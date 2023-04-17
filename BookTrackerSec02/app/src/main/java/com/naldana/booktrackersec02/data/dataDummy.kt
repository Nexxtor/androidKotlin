package com.naldana.booktrackersec02.data

// Creación del primer libro
val autor1 = Author(
    "Gabriel",
    "García Márquez",
    "6 de marzo de 1927",
    "Colombiano",
    "Gabriel José de la Concordia García Márquez fue un escritor, novelista, cuentista, guionista y periodista colombiano."
)
val editorial1 = Publisher(
    "Editorial Sudamericana",
    "Buenos Aires, Argentina",
    "www.editorialsudamericana.com.ar",
    1939
)
val libro1 = Book(
    "Cien años de soledad",
    listOf(autor1),
    editorial1,
    "30 de mayo de 1967",
    432,
    "Realismo mágico",
    "La novela narra la historia de la familia Buendía en el ficticio pueblo de Macondo, desde su fundación hasta su decadencia y desaparición.",
    "978-84-663-0003-3"
)

// Creación del segundo libro
val autor2 = Author(
    "Paulo",
    "Coelho",
    "24 de agosto de 1947",
    "Brasileño",
    "Paulo Coelho de Souza es un escritor, novelista, dramaturgo y letrista brasileño."
)
val editorial2 = Publisher("Planeta", "Barcelona, España", "www.planetadelibros.com", 1949)
val libro2 = Book(
    "El Alquimista",
    listOf(autor2),
    editorial2,
    "1988",
    192,
    "Novela filosófica",
    "La novela narra la historia de Santiago, un joven pastor andaluz que tiene un sueño y se embarca en un viaje por el norte de África en busca de su tesoro personal.",
    "978-84-08-18123-2"
)


// Creación del primer libro de tecnología
val autor3 = Author(
    "Eric",
    "Freeman",
    "14 de julio de 1964",
    "Estadounidense",
    "Eric Freeman es un programador y escritor estadounidense."
)
val autor4 = Author(
    "Elisabeth",
    "Robson",
    "20 de junio de 1980",
    "Canadiense",
    "Elisabeth Robson es una ingeniera de software y escritora canadiense."
)
val editorial3 = Publisher("O'Reilly Media", "Sebastopol, California", "www.oreilly.com", 1978)
val libro3 = Book(
    "Cabeza primera en Kotlin",
    listOf(autor3, autor4),
    editorial3,
    "2019",
    640,
    "Programación",
    "Este libro ofrece una introducción completa y altamente visual a la programación en Kotlin, utilizando un estilo de enseñanza basado en la experiencia de los estudiantes.",
    "978-84-415-4355-5"
)

// Creación del segundo libro de tecnología
val autor5 = Author(
    "Steve",
    "Krugg",
    "28 de agosto de 1951",
    "Estadounidense",
    "Steve Krug es un experto en usabilidad y diseño de sitios web estadounidense."
)
val editorial4 = Publisher("New Riders", "Indianápolis, Indiana", "www.newriders.com", 1984)
val libro4 = Book(
    "No me hagas pensar: Una aproximación a la usabilidad en la Web",
    listOf(autor5),
    editorial4,
    "2000",
    216,
    "Usabilidad web",
    "Este libro es una guía sobre cómo diseñar y construir sitios web fáciles de usar, con un enfoque en la usabilidad y la experiencia del usuario.",
    "978-84-415-2798-8"
)

// Creación del primer libro de cocina
val autor6 = Author(
    "Yotam",
    "Ottolenghi",
    "14 de diciembre de 1968",
    "Israelí",
    "Yotam Ottolenghi es un chef, escritor y propietario de restaurantes israelí-británico."
)
val editorial5 = Publisher("Ebury Press", "Londres, Reino Unido", "www.penguin.co.uk", 1949)
val libro5 = Book(
    "Plenty: Vibrant Recipes from London's Ottolenghi",
    listOf(autor6),
    editorial5,
    "2010",
    288,
    "Cocina vegetariana",
    "Este libro presenta más de 120 recetas vegetarianas vibrantes y deliciosas, inspiradas en la cocina del restaurante Ottolenghi en Londres.",
    "978-1-849-90163-4"
)

// Creación del segundo libro de cocina
val autor7 = Author(
    "Julia",
    "Child",
    "15 de agosto de 1912",
    "Estadounidense",
    "Julia Child fue una chef, autora y personalidad de televisión estadounidense."
)
val editorial6 = Publisher("Knopf", "Nueva York, Estados Unidos", "www.randomhouse.com", 1915)
val libro6 = Book(
    "Mastering the Art of French Cooking",
    listOf(autor7),
    editorial6,
    "1961",
    684,
    "Cocina francesa",
    "Este libro, escrito por la legendaria chef Julia Child, es una guía detallada para la cocina francesa clásica, con más de 500 recetas.",
    "978-0-307-95817-4"
)

public val books = listOf(libro1, libro2, libro3, libro4, libro5, libro6)
public val publishers =
    listOf(editorial1, editorial2, editorial3, editorial4, editorial5, editorial6)
public val authors = listOf(autor1, autor2, autor3, autor4, autor5, autor6, autor7)