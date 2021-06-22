package test;

public  class Derived {
	

	public void getDetails(String a)
	{
	System.out.println("Derived class"+a);
	}
	}

	 class Test extends Derived
	{
	
	public  void getDetails(String a)
	{
	System.out.println("Test class"+a);
	}
	public static void main(String[] args)
	{
	new Test();
	//obj.getDetails();
	Derived d = new Derived();
	d.getDetails(null);

}
}