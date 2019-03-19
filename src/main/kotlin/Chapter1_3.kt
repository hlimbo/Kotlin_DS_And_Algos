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

    // O(n) time
}