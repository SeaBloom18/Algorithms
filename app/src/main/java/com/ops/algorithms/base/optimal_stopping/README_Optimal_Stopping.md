# 🧠 Optimal Stopping Algorithm – Secretary Problem Simulation

Este proyecto simula el clásico problema del **secretario** (o *optimal stopping problem*), utilizando la **estrategia óptima basada en la regla del 37%**. Evalúa qué tan seguido esta estrategia logra seleccionar al mejor candidato de un grupo con calificaciones desconocidas, ordenadas aleatoriamente.

---

## 📌 ¿En qué consiste el algoritmo?

Dado un conjunto de `n` candidatos evaluados en orden aleatorio, la estrategia óptima consiste en:

1. Rechazar los primeros `r = ⌊n / e⌋` candidatos (~37%) solo para observar.
2. Guardar el mejor valor observado como umbral.
3. Seleccionar el **primer candidato posterior** que supere ese umbral.
4. Si ninguno lo supera, te quedas con el último.

Este enfoque maximiza la probabilidad de elegir al mejor candidato, con una tasa de éxito teórica cercana al **37%**.

---

## 📦 Estructura del proyecto

```kotlin
data class Candidate(
    val index: Int,
    val name: String,
    val satisfactionPercentage: Int
)
```

```kotlin
simulateStop(): Boolean
```
- Recorre una lista aleatoria de candidatos.
- Descarta los primeros 37%.
- Selecciona el primero que supere al mejor de los descartados.
- Retorna `true` si fue el mejor de todos.

---

## ⚙️ Parámetros configurables

```kotlin
const val NUM_CANDIDATES = 1000          // Total de candidatos por iteración
const val STOPPING_PERCENTAGE = 0.37     // Regla de stopping óptima (≈1/e)
const val NUM_ITERATIONS = 100000        // Número de simulaciones
```

Puedes ajustar estos valores para explorar cómo varía el resultado con más o menos candidatos, o más iteraciones.

---

## 📈 Resultado esperado

Después de correr las 100,000 iteraciones, el programa imprimirá algo como:

```
Satisfaction percentage: 36.9%
```

Este número representa la **tasa de éxito del algoritmo**: qué tan seguido seleccionó al mejor candidato absoluto.

---


## 🚀 Cómo correr el proyecto

1. Clona el repositorio.
2. Asegúrate de tener Kotlin configurado.
3. Ejecuta el archivo principal `main.kt` desde tu IDE o línea de comandos.

---

## 🧠 Referencias

- [Optimal Stopping Theory – Wikipedia](https://en.wikipedia.org/wiki/Secretary_problem)
- [The 37% Rule – Big Think](https://bigthink.com/the-present/37-percent-rule-optimal-stopping/)
- [1/e Stopping Rule Explanation – Brilliant.org](https://brilliant.org/wiki/secretary-problem/)

---

## 🧑‍💻 Autor

**Mario Armando Razo Valenzuela**  
*Software Engineer – Android Developer* 
