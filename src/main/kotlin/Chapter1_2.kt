import java.util.Collections.max
import java.util.Collections.sort
import kotlin.math.max
import kotlin.math.min

class Chapter1_2 {
    // returns smallest window that requires sorting where
    // first value in pair is the starting index
    // second value in pair is the ending index exclusive ~ should HAVE been inclusive
    // Assumption: we want to only sort in ascending order
    fun locateSmallestSortingWindow(list: ArrayList<Int>) : Pair<Int, Int> {
        var startingIndex = 0
        var endingIndex = 0
        var isFullySorted = true
        var minSortRange = Pair(0, 0)
        if(list.size == 0 || list.size == 1) {
            return minSortRange
        }

        // 1. find starting index in array where values become unsorted
        var prevValue = list[0]
        for(currentIndex in 1 until list.size) {
            val currentValue = list[currentIndex]
            if(currentValue < prevValue) {
                startingIndex = currentIndex - 1
                isFullySorted = false
                break
            }
            prevValue = currentValue
        }

        if(isFullySorted) {
            return minSortRange
        }

        // 2. naively assume last index of array is the ending index
        endingIndex = list.size

        //3. given the starting index and ending index,
        // check if the left hand side of starting index contains a value bigger than
        // right hand side of array
        val localMaxValueIndex = startingIndex - 1
        if(localMaxValueIndex >= 0) {
            val localMaxValue = list[localMaxValueIndex]
            var localMinRightValue: Int? = null
            for(i in (startingIndex + 1) until endingIndex) {
                // find the smallest value on the right hand side of the array
                if(localMaxValue > list[i]) {
                    localMinRightValue = list[i]
                }
                if(localMinRightValue != null && localMinRightValue > list[i]) {
                    localMinRightValue = list[i]
                }
            }

            // adjust the startingIndex if localMinRightValue is found -> increases sorting window
            if(localMinRightValue != null) {
                for(i in startingIndex downTo 0) {
                    if(localMinRightValue < list[i]) {
                        startingIndex -= 1
                    }
                }
            }
        }

        // 4. trim down endingIndex if values starting from the end remain sorted

        // find localRightMaxValue's index and see if it's equal to list.size - 1 and if it is we can
        // trim down the endingIndex......... if the localRightMaxValue's index isn't equal to list.size - 1,
        // then don't trim down endingIndex
        var localRightMaxValueIndex = endingIndex - 1
        for(i in (endingIndex - 2) downTo startingIndex) {
            if(list[localRightMaxValueIndex] < list[i]) {
                localRightMaxValueIndex = i
            }
        }

        // trim down endingIndex --> reduce sorting window
        if(localRightMaxValueIndex == list.size - 1) {
            prevValue = list[endingIndex - 1]
            for(i in (endingIndex - 2) downTo startingIndex) {
                val currentValue = list[i]
                if(prevValue > currentValue) {
                    endingIndex -= 1
                }
                prevValue = currentValue
            }

            // find local max left value --> increase sorting window if local max left value is greater than the value located at endingIndex
            if(endingIndex != list.size - 1) {
                var localMaxLeftValue = list[0]
                for(i in 1 until endingIndex) {
                    if(localMaxLeftValue < list[i]) {
                        localMaxLeftValue = list[i]
                    }
                }

                if(localMaxLeftValue > list[endingIndex]) {
                    endingIndex += 1
                }
            }
        }

        minSortRange = Pair(startingIndex, endingIndex)
        return minSortRange
    }

    // supposedly correct implementation with O(n) time and O(1) space
    fun window(list: ArrayList<Int>) : Pair<Int, Int> {
        var startingIndex = 0
        var endingIndex = 0

        var maxValue = list[0]
        var minValue = list[0]

        for(i in 0 until list.size) {
            maxValue = max(maxValue, list[i])
            if(list[i] < maxValue) {
                endingIndex = i
            }
        }

        for(i in (list.size - 1) downTo 0) {
            minValue = min(minValue, list[i])
            if(list[i] > minValue) {
                startingIndex = i
            }
        }

        val minSortRange = Pair(startingIndex, endingIndex)
        return minSortRange
    }

    // O(n * logn) solution uses sort to compare against array....
    // starting and ending indexes are inclusive
    fun window2(list: ArrayList<Int>) : Pair<Int, Int> {
        var startingIndex: Int? = null
        var endingIndex: Int? = null
        var minSortRange = Pair(0, 0)

        val sortedList = ArrayList<Int>(list)
        sortedList.sort()

        for(i in 0 until list.size) {
            if(list[i] != sortedList[i] && startingIndex == null) {
                startingIndex = i
            } else if(list[i] != sortedList[i]) {
                endingIndex = i  // ending index is included
            }
        }

        if(startingIndex != null && endingIndex != null) {
            minSortRange = Pair(startingIndex, endingIndex)
        }

        return minSortRange
    }
}