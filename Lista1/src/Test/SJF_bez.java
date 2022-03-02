package Test;

import Procesy.Proces;
import SJF.SJF_bezwywlaszczenia;

import static Test.GeneratorLiczbLosowych.SredniCzasOczekiwania;

public class SJF_bez {
    public static void main(String [] arg){
        Proces[] pr = new Proces[100];
        for(int i=0; i<pr.length; i++){
            pr[i] = new Proces(GeneratorLiczbLosowych.LosowanieNaz(),GeneratorLiczbLosowych.Losowanie(),i);
        }

        SJF_bezwywlaszczenia kolejka = new SJF_bezwywlaszczenia(pr.length);

        int c=0, n=0, ileProcesowDodalo;

        System.out.println("nazwa " + "dlugosc " + "czas oczekiwania " + "kolejnosc");
        while(c< pr.length){
            ileProcesowDodalo = GeneratorLiczbLosowych.LosowanieIleProcesowPrzybylo();
            if(ileProcesowDodalo > pr.length - c) {
                break;
            }
            for(int i=0; i<ileProcesowDodalo; i++){
                kolejka.DodajProces(pr[c]);
                c++;
            }
            kolejka.UsunProces();
            }
        for(int i=0; i<pr.length-c; i++){
            kolejka.DodajProces(pr[c+i]);
        }

        while(kolejka.isEmpty()==false){
            kolejka.UsunProces();
        }
        System.out.println("Sredni czas oczekiwania dla " + pr.length + "-procesow: " +SredniCzasOczekiwania(pr));

    }
}
