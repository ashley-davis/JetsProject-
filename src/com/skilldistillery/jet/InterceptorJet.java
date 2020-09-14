package com.skilldistillery.jet;

public class InterceptorJet extends Jet implements CombatReady{
	public InterceptorJet() {
		super();
	}
	public InterceptorJet(String mod, double ran, double sp, double pr) {
		super(mod, ran, sp, pr);
	}

	@Override
	public void fight() {
		System.out.println("Interceptor Jet " + this.model + "Ready to Intercept. ");	
	}
}
