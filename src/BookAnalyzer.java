import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class BookAnalyzer {

    public void analyzeBook(String bookName) {

        Path filePath = Paths.get("src/" + bookName);
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            System.out.println("The book was not found.");
            return;
        }

        try {
            String content = new String(Files.readAllBytes(filePath));


            TextStatistics textStatistics = new TextStatistics();
            textStatistics.generateStatistics(content);


            String outputFileName = bookName.replace(".txt", "_statistic.txt");
            StatisticsWriter statisticsWriter = new StatisticsWriter(outputFileName);
            statisticsWriter.writeStatistics(textStatistics);


            statisticsWriter.printStatistics(textStatistics);

        } catch (IOException e) {
            System.out.println("Error reading/writing the file.");
            e.printStackTrace();
        }
    }
}