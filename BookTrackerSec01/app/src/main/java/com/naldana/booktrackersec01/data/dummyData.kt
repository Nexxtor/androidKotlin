package com.naldana.booktrackersec01.data

// Creación del primer Book
val Author1 = Author("Gabriel", "García Márquez", "6 de marzo de 1927", "Colombiano", "Gabriel José de la Concordia García Márquez fue un escritor, novelista, cuentista, guionista y periodista colombiano.")
val Publisher1 = Publisher("Publisher Sudamericana", "Buenos Aires, Argentina", "www.Publishersudamericana.com.ar", 1939)
val Book1 = Book("Cien años de soledad", listOf(Author1), Publisher1, "30 de mayo de 1967", 432, "Realismo mágico", "La novela narra la historia de la familia Buendía en el ficticio pueblo de Macondo, desde su fundación hasta su decadencia y desaparición.", "978-84-663-0003-3")

// Creación del segundo Book
val Author2 = Author("Paulo", "Coelho", "24 de agosto de 1947", "Brasileño", "Paulo Coelho de Souza es un escritor, novelista, dramaturgo y letrista brasileño.")
val Publisher2 = Publisher("Planeta", "Barcelona, España", "www.planetadeBooks.com", 1949)
val Book2 = Book("El Alquimista", listOf(Author2), Publisher2, "1988", 192, "Novela filosófica", "La novela narra la historia de Santiago, un joven pastor andaluz que tiene un sueño y se embarca en un viaje por el norte de África en busca de su tesoro personal.", "978-84-08-18123-2")

// Creación del primer Book de tecnología
val Author3 = Author("Eric", "Freeman", "14 de julio de 1964", "Estadounidense", "Eric Freeman es un programador y escritor estadounidense.")
val Author4 = Author("Elisabeth", "Robson", "20 de junio de 1980", "Canadiense", "Elisabeth Robson es una ingeniera de software y escritora canadiense.")
val Publisher3 = Publisher("O'Reilly Media", "Sebastopol, California", "www.oreilly.com", 1978)
val Book3 = Book("Cabeza primera en Kotlin", listOf(Author3, Author4), Publisher3, "2019", 640, "Programación", "Este Book ofrece una introducción completa y altamente visual a la programación en Kotlin, utilizando un estilo de enseñanza basado en la experiencia de los estudiantes.", "978-84-415-4355-5")

// Creación del segundo Book de tecnología
val Author5 = Author("Steve", "Krugg", "28 de agosto de 1951", "Estadounidense", "Steve Krug es un experto en usabilidad y diseño de sitios web estadounidense.")
val Publisher4 = Publisher("New Riders", "Indianápolis, Indiana", "www.newriders.com", 1984)
val Book4 = Book("No me hagas pensar: Una aproximación a la usabilidad en la Web", listOf(Author5), Publisher4, "2000", 216, "Usabilidad web", "Este Book es una guía sobre cómo diseñar y construir sitios web fáciles de usar, con un enfoque en la usabilidad y la experiencia del usuario.", "978-84-415-2798-8")

// Creación del primer Book de cocina
val Author6 = Author("Yotam", "Ottolenghi", "14 de diciembre de 1968", "Israelí", "Yotam Ottolenghi es un chef, escritor y propietario de restaurantes israelí-británico.")
val Publisher5 = Publisher("Ebury Press", "Londres, Reino Unido", "www.penguin.co.uk", 1949)
val Book5 = Book("Plenty: Vibrant Recipes from London's Ottolenghi", listOf(Author6), Publisher5, "2010", 288, "Cocina vegetariana", "Este Book presenta más de 120 recetas vegetarianas vibrantes y deliciosas, inspiradas en la cocina del restaurante Ottolenghi en Londres.", "978-1-849-90163-4")

// Creación del segundo Book de cocina
val Author7 = Author("Julia", "Child", "15 de agosto de 1912", "Estadounidense", "Julia Child fue una chef, Authora y personalidad de televisión estadounidense.")
val Publisher6 = Publisher("Knopf", "Nueva York, Estados Unidos", "www.randomhouse.com", 1915)
val Book6 = Book("Mastering the Art of French Cooking", listOf(Author7), Publisher6, "1961", 684, "Cocina francesa", "Este Book, escrito por la legendaria chef Julia Child, es una guía detallada para la cocina francesa clásica, con más de 500 recetas.", "978-0-307-95817-4")


var authors =  listOf(Author1,Author2,Author3,Author4,Author5, Author6)
var publishers = listOf(Publisher1,Publisher2,Publisher3,Publisher4,Publisher5,Publisher6)
var books = listOf(Book1,Book2,Book3,Book4,Book5,Book6)