class Chapter1_4 {

    // O(n^2) solution
    fun smallerElementsToRightNaive(arr: ArrayList<Int>) : ArrayList<Int> {
        // one liner add all 0s
        // val result = ArrayList<Int>(IntArray(arr.size) { 0 }.asList())
        val newArr = ArrayList<Int>()
        for(i in 0 until arr.size) {
            newArr.add(0)
        }

        for(i in 0 until arr.size) {
            val currentElement = arr[i]
            for(j in (i + 1) until arr.size) {
                if(currentElement > arr[j]) {
                    newArr[i] += 1
                }
            }
        }
        return newArr
    }
}