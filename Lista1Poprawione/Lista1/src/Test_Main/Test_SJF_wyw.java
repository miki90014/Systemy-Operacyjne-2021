package Test_Main;

import Proces.Proces;
import SJF.SJF_WYW_class;
import SJF.SJF_class;

public class Test_SJF_wyw {
    public static void main (String [] arg) {
        Proces[] pr = new Proces[1000];
        int liniaCzasuDlaProcesu = 0;
        int liniaCzasowa =0;
        for (int i = 0; i < pr.length; i++) {
            pr[i] = new Proces(Generator.LosowanieNaz(), Generator.Losowanie(), liniaCzasuDlaProcesu,i);
            liniaCzasuDlaProcesu = liniaCzasuDlaProcesu + Generator.LosowanieKiedyPrzybylo();
        }
        SJF_WYW_class kolejka = new SJF_WYW_class(pr.length);
        System.out.println("Kolejnosc zgloszenia" + " " + "Id Procesu" +" " + "Dlugosc"+" "+"Moment zgloszenia"+" "+"Czas Oczekiwania");
        kolejka.DodajProces(pr[0]);
        int j=1;
        liniaCzasowa = pr[j+1].getCzasPrzybycia();
        while(j!=pr.length)
        {
            kolejka.WykonywanieProcesu(liniaCzasowa);
            kolejka.DodajProces(pr[j]);
            liniaCzasowa = pr[j].getCzasPrzybycia();
            j++;
        }
        while(kolejka.czyPusta() == false){
            kolejka.Wykanczanie();
        }
        System.out.println(Generator.SredniCzasOczekiwania(pr));
        }
}
