package com.sexde.CodingChallengesSexde.Challenges;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public final class ChallengeOne {

    private ChallengeOne() { }

    public static Integer getMaxSumOfAdjacentNumbers(final List<Integer> numbers) {

        if (Objects.isNull(numbers)) {
            throw new InvalidParameterException("Number list cannot be null.");
        }

        return
                IntStream
                        .range(1, numbers.size())
                        .mapToObj(i ->
                                new ArrayList<>(
                                        List.of(
                                                numbers.get(i - 1),
                                                numbers.get(i)
                                        )
                                )
                        )
                        .map(pairList ->
                                pairList
                                        .stream()
                                        .mapToInt(Integer::intValue)
                                        .sum()
                        )
                        .max(Integer::compareTo)
                        .orElseThrow(() -> new InvalidParameterException("Cannot operate with items whose size is less than two."));

    }


}