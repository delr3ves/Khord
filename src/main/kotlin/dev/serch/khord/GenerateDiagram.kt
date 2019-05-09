package dev.serch.khord

import dev.serch.khord.music.Instrument

interface GenerateDiagram {
    operator fun invoke(chord: String, instrument: Instrument)
}
