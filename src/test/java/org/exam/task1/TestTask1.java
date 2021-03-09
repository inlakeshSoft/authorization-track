package org.exam.task1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing Task1
 * 
 * @author Felipe Perez
 *
 */

class TestTask1 {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	void test() {
		Task1.printSum(Arrays.asList(1, 2, 3));
		assertEquals("6", outputStreamCaptor.toString().trim());
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}

}
