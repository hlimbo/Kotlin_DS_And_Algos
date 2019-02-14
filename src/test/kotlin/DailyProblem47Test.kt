import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

class DailyProblem47Test : FunSpec({
    test("First Test Case") {
        val stockPrices: ArrayList<Long> = arrayListOf(9, 11, 8, 5, 7, 10)
        val expectedAnswer: Long = 5
        val actualAnswer: Long = dailyProblem47(stockPrices)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Second Test Case") {
        val stockPrices: ArrayList<Long> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
        val expectedAnswer: Long = 8 - 1
        val actualAnswer: Long = dailyProblem47(stockPrices)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("No values in array") {
        val stockPrices = ArrayList<Long>()
        val expectedAnswer: Long = 0
        val actualAnswer: Long = dailyProblem47(stockPrices)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("Given stock prices are declining") {
        val stockPrices: ArrayList<Long> = arrayListOf(9, 8, 7, 6, 5, 4 ,3, 2, 1)
        val expectedAnswer: Long = 0
        val actualAnswer: Long = dailyProblem47(stockPrices)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("1 stock price") {
        val stockPrices = ArrayList<Long>()
        stockPrices.add(10)
        val expectedAnswer: Long = 0
        val actualAnswer: Long = dailyProblem47(stockPrices)
        actualAnswer.shouldBe(expectedAnswer)
    }

    test("2 stock prices") {
        val stockPrices = ArrayList<Long>()
        stockPrices.add(3)
        stockPrices.add(11)
        val expectedAnswer: Long = stockPrices[1] - stockPrices[0]
        val actualAnswer: Long = dailyProblem47(stockPrices)
        actualAnswer.shouldBe(expectedAnswer)
    }
})