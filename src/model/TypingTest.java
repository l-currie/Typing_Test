package model;

import java.util.Random;
import java.util.Scanner;

public class TypingTest {

    private String[] words;
    private double startTime;
    private double endTime;
    private String[] typedWords;
    private Scanner input;
    private String rawInput;
    private double grossWPM;
    private double netWPM;
    private float accuracy;
    private float errors;
    private double elapsedTime;

    private final String[] most_common_words = {"the", "of", "to", "and", "a", "in", "is", "it", "you", "that", "he", "was", "for", "on", "are", "with", "as", "I", "his", "they", "be", "at", "one", "have", "this", "from", "or", "had", "by", "not", "word", "but", "what", "some", "we", "can", "out", "other", "were", "all", "there", "when", "up", "use", "your", "how", "said", "an", "each", "she", "which", "do", "their", "time", "if", "will", "way", "about", "many", "then", "them", "write", "would", "like", "so", "these", "her", "long", "make", "thing", "see", "him", "two", "has", "look", "more", "day", "could", "go", "come", "did", "number", "sound", "no", "most", "people", "my", "over", "know", "water", "than", "call", "first", "who", "may", "down", "side", "been", "now", "find", "any", "new", "work", "part", "take", "get", "place", "made", "live", "where", "after", "back", "little", "only", "round", "man", "year", "came", "show", "every", "good", "me", "give", "our", "under", "name", "very", "through", "just", "form", "sentence", "great", "think", "say", "help", "low", "line", "differ", "turn", "cause", "much", "mean", "before", "move", "right", "boy", "old", "too", "same", "tell", "does", "set", "three", "want", "air", "well", "also", "play", "small", "end", "put", "home", "read", "hand", "port", "large", "spell", "add", "even", "land", "here", "must", "big", "high", "such", "follow", "act", "why", "ask", "men", "change", "went", "light", "kind", "off", "need", "house", "picture", "try", "us", "again", "animal", "point", "mother", "world", "near", "build", "self", "earth", "father", "head", "stand", "own", "page", "should", "country", "found", "answer", "school", "grow", "study", "still", "learn", "plant", "cover", "food", "sun", "four", "between", "state", "keep", "eye", "never", "last", "let", "thought", "city", "tree", "cross", "farm", "hard", "start", "might", "story", "saw", "far", "sea", "draw", "left", "late", "run", "don't", "while", "press", "close", "night", "real", "life", "few", "north", "open", "seem", "together", "next", "white", "children", "begin", "got", "walk", "example", "ease", "paper", "group", "always", "music", "those", "both", "mark", "often", "letter", "until", "mile", "river", "car", "feet", "care", "second", "book", "carry", "took", "science", "eat", "room", "friend", "began", "idea", "fish", "mountain", "stop", "once", "base", "hear", "horse", "cut", "sure", "watch", "color", "face", "wood", "main", "enough", "plain", "girl", "usual", "young", "ready", "above", "ever", "red", "list", "though", "feel", "talk", "bird", "soon", "body", "dog", "family", "direct", "pose", "leave", "song", "measure", "door", "product", "black", "short", "numeral", "class", "wind", "question", "happen", "complete", "ship", "area", "half", "rock", "order", "fire", "south", "problem", "piece", "told", "knew", "pass", "since", "top", "whole", "king", "space", "heard", "best", "hour", "better", "true", "during", "hundred", "five", "remember", "step", "early", "hold", "west", "ground", "interest", "reach", "fast", "verb", "sing", "listen", "six", "table", "travel", "less", "morning", "ten", "simple", "several", "vowel", "toward", "war", "lay", "against", "pattern", "slow", "center", "love", "person", "money", "serve", "appear", "road", "map", "rain", "rule", "govern", "pull", "cold", "notice", "voice", "unit", "power", "town", "fine", "certain", "fly", "fall", "lead", "cry", "dark", "machine", "note", "wait", "plan", "figure", "star", "box", "noun", "field", "rest", "correct", "able", "pound", "done", "beauty", "drive", "stood", "contain", "front", "teach", "week", "final", "gave", "green", "oh", "quick", "develop", "ocean", "warm", "free", "minute", "strong", "special", "mind", "behind", "clear", "tail", "produce", "fact", "street", "inch", "multiply", "nothing", "course", "stay", "wheel", "full", "force", "blue", "object", "decide", "surface", "deep", "moon", "island", "foot", "system", "busy", "test", "record", "boat", "common", "gold", "possible", "plane", "stead", "dry", "wonder", "laugh", "thousand", "ago", "ran", "check", "game", "shape", "equate", "hot", "miss", "brought", "heat", "snow", "tire", "bring", "yes", "distant", "fill", "east", "paint", "language", "among", "grand", "ball", "yet", "wave", "drop", "heart", "am", "present", "heavy", "dance", "engine", "position", "arm", "wide", "sail", "material", "size", "vary", "settle", "speak", "weight", "general", "ice", "matter", "circle", "pair", "include", "divide", "syllable", "felt", "perhaps", "pick", "sudden", "count", "square", "reason", "length", "represent", "art", "subject", "region", "energy", "hunt", "probable", "bed", "brother", "egg", "ride", "cell", "believe", "fraction", "forest", "sit", "race", "window", "store", "summer", "train", "sleep", "prove", "lone", "leg", "exercise", "wall", "catch", "mount", "wish", "sky", "board", "joy", "winter", "sat", "written", "wild", "instrument", "kept", "glass", "grass", "cow", "job", "edge", "sign", "visit", "past", "soft", "fun", "bright", "gas", "weather", "month", "million", "bear", "finish", "happy", "hope", "flower", "clothe", "strange", "gone", "jump", "baby", "eight", "village", "meet", "root", "buy", "raise", "solve", "metal", "whether", "push", "seven", "paragraph", "third", "shall", "held", "hair", "describe", "cook", "floor", "either", "result", "burn", "hill", "safe", "cat", "century", "consider", "type", "law", "bit", "coast", "copy", "phrase", "silent", "tall", "sand", "soil", "roll", "temperature", "finger", "industry", "value", "fight", "lie", "beat", "excite", "natural", "view", "sense", "ear", "else", "quite", "broke", "case", "middle", "kill", "son", "lake", "moment", "scale", "loud", "spring", "observe", "child", "straight", "consonant", "nation", "dictionary", "milk", "speed", "method", "organ", "pay", "age", "section", "dress", "cloud", "surprise", "quiet", "stone", "tiny", "climb", "cool", "design", "poor", "lot", "experiment", "bottom", "key", "iron", "single", "stick", "flat", "twenty", "skin", "smile", "crease", "hole", "trade", "melody", "trip", "office", "receive", "row", "mouth", "exact", "symbol", "die", "least", "trouble", "shout", "except", "wrote", "seed", "tone", "join", "suggest", "clean", "break", "lady", "yard", "rise", "bad", "blow", "oil", "blood", "touch", "grew", "cent", "mix", "team", "wire", "cost", "lost", "brown", "wear", "garden", "equal", "sent", "choose", "fell", "fit", "flow", "fair", "bank", "collect", "save", "control", "decimal", "gentle", "woman", "captain", "practice", "separate", "difficult", "doctor", "please", "protect", "noon", "whose", "locate", "ring", "character", "insect", "caught", "period", "indicate", "radio", "spoke", "atom", "human", "history", "effect", "electric", "expect", "crop", "modern", "element", "hit", "student", "corner", "party", "supply", "bone", "rail", "imagine", "provide", "agree", "thus", "capital", "won't", "chair", "danger", "fruit", "rich", "thick", "soldier", "process", "operate", "guess", "necessary", "sharp", "wing", "create", "neighbor", "wash", "bat", "rather", "crowd", "corn", "compare", "poem", "string", "bell", "depend", "meat", "rub", "tube", "famous", "dollar", "stream", "fear", "sight", "thin", "triangle", "planet", "hurry", "chief", "colony", "clock", "mine", "tie", "enter", "major", "fresh", "search", "send", "yellow", "gun", "allow", "print", "dead", "spot", "desert", "suit", "current", "lift", "rose", "continue", "block", "chart", "hat", "sell", "success", "company", "subtract", "event", "particular", "deal", "swim", "term", "opposite", "wife", "shoe", "shoulder", "spread", "arrange", "camp", "invent", "cotton", "born", "determine", "quart", "nine", "truck", "noise", "level", "chance", "gather", "shop", "stretch", "throw", "shine", "property", "column", "molecule", "select", "wrong", "gray", "repeat", "require", "broad", "prepare", "salt", "nose", "plural", "anger", "claim", "continent", "oxygen", "sugar", "death", "pretty", "skill", "women", "season", "solution", "magnet", "silver", "thank", "branch", "match", "suffix", "especially", "fig", "afraid", "huge", "sister", "steel", "discuss", "forward", "similar", "guide", "experience", "score", "apple", "bought", "led", "pitch", "coat", "mass", "card", "band", "rope", "slip", "win", "dream", "evening", "condition", "feed", "tool", "total", "basic", "smell", "valley", "nor", "double", "seat", "arrive", "master", "track", "parent", "shore", "division", "sheet", "substance", "favor", "connect", "post", "spend", "chord", "fat", "glad", "original", "share", "station", "dad", "bread", "charge", "proper", "bar", "offer", "segment", "slave", "duck", "instant", "market", "degree", "populate", "chick", "dear", "enemy", "reply", "drink", "occur", "support", "speech", "nature", "range", "steam", "motion", "path", "liquid", "log", "meant", "quotient", "teeth", "shell", "neck"};
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

    //takes in the number of words for the typing test.
    public TypingTest(int numWords) {
        Random rand = new Random();
        words = new String[numWords];

        for (int i = 0; i < numWords; i++) {
            words[i] = most_common_words[rand.nextInt(999)];
        }


    }

    public TypingTest(String mode) {
        Random rand = new Random();
        if (mode.equals("short")) {
            words = shortPhrases[rand.nextInt(4)];
        } else if (mode.equals("medium")) {
            words = mediumPhrases[rand.nextInt(4)];
        } else if (mode.equals("long")) {
            words = longPhrases[rand.nextInt(4)];
        }
    }


    private void calculateWPM() {
        //formula for wpm is #characters typed / 5  / 1 min
        this.elapsedTime = (endTime - startTime) / 1000;
        this.grossWPM = (((double)rawInput.length() / 5) / this.elapsedTime) * 60;
        this.netWPM = (((rawInput.length() - errors) / 5) / this.elapsedTime) * 60;

    }

    private void calculateAccuracy() {
        float correct = 0, wrong = 0;
        //basic accuracy, checks to see if each element in string[]'s are equal.
        //checks character-wise, accounts for extra / missing characters as well with diff of lengths.

        //to account for excess spaces, we can count number of spaces, subtract by (words.length -1)
        // to get the amount of spaces in solution, and then add # excess to errors.
        long spaces = rawInput.chars().filter(c -> c == (int) ' ').count();  //counts # of spaces
        // System.out.println("\n-------------------------------\n");
        // System.out.println("spaces: " + spaces);
        wrong = (spaces - (words.length - 1));
        // System.out.println("# of wrong spaces: " + wrong);


        // System.out.println("raw input untrimmed:   " + rawInput);
        this.rawInput = rawInput.trim().replaceAll(" +", " ");  //removes excess spaces only
        // System.out.println("raw input trimmed:     " + rawInput);
        this.typedWords = rawInput.split(" ");

        for (int i = 0; i < words.length; i++) {
            wrong += Math.abs(typedWords[i].length() - words[i].length()); // adds diff of lengths to wrong
            // this loop compares each char to see if right or wrong,
            for (int c = 0; c < Math.min((words[i].length()), typedWords[i].length()); c++) {
                String testChar = words[i].substring(c, c + 1);
                String typedChar = typedWords[i].substring(c, c + 1);
                if (testChar.equals(typedChar)) {
                    correct++;
                } else {
                    wrong++;
                }
            }
        }
        // System.out.println("Correct: " + correct + " Wrong: " + wrong);
        this.errors = wrong;
        this.accuracy = correct / (correct + wrong);

    }

    // Getters
    public String[] getWords() {
        return words;
    }

    public String[] getTypedWords() {
        return typedWords;
    }

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public double getGrossWPM() {
        return grossWPM;
    }

    public double getNetWPM() {
        return netWPM;
    }

    public String getRawInput() {
        return rawInput;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public float getErrors() {
        return errors;
    }

    public Scanner getInput() {
        return this.input;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    //Setters
    public void setWords(String[] words) {
        this.words = words;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public void setErrors(float errors) {
        this.errors = errors;
    }

    public void setGrossWPM(double grossWPM) {
        this.grossWPM = grossWPM;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public void setNetWPM(double netWPM) {
        this.netWPM = netWPM;
    }

    public void setRawInput(String rawInput) {
        this.rawInput = rawInput;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public void setTypedWords(String[] typedWords) {
        this.typedWords = typedWords;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public void updateStats() {
        calculateAccuracy();
        calculateWPM();
    }


}

