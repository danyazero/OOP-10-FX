package BLL;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class Function {
    private double start;
    private double end;
    private int nSteps;

    private double step;
    private DoubleUnaryOperator f;

    public Function(double start, double end, int nSteps, DoubleUnaryOperator f) {
        this.start = start;
        this.end = end;
        this.nSteps = nSteps;
        this.f = f;
        step = (end - start) / nSteps;
    }

    public double calculate() {
        double division = (f.applyAsDouble(start) + f.applyAsDouble(end)/2) * step;
        double sum = IntStream.range(1, nSteps).mapToDouble(i -> start + i * step).map(f).map(y -> y * step).sum();

        return division + sum;
    }
}
