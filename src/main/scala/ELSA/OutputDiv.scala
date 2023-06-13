package ELSA

import chisel3._

class OutputDiv extends Module {
  val io = IO(new Bundle {
    val input = Input(UInt(8.W))
    val outputMem = Output(UInt(8.W))
  })
    
}