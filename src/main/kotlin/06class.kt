
/* object
싱글톤 패턴 코드처럼 단일 객체로 선언하고 싶다면
클래스 정의시 object 를 사용하면 됨

companion object
자바의 static 변수를 만들고 싶다면
companion object 블록에 변수를 정의하고
클래스명.변수명으로 호출하면 됨

data class
자바의 VO 클래스를 만들고 싶다면 클래스 정의시 data를 사용하면 됨
클래스 내부에 함수는 포함하면 안됨

코틀린의 클래스 상속
모든 클래스의 조상클래스는 Any
Any 클래스는 기본적으로 equals, toString, hashCode 등이 멤버 메서드로 구성
부모클래스 상속시 ':부모클래스()' 형태로 작성
자식클래스가 상속받으려면 부모클래스에 open 이라고 선언해야 함
부모클래스의 메서드를 재정의하려면 함수에 open 이라고 선언해야 함

스마트 캐스팅
자손객체를 부모타입에 대입하는 경우 '암시적 형변환' 발생 - 스마트 캐스팅
반면, 부모 객체를 자손타입에 대입하는 경우 '명시적 형변환' 필요
*/

object Person{
    var name: String = ""
    var age: Int = 0

    fun print() {
        println ("$name $age")
    }

} // 단일 객체로만 생성됨

class Counter {
    companion object {

        fun add() { cnt += 1 }   // add 메서드 호출시 cnt를 하나 증가시킴
        var cnt = 0     // 카운트 값을 저장하는 변수, static 변수
        // static 변수를 조작하려면 static 메서드를 사용해야함
    }
}

data class Employee (val empno:String, val fname:String, val lname:String)
// 생성자이면서 -> setter/getter 필요없음

open class Parent {
    val name:String = "parent"
    fun sayHello () = println("Hello, World!!")
}

class Child: Parent () {
    fun sayagain() = println("Hello, Kotlin!!")
}

open class Parent2 () {
    val name:String = "parent"
    open fun sayHello() = println("Hello, World!!")     // 오버라이딩 가능
}

class Child2: Parent2 () {
    override fun sayHello() = println("Hello, World@@")         // 자식클래스에서 재정의
    fun sayagain() = println("Hello, Kotlin@@")
}

fun main() {
    // 단일 객체를 사용할 때는 객체 생성과정 불필요!
    Person.name="혜교"
    Person.age= 35
    Person.print()

    var a = Counter.add()       // Counter 객체 생성 : cnt
    var b = Counter.add()

    println("카운트된 cnt 수: ${Counter.cnt}")

    var emp1 = Employee("1", "Steve", "King")
    var emp2 = Employee("2", "Eric", "Gamma")

    println(emp1.toString())
    println(emp2.toString())

    val child = Child()
    println(child.name)     // 부모클래스의 super 변수 출력
    child.sayagain()
    child.sayHello()        // 부모클래스의 super 메서드 출력


    val child2 = Child2()
    println(child2.name)     // 부모클래스의 super 변수 출력
    child2.sayagain()
    child2.sayHello()        // 재정의한 메서드 출력


    val p1:Parent = Child()         // 스마트 캐스팅
    // val c1:Child = Parent()  // 오류 !! 명시적 형변환 필요!
    val c1:Child = Parent() as Child    // as 키워드를 이용한 명시적 형변환 실시


}