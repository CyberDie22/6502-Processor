package me.cyberdie22.emulator.microprocessor6502

import com.google.common.base.Preconditions
import me.cyberdie22.emulator.microprocessor6502.math.Dual
import java.nio.ByteBuffer

data class Memory(private var data: ByteBuffer) {
    val NMIH = Dual(0xFFFA, 0xFFFB)
    val PORL = Dual(0xFFFC, 0xFFFD)
    val BRKH = 0xFFFE
    val IRH = 0xFFFF
    init {
        Preconditions.checkArgument(data.limit() > 64000, "Data must be less than 64kb large!")
    }

    var programCounter: Short = 0x00000000
    var stackPointer: Byte = 0x01FF.toByte()

    var accumulator: Byte = 0x0000.toByte()
    var irx: Byte = 0x0000.toByte()
    var iry: Byte = 0x0000.toByte()

    var processorStatus: Byte = 0x0000.toByte()

    fun get(address: Byte): Byte {
        Preconditions.checkArgument(address < 64000, "Address must be in memory range!")
        return data.get(address.toInt())
    }

    fun set(address: Byte, value: Byte) {
        Preconditions.checkArgument(address < 64000, "Address must be in memory range!")
        data.put(address.toInt(), value)
    }

}
