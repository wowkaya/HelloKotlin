
/* Kotlin 변수선언

변수의 종류에는 가변변수와 불변변수가 있음
가변변수: 변수 선언 시 var 키워드 사용
         변수에 초기값을 선언한 뒤 나중에 값 변경 가능
불변변수: 변수 선언시 val 키워드 사용
         변수에 초기값을 선언하면 나중에 값 변경 불가

초기값을 이용한 변수타입 추론
자바와는 다르게 변수 타입을 지정하지 않아도 됨
변수 초기값을 이용해 변수의 자료형을 컴파일러가 추론

초기값 없이 변수 선언
초기값 없이 변수 선언 하는 경우, 컴파일러는 타입을 추론할 수 없음
따라서 변수 타입을 선언해야함
    var/val 변수명:타입 = 초기값
    var/val 변수명:타입(*첫글자는 대문자로!!) */

/*
문자열 템플릿
문자열과 변수값을 합쳐서 출력하는 방법
단, 문자열과 변수를 합쳐서 출력하려면 변수명 앞에 $를 붙임
또한, 변수와 문자열을 붙여서 출력하려면 -> ${변수명}

코틀린 자료형
Int, Double, Float, Long, Short, Byte, Char, Boolean, String,
Any, Unit, Nothing

타입 형변환
코틀린에서 형변환은 to타입명()으로 간단하게 사용가능

값 입력받기
readline() 함수를 사용해서 사용자 입력값을 처리할 수 있음   */

/*
nullable
코틀린의 타입은 기본적으로 null을 사용할 수 없음 (non-nullable)
따라서, 어떤 변수에 null이 발생할 것 같으면 컴파일러가 귀신같이 알아내 컴파일 오류 출력
이를 방지하려면 null safety operator 중 하나인 double-bang 연산자(!! 느낌표 두개)를 이용
'비록 null이 올 수 있는 변수지만 null이 절대 할당되지 않음을 단언한다'
는 의미를 컴파일러에게 알려줄 수 있음
실제는 NPE(Null Point Exception)이 어디서 발생하는지 알아내는 용도로 사용

또한, 안전호출연산자(?.)를 이용해서 어떤 변수값이 null 이면 코드를 실행하고
그렇지 않은 경우 무시하고 넘어가도록 할 수 있음
=> ?. 은 참조값이 null이 아니면 실행하라는 의미
    var name: String? = null        -> null 허용하도록 변수 선언 (null 가능 타입)
    name = name?.capitalize()       -> name이 null이면 capitalize 함수는 실행하지 않음

null 복합연산자(앨비스 연산자)를 사용하면 삼항연산자를 이용해서 null 체크에 따라 적절한 값 대입 가능
    name = name ?: 'null입니다'      -> name이 null이면 'null입니다'라는 문자열이 name에 할당
 */


fun main(){
    val name = "혜교"
    var kor = 100
    var eng = 100
    var mat = 100

    var tot:Int     // 변수타입 직접선언
    var avg:Float
    var grd:Char


    println("이름은 $name 이고,")
    println("국영수는 $kor, $eng, $mat 입니다.")

    //name = "지현"     // val로 선언한 변수는 값 변경 불가
    kor = 99
    eng = 99
    mat = 99


    // 이름, 성적데이터 입력받기 1
    /*print("이름을 입력하세요")
    var Name = readLine()
    print("국어점수를 입력하세요")
    kor = readLine()!!.toInt()
    print("영어점수를 입력하세요")
    eng = readLine()!!.toInt()
    print("수학점수를 입력하세요")
    mat = readLine()!!.toInt()

    print("이름은 ${Name}이고, \n" +
            "국영수 점수는 $kor,$eng,$mat 입니다.")
    print("총점과 평균은 ${kor+eng+mat}, ${(kor+eng+mat)/3} 입니다.")*/


    // 이름, 성적데이터 입력받기 2
    print("이름을 입력하세요")
    var Name = readLine()?.ifEmpty { "가연" }
    print("국어점수를 입력하세요")
    kor = readLine()?.toIntOrNull() ?: 0
    print("영어점수를 입력하세요")
    eng = readLine()?.toIntOrNull() ?: 0
    print("수학점수를 입력하세요")
    mat = readLine()?.toIntOrNull() ?: 0

    print("이름은 ${Name}이고, \n" +
            "국영수 점수는 $kor,$eng,$mat 입니다.")
    print("총점과 평균은 ${kor+eng+mat}, ${(kor+eng+mat)/3} 입니다.")



}