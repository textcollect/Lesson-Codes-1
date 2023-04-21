package ExceptionHandling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;

public class CalculatorTest {
	private final Calculator calculate = new Calculator();

	@Test //Denotes that a method is a test method
	void addition() {
		assertEquals(2, calculate.add(1, 1));
	}

	@Test
	void subtract() {
		assertEquals(3, calculate.subtract(5, 2));
	}

	@Test
	void division() {
		assertEquals(2, calculate.divide(10, 5));
		assertEquals(-1, calculate.divide(10, 0));
	}
}
