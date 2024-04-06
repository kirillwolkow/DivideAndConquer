package algorithms.measurement;

import javafx.application.Application;
import javafx.stage.Stage;

public class RunMeasurements extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        PerformanceComparison performanceComparison = new PerformanceComparison();
        performanceComparison.start(new Stage());

        ConcurrentPerformanceComparison concurrentPerformanceComparison = new ConcurrentPerformanceComparison();
        concurrentPerformanceComparison.start(new Stage());
    }
}
