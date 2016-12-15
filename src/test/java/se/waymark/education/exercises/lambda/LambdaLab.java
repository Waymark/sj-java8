package se.waymark.education.exercises.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
 * For each exercise, develop a solution and remove the @Ignore tag. Then run the test.
 */
public class LambdaLab {

    // Exercise 1: Use an anonymous inner class to implement a Comparator<String> that sorts strings by length (don't
    // bother making it null safe)

    @Ignore
    @Test
    public void writeClassicComparator() {
        Comparator<String> comparator = null;

        assertEquals(6, comparator.compare("13 chars long", "7 chars"));
        assertEquals(-6, comparator.compare("7 chars", "13 chars long"));
        assertEquals(0, comparator.compare("same", "same"));
    }

    // Exercise 2: Use a lambda expression to implement a Comparator<String> that sorts strings by length (don't bother
    // making it null safe)

    @Ignore
    @Test
    public void writeLambdaComparator() {
        Comparator<String> comparator = null;

        assertEquals(6, comparator.compare("13 chars long", "7 chars"));
        assertEquals(-6, comparator.compare("7 chars", "13 chars long"));
        assertEquals(0, comparator.compare("same", "same"));
    }

    // Exercise 3: Use an anonymous inner class to implement a Runnable that adds the string "run!" to the list addToMe

    @Ignore
    @Test
    public void writeClassicRunnable() {
        final List<String> addRunToMe = new ArrayList<>();

        Runnable runnable = null;

        runnable.run();

        assertEquals(1, addRunToMe.size());
        assertEquals("run!", addRunToMe.get(0));
    }

    // Exercise 4: Use a lambda expression to implement a Runnable that adds the string "run!" to the list addToMe

    @Ignore
    @Test
    public void writeRunnable() {
        final List<String> addRunToMe = new ArrayList<>();

        Runnable runnable = null;

        runnable.run();

        assertEquals(1, addRunToMe.size());
        assertEquals("run!", addRunToMe.get(0));
    }

    // Exercise 5: Use an anonymous inner class to implement a Predicate<String> that that checks if the fourth letter
    // of the argument is the capital letter "F"

    @Ignore
    @Test
    public void writeClassicPredicate() {
        Predicate<String> predicate = null;

        assertFalse(predicate.test("ABCDE"));
        assertTrue(predicate.test("CDEFG"));
    }

    // Exercise 6: Use a lambda expression to implement a Predicate<String> that that checks if the fourth letter
    // of the argument is the capital letter "F"

    @Ignore
    @Test
    public void writePredicate() {
        Predicate<String> predicate = null;

        assertFalse(predicate.test("ABCDE"));
        assertTrue(predicate.test("CDEFG"));
    }

}