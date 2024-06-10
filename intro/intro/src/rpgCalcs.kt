//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun fight() {
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
    hp = attack(5, hp);
    println(hp);

    hp = healing(3, hp);
    println(hp);

    hp = magic(3, hp);
    println(hp);

    hp = burst(3, hp);
    println(hp);

}

fun attack(atk : Int, hp : Int): Int {
    return hp - atk;
}

fun healing(heal : Int, hp: Int): Int {
    return hp + heal;
}

fun magic(divider : Int, hp: Int): Int {
    try{
        return hp / divider;
    }catch (arithmeticException e){
        return e;
    }
}

fun burst(boost: Int,  hp: Int): Int { return hp * boost; }