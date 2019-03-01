import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem62Test : FunSpec({
    test("First Test Case") {
        val dp = DailyProblem62(2, 2)
        val expectedWays = 2
        val actualWays = dp.findTotalPaths(0,0)
        actualWays.shouldBe(expectedWays)
    }

    test("Second Test Case") {
        val dp = DailyProblem62(5, 5)
        val expectedWays = 70
        val actualWays = dp.findTotalPaths(0, 0)
        actualWays.shouldBe(expectedWays)
    }
})