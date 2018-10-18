package visibility_modifier.modifier_member

/**
 * Desc: （相同包名）成员修饰符 演示
 * Created by Chiclaim on 2018/9/21.
 */
class MemberModifierTest {

    val memberModifier: MemberModifier = MemberModifier()

    fun call() {

        //memberModifier.gender    internal
        //memberModifier.username  public

        println("${memberModifier.username}'s gender ${memberModifier.gender}")
    }
}

//继承
class MemberModifierTest2 : MemberModifier() {
    fun call() {
        //gender //internal
        //username //public
        //asset  //protected

        println("$username's gender $gender, He has $asset")
    }

}