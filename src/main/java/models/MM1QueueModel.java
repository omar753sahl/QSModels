package models;


/**
 * Represents a M/M/1 Queue Model.
 */
public final class MM1QueueModel extends QueueModel {

    @Override
    protected PerformanceMetrics calculatePerformanceMetrics(double arrivalRate, double serviceRate) throws QueueModelException {
        return null;
    }
}
