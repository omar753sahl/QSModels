package models;

import io.reactivex.Observable;

/**
 * Base class for all Queue Models
 */
public abstract class QueueModel {

    /**
     * Calls {@link #calculatePerformanceMetrics(double, double)} asynchronously by returning an {@link Observable}
     * which can be observed on a background thread.
     *
     * @param arrivalRate: the arrival rate
     * @param serviceRate: the service rate
     * @return an {@link Observable<PerformanceMetrics>}
     */
    public Observable<PerformanceMetrics> getPerformanceMetrics(double arrivalRate, double serviceRate) {
        Observable<PerformanceMetrics> observable = Observable.create(emitter -> {
            try {
                PerformanceMetrics metrics = calculatePerformanceMetrics(arrivalRate, serviceRate);
                emitter.onNext(metrics);
                emitter.onComplete();
            } catch (QueueModelException e) {
                emitter.onError(e);
            }
        });

        return observable;
    }

    protected abstract PerformanceMetrics calculatePerformanceMetrics(double arrivalRate, double serviceRate) throws QueueModelException;
}
