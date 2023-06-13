package ELSA

import chisel3._

class Memory extends Module {
  val io = IO(new Bundle {
    val keyOut = Output(UInt(8.W))
    val queryOut = Output(UInt(8.W))
    val valueOut = Output(UInt(8.W))
  })
    
    
}