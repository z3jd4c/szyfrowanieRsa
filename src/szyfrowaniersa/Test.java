/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package szyfrowaniersa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 *
 * @author Kuba
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Klucz klucz = Klucz.Singleton();
        
                System.out.println("Wprowadz wiadomosc do szyfrowania: ");
        String message = "";
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    message = bufferRead.readLine();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        BigInteger mess = new BigInteger(message.getBytes());
        BigInteger ciphertext = klucz.szyfruj(mess);        
        System.out.println("Tekst zaszyfrowany: " + ciphertext);        
        mess = klucz.deszyfruj(ciphertext);        
        message = new String(mess.toByteArray());
        System.out.println("Tekst rozszyfrowany: " + message);
        
        
        }}
       
