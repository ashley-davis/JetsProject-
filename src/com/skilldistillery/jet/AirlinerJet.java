package com.skilldistillery.jet;

public class AirlinerJet extends Jet implements CargoCarrier{
	public AirlinerJet() {
		super();
	}
	public AirlinerJet(String mod, double ran, double sp, double pr) {
		super(mod, ran, sp, pr);
	}

	@Override
	public void loadCargo() {
		System.out.println("Model: "+ this.model + " . " + "Ready to transport passengers and small cargo. ");
	}

}
