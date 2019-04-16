import java.util.*
import kotlin.math.*

class Chapter4_3 {
    // O(n * k) time with O(k) space.... can this be improved to O(n) time?
    fun computeMaxKLengthSubArrays(arr: ArrayList<Int>,k: Int) {
        val subArray = ArrayList<Int>()

        val m = max(arr.size, k)
        for(i in 0 until m) {
            subArray.add(arr[i])
        }

        var maxValue = subArray[0]
        for(i in 0 until k) {
            maxValue = max(maxValue, subArray[i])
        }

        println("Max Value: $maxValue")

        for(i in k until arr.size) {
            subArray.removeAt(0)
            subArray.add(arr[i])
            maxValue = subArray[0]
            for(j in 0 until k) {
                maxValue = max(maxValue, subArray[j])
            }
            println("Max Value: $maxValue")
        }

    }
}