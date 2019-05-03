package geeksForGeeks

import io.kotlintest.shouldBe
import io.kotlintest.specs.FunSpec

// Note: This algorithm is NOT testable because there is a CHANCE that
// the array input ordering remains the same after passing into the function
class AmazonInterviewQuestion1Test : FunSpec({
    test("First Test Case") {
        val arr = ArrayList<Int>()
        arr.add(-10)
        arr.add(-50)
        arr.add(20)
        arr.add(17)
        arr.add(80)

        val k = 20
        val m = 2

        val amazon = AmazonInterviewQuestion1()
        val answer = amazon.findNearestElements2(k, m, arr)
        println("array length: ${answer.size}")
        for(a in answer) {
            println(a)
        }
    }
})