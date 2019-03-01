class DailyProblem62(val n: Int, val m: Int) {
    val matrix = Array(n) { IntArray(m) }
    fun findTotalPaths(row: Int, col: Int) : Int {
        // base case(s)
        if(row >= n && col in 0..m) {
            return 0
        }
        if(row < 0 && col in 0..m) {
            return 0
        }
        if(col >= m && row in 0..n) {
            return 0
        }
        if(col < 0 && row in 0..n) {
            return 0
        }

        // if bottom right cell is reached we found a path
        if(row == n -1 && col == n - 1)
            return 1

        val rightPaths = findTotalPaths(row, col + 1)
        val downPaths = findTotalPaths(row + 1, col)
        return rightPaths + downPaths
    }
}