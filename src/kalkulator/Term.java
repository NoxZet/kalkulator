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
    boolean negative;
    ArrayList<Fraction> nums;
    ArrayList<Term> terms;
    Term(boolean neg) {
        this.negative = neg;
    }
    /**
     * Přidá objekt zlomku do členu.
     * @param num Objekt Fraction ke vložení
     */
    void addFraction(Fraction num) {
        nums.add(num);
    }
    /**
     * Přidá objekt členu do členu.
     * @param term Objekt Term ke vložení
     */
    void addTerm(Term term) {
        terms.add(term);
    }
}
