/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package szyfrowaniersa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Kuba
 */
public final class Klucz {
    private static volatile Klucz klucz = null;
       private BigInteger pp,qq,nn,d,e,eeuler;
       //int i;
      // boolean czypierwsza = false;
      // boolean czypierwszaq = false;
       Random generator =  new Random();
       
          
    
    private Klucz() {
    ///////////////// P
        
        /*
       
       p = (generator.nextInt(200000))+100000;
       
       outerLoop:
       while(czypierwsza == false){
           i= 2;
       while(p%i != 0){
       i++;
       //System.out.println(" i = " + i);
       if(p%2 == 0) break;
       if(i == p) {
           //czypierwsza = true;
           //System.out.println("jest pierwsza, i = " + i);
           break outerLoop;}
       }
       //System.out.println(p + " nie jest pierwsza");;
       p = (generator.nextInt(200000))+100000;
       }
       
       /////////////////////// Q
      q = (generator.nextInt(200000))+100000;
              outerLoop:
       while(czypierwszaq == false){
           i= 2;
       while(q%i != 0){
       i++;
       //System.out.println(" i = " + i);
       if(q%2 == 0) break;
       if(i == q) {
           //czypierwszaq = true;
           //System.out.println("jest pierwsza, i = " + i);
           break outerLoop;}
       }
       //System.out.println(p + " nie jest pierwsza");;
       q = (generator.nextInt(200000))+100000;
       }
        */
       
       //pp = BigInteger.valueOf(p);
       //qq = BigInteger.valueOf(q);
       pp = new BigInteger(512, 15, generator);
       qq = new BigInteger(512, 15, generator);
       nn = pp.multiply(qq);
       System.out.println("n = p * q = " + nn);
        
       
        eeuler = pp.subtract(BigInteger.valueOf(1));
        eeuler = eeuler.multiply(qq.subtract(BigInteger.valueOf(1)));
       
       System.out.println("BigInteger (p-1)(q-1) = " + eeuler);
       
       //do 
       //{
       //e = new BigInteger(512, generator);
       //System.out.println("klucz = " + e);
       //System.out.println("nwd =" + nwd(eeuler,e));
       //}
       //while ((!(nwd(eeuler,e).equals((BigInteger.ONE)))) && e.compareTo(nn) < 0);
       
               do 
        {
            e = new BigInteger(512, generator);
        } 
        while (e.compareTo(eeuler) != 1 && e.gcd(eeuler).compareTo(BigInteger.valueOf(1)) != 0);
        
        d = e.modInverse(eeuler); 
       
       d = e.modInverse(eeuler);
       System.out.println("klucz prywatny = " + d);
    }
    
     public static Klucz Singleton() {
       if (klucz == null) {
            synchronized (Klucz.class) {
                if (klucz == null) {
                    return new Klucz();
                }
            }
        }
        return klucz;
    }
     
      public BigInteger szyfruj(BigInteger text) {
        return text.modPow(e, nn);
    }
    
    public BigInteger deszyfruj(BigInteger text) {
        return text.modPow(d, nn);
    }
    
}
