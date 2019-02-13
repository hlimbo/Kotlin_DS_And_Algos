import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DailyProblem46Test : FunSpec({
    test("First Test Case") {
        val str : String = "aabcdcb"
        val answer : String = "bcdcb"

        val actualAnswer : String = dailyProblem46(str)
        actualAnswer.shouldBe(answer)
    }

    test("Second Test Case") {
        val str : String = "bananas"
        val answer : String = "anana"

        val actualAnswer : String = dailyProblem46(str)
        actualAnswer.shouldBe(answer)
    }
})