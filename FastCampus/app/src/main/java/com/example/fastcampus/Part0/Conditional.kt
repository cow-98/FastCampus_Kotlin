package com.example.fastcampus.Part0
// 조건식
fun main() {
    Max(10,3)
    isHoliday("월")
}

fun Max (a: Int, b: Int){
   val res = if(a > b) {
       a
   } else {
       b
   }
    println(res)

    // 위에 식을 간단하게 작성하면 -> val res = if (a>b) a else b
}
//월 화 수 목 금 토 일
fun isHoliday (dayOfWeek: String){
    val res = when (dayOfWeek) {
        "토","일" -> true
        else -> false
    }
    println(res)
}
