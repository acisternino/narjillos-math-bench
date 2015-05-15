/*
 * Copyright (c) 2015 Andrea Cisternino
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package org.nusco.narjillos.jmh;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class FastMathSinCosBenchmark {

    static {
        org.nusco.narjillos.core.physics.FastMath.setUp();
    }

    @Param({"0", "5", "30", "45", "60", "85", "90"})
    private double x;

    //---- sin(x) ---------------------------------------------------

    @Benchmark
    public double baselineSin() {
        return Math.sin(x);
    }

    @Benchmark
    public double narjillosFastMathSin() {
        return org.nusco.narjillos.core.physics.FastMath.sin(x);
    }

    @Benchmark
    public double commonsFastMathSin() {
        return org.apache.commons.math3.util.FastMath.sin(x);
    }

    //---- cos(x) ---------------------------------------------------

    @Benchmark
    public double baselineCos() {
        return Math.cos(x);
    }

    @Benchmark
    public double narjillosFastMathCos() {
        return org.nusco.narjillos.core.physics.FastMath.cos(x);
    }

    @Benchmark
    public double commonsFastMathCos() {
        return org.apache.commons.math3.util.FastMath.cos(x);
    }

}
