package se.waymark.education.exercises.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
 * For each exercise, develop a solution using Java SE 8 Lambda/Streams
 * and remove the @Ignore tag. Then run the test.
 */
public class StreamsLab1Answers {

    // Exercise 1: Create a Stream of the words in the WORD_LIST constant that are shorter than 4 characters

    @Test
    public void filter() throws Exception {
        Stream<String> shorterThanFour = WORD_LIST.stream()
                                                  .filter(string -> string.length() < 4);

        Assert.assertEquals("in, can, be, by, of", shorterThanFour.collect(Collectors.joining(", ")));
    }

    // Exercise 2: Create a Stream of the words in the WORD_LIST constant that are longer than 4 characters
    // and start with the letter "a"

    @Test
    public void twoFilters() throws Exception {
        Stream<String> longerThanFourAndStartsWithAnA = WORD_LIST.stream()
                                                                 .filter(string -> string.length() > 4)
                                                                 .filter(string -> string.startsWith("a"));

        Assert.assertEquals("adding, another", longerThanFourAndStartsWithAnA.collect(Collectors.joining(", ")));
    }

    // Exercise 3: Create a Stream of the first character of each word in the WORD_LIST constant

    @Test
    public void mapToCharacter() throws Exception {
        Stream<Character> firstCharacters = WORD_LIST.stream()
                                                     .map(string -> string.charAt(0));

        Assert.assertEquals("e, p, i, c, s, c, b, s, b, a, a, l, o, i",
                            firstCharacters.map(String::valueOf)
                                           .collect(Collectors.joining(", ")));
    }

    // Exercise 4: Create a Stream containing the first letter of every word with an even number of letters in the
    // WORD_LIST constant

    @Test
    public void mapAndFilter() throws Exception {
        Stream<Character> evenLengthWordFirstCharacters = WORD_LIST.stream()
                                                                   .filter(string -> string.length() % 2 == 0)
                                                                   .map(string -> string.charAt(0));

        Assert.assertEquals("i, c, b, s, b, a, o",
                            evenLengthWordFirstCharacters.map(String::valueOf)
                                                         .collect(Collectors.joining(", ")));
    }

    // Exercise 5: Create a Stream from an Array of BigDecimals

    @Test
    public void streamFromArray() throws IOException {
        BigDecimal big1 = BigDecimal.ONE;
        BigDecimal big2 = big1.add(BigDecimal.ONE);
        BigDecimal big3 = big2.add(BigDecimal.ONE);
        BigDecimal big4 = big3.add(BigDecimal.ONE);
        BigDecimal[] bigArray = new BigDecimal[]{big1, big2, big3, big4};

        Stream<BigDecimal> bigStream = Stream.of(bigArray);
        // OR
        Stream<BigDecimal> bigStream2 = Arrays.stream(bigArray);

        assertEquals(Arrays.asList(big1, big2, big3, big4),
                     bigStream.collect(Collectors.toList()));
        assertEquals(Arrays.asList(big1, big2, big3, big4),
                     bigStream2.collect(Collectors.toList()));
    }

    // Exercise 6: Create a Stream of individual words from the comma-separated string of words in the
    // constant WORDS

    @Test
    public void splitStringIntoStream() throws IOException {
        Stream<String> splitStream = Stream.of(WORDS.split(","));

        // OR
        Stream<String> splitStream2 = Arrays.stream(WORDS.split(","));

        // OR
        Pattern pattern = Pattern.compile(",");
        Stream<String> splitStream3 = pattern.splitAsStream(WORDS);

        assertEquals(WORD_LIST, splitStream.collect(Collectors.toList()));
        assertEquals(WORD_LIST, splitStream2.collect(Collectors.toList()));
        assertEquals(WORD_LIST, splitStream3.collect(Collectors.toList()));
    }

    // Exercise 7: Put the lines of the file "SonnetI.txt" into a Stream.
    // The field "reader" is a BufferedReader which will be opened for you
    // on the text file. See the JUnit @Before and @After methods at the
    // bottom of this file.

    @Test
    public void countLinesInFile() throws IOException {
        Stream<String> linesInFile = reader.lines();

        assertEquals(Arrays.asList(
                "From fairest creatures we desire increase,",
                "That thereby beauty's rose might never die,",
                "But as the riper should by time decease,",
                "His tender heir might bear his memory:",
                "But thou contracted to thine own bright eyes,",
                "Feed'st thy light's flame with self-substantial fuel,",
                "Making a famine where abundance lies,",
                "Thy self thy foe, to thy sweet self too cruel:",
                "Thou that art now the world's fresh ornament,",
                "And only herald to the gaudy spring,",
                "Within thine own bud buriest thy content,",
                "And, tender churl, mak'st waste in niggarding:",
                "   Pity the world, or else this glutton be,",
                "   To eat the world's due, by the grave and thee."
        ), linesInFile.collect(Collectors.toList()));
    }

    // Exercise 8: Create a Stream of 50 random integers

    @Test
    public void randomIntegers() throws IOException {
        IntStream random = new Random().ints(50);

        assertEquals(50L, random.distinct()
                                .count());
    }

    // ===== TEST INFRASTRUCTURE ==================================================

    private static List<String> WORD_LIST = Arrays.asList(
            "every", "problem", "in", "computer", "science",
            "can", "be", "solved", "by", "adding", "another",
            "level", "of", "indirection");

    private static final String WORDS = WORD_LIST.stream()
                                                 .collect(Collectors.joining(","));

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
