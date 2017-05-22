package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		
	
		try{ 
			ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
			int i = 0;
			while(rates.get(i).getiMinCreditScore() != GivenCreditScore){
				i++;
			}
		
			dInterestRate = rates.get(i).getdInterestRate();
			
			if (dInterestRate == 0){
				throw new RateException(rates.get(i));
			}
			
		} catch(RateException r){
			System.out.println("An error occured: "  + r);
		}
		
		return dInterestRate;
		
			
		
		
		
	}
	
	

	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
