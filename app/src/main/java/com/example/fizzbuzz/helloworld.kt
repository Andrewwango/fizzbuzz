enum class BuildType {
    APPEND, PREPEND, REPLACE, KEEP
}

fun main() {
    val n = 2431
    for (x in 1..n){
        var builder : MutableList<String> = mutableListOf()

        //other conditions
        builder = checkMod(x, builder, "Fizz", BuildType.APPEND, 3)
        builder = checkMod(x, builder, "Fezz", BuildType.APPEND, 13)
        builder = checkMod(x, builder, "Buzz", BuildType.APPEND, 5)
        builder = checkMod(x, builder, "Bang", BuildType.APPEND, 7)
        builder = checkMod(x, builder, "Bong", BuildType.REPLACE, 11)
        builder = checkMod(x, builder, "Fezz", BuildType.REPLACE, 11, 13)
        builder = checkMod(x, builder, "Bong", BuildType.APPEND, 11, 13)

        if (x % 17 == 0) {
            builder = builder.asReversed()
        }
        val outputString = if (builder.size == 0) "$x" else builder.joinToString(separator="")
        println(outputString)
    }
}

fun checkMod(x : Int, builder : MutableList<String>, word : String, buildType : BuildType, m : Int, m2 : Int? = null) : MutableList<String> {
    var _buildType : BuildType
    if (m2 != null){
        _buildType = if (x%m == 0 && x%m2 == 0) buildType else BuildType.KEEP
    }
    else {
        _buildType = if (x%m == 0) buildType else BuildType.KEEP
    }

    when (_buildType){
        BuildType.APPEND -> builder.add(word)
        BuildType.PREPEND -> builder.add(0, word)
        BuildType.KEEP -> {}
        BuildType.REPLACE -> {
            builder.clear()
            builder.add(word)
        } //return
    }
    return builder

}