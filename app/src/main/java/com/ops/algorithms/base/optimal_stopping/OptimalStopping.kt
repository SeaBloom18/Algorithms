package com.ops.algorithms.base.optimal_stopping

/**
 * Porcentaje de candidatos que se descartan inicialmente (regla 1/e).
 */
const val STOPPING_PERCENTAGE = 0.37

const val NUM_ITERATIONS = 100000
const val NUM_CANDIDATES = 1000

/**
 * Función principal que ejecuta múltiples simulaciones del algoritmo de "optimal stopping"
 * y calcula el porcentaje de éxito al seleccionar al mejor candidato.
 */
fun main() {
    var optimalWins = 0

    (1..NUM_ITERATIONS).forEach {
        if (simulateStop())
            optimalWins++
    }

    val satisfactionPercentage = calculateSatisfactionPercentage(optimalWins)
    println("Satisfaction percentage: $satisfactionPercentage%")
}

/**
 * Representa a un candidato con un índice, nombre y nivel de satisfacción.
 *
 * @property index Índice del candidato (1-based).
 * @property name Nombre del candidato.
 * @property satisfactionPercentage Valor numérico que representa qué tan "bueno" es el candidato.
 */
data class Candidate(
    val index: Int,
    val name: String,
    val satisfactionPercentage: Int
)

/**
 * Calcula el porcentaje de éxito del algoritmo.
 *
 * @param optimalWins Número de veces que el algoritmo eligió al mejor candidato.
 * @return Porcentaje de éxito en forma decimal (ej. 37.0).
 */
private fun calculateSatisfactionPercentage(optimalWins: Int): Double {
    return ((optimalWins.toFloat() / NUM_ITERATIONS.toFloat()) * 100).toDouble()
}

/**
 * Genera y devuelve una lista aleatoria de candidatos con valores únicos de satisfacción.
 *
 * @return Lista desordenada de candidatos únicos.
 */
private fun getRandomSetOfCandidates(): List<Candidate> {
    return (1..NUM_CANDIDATES).map {
        Candidate(it, "Candidate $it", satisfactionPercentage = it)
    }.shuffled()
}

/**
 * Ejecuta una simulación del algoritmo de optimal stopping (problema del secretario).
 *
 * Se descarta un porcentaje inicial de candidatos y se selecciona el primero que
 * supere el mejor de los descartados.
 *
 * @return `true` si el candidato seleccionado fue el mejor de todos, `false` en otro caso.
 */
private fun simulateStop(): Boolean {
    val candidates = getRandomSetOfCandidates()

    val r = maxOf(1, (NUM_CANDIDATES * STOPPING_PERCENTAGE).toInt())
    val threshold = candidates.take(r).maxByOrNull { it.satisfactionPercentage }

    val selection = candidates.drop(r)
        .firstOrNull { it.satisfactionPercentage > (threshold?.satisfactionPercentage ?: 0) }
        ?: candidates.last()

    return selection == candidates.maxByOrNull { it.satisfactionPercentage }
}
