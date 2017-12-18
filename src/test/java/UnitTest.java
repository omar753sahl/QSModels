import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import models.MM1KQueueModel;
import models.PerformanceMetrics;
import models.QueueSystemInput;
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

}
