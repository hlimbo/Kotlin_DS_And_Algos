import java.util.*

// LRU cache
class dailyProblem52 {
    inner class Item(val value: Int, var usedScore: Int = 0) {
        override fun toString(): String {
            return "Value: $value | Used Score: $usedScore"
        }
    }

    // Tradeoff when n is small... there will be more frequent removals of least used item
    // when n is larger... there will be less frequent removals of a least used item
    // if more sets are performed than gets given unique items are always being set,
    // then the likelihood of O(n) time complexity is greater on set method
    inner class LRU(val n: Int, var size: Int = 0) {
        private val hashMap = HashMap<Int, Item>()

        private val pq = PriorityQueue<Pair<Int, Item?>>(kotlin.Comparator { o1, o2 ->  o1.second!!.usedScore - o2.second!!.usedScore })
        var mostUsedScore = 0

        fun set(key: Int, value: Item) {
            val previousMapping: Item? = hashMap.put(key, value)

            // assumption: an item being set affects the relative usage score
            // give this item the highest score possible
            if(hashMap[key] != null) {
                ++mostUsedScore
                hashMap[key]?.usedScore = mostUsedScore
            }

            // increase the size by 1 if a brand new item in the cache is being added in
            if(previousMapping == null) {
                ++size
                pq.offer(Pair(key, hashMap[key]))
            } else {
                // replacing item value in queue....
                pq.remove()
                pq.offer(Pair(key, hashMap[key]))
            }

            // remove least recently used item
            if(size > n) {
                --size

                // remove least recently used item in O(1) time implementation
                val leastRecentlyUsed: Pair<Int,Item?> = pq.peek()
                pq.remove()
                hashMap.remove(leastRecentlyUsed.first)

                // O(n) implementation
//                var leastUsed: Item? = hashMap[key]
//                var leastUsedIndex = -1
//                for(k in hashMap.keys) {
//                    if(leastUsed!!.usedScore > hashMap[k]!!.usedScore) {
//                        leastUsed = hashMap[k]
//                        leastUsedIndex = k
//                    }
//                }
//
//                if(leastUsedIndex != -1) {
//                    hashMap.remove(leastUsedIndex)
//                }
            }
        }

        // O(1)
        fun get(key: Int) : Item? {
            if(hashMap[key] != null) {
                ++mostUsedScore
                hashMap[key]?.usedScore = mostUsedScore
            }
            return hashMap[key]
        }

        fun cachedItems(): MutableSet<MutableMap.MutableEntry<Int,Item>> {
            return hashMap.entries
        }
    }
}