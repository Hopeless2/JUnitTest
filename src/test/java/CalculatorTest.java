import org.junit.jupiter.api.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static long suiteStartTime;
    private long testStartTime;
    private static Calculator calc = Calculator.instance.get();

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running CalculatorTest");
        suiteStartTime = System.nanoTime();
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("CalculatorTest complete: " + (System.nanoTime() - suiteStartTime));
    }
    @BeforeEach
    public void initTest() {
        System.out.println("Starting new test");
        calc = Calculator.instance.get();
        testStartTime = System.nanoTime();
    }
    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
        calc = null;
    }

    @Test
    public void plusTest_success(){
            //given:
        final double a = 3.0;
        final double b = 4.0;
        final double expected = 7.0;
            //when:
        double result = calc.plus.apply(a, b);
            //then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void plusTest_emptyArgument_success(){
            //given:
        final double a = 3.0;
        final double b = 0.0;
            //when:
        double result = calc.plus.apply(a, b);
            //then:
        Assertions.assertEquals(a, result);
    }

    @Test
    public void plusTest_nullArgument_throwsException(){
            //given:
        final double a = 3.0;
            //expect
        assertThrows(NullPointerException.class, () -> calc.plus.apply(a, null));
    }

    @Test
    public void devideTest_success(){
            //given::
        final double a = 7.0;
        final double b = 2.0;
        final double expected = 3.5;
            //when::
        double result = calc.devide.apply(a, b);
            //then::
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void devideTest_emptyArgument_getMessage(){
            //given::
        final double a = 7.0;
        final double b = 0.0;
            //when::
        double result = calc.devide.apply(a, b);
            //then::
        Assertions.assertEquals(b, result);
    }

    @Test
    public void devideTest_nullArgument_throwsException(){
            //given::
        final double a = 7.0;
            //expect::
        assertThrows(NullPointerException.class, () -> calc.devide.apply(a, null));


    }


}
