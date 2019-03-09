import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec
import kotlin.math.exp

class Chapter1_1Test : FunSpec({
    test("First Test Case") {
        val dp = Chapter1_1()
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val expectedOutput = intArrayOf(120, 60, 40, 30, 24)

        val actualAnswer: IntArray = dp.otherProducts(arr)
        for(i in 0 until expectedOutput.size) {
            actualAnswer[i].shouldBe(expectedOutput[i])
        }

        for(ans in actualAnswer)
            println(ans)
    }

    test("Second Test Case") {
        val dp = Chapter1_1()
        val arr = intArrayOf(3, 2, 1)
        val expectedOutput = intArrayOf(2, 3, 6)

        val actualAnswer: IntArray = dp.otherProducts(arr)
        for(i in 0 until expectedOutput.size) {
            actualAnswer[i].shouldBe(expectedOutput[i])
        }
    }

    test("Third Test Case") {
        val dp = Chapter1_1()
        val arr = intArrayOf(2, 1)
        val expectedOutput = intArrayOf(1, 2)

        val actualAnswer: IntArray = dp.otherProducts(arr)
        for(i in 0 until expectedOutput.size) {
            actualAnswer[i].shouldBe(expectedOutput[i])
        }
    }
})