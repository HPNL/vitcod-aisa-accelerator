package ELSA

import chisel3._

class AttentionComputation extends Module {
  val io = IO(new Bundle {
    val keyVec = Input(UInt(8.W))
    val query = Input(UInt(8.W))
    val value = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })
}

