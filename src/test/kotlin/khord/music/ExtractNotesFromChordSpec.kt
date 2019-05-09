package dev.serch.khord.music

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class ExtractNotesFromChordSpec : StringSpec({

    val extractNotesFromChord = ExtractNotesFromChord()

    "should be able to extract chords from string" {
        forall(
            row("Cbm7", listOf(Note.B, Note.D, Note.`F#`, Note.A)),
            row("C", listOf(Note.C, Note.E, Note.G)),
            row("Cm", listOf(Note.C, Note.`D#`, Note.G)),
            row("C7", listOf(Note.C, Note.E, Note.G, Note.`A#`)),
            row("C5", listOf(Note.C, Note.G)),
            row("C#6", listOf(Note.`C#`, Note.F, Note.`G#`, Note.`A#`)),
            row("Cm6", listOf(Note.C, Note.`D#`, Note.G, Note.A)),
            row("Dmaj7", listOf(Note.D, Note.`F#`, Note.A, Note.`C#`)),
            row("Fº", listOf(Note.F, Note.`G#`, Note.B)),
            row("Eº7", listOf(Note.E, Note.G, Note.`A#`, Note.`C#`)),
            row("A-5", listOf(Note.A, Note.`C#`, Note.`D#`)),
            row("A#+", listOf(Note.`A#`, Note.`D`, Note.`F#`))
        ) { chord, expected ->
            extractNotesFromChord(chord) shouldBe expected
        }
    }

    "should return only the tonic when the mode is not known" {
        forall(
            row("cwhatever", listOf(Note.C)),
            row("fuRenol", listOf(Note.F)),
            row("Bye bye", listOf(Note.B))
        ) { chord, expected ->
            extractNotesFromChord(chord) shouldBe expected
        }
    }

    "should return no notes when the chord is unknown" {
        forall(
            row("notAChord"),
            row("this is another invalid chord"),
            row("oh my god why this chord is so incorrect")
        ) { chord ->
            extractNotesFromChord(chord) shouldBe listOf()
        }
    }
})
