package com.sexde.CodingChallengesSexde.Challenges;

import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChallengeOneBenchmark {

    private static final List<Integer> LARGE_NUMBER_LIST =
            new Random()
                    .ints()
                    .boxed()
                    .limit(999999)
                    .toList();

    private static final List<Integer> SMALL_NUMBER_LIST =
            new Random()
                    .ints()
                    .boxed()
                    .limit(10)
                    .toList();

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer benchmarkChallengeOneWithLargeList() {

        return ChallengeOne.getMaxSumOfAdjacentNumbers(LARGE_NUMBER_LIST);

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer benchmarkChallengeOneWithSmallList() {

        return ChallengeOne.getMaxSumOfAdjacentNumbers(SMALL_NUMBER_LIST);

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer benchmarkChallengeParallelizedOneWithLargeList() {

        return ChallengeOne.getMaxSumOfAdjacentNumbers(LARGE_NUMBER_LIST);

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public Integer benchmarkChallengeParallelizedOneWithSmallList() {

        return ChallengeOne.getMaxSumOfAdjacentNumbers(SMALL_NUMBER_LIST);

    }


}
