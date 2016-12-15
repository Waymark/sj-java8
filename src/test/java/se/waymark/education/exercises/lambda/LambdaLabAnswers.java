package se.waymark.education.exercises.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LambdaLabAnswers {

    // Exercise 1: Use an anonymous inner class to implement a Comparator<String> that sorts strings by length (don't
    // bother making it null safe)

    @Test
    public void writeClassicComparator() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        assertEquals(6, comparator.compare("13 chars long", "7 chars"));
        assertEquals(-6, comparator.compare("7 chars", "13 chars long"));
        assertEquals(0, comparator.compare("same", "same"));
    }

    // Exercise 2: Use a lambda expression to implement a Comparator<String> that sorts strings by length (don't bother
    // making it null safe)

    @Test
    public void writeLambdaComparator() {
        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
        // Or
        // comparator = Comparator.comparingInt(String::length);

        assertEquals(6, comparator.compare("13 chars long", "7 chars"));
        assertEquals(-6, comparator.compare("7 chars", "13 chars long"));
        assertEquals(0, comparator.compare("same", "same"));
    }

    // Exercise 3: Use an anonymous inner class to implement a Runnable that adds the string "run!" to the list addToMe

    @Test
    public void writeClassicRunnable() {
        final List<String> addRunToMe = new ArrayList<>();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                addRunToMe.add("run!");
            }
        };

        runnable.run();

        assertEquals(1, addRunToMe.size());
        assertEquals("run!", addRunToMe.get(0));
    }

    // Exercise 4: Use a lambda expression to implement a Runnable that adds the string "run!" to the list addToMe

    @Test
    public void writeRunnable() {
        final List<String> addRunToMe = new ArrayList<>();

        Runnable runnable = () -> addRunToMe.add("run!");

        runnable.run();

        assertEquals(1, addRunToMe.size());
        assertEquals("run!", addRunToMe.get(0));
    }

    // Exercise 5: Use an anonymous inner class to implement a Predicate<String> that that checks if the fourth letter
    // of the argument is the capital letter "F"

    @Test
    public void writeClassicPredicate() {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.charAt(3) == 'F';
            }
        };

        assertFalse(predicate.test("ABCDE"));
        assertTrue(predicate.test("CDEFG"));
    }

    // Exercise 6: Use a lambda expression to implement a Predicate<String> that that checks if the fourth letter
    // of the argument is the capital letter "F"

    @Test
    public void writePredicate() {
        Predicate<String> predicate = s -> s.charAt(3) == 'F';

        assertFalse(predicate.test("ABCDE"));
        assertTrue(predicate.test("CDEFG"));
    }

}