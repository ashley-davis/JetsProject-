package com.skilldistillery.jet;

public class BomberJet extends Jet implements CombatReady {
	public BomberJet() {
		super();
	}
	public BomberJet(String mod, double ran, double sp, double pr) {
		super(mod, ran, sp, pr);
	}

	@Override
	public void fight() {
		System.out.println("Model: " + this.model + " . " + "Ready to bomb.");	
	}

}
