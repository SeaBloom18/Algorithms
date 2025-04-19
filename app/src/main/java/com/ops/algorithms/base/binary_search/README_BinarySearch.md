# 🔍 Binary Search Algorithm – Kotlin Implementation

Este proyecto demuestra el uso del **algoritmo de búsqueda binaria** en una lista de enteros generada aleatoriamente y posteriormente ordenada, con el fin de encontrar un valor objetivo específico de forma eficiente.

---

## 🧠 ¿En qué consiste el algoritmo?

La búsqueda binaria es una técnica que permite encontrar un elemento dentro de una lista **ordenada** dividiéndola repetidamente a la mitad. En cada paso:

1. Se compara el valor del centro con el objetivo.
2. Si coincide, se ha encontrado.
3. Si el objetivo es menor, se busca en la mitad izquierda.
4. Si es mayor, en la mitad derecha.

Este proceso continúa hasta encontrar el valor o agotar las opciones. Su complejidad es **O(log n)**, lo que lo hace ideal para listas grandes.

---

## 📦 Estructura del proyecto

```kotlin
private fun binarySearch(list: List<Int>, target: Int): Int {
    var sortedList = list.sorted()
    var left = 0
    var right = sortedList.size - 1

    while (left <= right) {
        var mid = (left + right) / 2

        if (target == sortedList[mid]) {
            return mid
        } else if (target < sortedList[mid]) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return -1
}
```

Este método:
- Recibe una lista desordenada.
- La ordena internamente.
- Busca el valor objetivo en la lista ordenada.
- Retorna el índice correspondiente dentro de la lista ordenada.

---

## ⚙️ Parámetros configurables

```kotlin
const val NUM_ITEMS = 1000 // Número total de elementos en la lista generada aleatoriamente.
```

---

## 🧪 Ejecución y resultado esperado

Al correr el programa, se imprimirá algo como:

```
Target: 537
Target en el index: 631
```

Esto indica que el valor `537` fue encontrado en la posición `631` dentro de la lista ordenada.

---

## 🚀 Cómo correr el proyecto

1. Clona el repositorio.
2. Abre el proyecto en tu IDE favorito con soporte para Kotlin (ej. IntelliJ IDEA).
3. Ejecuta `main()` en el archivo `main.kt` ubicado en el paquete `binary_search`.

---

## 🧑‍💻 Autor

**Mario Armando Razo Valenzuela**  
*Software Engineer – Android Developer*