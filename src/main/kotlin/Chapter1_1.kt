// challenge implement this without division
class Chapter1_1 {
    // more complex way...
    fun otherProducts(arr: IntArray) : IntArray {
        val productArray = IntArray(arr.size)

        for(i in 0 until arr.size) {
            var product = 1
            var j = i + 1 // + 1 to skip multiplying the value located at index i
            while(j != i + arr.size) {
                // % arr.size to prevent going out of array bounds
                val k = j % arr.size
                product *= arr[k]
                j += 1
            }
            productArray[i] = product
        }

        return productArray
    }

    // less complex way..
    fun otherProductsFirstWay(arr: IntArray) : IntArray {
        val productArray = IntArray(arr.size)

        for(i in 0 until arr.size) {
            var product = 1
            for(j in 0 until arr.size) {
                if(i == j) continue
                product *= arr[j]
            }
            productArray[i] = product
        }


        return productArray
    }
}