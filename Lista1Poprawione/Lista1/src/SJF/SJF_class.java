package SJF;

import Proces.Proces;

public class SJF_class {
    Proces[] pr;
    int indexPocz;
    int indexKon;
    int oczekiwanie;
    int kolejnosc;
    private Proces temp;

    public SJF_class(int n){
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
        return indexPocz==pr.length;
    }

    public void DodajProces(Proces p) {
            pr[indexKon++] = p;
            pr[indexKon - 1].setKolejnosc(indexKon - 1);
            if (indexKon - 1 == 0) {
                pr[indexKon - 1].setOczekiwanie(0);
            }
            if(indexKon-1!=0) {
                for (int i = indexPocz; i < indexKon-1; i++) {
                    for (int j = indexPocz; j < indexKon-1; j++) {
                            if (pr[j].getDlugosc() > pr[j + 1].getDlugosc()) {
                                temp = pr[j];
                                pr[j] = pr[j + 1];
                                pr[j + 1] = temp;
                        }
                    }
                }
            }
    }

    public void WykonajProces(){
        if(indexPocz!=pr.length) {
            pr[indexPocz].setKolejnosc(kolejnosc);
            pr[indexPocz].setOczekiwanie(oczekiwanie - pr[indexPocz].getCzasPrzybycia());
            if(oczekiwanie-pr[indexPocz].getCzasPrzybycia()<0)
                pr[indexPocz].setOczekiwanie(0);
            oczekiwanie = oczekiwanie + pr[indexPocz].getDlugosc();
            pr[indexPocz].Dane();
            indexPocz++;
            kolejnosc++;
        }
    }

}
