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
    public Term process(String input) {
        int minpos, numlen;
        int depth = 0, pos = 0, count = 1, div = 1;
        char nextchar;
        // TODO count max depth
        Term[] current = new Term[64];
        current[depth] = new Term(1);
        boolean isDiv = false;
        while(pos<input.length())
        {
            nextchar = input.charAt(pos);
            // pokud nula, invertne se násobitel
            if (nextchar=='-')
            {
                pos++;
                count *= -1;
            }
            // zpracování čísla
            else if (Character.isDigit(nextchar))
            {
                minpos=pos;
                pos++;
                while(Character.isDigit(input.charAt(pos)))
                {
                    pos++;
                    nextchar = input.charAt(pos);
                }
                numlen=pos-minpos;
                if (isDiv)
                    div *= Integer.parseInt(input.substring(minpos, numlen));
                else
                    count *= Integer.parseInt(input.substring(minpos, numlen));
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
                        current[depth].addFraction(count, div);
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
        }
        return current[0];
    }
}
