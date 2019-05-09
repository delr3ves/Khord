package khord.music

import dev.serch.khord.music.Interval
import dev.serch.khord.music.Interval.Companion.INTERVALS_BY_CHORD
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class IntervalSpec : StringSpec({

    "Intervals by chord should not have repeated structures" {
        val repeated = INTERVALS_BY_CHORD
            .values
            .groupBy { it }
            .values
            .filter { it.size > 1 }

        repeated shouldBe listOf<List<Interval>>()
    }
})
