package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;

public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();

	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");

		if (message instanceof LoanRequest) {
			resetOutput();

			LoanRequest lq = (LoanRequest) message;
			double periods = lq.getiTerm() * 12;
			double rate = lq.getdRate() / 1200;
			double p = lq.getdAmount() - lq.getiDownPayment();
			lq.setdRate(RateBLL.getPayment(rate, periods, p, 0, false));

			sendToAll(lq);
		}
	}
}
