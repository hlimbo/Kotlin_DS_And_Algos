class DailyProblem54 {
    inner class SudokuBoard {
        private val rowCount = 9
        private val colCount = 9
        val board = Array(rowCount){ IntArray(colCount) }

        constructor(boardCopy: Array<IntArray>) {
            for((index, row) in boardCopy.withIndex()) {
                board[index] = row.clone()
            }
        }
    }

    inner class Cell(val row: Int, val col: Int) {
        // key = possible number to fill in cell
        // value = boolean that indicates if associated key is a possible candidate
        val candidates = HashMap<Int,Boolean>()
        val subgridRow = row / 3
        val subgridCol = col / 3

        init {
            for(i in 1..9) {
                candidates[i] = true
            }
        }

        fun removeCandidate(num: Int) : Boolean {
            if(candidates.containsKey(num) && candidates[num] == true) {
                candidates[num] = false
                return true
            }

            return false
        }

        fun addCandidate(num: Int) : Boolean {
            if(candidates.containsKey(num) && candidates[num] == false) {
                candidates[num] = true
                return true
            }

            return false
        }
    }
}