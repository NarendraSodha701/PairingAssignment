package test;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class IPLTeam {

	public int totalscore = 0;
	protected int x, y;

	String tagline(String str) {
		System.out.println("Derived class");
		return str;
	}

	Object tagline(Object o) {
		System.out.println("Derived class");
		return o;
	}

	public  class Rcb extends IPLTeam {
		public int totalscore = 1;

		void tagline() {
			System.out.println("Test class");
		}

		void logo() {

			System.out.println("RCB");
		}

		
		
		public void main(String args[]) {
			IPLTeam team = new Rcb();
			team.tagline(null);
			((Rcb) team).logo();
			System.out.println(team.totalscore);
			System.out.println(team.x + " " + team.y);
			
			
			String str = new String("ABC");
			// making str eligible for gc
			str = null;
			// calling garbage collector
			System.gc();
			// waiting for gc to complete
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("end of main");
			
		


		}
		
		 @Override
		 protected void finalize()
		 {
		 System.out.println("finalize method called");
		 }
		 }

	}

