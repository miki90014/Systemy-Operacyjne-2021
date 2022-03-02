package Test_Main;

import FCFS.FCFS_class;
import Proces.Proces;

public class Test_FCFS {
    public static void main (String [] arg) {
        Proces[] pr = new Proces[1000];
        int liniaCzasuDlaProcesu = 0;
        for (int i = 0; i < pr.length; i++) {
            pr[i] = new Proces(Generator.LosowanieNaz(), Generator.Losowanie(), liniaCzasuDlaProcesu,i);
            System.out.println(Generator.LosowanieKiedyPrzybylo());
            liniaCzasuDlaProcesu = liniaCzasuDlaProcesu + Generator.LosowanieKiedyPrzybylo();
        }
        FCFS_class kolejka = new FCFS_class(pr.length);
        for(int i=0; i<pr.length; i++){
            kolejka.DodajProces(pr[i]);
        }
        System.out.println("Kolejnosc zgloszenia" + " " + "Id Procesu" +" " + "Dlugosc"+" "+"Moment zgloszenia"+" "+"Czas Oczekiwania");
        while(kolejka.czyKoniec()==false){
            kolejka.WykonajProces();
        }

        System.out.println(Generator.SredniCzasOczekiwania(pr));

        /*
        Proces [] pr = new Proces[10];
        pr[0] = new Proces("P0",10,2,0);
        pr[1] = new Proces("P1",15,6,1);
        pr[2] = new Proces("P2",5,7,2);
        pr[3] = new Proces("P3",90,9,3);
        pr[4] = new Proces("P4",23,10,4);
        pr[5] = new Proces("P5",13,11,5);
        pr[6] = new Proces("P6",11,23,6);
        pr[7] = new Proces("P7",3,23,7);
        pr[8] = new Proces("P8",45,24,8);
        pr[9] = new Proces("P9",7,45,9);
         */


    }
}
