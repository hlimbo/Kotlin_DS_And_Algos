import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.FunSpec

class DailyProblem52Test : FunSpec({
    test("First Test Case") {
        val dp = dailyProblem52()
        val lru = dp.LRU(2)
        lru.set(1, dp.Item(2))
        lru.set(2, dp.Item(3))
        lru.set(1, dp.Item(5))
        lru.set(4, dp.Item(5))
        lru.set(6, dp.Item(7))

        val item1: dailyProblem52.Item? = lru.get(4)
        val item2: dailyProblem52.Item? = lru.get(1)
        item1.shouldNotBe(null)
        item2.shouldBe(null)
        println(item1)
        println(item2)

        println("Cached Items")
        println(lru.cachedItems())
    }
})