package fr.soat.cleancoders.exo1;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class MatcherTest {
    private final int clipLimit = 100;
    private final int delta = 5;
    private Matcher matcher;
    private int[] expected;

    @Before
    public void initialize_common_variables() {
        matcher = new Matcher();
        expected = new int[]{10, 50, 30, 98};
    }

    @Test
    public void should_match_when_the_difference_between_the_actual_entry_and_the_expected_one_is_below_delta() {
        //Given
        int[] actual = new int[]{12, 55, 25, 110};

        //When
        boolean matches = matcher.match(expected, actual, clipLimit, delta);

        //Then
        Assertions.assertThat(matches).isTrue();

    }

    @Test
    public void should_not_match_when_the_difference_between_the_actual_entry_and_the_expected_one_is_above_delta() {
        //Given
        int[] actual = new int[]{10, 60, 30, 98};

        //When
        boolean matches = matcher.match(expected, actual, clipLimit, delta);

        //Then
        Assertions.assertThat(matches).isFalse();

    }

    @Test
    public void should_not_match_when_the_actual_and_the_expected_have_different_length() {
        //Given
        int[] actual = new int[]{10, 50, 30};

        //When
        boolean matches = matcher.match(expected, actual, clipLimit, delta);

        //Then
        Assertions.assertThat(matches).isFalse();

    }
}