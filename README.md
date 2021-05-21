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
* Java 16 o similar.
* JUnit 5.0 o similar.
* IntelliJ IDE
* Versión 14 de Gradle JVM o similar.

Para instalarlo en el ordenador, se recomienda clonar el repositorio a través del comando
`git clone` de Git. Una vez clonado, se debe de armar el Gradle a través de la instrucción
`gradle build`: esto se puede hacer fácilmente desde IntelliJ apretando la opción "Gradle"
y ejecutando `Gradle build`. Paso seguido, se puede ejecutar los tests que posee el 
proyecto para verificar que todo esté en orden.  

# Descripción

## Tipo de datos
Una de las partes más importantes para representar la realidad en un programa son los 
tipos de datos que puedan crearse, almacenarse y operarse. Este proyecto provee algunos 
tipos de datos elementales para crear un programa simple, en particular, se provee de 
los siguientes tipos de datos:
* _TypeStrings_: Utilizados para representar un texto simple. Es representado por un 
  `String` nativo de _Java_.
* _TypeBool_: Utilizados para representar un tipo booleano, esto es, un valor `true` 
  o un valor `false`. Es representado por un `boolean` nativo de _Java_.
* _TypeFloat_:  Utilizado para representar un número flotante, o en términos matemáticos,
  un número real, como por ejemplo 1.3333 o 3.1416. Es representado por un `double` nativo de _Java_.
* _TypeInt_: Utilizado para representar un número entero, como por ejemplo -3 o 42.
  Es representado por un `int` nativo de _Java_.
* _TypeBinary_: Utilizado para representar un número entero como un número binario.
  Cabe mencionar que para representar un negativo en binario se utiliza su 
  [complemento dos](https://en.wikipedia.org/wiki/Two%27s_complement) para este propósito.
  Por ejemplo, `0110` representa al número 6 y `1010` representa al número -6.
  Es representado por un `String` nativo de _Java_, conteniendo únicamente ceros y unos.

## Clasificación de los tipos de datos
Dados los distintos tipos de datos, estos se pueden clasificar en distintas categorías 
dependiendo de su comportamiento. Más precisamente:
* _SType_: Estos son todos los tipos de datos mencionados anteriormente. Es decir, 
  _TypeString_, _TypeBool_, _TypeFloat_, _TypeInt_ y _TypeBinary_.
* _SNumber_: Corresponden a todos aquellos que se consideran números. Es decir, 
  _TypeFloat_, _TypeInt_ y _TypeBinary_.
* _SInteger_: Corresponden a todos aquellos tipos que representan a un entero. 
  En esta categoría entran _TypeInt_ y _TypeBinary_.
* _SLogical_: Corresponden a todos aquellos que tienen una representación lógica 
  (con 0 o 1), o bien, se pueden operar con operadores lógicos (como `and` o `or`,
  para más detalles revise la sección 
  [Operaciones entre tipos de datos](#operaciones-entre-tipos-de-datos)). En esta 
  categoría se encuentran _TypeBool_ y _TypeBinary_. 
  
## Trasformaciones entre tipos de datos
Existe la posibilidad que se desee transformar un tipo de dato en otro. Esto se puede 
hacer mediante instrucción `aType.toType<otherType>()` donde `<otherType>` puede
ser un _String_, _Bool_, _Float_, _Int_ o _Binary_. 
Las distintas transformaciones entre tipos de datos se resumen en la siguiente tabla:

Tipos | TypeString | TypeBool | TypeFloat | TypeInt | TypeBinary
--- | --- | --- | --- | --- | ---
TypeString | Sí | No | No | No | No
TypeBool | Sí | Si | No | No | No
TypeFloat | Sí | No | Sí | No | No
TypeInt | Sí | No | Sí | Sí | Sí
TypeBinary | Sí | No | Sí | Sí | Sí

O bien, en términos de la clasificación de tipos de datos:
* _SType_: Permite la transformación a _TypeString_.
* _SNumber_: Permite la transformación a _TypeFloat_.
* _SInteger_: Permite la transformación a _TypeInt_ y _TypeBinary_.

Donde el único caso distinto es _TypeBool_ que adicionalmente posee la 
transformación a _TypeBool_.

## Operaciones entre tipos de datos
Se provee además de distintas operaciones entre los tipos. Estas son:
* `add`: Corresponde a la suma de dos tipos.
* `sub`: Corresponde a la resta de dos tipos.
* `mult`: Corresponde a la multiplicación de dos tipos.
* `div`: Corresponde a la división de dos tipos.
* `neg`: Corresponde a la negación del tipo actual.
* `and`: Corresponde a la disyunción de dos tipos.
* `or`: Corresponde a la conjunción de dos tipos.

Donde las distintas operaciones entre tipos se resume en la siguiente tabla:

Tipos      | TypeString | TypeBool    | TypeFloat                   | TypeInt                     | TypeBinary
---        | ---        | ---         | ---                         | ---                         | ---
TypeString | `add`      | `add`       | `add`                       | `add`                       | `add`
TypeBool   |            | `and`, `or` |                             |                             | `and`, `or`
TypeFloat  |            |             | `add`, `sub`, `mult`, `div` | `add`, `sub`, `mult`, `div` | `add`, `sub`, `mult`, `div`
TypeInt    |            |             | `add`, `sub`, `mult`, `div` | `add`, `sub`, `mult`, `div` | `add`, `sub`, `mult`, `div`
TypeBinary |            | `and`, `or` |                             | `add`, `sub`, `mult`, `div` | `add`, `sub`, `mult`, `div`, `and`, `or`

O bien, se puede resumir utilizando la clasificación mencionada:
* _TypeString_: Puede ser sumado con cualquier _SType_ y devuelve un _TypeString_.
* _TypeBool_: Puede ser operado con `and` o con `or` con cualquier _SLogical_ y 
  devuelve un _TypeBool_ si fue operado con otro _TypeBool_ o devuelve un _TypeBinary_
  si se opera con un _TypeBinary_.
* _TypeFloat_: Puede ser operado con cualquier _SNumber_ y devuelve un _SNumber_.
  En la mayoría de los casos, devuelve un _TypeFloat_.
* _TypeInt_:  Puede ser operado con cualquier _SNumber_ y devuelve un _SNumber_.
  Siendo más precisos, devuelve un _TypeFloat_ si se opera con un _TypeFloat_ y devuelve
  un _TypeInt_ en el resto de los casos. En el caso de la división, retorna la división
  redondeada si es operado con un _SInteger_.
* _TypeBinary_: En el caso de los operadores aritméticos, puede ser operado con cualquier
  _SInteger_ y devuelve un _SInteger_. En la mayoría de los casos, devuelve un 
  _TypeBinary_. En el caso de la división, retorna la división redondeada si es operado 
  con un _SInteger_. Por otro lado, en el caso de los operadores lógicos, si es que se 
  opera con otro binario, entonces la operación se hace carácter por carácter, 
  extendiendo al número binario más pequeño manteniendo su valor numérico original. 

Cabe destacar que si un número cualquiera es dividido entre cero, entonces el resultado 
de la operación es cero. En futuras versiones se manejarán mejor estos casos.


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


