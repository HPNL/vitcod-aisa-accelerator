// See README.md for license details.

package vitcod

import chisel3._

class MACLine extends Module {
  val io = IO(new Bundle {
    val k_s_in = Input(UInt(32.w)),
      val q_v_in = Input(UInt(8.w)),
      val out = Output(UInt(8.w))
  })
  val macs = Seq.fill(4)(Module(new MAC()))
  for (i <- 0 until 4) {
    instances(i).io.k_s_in := io.k_s_in(8*i-1, 8*i).asTypeOf(io.k_s_in)
    instances(i).io.q_v_in := io.q_v_in
    when(i.U==0.U){
      instances(i).io.start_in := 0.U
    }otherwise{
      instances(i).io.start_in := instances(i-1).io.output
    }

  }
}
