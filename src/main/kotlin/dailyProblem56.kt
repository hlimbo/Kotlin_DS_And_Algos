class DailyProblem56 {
    inner class Vertex(val label: Int, var connectionCount: Int, val possibleColorChoices: Int) {
        val verticesRef = ArrayList<Vertex>()
        // from 0 to possibleColorChoices - 1
        val colorChoices = Array<Int>(possibleColorChoices) { it }
    }


    inner class UndirectedGraph(val nodeTotal: Int){
        val adjacencyMatrix = Array(nodeTotal) { IntArray(nodeTotal) }
        val vertices = ArrayList<Vertex>()

        private val connected = 1
        private val notConnected = 0

        fun construct(matrix: Array<IntArray>,k: Int) {
            for(r in 0 until nodeTotal) {
                for(c in 0 until nodeTotal) {
                    adjacencyMatrix[r][c] = matrix[r][c]
                }
            }

            for(i in 0 until nodeTotal) {
                vertices.add(Vertex(i, 0, k))
            }

            // get connections count
            for(r in 0 until nodeTotal) {
                for(c in 0 until nodeTotal) {
                    when(adjacencyMatrix[r][c]) {
                        connected -> {
                            vertices[r].connectionCount += 1
                            vertices[r].verticesRef.add(vertices[c])
                        }
                    }
                }
            }
        }

        fun constructVerticesData() {

            // get connection counts
            for(r in 0 until nodeTotal) {
                for(c in 0 until nodeTotal) {

                }
            }

            for(i in 0 until nodeTotal) {
            }
        }

        // assuming not all nodes have to be connected with every other node
        fun canVerticesBeColored(k: Int) : Boolean {
            return false
        }
    }
}