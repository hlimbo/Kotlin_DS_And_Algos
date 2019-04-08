class Chapter3_4 {

    inner class Node(val data: Int, var next: Node?)

    fun findMin(node: Node?) : Int {
        var ptr: Node? = node
        var min: Int = ptr?.data ?: 0
        while(ptr != null) {
            if(min > ptr.data) {
                min = ptr.data
            }
            ptr = ptr.next
        }

        return min
    }

    fun findMax(node: Node?) : Int {
        var ptr: Node? = node
        var max: Int = ptr?.data ?: 0
        while(ptr != null) {
            if(max < ptr.data) {
                max = ptr.data
            }
            ptr = ptr.next
        }

        return max
    }

    // O(m + n) solution with constant space because I'm only using temporary variables that aren't collections that scale with the size of linked list A or linked list B
    fun findIntersectingNode(a: Node?, b: Node?) : Node? {
        val nodeMaxA: Int = findMax(a)
        val nodeMaxB: Int = findMax(b)

        val smallestMax = kotlin.math.min(nodeMaxA, nodeMaxB)

        var ptrA: Node? = a
        var ptrB: Node? = b
        var hadPtrAAdvanced = false
        var hadPtrBAdvanced = false
        var intersectingNode: Node? = null

        while(ptrA != null && ptrB != null) {
            if(ptrA.data == ptrB.data) {
                intersectingNode = ptrA
                break
            } else {
                if (ptrA.data > smallestMax) {
                    ptrA = ptrA.next
                    hadPtrAAdvanced = true
                    if(hadPtrBAdvanced)
                        hadPtrAAdvanced = false
                } else if (ptrB.data > smallestMax) {
                    ptrB = ptrB.next
                    hadPtrBAdvanced = true
                    if(hadPtrAAdvanced)
                        hadPtrAAdvanced = false
                } else {
                    if(hadPtrAAdvanced) {
                        hadPtrAAdvanced = false
                        hadPtrBAdvanced = true
                        ptrB = ptrB.next
                    }
                    if(hadPtrBAdvanced) {
                        hadPtrAAdvanced = true
                        hadPtrBAdvanced = false
                        ptrA = ptrA.next
                    }
                }
            }

        }

        return intersectingNode
    }

}