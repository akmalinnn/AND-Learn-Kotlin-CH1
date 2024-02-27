package practice

import jdk.jfr.Event

/* 1. Class calculator, ga boleh keluar dari boundaries perhitungan tentang kalkulator

* */
class WrongCalculator() {

    fun plus(a: Int, b: Int) {
        val result = a + b
        println("Result is : $result")
    }
}

class CalculatorRight() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }
}

//fun main{
//    CalculatorRight().plus(7,8)
//}


//single responsibilty
// tiap fungsi dipisah sesuai dengan kegunaan

class RockPaperScissor() {

    private var playerOne: Int = -1
    private var playerTwo: Int = -1

    private fun printOptions() {

    }

    private fun showResult(playerOne: Int, playerTwo: Int): String {
        return if (((playerOne + 1) % 3) == playerTwo) {
            "Player 2 menang"
        } else if (playerOne == playerTwo) {
            "Seri"
        } else {
            "Player 1 menang"
        }
    }

    private fun inputPlayerOne() {
        println("masukkan pilihan 1 (0/1/2) :")
        playerOne = readln().toInt()
    }

    private fun inputPlayerTwo() {
        println("masukkan pilihan 2 (0/1/2)")
        playerTwo = readln().toInt()
    }

    fun run() {
        printOptions()
        inputPlayerOne()
        inputPlayerTwo()
        println(showResult(playerOne, playerTwo))
    }
}


//open close
//bagaimana cara kita untuk meng close sesuatu agar class lain tidak tau.
//tidak memodifier parent classnya
open class IronManSuit() {
    open fun blast() {
        println("Blast using laser powered by arc")
    }

    fun activeAi() {
        println("Jarvis is Actived")

    }
}

class WarMachineSuit() :IronManSuit(){
    override fun blast() {
//        super.blast()
        println("Sleep for 2 second")
        Thread.sleep(2000)
        println("duarrr")
    }
}

//LSP
// bagaimana cara kita mengganti suatu hal dengan hal yang lain
/* contoh

punya dua barista, orang medan kopi duluan baru air. orang madura air dulu baru kopi
* */
class Capadocia(){
    private lateinit var balloon : HotAirBalloon
        fun run (){
            //balloon = RedHotAirBallon()
            balloon = BlueHotAirBalloon()
            balloon.apply {
                carryPassengers()
                blow()
                pop()
            }
        }
    }

// interface Seg regation

interface Animal {
    fun eat()
    fun hunt()
    fun walking()
    fun sleep()
    fun jump()
    fun breath()
    fun sound()
    fun reproduction()
}

interface Aves : Animal{
    fun fly()
    fun swim()
}

class Bird() : Animal {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }




}

class CatFish() : Animal{
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }
}


//Dependency Inversion
/*
* */
class FirebaseAnalytics(){
    fun log(event: String){
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success!")
    }
}
class NewRelicAnalytics(){
    fun log(event: String){
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success!")
    }
}
class MoEngageAnalytics(){
    fun log(event: String){
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success!")
    }
}

interface Analytics {
    fun logEvent(event: String)
}

//agnostic class

class AppAnalytics : Analytics {
    private var firebaseAnalytics = FirebaseAnalytics()
    private var MoEngageAnalytics = MoEngageAnalytics()
    private var NewRelicAnalytics = NewRelicAnalytics()

    override fun logEvent(event: String) {
    }
}

class SplashScreen(private val analytics: Analytics){
    fun openPage(){
        println("Open Page Splash Screen")
        analytics.logEvent("spalshScreen")
    }
}
class HomePage(private val analytics: Analytics){
    fun openPage(){
        println("Open Page HomePage")
        analytics.logEvent("HomePage")
    }
}

class LoginPage(private val analytics: Analytics){
    fun openPage(){
        println("Open Page Login Page")
        analytics.logEvent("Login page")
    }
}

class App{
    private val analytics = AppAnalytics()

    fun run(){
        SplashScreen(analytics).openPage()
        HomePage(analytics).openPage()
        LoginPage(analytics).openPage()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}
fun main(args: Array<String>) {
//    RockPaperScissor().run()
//    WarMachineSuit().blast()
//    Capadocia().run()
}
