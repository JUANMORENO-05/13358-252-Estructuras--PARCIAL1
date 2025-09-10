public class Parcial {  

    // Student Class 
    static class Student {
        private int age;
        private int semester;
        private int socioEconomicStratum;
        private int coursesCompleted;
        private int coursesPending;
        private String program;
        private int programId;

        public Student(int age, int semester, int socioEconomicStratum,
                       int coursesCompleted, int coursesPending,
                       String program, int programId) {
            this.age = age;
            this.semester = semester;
            this.socioEconomicStratum = socioEconomicStratum;
            this.coursesCompleted = coursesCompleted;
            this.coursesPending = coursesPending;
            this.program = program;
            this.programId = programId;
        }

        // Getters
        public int getAge() { return age; }
        public int getSemester() { return semester; }
        public int getSocioEconomicStratum() { return socioEconomicStratum; }
        public int getCoursesCompleted() { return coursesCompleted; }
        public int getCoursesPending() { return coursesPending; }
        public String getProgram() { return program; }
        public int getProgramId() { return programId; }

        // Print student info
        public void printInfo() {
            System.out.println("Program ID: " + programId +
                    ", Program: " + program +
                    ", Age: " + age +
                    ", Semester: " + semester +
                    ", Stratum: " + socioEconomicStratum +
                    ", Courses Completed: " + coursesCompleted +
                    ", Courses Pending: " + coursesPending);
        }
    }

    // Sorting Algorithms 
    static class SortAlgorithms {

        // Bubble Sort by age (ascending)
        public static void bubbleSortByAge(Student[] students) {
            int n = students.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (students[j].getAge() > students[j + 1].getAge()) {
                        Student temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }
        }

        // Insertion Sort by semester (descending)
        public static void insertionSortBySemester(Student[] students) {
            for (int i = 1; i < students.length; i++) {
                Student key = students[i];
                int j = i - 1;

                while (j >= 0 && students[j].getSemester() < key.getSemester()) {
                    students[j + 1] = students[j];
                    j = j - 1;
                }
                students[j + 1] = key;
            }
        }
    }

    // Searching Algorithms 
    static class SearchAlgorithms {

        // Linear Search by programId
        public static Student linearSearchByProgramId(Student[] students, int programId) {
            for (Student student : students) {
                if (student.getProgramId() == programId) {
                    return student;
                }
            }
            return null;
        }

        // Binary Search by age (requires array sorted by age)
        public static Student binarySearchByAge(Student[] students, int age) {
            int left = 0;
            int right = students.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (students[mid].getAge() == age) {
                    return students[mid];
                }

                if (students[mid].getAge() < age) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }
    }

    // Main Method 
    public static void main(String[] args) {
        // Create dataset with 10 students
        Student[] students = {
            new Student(20, 3, 2, 15, 5, "Computer Science", 101),
            new Student(22, 5, 3, 25, 3, "Business", 102),
            new Student(19, 1, 1, 5, 8, "Law", 103),
            new Student(23, 7, 4, 35, 2, "Medicine", 104),
            new Student(21, 4, 2, 20, 6, "Engineering", 105),
            new Student(24, 8, 5, 40, 1, "Architecture", 106),
            new Student(18, 1, 1, 4, 9, "Psychology", 107),
            new Student(25, 9, 6, 45, 0, "Economics", 108),
            new Student(20, 2, 2, 10, 7, "Art", 109),
            new Student(26, 10, 6, 50, 0, "Philosophy", 110)
        };

        System.out.println("=== Original List ===");
        for (Student s : students) s.printInfo();

        // Bubble Sort by age
        SortAlgorithms.bubbleSortByAge(students);
        System.out.println("\n=== Sorted by Age (Bubble Sort) ===");
        for (Student s : students) s.printInfo();

        // Insertion Sort by semester
        SortAlgorithms.insertionSortBySemester(students);
        System.out.println("\n=== Sorted by Semester (Insertion Sort) ===");
        for (Student s : students) s.printInfo();

        // Linear Search
        int searchProgramId = 105;
        Student result1 = SearchAlgorithms.linearSearchByProgramId(students, searchProgramId);
        System.out.println("\n=== Linear Search by programId " + searchProgramId + " ===");
        if (result1 != null) result1.printInfo();
        else System.out.println("Student not found.");

        // Binary Search
        SortAlgorithms.bubbleSortByAge(students); // sort first
        int searchAge = 20;
        Student result2 = SearchAlgorithms.binarySearchByAge(students, searchAge);
        System.out.println("\n=== Binary Search by age " + searchAge + " ===");
        if (result2 != null) result2.printInfo();
        else System.out.println("Student not found.");
    }
}
