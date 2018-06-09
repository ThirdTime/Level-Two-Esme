package org.jointheleague.level2;

public class Shoop {

	private int numTails;

	private String name;

	public Shoop(String name, int numTails) {

		this.name = name;

		this.numTails = numTails;

	}

	public int getNumTails() {

		return numTails;

	}

	public String getName() {

		return name;

	}
	public boolean equals(Object object) {

		if(object==null) {

			return false;

		}

		if(object.getClass()!= this.getClass()) {

			return false;

		}

		Shoop otherShoop= (Shoop) object;

		return numTails== otherShoop.getNumTails() && name.equals(otherShoop.name); 

	}



}
