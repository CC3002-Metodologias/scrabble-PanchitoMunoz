# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

# Contexto

El objetivo de este proyecto es el de crear un clon simplificado de Scratch. Para ello,
se creará un entorno de programación por bloques en el que cualquier persona podrá crear
un programa sencillo sin la necesidad de que tenga conocimientos de programación.

# Cómo instalar el programa

Se recomienda:
* Java 15 o similar.
* JUnit 5.0 o similar.
* IntelliJ IDE
* Versión 14 de Gradle JVM o similar.

Para instalarlo en el ordenador, se recomienda clonar el repositorio a través del comando
`git clone` de Git. Una vez clonado, se debe de armar el Gradle a través de la instrucción
`gradle build`: esto se puede hacer fácilmente desde IntelliJ apretando la opción "Gradle"
y ejecutando `Gradle build`. Paso seguido, se puede ejecutar los tests que posee el 
proyecto para verificar que todo esté en orden.  

# Cosas nuevas agregadas en esta tarea
## Mejoras en el diseño
1. Ahora las clases de la tarea 1 no poseen los métodos auxiliares del double dispatch; ahora son adaptadores, que a su vez, las clases adaptadas utilizan el [patrón bridge](https://refactoring.guru/es/design-patterns/bridge) para delegar los métodos auxiliares del double dispatch, y no tener una explosión de métodos (que tampoco es responsabilidad de aquellas clases implementar dichos métodos).
2. Para setear los valores de las variables se utiliza el [patrón iterator](https://refactoring.guru/es/design-patterns/iterator) para recorrer las hojas. Además se crea un iterador para hacer más comprensible el código. (Corresponden a las clases `DFSIterator`, `LeafIterator` y `LeafIterable`).
3. Se utiliza el [patrón prototype](https://refactoring.guru/es/design-patterns/prototype) para generar copias de las clases y no utilizar las propias instancias (para los tipos de datos se retorna la propia instancia, ya que se utiliza Flyweight en este caso).

## Extras de la tarea 3
1. Se implementan las clases para realizar comparaciones entre tipos de datos numéricos. Se puede ver el detalle [aquí](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/2.-Operadores#operadores-relacionales).
2. Se implementan las clases de control de flujo [`If`](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/4.-Control-de-Flujo#if) y [`For`](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/4.-Control-de-Flujo#for), adicionales a las clases [`While`](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/4.-Control-de-Flujo#while) e [`IfElse`](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/4.-Control-de-Flujo#ifelse) exigidas en la tarea.
3. Se crean formas de que el control de flujo también utilice a [las variables](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/3.-Variables) descritas en la tarea 2, a pesar de que esto no era exigido.
4. Se crean métodos [`increase` y `decreased`](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/3.-Variables#incrementos-y-decrementos) para utilizar en el ciclo `For` a modo de `i++` o `i--`.
5. Se crea la clase `Program` y `ListOfInstructions` para utilizar y orquestar todas las componentes creadas anteriormente y para poder ejecutar más de una instrucción en un mismo cuerpo de control de flujo.
6. Se provee de una visualización en formato de código para las clases `Program`. [Por ejemplo](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/5.-Programa).

# Descripción

Para una descripción más detallada se sugiere leer [la Wiki del proyecto](https://github.com/CC3002-Metodologias/scrabble-asolnn2a8/wiki/0.-Home).


--------------------------------------------------------------------------------------

# Context

The goal of this project is to create a simplified clone of Scratch. For this purpose,
a block programming environment will be created in which anyone can create a simple
program without the need for programming knowledge.

# How to install
(in construction...)

# Description
(in construction...)

## Type of data
(in construction...)


