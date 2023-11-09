import java.util.*;
import java.io.*;
import java.util.logging.Logger;

//For input/caching things
public class TechnicalChallenge {

    private static final Logger logger = Logger.getLogger(TechnicalChallenge.class.getName());
    public static void main(String[] args)  {
        //Initialise cache to store inputs
        List<String> cache = new ArrayList<>();

        //Scanner for input
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a username: ");
        String username = sc.nextLine();

        System.out.println("Enter your first word: ");
        String firstWord = sc.nextLine();

        System.out.println("Enter your second word: ");
        String secondWord = sc.nextLine();

        sc.close();
        System.out.println();
        System.out.println("Hello " + username);

        // Load cached data from previous runs
        cacheLoader(cache);
        logger.info("Cache loaded successfully.");

        //Check if user's values are present in cache
        String input = username + " " + firstWord + " " + secondWord;
        boolean isInCache = cache.contains(input);  //Checks if user input is already in cache

        //Checks before computation to minimise redundancies
        if(!isInCache)  {
            //Checks if word has numbers, if not prints anagram result
            if(containsNumbers(firstWord) || containsNumbers(secondWord))   {
                System.out.println("Words cannot contain numbers");
                System.out.println();
            }
            else if(Anagram.isAnagram(firstWord, secondWord)) {
                System.out.println(firstWord + " and " + secondWord + " are anagrams!");
                System.out.println();
                cache.add(input);   //Adds to cache if new input
            }
            else    {
                System.out.println(firstWord + " and " + secondWord + " are not anagrams.");
                System.out.println();
                cache.add(input);   
            }
            logger.info("Anagrams checked for: " + firstWord + " and " + secondWord);

            // Appends input and result to an external file
            writeToFile(input);
            logger.info("Data written to external file for input: " + input);

        }
    }

    //Checks if input string contains numbers
    private static boolean containsNumbers(String str) {
        return str.matches(".*\\d.*");
    }

    private static void cacheLoader(List<String> cache) {
        // Load cached data from the external file and populate 
        try (BufferedReader br = new BufferedReader(new FileReader("cache.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                cache.add(line);
            }
        } catch (IOException e) {
            logger.severe("Error loading cache from file: " + e.getMessage());
        }
    }

    private static void writeToFile(String inputKey) {
        // Appends input and result to an external file
        try (FileWriter fw = new FileWriter("cache.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(inputKey);
        } catch (IOException e) {
            logger.severe("Error writing to external file: " + e.getMessage());
        }
    }
}

//For all things anagram
class Anagram {

    //Converts input to lowercase and removes spaces
    private static String cleanWord(String x)    {
        return x.replaceAll("\\s", "").toLowerCase();
    }

    //Checks if two inputted words are anagrams
    public static boolean isAnagram(String firstWord, String secondWord)    {
        
        firstWord = cleanWord(firstWord);
        secondWord = cleanWord(secondWord);

        //Checks lengths and if not equal, returns false
        if(firstWord.length() != secondWord.length())   {
            return false;
        }

        //Convert to char for easy sorting
        char[] firstWordChars = firstWord.toCharArray();
        char[] secondWordChars = secondWord.toCharArray();

        //Sort both char arrays
        Arrays.sort(firstWordChars);
        Arrays.sort(secondWordChars);

        //Returns true if sorted arrays are equal which means words are anagrams, false otherwise
        return Arrays.equals(firstWordChars, secondWordChars);
    }
}



