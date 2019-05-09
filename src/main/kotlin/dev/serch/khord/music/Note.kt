package dev.serch.khord.music

enum class Note(val position: Int) {
    C(0),
    `C#`(1),
    D(2),
    `D#`(3),
    E(4),
    F(5),
    `F#`(6),
    G(7),
    `G#`(8),
    A(9),
    `A#`(10),
    B(11);

    fun next(): Note {
        return fromPosition(position + 1)
    }
    fun prev(): Note {
        return fromPosition(position - 1)
    }

    fun forInterval(interval: Interval): Note {
        return fromPosition(position + interval.semitones)
    }

    companion object {
        fun fromPosition(position: Int): Note {
            val effectivePosition = (12 + position) % 12
            return values().find { it.position == effectivePosition }!!
        }
    }
}
