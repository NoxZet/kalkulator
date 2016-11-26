/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;
import commonMultiple.NumberGroup;
import commonMultiple.Number;
import java.util.ArrayList;

/**
 * Zlomek, je složen ze dvou celých čísel, čitatele a jmenovatele.
 * @author Lenny
 */
public class Fraction {
    /**
     * 
     * @param num Numerator, čitatel
     * @param denum Denumerator, jmenovatel
     */
    int num, denum;
    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
        simplify();
    }
    /**
     * 
     * @param list ArrayList s prvočísly
     * @return Součin prvočísel
     */
    private int listToInt(ArrayList<Integer> list)
    {
        int e, i = 1, len = list.size();
        for(e = 0; e < len; e++)
        {
            i *= list.get(e);
        }
        return i;
    }
    private void simplify()
    {
        Number[] nums = new Number[2];
        nums[0] = new Number(num);
        nums[1] = new Number(denum);
        NumberGroup group = new NumberGroup(nums, 2);
        ArrayList<Integer> list = group.calculate(true);
        int div = listToInt(list);
        num /= div;
        denum /= div;
        System.out.println(num);
        System.out.println(denum);
    }
}
