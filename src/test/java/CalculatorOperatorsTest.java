import model.Model;
import model.UnknownOperatorException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorOperatorsTest {

    private static Model calculator = new Model();
    private int first = 1;
    private int second = 2;

    @Test
    public void testAddition() {
        assertThat(calculator.add(first, second), is(3));
        assertThat(calculator.add(-1, 1), is(0));
        assertThat(calculator.add(0, 0), is(0));
        assertThat(calculator.add(15, 0), is(15));
    }

    @Test
    public void testSubtraction() {
        assertThat(calculator.sub(first, second), is(-1));
        assertThat(calculator.sub(-1, 1), is(-2));
        assertThat(calculator.sub(0, 0), is(0));
        assertThat(calculator.sub(15, 0), is(15));
    }

    @Test
    public void testDivision() {
        assertThat(calculator.div(first, second), is(0));
        assertThat(calculator.div(-1, 1), is(-1));
        try {
            assertThat(calculator.div(0, 0), is(0));
            assertThat(calculator.div(15, 0), is(15));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals(e.getClass(), ArithmeticException.class);
        }
    }

    @Test
    public void testMultiplication() {
        assertThat(calculator.mult(first, second), is(2));
        assertThat(calculator.mult(-1, 1), is(-1));
        assertThat(calculator.mult(0, 0), is(0));
        assertThat(calculator.mult(15, 0), is(0));
    }

    @Test
    public void testClearWhitespaces() {
        String input = "1 + 1";
        String result = calculator.clearWhitespaces(input);
        assertThat(result, is("1+1"));

    }

    @Test
    public void testCalculateAddition() {
        assertThat(calculator.calculate(first, second, "+"), is(3));
        assertThat(calculator.calculate(-1, 1, "+"), is(0));
        assertThat(calculator.calculate(0, 0, "+"), is(0));
        assertThat(calculator.calculate(15, 0, "+"), is(15));
    }

    @Test
    public void testCalculateSubtraction() {
        assertThat(calculator.calculate(first, second, "-"), is(-1));
        assertThat(calculator.calculate(-1, 1, "-"), is(-2));
        assertThat(calculator.calculate(0, 0, "-"), is(0));
        assertThat(calculator.calculate(15, 0, "-"), is(15));
    }

    @Test
    public void testCalculateDivision() {
        assertThat(calculator.calculate(first, second, "/"), is(0));
        assertThat(calculator.calculate(-1, 1, "/"), is(-1));
        try {
            assertThat(calculator.calculate(0, 0, "/"), is(0));
            assertThat(calculator.calculate(15, 0, "/"), is(15));
        } catch (Exception e) {
            assertEquals(e.getClass(), ArithmeticException.class);
        }
    }

    @Test
    public void testCalculateMultiplication() {
        assertThat(calculator.calculate(first, second, "*"), is(2));
        assertThat(calculator.calculate(-1, 1, "*"), is(-1));
        assertThat(calculator.calculate(0, 0, "*"), is(0));
        assertThat(calculator.calculate(15, 0, "*"), is(0));
    }

    @Test(expected = UnknownOperatorException.class)
    public void testCalculateUnknownOperator() {
        calculator.calculate(1, 2, "%");
    }

}