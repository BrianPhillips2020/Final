package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.RateException;

public class rate_test {


	
	@Test
	public void RateExceptiontest() throws RateException{
		assert rocketBase.RateBLL.getRate(800) == 5.5;
	}
	
	public ExpectedException ex = ExpectedException.none();
	@Test
	public void RateExceptiontest2() throws RateException{
		ex.expect(RateException.class);
		rocketBase.RateBLL.getRate(4);
	}
	
}
