// see https://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
// and compare my solution with the one above ^

class DailyProblem55 {
    val urlToShortStringMap = HashMap<String, String>()
    val shortToUrlStringMap = HashMap<String, String>()
    val alphaNumerics = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    val indices = intArrayOf(0, 0, 0, 0, 0, 0)
    var currentIndex = indices.size - 1 // last alphanumeric char in shorten


    // current problem with this function is if a user of this function reaches
    // (26 lowercase letters + 26 uppercase letters + 10 digits) = 62 possible characters per slot
    // assuming repetition is allowed, 62^6 possible permutations exist to generate shortened urls
    // or roughly 56 billion possible permutations of a 6 alphanumeric character short string
    fun shorten(url: String) : String {
        if(urlToShortStringMap.containsKey(url)) {
            return urlToShortStringMap[url]!!
        }

        // create the algorithm that generates the 6 alphanumeric char string
        // with consideration of possible mapping oollisions that could occur
        var shortString = ""
        for(i in indices) {
            shortString += alphaNumerics[i]
        }

        urlToShortStringMap[url] = shortString
        shortToUrlStringMap[shortString] = url

        indices[currentIndex] += 1
        // stop incrementing if we reached upper limit of 62 characters and move on to the next
        // index
        if(currentIndex == alphaNumerics.length) {
            currentIndex -= 1
        }

        if(currentIndex < 0) {
            // throw exception here max number of short urls have been reached!
        }

        return shortString
    }

    fun restore(short: String) : String? {
        return shortToUrlStringMap[short]
    }
}