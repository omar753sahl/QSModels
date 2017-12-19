package models;

import io.reactivex.Observable;

/**
 * Base class for all Queue Models
 */
public abstract class QueueModel {

    /**
     * Calls {@link #calculatePerformanceMetrics(QueueSystemInput)} asynchronously by returning an {@link Observable}
     * which can be observed on a background thread.
     *
     * @param input: the Queue System Input Variables
     * @return an {@link Observable<PerformanceMetrics>}
     */

    //Calculation interface
    public Observable<PerformanceMetrics> getPerformanceMetrics(QueueSystemInput input) {

        return Observable.create(emitter -> {
            try {
                validateQueueSystemInputs(input);
                Thread.sleep(3000);
                PerformanceMetrics metrics = calculatePerformanceMetrics(input);
                emitter.onNext(metrics);
                emitter.onComplete();
            } catch (QueueModelException e) {
                emitter.onError(e);
            }
        });
    }

    //Calculation
    protected abstract PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput input) throws QueueModelException;

    //Input Validation
    protected void validateQueueSystemInputs(QueueSystemInput inputs) throws QueueModelException {
        if (inputs.getArrivalRate() == null) {
            throw new QueueModelException("Arrival rate can't be null");
        } else if (inputs.getServiceRate() == null) {
            throw new QueueModelException("Service rate can't be null");
        }
    }

}
