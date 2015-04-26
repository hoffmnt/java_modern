package de.cassini.ecms.java8.needed;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Delivery {

	private static Person [] personArray = {
		new Person("Claudia", "Schiffer", LocalDate.of(1970, 8, 20), Person.Gender.FEMALE),
		new Person("Heidi", "Klum", LocalDate.of(1973, 6, 1), Person.Gender.FEMALE),
		new Person("Robert", "Redford", LocalDate.of(1936, 8, 18), Person.Gender.MALE),
		new Person("Shia", "LaBoef", LocalDate.of(1986, 6, 11), Person.Gender.MALE),
		new Person("Megan", "Fox", LocalDate.of(1986, 6, 18), Person.Gender.FEMALE),
		new Person("Johnny", "Depp", LocalDate.of(1963, 6, 9), Person.Gender.MALE),
		new Person("Colin", "Farrell", LocalDate.of(1976, 5, 31), Person.Gender.MALE),
		new Person("Evangeline", "Lilly", LocalDate.of(1979, 8, 3), Person.Gender.FEMALE),
		new Person("Martin", "Freeman", LocalDate.of(1971, 9, 8), Person.Gender.MALE),
		new Person("Benedict", "Cumberbatch", LocalDate.of(1976, 7, 19), Person.Gender.MALE),
		new Person("Ian", "McKellen", LocalDate.of(1939, 5, 25), Person.Gender.MALE),
	};

	private Delivery() {}
	
	public static List<Person> getPeopleAsList() {
		
		return Arrays.asList(personArray);
	}
}
