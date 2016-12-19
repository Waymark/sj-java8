package se.waymark.education.exercises.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/*
 * For each exercise, develop a solution using java.time
 * and remove the @Ignore tag. Then run the test.
 */
public class TimeLab {

    // Exercise 1: Print the current date and time in ISO 8601 format (https://en.wikipedia.org/wiki/ISO_8601)

    @Test
    @Ignore
    public void printNow() {
        ZonedDateTime now = null; // TODO

        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
    }

    // Exercise 2:
    // * Format the JAN_31_2017_0755 ZonedDateTime object in full date and time format according to the French locale
    // * Format the JAN_31_2017_0755 ZonedDateTime object in medium local date format according to the German locale
    // * Format the JAN_31_2017_0755 ZonedDateTime object with the "H:mm MMMM d, uuuu" pattern using the Italian locale

    @Test
    @Ignore
    public void formatDateAndTime() {
        String frenchFullDateTime = null; // TODO

        String germanMediumDate = null; // TODO

        String italianPatternDate = null; // TODO

        Assert.assertEquals("mardi 31 janvier 2017 07 h 55 CET", frenchFullDateTime);
        Assert.assertEquals("31.01.2017", germanMediumDate);
        Assert.assertEquals("7:55 gennaio 31, 2017", italianPatternDate);
    }

    // Exercise 3: Create instances of LocalDate that represent the days before and after the LocalDate object
    // JAN_31_2017

    @Test
    @Ignore
    public void addAndSubtractDays() {
        LocalDate dayBefore = null; // TODO
        LocalDate dayAfter = null; // TODO

        Assert.assertEquals(JAN_31_2017.getDayOfYear() - 1, dayBefore.getDayOfYear());
        Assert.assertEquals(JAN_31_2017.getDayOfYear() + 1, dayAfter.getDayOfYear());
    }

    // Exercise 4: The constant YEARS_2000_2050 is a list of Longs representing all years from 2000 to 2050. Create a
    // list "leapYears" that contains all leap years in that interval.

    @Test
    @Ignore
    public void findLeapYears() {
        List<Long> leapYears = null; // TODO

        Assert.assertEquals(Arrays.asList(2000L, 2004L, 2008L, 2012L, 2016L, 2020L, 2024L,
                                          2028L, 2032L, 2036L, 2040L, 2044L, 2048L),
                            leapYears);
    }

    // Exercise 5: Create a list containing all even (day of month is even) Fridays in the DATES list of LocalDates.

    @Test
    @Ignore
    public void findEvenFridays() {
        List<LocalDate> evenFridays = null; // TODO

        Assert.assertEquals(
                Arrays.asList(LocalDate.of(2017, 2, 10), LocalDate.of(2017, 5, 26), LocalDate.of(2017, 6, 30),
                              LocalDate.of(2017, 8, 4), LocalDate.of(2017, 9, 8), LocalDate.of(2017, 12, 22),
                              LocalDate.of(2018, 1, 26), LocalDate.of(2018, 3, 2), LocalDate.of(2018, 4, 6)),
                evenFridays);
    }

    // Exercise 6: Midsummer's eve in Sweden is the Friday between the 19th and 25th of June. Write a method that takes
    // an integer parameter and returns a LocalDate representing midsummer's eve of the year corresponding to the
    // parameter value

    @Test
    @Ignore
    public void findSwedishMidsummer() {
        LocalDate midsummer2017 = findSwedishMidsummer(2017);
        LocalDate midsummer2018 = findSwedishMidsummer(2018);
        LocalDate midsummer2019 = findSwedishMidsummer(2019);
        LocalDate midsummer5BC = findSwedishMidsummer(-5);
        LocalDate midsummer3456 = findSwedishMidsummer(3456);

        Assert.assertEquals(
                LocalDate.of(2017, 6, 23),
                midsummer2017);
        Assert.assertEquals(
                LocalDate.of(2018, 6, 22),
                midsummer2018);
        Assert.assertEquals(
                LocalDate.of(2019, 6, 21),
                midsummer2019);
        Assert.assertEquals(
                LocalDate.of(-5, 6, 23),
                midsummer5BC);
        Assert.assertEquals(
                LocalDate.of(3456, 6, 20),
                midsummer3456);
    }

    private LocalDate findSwedishMidsummer(final int year) {
        return null; // TODO
    }

    // Exercise 7: Time zone operations:
    // * Use the JAN_31_2017_0755 constant to create a new ZonedDateTime object representing the same instant in
    //   India
    // * Use the JAN_31_2017_0755 constant to create a new ZonedDateTime object representing the same local time in
    //   India

    @Test
    @Ignore
    public void timeZoneOperations() {
        ZonedDateTime sameInstantInCa = null; // TODO
        ZonedDateTime sameLocalTimeInCa = null; // TODO

        Assert.assertEquals(ZonedDateTime.of(JAN_31_2017,
                                             LocalTime.of(12, 25),
                                             ZoneId.of("Asia/Kolkata")),
                            sameInstantInCa);
        Assert.assertEquals(ZonedDateTime.of(JAN_31_2017,
                                             LocalTime.of(7, 55),
                                             ZoneId.of("Asia/Kolkata")),
                            sameLocalTimeInCa);
    }

    // Exercise 8: Time units until a certain instant
    // * Calculate the number of minutes from JAN_31_2017_0755 to JAN_01_2018_0000
    // * Calculate the number of days from JAN_31_2017 to JAN_01_2018

    @Test
    @Ignore
    public void until() {
        long minutesUntilNewYears = 0; // TODO
        long daysUntilNewYears = 0; // TODO

        Assert.assertEquals(335L, daysUntilNewYears);
        Assert.assertEquals(481925L, minutesUntilNewYears);
    }

    // Exercise 9: Time zone and duration
    // * A plane bound for Tokyo leaves Los Angeles at 2017-04-02 07:45 local time. The flight takes 10 hours and 50
    //   minutes. Create a new ZonedDateTime object that represents the local scheduled arrival time in Tokyo and
    //   check if daylight savings time is in effect in Tokyo at that time.

    @Test
    @Ignore
    public void flightToTokyo() {
        ZonedDateTime departureTime = ZonedDateTime.of(LocalDate.of(2017, 4, 2),
                                                       LocalTime.of(7, 45),
                                                       ZoneId.of("America/Los_Angeles"));
        ZonedDateTime arrivalTime = null; // TODO
        Boolean isDaylightSavingsAtArrival = null; // TODO

        Assert.assertEquals(2017, arrivalTime.getYear());
        Assert.assertEquals(Month.APRIL, arrivalTime.getMonth());
        Assert.assertEquals(3, arrivalTime.getDayOfMonth());
        Assert.assertEquals(10, arrivalTime.getHour());
        Assert.assertEquals(35, arrivalTime.getMinute());
        Assert.assertEquals(ZoneOffset.ofHours(9), arrivalTime.getOffset());
        Assert.assertFalse(isDaylightSavingsAtArrival);
    }

    // ===== TEST INFRASTRUCTURE ==================================================

    private static final LocalDate JAN_01_2018 = LocalDate.of(2018, 1, 1);

    private static final LocalDate JAN_31_2017 = LocalDate.of(2017, 1, 31);

    private static final ZonedDateTime JAN_01_2018_0000 = ZonedDateTime.of(JAN_01_2018,
                                                                           LocalTime.of(0, 0),
                                                                           ZoneId.of("CET"));

    private static final ZonedDateTime JAN_31_2017_0755 = ZonedDateTime.of(JAN_31_2017,
                                                                           LocalTime.of(7, 55),
                                                                           ZoneId.of("CET"));

    private static final List<Long> YEARS_2000_2050 = LongStream.range(2000L, 2050L)
                                                                .boxed()
                                                                .collect(Collectors.toList());

    private static final List<LocalDate> DATES = IntStream.range(1, 500)
                                                          .filter(n -> n % 5 == 0)
                                                          .mapToObj(JAN_31_2017::plusDays)
                                                          .collect(Collectors.toList());

}
