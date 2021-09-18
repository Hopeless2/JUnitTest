import java.util.function.*;

public class Calculator {
    static protected Supplier<Calculator> instance = Calculator::new;
    static protected BinaryOperator<Double> plus = (x, y) -> x + y;
    static protected BinaryOperator<Double> minus = (x, y) -> x - y;
    static protected BinaryOperator<Double> multiply = (x, y) -> x * y;
    static protected BinaryOperator<Double> devide = (x, y) -> {
        if(y == 0){
            System.out.println("На ноль делить нельзя!");
            return y;
        }else{
            return (x / y);
        }
    };
    static protected UnaryOperator<Double> pow = x -> x * x;
    static protected UnaryOperator<Double> abs = x -> x > 0 ? x : x * -1;
    static protected Predicate<Double> isPositive = x -> x > 0;
    static protected Consumer<Double> println = System.out::println;
}
