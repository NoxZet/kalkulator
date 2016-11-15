/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;
import java.util.ArrayList;
/**
 * Člen, obsahuje zlomky a jiné členy.
 * @author Lenny
 */
public class Term {
    Fraction count;
    ArrayList<Fraction> nums;
    ArrayList<Term> terms;
    Term(int count) {
        this.count = new Fraction(count, 1);
    }
    Term(int count, int div) {
        this.count = new Fraction(count, div);
    }
    /**
     * Přidá objekt zlomku do členu.
     * @param num Objekt Fraction ke vložení
     */
    void addFraction(Fraction num) {
        nums.add(num);
    }
    void addFraction(int num, int denum) {
        Fraction number = new Fraction(num, denum);
        nums.add(number);
    }
    /**
     * Přidá objekt členu do členu.
     * @param term Objekt Term ke vložení
     */
    void addTerm(Term term) {
        terms.add(term);
    }
}
