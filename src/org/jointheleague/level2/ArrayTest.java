package org.jointheleague.level2;

public class ArrayTest {
	public static void main(String[] args) {
		System.out.println("Names Test");
		System.out.println("-");
		
		String[] names = new String[3];
		names[2] = "David";
		names[0] = "Esme";
		names[1] = "Isis";
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		System.out.println("");
		System.out.println("Numbers Test");
		System.out.println("-");
		
		int[] theFinalCountdown = new int[5];
		theFinalCountdown[0] = 1;
		theFinalCountdown[1] = 2;
		theFinalCountdown[2] = 3;
		theFinalCountdown[3] = 4;
		theFinalCountdown[4] = 5;
		for (int i = theFinalCountdown.length - 1; i >= 0; i--) {
			System.out.println(theFinalCountdown[i]);
		}
	}
}
