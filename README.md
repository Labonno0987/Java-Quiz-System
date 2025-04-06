# MCQ Quiz System: A Java-based Multiple Choice Question Platform
## Description
This is a simple Java-based MCQ Quiz System designed for learning and practice.It supports Admin and Student roles with separate functionalities.Admins can add MCQ questions to a JSON-based quiz bank.Students can take a 10-question random quiz and receive a score with feedback.

## Technology I Used
- Java (Core Java)
- JSON (for storing users and questions)

## Prerequisites
Before running the system, make sure you have:
- Java (JDK 17 or above) installed
- An IDE like **IntelliJ IDEA** installed
- `quiz.json` and `users.json` files placed in the root directory
  
## How to run?
- ### Clone the Repository
     - ```git clone https://github.com/Labonno0987/Java-Quiz-System```
     - ```cd Java-Quiz-System ```
       
- ### Run the Quiz System
   - Go to the MCQQuizSystem1.java or Main.java (whichever is your entry point).
   - Open it in your IDE (e.g., IntelliJ).
   - Right-click on the file → Select Run 'MCQQuizSystem'.
   - Follow the on-screen prompts to log in as admin or student.
  
## Project Structure
 ### Java-Quize_System/
- ├── src/main
- │   ├── java
- │   │    ├── Main.java
- │   │    ├── Admin.java
- │   │    └── Student.java
- │   └── respurces
- │       ├── users.json
- │       └── quize.json
- ├── .gitignore
- ├── README.md
- └── (Excluded: .idea/, build/, .gradle/, out/)

##  How It Works
- ### For Admin:
     ##### 1. Logs in using credentials from users.json
     ##### 2. Adds new questions via console input
     ##### 3. Questions are saved into quiz.json
- ### For Student:
     ##### 1. Logs in using credentials from users.json
     ##### 2. Gets 10 random questions from quiz.json
     ##### 3. Answers questions one by one
     ##### 4. Final score and performance feedback are shown
   
## Task Checklist
- Admin can add questions
-  Students take quiz with 10 random MCQs
-  JSON file reading/writing implemented
-  Score calculation & feedback shown


## System Walkthrough Video
- [Click here to view the how the Admin Portal Work](https://drive.google.com/file/d/1s2TY_1NxBOU83DE7Wk1z8HJoWsaiGdx3/view?usp=sharing)
- [Click here to view the how the Student Portal Work](https://drive.google.com/file/d/1EsgJz-VPabgDbJeurOk49pImRE5XVLUl/view?usp=sharing)   




