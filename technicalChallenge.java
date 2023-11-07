import java.util.Arrays;    
import java.util.Scanner;

public class TechnicalChallenge {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a username: ");
        String username = sc.nextLine();

        System.out.println("Enter your first word: ");
        String firstWord = sc.nextLine();

        System.out.println("Enter your second word: ");
        String secondWord = sc.nextLine();

        sc.close();

        System.out.println("Hello " + username);

        if(containsNumbers(firstWord) || containsNumbers(secondWord))   {
            System.out.println("Words cannot contain numbers");
        }
        else if(Anagram.isAnagram(firstWord, secondWord)) {
            System.out.println(firstWord + " and " + secondWord + " are anagrams!");
        }
        else    {
            System.out.println(firstWord + " and " + secondWord + " are not anagrams.");
        }
    }

    private static boolean containsNumbers(String str) {
        return str.matches(".*\\d.*");
    }
}

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

