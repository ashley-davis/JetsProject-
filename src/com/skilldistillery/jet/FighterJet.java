package com.skilldistillery.jet;

public class FighterJet extends Jet implements CombatReady{
	public FighterJet() {
		super();
	}
	public FighterJet(String mod, double ran, double sp, double pr) {
		super(mod, ran, sp, pr);
	}
	@Override
	public void fight() {
		System.out.println("Fighter Jet: " +this.model+ ". " + "Ready to fight. ");
	}
}
