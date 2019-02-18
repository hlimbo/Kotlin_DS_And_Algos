package geeksForGeeks

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

// Note: This algorithm is NOT testable because there is a CHANCE that
// the array input ordering remains the same after passing into the function
class FisherYatesShuffleTest : FunSpec({
    test("First Test Case - Naive") {
        val arr = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
        val shuffled: ArrayList<Int> = shuffleArrayNaive(arr)
        println("Arr: $arr")
        println("Shuffled: $shuffled")
    }

    test("Fisher-Yates shuffle Algorithm") {
        val arr = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
        val shuffled: ArrayList<Int> = fisherYatesAlgorithmShuffle(arr)
        println("Arr: $arr")
        println("Shuffled Using Fisher-Yates Algorithm: $shuffled")
    }
})