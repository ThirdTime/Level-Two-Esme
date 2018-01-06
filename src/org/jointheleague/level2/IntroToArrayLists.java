package org.jointheleague.level2;

import java.util.ArrayList;

public class IntroToArrayLists {

	public static void main(String[] args) {
		ArrayList<String> monthsOfYear = new ArrayList<>();
		monthsOfYear.add("January");
		monthsOfYear.add("February");
		monthsOfYear.add("March");
		monthsOfYear.add("April");
		monthsOfYear.add("May");
		monthsOfYear.add("June");
		monthsOfYear.add("July");
		monthsOfYear.add("August");
		monthsOfYear.add("September");
		monthsOfYear.add("October");
		monthsOfYear.add("November");
		monthsOfYear.add("December");
		
		//for loop which prints the months
		/**for (int i = 0; i < monthsOfYear.size(); i++) {
			int iPlusOne = i+1;
				System.out.println("Month number " + iPlusOne + " is called " + monthsOfYear.get(i));
		}
		*/
		
		//for loop which prints only the even months
		/**for (int i = 1; i < monthsOfYear.size(); i++) {
			int startAtOneMonthNumber = i + 1;
			if (startAtOneMonthNumber % 2 == 0) {
				System.out.println("Month number " + startAtOneMonthNumber + " is called " + monthsOfYear.get(i));
			}
		}
		*/
		
		//for loop which prints the months... backwards.
		/**for(int i = monthsOfYear.size() - 1; i >= 0; i = i-1) {
			System.out.println(monthsOfYear.get(i));
		}
		*/
		
		//for loop which prints out all the months whose names contain the letter "e"
		/**for(int i = 1; i < monthsOfYear.size(); i++) {
			if(monthsOfYear.get(i).contains("e")) {
				System.out.println(monthsOfYear.get(i));
			}
		}
		*/
		
		//enhanced for loop!
		for(String insertACoolVariableNameHere : monthsOfYear) {
			System.out.println(insertACoolVariableNameHere);
		}
		
	}

}
