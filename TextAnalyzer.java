import java.util.*;

public class TextAnalyzer {
    public static void main(String[] args) {

        int badStuffCount = 0;
        int shortStuffCount = 0;
        int coolness = 0;
        int badness = 0;

        HashSet<String> badWords = new HashSet<>(Arrays.asList(
            "fuck","bitch","shit","mf","whore","hoe","motherfucker","fucking"
        ));

        HashSet<String> abrevation = new HashSet<>(Arrays.asList(
            "lol","brb","wdym","wym","lmfao","omg","idk","btw","smh","ngl","fr"
        ));

        Scanner in = new Scanner(System.in);

        System.out.println("Input your message...");
        String messageInput = in.nextLine();
        String[] words = messageInput.split(" ");

        // Scan + censor
        for(String word : words) {
            if(badWords.contains(word.toLowerCase())) {
                word = "*".repeat(word.length());
                badStuffCount++;
            }

            if(abrevation.contains(word.toLowerCase())) {
                shortStuffCount++;
            }

            System.out.print(word + " ");
        }

        System.out.println();

        // Badness analysis
        if(badStuffCount >= 1 && badStuffCount < 4) {
            System.out.println("Your message is informal");
            badness += 4;
        } else if(badStuffCount >= 4) {
            System.out.println("Your message isn't just informal, it's filthy");
            badness += 10;
        } else {
            System.out.println("Innocent message, cuss-free");
        }

        System.out.println();

        // Coolness analysis
        if(shortStuffCount >= 1 && shortStuffCount < 4) {
            System.out.println("Your message is trying to be cool");
            coolness += 5;
        } else if(shortStuffCount >= 4) {
            System.out.println("Your message is trying hard to be gen z slangy");
            coolness += 10;
        } else {
            System.out.println("Not slang AT ALL");
        }

        System.out.println("Word Length: " + messageInput.length());
        System.out.println("Overall: Coolness: " + coolness + " / 10");
        System.out.println("Overall: Badness: " + badness + " / 10");

        // Suggestions
        if(coolness == 0) {
            System.out.println("Suggestion: ADD COOLNESS");
        }

        if(badness == 0) {
            System.out.println("Suggestion: KEEP IT UP NO CUSSING");
        }

        // Message type (prints ONCE)
        if (badStuffCount == 0 && shortStuffCount == 0 && messageInput.length() > 15) {
            System.out.println("Message Type: Professional");
        } else if (shortStuffCount > 0 && badStuffCount <= 1) {
            System.out.println("Message Type: Casual / DM");
        } else if (badStuffCount >= 4) {
            System.out.println("Message Type: Argument");
        } else {
            System.out.println("Message Type: Normal");
        }
    }
}