// TODO: use JMH or kotlinx.benchmark
import java.util.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

inline fun warmupOnceAndMeasureTimeMillis(block: () -> Unit): Long {
    block()
    return measureTimeMillis(block)
}

fun Sequence<Long>.toLongArray(size: Int): LongArray {
    val iterator = iterator()
    return LongArray(size) { iterator.next() }
}

val size = 1 shl 27
val array = LongArray(size) { Random.nextLong() }
println(warmupOnceAndMeasureTimeMillis {
    val resultArray = LongArray(size)
    for (i in 0 until size) resultArray[i] = array[i].inv()
})

println(warmupOnceAndMeasureTimeMillis { array.asSequence().map { it.inv() }.toLongArray(size) })
println(warmupOnceAndMeasureTimeMillis { array.asSequence().map(Long::inv).toLongArray(size) })

println(warmupOnceAndMeasureTimeMillis { Arrays.stream(array).map { it.inv() }.toArray() })
println(warmupOnceAndMeasureTimeMillis { Arrays.stream(array).map(Long::inv).toArray() })

println(warmupOnceAndMeasureTimeMillis { Arrays.stream(array).parallel().map { it.inv() }.toArray() })
println(warmupOnceAndMeasureTimeMillis { Arrays.stream(array).parallel().map(Long::inv).toArray() })