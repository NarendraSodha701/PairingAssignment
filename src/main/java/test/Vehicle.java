package test;

public class Vehicle {

	void run() {
		System.out.println("Vehicle is running");
	}


// Creating a child class
 public static class Bike extends Vehicle {
	void run() {
		System.out.println("Bike is running");
	}
	

	public static void main(String args[]) {
		// creating an instance of child class
		Bike obj = new Bike();
		// calling the method with child class instance
		obj.run();
		Vehicle v = new Bike();
		v.run();
	}
}
}