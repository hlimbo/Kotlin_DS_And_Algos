class DailyProblem16 {

    // Question to ask: how to achieve O(1) read and O(1) write access?

    private val orderIds = ArrayList<Long>()

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun record(orderId: Long) {
        orderIds.add(orderId)
    }

    // assumption i is guaranteed to be smaller than or equal to N
    //assumption i is zero-based
    // Time Complexity: O(1) assuming orderIds.size is cached and [] operator is constant time as well
    // Space Complexity: O(1) returning value of constant memory 8 bytes on 64 bit machines
    fun getLast(i : Int) : Long {
        val size : Int = orderIds.size
        return orderIds[size - (i + 1)]
    }
}