/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

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
    Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }
}
