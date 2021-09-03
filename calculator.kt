 main() {
	var firstResult: Float? =  addTwoNumbers(1.0f, 2.0f)
    var funsecondResult: Float? = subtractNumber(2.0f, 1.0f)
    var thirdResult: Float? = multiplyTwoNumbers(2.0f, 2.0f)
    var fourthNumber: Float? = divideNumber(10.0f, 2.0f)
    
   println(firstResult)
   println(secondResult)
   println(thirdResult)
   println(fourthNumber)
  
  requestOption()
  
}

fun addTwoNumbers(numberOne: Float?, numberTwo: Float?):Float?{
    var result: Float?
    
    if (numberOne != null && numberTwo != null){
        result = numberOne + numberTwo
        
    }else{
        result = null
    }
    
    return result
}

fun subtractNumber(numberOne: Float?, numberTwo: Float?):Float?{
    var result: Float?
    
    if (numberOne != null && numberTwo != null){
        result = numberOne - numberTwo
    }else{
        result = null
    }
    
    return result 
    
}

fun multiplyTwoNumbers(numberOne: Float?, numberTwo: Float?) :Float?{
    var result: Float?
    
    if(numberOne != null && numberTwo !=null){
        result = numberOne * numberTwo
    }else{
        result = null
    } 
    
