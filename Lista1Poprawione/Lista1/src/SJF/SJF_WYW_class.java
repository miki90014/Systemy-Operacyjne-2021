package SJF;

import Proces.Proces;

public class SJF_WYW_class {
    Proces[] pr;
    int indexKon;
    int oczekiwanie;
    int kolejnosc;
    private Proces temp;

    public SJF_WYW_class(int n){
        this.pr = new Proces[n];
        indexKon =0;
        oczekiwanie =0;
        kolejnosc =0;
    }


    public boolean czyPusta(){
        if(indexKon==0){
            return true;
        }
        return false;
    }


    public void DodajProces(Proces p) {
        pr[indexKon++] = p;
        pr[indexKon-1].setIlezostalo(pr[indexKon-1].getDlugosc());
        if(indexKon-1!=0) {
            for (int i = 0; i < indexKon-1; i++) {
                for (int j = 0; j < indexKon-1; j++) {
                    if (pr[j].getIlezostalo() > pr[j + 1].getIlezostalo()) {
                        temp = pr[j];
                        pr[j] = pr[j + 1];
                        pr[j + 1] = temp;
                    }
                }
            }
        }
    }
    public void WykonywanieProcesu(int czas){
        pr[0].setIlezostalo(pr[0].getIlezostalo()-czas);
        for(int i=1; i<indexKon; i++){
            pr[i].setOczekiwanie(pr[i].getOczekiwanie()+czas);
        }
        if(pr[0].getIlezostalo()<=0){
            UsunProces();
        }
    }
    public void Wykanczanie(){
        for(int i=1; i<indexKon; i++){
            pr[i].setOczekiwanie(pr[i].getOczekiwanie()+pr[0].getIlezostalo());
        }
        UsunProces();
    }

    public void UsunProces(){
        pr[0].Dane();
        for(int i=0; i<indexKon-1; i++){
            pr[i] = pr[i+1];
        }
        indexKon--;
    }


}
