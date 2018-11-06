import model.Model;
import model.UnknownOperatorException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CalculatorStringParsingTest {

    private static Model calculator = new Model();
    private int first = 1;
    private int second = 2;

    //TODO: Floating-point improve
    @Test
    public void testAddition() {
        assertThat(calculator.calculate("1 + 1"), is(2));
        assertThat(calculator.calculate("1+1+1"), is(3));
        assertThat(calculator.calculate("12 + 13"), is(25));
        assertThat(calculator.calculate("999 + 1001"), is(2000));
    }

    @Test
    public void testSubtraction() {
        assertThat(calculator.calculate("1-1"), is(0));
        assertThat(calculator.calculate("1 - 1"), is(0));
        assertThat(calculator.calculate("12 - 13"), is(-1));
        assertThat(calculator.calculate("999 - 1001"), is(-2));
    }

    @Test
    public void testDivision() {
        assertThat(calculator.calculate("1/1"), is(1));
        assertThat(calculator.calculate("1 / 1"), is(1));
        try {
            assertThat(calculator.calculate("12 / 0"), is(1));
            assertThat(calculator.calculate("999 / 0"), is(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals(e.getClass(), ArithmeticException.class);
        }
    }

    @Test
    public void testMultiplication() {
        assertThat(calculator.calculate("1*1*12"), is(12));
        assertThat(calculator.calculate("1 * 1"), is(1));
        assertThat(calculator.calculate("12 * 13"), is(156));
        assertThat(calculator.calculate("999 * 1001"), is(999999));
    }

    @Test
    public void testComplexCalculation() {
        assertThat(calculator.calculate("1*1*12/2"), is(6));
        assertThat(calculator.calculate("(1+1)*12/2"), is(12));
    }

}