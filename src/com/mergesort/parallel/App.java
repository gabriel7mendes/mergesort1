package com.mergesort.parallel;

import java.util.Random;

public class App {
	
	private static Random random = new Random();
	
	public static void main(String[] args) {
		
		int numberOfThreads = Runtime.getRuntime().availableProcessors();
		
		System.out.println("Number of threads/cores: " + numberOfThreads);
		System.out.println();
		
		int[] numbers1 = createRandomArray();
		int[] numbers2 = new int[numbers1.length];
		
		for(int i=0; i<numbers1.length;i++) 
			numbers2[i] = numbers1[i];
			
		Mergesort parallelSorter = new Mergesort(numbers1);
		
		long startTime = System.currentTimeMillis();
		parallelSorter.parallelMergeSort(0, numbers1.length - 1, numberOfThreads);
		//parallelSorter.showResult();
		long endTime = System.currentTimeMillis();
		
		System.out.println();
		System.out.printf("Time taken for 10 000 000 elements parallel: %d", endTime - startTime);
		
		Mergesort sequentialSorted = new Mergesort(numbers2);
		
		startTime = System.currentTimeMillis();
		sequentialSorted.mergeSort(0, numbers2.length - 1);
		//sequentialSorted.showResult();
		endTime = System.currentTimeMillis();
		
		System.out.println();
		System.out.printf("Time taken for 10 000 000 elements sequential: %d", endTime - startTime);		
	}
	
	public static int[] createRandomArray() {
		int[] a = new int[10000000];
		for(int i = 0; i < 10000000; i++) {
			a[i] = random.nextInt(10000000);
		}
		return a;
	}
 
}
