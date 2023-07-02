package vitcod

import chisel3._

class Engine extends Module {
  val io = IO(new Bundle {
    
  })
    val denserEngine = Module(new DenserEngine())
    val sparserEngine = Module(new SparserEngine())

}