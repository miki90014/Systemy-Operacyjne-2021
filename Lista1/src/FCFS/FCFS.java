package FCFS;

import Procesy.Proces;

public class FCFS {

    int n;
    public Proces [] tab;
    int indexEnd;
    int oczekiwanie;
    int kolejnosc;

    public FCFS(int n){
        indexEnd = 0;
        oczekiwanie = 0;
        this.n =n;
        tab = new Proces[n];
        kolejnosc = 0;
    }

    public boolean isFull(){
        return (indexEnd== n);
    }

    public boolean isEmpty(){
        return (indexEnd==0);
    }

    public void DodajProces(Proces pr){
        if(isFull()==false) {
            tab[indexEnd++] = pr;
            tab[indexEnd-1].setMomentZgłoszenia(kolejnosc);
            kolejnosc ++;
        }
    }

    public void UsunProces(){
        if(isEmpty()==false){
            tab[0].setCzasOczekiwania(oczekiwanie);
            tab[0].DanyProces();
            oczekiwanie = oczekiwanie + tab[0].getDlugosc();
            for(int i=0; i< indexEnd-1; i++){
                tab[i]=tab[i+1];
            }
            indexEnd--;
        }
    }

}
