package app.model

import app.model.model.ComputerSpec

class App(var creatorName: String? = null) {

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

    private var selectedComputer: ComputerSpec? = null

    fun run() {
        printHeader()
        getSelectedComputer()
    }

    private fun printHeader() {

        println("===========================")
        //let
        creatorName?.let {
            println("My Name is : $creatorName ")
        } ?: run {
            println("This program open source")
        }

        println("===========================")
        println("Order PC app")
        println("===========================")

        computerData.forEachIndexed { index, data ->
            println("${index + 1}.${data.processorName} : ${data.EGPUName}") //lamda function
        }

    }

    private fun getSelectedComputer() {
        println("===========================")
        println("Masukkan Pilihan Anda")

        try {
            val selectedIndex = readln().toInt()
            if (selectedIndex in 1..computerData.size) {
                selectedComputer = computerData[selectedIndex - 1]
                println("Pilihan komputer anda : $selectedComputer")
            } else {
                println("pilihan salah silahkan coba lagi")
                getSelectedComputer()
            }
        } catch (e: NumberFormatException) {
            println("menu anda salah")
            getSelectedComputer()

        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App("Hermas").run()
        }
    }

}
fun main() {
    App().run()
}