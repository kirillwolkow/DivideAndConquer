package algorithms.measurement;

import algorithms.fibonacci.ConcurrentFibonacci;
import algorithms.logger.ExecutionLogger;
import algorithms.logger.ProgressBarLogger;
import algorithms.measurement.charts.utils.Chart;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;

public class ConcurrentPerformanceComparison extends Application {
    @Override
    public void start(Stage stage) {
        int maxN = 40;

        final ArrayList<Long> executionTimes = new ArrayList<>(maxN+1);

        for (int n = 0; n <= maxN; n++) {
            try {
                int finalN = n;
                ProgressBarLogger.logProgress(n, maxN);
                ExecutionTimer<Long> timer = new ExecutionTimer<>(() -> {
                    try {
                        return new ConcurrentFibonacci(finalN).concurrentDivideAndConquer();
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
                executionTimes.add(timer.time);
            } catch (Exception e) {
                ExecutionLogger.logExecutionTimes(Level.SEVERE, "Error happened at " + n + " Iteration " + e);
            }
        }

        LineChart<Number, Number> lineChart = Chart.createConcurrentLineChart("Concurrent Performance Comparison", maxN, executionTimes);
        VBox root = Chart.createChartInformation(lineChart);

        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Concurrent Performance Comparison");
        stage.show();
        ExecutionLogger.logExecutionTimes(Level.INFO, "Line Chart finished");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
