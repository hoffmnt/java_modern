package de.cassini.ecms.java8.interfaceStuff;

import java.util.Collections;
import java.util.List;

public class Implementor implements AFace, BFace 
{
	// use a default implementation
	public void doTheStuff() {
		AFace.super.doTheStuff();
	}
	
    public List<String> listMe() {
    	
        // useful things
    	return Collections.emptyList();
    }

}
