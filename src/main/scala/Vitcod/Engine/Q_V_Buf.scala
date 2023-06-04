package vitcod

import chisel3._

class Q_V_Buf extends Module {
    val io = IO(new Bundle {
    val input = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })

  val reg = RegInit(0.U(8.W))

  when (true.B) {
    reg := io.input
  }

  io.output := reg

}