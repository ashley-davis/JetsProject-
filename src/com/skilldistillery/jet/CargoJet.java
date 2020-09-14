package com.skilldistillery.jet;

public class CargoJet extends Jet implements CargoCarrier  {
	
	public CargoJet() {
	super();
	}
	public CargoJet(String mod, double ran, double sp, double pr) {
		super(mod, ran, sp, pr);
	}
	@Override
	public void loadCargo() {
		System.out.println("Cargo Jet" + this.model + "Ready to Load Cargo.");
	}
}
