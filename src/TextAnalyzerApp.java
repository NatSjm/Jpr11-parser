public class TextAnalyzerApp {
    public static void main(String[] args) {
        try (UserInput userInput = new UserInput()) {
            String bookName = userInput.getBookName();

            BookAnalyzer bookAnalyzer = new BookAnalyzer();
            bookAnalyzer.analyzeBook(bookName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}