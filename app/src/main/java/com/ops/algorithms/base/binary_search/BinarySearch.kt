package com.ops.algorithms.base.binary_search

import kotlin.random.Random

const val NUM_ITEMS = 1000

fun main() {
    val list = (1..NUM_ITEMS).map { Random.nextInt(1, 1000) }.shuffled()

    val target = list.random()
    println("Target: $target")
    println("Target en el index: ${binarySearch(list, target)}")
}

private fun binarySearch(list: List<Int>, target: Int): Int {
    var sortedList = list.sorted()
    var left = 0
    var right = sortedList.size - 1

    while (left <= right) {
        var mid = (left + right) / 2

        if (target == sortedList[mid]) {
            println("Found: ${sortedList[mid]}")
            return mid
        } else if (target < sortedList[mid]) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return -1
}