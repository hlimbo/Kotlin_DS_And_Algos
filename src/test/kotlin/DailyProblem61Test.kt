import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem61Test : FunSpec({
    test("First Test Case") {
        val dp = DailyProblem61()
        val expected = 1
        val answer = dp.powNaive(2, 0)
        answer.shouldBe(expected)
    }

    test("Second Test Case") {
        val dp = DailyProblem61()
        val expected = Math.pow(2.0, 3.0).toInt()
        val answer = dp.powNaive(2, 3)
        answer.shouldBe(expected)
    }

    test("Third Test Case") {
        val dp = DailyProblem61()
        val expected = Math.pow(2.0, 1.0).toInt()
        val answer = dp.powNaive(2, 1)
        answer.shouldBe(expected)
    }

    test("First Test Case- Recursive") {
        val dp = DailyProblem61()
        val expected = 1
        val answer = dp.powNaiveRecursive(2, 0)
        answer.shouldBe(expected)
    }

    test("Second Test Case - Recursive") {
        val dp = DailyProblem61()
        val expected = Math.pow(2.0, 10.0).toInt()
        val answer = dp.powNaiveRecursive(2, 10)
        answer.shouldBe(expected)
    }

    test("Third Test Case - Recursive") {
        val dp = DailyProblem61()
        val expected = Math.pow(2.0, 1.0).toInt()
        val answer = dp.powNaiveRecursive(2, 1)
        answer.shouldBe(expected)
    }

    test("pow Fast First Test Case") {
        val dp = DailyProblem61()
        val expected = Math.pow(2.0, 0.0).toInt()
        val lookup = HashMap<Pair<Int,Int>,Int>()
        val answer = dp.powFast(2, 0, false, false, lookup)
        for(entry in lookup.entries){
            println("Key: [${entry.key.first}, ${entry.key.second}] -> ${entry.value}")
        }
        answer.shouldBe(expected)
    }

    test("pow Fast Second Test Case") {
        val dp = DailyProblem61()
        val expected = Math.pow(2.0, 10.0).toInt()
        val lookup = HashMap<Pair<Int,Int>,Int>()
        val answer = dp.powFast(2, 10, false, false, lookup)
        for(entry in lookup.entries){
            println("Key: [${entry.key.first}, ${entry.key.second}] -> ${entry.value}")
        }
        answer.shouldBe(expected)
    }
})