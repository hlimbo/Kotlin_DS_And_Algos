import java.util.*

// problem with this approach is that I'm depending on the ordering of the list
// such that there will be an eventual value added in that is greater than the current max value
// worst case scenario is that values are pushed into the stack in descending order 10, 9, 8, 7
// which there will be no PREV MAX VALUES to use!
class Chapter4_1 {
    inner class Stack() {
        private val stack = ArrayList<Int>()
        private val prevMaxValuesList = ArrayList<Int>()
        var maxValue: Int? = null

        fun push(data: Int) {
            stack.add(data)
            if(maxValue == null) {
                maxValue = data
            } else if(maxValue!! <= data) {
                prevMaxValuesList.add(maxValue!!)
                maxValue = data
            }
        }

        fun pop(): Int {
            if(stack.isEmpty())
                throw EmptyStackException()

            val lastValue = stack[stack.size - 1]
            stack.removeAt(stack.size - 1)

            // after removal
            if(stack.isEmpty()) {
                maxValue = null
                prevMaxValuesList.clear()
            } else if(maxValue != null && lastValue == maxValue) {
                // recompute the max value here which is O(N) time
//                maxValue = stack[0]
//                for(i in 1 until stack.size) {
//                    maxValue = kotlin.math.max(maxValue!!, stack[i])
//                }

                // this will break when values pushed onto the stack are in descending order
                maxValue = prevMaxValuesList[prevMaxValuesList.size - 1]
                prevMaxValuesList.removeAt(prevMaxValuesList.size - 1)
            }
            return lastValue
        }

        fun max(): Int? {
            if(stack.isEmpty())
                throw EmptyStackException()
            return maxValue
        }
    }
}