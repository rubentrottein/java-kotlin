//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    /*
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }
    */

    var hp = 10;
    hp = substract(5, hp);
    println(hp);

    hp = add(3, hp);
    println(hp);

    hp = divide(3, hp);
    println(hp);

    hp = multiply(3, hp);
    println(hp);


    kotlinElements.handleInput()
}

fun substract(atk : Int, hp : Int): Int {
    return hp - atk;
}

fun add(heal : Int, hp: Int): Int {
    return hp + heal;
}

fun divide(divider : Int, hp: Int): Int {
    try{
        return hp / divider;
    }catch (arithmeticException e){
        return e;
    }
}

fun multiply(boost: Int,  hp: Int): Int {
    return hp * boost;
}