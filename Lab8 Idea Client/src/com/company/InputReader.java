package com.company;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

//execute_script script3.txt

class InputReader {
    private static Stack<Scanner> readers = new Stack<>();
    private Scanner consoleInput = new Scanner(System.in);
    private boolean SolvingMistakesMode = false;
    InputReader(){
        readers.push(new Scanner(System.in));
    }
    void push(Scanner reader){
        if (!readers.contains(reader)) {
            readers.push(reader);
        }
        else{
            System.out.println("Рекурсия была обнаружена.");
            readers.clear();
            readers.push(new Scanner(System.in));
        }
    }

    public void setSolvingMistakesMode(boolean solvingMistakesMode) {
        SolvingMistakesMode = solvingMistakesMode;
    }

    boolean ConsoleInputCheck() {
        if (readers.size() == 1){
            return true;
        }
        else{
            if (!readers.peek().hasNextLine()){
                readers.pop();
                return ConsoleInputCheck();
            }
            return false;
        }
    }
    String read(){
            if (ConsoleInputCheck()) {
                return readers.peek().nextLine();
            } else {
                if (SolvingMistakesMode) {
                    return consoleInput.nextLine();
                } else {
                    if (readers.peek().hasNextLine()) {
                        return readers.peek().nextLine();
                    } else {
                        return read();
                    }
                }
            }
    }
}
