# Trabajo Práctico – Programación 3 - TUDAI 2025

### Integrantes:  Rodrigo Menendez  -  Mauricio Miranda  


---

## BACKTRACKING

**Estrategia de resolución:**
- Se genera un árbol de exploración probando todas las posibles combinaciones de máquinas.
- Cada nodo representa una máquina utilizada en la secuencia.
- Se exploran las ramas sumando piezas hasta alcanzar o superar el objetivo.

**Estados finales:**
- Secuencia de máquinas cuya suma de piezas es igual al objetivo.

**Estados solución:**
- Entre los estados finales, se elige el de menor cantidad de puestas en funcionamiento.

**Podas implementadas:**
1. Si la cantidad de puestas actuales ya supera la mejor encontrada (`menorPuesta`), se abandona esa rama.
2. Si ya se alcanzó el objetivo, se guarda la solución y no se sigue explorando.

**Consideraciones:**
- Si no se encuentra una combinación exacta, se informa que no hay solución.

**Métrica de costo:**
- Se mide por la cantidad de “estados generados” (llamadas recursivas).

---

## GREEDY

**Estrategia de resolución:**
- Se ordenan las máquinas de mayor a menor según las piezas que producen.
- Se selecciona la mayor cantidad posible de la que más produce, y se pasa a la siguiente.
- Se busca cubrir el objetivo con la menor cantidad de puestas posibles.

**Candidatos:**
- Cada máquina disponible, ordenada de mayor a menor producción.

**Estados finales:**
- Una secuencia que suma el objetivo de piezas (si existe).

**Consideraciones:**
- Puede no encontrar una solución, aunque exista, si el camino elegido no la alcanza.

**Métrica de costo:**
- Candidatos considerados (máquinas analizadas).

---

## FORMATO DEL ARCHIVO `input.txt`

El archivo debe estar ubicado en la misma carpeta desde la que se ejecuta el programa.

**Formato esperado:**

El solicitado en el enunciado.

**Consideraciones:**

- No deben haber espacios extras ni líneas vacías.

- El nombre de la máquina no debe contener comas.

- El archivo debe tener como primera línea el número total de piezas a producir.
 
- Nota:  Estas validaciones ya están contempladas dentro del código del programa. Las líneas incorrectas se descartan automáticamente.

## CONCLUSIÓN

Backtracking garantiza encontrar la mejor solución posible, aunque con mayor costo computacional.

Greedy es mucho más rápido, pero puede no encontrar la mejor solución o incluso ninguna válida.

Ambas técnicas se implementaron para mostrar el contraste entre búsqueda exhaustiva y heurística voraz.


