package test;

import model.TypingTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TestTypingTest {

    private TypingTest test;


    private final String[][] shortPhrases =

            {
                    {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"},
                    {"The", "five", "boxing", "wizards", "jump", "quickly"},
                    {"How", "vexingly", "quick", "daft", "zebras", "jump!"},
                    {"Trust", "the", "natural", "recursion"}
            };


    private final String[][] mediumPhrases = {
            {"You", "either", "die", "a", "hero,", "or", "you", "live", "long", "enough", "to", "see", "yourself", "become", "the", "villain."},
            {"Because", "maybe", "you're", "gonna", "be", "the", "one", "that", "saves", "me", "and", "after", "all", "you're", "my", "wonderwall"},
            {"You", "either", "die", "a", "hero,", "or", "you", "live", "long", "enough", "to", "see", "yourself", "become", "the", "villain."},
            {"Because", "maybe", "you're", "gonna", "be", "the", "one", "that", "saves", "me", "and", "after", "all", "you're", "my", "wonderwall"}
    };

    private final String[][] longPhrases = {
            {"Most", "patients", "report", "a", "night", "of", "dreamless", "sleep", "after", "only", "one", "viewing", "of", "this", "videocassette.", "Consult", "your", "technician", "if", "you", "are", "experiencing", "delayed", "results", "and/or", "unwanted", "side", "effects.",},
            {"Take", "time", "to", "really", "think", "about", "your", "excuses", "and", "write", "them", "down.", "These", "are", "the", "same", "exact", "excuses", "that", "you", "always", "use", "to", "stop", "yourself", "from", "learning", "something", "new"},
            {"Most", "patients", "report", "a", "night", "of", "dreamless", "sleep", "after", "only", "one", "viewing", "of", "this", "videocassette.", "Consult", "your", "technician", "if", "you", "are", "experiencing", "delayed", "results", "and/or", "unwanted", "side", "effects.",},
            {"Take", "time", "to", "really", "think", "about", "your", "excuses", "and", "write", "them", "down.", "These", "are", "the", "same", "exact", "excuses", "that", "you", "always", "use", "to", "stop", "yourself", "from", "learning", "something", "new"}
    };

    @BeforeEach
    public void initTests(){
        this.test = new TypingTest(2);

    }

    @Test
    public void testConstructorNumWords(){
        assertEquals(2, test.getWords().length);
        test = new TypingTest(20);
        assertEquals(20, test.getWords().length);
    }

    @Test
    public void testConstructorPhraseShort(){
        test = new TypingTest("short");

        if (Arrays.equals(test.getWords(), shortPhrases[0]) ||
                Arrays.equals(test.getWords(), shortPhrases[1]) ||
                Arrays.equals(test.getWords(), shortPhrases[2]) ||
                Arrays.equals(test.getWords(), shortPhrases[3])) {
            // do nothing
        } else {
            fail("typing test did not pick a shortPhrase from array");
        }

    }

    @Test
    public void testConstructorPhraseMedium(){
        test = new TypingTest("medium");

        if (Arrays.equals(test.getWords(), mediumPhrases[0]) ||
                Arrays.equals(test.getWords(), mediumPhrases[1]) ||
                Arrays.equals(test.getWords(), mediumPhrases[2]) ||
                Arrays.equals(test.getWords(), mediumPhrases[3])) {
            // do nothing
        } else {
            fail("typing test did not pick a mediumPhrase from array");
        }

    }

    @Test
    public void testConstructorPhraseLong(){
        test = new TypingTest("long");

        if (Arrays.equals(test.getWords(), longPhrases[0]) ||
                Arrays.equals(test.getWords(), longPhrases[1]) ||
                Arrays.equals(test.getWords(), longPhrases[2]) ||
                Arrays.equals(test.getWords(), longPhrases[3])) {
            // do nothing
        } else {
            fail("typing test did not pick a longPhrase from array");
        }

    }

    @Test
    public void testCalculateWPM() {
        //manually simulate an exactly 1 second test, with 15 characters, no errors.  gross = net
        String rawinput1 = "Test no errors.";
        test.setStartTime(1000);
        test.setEndTime(2000);
        test.setRawInput(rawinput1);
        test.setTypedWords(rawinput1.split(" "));
        test.setWords(rawinput1.split(" "));
        assertEquals(1, test.getElapsedTime());
        assertEquals(3 * 60, test.getGrossWPM());
        assertEquals(180, test.getNetWPM());

        //manually simulate an exactly 1 second test, with 15 characters, 1 error. gross != net
        //no need to retest elapsed time.  Just check that grossWPM stays same, and net is different
        String rawinput2 = "Test nx errors.";
        test.setRawInput(rawinput2);
        test.setTypedWords(rawinput2.split(" "));
        assertEquals(180, test.getGrossWPM());
        assertNotEquals(test.getGrossWPM(), test.getNetWPM());
        assertEquals((float) 14 / 5 * 60, (float) test.getNetWPM());
    }

    @Test
    public void testCalculateAccuracy(){
        //manually simulate an entry of "Test no errors."  when solution is "Test no errors."
        //tests no error case
        String rawInput = "Test no errors.";
        test.setRawInput(rawInput);
        test.setWords(rawInput.split(" "));
        test.setTypedWords(rawInput.split(" "));

        assertEquals(1, test.getAccuracy());
        assertEquals(0, test.getErrors());

        //manually simulate an entry with improper capitalization (still counts as error)
        //   typed ->  "tEST no errors."   solution  "Test no errors."
        rawInput = "tEST no errors.";
        test.setRawInput(rawInput);
        test.setTypedWords(rawInput.split(" "));
        assertEquals((float) 9/13, test.getAccuracy());
        assertEquals(4, test.getErrors());

        //manually simulate an entry with extra characters at end of word, and in front of word
        //   typed ->  "aTesta no errors."    solution  "Test no errors."
        rawInput = "aTesta no errors.";
        test.setRawInput(rawInput);
        test.setTypedWords(rawInput.split(" "));
        //   correct accuracy should be #chars correctly matched in sequence per word - errors per word  / total#char
        assertEquals(6, test.getErrors());
        assertEquals((float) 9/15, test.getAccuracy());

        //manually simulate an entry with a double space.  should count the extra space as 1 error, nothing more
        // typed -> "Test  no errors."  solution "Test no errors.
        rawInput = "Test  no errors.";
        test.setRawInput(rawInput);
        test.setTypedWords(rawInput.split(" "));
        assertEquals((float) 13/14, test.getAccuracy());
        test.setRawInput(rawInput);
        test.setTypedWords(rawInput.split(" "));
        assertEquals(1, test.getErrors());
    }




}
