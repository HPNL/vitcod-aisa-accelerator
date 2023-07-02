package ELSA

import chisel3._

class Sum extends Module {
  val io = IO(new Bundle {
    val input = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })
    
}