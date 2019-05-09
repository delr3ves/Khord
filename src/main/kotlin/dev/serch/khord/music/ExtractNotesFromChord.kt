package dev.serch.khord.music

import dev.serch.khord.music.Interval.Companion.INTERVALS_BY_CHORD

class ExtractNotesFromChord {

    operator fun invoke(chord: String): List<Note> {
        val parts = chordRegex.matchEntire(chord)
        if (parts != null) {
            val values = parts.groupValues
            val tonicAsString = values[1]
            val modifier = values[2]
            val mode = values[3]
            val tonic = extractTonic(tonicAsString, modifier)
            val intervals = extractIntervals(tonic, mode)
            return listOf(tonic) + intervals
        }
        return listOf()
    }

    private fun extractTonic(tonic: String, modifier: String): Note {
        val candidate = Note.valueOf(tonic.toUpperCase())
        return when (modifier) {
            "#" -> candidate.next()
            "b" -> candidate.prev()
            else -> candidate
        }
    }

    private fun extractIntervals(tonic: Note, mode: String): List<Note> {
        return INTERVALS_BY_CHORD.getOrDefault(mode, listOf()).map {
            tonic.forInterval(it)
        }
    }

    private val chordRegex = "([A-G])([#|b]?)(.*)".toRegex(setOf(RegexOption.IGNORE_CASE))
}
