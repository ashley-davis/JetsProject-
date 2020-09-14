package com.skilldistillery.jet;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected double range;
	protected double price;

	public Jet() {
		this.model=null;
		this.range=0;
		this.speed=0;
		this.price=0;
		}
	public Jet(String mod, double ran, double sp, double pr) {
		this.model=mod;
		this.range=ran;
		this.speed=sp;
		this.price=pr;
		}

	public void setModel(String mod) {
		this.model=mod;
		}
	public void setRange(double ran) {
		this.range=ran;
		}
	public void setSpeed(double sp) {
		this.speed=sp;
		}
	public void setPrice(double pr) {
		this.price=pr;
		}
	public String getModel() {
		return this.model;
		}
	public double getRange() {
		return this.range;
		}
	public double getSpeed() {
		return this.speed;
		}
	public double getPrice() {
		return this.price;
		}

	public String toString() {
		return "Model: "+this.model+"; Speed: "+this.speed+"; Range: "+this.range+"; Price: "+this.price;	
		}
	public void fly() {
		System.out.println("\nModel: " + this.model + ", Speed: " + this.speed + ", Range: " + this.range + ", Price: " + this.price);		
		System.out.println("Range: " + this.range/this.speed + " hours");
		}
}
