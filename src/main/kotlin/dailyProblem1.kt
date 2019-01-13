// Daily Problem #1
// Given a list of numbers and a number k, return whether any two numbers from the list add up to k

// Bonus: Can you do this in one pass?

fun testFunction() : Int {
    return 5
}

// Time Complexity: O(n^2) ~ using .contains which is typically implemented of linear complexity
// Space Complexity: O(n)
fun dailyProblem1(l : Array<Int>, k : Int) : Pair<Int, Int> {
    val size = l.size
    for(i in 0 until size) {
        val element = l[i]
        val difference = k - element

        // ensure there are at least 2 duplicate values in the array to form a Pair that sums to k
        if(element == difference && l.count { it == element } > 1) {
            return Pair(element, difference)
        }

        if(element != difference && l.contains(difference)) {
            return Pair(element, difference)
        }
    }

    // no pair results found
    return Pair(-1, -1)
}

// fail to solve in 15 minutes
// Time Complexity: O(m)
// Space Complexity: O(m)
fun dailyProblem1OnePass(l : Array<Int>, k : Int) : Pair<Int, Int> {

    val elements = HashMap<Int, Int>()

    // step 1 store all elements in list into a hash map
    // where the key is an element in the list and the value is
    // the number of times an element appears in the list
    for(element in l) {
        // using the elvis operator
        elements[element] = (elements[element] ?: 0) + 1
    }

    // step 2: find a potential pair of numbers that can be returned
    // such that the pair of numbers add up to sum k
    for(entry in elements) {
        val diff = k - entry.key

        if(entry.key == diff && (elements[diff] ?: 0) > 1) {
            // if a potential pair was found, ensure that the elements map contains at least 2 copies of the same number
            return Pair(entry.key, diff)
        }

        if(entry.key != diff && elements.containsKey(diff)) {
            return Pair(entry.key, diff)
        }
    }


    // no pair results found
    return Pair(-1, -1)
}