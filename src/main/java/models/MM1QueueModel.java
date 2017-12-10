package models;

public class MM1QueueModel extends AbstractQueueModel {

    public MM1QueueModel(double arrivalRate, double serviceRate) {
        super(arrivalRate, serviceRate);
    }

    @Override
    public void calculatePerformanceMetrics() {

    }

    @Override
    public double getL() {
        return 0;
    }

    @Override
    public double getLq() {
        return 0;
    }

    @Override
    public double getW() {
        return 0;
    }

    @Override
    public double getWq() {
        return 0;
    }
}
