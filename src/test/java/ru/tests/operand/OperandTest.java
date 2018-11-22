package ru.tests.operand;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static ru.tests.operand.Operand.readFile;

public class OperandTest {

    List<String> operations = new ArrayList<>();

    @Test
    public void operandTestDel(){
       operations =  readFile("E:/Java/operand.txt");

        for (int i = 0; i < operations.size(); i++) {
            String[] str = operations.get(i).split(";");
            Operand operand = new Operand(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[3]), str[2].charAt(0));
            if(str[2].charAt(0) == '/') {
                System.out.print(operand.getOperand1() + " ");
                System.out.print(operand.getOperations() + " ");
                System.out.print(operand.getOperand2() + " ");
                System.out.println(operand.getResult() + " ");
                Assert.assertEquals(operand.arithmethicOperations(),operand.getResult() );
            }
        }
    }

    @Test
    public void operandTestUmn(){
        operations =  readFile("E:/Java/operand.txt");

        for (int i = 0; i < operations.size(); i++) {
            String[] str = operations.get(i).split(";");
            Operand operand = new Operand(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[3]), str[2].charAt(0));
            if(str[2].charAt(0) == '*') {
                System.out.print(operand.getOperand1() + " ");
                System.out.print(operand.getOperations() + " ");
                System.out.print(operand.getOperand2() + " ");
                System.out.println(operand.getResult() + " ");
                Assert.assertEquals(operand.arithmethicOperations(),operand.getResult() );
            }
        }
    }

    @Test
    public void operandTestMinus(){
        operations =  readFile("E:/Java/operand.txt");

        for (int i = 0; i < operations.size(); i++) {
            String[] str = operations.get(i).split(";");
            Operand operand = new Operand(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[3]), str[2].charAt(0));
            if(str[2].charAt(0) == '-') {
                System.out.print(operand.getOperand1() + " ");
                System.out.print(operand.getOperations() + " ");
                System.out.print(operand.getOperand2() + " ");
                System.out.println(operand.getResult() + " ");
                Assert.assertEquals(operand.arithmethicOperations(),operand.getResult() );
            }
        }
    }

    @Test
    public void operandTestPlus(){
        operations =  readFile("E:/Java/operand.txt");

        for (int i = 0; i < operations.size(); i++) {
            String[] str = operations.get(i).split(";");
            Operand operand = new Operand(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[3]), str[2].charAt(0));
            if(str[2].charAt(0) == '+') {
                System.out.print(operand.getOperand1() + " ");
                System.out.print(operand.getOperations() + " ");
                System.out.print(operand.getOperand2() + " ");
                System.out.println(operand.getResult() + " ");
                Assert.assertEquals(operand.arithmethicOperations(),operand.getResult() );
            }
        }
    }

}
