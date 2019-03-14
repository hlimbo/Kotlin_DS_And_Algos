import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter1_2Test : FunSpec({
    val dp = Chapter1_2()

    test("First Test Case") {
        val arr = arrayListOf(3, 7, 5, 6, 9)

        val expectedAns = Pair(1, 3)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Second Test Case - 0 values") {
        val arr = ArrayList<Int>()

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 1 value") {
        val arr = ArrayList<Int>()
        arr.add(1)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 2 values") {
        val arr = ArrayList<Int>()
        arr.add(1)
        arr.add(2)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 2 values part 2") {
        val arr = ArrayList<Int>()
        arr.add(2)
        arr.add(1)

        val expectedAns = Pair(0, 2)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Fourth Test Case") {
        val arr = arrayListOf(1, 2, 3, 9, 6, 4, 2)

        val expectedAns = Pair(1, 7)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Fifth Test Case") {
        val arr = arrayListOf(1, 2, 3, 9, 6, 4, 1)

        val expectedAns = Pair(0, 7)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Sixth Test Case - Fully Sorted") {
        val arr = arrayListOf(1, 2, 3, 4, 9)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Seventh Test Case") {
        val arr = arrayListOf(3, 1, 2, 6, 7, 8, 9)

        val expectedAns = Pair(0, 3)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Eighth Test Case") {
        val arr = arrayListOf(1, 2, 3, 5, 4, 3, 6, 7, 8)

        val expectedAns = Pair(3, 6)
        val actualAns: Pair<Int, Int> = dp.locateSmallestSortingWindow(arr)
        actualAns.shouldBe(expectedAns)
    }
})

class Chapter1_2TestEfficientImplementation : FunSpec({
    val dp = Chapter1_2()

    test("First Test Case") {
        val arr = arrayListOf(3, 7, 5, 6, 9)

        val expectedAns = Pair(1, 3)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Second Test Case - 0 values") {
        val arr = ArrayList<Int>()

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 1 value") {
        val arr = ArrayList<Int>()
        arr.add(1)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 2 values") {
        val arr = ArrayList<Int>()
        arr.add(1)
        arr.add(2)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 2 values part 2") {
        val arr = ArrayList<Int>()
        arr.add(2)
        arr.add(1)

        val expectedAns = Pair(0, 2)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Fourth Test Case") {
        val arr = arrayListOf(1, 2, 3, 9, 6, 4, 2)

        val expectedAns = Pair(1, 7)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Fifth Test Case") {
        val arr = arrayListOf(1, 2, 3, 9, 6, 4, 1)

        val expectedAns = Pair(0, 7)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Sixth Test Case - Fully Sorted") {
        val arr = arrayListOf(1, 2, 3, 4, 9)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Seventh Test Case") {
        val arr = arrayListOf(3, 1, 2, 6, 7, 8, 9)

        val expectedAns = Pair(0, 3)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Eighth Test Case") {
        val arr = arrayListOf(1, 2, 3, 5, 4, 3, 6, 7, 8)

        val expectedAns = Pair(3, 6)
        val actualAns: Pair<Int, Int> = dp.window(arr)
        actualAns.shouldBe(expectedAns)
    }
})

class Chapter1_2TestCorrect : FunSpec({
    val dp = Chapter1_2()

    test("First Test Case") {
        val arr = arrayListOf(3, 7, 5, 6, 9)

        val expectedAns = Pair(1, 3)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Second Test Case - 0 values") {
        val arr = ArrayList<Int>()

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 1 value") {
        val arr = ArrayList<Int>()
        arr.add(1)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 2 values") {
        val arr = ArrayList<Int>()
        arr.add(1)
        arr.add(2)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Third Test Case - 2 values part 2") {
        val arr = ArrayList<Int>()
        arr.add(2)
        arr.add(1)

        val expectedAns = Pair(0, 2)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Fourth Test Case") {
        val arr = arrayListOf(1, 2, 3, 9, 6, 4, 2)

        val expectedAns = Pair(1, 7)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Fifth Test Case") {
        val arr = arrayListOf(1, 2, 3, 9, 6, 4, 1)

        val expectedAns = Pair(0, 7)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Sixth Test Case - Fully Sorted") {
        val arr = arrayListOf(1, 2, 3, 4, 9)

        val expectedAns = Pair(0, 0)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Seventh Test Case") {
        val arr = arrayListOf(3, 1, 2, 6, 7, 8, 9)

        val expectedAns = Pair(0, 3)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }

    test("Eighth Test Case") {
        val arr = arrayListOf(1, 2, 3, 5, 4, 3, 6, 7, 8)

        val expectedAns = Pair(3, 6)
        val actualAns: Pair<Int, Int> = dp.window2(arr)
        actualAns.shouldBe(expectedAns)
    }
})