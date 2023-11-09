# CME_Technical_Challenge - James Donnelly  09/11/23

Welcome to my anagram program! Below are the instructions for how to use the program as well as some assumptions that were made during the process. Note that Maven was used for defining directory structure and creating test cases in TechnicalChallengeTest.java and AnagramTest.java

------------------------------------------------------------------------------------------------------------------------------

To run the program:
    1. Ensure you are in the /src/main/java directory which includes TechnicalChallenge.java
    2. Compile the program using "javac TechnicalChallenge.java"
    3. Run program using "java TechnicalChallenge.java"
    4. Follow prompts from terminal to enter a username and two words
    5. The terminal will output log records at different stages of execution as well as if the user entered words are anagrams
    6. If execution is successful, program will place input values (username, firstWord and secondWord) into cache.txt 

------------------------------------------------------------------------------------------------------------------------------

Assumptions:
    1. A word is an angram of another if it contains the exact same letters at the other word but in a different order
    2. cache.txt is assumed to be in same dirrectory as TechnicalChallenge.java
    3. Valid input should only consist of letters
    4. The program does not depend on external libraries, only standard Java libraries are used
    5. It is expected the user only interacts with the program on the command line