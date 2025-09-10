// Clase Estudiante con atributos y constructor
static class Estudiante {
    private int edad;
    private int semestre;
    private int estratoSocioeconomico;
    private int cursosCompletados;
    private int cursosPendientes;
    private String programa;
    private int idPrograma;

    public Estudiante(int edad, int semestre, int estratoSocioeconomico,
                      int cursosCompletados, int cursosPendientes,
                      String programa, int idPrograma) {
        this.edad = edad;
        this.semestre = semestre;
        this.estratoSocioeconomico = estratoSocioeconomico;
        this.cursosCompletados = cursosCompletados;
        this.cursosPendientes = cursosPendientes;
        this.programa = programa;
        this.idPrograma = idPrograma;
    }



// Imprime la información del estudiante
public void imprimirInfo() {
    System.out.println("ID Programa: " + idPrograma +
            ", Programa: " + programa +
            ", Edad: " + edad +
            ", Semestre: " + semestre +
            ", Estrato: " + estratoSocioeconomico +
            ", Cursos Completados: " + cursosCompletados +
            ", Cursos Pendientes: " + cursosPendientes);
}




// Algoritmos de ordenamiento
static class AlgoritmosOrdenamiento {

    // Ordenamiento Burbuja por edad (ascendente)
    public static void ordenarPorEdadBurbuja(Estudiante[] estudiantes) { ... }

    // Ordenamiento por Inserción por semestre (descendente)
    public static void ordenarPorSemestreInsercion(Estudiante[] estudiantes) { ... }
}




// Algoritmos de búsqueda
static class AlgoritmosBusqueda {

    // Búsqueda Lineal por ID de programa
    public static Estudiante busquedaLinealPorIdPrograma(Estudiante[] estudiantes, int idPrograma) { ... }

    // Búsqueda Binaria por edad (requiere que el arreglo esté ordenado por edad)
    public static Estudiante busquedaBinariaPorEdad(Estudiante[] estudiantes, int edad) { ... }
}



// Crear conjunto de datos con 10 estudiantes
Estudiante[] estudiantes = {
    new Estudiante(20, 3, 2, 15, 5, "Ciencias de la Computación", 101),
    new Estudiante(22, 5, 3, 25, 3, "Negocios", 102),
    new Estudiante(19, 1, 1, 5, 8, "Derecho", 103),
    new Estudiante(23, 7, 4, 35, 2, "Medicina", 104),
    new Estudiante(21, 4, 2, 20, 6, "Ingeniería", 105),
    new Estudiante(24, 8, 5, 40, 1, "Arquitectura", 106),
    new Estudiante(18, 1, 1, 4, 9, "Psicología", 107),
    new Estudiante(25, 9, 6, 45, 0, "Economía", 108),
    new Estudiante(20, 2, 2, 10, 7, "Arte", 109),
    new Estudiante(26, 10, 6, 50, 0, "Filosofía", 110)
};




//Mostrar resultados de ordenamientos
System.out.println("=== Lista Original ===");
for (Estudiante e : estudiantes) e.imprimirInfo();

// Ordenar por edad (Burbuja)
AlgoritmosOrdenamiento.ordenarPorEdadBurbuja(estudiantes);
System.out.println("\n=== Ordenado por Edad (Ordenamiento Burbuja) ===");
for (Estudiante e : estudiantes) e.imprimirInfo();

// Ordenar por semestre (Inserción)
AlgoritmosOrdenamiento.ordenarPorSemestreInsercion(estudiantes);
System.out.println("\n=== Ordenado por Semestre (Ordenamiento por Inserción) ===");
for (Estudiante e : estudiantes) e.imprimirInfo();


// Pruebas de búsqueda
// Búsqueda Lineal
int idBuscado = 105;
Estudiante resultado1 = AlgoritmosBusqueda.busquedaLinealPorIdPrograma(estudiantes, idBuscado);
System.out.println("\n=== Búsqueda Lineal por ID de Programa " + idBuscado + " ===");
if (resultado1 != null) resultado1.imprimirInfo();
else System.out.println("Estudiante no encontrado.");

// Búsqueda Binaria (primero ordenar por edad)
AlgoritmosOrdenamiento.ordenarPorEdadBurbuja(estudiantes); // Ordenar primero
int edadBuscada = 20;
Estudiante resultado2 = AlgoritmosBusqueda.busquedaBinariaPorEdad(estudiantes, edadBuscada);
System.out.println("\n=== Búsqueda Binaria por Edad " + edadBuscada + " ===");
if (resultado2 != null) resultado2.imprimirInfo();
else System.out.println("Estudiante no encontrado.");
