import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

class Student {
    private int rollNumber;
    private String studentName;
    private int[] marks; 

    public Student(int rollNumber, String studentName, int[] marks) throws InvalidMarksException {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        if (marks == null || marks.length != 3) {
            throw new IllegalArgumentException("Marks array must contain exactly 3 values.");
        }
        this.marks = marks;
        validateMarks(); 
    }

    public void validateMarks() throws InvalidMarksException {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0 || marks[i] > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + marks[i]);
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    public String getResultStatus() {
        for (int m : marks) {
            if (m < 35) return "Fail"; 
        }
        return "Pass";
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int m : marks) System.out.print(m + " ");
        System.out.println();
        System.out.println("Average: " + calculateAverage());
        System.out.println("Result: " + getResultStatus());
    }
}

public class ResultManagementSystem {
    private Student[] students;
    private int count;
    private Scanner scanner;

    public ResultManagementSystem() {
        students = new Student[100]; 
        count = 0;
        scanner = new Scanner(System.in);
    }

    private int findStudent(int roll) {
        for (int i = 0; i < count; i++) {
            if (students[i].getRollNumber() == roll)
                return i;
        }
        return -1;
    }

    public void addStudent() throws InvalidMarksException {
        if (count >= students.length) {
            System.out.println("Storage full! Cannot add more students.");
            return;
        }

        try {
            System.out.print("Enter Roll Number: ");
            int roll = Integer.parseInt(scanner.nextLine().trim());

            if (findStudent(roll) != -1) {
                System.out.println("Error: Roll number already exists!");
                return;
            }

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                try {
                    marks[i] = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter a number.");
                    return;
                }
            }

            Student s = new Student(roll, name, marks); 
            students[count++] = s;

            System.out.println("Student added successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong input format!");
        }
    }

    public void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = Integer.parseInt(scanner.nextLine().trim());

            int idx = findStudent(roll);
            if (idx == -1) {
                System.out.println("Student not found.");
                return;
            }
            students[idx].displayResult();
            System.out.println("Search completed.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid roll number format!");
        }
    }

    public void mainMenu() {
        try {
            boolean running = true;

            while (running) {
                System.out.println("\n===== Student Result Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                String choice = scanner.nextLine().trim();

                switch (choice) {
                    case "1":
                        try {
                            addStudent();
                        } catch (InvalidMarksException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case "2":
                        showStudentDetails();
                        break;

                    case "3":
                        System.out.println("Exiting program. Thank you!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }

        } finally {
            scanner.close();
            System.out.println("Scanner closed. Program ended.");
        }
    }

    public static void main(String[] args) {
        ResultManagementSystem rms = new ResultManagementSystem();
        rms.mainMenu();
    }
}
