package BLL;

import models.Result;

public class CalculatorLogic implements ICalculator{

    public Result calculateIntegral(int intervals, int threads) {
        double a = 0;
        double b = Math.PI/3;
        int n = intervals;

        int nThreads = threads;
        double delta = (b - a) / nThreads;
        totalResult = 0;
        finished = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            IntegralCalculator calculator = new IntegralCalculator(a + i * delta,
                    a + i * delta + delta,
                    n / nThreads, t -> Math.cos(4*t)*Math.cos(2*t), this);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < nThreads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
        long finishTime = System.currentTimeMillis();
        return new Result(totalResult, finishTime - startTime);
    }

    public synchronized void send(double v) {
        totalResult += v;
        finished++;
        notify();
    }

    private double totalResult;
    private int finished;
}
