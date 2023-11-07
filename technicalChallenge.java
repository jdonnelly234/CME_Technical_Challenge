import java.util.Arrays;


public class technicalChallenge{

    //Converts input to lowercase and removes spaces
    private static String cleanWord(String x)    {
        return x.replaceAll("\\s", "").toLowerCase();
    }

    //Chcks if two inputted words are anagrams
    public static boolean isAnagram(String firstWord, String secondWord)    {

        firstWord = cleanWord(firstWord);
        secondWord = cleanWord(secondWord);

        //Checks lengths and if unequal returns false
        if(firstWord.length() != secondWord.length())   {
            return false;
        }

        char[] firstWordChars = firstWord.toCharArray();
        char[] secondWordChars = secondWord.toCharArray();

        Arrays.sort(firstWordChars);
        Arrays.sort(secondWordChars);

        return Arrays.equals(firstWordChars, secondWordChars);
    }
    public static void main(String[] args)  {
        
    }

}