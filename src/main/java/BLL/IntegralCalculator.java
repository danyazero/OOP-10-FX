package BLL;

import java.util.function.DoubleUnaryOperator;

public class IntegralCalculator implements Runnable {

    private CalculatorLogic main;

    private Function calculator;

    public IntegralCalculator(double start, double end, int nSteps, DoubleUnaryOperator f, CalculatorLogic main) {
        calculator = new Function(start, end, nSteps, f);
        this.main = main;
    }

    @Override
    public void run() {
        double v = calculator.calculate();
        main.send(v);
    }
}
