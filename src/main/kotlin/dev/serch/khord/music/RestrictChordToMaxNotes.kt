package dev.serch.khord.music

interface RestrictChordToMaxNotes {

    operator fun invoke(notes: List<Note>, maxConcurrentNotes: Int): List<Note>
}
