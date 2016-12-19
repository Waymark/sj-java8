package se.waymark.education.exercises.combinations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

/*
 * For each exercise, develop a solution and remove the @Ignore tag. Then run the test.
 */
public class PredicatesAndFunctionsLabAnswers {

    // Exercise 1:
    //  * Write a function that doubles the value of a given integer
    //  * Write a function that increases the value of a given integer by 5

    @Test
    public void basicIntegerFunctions() throws Exception {
        Function<Integer, Integer> doubler = n -> 2 * n;
        Function<Integer, Integer> addFive = n -> 5 + n;

        Assert.assertThat(doubler.apply(2), is(4));
        Assert.assertThat(doubler.apply(24), is(48));
        Assert.assertThat(doubler.apply(-8), is(-16));

        Assert.assertThat(addFive.apply(2), is(7));
        Assert.assertThat(addFive.apply(24), is(29));
        Assert.assertThat(addFive.apply(-8), is(-3));
    }

    // Exercise 2: Use the functions written in Exercise 1 and combine them into:
    //  * A function that first adds five to the argument and then doubles the result
    //  * A function that first doubles the argument and then adds five to the result

    @Test
    public void combineBasicIntegerFunctions() throws Exception {
        Function<Integer, Integer> doubler = n -> 2 * n;
        Function<Integer, Integer> addFive = n -> 5 + n;

        Function<Integer, Integer> doubleThenAddFive = doubler.andThen(addFive);
        Function<Integer, Integer> addFiveThenDouble = doubler.compose(addFive); // Or: addFive.andThen(doubler)

        Assert.assertThat(doubleThenAddFive.apply(2), is(9));
        Assert.assertThat(doubleThenAddFive.apply(-4), is(-3));

        Assert.assertThat(addFiveThenDouble.apply(2), is(14));
        Assert.assertThat(addFiveThenDouble.apply(-4), is(2));
    }

    // Exercise 3:
    //  * Write a predicate that checks if a given integer is even
    //  * Write a predicate that checks if a given integer greater than 11

    @Test
    public void basicIntegerPredicates() throws Exception {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThanEleven = n -> n > 11;

        List<Integer> evenIntegers = IntStream.range(1, 21)
                                              .boxed()
                                              .filter(isEven)
                                              .collect(Collectors.toList());

        List<Integer> greaterThanEleven = IntStream.range(1, 21)
                                                   .boxed()
                                                   .filter(isGreaterThanEleven)
                                                   .collect(Collectors.toList());

        Assert.assertThat(evenIntegers,
                          is(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)));
        Assert.assertThat(greaterThanEleven,
                          is(Arrays.asList(12, 13, 14, 15, 16, 17, 18, 19, 20)));
    }

    // Exercise 4: Use the predicates written in Exercise 3 and combine them into:
    //  * A predicate that checks if the argument is even and greater than 11
    //  * A predicate that checks if the argument is even or greater than 11
    //  * A predicate that checks if the argument is even and not greater than 11
    //  * A predicate that checks if the argument is neither even nor greater than 11

    @Test
    public void combineBasicIntegerPredicates() throws Exception {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThanEleven = n -> n > 11;

        Predicate<Integer> isEvenAndGreaterThanEleven = isEven.and(isGreaterThanEleven);
        Predicate<Integer> isEvenOrGreaterThanEleven = isEven.or(isGreaterThanEleven);
        Predicate<Integer> isEvenAndNotGreaterThanEleven = isEven.and(isGreaterThanEleven.negate());
        Predicate<Integer> isNeitherEvenOrGreaterThanEleven = isEven.negate().and(isGreaterThanEleven.negate());

        List<Integer> evenIntegersGreaterThanEleven = IntStream.range(1, 21)
                                                               .boxed()
                                                               .filter(isEvenAndGreaterThanEleven)
                                                               .collect(Collectors.toList());

        List<Integer> evenOrGreaterThanElevenIntegers = IntStream.range(1, 21)
                                                                 .boxed()
                                                                 .filter(isEvenOrGreaterThanEleven)
                                                                 .collect(Collectors.toList());

        List<Integer> evenNotGreaterThanElevenIntegers = IntStream.range(1, 21)
                                                                  .boxed()
                                                                  .filter(isEvenAndNotGreaterThanEleven)
                                                                  .collect(Collectors.toList());

        List<Integer> neitherEvenNorGreaterThanElevenIntegers = IntStream.range(1, 21)
                                                                         .boxed()
                                                                         .filter(isNeitherEvenOrGreaterThanEleven)
                                                                         .collect(Collectors.toList());

        Assert.assertThat(evenIntegersGreaterThanEleven,
                          is(Arrays.asList(12, 14, 16, 18, 20)));
        Assert.assertThat(evenOrGreaterThanElevenIntegers,
                          is(Arrays.asList(2, 4, 6, 8, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20)));
        Assert.assertThat(evenNotGreaterThanElevenIntegers,
                          is(Arrays.asList(2, 4, 6, 8, 10)));
        Assert.assertThat(neitherEvenNorGreaterThanElevenIntegers,
                          is(Arrays.asList(1, 3, 5, 7, 9, 11)));
    }

}
