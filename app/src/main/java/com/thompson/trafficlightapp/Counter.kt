package com.thompson.trafficlightapp

class Counter {
    private var count: Int = 0
    fun addCount() {
        count++
    }

    fun getCount(): Int {
        return count
    }
}