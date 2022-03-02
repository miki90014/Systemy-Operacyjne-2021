package Test;

import Procesy.Proces;

import java.util.LinkedList;
import java.util.Random;

import static java.lang.Math.abs;

public class GeneratorLiczbLosowych {
    public static int Losowanie(){
        int m;
        Random generator = new Random();
        m =abs(generator.nextInt()%1000);
        return m;
    }
    public static int LosowanieIleProcesowPrzybylo(){
        int m;
        Random generator = new Random();
        m =abs(generator.nextInt()%5);
        return m;
    }

    public static String LosowanieNaz(){
        int  m1, m2, m3, m4, m5;
        Random generator = new Random();
        m1 = abs(generator.nextInt()%10);
        m2 = abs(generator.nextInt()%10);
        m3 = abs(generator.nextInt()%10);
        m4 = abs(generator.nextInt()%10);
        m5 = abs(generator.nextInt()%10);
        return ("P" + String.valueOf(m1) + String.valueOf(m2) +String.valueOf(m3) +String.valueOf(m4) + String.valueOf(m5));

    }

    public static double SredniCzasOczekiwania(Proces [] pr){
        double sr=0;
        for(int i=0; i<pr.length; i++){
            sr=sr + pr[i].getCzasOczekiwania();
        }
        return sr=sr/pr.length;
    }
}
