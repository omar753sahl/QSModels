package models;

import utils.MathUtils;
import static java.lang.Math.*;

public class MMCQueueModel extends QueueModel {
    @Override
    protected PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput inputs) throws QueueModelException {
        double lambda = inputs.getArrivalRate();
        double mue = inputs.getServiceRate();
        double c = inputs.getNumberOfServers();
        double r = lambda / mue;

        MathUtils.prepareFact((int) (c + 1));

        double p0 = calculateP0(c, r);
        double Lq = calculateLq(lambda, mue, c, r, p0);

        double Wq = Lq / lambda;
        double W = Wq + (1 / mue);
        double L = Lq + r;

        return new PerformanceMetrics(L, Lq, W, Wq);
    }

    private double calculateLq(double lambda, double mue, double c, double r, double p0) {
        double numerator = pow(r, c) * lambda * mue;
        double denominator = MathUtils.fact((int) (c - 1)) * pow((c * mue) - lambda, 2);
        return (numerator / denominator) * p0;
    }

    private double calculateP0(double c, double r) {
        double firstTerm = 0;
        double secondTerm = ((c * pow(r, c)) / (MathUtils.fact((int) c) * (c - r)));

        for (int n = 0; n <= c - 1; n++) {
            firstTerm += (pow(r, n) / MathUtils.fact(n));
        }

        double result = firstTerm + secondTerm;

        return 1 / result;
    }

    @Override
    protected void validateQueueSystemInputs(QueueSystemInput inputs) throws QueueModelException {
        super.validateQueueSystemInputs(inputs);
        if (inputs.getNumberOfServers() == null) {
            throw new QueueModelException("Number of servers can't be null");
        }
    }
}
