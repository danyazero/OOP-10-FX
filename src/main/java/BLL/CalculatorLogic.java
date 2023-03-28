package BLL;

import models.Result;

public class CalculatorLogic implements ICalculator{

    public Result calculateIntegral(int intervals, int threads) {
        double a = 0;
        double b = Math.PI/3;

        double delta = (b - a) / threads;
        totalResult = 0;
        finished = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            IntegralCalculator calculator = new IntegralCalculator(a + i * delta,
                    a + i * delta + delta,
                    intervals / threads, t -> Math.cos(4*t)*Math.cos(2*t), this);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < threads) {
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
