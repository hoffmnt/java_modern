package de.cassini.ecms.java8.needed;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

	private DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	public enum Gender {
		FEMALE("weiblich"),
		MALE("männlich");
		
		private String text;

		Gender(String text) {
			this.text = text;
		}
		
		@Override
		public String toString() {
			return text;
		}
		
		
	}
	
	String vorname;
	String nachname;
	Gender geschlect;
	LocalDate geburstag;
	
	public Person(String vorname, String nachname, LocalDate geburtstag, Gender geschlecht) {
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburstag = geburtstag;
		this.geschlect = geschlecht;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s, *%s, %s", 
				getVorname(), getNachname(), 
				f.format(getGeburtstag()), getGeschlect());
	}
	
	public String getVorname() {
		return vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public Gender getGeschlect() {
		return geschlect;
	}
	public LocalDate getGeburtstag() {
		return geburstag;
	}
	
}

