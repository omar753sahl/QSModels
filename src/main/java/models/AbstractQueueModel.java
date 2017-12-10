package models;

public abstract class AbstractQueueModel {
    protected double arrivalRate;
    protected double serviceRate;

    public AbstractQueueModel(double arrivalRate, double serviceRate) {
        this.arrivalRate = arrivalRate;
        this.serviceRate = serviceRate;
        calculatePerformanceMetrics();
    }

    public abstract void calculatePerformanceMetrics();

    public abstract double getL();

    public abstract double getLq();

    public abstract double getW();

    public abstract double getWq();
}
