package geeksForGeeks

class AmazonInterviewQuestion1 {
    // k = value of interest
    // m = m nearest values of k
    fun findNearestElements(k: Int, m: Int, arr: ArrayList<Int>) : ArrayList<Int> {

        if(arr.isEmpty()) return ArrayList()

        val closestValues = ArrayList<Int>()
        for(i in 0 until m) {
            if(i == 0) {
                closestValues.add(arr[0])
            } else {
                closestValues.add(closestValues[i - 1])
            }

            for(element in arr) {
                val currentDistance = Math.abs(closestValues[i] - k)
                val distance = Math.abs(element - k)
                if(i == 0 && distance < currentDistance) {
                    closestValues[i] = element
                } else if(i != 0) {
                    val prevClosestDistance = Math.abs(closestValues[i - 1] - k)
                    if(distance >= prevClosestDistance && distance < currentDistance) {
                        closestValues[i] = element
                    }
                }
            }

        }

        return closestValues
    }

    // sort by distances in ascending order and return the m closes elements this way!
    fun findNearestElements2(k: Int, m: Int, arr: ArrayList<Int>) : ArrayList<Int> {

        if(arr.isEmpty()) return ArrayList()

        var copy = ArrayList<Int>(arr)

        copy.sortWith(compareBy( { Math.abs(it - k)}, {Math.abs(it - k)}))

        var closestValues = ArrayList<Int>()

        for(i in 0 until m) {
            closestValues.add(copy[i])
        }

        return closestValues
    }
}