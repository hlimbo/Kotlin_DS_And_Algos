import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem68Test : FunSpec({
    test("First Test Case") {
        val M = 5
        val initialBishopPositions = ArrayList<Pair<Int,Int>>()
        initialBishopPositions.add(Pair(0, 0))
        initialBishopPositions.add(Pair(1, 2))
        initialBishopPositions.add(Pair(2, 2))
        initialBishopPositions.add(Pair(4, 0))

        val dp = DailyProblem68(M)
        dp.initBoard(initialBishopPositions)
        dp.initBishopAttackPositions()

        val actualCount: Int = dp.bishopPairsAttackCount()
        println("Actual Attack Count: $actualCount")
        actualCount.shouldBe(2)
    }
})