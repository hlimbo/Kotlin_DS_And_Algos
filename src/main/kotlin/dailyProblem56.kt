class DailyProblem56 {
    // I assumed that all nodes have to be connected to every other node
    // but that shouldn't always be the case for a undirected graph
    inner class UndirectedGraph(val nodeTotal: Int){
        val adjacencyMatrix = Array(nodeTotal) { IntArray(nodeTotal) }

        // 0 means not connected
        // 1 means connected
        fun copy(matrix: Array<IntArray>) {
            for(r in 0 until nodeTotal) {
                for(c in 0 until nodeTotal) {
                    adjacencyMatrix[r][c] = matrix[r][c]
                }
            }
        }

        // assuming not all nodes have to be connected with every other node
        fun canVerticesBeColored2(k: Int) : Boolean {
            return false
        }

//        fun edgeCountTotal(nodeTotal: Int) : Int {
//            if(nodeTotal == 0)
//                return 0
//
//            var edgeCount = 0
//            for(i in 1..nodeTotal) {
//                edgeCount += (i - 1)
//            }
//
//            return edgeCount
//        }

        // would be correct if all nodes are connected to every other node

        // vertices can be colored only when no 2 adjacent vertices share
        // the same color using at most k colors
        fun canVerticesBeColored(c: Int) : Boolean {
            if(c < nodeTotal) {
                return false
            }
            // if c >= nodeTotal
            return true
        }
    }
}