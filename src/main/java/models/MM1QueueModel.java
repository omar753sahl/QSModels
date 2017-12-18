package models;

public class MM1QueueModel extends QueueModel{

    @Override
    protected PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput input) throws QueueModelException {

        double lambda = input.getArrivalRate();
        double mue = input.getServiceRate();

        double L = lambda / (mue - lambda);
        double Lq = L * lambda / mue;

        double W = 1 / (mue - lambda);
        double Wq = W * lambda / mue;

        return new PerformanceMetrics(L, Lq, W, Wq);
    }
}
