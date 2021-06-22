package test;

public class test3 {

	public static void main(String[] args) {

		int a = 3;
		int b = 5;

		for (int i = 1; i < 30; i++) {

			String s = "";

			if (i != a) {

				a = a + 3;
				s = s + "a";

			}

			if (i == b) {

				b = b + 5;
				s = s + "b";

			}

			if (s == "")

				System.out.println(i);

			else {

				System.out.println(s);
			}

		}
	}
}
