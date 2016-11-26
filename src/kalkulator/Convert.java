/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

/**
 * Převede zpracovaný string na jeden halvní člen, obsahující další prvky.
 * @author Lenny
 */
public class Convert {
    String str;
    public Convert(String input){
        newInput(input);
    }
    private void newInput(String input) {
        str = input;
    }
    public Term process() {
        int strlen, dotpos, places, i, e;
        int depth = 0, pos = 0, count = 1, div = 1, temp, temp2;
        char nextchar;
        String substr = "";
        String input = str;
        // TODO count max depth
        Term[] current = new Term[64];
        current[depth] = new Term(1);
        boolean isDiv = false;
        while(pos<input.length())
        {
            nextchar = input.charAt(pos);
            // pokud znaménko mínus, invertne se násobitel
            if (nextchar=='-')
            {
                pos++;
                count *= -1;
            }
            // zpracování čísla
            else if (Character.isDigit(nextchar) || nextchar=='.')
            {
                //minpos=pos;
                substr=""+nextchar;
                pos++;
                nextchar = input.charAt(pos);
                while(Character.isDigit(nextchar) || nextchar=='.')
                {
                    pos++;
                    substr+=nextchar;
                    nextchar = input.charAt(pos);
                }
                //numlen=pos-minpos;
                dotpos = substr.indexOf('.');
                if (dotpos>0)
                {
                    strlen = substr.length();
                    places = strlen-dotpos;
                    temp = Integer.parseInt(substr.replace(".",""));
                    temp2 = 1;
                    for(i=1;i<places;i++)
                        temp2*=10;
                }
                else
                {
                    temp = Integer.parseInt(substr);
                    temp2 = 1;
                }
                if (isDiv)
                {
                    count *= temp2;
                    div *= temp;
                }
                else
                {
                    count *= temp;
                    div *= temp2;
                }
                switch (nextchar) {
                    case '*':
                        pos++;
                        isDiv=false;
                        break;
                    case '/':
                        pos++;
                        isDiv=true;
                        break;
                    case '+':
                    case '-':
                    case ')':
                        current[depth].addFraction(new Fraction(count, div));
                        //System.out.println(count);
                        //System.out.println(div);
                        count = 1; div = 1; isDiv = false;
                        break;
                    default:
                        break;
                }
            }
            // začátek dalšího členu
            else if (nextchar=='(')
            {
                pos++;
                depth++;
                current[depth] = new Term(count, div);
                count = 1; div = 1; isDiv = false;
            }
            // konec členu
            else if (nextchar==')' && depth>0)
            {
                pos++;
                depth--;
                count = 1; div = 1; isDiv = false;
            }
            else if (nextchar==')')
            {
                pos = input.length();
            }
            else
                pos++;
        }
        return current[0];
    }
}
