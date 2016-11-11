/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

/**
 *
 * @author Lenny
 */
import commonMultiple.NumberGroup;
import commonMultiple.Number;
import java.util.ArrayList;
public class Kalkulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Number[] group = new Number[2];
        group[0] = new Number(14);
        group[1] = new Number(21);
        NumberGroup skupka = new NumberGroup(group, 2);
        ArrayList<Integer> list = skupka.calculate(true);
        int totalResult = 1;
        for (int i : list)
        {
            totalResult *= i;
        }
        System.out.println(totalResult);
    }
    
}
