package me.cyberdie22.emulator.microprocessor6502

import java.nio.ByteBuffer
import me.cyberdie22.emulator.microprocessor6502.Instructions

class Processor(val data: ByteArray) {
    var memory = Memory(ByteBuffer.allocate(64000).put(data))
    fun execute() {

    }

    fun executeIns(address: Byte) {
        when (memory.get(address)) {
            
        }
    }
}