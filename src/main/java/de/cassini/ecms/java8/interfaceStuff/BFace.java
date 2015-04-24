package de.cassini.ecms.java8.interfaceStuff;

public interface BFace {

	default void doTheStuff() {
		System.out.printf("default doTheStuff from BFace.");
	}
}
