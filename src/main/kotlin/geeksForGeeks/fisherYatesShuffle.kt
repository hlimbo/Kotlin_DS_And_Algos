package geeksForGeeks

import kotlin.random.Random

// Fisher-Yates shuffle Algorithm
// https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
// Relates to Daily Problem #51

/*
    Given an array, write a program to generate a random permutation of array elements
    Shuffle means that every permutation of array element should equally be likely
*/

fun shuffleArrayNaive(arr: ArrayList<Int>) : ArrayList<Int> {
    val temp = ArrayList<Int>(arr)
    val shuffledArr = ArrayList<Int>()

    // don't get how this is O(n^2) unless I implemented the naive solution incorrectly??????
    for(i in 0 until arr.size) {
        val randomIndex = Random.nextInt(0, temp.size)
        val randomNum = temp.removeAt(randomIndex)
        shuffledArr.add(randomNum)
    }

    return shuffledArr
}

// O(n) time complexity
// Assumption: given a function rand() that generates a random number in O(1)time
fun fisherYatesAlgorithmShuffle(arr: ArrayList<Int>) : ArrayList<Int> {
    val shuffled = ArrayList<Int>(arr)

    for(i in (arr.size - 1) downTo 1) {
        val j = Random.nextInt(0, i + 1)
        val tmp = shuffled[j]
        shuffled[j] = shuffled[i]
        shuffled[i] = tmp
    }
    return shuffled
}

// How does the above algorithm satisfy that every permutation of array element should equally be likely?
/*
    * Probability that the ith element goes to last position is 1/n, because
    we randomly pick an element in the first iteration.
    * (The probability the last element doesn't stay at its original position) x (probability that the index picked in previous step is picked again so that the last element is swapped)
    * ((n - 1) / n) * ( 1 / (n - 1) ) = 1/n
 */