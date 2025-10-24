package com.npd;

import java.io.*;
import java.util.*;

public class NotesManager {
    private final String filePath;
    private final Scanner scanner = new Scanner(System.in);

    public NotesManager(String filePath) {
        this.filePath = filePath;
    }

    public void addNote() {
        System.out.println("Enter your note (single line). Press Enter to save:");
        String note = scanner.nextLine().trim();
        if (note.isEmpty()) {
            System.out.println("Empty note. Not saved.");
            return;
        }
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(note);
            bw.newLine();
            System.out.println("Note saved.");
        } catch (IOException e) {
            System.err.println("Failed to write note: " + e.getMessage());
        }
    }

    public void viewNotes() {
        List<String> notes = readAllNotes();
        if (notes.isEmpty()) {
            System.out.println("-- No notes found --");
            return;
        }
        System.out.println("Your notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, notes.get(i));
        }
    }

    public void deleteNote() {
        List<String> notes = readAllNotes();
        if (notes.isEmpty()) {
            System.out.println("-- No notes to delete --");
            return;
        }
        viewNotes();
        System.out.print("Enter the note number to delete (or 0 to cancel): ");
        String input = scanner.nextLine().trim();
        int idx;
        try {
            idx = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
            return;
        }
        if (idx == 0) {
            System.out.println("Canceling deletion.");
            return;
        }
        if (idx < 1 || idx > notes.size()) {
            System.out.println("Number out of range.");
            return;
        }
        notes.remove(idx - 1);
        try (FileWriter fw = new FileWriter(filePath, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (String n : notes) {
                bw.write(n);
                bw.newLine();
            }
            System.out.println("Note deleted.");
        } catch (IOException e) {
            System.err.println("Failed to delete note: " + e.getMessage());
        }
    }

    public void searchNotes() {
        List<String> notes = readAllNotes();
        if (notes.isEmpty()) {
            System.out.println("-- No notes to search --");
            return;
        }
        System.out.print("Enter search query: ");
        String q = scanner.nextLine().trim().toLowerCase();
        if (q.isEmpty()) {
            System.out.println("Empty query.");
            return;
        }
        boolean found = false;
        for (int i = 0; i < notes.size(); i++) {
            String note = notes.get(i);
            if (note.toLowerCase().contains(q)) {
                if (!found) {
                    System.out.println("Matches:");
                    found = true;
                }
                System.out.printf("%d. %s%n", i + 1, note);
            }
        }
        if (!found) System.out.println("No matches found.");
    }

    public void clearNotes() {
        System.out.print("Are you sure you want to delete ALL notes? (yes/no): ");
        String ans = scanner.nextLine().trim().toLowerCase();
        if (!ans.equals("yes")) {
            System.out.println("Aborted.");
            return;
        }
        try (FileWriter fw = new FileWriter(filePath, false)) {
            System.out.println("All notes cleared.");
        } catch (IOException e) {
            System.err.println("Failed to clear notes: " + e.getMessage());
        }
    }

    private List<String> readAllNotes() {
        List<String> notes = new ArrayList<>();
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return notes;
    }
}
