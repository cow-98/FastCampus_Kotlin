package com.example.fastcampus.Part0
// 컬렉션 (list, map, set)
fun main() {
    val list = mutableListOf(1,2,3,4,5)
    list.add(6)
    list.addAll(listOf(7,8,9))

    val xlist = listOf(1,2,3,4) // 변경 불가
    xlist[0]

    val diverseList = listOf(1, "안녕", 1.78, true)

    println(xlist.map { it * 10 }.joinToString("/"))

    println(list.joinToString(","))

    val xmap = mapOf(1 to "안녕", 2 to "hello")
    val map = mutableMapOf(1 to "안녕", 2 to "hello")
    map[3] = "응"
    map[4] = "아니"

}
