// See README.md for license details.

package vitcod

import chisel3._

/**
  * Compute GCD using subtraction method.
  * Subtracts the smaller from the larger until register y is zero.
  * value in register x is then the GCD
  */
class SparserEngine extends Module {
  val io = IO(new Bundle {
    
  })

  val weight =Wire(UInt(8.W))
  val output = Wire(UInt(8.W))
  val q_v = Wire(UInt(8.W))
  val k_s = Wire(UInt(8.W))
  val idx = Wire(UInt(8.W))


  val WBuf = Module(new WBuf())
  weight := WBuf.io.output

  val OBuf = Module(new OBuf())
  OBuf.io.input := output

  val IdxBuf = Module(new IdxBuf())
  idx := IdxBuf.io.output

  val Q_V_Buf = Module(new Q_V_Buf())
  q_v := Q_V_Buf.io.output

  val K_S_Buf = Module(new K_S_Buf())
  k_s := K_S_Buf.io.output

  val PE = Module(new PE())
  PE.io.k_s_in := k_s
  PE.io.q_v_in := q_v
  output := PE.io.output

  val EncDec = Module(new EncDec())
  val Softmax = Module(new Softmax())

}
