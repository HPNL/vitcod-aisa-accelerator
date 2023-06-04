
package vitcod

import chisel3._

class MAC extends Module {
  val io = IO(new Bundle {
      val k_s_in = Input(UInt(8.w)),
      val q_v_in = Input(UInt(8.w)),
      val start_in = Input(UInt(8.w)),
      val out = Output(UInt(8.w))
  })
  val mul = Wire(UInt(8.w))
  val sum = Wire(UInt(8.w))
  val sum_in = Wire(UInt(8.w))

  mul := io.k_s_in * io.q_v_in
  sum := mul*sum_in
  io.out := mux(io.out_sel,sum,mul)
  sum_in := mux(io.sum_in_sel,io.out,io.start_in)
  

}
