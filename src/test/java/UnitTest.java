import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import models.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import utils.MathUtils;

/**
 * Created by Omar
 * Date: 17-Dec-17.
 */

public class UnitTest {
    @Test
    public void testSomething() {
        try {
            System.out.println(MathUtils.eval("(5 + 10) * 5"));
        } catch (Exception e) {
            System.out.println("sorry :(");
        }
    }

    @Test
    public void testMM1KQueueModel() {
        MM1KQueueModel model = new MM1KQueueModel();
        Observable<PerformanceMetrics> ob = model.getPerformanceMetrics(new QueueSystemInput(5.0, 6.0, null, 5));
        ob.subscribeWith(new DisposableObserver<PerformanceMetrics>() {
            @Override
            public void onNext(PerformanceMetrics performanceMetrics) {
                System.out.println(performanceMetrics);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("done!");
            }
        });
    }


    @Test
    public void testMM1QueueModel() {
        MM1QueueModel model = new MM1QueueModel();
        Observable<PerformanceMetrics> ob = model.getPerformanceMetrics(new QueueSystemInput(50.0, 60.0, null, null));
        ob.subscribeWith(new DisposableObserver<PerformanceMetrics>() {
            @Override
            public void onNext(PerformanceMetrics performanceMetrics) {
                System.out.println(performanceMetrics);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("done!");
            }
        });
    }

    @Test
    public void testMMCKQueueModel() {
        MMCKQueueModel model = new MMCKQueueModel();
        Observable<PerformanceMetrics> ob = model.getPerformanceMetrics(new QueueSystemInput(6.0 / 60.0, 1 / 20.0, 3, 7));
        ob.subscribeWith(new DisposableObserver<PerformanceMetrics>() {
            @Override
            public void onNext(PerformanceMetrics performanceMetrics) {
                System.out.println(performanceMetrics);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("done!");
            }
        });
    }
}
