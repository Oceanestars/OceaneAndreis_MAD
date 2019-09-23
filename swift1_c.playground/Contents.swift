var message : String = "Hello class"
let classMax : Int = 30
var age : Int //Don't forget the Int
age = 20

var name = "someone"

print("HI")
print(name)
print("Hi "+name)
print("My name is \(name)")

//Constant
let a = 42 //int
let b = 0.123 //double
let c = Double(a)+b

//Tuple - any type
let violet = ("#EE82EE", 238, 130, 238)
print(violet)
print(violet.0)
let(hex, red, green, blue) = violet
print(hex) // same as print(violet.0)

var young = "You're young"
var notyoung = "you're not young"
//Conditionals
if age<21{
    print(young)
}
else{
    print(notyoung)
}

age < 21 ? young : notyoung //equivalent as the conditional above

switch age {
case 0...5: //range of 0-5, ...5
    print("You're little")
case 6..<21:
    print("enjoy school")
case 22...55: //22... would not have an end
    print("welcome to the real world")
default:
    print("I don't know what i'm doing")
}

for count in 0...age{
    print(count)
}

//functions
func sayHi(){
    print("Hi")
}
func sayHello(first:String, last:String){
    print("Hi \(first) \(last)")
    
}

sayHello(first: "Bill",  last: "Adams")

func sayWhat(firstName first: String, lastName last: String){
    //firstName = external name
    print("What \(first) \(last)")
    
}
sayWhat(firstName: "Stacey", lastName:"Smith")
func sayWhere(_ place:String){
    print(place)
}
sayWhere("Boulder")

//saywhere(_:String, _Int) two parameters
func sayWho(firstName: String, lastName:String)-> String{
    return "Who" + firstName + " " + lastName + "?"
}
let msg2 = sayWho(firstName: "jim", lastName: "Adams")
print(msg2)
