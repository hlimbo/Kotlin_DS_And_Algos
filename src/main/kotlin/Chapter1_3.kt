import kotlin.math.max

class Chapter1_3 {
    // o(n^2 * k) where n is the size of the array and is the size of the sub-array
    fun maxSubArraySumNaive(arr: ArrayList<Int>) : Int {
        val sums = ArrayList<Int>()

        for(startingIndex in 0 until arr.size) {
            for(i in startingIndex until arr.size) {
                var sum = 0
                for(j in startingIndex..i) {
                    sum += arr[j]
                }
                sums.add(sum)
            }
        }

        var maxSum = 0
        for(sum in sums) {
            // println("sum $sum")
            maxSum = max(sum, maxSum)
        }

        return maxSum
    }

    // O(n^2) solution with wrap around support using Kadane's Algorithm
    fun kadanesAlgoWithWrapAround(arr: ArrayList<Int>) : Int {
        var fullMax = 0
        for(j in 0 until arr.size) {
            var t = j
            println("j: $j")
            var localMax = 0
            var globalMax = 0
            for(i in 0 until arr.size) {
                println("t: $t")
                localMax = max(arr[t], localMax + arr[t])
                globalMax = max(globalMax, localMax)
                t = (t + 1) % arr.size
            }

            fullMax = max(fullMax, globalMax)

            println("\n\n")
        }

        return fullMax
    }

    // O(n) time ~ when elements can wrap around?
    fun kadanesAlgoWithWrapAround2(arr: ArrayList<Int>) : Int {
        val totalElementsToTraverse: Int = arr.size * arr.size
        var fullMax = 0
        var localMax = 0
        var globalMax = 0
        var startingIndex = 0
        var t = startingIndex
        for(i in 0 until totalElementsToTraverse) {
            // update startingIndex
            if(i >= arr.size && i % arr.size == 0) {
                startingIndex += 1
                t = startingIndex
                fullMax = max(fullMax, globalMax)
                // reset trackers to ensure the number of elements to calculate the max does not exceed arr.size
                localMax = 0
                globalMax = 0
            }

            localMax = max(arr[t], localMax + arr[t])
            globalMax = max(globalMax, localMax)

            t = (t + 1) % arr.size
        }

        return fullMax
    }

}