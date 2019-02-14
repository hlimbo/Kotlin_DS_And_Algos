fun dailyProblem47(stockPrices: ArrayList<Long>) : Long {
    // 1. find the minimum stock price index ti
    var ti = 0
    for(t in 1 until stockPrices.size) {
        if(stockPrices[ti] > stockPrices[t])
            ti = t
    }

    // 2. find the max stock price AFTER min stock price at index ti is located
    var t = ti + 1
    var netProfit: Long = 0
    while(t < stockPrices.size) {
        val netAmount = stockPrices[t] - stockPrices[ti]
        if(netAmount > netProfit)
            netProfit = netAmount
        ++t
    }
    return netProfit
}