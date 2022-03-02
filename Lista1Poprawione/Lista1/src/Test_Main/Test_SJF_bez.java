package Test_Main;

import Proces.Proces;
import SJF.SJF_class;

public class Test_SJF_bez {
    public static void main (String [] arg) {
        Proces[] pr = new Proces[1000];
        int liniaCzasuDlaProcesu = 0;
        int liniaCzasu =0;
        int j=1,k=0;
        for (int i = 0; i < pr.length; i++) {
            pr[i] = new Proces(Generator.LosowanieNaz(), Generator.Losowanie(), liniaCzasuDlaProcesu,i);
            liniaCzasuDlaProcesu = liniaCzasuDlaProcesu + Generator.LosowanieKiedyPrzybylo();
        }
        SJF_class kolejka = new SJF_class(pr.length);
        System.out.println("Kolejnosc zgloszenia" + " " + "Id Procesu" +" " + "Dlugosc"+" "+"Moment zgloszenia"+" "+"Czas Oczekiwania");
        kolejka.DodajProces(pr[0]);
        while(j<pr.length){
            while(pr[j].getCzasPrzybycia() <= liniaCzasu){
                kolejka.DodajProces(pr[j]);
                j++;
                if(j==pr.length){
                    break;
                }
            }
            if(kolejka.czyKoniec()==false){
            kolejka.WykonajProces();
            }
            liniaCzasu=liniaCzasu+pr[k].getDlugosc();
            k++;
        }
        while(kolejka.czyKoniec()==false){
            kolejka.WykonajProces();
        }
        System.out.println(Generator.SredniCzasOczekiwania(pr));


    }
}
