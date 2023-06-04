// See README.md for license details.

package vitcod

import chisel3._

class PE extends Module {
  val io = IO(new Bundle {
    val k_s_in = Input(UInt(8.W))
    val q_v_in = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })
  
val macLines = Seq.fill(4)(Module(new MACLine()))
  for (i <- 0 until 4) {
    instances(i).io.k_s_in := io.k_s_in(8*i-1, 8*i).asTypeOf(io.k_s_in)
    instances(i).io.q_v_in := io.q_v_in(8*i-1, 8*i).asTypeOf(io.q_v_in)

}
}
