package practice

import app.model.model.ComputerSpec


class ScopeFunctionExample {

    private val creatorName: String? = null
    private var computerData : ComputerSpec? = null

    fun run() {
        creatorName?.let {
            println("Created by : $creatorName ")
        } ?: run {
            println("This program is open source")
        }
        println(computerData)
        computerData?.apply {
            this.processorName = "intel pentium"
        } ?: run { println("computer data")
        }

        computerData = ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveGPU = true,
            totalRamInGB = 32,
            EGPUName = "RTX 4060"
        )


        computerData?.apply {
            this.processorName = "intel Pentium"
        } ?: run { println("Computer data is null") }
        println(computerData)

        println(computerData?.processorName)
        println(computerData?.totalRamInGB)
        println(computerData?.isHaveGPU)

        with(computerData){
            println(this?.processorName)
            println(this?.totalRamInGB)
            println(this?.isHaveGPU)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ScopeFunctionExample().run()
        }
    }
}