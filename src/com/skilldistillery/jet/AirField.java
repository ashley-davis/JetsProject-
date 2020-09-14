package com.skilldistillery.jet;

import java.util.ArrayList;


public class AirField {
	private ArrayList<Jet> listOfJets;
	public ArrayList<Jet> getListOfJets() {
		return this.listOfJets;
	}
	public AirField() {
		this.listOfJets = new ArrayList<Jet>();
	}
	public AirField(ArrayList<Jet> list) {
		this.listOfJets = list;
	}
}
