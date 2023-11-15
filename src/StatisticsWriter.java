import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

class StatisticsWriter {

    final private String outputFileName;

    public StatisticsWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void writeStatistics(TextStatistics textStatistics) throws IOException {
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            for (Map.Entry<String, Integer> entry : textStatistics.getTopWords()) {
                writer.println(entry.getKey() + " -> " + entry.getValue() + " times");
            }
            writer.println("Total number of words: " + textStatistics.getUniqueWordCount());
        }
    }

    public void printStatistics(TextStatistics textStatistics) {
        System.out.println("Top 10 words:");
        for (Map.Entry<String, Integer> entry : textStatistics.getTopWords()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " times");
        }
        System.out.println("Total number of words: " + textStatistics.getUniqueWordCount());
    }
}