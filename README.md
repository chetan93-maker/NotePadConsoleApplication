# 📝 Notes App (Java File I/O Project)

A simple **console-based Notes Application** built using **Java File Handling (FileReader, FileWriter, BufferedReader, BufferedWriter)**.  
This project allows users to add, view, delete, search, and clear notes — all stored in a local text file (`notes.txt`).

---

## 📂 Project Structure
NotePad/
├── NotesApp.java # Main class - user menu and program flow
├── NotesManager.java # Handles file operations (add, view, delete, search, clear)
├── NotesUtility.java # Utility class to check or create file
└── README.md # Project documentation

yaml
Copy code

---

## ⚙️ Features
✅ Add a new note  
✅ View all saved notes  
✅ Delete a specific note by number  
✅ Search for a note (case-insensitive)  
✅ Clear all notes  
✅ Data stored persistently in `notes.txt`

---

## 🧠 Java Concepts Used
- **FileReader / BufferedReader** → for reading from files  
- **FileWriter / BufferedWriter** → for writing to files  
- **try-with-resources** → automatic resource closing  
- **Exception Handling** → managing `IOException` and `FileNotFoundException`  
- **Classes & Objects** → for better modular structure  

---

## ▶️ How to Run

### 1️⃣ Open Terminal or Command Prompt
Go to your project folder:
```bash
cd NotePad
2️⃣ Compile the Java files
bash
Copy code
javac NotesApp.java NotesManager.java NotesUtility.java
3️⃣ Run the main program
bash
Copy code
java NotesApp
4️⃣ Use the menu
You’ll see:

markdown
Copy code
=== Simple Notes App ===
1. Add note
2. View notes
3. Delete a note
4. Search notes
5. Clear all notes
6. Exit
Enter choice:
