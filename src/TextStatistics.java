import java.util.*;
import java.util.stream.Collectors;

class TextStatistics {

    final private Map<String, Integer> wordFrequency = new HashMap<>();

    public void generateStatistics(String text) {
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (word.length() > 2) {
                word = word.toLowerCase();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
    }

    public List<Map.Entry<String, Integer>> getTopWords() {
        return wordFrequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toList());
    }

    public int getUniqueWordCount() {
        return wordFrequency.size();
    }
}