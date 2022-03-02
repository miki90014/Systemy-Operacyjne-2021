package Test;

import FCFS.FCFS;
import Procesy.Proces;

import static Test.GeneratorLiczbLosowych.SredniCzasOczekiwania;

public class FCFO_Test {
    public static void main (String [] arg){
        Proces [] pr = new Proces[20];
        for(int i=0; i<pr.length; i++){
            pr[i] = new Proces(GeneratorLiczbLosowych.LosowanieNaz(),GeneratorLiczbLosowych.Losowanie(),i);
        }

        for(int i=0; i< pr.length; i++){
            pr[i].DanyProces();
        }

        FCFS kolejka = new FCFS(pr.length);
        int i=0;
        while(kolejka.isFull()==false){
            kolejka.DodajProces(pr[i]);
            i++;
        }
        System.out.println("nazwa " + "dlugosc " + "czas oczekiwania " + "kolejnosc");
        while(kolejka.isEmpty()==false){
            kolejka.UsunProces();
        }

        System.out.println("Sredni czas oczekiwania dla " + pr.length + "-procesow: " +SredniCzasOczekiwania(pr));



    }
}
