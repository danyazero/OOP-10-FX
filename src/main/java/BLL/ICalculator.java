package BLL;

import models.Result;

public interface ICalculator {
    public Result calculateIntegral(int intervals, int threads);
}
