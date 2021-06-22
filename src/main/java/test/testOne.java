package test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class testOne {

	public static void main(String[] args) {

		List<Integer> lstint = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = 0;

		sum = lstint.stream().distinct().filter(i -> i % 3 == 0).collect(Collectors.summingInt(Integer::intValue));

		List<String> list = Arrays.asList("sdfg", "for", "vfbgdf", "GFG");

		// Using Stream findFirst()
		Optional<String> answer = list.stream().findFirst();
		
		//list.stream().map(emprepost::findbyUnit).

	

		sum = getSum(455);

		System.out.println(sum);

		System.out.println(answer);
		String str = new String("myname");
		str.toUpperCase();
		System.out.println(str);

	}

	static int getSum(int n) {
		int sum = 0;

		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}

		return sum;
	}

}