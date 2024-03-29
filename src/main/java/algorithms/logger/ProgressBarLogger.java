package algorithms.logger;

import java.util.logging.Level;

public class ProgressBarLogger {
    private static final int PROGRESS_BAR_LENGTH = 50; // Length of the progress bar
    private static final String RESET_LINE = "\r\033[K"; // Reset the line and clear it

    public static void logProgress(int currentIteration, int maxIterations) {
        double progressPercentage = (double) currentIteration / maxIterations;
        int progressBarFilledLength = (int) (progressPercentage * PROGRESS_BAR_LENGTH);
        int progressBarEmptyLength = PROGRESS_BAR_LENGTH - progressBarFilledLength;

        StringBuilder progressBar = new StringBuilder();
        progressBar.append("Computing Fibonacci Numbers [");

        for (int i = 0; i < progressBarFilledLength; i++) {
            progressBar.append("█");
        }

        for (int i = 0; i < progressBarEmptyLength; i++) {
            progressBar.append(" ");
        }

        progressBar.append("] ");
        progressBar.append(String.format("%.2f", progressPercentage * 100));
        progressBar.append("% ");
        progressBar.append(currentIteration + "/" + maxIterations);

        System.out.print(RESET_LINE + progressBar.toString());

        if (currentIteration == maxIterations) {
            System.out.println(); // Add newline when loop is finished
        }
    }
}
