package app.model.model

data class ComputerSpec(
    var processorName : String,
    var processorTotalCore : Int,
    var isHaveGPU : Boolean,
    var totalRamInGB : Int,
    var EGPUName : String
)
