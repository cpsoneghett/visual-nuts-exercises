package com.visualnuts.exercises;

import com.visualnuts.exercises.list.Exercise2;

import com.visualnuts.exercises.list.Exercise1;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {

	public static void main( String[] args ) throws IOException {

		System.out.println("::: Exercise 1 :::");
		// Run first exercise.
		Exercise1.printNumber(100);

		System.out.println("\n");
		System.out.println("::: Exercise 2 :::");
		//Run second exercise.
		Exercise2 exercise2 = new Exercise2();
		exercise2.run();
	}
}
