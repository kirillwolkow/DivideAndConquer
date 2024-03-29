package algorithms.measurement;

import algorithms.fibonacci.Fibonacci;
import algorithms.logger.ExecutionLogger;
import algorithms.logger.ProgressBarLogger;
import algorithms.measurement.charts.utils.Chart;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.logging.Level;

public class PerformanceComparison extends Application {

    @Override
    public void start(Stage stage) {
        final int maxN = 40;

        final ArrayList<Long> executionTimes = new ArrayList<>(maxN+1);
        final ArrayList<Long> executionTimesWithMemory = new ArrayList<>(maxN+1);

        for (int n = 0; n <= maxN; n++) {
            ProgressBarLogger.logProgress(n, maxN);
            int finalN = n;
            final ExecutionTimer<Long> timer = new ExecutionTimer<>(() -> new Fibonacci(finalN).divideAndConquer());
            executionTimes.add(timer.time);

            int finalN1 = n;
            final ExecutionTimer<Long> timerWithMemory = new ExecutionTimer<>(() -> new Fibonacci(finalN1).divideAndConquerWithMemory(new Long[finalN1 + 1]));
            executionTimesWithMemory.add(timerWithMemory.time);
        }

        final LineChart<Number, Number> lineChart = Chart.createLineChart("Performance Comparison", maxN, executionTimes, executionTimesWithMemory);

        VBox root = Chart.createChartInformation(lineChart);

        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("Performance Comparison");
        stage.show();
        ExecutionLogger.logExecutionTimes(Level.INFO, "Line Chart finished.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
