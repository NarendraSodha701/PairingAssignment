package test;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Employee,Integer> map = new HashMap<Employee,Integer>();

        Employee e1 = new Employee("Sachin",10);
        Employee e2 = new Employee("Sachin",10);

        map.put(e1, 1);
        map.put(e2,2);

        System.out.println(e1.hashCode()+"    "+e2.hashCode());

        System.out.println(map);

        e2.setName("Akshay"); //<---- changing the name for e2

        Employee e3 = new Employee("Sachin",10);        
        map.put(e3, 3);

        System.out.println(map);
    }
}

