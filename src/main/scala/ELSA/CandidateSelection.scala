package ELSA

import chisel3._

class CandidateSelection extends Module {
  val io = IO(new Bundle {
    val queryHash = Input(UInt(8.W))
    val keyHash = Input(UInt(8.W))
    val keyNorm = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })
    
}