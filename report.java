import java.util.*;

class Student {
    int rollNo;
    String name;
    String email;
    String course;
    double marks;

    public Student(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return rollNo + " | " + name + " | " + email + " | " + course + " | " + marks;
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadSampleData();
        displayLoaded();

        while (true) {
            menu();
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) addStudent();
            else if (ch == 2) viewAll();
            else if (ch == 3) searchByName();
            else if (ch == 4) deleteByName();
            else if (ch == 5) sortByMarks();
            else if (ch == 6) {
                System.out.println("Exiting...");
                break;
            }
        }
    }

    static void loadSampleData() {
        students.add(new Student(201, "Parth", "parth@mail.com", "CSE", 88.5));
        students.add(new Student(202, "Ayush", "ayush@mail.com", "ECE", 92.3));
        students.add(new Student(203, "Lovish", "lovish@mail.com", "IT", 79.8));
        students.add(new Student(204, "Ajay", "ajay@mail.com", "ME", 85.4));
    }

    static void displayLoaded() {
        System.out.println("Loaded students:");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    static void menu() {
        System.out.println("\n===== Student Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search by Name");
        System.out.println("4. Delete by Name");
        System.out.println("5. Sort by Marks");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int r = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String n = sc.nextLine();

        System.out.print("Enter Email: ");
        String e = sc.nextLine();

        System.out.print("Enter Course: ");
        String c = sc.nextLine();

        System.out.print("Enter Marks: ");
        double m = sc.nextDouble();

        students.add(new Student(r, n, e, c, m));
        System.out.println("Student added.");
    }

    static void viewAll() {
        System.out.println("\nAll Students:");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }

    static void searchByName() {
        System.out.print("Enter name to search: ");
        String key = sc.nextLine();

        for (Student s : students) {
            if (s.name.equalsIgnoreCase(key)) {
                System.out.println("Found: " + s.toString());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteByName() {
        System.out.print("Enter name to delete: ");
        String key = sc.nextLine();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().name.equalsIgnoreCase(key)) {
                it.remove();
                System.out.println("Deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void sortByMarks() {
        students.sort((a, b) -> Double.compare(b.marks, a.marks));
        System.out.println("\nSorted by Marks:");
        for (Student s : students) {
            System.out.println(s.toString());
        }
    }
}
