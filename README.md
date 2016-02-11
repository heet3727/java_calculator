# java_calculator
Java event handling program for scientific calculator.

## View live Demo:
- Download the file
- javac checkCalc.java ( compile the java file )
- java checkCalc ( run the class file )

## Features & Libraries used:
- maintains the history of operation performed. ( fileIO -> FileReader, FileWriter )
- Display of last 5 operations on the screen. ( used JTextArea )
- some advanced operations including sine, cosine, tangent, logarithm, power ( using math library )
- KeyBoard actions supported ( KeyListener ) 
      ( sine->s, cosine->c, tangent->t, logarithm->l, clear->del, remaining the same keys)
- During the execution of program, if our file for history-backup is deleted, automatically re-create the file. ( Exception Handling )
- UI using swing
