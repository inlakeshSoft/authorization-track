package org.exam.task1;

import java.util.List;

import org.exam.task1.interfaces.FunctionalOperation;

/**
 * Task1
 * Given an integer N, write a function that allows printing the sum of all of
 * the numbers presented in a list.Your code must be valid even if the
 * functional interface is omitted.Validate that your solution compiles.
 * 
 * @author Feliipe Perez
 *
 */
public class Task1 {

	public static void printSum(List<Integer> list) {
		FunctionalOperation sum = (a, b) -> a + b;
		System.out.println(list.stream().reduce(0, sum::operation).intValue());
	}

}
