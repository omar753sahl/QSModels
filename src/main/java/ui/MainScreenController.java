package ui;

import com.jfoenix.controls.JFXButton;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.MM1QueueModel;
import models.PerformanceMetrics;
import models.QueueModelException;

public class MainScreenController {

    @FXML
    private JFXButton mm1Button;

    @FXML
    private JFXButton mmkButton;

    @FXML
    private JFXButton mmcButton;

    @FXML
    private JFXButton mmckButton;

    @FXML
    public void initialize() {
        System.out.println("Done loading FXML components!");
    }

    @FXML
    void onMm1Clicked(ActionEvent event) {
//        MM1QueueModel model = new MM1QueueModel();
//        Observable<PerformanceMetrics> metricsObservable = model.getPerformanceMetrics(0.3, 0.4);
//        DisposableObserver<PerformanceMetrics> disposable = metricsObservable.subscribeWith(new DisposableObserver<PerformanceMetrics>() {
//            @Override
//            public void onNext(PerformanceMetrics performanceMetrics) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
//        disposable.dispose();
    }

    @FXML
    void onMmcClicked(ActionEvent event) {

    }

    @FXML
    void onMmckClicked(ActionEvent event) {

    }

    @FXML
    void onMmkClicked(ActionEvent event) {

    }
}
