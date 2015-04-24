package de.cassini.ecms.java8.interfaceStuff;

public interface AFace {

	default void doTheStuff() {
		System.out.printf("default doTheStuff from AFace.");
	}
}
