package de.cassini.ecms.java8.lambda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author cassini
 *
 */
public class ListenerExample {

	public static void main(String[] args) {
		
		JButton classicButton = new JButton("Da classic style button.");
		
		classicButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.printf("clicked by anonymous class%n");
				
			}
		});
		
		JButton lambdaButton = new JButton("Lambda style");
		lambdaButton.addActionListener(e -> System.out.printf("lambda style click%n"));
		
		JFrame frame = new JFrame("Lambda example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(classicButton, BorderLayout.NORTH);
		frame.add(lambdaButton, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
