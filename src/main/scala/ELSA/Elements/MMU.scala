package ELSA

import chisel3._

class MMU extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(8.W))
    val b = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })
    
}