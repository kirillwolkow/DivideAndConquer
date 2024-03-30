package algorithms.measurement.charts.utils;

import algorithms.logger.ExecutionLogger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.logging.Level;

public class Chart {
    public static LineChart<Number, Number> createLineChart(final String title, final int maxN, final ArrayList<Long> executionTimes, final ArrayList<Long> executionTimesWithMemory) {
        ExecutionLogger.logExecutionTimes(Level.INFO, "Creating Line Chart...");
        final LineChart<Number, Number> lineChart = constructLineChart(title);

        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Without Memory");
        for (int n = 0; n <= maxN; n++) {
            series1.getData().add(new XYChart.Data<>(n, executionTimes.get(n) / 1_000_000.0)); // Convert nanoseconds to milliseconds
        }

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("With Memory");
        for (int n = 0; n <= maxN; n++) {
            series2.getData().add(new XYChart.Data<>(n, executionTimesWithMemory.get(n) / 1_000_000.0)); // Convert nanoseconds to milliseconds
        }

        lineChart.getData().addAll(series1, series2);
        return lineChart;
    }

    public static LineChart<Number, Number> createConcurrentLineChart(final String title, final int maxN, final ArrayList<Long> executionTimes) {
        ExecutionLogger.logExecutionTimes(Level.INFO, "Creating Line Chart...");
        final LineChart<Number, Number> lineChart = constructLineChart(title);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Concurrent Fibonacci");
        for (int n = 0; n <= maxN; n++) {
            series.getData().add(new XYChart.Data<>(n, executionTimes.get(n) / 1_000_000.0)); // Convert nanoseconds to milliseconds
        }

        lineChart.getData().add(series);
        return lineChart;
    }

    private static LineChart<Number, Number> constructLineChart(final String title) {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle(title);
        xAxis.setLabel("N");
        yAxis.setLabel("Execution Time (ms)");
        return lineChart;
    }

    public static VBox createChartInformation(LineChart<Number, Number> lineChart) {
        Text algoInfo = new Text("Fibonacci-Function | OO-DnC | Long");
        Text systemInfo = new Text("OpenJDK 21.0.1 | System::nanoTime | macOS 14.2.1");
        Text hardwareInfo = new Text("Apple M1 Pro (8 Cores) | 16GB LPDDR5 | 275GB (free) of 500GB Apple SSD");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 0, 20, 0));
        vbox.getChildren().addAll(algoInfo, systemInfo, hardwareInfo);
        VBox.setVgrow(lineChart, Priority.ALWAYS);

        VBox root = new VBox();
        root.getChildren().addAll(vbox, lineChart);
        return root;
    }
}
