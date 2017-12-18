package models;

import static java.lang.Math.*;

public final class MM1KQueueModel extends QueueModel {
    @Override
    protected PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput input) throws QueueModelException {

        double lambda = input.getArrivalRate();
        double mu = input.getServiceRate();
        double k = input.getSystemCapacity();

        double rho = lambda / mu;

        double L = getL(rho, k);
        double Pk = getPk(rho, k);

        double lambdaPrime = lambda * (1 - Pk);

        double W = L / lambdaPrime;

        double Wq = W - (1 / mu);

        double Lq = lambdaPrime * Wq;

        return new PerformanceMetrics(L, Lq, W, Wq);
    }

    private double getL(double rho, double k) {
        if (rho == 1) {
            return k / 2;
        }

        return rho * ((1 - (k + 1) * pow(rho, k) + k * pow(rho, k + 1)) / ((1 - rho) * (1 - pow(rho, k + 1))));
    }

    private double getPk(double rho, double k) {
        if (rho == 1) {
            return 1 / (k + 1);
        }

        return pow(rho, k) * ((1 - rho) / (1 - pow(rho, k + 1)));
    }

    @Override
    protected void validateQueueSystemInputs(QueueSystemInput inputs) throws QueueModelException {
        super.validateQueueSystemInputs(inputs);
        if (inputs.getSystemCapacity() == null) {
            throw new QueueModelException("System capacity can't be null");
        }
    }
}