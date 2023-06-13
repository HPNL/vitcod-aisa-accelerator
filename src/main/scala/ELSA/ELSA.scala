package ELSA

import chisel3._

class DF extends Module {
  val io = IO(new Bundle {
    val output = Output(UInt(8.W))
  })
    val df = Module(new DF())
    val memory = Module(new Memory())
    
    val query =Wire(UInt(8.W))
    val key =Wire(UInt(8.W))
    val value = Wire(UInt(8.W))

    val keyID = Wire(UInt(8.W))

    keyID := df.io.keyID
    df.io.keyVec := key
    df.io.valueVec := value
    df.io.queryVec := query
    output := df.io.output

    key := memory.io.keyOut
    value := memory.io.valueOut
    query := memory.io.queryOut
    
}