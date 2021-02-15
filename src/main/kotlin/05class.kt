
/* 코틀린 클래스
클래스의 객체 생성 시 new 연산자는 사용하지 않음


*/

class Person1 {
    var name:String = ""
    var age:Int = 0
}       // 자바의 멤버변수 정의하듯 클래스 선언

class Person2 (var name:String, var age:Int){
}       // 기본 생성자 형태로 멤버변수 정의하는 클래스 선언
        // 생성자 정의 시 constructor 라는 예약어 사용
        // 단, 기본생성자 정의시 생략가능

class Person3 (var name:String, var age:Int, var addr:String){
    constructor(name:String,addr:String):this(name,0,addr)
    // 보조생성자에서 기본생성자 호출시 this 라는 예약어 사용
    // 보조생성자 정의시 constructor 라는 예약어 반드시 사용

}   // 기본생성자와 보조생성자를 정의한 클래스 선언

class SungJuk (var name:String,var kor:Int,var eng:Int,var mat:Int) {
    val tot: Int get() {return kor + eng + mat}
    // 코틀린에서 자동으로 생성해준 getter 대신 개발자가 임의로 getter를 정의해서 사용할 수 있음

    val avg: Double get() {return tot.toDouble() / 3}   // 코드가 한줄이면 간단하게 작성할 수도 있음
    val grd: Char get() {
/*        return when (avg.toInt()) {
            in 90..100 -> '수'
            in 80..89 -> '우'
            in 70..79 -> '미'
            in 60..69 -> '양'
            else -> '가'*/
        return when (avg.toInt()/10) {
            9,10 -> '수'
            8 -> '우'
            7 -> '미'
            6 -> '양'
            else -> '가'
        }
    }
}

class Member (var mno:String, var name:String, var jumin:String, var userid:String,
              var passwd:String, var zipcode:String, var addr1:String, var addr2:String,
              var email:String, var phone:String, var regdate:String) {}

class SungJuk2 (var name:String,var kor:Int,var eng:Int,var mat:Int) {
    var tot:Int = 0
    var avg:Double = 0.0
    var grd:Char = '가'

    init {
        computeSungJuk()
    }   // 초기화블럭, 기본생성자 호출 후 추가적으로 작업 할 내용을 작성해 둠

    fun computeSungJuk(){
        tot = kor + eng + mat
        avg = tot.toDouble()/3
        grd = when (avg.toInt()/10){
            9,10 -> '수'
            8 -> '우'
            7 -> '미'
            6 -> '양'
            else -> '가'
        }
    }
}       // 클래스내에 멤버함수도 포함할 수 있음


fun main () {
    val p = Person1()
    p.name = "혜교"
    p.age = 35
    println("이름: ${p.name}, 나이: ${p.age}")

    val p2 = Person2("지현", 40)
    println("이름: ${p2.name}, 나이: ${p2.age}")

    val p3 = Person3("수지", "서울시")
    println("이름: ${p3.name}, 나이: ${p3.age}, 주소: ${p3.addr}")

    val sj = SungJuk("가연", 100,100,100)
    println("총점: ${sj.tot}, 평균:${sj.avg}, 학점:${sj.grd}")

    val m = Member ("100","가연","861020","lotus",
                    "a123","14356","경기도 광명시","소하로 56",
                    "wowkaya@gmail.com","01037441853","2021-02-10")
    println("${m.name} ${m.userid} ${m.email}")

    val sj2 = SungJuk2("가연", 80,80,100)
    sj2.computeSungJuk()
    println("총점: ${sj2.tot}, 평균:${String.format("%.1f",sj2.avg)}, 학점:${sj2.grd}")

}

