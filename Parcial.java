public class Parcial {

    // Clase Estudiante
    static class Estudiante {
        private int edad;
        private int semestre;
        private int estratoSocioeconomico;
        private int cursosCompletados; // "Aprobadas" en la imagen
        private int cursosPendientes;  // "Pendientes" en la imagen
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

        // Métodos para obtener los valores (getters)
        public int getEdad() { return edad; }
        public int getSemestre() { return semestre; }
        public int getEstratoSocioeconomico() { return estratoSocioeconomico; }
        public int getCursosCompletados() { return cursosCompletados; }
        public int getCursosPendientes() { return cursosPendientes; }
        public String getPrograma() { return programa; }
        public int getIdPrograma() { return idPrograma; }

        // ⚠️ ¡CAMBIAMOS ESTE MÉTODO PARA QUE IMPRIMA COMO EN LA IMAGEN!
        public void imprimirInfo() {
            System.out.printf("ID: %3d | Edad: %2d | Semestre: %2d | Estrato: %2d | Aprobadas: %2d | Pendientes: %2d | Programa: %-15s%n",
                    idPrograma, edad, semestre, estratoSocioeconomico,
                    cursosCompletados, cursosPendientes, programa);
        }
    }

    // Algoritmos de ordenamiento
    static class AlgoritmosOrdenamiento {

        // Ordenamiento Burbuja por edad (ascendente) — ✅ IGUAL QUE TENÍAS
        public static void ordenarPorEdadBurbuja(Estudiante[] estudiantes) {
            int n = estudiantes.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (estudiantes[j].getEdad() > estudiantes[j + 1].getEdad()) {
                        Estudiante temp = estudiantes[j];
                        estudiantes[j] = estudiantes[j + 1];
                        estudiantes[j + 1] = temp;
                    }
                }
            }
        }

        // Ordenamiento por Inserción por semestre (descendente) — ✅ IGUAL QUE TENÍAS
        public static void ordenarPorSemestreInsercion(Estudiante[] estudiantes) {
            for (int i = 1; i < estudiantes.length; i++) {
                Estudiante clave = estudiantes[i];
                int j = i - 1;

                while (j >= 0 && estudiantes[j].getSemestre() < clave.getSemestre()) {
                    estudiantes[j + 1] = estudiantes[j];
                    j = j - 1;
                }
                estudiantes[j + 1] = clave;
            }
        }
    }

    // Algoritmos de búsqueda
    static class AlgoritmosBusqueda {

        // Búsqueda Lineal por ID de programa — ✅ IGUAL QUE TENÍAS
        public static Estudiante busquedaLinealPorIdPrograma(Estudiante[] estudiantes, int idPrograma) {
            for (Estudiante estudiante : estudiantes) {
                if (estudiante.getIdPrograma() == idPrograma) {
                    return estudiante;
                }
            }
            return null; // No encontrado
        }

        // Búsqueda Binaria por edad — ✅ IGUAL QUE TENÍAS
        public static Estudiante busquedaBinariaPorEdad(Estudiante[] estudiantes, int edad) {
            int izquierda = 0;
            int derecha = estudiantes.length - 1;

            while (izquierda <= derecha) {
                int medio = izquierda + (derecha - izquierda) / 2;

                if (estudiantes[medio].getEdad() == edad) {
                    return estudiantes[medio];
                }

                if (estudiantes[medio].getEdad() < edad) {
                    izquierda = medio + 1;
                } else {
                    derecha = medio - 1;
                }
            }
            return null; // No encontrado
        }
    }

    // Método principal
    public static void main(String[] args) {
        // 🖼️ DATOS EXACTOS DE LA IMAGEN (10 estudiantes con valores específicos)
        Estudiante[] estudiantes = {
            new Estudiante(18, 1, 5, 4, 8, "Writer", 105),
            new Estudiante(19, 2, 3, 6, 6, "Biologist", 102),
            new Estudiante(19, 2, 6, 5, 7, "Chef", 109),
            new Estudiante(20, 3, 2, 8, 4, "Programmer", 101),
            new Estudiante(20, 3, 3, 9, 3, "Architect", 107),
            new Estudiante(21, 4, 4, 10, 4, "Journalist", 104),
            new Estudiante(22, 5, 1, 12, 2, "Engineer", 103),
            new Estudiante(23, 7, 2, 14, 2, "Translator", 108),
            new Estudiante(24, 8, 2, 18, 0, "Pilot", 110),
            new Estudiante(25, 7, 2, 16, 1, "Nurse", 106)
        };

        // Mostrar lista original
        System.out.println("--- Lista Original ---");
        for (Estudiante e : estudiantes) {
            e.imprimirInfo();
        }

        // Ordenar por edad (Burbuja)
        AlgoritmosOrdenamiento.ordenarPorEdadBurbuja(estudiantes);
        System.out.println("\n--- Después de Bubble Sort por Edad ---");
        for (Estudiante e : estudiantes) {
            e.imprimirInfo();
        }

        // Ordenar por semestre (Inserción descendente)
        AlgoritmosOrdenamiento.ordenarPorSemestreInsercion(estudiantes);
        System.out.println("\n--- Después de Insertion Sort por Semestre ---");
        for (Estudiante e : estudiantes) {
            e.imprimirInfo();
        }

        // Búsqueda Lineal por ID = 105
        System.out.println("\n--- Buscando por ID de programa (105) con Búsqueda Lineal ---");
        Estudiante resultado1 = AlgoritmosBusqueda.busquedaLinealPorIdPrograma(estudiantes, 105);
        if (resultado1 != null) {
            System.out.println(" ? ¡Encontrado! Datos del estudiante:");
            resultado1.imprimirInfo();
        } else {
            System.out.println("No encontrado.");
        }

        // Búsqueda Binaria por edad = 22 (requiere ordenar por edad primero)
        AlgoritmosOrdenamiento.ordenarPorEdadBurbuja(estudiantes); // Reordenar
        System.out.println("\n--- Buscando por EDAD (22) con Búsqueda Binaria (requiere ordenar antes) ---");
        Estudiante resultado2 = AlgoritmosBusqueda.busquedaBinariaPorEdad(estudiantes, 22);
        if (resultado2 != null) {
            System.out.println(" ? ¡Encontrado! Datos del estudiante:");
            resultado2.imprimirInfo();
        } else {
            System.out.println("No encontrado.");
        }
    }
}