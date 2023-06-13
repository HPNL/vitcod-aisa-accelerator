
package vitcod

import chisel3._

class MAC extends Module {
  val io = IO(new Bundle {
      val k_s_in = Input(UInt(8.W))
      val q_v_in = Input(UInt(8.W))
      val start_in = Input(UInt(8.W))
      val out_sel = Input(Bool())
      val sum_in_sel = Input(Bool())
      val out = Output(UInt(8.W))
  })
  val mul = Wire(UInt(8.W))
  val sum = Wire(UInt(8.W))
  val sum_in = Wire(UInt(8.W))

  mul := io.k_s_in * io.q_v_in
  sum := mul*sum_in
  io.out := Mux(io.out_sel,sum,mul)
  sum_in := Mux(io.sum_in_sel,io.out,io.start_in)
  
}
