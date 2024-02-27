package practice

import app.model.model.ComputerSpec

class ControlFlowExample {

    fun run(){
        println(checkName("nope"))
        printSomething()
    }

 private fun checkName(name : String): String {

        return if (name == null) {
            "Your name still Empty"
        } else if (name.contains("Nope", ignoreCase = true)) {
            "aku dimana"
        } else if (name.contains("Nope", ignoreCase = true)) {
            "aku di surabaya"
        } else {
            "gtw"
        }
    }

    private fun checkNameUsingWhen(name:String?) {
        //when biasanya digunakan untuk nilai yang fix

    }

    private fun exampleWhen(){
//        val contentType = ContentType.REELS
//        when(contentType).VIDEO -> {
//            println("konten ")
//        }
    }

//    private var name:String?  = "Tony Strak"
//
//    private fun checkName(){
//        //escape condition
//        if (name = null) return
//        println("Nama anda adalah $name")
//        println("Anda adalah anak pemilik BCA")
//    }

    private val computerData = listOf(

        ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveGPU = true,
            totalRamInGB = 32,
            EGPUName = "RTX 4060"
        ),

        ComputerSpec(
            processorName = "Intel i5",
            processorTotalCore = 8,
            isHaveGPU = true,
            totalRamInGB = 16,
            EGPUName = "RTX 4080"
        )
    )

    fun printSomething(){
        //for-loop
        for(index in 1..10){
          println("Ini looping ke : $index")
        }

        for(index in 1..10 step 2 ){
            println("Ini looping ke : $index")
        }
        for(index in 10 downTo 3 step 2) {
            println("Ini looping ke : $index")
        }
        for (index in computerData.indices){
            println("$index ${computerData[index]}")
        }

        var index = 0
        do
        {
            println(index)
            index++
        }while (index < 5)

        index = 0
        while (index < 5){
            println(index)
            index++
        }
  //escape
        for(index in 1..10){
            if (index == 5) continue
                println("Ini looping ke : $index")
        }

        for(index in 1..10){
            if (index == 5) break
            println("Ini looping ke : $index")
        }

    }




    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            ControlFlowExample().run()
        }
    }
}

enum class ContentType{
    PHOTO,VIDEO,REELS
}