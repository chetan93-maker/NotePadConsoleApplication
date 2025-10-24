package com.npd;

import java.util.Scanner;

public class NotesApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final NotesManager manager = new NotesManager("notes.txt");

    public static void main(String[] args) {
        System.out.println("=== Simple Notes App ===");
        NotesUtility.ensureFileExists("notes.txt");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": manager.addNote(); break;
                case "2": manager.viewNotes(); break;
                case "3": manager.deleteNote(); break;
                case "4": manager.searchNotes(); break;
                case "5": manager.clearNotes(); break;
                case "6":
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Choose 1-6.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add note");
        System.out.println("2. View notes");
        System.out.println("3. Delete a note");
        System.out.println("4. Search notes");
        System.out.println("5. Clear all notes");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }
}
