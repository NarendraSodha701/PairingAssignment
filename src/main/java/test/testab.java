package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class testab {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		List<Emp> list = new ArrayList<>();
		list.add(new Emp(1, "XYZ"));
		list.add(new Emp(3, "Shubham"));
		list.add(new Emp(2, "Pavitra"));
		
	

	

	}

}

class Emp {
	int id;
	String name;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
}
