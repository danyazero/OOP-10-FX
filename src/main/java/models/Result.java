package models;

public class Result {
    private double result;
    private long time;

    public Result(double result, long time){
        this.result = result;
        this.time = time;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
