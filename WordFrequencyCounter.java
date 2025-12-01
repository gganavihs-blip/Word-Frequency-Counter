
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String line = sc.nextLine();               // read whole line

        // Normalize to lowercase
        line = line.toLowerCase();

        // Remove punctuation
        line = line.replaceAll("[^a-z0-9\\s]", "");

        // Split into words
        String[] words = line.trim().split("\\s+");

        // Count words in insertion order
        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String w : words) {
            if (w.isEmpty()) continue;
            counts.put(w, counts.getOrDefault(w, 0) + 1);
        }

        // Print results
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        sc.close();
    }
}