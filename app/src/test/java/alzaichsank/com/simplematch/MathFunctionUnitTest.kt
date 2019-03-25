package alzaichsank.com.simplematch

import alzaichsank.com.simplematch.view.math.MathActivity
import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import java.util.*
import java.util.logging.Logger

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MathFunctionUnitTest {

    /**
     * TEST 1
     * Sum X & Y, and print the result
     * Input : 1, 2
     * Output : 3
     */
    @Test
    fun sumTest() {
        val x = 1
        val y = 2
        val resultOperation = x + y
        assertEquals(3, resultOperation)
    }

    /**
     * TEST 2
     * Multiply X & Y, and print the result
     * Input : 1, 2
     * Output : 2
     */
    @Test
    fun multiplyTest() {
        val x = 1
        val y = 2
        val resultOperation = x * y
        assertEquals(2, resultOperation)
    }
    /**
     * TEST 3
     * Find first N prime number, and print the result
     * Input : 4
     * Output : 2, 3, 5, 7
     */
    @Test
    fun primeTest() {
        var resultList: MutableList<Int> = mutableListOf<Int>()
        val n = 4
        var status = 1
        var num = 3
        if (n >= 1) {
            //2 is a known prime number
            resultList.add(2)
        }

        var i = 2
        while (i <= n) {
            var j = 2
            while (j <= Math.sqrt(num.toDouble())) {
                if (num % j == 0) {
                    status = 0
                    break
                }
                j++
            }
            if (status != 0) {
                resultList.add(num)
                i++
            }
            status = 1
            num++
        }
        assertEquals(2, resultList[0])
        assertEquals(3, resultList[1])
        assertEquals(5, resultList[2])
        assertEquals(7, resultList[3])
    }
    /**
     * TEST 4
     * Find first N Fibonacci sequence, and print the result
     * Input : 4
     * Output : 0, 1, 1, 2
     */
    @Test
    fun fiboTest() {
        var resultList: MutableList<Int> = mutableListOf<Int>()
        val x = 4
        var fib1 = 0
        var fib2 = 1
        for (i in 0 until x) {
            resultList.add(fib1)
            val sum = fib1 + fib2
            fib1 = fib2
            fib2 = sum
        }
        assertEquals(0, resultList[0])
        assertEquals(1, resultList[1])
        assertEquals(1, resultList[2])
        assertEquals(2, resultList[3])
    }
}
