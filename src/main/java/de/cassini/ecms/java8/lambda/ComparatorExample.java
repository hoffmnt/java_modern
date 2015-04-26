package de.cassini.ecms.java8.lambda;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.cassini.ecms.java8.needed.Delivery;
import de.cassini.ecms.java8.needed.Person;

public class ComparatorExample {

	public static void main(String[] args) {
		
		sortPeopleByName();
		sortPeopleByBirthday();
	}
	
	private static void sortPeopleByName() {
		
		List<Person> people = Delivery.getPeopleAsList();
		
		// old style
		System.out.printf("%n=== classic code ===");
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getNachname().compareTo(o2.getNachname());
			}
			
		});
		
		for (Person person : people) {
			System.out.println(person);
		}
		
		// lambda style
		System.out.println("\n=== lambda style (first name) ===");
		Collections.sort(people, (p1, p2) -> p1.getVorname().compareTo(p2.getVorname()));
		people.forEach(System.out::println);
		
	}

	private static void sortPeopleByBirthday() {
		
		System.out.printf("%n=== people sorted by age ===%n");
		List<Person> people = Delivery.getPeopleAsList();
		Collections.sort(people, (p1, p2) -> p1.getGeburtstag().compareTo(p2.getGeburtstag()));
		people.forEach(System.out::println);
		
		System.out.printf("%n=== people sorted by brithday in a given year ===%n");
		Collections.sort(people, 
			(p1, p2)-> MonthDay.from(p1.getGeburtstag()).compareTo(MonthDay.from(p2.getGeburtstag()))
		);
		DateTimeFormatter _f = DateTimeFormatter.ofPattern("dd.MM.");
		people.forEach(p->System.out.printf("%s, %s%n", _f.format(p.getGeburtstag()) , p.getVorname()));
	}
	
}
