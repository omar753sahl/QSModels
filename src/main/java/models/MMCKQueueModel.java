package models;

import utils.MathUtils;

import static utils.MathUtils.fact;
import static utils.MathUtils.pow;

public final class MMCKQueueModel extends QueueModel {

    private double lambda, lambdaDash, mue, r, rho, P0;
    private int servers, capacity, C, K;

    @Override
    protected PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput input) throws QueueModelException {

        lambda = input.getArrivalRate();
        mue = input.getServiceRate();
        servers = input.getNumberOfServers();
        capacity = input.getSystemCapacity();

        C = servers;
        K = capacity;

        r = lambda / mue;
        rho = r / C;

        P0 = getP0();

        double L, Lq, W, Wq;

        //Lambda(dash) calculation
        {
            lambdaDash = lambda * (1 - getP(K));
        }

        //Lq calculation
        {
            Lq = 0.0;
            for (int n = C + 1; n <= K; ++n) {
                double Pn = getP(n);
                Lq += (n - C) * Pn;
            }
        }

        //L calculation
        {
            L = Lq + C;

            double neg = 0;
            for (int n = 0; n <= C - 1; ++n) {
                neg += ((C - n) * pow(r, n)) / fact(n);
            }

            L -= P0 * neg;
        }

        //W calculation
        {
            W = L / lambdaDash;
        }

        //Wq calculation
        {
            Wq = Lq / lambdaDash;
        }

        return new PerformanceMetrics(L, Lq, W, Wq);
    }


    //Calculates P(n)
    double getP(int n) {

        double P = Double.NaN;

        if (n >= 0 && n < C) {
            P = (pow(r, n) / fact(n)) * P0;
        } else if (n >= C && n <= K) {
            P = (pow(r, n) / (pow(C, n - C) * fact(C))) * P0;
        }

        return P;
    }

    //Calculates P(0)
    double getP0() {

        double P0_inv = 0.0;

        MathUtils.prepareFact(Math.max(C, K));

        if (rho == 1.0) {

            for (int n = 0; n <= C - 1; ++n) {
                P0_inv += (pow(r, n) / fact(n));
            }
            P0_inv += (pow(r, C) / fact(C)) * (K - C + 1);

        } else {

            for (int n = 0; n <= C - 1; ++n) {
                P0_inv += (pow(r, n) / fact(n));
            }
            P0_inv += (pow(r, C) / fact(C)) * ((1 - pow(rho, K - C + 1)) / (1 - rho));
        }

        return 1 / P0_inv;
    }

    @Override
    protected void validateQueueSystemInputs(QueueSystemInput inputs) throws QueueModelException {
        super.validateQueueSystemInputs(inputs);
        if (inputs.getSystemCapacity() == null) {
            throw new QueueModelException("System capacity can't be null");
        }
        if (inputs.getNumberOfServers() == null) {
            throw new QueueModelException("Number of servers can't be null");
        }
    }
}
