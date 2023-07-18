package com.sexde.CodingChallengesSexde.Challenges;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public final class ChallengeOne {

    private ChallengeOne() { }

    public static Integer getMaxSumOfAdjacentNumbers(final List<Integer> numbers) {

        return
                Optional.ofNullable(numbers)
                                .flatMap(list ->
                                        IntStream
                                                .range(1, numbers.size())
                                                .boxed()
                                                .map(i -> numbers.get(i - 1) + numbers.get(i))
                                                .max(Integer::compareTo)
                                )
                        .orElseThrow(InvalidParameterException::new);
    }

    public static Integer getMaxSumOfAdjacentNumbersParallelized(final List<Integer> numbers) {

        return
                Optional.ofNullable(numbers)
                        .flatMap(list ->
                                IntStream
                                        .range(1, numbers.size())
                                        .boxed()
                                        .parallel()
                                        .map(i -> numbers.get(i - 1) + numbers.get(i))
                                        .max(Integer::compareTo)
                        )
                        .orElseThrow(InvalidParameterException::new);

    }

}
