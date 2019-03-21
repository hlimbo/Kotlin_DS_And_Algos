import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter1_3Test : FunSpec({
    val dp = Chapter1_3()
    test("First Test Case- all negatives") {
        val arr = arrayListOf(-5, -1, -8, -9)
        val actualAnswer = dp.maxSubArraySumNaive(arr)
        val expectedAnswer = 0
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Second Test Case") {
        val arr = arrayListOf(34, -50, 42, 14, -5, 86)
        val actualAnswer = dp.maxSubArraySumNaive(arr)
        val expectedAnswer = (42 + 14 - 5 + 86)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Using Kadane's Algorithm with Wrap Around Test") {
        val arr = arrayListOf(8, -1, 3, 4)
        val actualAnswer = dp.kadanesAlgoWithWrapAround(arr)
        val expectedAnswer = (3 + 4 + 8)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Using Kadane's Algorithm with Wrap Around Test2") {
        val arr = arrayListOf(8, -1, 3, 4)
        val actualAnswer = dp.kadanesAlgoWithWrapAround2(arr)
        val expectedAnswer = (3 + 4 + 8)
        actualAnswer.shouldBe(expectedAnswer)
    }
})
