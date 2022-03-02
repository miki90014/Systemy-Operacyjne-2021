package Roatcyjny;

import Proces.Proces;

public class Rotacja_class {
    Proces[] pr;
    int indexKon;
    int oczekiwanie;
    int kolejnosc;
    int kwant_czasu;
    int index;
    int temp;
    Proces tempProc;

    public Rotacja_class(int n, int kwant_czasu){
        this.pr = new Proces[n];
        this.kwant_czasu = kwant_czasu;
        indexKon =0;
        oczekiwanie =0;
        kolejnosc =0;
        index=0;
    }

    public boolean czyZapelnione(){
        return indexKon==pr.length;
    }


    public void DodajProces(Proces p){
        if(czyZapelnione()==false) {
            pr[indexKon] = p;
            indexKon++;
        }
    }
    public boolean czyPusta(){
        if(indexKon==0){
            return true;
        }
        return false;
    }


    public int WykonywanieProcesu(){
        pr[index].setIlezostalo(kwant_czasu + pr[index].getIlezostalo());
        if(kwant_czasu > pr[index].getDlugosc())
        if(pr[index].getIlezostalo() > pr[index].getDlugosc()) {
            temp = pr[index].getIlezostalo() - pr[index].getDlugosc();
            UsuwanieProcesu(index);
        }
        else{
            temp=kwant_czasu;
        }
        for(int i=0; i<indexKon; i++){
            if(i!=index){
                pr[i].setOczekiwanie(pr[i].getOczekiwanie()+temp);

            }
        }
        if(index+1 >=indexKon){
            index=0;
        }
        else{
            index++;
        }
       return temp;
    }

    public void UsuwanieProcesu(int indexUsuwanegoProcesu){
        tempProc = pr[indexUsuwanegoProcesu];
        for(int i=indexUsuwanegoProcesu; i<indexKon-1; i++){
            pr[i]=pr[i+1];
        }
        indexKon--;
        tempProc.Dane();
    }


}
