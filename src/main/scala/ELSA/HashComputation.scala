package ELSA

import chisel3._

class HashComputation extends Module {
  val io = IO(new Bundle {
    val key = Input(UInt(8.W))
    val query = Input(UInt(8.W))
    val queryOut = Output(UInt(8.W))
    val keyOut = Output(UInt(8.W))
  })
    
}