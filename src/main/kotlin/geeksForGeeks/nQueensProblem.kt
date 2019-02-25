package geeksForGeeks

// The N Queen is the problem of placing N chess queens on an NxN chessboard
// so that no 2 queens attack each other

// solving subset of the problem with a 4x4 chessboard and 4 queens placed on board
class NQueensProblem(val n: Int) {
    val chessBoard = Array(n) { IntArray(n) }
    private val queen = 1
    private val free = 0

    fun isSolvable() : Boolean {
        val startingColumn = 0
        return isSolvableRecursive(n, startingColumn)
    }
    fun isSolvableRecursive(queenCount: Int, startingColumn: Int) : Boolean {
        //1. base case(s)
        if(queenCount == 0)
            return true

        //2. recursive step
        for(r in 0 until chessBoard.size) {
            // if the queen can be placed safely in this row then mark this [row, col]
            // as part of the solution and recursively check if placing a queen here leads to a
            // solution
            if(!canQueenBeAttacked(r, startingColumn)) {
                chessBoard[r][startingColumn] = queen
                val canBeSolved: Boolean = isSolvableRecursive(queenCount - 1, startingColumn + 1)

                // if placing the queen in [row, col] leads to a solution then return true
                if(canBeSolved) {
                    return true
                } else {
                    // unmark this [row, col] and back track
                    chessBoard[r][startingColumn] = free
                    println("Backtracking as row col pair is not part of the solution: [$r, $startingColumn]")
                }
            }


        }

        // if all rows have been tried and nothing worked, return false to trigger back tracking
        println("Backtracking as all row enumerations for this recursive run has been exhausted with startingColumn: $startingColumn")
        return false
    }

    fun isChessBoardClear() : Boolean {
        for(row in chessBoard) {
            for(position in row) {
                if(position == queen)
                    return false
            }
        }
        return true
    }

    fun canQueenBeAttacked(targetRow: Int, targetCol: Int) : Boolean {
        val otherQueenPositions: ArrayList<Pair<Int, Int>> = queenPositions()

        if(isChessBoardClear())
            return false

        val attackingPositions = ArrayList<Pair<Int, Int>>()
        for(otherQueenPosition in otherQueenPositions) {
            val queenAttackPos: ArrayList<Pair<Int, Int>> = queenAttackingPositions(otherQueenPosition.first, otherQueenPosition.second)
            attackingPositions.addAll(queenAttackPos)
        }

        var canBeAttacked = false
        for(attackingPosition in attackingPositions) {
            if(attackingPosition.first == targetRow && attackingPosition.second == targetCol) {
                canBeAttacked = true
                break
            }
        }

        return canBeAttacked
    }

    fun queenPositions() : ArrayList<Pair<Int, Int>> {
        val positions = ArrayList<Pair<Int, Int>>()
        for((rowIndex, row) in chessBoard.withIndex()) {
            for((colIndex, col) in row.withIndex()) {
                if(col == queen) {
                    positions.add(Pair(rowIndex, colIndex))
                }
            }
        }
        return positions
    }

    fun queenAttackingPositions(initialRow: Int, initialCol: Int) : ArrayList<Pair<Int,Int>> {

        val attackingPositions = ArrayList<Pair<Int, Int>>()

        // north
        for(i in (initialRow -1) downTo 0) {
            attackingPositions.add(Pair(i, initialCol))
        }

        // south
        for(i in (initialRow + 1) until chessBoard.size) {
            attackingPositions.add(Pair(i, initialCol))
        }

        // west
        for(i in (initialCol - 1) downTo 0) {
            attackingPositions.add(Pair(initialRow, i))
        }

        // east
        for(i in (initialCol + 1) until chessBoard[initialRow].size) {
            attackingPositions.add(Pair(initialRow, i))
        }

        // north-west
        var c = initialCol - 1
        for(r in (initialRow - 1) downTo 0) {
            // prevent adding positions that are out of chess board bounds
            if(c < 0)
                break

            attackingPositions.add(Pair(r, c))
            c -= 1
        }

        // north-east
        c = initialCol + 1
        for(r in (initialRow - 1) downTo 0) {
            // prevent adding positions that are out of chess board bounds
            if(c >= chessBoard[initialRow].size)
                break

            attackingPositions.add(Pair(r, c))
            c += 1
        }

        // south-west
        c = initialCol - 1
        for(r in (initialRow + 1) until chessBoard.size) {
            if(c < 0)
                break

            attackingPositions.add(Pair(r, c))
            c -= 1
        }

        // south-east
        c = initialCol + 1
        for(r in (initialRow + 1) until chessBoard.size) {
            if( c >= chessBoard[initialRow].size)
                break

            attackingPositions.add(Pair(r, c))
            c += 1
        }

        return attackingPositions
    }

    override fun toString(): String {
        var output = ""
        for(row in chessBoard) {
            output += "[ "
            for(c in 0 until row.size) {
                output += row[c].toString() + " "
            }
            output += "]\n"
        }

        return output
    }

}