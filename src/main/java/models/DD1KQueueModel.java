package models;


/**
 * Represents a D/D/1/K-1 Queue Model.
 */
public final class DD1KQueueModel extends QueueModel {

    int M = 0; //number of people "already" in the system
    double Ti = Double.NaN;
    boolean isCase1 = false;
    boolean isCase2 = false;

    protected PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput input) throws QueueModelException {

        isCase1 = input.getArrivalRate() > input.getServiceRate();
        isCase2 = input.getArrivalRate() <= input.getServiceRate();

        if (isCase1 == isCase2) throw new QueueModelException("Cannot determine the queue case!");

        PerformanceMetrics result = new PerformanceMetrics();

        if (isCase1) {

            Ti = fetchTi(input);
//            double Wq = fetchWq(input, n);

        } else if (isCase2) {

        }

        return null;
    }


    double fetchTi(QueueSystemInput input) {

        double LEFT_BOUND = 0.0, RIGHT_BOUND = Double.MAX_VALUE;
        double eps = 1e-9;

        while ((RIGHT_BOUND - LEFT_BOUND) > eps) {
            double t = (LEFT_BOUND + RIGHT_BOUND) / 2;

            int cutomersInSystem = numberOfCustomers(input, t);

            if (cutomersInSystem >= input.getSystemCapacity())
                RIGHT_BOUND = t;
            else
                LEFT_BOUND = t;
        }

        return Ti;
    }

    int numberOfCustomers(QueueSystemInput input, double t) {
        if (Double.isNaN(Ti))
            return (int) (input.getArrivalRate() * t) - (int) (input.getServiceRate() * t - input.getServiceRate() / input.getArrivalRate());
        else {

            if (t <= 1 / input.getArrivalRate())
                return M;
            else if (t > 1 / input.getArrivalRate() && t <= Ti)
                return (int) (input.getArrivalRate() * t) - (int) (input.getServiceRate() * t - input.getServiceRate() / input.getArrivalRate());
            else {
                //t > Ti
                //needs filling
                //alternates between K - 1 / K - 2
                return input.getSystemCapacity() - 1; // wrong!
            }
        }
    }

    double fetchWq(QueueSystemInput input, int n) {
        if (n == 0) return 0;

        if (n < (int) Ti * input.getArrivalRate()) {
            return (1 / input.getServiceRate() - 1 / input.getArrivalRate()) * (n - 1);
        } else {
            return (1 / input.getServiceRate() - 1 / input.getArrivalRate()) * (Ti * input.getArrivalRate() - 2);
        }
    }

}
