package lambda.base

/**
 * desc: lambda作为方法参数演示和原理分析
 *
 * Created by Chiclaim on 2018/09/24
 */

fun postDelay0(delay: Long, runnable: Runnable) {
    runnable.run()
}

inline fun postDelay1(delay: Long, runnable: () -> Unit) {
    runnable()
}

fun postDelay2(delay: Long, runnable: () -> Unit) {
    runnable()
}


fun main(args: Array<String>) {


    //创建一个实现了Runnable接口的内部类。
    //下面lambda没有访问外部的任何变量，所以不管postDelay触发多少遍，只会有一个Runnable对象
    //因为这个runnable对象是该内部类的常量
    postDelay0(1000, Runnable {
        println("postDelay0")
    })

    //如果再调用一次postDelay会怎样？会创建一个和上面一样的实现了Runnable接口的内部类
    //调用postDelay0方法传入的runnable参数，就是该内部类的对象
    //由此可见有多少个lambda，就会有多少个内部类
    postDelay0(1000, Runnable {
        println("postDelay0 another")
    })

    //但是如果该方法是内联函数(inline)，则不会创建内部类
    postDelay1(1000) {
        println("inline postDelay1")
    }

    val flag = 10
    //下面的lambda访问了外部的flag变量，postDelay2方法调用一次便创建一个lambda对象
    postDelay2(1500) {
        println("postDelay2 $flag")
    }

    //------------可以集合class字节码来分析
}