package Test_Main;

import FCFS.FCFS_class;
import Proces.Proces;
import Roatcyjny.Rotacja_class;

public class Test_Roatcyjny {
    public static void main (String [] arg) {
        Proces[] pr = new Proces[1000];
        int liniaCzasuDlaProcesu = 0;
        int liniaCzasowa=0;
        int kwant_czasu=100;
        for (int i = 0; i < pr.length; i++) {
            pr[i] = new Proces(Generator.LosowanieNaz(), Generator.Losowanie(), liniaCzasuDlaProcesu, i);
            liniaCzasuDlaProcesu = liniaCzasuDlaProcesu + Generator.LosowanieKiedyPrzybylo();
        }
        for(int i=0; i<pr.length; i++){
            pr[i].Dane();
        }
        System.out.println("Kolejnosc zgloszenia" + " " + "Id Procesu" +" " + "Dlugosc"+" "+"Moment zgloszenia"+" "+"Czas Oczekiwania");
        Rotacja_class kolejka = new Rotacja_class(pr.length, kwant_czasu);
        kolejka.DodajProces(pr[0]);
        int j=1;
        while(j!=pr.length)
        {
            liniaCzasowa = liniaCzasowa + kolejka.WykonywanieProcesu(liniaCzasowa);
        }
        while(kolejka.czyPusta() == false){
            liniaCzasowa = liniaCzasowa + kolejka.WykonywanieProcesu(liniaCzasowa);
        }
        System.out.println(Generator.SredniCzasOczekiwania(pr));
    }
}
