package ru.tests.operand;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Operand {

    private int operand1;
    private int operand2;
    private int result;
    private char operations;

    public Operand(int operand1, int operand2, int result, char operation){
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
        this.operations = operation;
    }

    public static List<String> readFile(String path){

        List<String> operations = new ArrayList<>();

        try{
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null){
                operations.add(strLine);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return operations;
    }

    public int arithmethicOperations(){
        int result = 0;
        switch (getOperations()){
            case('+'):
                result = getOperand1() + getOperand2();
                break;
            case('-'):
                result = getOperand1() - getOperand2();
                break;
            case('*'):
                result = getOperand1() * getOperand2();
                break;
            case('/'):
                result = getOperand1() / getOperand2();
                break;
            default:
                System.out.println("Ошибка в третьем аргументе");
        }
        return result;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public int getResult() {
        return result;
    }

    public char getOperations() {
        return operations;
    }
}
