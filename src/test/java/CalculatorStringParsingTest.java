import model.Model;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorStringParsingTest {

    private static Model calculator = new Model();

    @Test
    public void testAddition() {
        assertThat(calculator.calculate("1 + 1"), is(2.0));
        assertThat(calculator.calculate("1+1+1"), is(3.0));
        assertThat(calculator.calculate("12 + 13"), is(25.0));
        assertThat(calculator.calculate("999 + 1001"), is(2000.0));
    }

    @Test
    public void testSubtraction() {
        assertThat(calculator.calculate("1-1"), is(0.0));
        assertThat(calculator.calculate("1 - 1"), is(0.0));
        assertThat(calculator.calculate("12 - 13"), is(-1.0));
        assertThat(calculator.calculate("999 - 1001"), is(-2.0));
    }

    @Test
    public void testDivision() {
        assertThat(calculator.calculate("1/1"), is(1.0));
        assertThat(calculator.calculate("1 / 1"), is(1.0));
        assertThat(calculator.calculate("12 / 0"), is(Double.POSITIVE_INFINITY));
        assertThat(calculator.calculate("999 / 0"), is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testMultiplication() {
        assertThat(calculator.calculate("1*1*12"), is(12.0));
        assertThat(calculator.calculate("1 * 1"), is(1.0));
        assertThat(calculator.calculate("12 * 13"), is(156.0));
        assertThat(calculator.calculate("999 * 1001"), is(999999.0));
    }

    @Test
    public void testComplexCalculation() {
        assertThat(calculator.calculate("1*1*12/2"), is(6.0));
        assertThat(calculator.calculate("(1+1)*12/2"), is(12.0));
        assertThat(calculator.calculate("123+13*(99+98)-987+654*2- (12*(33/(324-320)))"),
                                     is(2906.0));
    }

}