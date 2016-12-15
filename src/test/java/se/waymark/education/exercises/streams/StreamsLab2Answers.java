package se.waymark.education.exercises.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/*
 * Adapted from:
 * HOL3970 - Lambda Programming Lab
 * JavaOne San Francisco 2013
 *
 * For each exercise, develop a solution using Java SE 8 Lambda/Streams
 * and remove the @Ignore tag. Then run the test.
 */
public class StreamsLab2Answers {

    // Exercise 1: Convert all words in WORD_LIST to upper case,
    // and gather the result into an output list.

    @Test
    public void upperCaseWords() {
        List<String> output = WORD_LIST.stream()
                                      .map(String::toUpperCase)
                                      .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
                        "EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE",
                        "CAN", "BE", "SOLVED", "BY", "ADDING", "ANOTHER",
                        "LEVEL", "OF", "INDIRECTION"),
                output);
    }

    // Exercise 2: Find all the words in WORD_LIST that have even length
    // and put them into an output list.

    @Test
    public void findEvenLengthWords() {
        List<String> output = WORD_LIST.stream()
                                      .filter(word -> word.length() % 2 == 0)
                                      .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
                        "in", "computer", "be", "solved", "by", "adding", "of"),
                output);
    }

    // Exercise 3: Count the number of lines in a file. The field *reader*
    // is a BufferedReader which will be opened for you on the text file.
    // See the JUnit @Before and @After methods at the bottom of this file.
    // The text file is "SonnetI.txt" (Shakespeare's first sonnet).

    @Test
    public void countLinesInFile() throws IOException {
        long count = reader.lines()
                           .count();

        assertEquals(14, count);
    }

    // Exercise 4: Join lines 3-4 from the text file into a single string.

    @Test
    public void joinLineRange() throws IOException {
        String output = reader.lines()
                              .skip(2)
                              .limit(2)
                              .collect(Collectors.joining());

        assertEquals("But as the riper should by time decease," +
                             "His tender heir might bear his memory:",
                     output);
    }

    // Exercise 5: Find the length of the longest line in the file.

    @Test
    public void lengthOfLongestLine() throws IOException {
        int longest = reader.lines()
                            .mapToInt(String::length)
                            .max()
                            .orElse(0);

        assertEquals(longest, 53);
    }

    // Exercise 6: Collect all the words from the text file into a list.
    // Hint: use String.split(REGEXP) to split a string into words.
    // Splitting this way results in "words" that are the empty string,
    // which should be discarded. REGEXP is defined at the bottom of this file.

    @Test
    public void listOfAllWords() throws IOException {
        final Pattern pattern = Pattern.compile(REGEXP);
        List<String> output = reader.lines()
                                    .flatMap(pattern::splitAsStream)
                                    .filter(word -> !word.isEmpty())
                                    .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
                        "From", "fairest", "creatures", "we", "desire", "increase",
                        "That", "thereby", "beauty", "s", "rose", "might", "never", "die",
                        "But", "as", "the", "riper", "should", "by", "time", "decease",
                        "His", "tender", "heir", "might", "bear", "his", "memory", "But",
                        "thou", "contracted", "to", "thine", "own", "bright", "eyes",
                        "Feed", "st", "thy", "light", "s", "flame", "with", "self",
                        "substantial", "fuel", "Making", "a", "famine", "where",
                        "abundance", "lies", "Thy", "self", "thy", "foe", "to", "thy",
                        "sweet", "self", "too", "cruel", "Thou", "that", "art", "now",
                        "the", "world", "s", "fresh", "ornament", "And", "only", "herald",
                        "to", "the", "gaudy", "spring", "Within", "thine", "own", "bud",
                        "buriest", "thy", "content", "And", "tender", "churl", "mak",
                        "st", "waste", "in", "niggarding", "Pity", "the", "world", "or",
                        "else", "this", "glutton", "be", "To", "eat", "the", "world", "s",
                        "due", "by", "the", "grave", "and", "thee"),
                output);
    }

    // Exercise 7: Create a list containing the words, lowercased, in alphabetical order.

    @Test
    public void sortedLowerCase() throws IOException {
        final Pattern pattern = Pattern.compile(REGEXP);
        List<String> output = reader.lines()
                                    .flatMap(pattern::splitAsStream)
                                    .map(String::toLowerCase)
                                    .filter(word -> !word.isEmpty())
                                    .sorted()
                                    .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
                        "a", "abundance", "and", "and", "and", "art", "as", "be",
                        "bear", "beauty", "bright", "bud", "buriest", "but", "but",
                        "by", "by", "churl", "content", "contracted", "creatures",
                        "cruel", "decease", "desire", "die", "due", "eat", "else",
                        "eyes", "fairest", "famine", "feed", "flame", "foe", "fresh",
                        "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald",
                        "his", "his", "in", "increase", "lies", "light", "mak",
                        "making", "memory", "might", "might", "never", "niggarding",
                        "now", "only", "or", "ornament", "own", "own", "pity",
                        "riper", "rose", "s", "s", "s", "s", "self", "self", "self",
                        "should", "spring", "st", "st", "substantial", "sweet",
                        "tender", "tender", "that", "that", "the", "the", "the",
                        "the", "the", "the", "thee", "thereby", "thine", "thine",
                        "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy",
                        "time", "to", "to", "to", "to", "too", "waste", "we", "where",
                        "with", "within", "world", "world", "world"),
                output);
    }

    // Exercise 8: Sort unique, lower-cased words by length, then alphabetically
    // within length, and place the result into an output list.

    @Test
    public void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
        final Pattern pattern = Pattern.compile(REGEXP);
        List<String> output = reader.lines()
                                    .flatMap(pattern::splitAsStream)
                                    .map(String::toLowerCase)
                                    .filter(word -> !word.isEmpty())
                                    .distinct()
                                    .sorted(Comparator.comparing(String::length)
                                                      .thenComparing(Comparator.naturalOrder()))
                                    .collect(Collectors.toList());

        assertEquals(
                Arrays.asList(
                        "a", "s", "as", "be", "by", "in", "or", "st", "to", "we",
                        "and", "art", "bud", "but", "die", "due", "eat", "foe", "his",
                        "mak", "now", "own", "the", "thy", "too", "bear", "else",
                        "eyes", "feed", "from", "fuel", "heir", "lies", "only",
                        "pity", "rose", "self", "that", "thee", "this", "thou",
                        "time", "with", "churl", "cruel", "flame", "fresh", "gaudy",
                        "grave", "light", "might", "never", "riper", "sweet", "thine",
                        "waste", "where", "world", "beauty", "bright", "desire",
                        "famine", "herald", "making", "memory", "should", "spring",
                        "tender", "within", "buriest", "content", "decease",
                        "fairest", "glutton", "thereby", "increase", "ornament",
                        "abundance", "creatures", "contracted", "niggarding",
                        "substantial"),
                output);
    }

    // Exercise 9: Categorize the words into a map, where the map's key is
    // the length of each word, and the value corresponding to a key is a
    // list of words of that length. Don't bother with uniqueness or lower-
    // casing the words.

    @Test
    public void mapLengthToWordList() throws IOException {
        final Pattern pattern = Pattern.compile(REGEXP);
        Map<Integer, List<String>> map = reader.lines()
                                               .flatMap(pattern::splitAsStream)
                                               .filter(word -> !word.isEmpty())
                                               .collect(Collectors.groupingBy(String::length));

        assertEquals(6, map.get(7).size());
        assertEquals(Arrays.asList("increase", "ornament"), map.get(8));
        assertEquals(Arrays.asList("creatures", "abundance"), map.get(9));
        assertEquals(Arrays.asList("contracted", "niggarding"), map.get(10));
        assertEquals(Collections.singletonList("substantial"), map.get(11));
        assertFalse(map.containsKey(12));

    }

    @Test
    public void classicMapLengthToWordList() throws IOException {
        Map<Integer, List<String>> map = new HashMap<>();
        String line;

        List<String> words;

        while ((line = reader.readLine()) != null) {
            words = Arrays.asList(line.split(REGEXP));

            for (String word : words) {
                if (!word.isEmpty()) {
                    List<String> value = map.get(word.length());
                    if (value == null) {
                        value = new ArrayList<>();
                        map.put(word.length(), value);
                    }
                    value.add(word);
                }
            }
        }

        assertEquals(6, map.get(7).size());
        assertEquals(Arrays.asList("increase", "ornament"), map.get(8));
        assertEquals(Arrays.asList("creatures", "abundance"), map.get(9));
        assertEquals(Arrays.asList("contracted", "niggarding"), map.get(10));
        assertEquals(Collections.singletonList("substantial"), map.get(11));
        assertFalse(map.containsKey(12));
    }

    // Exercise 10: Gather the words into a map, accumulating a count of the
    // number of occurrences of each word. Don't worry about upper case and
    // lower case.

    @Test
    public void wordFrequencies() throws IOException {
        final Pattern pattern = Pattern.compile(REGEXP);
        Map<String, Long> map = reader.lines()
                                      .flatMap(pattern::splitAsStream)
                                      .filter(word -> !word.isEmpty())
                                      .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        assertEquals(2L, (long) map.get("tender"));
        assertEquals(6L, (long) map.get("the"));
        assertEquals(1L, (long) map.get("churl"));
        assertEquals(2L, (long) map.get("thine"));
        assertEquals(3L, (long) map.get("world"));
        assertFalse(map.containsKey("lambda"));

    }

    @Test
    public void wordFrequenciesAlternativeSolution() throws IOException {
        // OR
        final Pattern pattern = Pattern.compile(REGEXP);
        Map<String, Long> map = reader.lines()
                                      .flatMap(pattern::splitAsStream)
                                      .filter(word -> !word.isEmpty())
                                      .collect(Collectors.toMap(Function.identity(),
                                                                word -> 1L,
                                                                Long::sum));

        assertEquals(2L, (long) map.get("tender"));
        assertEquals(6L, (long) map.get("the"));
        assertEquals(1L, (long) map.get("churl"));
        assertEquals(2L, (long) map.get("thine"));
        assertEquals(3L, (long) map.get("world"));
        assertFalse(map.containsKey("lambda"));
    }

    // Exercise 11: Create a nested grouping, where the outer map is a map
    // from the first letter of the word to a submap. (Use a string of length
    // one as the key.) The submap, in turn, is a mapping from the length of the
    // word to a list of words with that length. Don't bother with any downcasing
    // or uniquifying of the words.
    //
    // For example, given the words "foo bar baz bazz" the top level map would have
    // a keys of "f" and "b". The value corresponding to "b" would be a map with
    // a key of 3 with a value of [bar baz] (a list of Strings) and a key of 4
    // with a value of [bazz] (a one-element list of String).

    @Test
    public void nestedGrouping() throws IOException {
        final Pattern pattern = Pattern.compile(REGEXP);
        Map<String, Map<Integer, List<String>>> map = reader.lines()
                                                            .flatMap(pattern::splitAsStream)
                                                            .filter(word -> !word.isEmpty())
                                                            .collect(Collectors.groupingBy(word -> word.substring(0, 1),
                                                                                           Collectors.groupingBy(
                                                                                                   String::length)));

        assertEquals("[From, Feed]", map.get("F").get(4).toString());
        assertEquals("[by, be, by]", map.get("b").get(2).toString());
        assertEquals("[the, thy, thy, thy, too, the, the, thy, the, the, the]",
                     map.get("t").get(3).toString());
        assertEquals("[beauty, bright]", map.get("b").get(6).toString());
    }

    @Test
    public void classisNestedGrouping() throws IOException {
        Map<String, Map<Integer, List<String>>> map = new HashMap<>();

        String line;
        List<String> words;

        while ((line = reader.readLine()) != null) {
            words = Arrays.asList(line.split(REGEXP));

            for (String word : words) {
                if (!word.isEmpty()) {
                    String firstLetter = word.substring(0, 1);
                    int wordLength = word.length();

                    Map<Integer, List<String>> innerMap = map.get(firstLetter);

                    if (innerMap == null) {
                        innerMap = new HashMap<>();
                        map.put(firstLetter, innerMap);
                    }

                    List<String> matchingWords = innerMap.get(wordLength);

                    if (matchingWords == null) {
                        matchingWords = new ArrayList<>();
                        innerMap.put(wordLength, matchingWords);
                    }

                    innerMap.get(wordLength).add(word);
                }
            }
        }

        assertEquals("[From, Feed]", map.get("F").get(4).toString());
        assertEquals("[by, be, by]", map.get("b").get(2).toString());
        assertEquals("[the, thy, thy, thy, too, the, the, thy, the, the, the]",
                     map.get("t").get(3).toString());
        assertEquals("[beauty, bright]", map.get("b").get(6).toString());
    }

    // ===== TEST INFRASTRUCTURE ==================================================

    private static List<String> WORD_LIST = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection");

    private static final String REGEXP = "\\W+"; // for splitting into words

    private BufferedReader reader;

    @Before
    public void setUpBufferedReader() throws IOException, URISyntaxException {
        URL file = getClass().getResource("/SonnetI.txt");

        reader = Files.newBufferedReader(
                Paths.get(file.toURI()), StandardCharsets.UTF_8);
    }

    @After
    public void closeBufferedReader() throws IOException {
        reader.close();
    }
}