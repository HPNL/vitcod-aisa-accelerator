package ELSA

import chisel3._

class DF extends Module {
  val io = IO(new Bundle {
    val keyID = Output(UInt(8.W))
    val keyVec = Input(UInt(8.W))
    val queryVec = Input(UInt(8.W))
    val valueVec = Input(UInt(8.W))
    val output = Output(UInt(8.W))
  })
    val arb = Module(new Arb())
    val attentionComputation = Module(new AttentionComputation())
    val candidateSelection = Module(new CandidateSelection())
    val hashComputation = Module(new HashComputation())
    val keyHashMemory = Module(new KeyHashMemory())
    val keyNormMemory = Module(new KeyNormMemory())
    val normComputation = Module(new NormComputation())
    val outputDiv = Module(new OutputDiv())
    val queryHashBuffer = Module(new QueryHashBuffer())
    
    val queryBufferOut =Wire(UInt(8.W))
    val queryBufferIn =Wire(UInt(8.W))

    val keyHashMemoryIn = Wire(UInt(8.W))
    val keyHashMemoryOut = Wire(UInt(8.W))

    val keyNormMemoryIn = Wire(UInt(8.W))
    val keyNormMemoryOut = Wire(UInt(8.W))

    val outDivIn = Wire(UInt(8.W))

    val candidateSelectionOut = Wire(UInt(8.W))
    

    arb.io.input := candidateSelectionOut
    io.keyID := arb.io.output

    attentionComputation.io.keyVec := io.keyVec
    attentionComputation.io.query := io.queryVec
    attentionComputation.io.value := io.valueVec
    outDivIn := attentionComputation.io.output

    candidateSelection.io.queryHash := queryBufferOut
    candidateSelection.io.keyHash := keyHashMemoryOut
    candidateSelection.io.keyNorm := keyNormMemoryOut
    candidateSelectionOut := candidateSelection.io.output

    hashComputation.io.key := keyVec
    hashComputation.io.query := queryVec
    queryBufferIn := hashComputation.io.queryOut
    keyHashMemoryIn := hashComputation.io.keyOut

    keyHashMemory.io.input := keyHashMemoryIn
    keyHashMemoryOut := keyHashMemory.io.output

    keyNormMemory.io.input := keyNormMemoryIn
    keyNormMemoryOut := keyNormMemory.io.output

    //normComputation.io.input := 
    keyNormMemoryIn := normComputation.io.output

    outputDiv.io.input := io.output
    outDivOut := outputDiv.io.output

    queryHashBuffer.io.input := queryBufferIn
    queryBufferOut := queryHashBuffer.io.output

    
        

    
    

}