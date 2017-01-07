/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;

import java.util.Scanner;

/**
 *
 * @author Honza
 */
public class UsersInput 
{
    private String inputKey;
    private String noksOutput;
    private Scanner sc;
    boolean manuallyKey;
    
    UsersInput ()
    {
        sc = new Scanner(System.in);
        manuallyKey = true;
    }
    
    UsersInput (String allways)
    {
        inputKey = allways;
        manuallyKey = false;
    }
    
    
    
    public String changeUsersInput ()
    {
        if (manuallyKey){inputKey = entKey();}
        
        noksOutput = inputKey;
        
        noksOutput = odstranParazity(noksOutput); //nechá jen použitelné znaky a udělá trim
        tiskniPriklad ();
        
        noksOutput = insertMultiples(noksOutput); //mezi čísla a závorky a proměné vloží *
        tiskniPriklad ();
        
        noksOutput = vlozZavorky(noksOutput); //vyrovná počet závorek na obou stranách
        tiskniPriklad ();
        
        return noksOutput;
    }
    
    
    private String vlozZavorky(String anovPriklad)
    {
        anovPriklad += " ";
        String vysledek = "";
        String vloz = "";
        String dosavadni = "";
        int pocetZavorek = 0;
        for (int i = 0; i < anovPriklad.length(); i++)
            {
                if (anovPriklad.charAt(i) == '(') {pocetZavorek += 1;}
                if (anovPriklad.charAt(i) == ')') {pocetZavorek -= 1;}
                if (anovPriklad.charAt(i) == ' '|| anovPriklad.charAt(i) == '=')
                    {
                        if (pocetZavorek > 0)
                            {
                            for(int j = 0; j < pocetZavorek; j++)
                                {vloz += ')';}
                            vysledek += dosavadni + vloz;
                            dosavadni = ""; vloz = "";
                            }
                        if (pocetZavorek < 0)
                            {
                            for(int j = 0; j > pocetZavorek; j--)
                                {vloz += '(';}
                            vysledek += vloz + dosavadni;
                            dosavadni = ""; vloz = "";
                            }
                        if (pocetZavorek == 0)
                            {vysledek += dosavadni; dosavadni = "";}
                    }
                dosavadni += anovPriklad.charAt(i);
            }
        
        return vysledek;
    };
    
    
    private String insertMultiples (String anovPriklad)
        {
            anovPriklad += " ";
            String vysledek = "";
            String vysledek2 = "";
            String povoleno = "1234567890xab()";
            String desetCisel = "1234567890";
            char a;
            char b;
            boolean nextTimeContinue = false;
            for (int i = 0; i < anovPriklad.length() - 1; i++)
            {
                if (isContaining (anovPriklad.charAt(i), povoleno) && isContaining (anovPriklad.charAt(i+1), povoleno) )
                    {
                        if(isContaining(anovPriklad.charAt(i), desetCisel) && isContaining(anovPriklad.charAt(i+1), desetCisel))
                            {vysledek += anovPriklad.charAt(i);}
                        else {vysledek += anovPriklad.charAt(i) + "*";}
                    }
                    else {vysledek += anovPriklad.charAt(i);}
            }
            vysledek += " ";
            for (int i = 0; i < vysledek.length() - 1; i++)
            {
                if (nextTimeContinue){nextTimeContinue = false; continue;}
                if (vysledek.charAt(i) == '(' && vysledek.charAt(i+1) == '*')
                    {nextTimeContinue = true;}
                if (vysledek.charAt (i) == '*' && vysledek.charAt(i+1) == ')')
                    {continue;}
                vysledek2 += vysledek.charAt(i);
            }
            return vysledek2;
        }
    
    private String odstranParazity (String anovPriklad)
    {
        String novyString = "";
        String nech = "0123456789abx+-*/()!%^=,.";
        boolean je = false;
        anovPriklad = anovPriklad.replace(",", ".");
        for (int i = 0; i < anovPriklad.length(); i++)
        {
            for (int j = 0; j < nech.length(); j++)
            {
                je = false;
                if (nech.charAt(j) == anovPriklad.charAt(i))
                    {je = true;}
                if (je) {break;}
            }
            
            
            if (je) {novyString += anovPriklad.charAt(i);}
        }
        return novyString;
    }
    
    private void tiskniPriklad()
    {
        System.out.println(noksOutput);
    }
    
    private String entKey() 
    {
       return sc.nextLine();
    }
    
    private boolean isContaining (char a, String s)
    {
        for (int i = 0; i < s.length(); i++)
            {
                if (a == s.charAt(i))
                    {return true;}
            }
        return false;
    }
    
}
