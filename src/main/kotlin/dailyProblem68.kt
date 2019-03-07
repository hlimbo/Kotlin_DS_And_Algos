class DailyProblem68(val M: Int) {
    val gameBoard = Array(M) { CharArray(M) }
    val bishopPositions = ArrayList<Pair<Int,Int>>()
    val bishopAttackPositions = HashMap<Int,ArrayList<Pair<Int,Int>>>()

    fun initBoard(initialBishopPositions: ArrayList<Pair<Int,Int>>) {
        for(bishopPosition in initialBishopPositions) {
            bishopPositions.add(bishopPosition)
        }
    }

    fun initBishopAttackPositions() {
        for((index, bishopPosition) in bishopPositions.withIndex()) {
            bishopAttackPositions[index] = ArrayList()

            // NorthWest
            var currentRow = bishopPosition.first - 1
            var currentCol = bishopPosition.second - 1
            while(currentRow > 0 && currentCol > 0) {
                bishopAttackPositions[index]?.add(Pair(currentRow, currentCol))
                currentRow -= 1
                currentCol -= 1
            }

            // NorthEast
            currentRow = bishopPosition.first - 1
            currentCol = bishopPosition.second + 1
            while(currentRow > 0 && currentCol < M) {
                bishopAttackPositions[index]?.add(Pair(currentRow, currentCol))
                currentRow -= 1
                currentCol += 1
            }

            // SouthWest
            currentRow = bishopPosition.first + 1
            currentCol = bishopPosition.second - 1
            while(currentRow < M && currentCol > 0) {
                bishopAttackPositions[index]?.add(Pair(currentRow, currentCol))
                currentRow += 1
                currentCol -= 1
            }

            // SouthEast
            currentRow = bishopPosition.first + 1
            currentCol = bishopPosition.second + 1
            while(currentRow < M && currentCol < M) {
                bishopAttackPositions[index]?.add(Pair(currentRow, currentCol))
                currentRow += 1
                currentCol += 1
            }
        }
    }

    // ordering of pairs don't matter (1,2) same as (2,1) (don't count attacks twice)
    // bishops can attack through pieces
    // O(t * n^2) solution ~ where t is the number of attack positions and n is the number of bishops on the game board
    fun bishopPairsAttackCount(): Int {
        var pairCount = 0
        for(index in 0 until bishopPositions.size) {
            for((otherIndex, otherBishopPosition) in bishopPositions.withIndex()) {
                // don't consider attacking self bishop
                if(index == otherIndex)
                    continue

                if(bishopAttackPositions[index]!!.contains(otherBishopPosition)) {
                    println("bishop $index can attack bishop $otherIndex")
                    pairCount += 1
                }
            }
        }

        return pairCount
    }
}