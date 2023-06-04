// See README.md for license details.

package vitcod

import chisel3._


class EncDec extends Module {
  val io = IO(new Bundle {
    //Decode:
    val encinput = Input(UInt(8.W))
    val decoutput = Output(UInt(8.W))
    //Encode:
    val decinput = Input(UInt(8.W))
    val encoutput = Output(UInt(8.W))
    //Weights:
    val weight = Input(UInt(8.W))
  })

  /*To Do: Implement encode and decode*/
  
}
