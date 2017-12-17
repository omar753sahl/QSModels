package models;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * Base class for all Queue Models
 */
public abstract class QueueModel {

    /**
     * Calls {@link #calculatePerformanceMetrics(QueueSystemInput)} asynchronously by returning an {@link Observable}
     * which can be observed on a background thread.
     *
     * @param inputs: inputs to this queue.
     * @return an {@link Observable<PerformanceMetrics>}
     */
    public Observable<PerformanceMetrics> getPerformanceMetrics(QueueSystemInput inputs) {
        return Observable.create(emitter -> {
            try {
                validateQueueSystemInputs(inputs);
                PerformanceMetrics metrics = calculatePerformanceMetrics(inputs);
                emitter.onNext(metrics);
                emitter.onComplete();
            } catch (QueueModelException e) {
                emitter.onError(e);
            }
        });
    }

    protected abstract PerformanceMetrics calculatePerformanceMetrics(QueueSystemInput inputs) throws QueueModelException;

    protected abstract void validateQueueSystemInputs(QueueSystemInput inputs) throws QueueModelException;
}
