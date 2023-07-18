package com.sexde.CodingChallengesSexde.Challenges;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.IntStream;

public final class ChallengeTwo {

    private ChallengeTwo () { }

    public static List<Integer> findTwoSum(final List<Integer> numbers, final int target) {

        final Map<Integer, Integer> auxMap = new HashMap<>();

        return Optional.ofNullable(numbers)
                        .map(list ->
                                IntStream
                                        .range(0, list.size())
                                        .boxed()
                                        .filter(i ->
                                                auxMap.containsKey(target - numbers.get(i))
                                                        || !Objects.isNull(auxMap.put(numbers.get(i), i))
                                        )
                                        .findFirst()
                                        .map(i -> List.of(i, auxMap.get(target - numbers.get(i))))
                                        .orElse(Collections.emptyList())
                        )
                .orElseThrow(InvalidParameterException::new);

    }

    public static List<Integer> findTwoSumParallelized(final List<Integer> numbers, final int target) {

        final Map<Integer, Integer> auxMap = new HashMap<>();

        return Optional.ofNullable(numbers)
                .map(list ->
                        IntStream
                                .range(0, list.size())
                                .boxed()
                                .parallel()
                                .filter(i ->
                                        auxMap.containsKey(target - numbers.get(i))
                                                || !Objects.isNull(auxMap.put(numbers.get(i), i))
                                )
                                .findAny()
                                .map(i -> List.of(i, auxMap.get(target - numbers.get(i))))
                                .orElse(Collections.emptyList())
                )
                .orElseThrow(InvalidParameterException::new);

    }

}
