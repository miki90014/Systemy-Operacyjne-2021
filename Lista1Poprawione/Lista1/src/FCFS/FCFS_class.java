package FCFS;

import Proces.Proces;

public class FCFS_class {
    Proces[] pr;
    int indexPocz;
    int indexKon;
    int oczekiwanie;
    int kolejnosc;

    public FCFS_class(int n){
        this.pr = new Proces[n];
        indexPocz =0;
        indexKon =0;
        oczekiwanie =0;
        kolejnosc =0;
    }

    public boolean czyZapelnione(){
        return indexKon==pr.length;
    }

    public boolean czyKoniec(){
        if(indexKon!=0)
            return indexKon==indexPocz;
        return false;
    }

    public void DodajProces(Proces p){
        if(czyZapelnione()==false) {
            pr[indexKon++] = p;
            pr[indexKon - 1].setKolejnosc(indexKon - 1);
            if (indexKon - 1 == 0) {
                pr[indexKon - 1].setOczekiwanie(0);
            }
        }
    }

    public void WykonajProces(){
        pr[indexPocz].setOczekiwanie(oczekiwanie-pr[indexPocz].getCzasPrzybycia());
        if(oczekiwanie-pr[indexPocz].getCzasPrzybycia()<0)
            pr[indexPocz].setOczekiwanie(0);
        oczekiwanie = oczekiwanie + pr[indexPocz].getDlugosc();
        pr[indexPocz].Dane();
        indexPocz++;
        kolejnosc++;
    }

}
