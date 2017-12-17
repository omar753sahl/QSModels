package models;


/**
 * Represents a M/M/1 Queue Model.
 */
public final class MM1QueueModel extends QueueModel {
    @Override
    protected PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput inputs) throws QueueModelException {
        return null;
    }

    @Override
    protected void validateQueueSystemInputs(QueueSystemInput inputs) throws QueueModelException {
        if (inputs.getArrivalRate() == null) {
            throw new QueueModelException("Arrival rate can't be null");
        } else if (inputs.getServiceRate() == null) {
            throw new QueueModelException("Service rate can't be null");
        }
    }
}
