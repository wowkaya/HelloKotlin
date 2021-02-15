
/* list
자바와 다르게 list 에는 읽기 전용과 수정가능한 객체 등 2가지가 각각 지원
읽기전용 리스트 객체를 만들 때는 listOf 라는 함수를 사용함
쓰기전용 리스트 객체를 만들 때는 mutableListOf 라는 함수를 사용함

filterNotNull 이라는 함수를 사용하면 null 을 제외한 나머지 요소만 다룰 수 있음
+, - 연산자를 이용해서 특정 요소를 추가하거나 제거할 수 있음
*/

/* map
자바와 다르게 map 에는 읽기 전용과 수정가능한 객체 등 2가지가 각각 지원
읽기전용 리스트 객체를 만들 때는 mapOf 라는 함수를 사용함
쓰기전용 리스트 객체를 만들 때는 mutableMapOf 라는 함수를 사용함
+,- 연산자를 이용해 특정요소를 추가/제거할 수 있는데, 제거시 반드시 키를 지정해야 함
*/


fun main () {
    val names = listOf("혜교","지현","수지")

    for (i in 0..names.size-1) println(names[i])
    // names.add("길동")      // 읽기전용이라 추가 불가

    val names2 = mutableListOf("혜교","지현","수지")
    for (i in 0..names2.size-1) println(names2.get(i))
    names2.add("길동")        // 쓰기기능이라 추가 가능

    println("")

    var names2b = names2 + null     // null을 추가함
    for (i in 0..names2b.size-1) println(names2b.get(i))

    println("")

    names2b = names2b - "지현"
    for (i in 0..names2b.size-1) println(names2b.get(i))

    println("")

    for (str in names2b.filterNotNull()) println(str)
    // null 인 요소를 제외하고 foreach문 형ㅇ식으로 출력

    var names3 = mutableMapOf(1 to "혜교", 2 to "지현", Pair(3, "수지"))
    names3[4] = "길동"        // 새로운 데이터 추가
    names3.put(5, "영희")
    names3[1] = "철수"        // 기존데이터 수정

    for (name in names3) print("${name.key} ${name.value} /")
    println("")
    var names3b = names3 - 3        // 3번째 항목 제거
    for (i in names3b.keys) print("${names3b.get(i)} ")
    println("")
    var names3c = names3b +(6 to "지은")      // 3번째 항목 제거
    for (i in names3c.keys) print("${names3c.get(i)} ")

}