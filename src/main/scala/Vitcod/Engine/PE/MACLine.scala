// See README.md for license details.

package vitcod

import chisel3._

class MACLine extends Module {
  val io = IO(new Bundle {
    val k_s_in = Input(UInt(32.W))
      val q_v_in = Input(UInt(8.W))
      val out = Output(UInt(8.W))
  })
  val macs = Seq.fill(4)(Module(new MAC()))
  for (i <- 0 until 4) {
    macs(i).io.k_s_in := io.k_s_in(8*i-1, 8*i).asTypeOf(io.k_s_in)
    macs(i).io.q_v_in := io.q_v_in
    when(i.U===0.U){
      macs(i).io.start_in := 0.U
    }otherwise{
      macs(i).io.start_in := macs(i-1).io.out
    }

  }
}
