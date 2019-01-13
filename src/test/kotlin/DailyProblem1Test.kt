import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.matchers.shouldHave
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DailyProblem1Test : FunSpec({
    test("First Test") {
        val five = 5
        val answer = testFunction()
        answer.shouldBe(five)
    }

    test("Test of Understanding") {
        val k = 10
        val l : Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val actualAnswer : Pair<Int, Int> = dailyProblem1(l, k)
        val expectedAnswer : Pair<Int, Int> = Pair(1, 9)

        actualAnswer.toList().shouldContainAll(expectedAnswer.toList())
    }

    test("When no valid pair is available") {
        val k = 10
        val l: Array<Int> = arrayOf(1, 1, 1, 1, 1, 1, 1, 1)

        val actualAnswer: Pair<Int, Int> = dailyProblem1(l, k)
        val expectedAnswer: Pair<Int, Int> = Pair(-1, -1)

        actualAnswer.toList().shouldContainAll(expectedAnswer.toList())
    }

    test("Testing for no existence of duplicate values") {
        val k = 12
        val l = arrayOf(6,5, 3, 1, 8, 25, 10)

        val actualAnswer : Pair<Int, Int> = dailyProblem1(l, k)
        val expectedAnswer = Pair(-1, -1)

        actualAnswer.toList().shouldContainAll(expectedAnswer.toList())
    }

    test("dailyProblem1OnePass Test of Understanding") {
        val k = 10
        val l : Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        val actualAnswer : Pair<Int, Int> = dailyProblem1OnePass(l, k)
        val expectedAnswer : Pair<Int, Int> = Pair(1, 9)

        actualAnswer.toList().shouldContainAll(expectedAnswer.toList())
    }

    test("dailyProblem1OnePass When no valid pair is available") {
        val k = 10
        val l: Array<Int> = arrayOf(1, 1, 1, 1, 1, 1, 1, 1)

        val actualAnswer: Pair<Int, Int> = dailyProblem1OnePass(l, k)
        val expectedAnswer: Pair<Int, Int> = Pair(-1, -1)

        actualAnswer.toList().shouldContainAll(expectedAnswer.toList())
    }

    test("dailyProblem1OnePass There is no existence of duplicate pairs") {
        val k = 12
        val l = arrayOf(6,5, 3, 1, 8, 25, 10)

        val actualAnswer : Pair<Int, Int> = dailyProblem1OnePass(l, k)
        val expectedAnswer = Pair(-1, -1)

        actualAnswer.toList().shouldContainAll(expectedAnswer.toList())
    }
})