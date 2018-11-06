import model.Model;
import model.UnknownOperatorException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorOperatorsTest {

    private static Model calculator = new Model();
    private double first = 1d;
    private double second = 2d;

    @Test
    public void testAddition() {
        assertThat(calculator.add(first, second), is(3.0));
        assertThat(calculator.add(-1.0, 1.0), is(0.0));
        assertThat(calculator.add(0.0, 0.0), is(0.0));
        assertThat(calculator.add(15.0, 0.0), is(15.0));
    }

    @Test
    public void testSubtraction() {
        assertThat(calculator.subtract(first, second), is(-1.0));
        assertThat(calculator.subtract(-1.0, 1.0), is(-2.0));
        assertThat(calculator.subtract(0.0, 0.0), is(0.0));
        assertThat(calculator.subtract(15.0, 0.0), is(15.0));
    }

    @Test
    public void testDivision() {
        assertThat(calculator.divide(first, second), is(0.5));
        assertThat(calculator.divide(-1.0, 1.0), is(-1.0));
        assertThat(calculator.divide(0.0, 0.0), is(Double.NaN));
        assertThat(calculator.divide(15.0, 0.0), is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testMultiplication() {
        assertThat(calculator.multiple(first, second), is(2.0));
        assertThat(calculator.multiple(-1.0, 1.0), is(-1.0));
        assertThat(calculator.multiple(0.0, 0.0), is(0.0));
        assertThat(calculator.multiple(15.0, 0.0), is(0.0));
    }

    @Test
    public void testCalculateAddition() {
        assertThat(calculator.calculate(first, second, "+"), is(3.0));
        assertThat(calculator.calculate(-1.0, 1.0, "+"), is(0.0));
        assertThat(calculator.calculate(0.0, 0.0, "+"), is(0.0));
        assertThat(calculator.calculate(15.0, 0.0, "+"), is(15.0));
    }

    @Test
    public void testCalculateSubtraction() {
        assertThat(calculator.calculate(first, second, "-"), is(-1.0));
        assertThat(calculator.calculate(-1.0, 1.0, "-"), is(-2.0));
        assertThat(calculator.calculate(0.0, 0.0, "-"), is(0.0));
        assertThat(calculator.calculate(15.0, 0.0, "-"), is(15.0));
    }

    @Test
    public void testCalculateDivision() {
        assertThat(calculator.calculate(first, second, "/"), is(0.5));
        assertThat(calculator.calculate(-1.0, 1.0, "/"), is(-1.0));
        assertThat(calculator.calculate(0.0, 0.0, "/"), is(Double.NaN));
        assertThat(calculator.calculate(15.0, 0.0, "/"), is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testCalculateMultiplication() {
        assertThat(calculator.calculate(first, second, "*"), is(2.0));
        assertThat(calculator.calculate(-1.0, 1.0, "*"), is(-1.0));
        assertThat(calculator.calculate(0.0, 0.0, "*"), is(0.0));
        assertThat(calculator.calculate(15.0, 0.0, "*"), is(0.0));
    }

    @Test(expected = UnknownOperatorException.class)
    public void testCalculateUnknownOperator() {
        calculator.calculate(1.0, 2.0, "%");
    }

}