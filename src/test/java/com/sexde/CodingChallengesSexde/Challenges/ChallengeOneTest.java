package com.sexde.CodingChallengesSexde.Challenges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ChallengeOneTest {

    @DisplayName("Test max numbers with correct array")
    @ParameterizedTest
    @MethodSource("argumentProvider")
    void testChallengeOneCorrectArray(final List<Integer> numbers) {

        assertEquals(
                numbers.get(numbers.size() - 1),
                ChallengeOne.getMaxSumOfAdjacentNumbers(
                        numbers
                                .stream()
                                .limit(numbers.size() - 1)
                                .collect(Collectors.toList())
                )
        );

    }

    static Stream<List<Integer>> argumentProvider() {

        return Stream.of(
                List.of(2, 1, 3, 0, 4),
                List.of(2, 4, 1, 5, 6, 3, 11),
                List.of(2, 4, 1, 5, 6, 3, 11, 14),
                List.of(20, -16, 10, 5, 15)
        );

    }

    @DisplayName("test max numbers with null array")
    @Test
    void testChallengeOneNullArray() {

        assertThrows(InvalidParameterException.class, () -> ChallengeOne.getMaxSumOfAdjacentNumbers(null));

    }

    @DisplayName("test max numbers with empty array")
    @Test
    void testChallengeOneEmptyArray() {

        assertThrows(InvalidParameterException.class, () -> ChallengeOne.getMaxSumOfAdjacentNumbers(Collections.emptyList()));

    }

    @DisplayName("test max numbers with array whose size is less than two")
    @Test
    void testChallengeOneSizeLessThanTwoArray() {

        assertThrows(InvalidParameterException.class, () -> ChallengeOne.getMaxSumOfAdjacentNumbers(List.of(1)));

    }


}
