package de.cassini.ecms.java8.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import de.cassini.ecms.java8.needed.Delivery;
import de.cassini.ecms.java8.needed.Person;

public class DateTimeExamples {

	public static void main(String[] args) {
		
		dateOnlyStuff();
		
		birthdayStuff();
		
		timeStuff();
		
		yearMonthStuff();
		
	}

	private static void yearMonthStuff() {

		YearMonth currentYearMonth = YearMonth.now(); 
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
		
		YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry); 

	}

	private static void dateOnlyStuff() {
		
		// Heute 
		LocalDate today = LocalDate.now(); 
		System.out.printf("Heute: %s%n%n", today);

		// Auf Jahr, Monat, Tag zugreifen
		int day = today.getDayOfMonth();
		int month = today.getMonthValue();
		Month monthname = today.getMonth();
		int year = today.getYear();
		
		System.out.printf("Tag %s, Monat %s (%s), Jahr %s%n%n",
			day, month, monthname, year
		);
		
		// Datum setzen
		LocalDate gruendung = LocalDate.of(2006, 7, 1);
		System.out.printf("Gründungstag: %s%n%n", gruendung);
		
		// So war's früher
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2006);
		cal.set(Calendar.MONTH, 6); // yeah, 0-based month field
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		Date oldGruendung = cal.getTime();
		
		// zwischen alt und neu wechseln
		// das ist alles andere als kanonisch, what the heck
		LocalDate newGruendung = Instant.ofEpochMilli(oldGruendung.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		
		// Sind sie gleich? Equals geht ...
		System.out.printf("gruendung.equals(newGruendung) ist %s%n", gruendung.equals(newGruendung));
		
		// Jahre später
		System.out.printf("Sieben Jahre später: %s.%n", gruendung.plus(7, ChronoUnit.YEARS));
		
	}

	private static void birthdayStuff() {
		
		LocalDate holger = LocalDate.of(1945, 5,  25);
		
		List<Person> celebrities = Delivery.getPeopleAsList();
		
		// gibt es einen Prominenten aus der Liste, der am gleichen Tag
		// Geburtstag hat wie mein Vater? (Das Jahr ist irrelevant.)
		
		System.out.printf("%nWer hat am selben Tag Geburtstag wie Holger Hoffmann (%s.%s.)?%n", 
				holger.getMonth(), holger.getDayOfMonth()
		);
		celebrities.stream()
			.filter(p->MonthDay.from(holger).equals(MonthDay.from(p.getGeburtstag())))
			.forEach(celeb -> System.out.println(celeb)
		);
	
	}
	
	private static void timeStuff() {
		
		LocalTime now = LocalTime.now();
		LocalTime nyTime = LocalTime.now(ZoneId.of("America/New_York"));
		
		System.out.printf("%nJetzt: %s, und in New York: %s.%n", now, nyTime);
		int stunde = 2;
		System.out.printf("In %s Stunden ist es %s.%n", stunde, now.plusHours(stunde));
		
		
	}


}
