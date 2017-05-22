package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	RateDomainModel r;
	

	public RateException(RateDomainModel rate) {
		super();
		this.r = rate;
		
	}

	public RateDomainModel getRates() {
		return r;
		
	}
	

	

}
