package _003_variables;

public class Variables {
	public static void main(String[] args) {
		String name = "John";
		System.out.println(name);
		int myNum = 15;
		System.out.println(myNum);
		myNum = 20;
		System.out.println(myNum);
		final int myNum2 = 15;
		//myNum2 =20; will generate an error : cannot assign a value to a final variable
	}
}
