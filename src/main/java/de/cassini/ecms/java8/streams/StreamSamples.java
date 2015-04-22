package de.cassini.ecms.java8.streams;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author nhn
 *
 */
public class StreamSamples {

    Random random = new Random();

	public static void main(String[] args) {
		
		StreamSamples me = new StreamSamples();
		
		me.funWithIntStreams();
	}

	/**
	 * 
	 */
	private void funWithIntStreams() {

		printSeparator();
		System.out.printf("See how many even numbers get generated.%n");
		
		List<Integer> ints = makeRandomInts(200);
		
		long evenNumbers = ints.stream()		// get the stream - lazy
				.mapToInt(Integer::intValue)	// make it a special int stream, method reference - lazy
				.filter(i -> i%2==0)			// filter it - lazy
				.count();						// get the values - terminal
		
		System.out.printf("We got %s even numbers this time.%n%n", evenNumbers);
		
		// Define stream for later use - remember, this is still lazy!
		IntStream intStream = ints.stream().mapToInt(Integer::intValue);
		
		// no need of a Comparator for max here as we have a special IntStream
		System.out.printf("This is the max int: %s%n", intStream.max());
		
		
		// numeric streams have a nice statistics method
		// don't know about performance, though
		// cannot reuse intStream here as it is already closed
		// parallel streams use the Java7 concurrency, namely fork/join
		// not of really use here, just for illustration
		IntSummaryStatistics stats = ints.parallelStream()
				.mapToInt(Integer::intValue)
				.summaryStatistics();
		
        System.out.printf("Highest number in List: %s%n", stats.getMax());
        System.out.printf("Lowest number in List: %s%n", stats.getMin());
        System.out.printf("Sum of all numbers: %s%n", stats.getSum());
        System.out.printf("Average of all numbers: %s%n", stats.getAverage());
	}

	/**
	 * @param listSize
	 * @return
	 */
	private List<Integer> makeRandomInts(int listSize) {
        List<Integer> list = new ArrayList<>(listSize);

        for(int c = 0 ; c <= listSize ; c++) {
        	list.add(random.nextInt(2_000_000));
        }
        
        return list;
	}
	
	/**
	 * 
	 */
	private void printSeparator() {
		System.out.printf("------------------------%n");
	}
	
	
	
}
