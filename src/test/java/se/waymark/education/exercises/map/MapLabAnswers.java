package se.waymark.education.exercises.map;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/*
 * For each exercise, develop a solution using Java SE 8 Lambda/Streams
 * and remove the @Ignore tag. Then run the test.
 */
public class MapLabAnswers {

    // Exercise 1: Use Map#computeIfAbsent(K, Function<K, V>) to achieve the same result as in the manual example above

    @Test
    public void computeIfAbsent() throws Exception {
        Map<Integer, String> emptyMap = new HashMap<>();
        Map<Integer, String> mapWithValue = generateMapWithValue();

        Instant startPutToEmpty = Instant.now();
        emptyMap.computeIfAbsent(EXPENSIVE_STRING_KEY,
                                 this::expensiveOperation);
        Duration putToEmptyDuration = Duration.between(startPutToEmpty, Instant.now());

        Instant startPutMapWithValue = Instant.now();
        mapWithValue.computeIfAbsent(EXPENSIVE_STRING_KEY,
                                     this::expensiveOperation);
        Duration putToMapWithValueDuration = Duration.between(startPutMapWithValue, Instant.now());

        // Assert: First put is slow, second is fast
        Assert.assertTrue(putToEmptyDuration.getSeconds() >= 5);
        Assert.assertTrue(putToMapWithValueDuration.getSeconds() == 0);

        // Assert both values are correct
        Assert.assertEquals(EXPENSIVE_STRING_KEY + EXPENSIVE_STRING, emptyMap.get(EXPENSIVE_STRING_KEY));
        Assert.assertEquals("present", mapWithValue.get(EXPENSIVE_STRING_KEY));
    }

    private String expensiveOperation(final Integer input) {
        try {
            System.out.println("Doing really slow stuff...");
            Thread.sleep(5000L);
            System.out.println("...DONE!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return input + EXPENSIVE_STRING;
    }

    private Map<Integer, String> generateMapWithValue() {
        Map<Integer, String> mapWithValue = new HashMap<>();
        mapWithValue.put(EXPENSIVE_STRING_KEY, "present");
        return mapWithValue;
    }

    // ===== TEST INFRASTRUCTURE ==================================================

    private static final Integer EXPENSIVE_STRING_KEY = 123;
    private static final String EXPENSIVE_STRING = "This is the expensive string";

}