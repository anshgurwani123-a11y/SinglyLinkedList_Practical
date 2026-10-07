import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Node head = null;

    // Insert a student registration
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student registered successfully.");
    }

    // Delete a student registration
    void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    // Search for a student registration
    void search(int data) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Student found.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Update student registration
    void update(int oldData, int newData) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == oldData) {
                temp.data = newData;
                System.out.println("Student record updated successfully.");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Display all student registrations
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.println("Student Registrations:");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        int choice;

        do {
            System.out.println("\n--- Student Registration System ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student Registration Number: ");
                    int insertData = sc.nextInt();
                    list.insert(insertData);
                    break;

                case 2:
                    System.out.print("Enter Registration Number to delete: ");
                    int deleteData = sc.nextInt();
                    list.delete(deleteData);
                    break;

                case 3:
                    System.out.print("Enter Registration Number to search: ");
                    int searchData = sc.nextInt();
                    list.search(searchData);
                    break;

                case 4:
                    System.out.print("Enter old Registration Number: ");
                    int oldData = sc.nextInt();

                    System.out.print("Enter new Registration Number: ");
                    int newData = sc.nextInt();

                    list.update(oldData, newData);
                    break;

                case 5:
                    list.display();
                    break;

                case 6:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}