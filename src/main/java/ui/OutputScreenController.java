package ui;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSpinner;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import io.reactivex.schedulers.Schedulers;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import models.*;

import java.io.IOException;

public class OutputScreenController {
    private QueueType queueType;
    private QueueSystemInput inputs;

    @FXML
    private BorderPane root;

    @FXML
    private Label labelL;

    @FXML
    private Label labelLq;

    @FXML
    private Label labelW;

    @FXML
    private Label labelWq;

    @FXML
    private Label backButton;

    @FXML
    private JFXSpinner progressBar;

    @FXML
    private StackPane progressBarContainer;


    private DisposableObserver<PerformanceMetrics> disposableObserver;

    public void initView(QueueType queueType, QueueSystemInput inputs) {
        this.queueType = queueType;
        this.inputs = inputs;

        System.out.println("QueueType: " + queueType.name());
        System.out.println(inputs);

        calculateOutput(inputs);
    }

    private void calculateOutput(QueueSystemInput inputs) {
        QueueModel model = null;

        switch (queueType) {
            case DD1K:
                // do nothing for now
                break;
            case MM1:
                model = new MM1QueueModel();
                break;
            case MM1K:
                model = new MM1KQueueModel();
                break;
            case MMC:
                model = new MMCQueueModel();
                break;
            case MMCK:
                model = new MMCKQueueModel();
                break;
        }

        Observable<PerformanceMetrics> observable = model.getPerformanceMetrics(inputs);
        disposableObserver = observable.subscribeOn(Schedulers.computation())
                .observeOn(JavaFxScheduler.platform())
                .subscribeWith(new DisposableObserver<PerformanceMetrics>() {
                    @Override
                    public void onNext(PerformanceMetrics performanceMetrics) {
                        System.out.println(Thread.currentThread().getName());
                        bindOutputToView(performanceMetrics);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                        hideProgressBar();
                    }
                });
    }

    private void bindOutputToView(PerformanceMetrics metrics) {
        System.out.println("metrics for this '" + queueType + "' are: " + metrics.toString());
        labelL.setText(formatOutput(4, metrics.getL()));
        labelLq.setText(formatOutput(4, metrics.getLq()));
        labelW.setText(formatOutput(4, metrics.getW()));
        labelWq.setText(formatOutput(4, metrics.getWq()));
    }

    private String formatOutput(int decimalPlaces, double value) {
        return String.format("%." + decimalPlaces + "f", value);
    }

    private void hideProgressBar() {
        progressBarContainer.getChildren().remove(progressBar);
    }

    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
        if (disposableObserver != null && !disposableObserver.isDisposed()) {
            disposableObserver.dispose();
        }
        App.getScenesManager().goToInputScreen(queueType);
    }
}
