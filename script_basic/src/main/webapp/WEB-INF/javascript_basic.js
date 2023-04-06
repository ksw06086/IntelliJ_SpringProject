// name = "Mike"; age = 30; 같음
// alert() : 알림창 띄움
// console.log : console에 결과 출력
// 변수선언 : let(변수), const(상수, 대문자)

// let name = "Mike";
// const age = 30;
// const NAME = "Miker";

// let name1 = "Mike";
// let name2 = 'Mike';
// let name3 = `mike`;

// const message = "I'm a boy.";
// const message2 = 'I\'m a boy.';

// const message3 = `My name is ${name}`;
// const message5 = "My name is ${name}";
// const message4 = `나는 ${30+1}살 입니다.`;

// 숫자를 0으로 나눈다면?
const x = 1/0;
console.log(x); // 무한대로 infinity 출력

const y = name/2;
console.log(y);
// NaN = Not a number

// boolean
// const a = true;
// const b = false;

// null(존재하지 않는 값)과 nudefined(값 할당 안됨)

// let age1;
// console.log(age1);

let user = null;
// 유저 존재 안함

// 객체형, 심볼형

// typeof 연산자 => 각자의 자료형 출력해줌, 다른 개발자가 사용한 변수의 타입을 알아야할 때
// null은 객체가 아니다 이건 스크립트 오류이다.
console.log(typeof 3);
console.log(typeof null);
console.log(typeof "xxx");
console.log(typeof undefined);

// 문자형 + 연산
// const name1 = "mike";

// const a = "나는 ";
// const b = " 입니다.";

// console.log(a+name1+b);

// const age = 30;
// console.log(a + age + "살" + b);

// *** 대화상자 ***
// alert() 알려줌
// alert("환영합니다, 님");

// prompt() 입력받음
// const name = prompt("이름을 입력하세요.");
// const name = prompt("예약일을 입력해주세요.", "2020-10-02");
// alert("환영합니다, " + name + "님");
// alert(`안녕하세요, ${name}님. 환영합니다.`);

// confirm() 확인받음
// const isAdult = confirm("당신은 성인입니까?");
// console.log(isAdult); => boolean 값이 출력됨

// *** 형변환 ***
// String() => 문자형으로 변환
// Number() => 숫자형으로 변환
// Boolean() => 불린형으로 변환

// prompt로 입력받을 시 모든게 문자형으로 오게됨
// const mathSocre = prompt("수학몇점?"); = 90
// const engSocre = prompt("영어몇점?"); = 80
// const result = mathScore + engScore / 2; => 4540점(/는 숫자로 자동 형변환해줌)

// console.log(result);

// 1. String();
console.log(String(3));
// 2. Number();
console.log(Number("1234"));
// 3. Boolean();
// false = 숫자 0, 빈 문자열 '', null, undefined, NaN

// ** 주의사항 **
// Number(null) // 0
// Number(undefined) // NaN
// Boolean(0) => false
// Boolean('0') => true
// Boolean('') => false
// Boolean(' ') => true

// *** FOR 문 ***
for(let i = 0; i < 10; i++){
    console.log(i);
}

// *** while 문 ***
let i = 0;
while(i < 10){
    console.log(i);
    if(i == 5){
        break;
    }
    i++;
}

// *** 함수 ***
// 1. 한번에 한 작업에 집중
// 2. 읽기 쉽고 어떤 동작인지 알 수 있게 네이밍 하는게 중요함

// *** 화살표 함수 ***
// let showError = () => {
//    ... 코드~;
//    return 값;
// }

// *** 객체(Object) ***
// 1. 객체생성
const superman = {
    name : 'clark',
    age : 33,
}
// 2-1. 객체 요소 접근
superman.name;
superman['age'];
// 2-2. 추가
superman.name = 'male';
// 2-3. 삭제
delete superman.age;

// 3. Object-단축 프로퍼티
const name1 = 'clark';
const age1 = 33;

const superman1 = {
    name1,  // name1=name1
    age1,   // age1=age1
    gender:'male',
}

// 4. Object-프로퍼티 존재 여부 확인
// 함수 인자를 받아올 때 데이터가 있는지 확인할 때 사용함
superman.birthDay;  // undefined
'birthDay' in superman;  // false
'age' in superman;  // true

// 5. for...in 반복문
for(let key in superman){
    console.log(key)
    console.log(superman[key])
}

// 6. 함수로 객체 인자 받기
function makeObject(name, age){
    return {
        name,
        age,
        hobby : 'football',
    }
}

const Mike = makeObject('Mike', 30);
console.log(Mike);
console.log('age' in Mike);
console.log('birth' in Mike);

function isAdult(user) {
    if(!('age' in user) || user.age < 20){
        return false;
    }
    return true;
}

const Mike2 = {
    name: "Mike",
    age: 30,
    fly() {
        console.log("날라갑니다.");
    }
};

const Jane = {
    name: "Jane"
};

console.log(isAdult(Jane))
Mike2.fly()

// 객체 안에서 자신의 멤버변수를 사용하고 싶을 때 this로 호출한다.
const user1 = {
    name : 'Mike',
    sayHello(){
        console.log(`Hello, I'm ${this.name}`);
    }
}

user1.sayHello();

// 화살표 함수와 일반 함수의 차이점
// 화살표 함수 : 자신만의 this를 가지지 않음 사용못함 그래서 외부에서 가져와야함
// 일반 함수 : 자신만의 this를 가지고 있어서 사용할 수 있음

// **** Array 배열에 대한 것([]로 함) ****
let students = ['철수', '영의', '와우'];
// 값 찾기 : students[0]

// * 배열의 특징
// 문자 뿐 아니라 숫자, 객체, 함수 등도 포함할 수 있음
// length - 배열의 길이 반환
// 메소드
// 1) push -> 뒤에서 추가
// 2) pop -> 뒤에서 삭제
// 3) unshift -> 앞에서 추가(여러개 추가 가능)
// 4) shift -> 앞에서 삭제

// ㅁ 배열과 for문
let days = ['월', '화', '수'];
for(let index = 0; index < days.length; index++){
    console.log(days[index]);
}

// ㅁ 배열과 for .. of -> for .. in은 단점이 많아 권장 안함(사용은 가능함)
for(let day of days){
    console.log(day);
}