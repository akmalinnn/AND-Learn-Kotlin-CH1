package practice

private class Aclass(){
    private fun run(){
        println("this from A class ")
    }
    fun runPublic(){
        println("This is from Class A in public")
    }
}

class BClass(){
    fun run(){
        //cant call run bcs private
        // AClass().run()
        Aclass().runPublic()
        println("This in from class B")
    }
}

//abstraction
interface Balloon {
    fun blow()
    fun pop()
}

abstract class HotAirBalloon() : Balloon{
    override fun blow() {
        println("Isi balon dengan udara panas")
    }

    override fun pop() {
        println("Bahaya !!!!")
    }

    fun moveleft()
    {
        println("move left")
    }

    // Wajib di implement di turunan classnya
    abstract fun carryPassengers()

}

class RedHotAirBalloon(): HotAirBalloon(){

    // Wajib di implement di turunan classnya
    override fun carryPassengers() {
        println("Membawa 5 penumpang ")
    }

//    override fun pop() {
//        super.pop()
//    }

    override fun pop() {
        println("Ini red balon di pecah")
    }
}

class BlueHotAirBalloon(): HotAirBalloon(){

    // Wajib di implement di turunan classnya
    override fun carryPassengers() {
        println("Membawa 5 penumpang ")
    }

//    override fun pop() {
//        super.pop()
//    }

    override fun pop() {
        println("Ini blue balon di pecah")
    }
}

class RedBalloon(): Balloon{
    override fun blow() {
        println("Balon merah ditiup")
    }

    override fun pop() {
        println("Balon merah meledak")
    }

}

class BlueBalloon(): Balloon{
    override fun blow() {
        println("Balon biru ditiup")
    }

    override fun pop() {
        println("Balon biru meledak")
    }

}


//inheritance using open class
open class Processor(val name: String){
      open fun initProcessor(){
        println("initialize.... $name")
    }
}
//inheritance using open class
class AMDProcessor() : Processor("Ryzen 9")
class IntelProcessor() : Processor("i3")

abstract class ChangeProcessor() : Processor("Linux") {
    override fun initProcessor() {
        println("initializetttttttttter.... $name")
    }

}

class RunProcessor() : ChangeProcessor(){
    override fun initProcessor() {
        super.initProcessor()
    }
}

//fun main() {
//    RedHotAirBalloon().let{
//        //sifat kakek
//        it.blow()
//        it.pop()
//        //sifat bapak
//        it.moveleft()
//        it.carryPassengers()
//    }
//    AMDProcessor().initProcessor()
//    IntelProcessor().initProcessor()
//
//    RunProcessor().initProcessor()
//}