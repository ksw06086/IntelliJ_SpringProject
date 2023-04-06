// var와 let의 차이점
// var : var name 을 여러번 선언해도 에러가 생기지 않음, 선언과 할당이 함께함
// let : let name이라고 2번 이상 선언하면 에러가 생김
// 1) var는 사용한 후에 선언해도 에러가 생기지 않음 let은 생김
// 2) 호이스팅(선언은 100줄에서 되었지만 이미 선언된걸로 올라감)은 var, let, const 모두 해줌
// 3) Temporal Dead Zone 때문에 var처럼 되지 않음, let과 const는 잠재적 오류를 예측하게 해주게 함

// var : 함수 스코프 -> 함수 내에서만 함수 내 지역변수가 됨 그 외는 다른 곳에서 사용가능
// let : 블록 스코프 ( 함수, if, for, while, try/catch 문)


// **** 생성자 함수 ****
// - 객체를 여러개 생성해야할 때 주로 사용함
function User(name, age){
    // // => 이미 미리 생성해줌
    // this = {}
    this.name = name;
    this.age = age;
    this.sayName = function(){
        console.log(this.name);
    }
    // return this;
}

let user1 = new User('Mike', 30);
let user2 = new User('Jane', 20);
let user3 = new User('Tom', 17);
user1.sayName();

// **** Computed property ****
// ex1)
let a = 'age';
const user = {
    name : 'Mike',
    [a] : 30, // [a]로 바꾸면 a 값이 저기에 들어가게 됨
}
// ex2) {5: 5, 안녕하세요: "Hello"}
// const user = {
//   [1+4] : 5,
//   ["안녕" + "하세요"] : "Hello"
// }

// ** Object Method **
// 1) Object.assign() : 객체 복제
const cloneUserEx = user
// ㄴ 객체가 새로 생성되는게 아니라 주소가 같아져서 값을 바꾸면 user객체의 값도 바뀌어짐
// {}는 초기값임, 2번째 인수가 병합됨, 2개 이상의 객체를 병합할 수 있음
const cloneUser = Object.assign({}, user);
// const cloneUser = Object.assign({gender : 'male'}, user);
// ㄴ 병합하게 되어서 추가하게 됨
// const cloneUser = Object.assign({name : 'Tom'}, user);
// ㄴ 키가 같아서 2번째 인수로 덮어쓰여지게 됨

// 2) Object.keys() : 키들을 배열로 반환함
Object.keys(user);
// 3) Object.values() : 값들을 배열로 반환함
Object.values(user);

// 4) Object.entries() : 키와 값들을 배열로 반환함
Object.entries(user);
// [
//    ["name", "Mike"],
//    ["age", 30],
//    ["gender", "male"],
// ]

// 4) Object.fromEntries() : 키와 값들을 배열로 주면 객체 반환함
const arr =
    [
        ["name", "Mike"],
        ["age", 20],
        ["gender", "male"],
    ]
Object.fromEntries(arr);


/// ****** 심볼(Symbol) ******

