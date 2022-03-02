package SJF;

import Procesy.Proces;

public class SJF_bezwywlaszczenia {

    int n;
    public Proces[] tab;
    int indexEnd;
    int oczekiwanie;
    int kolejnosc;
    Proces temp;

    public SJF_bezwywlaszczenia(int n){
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
        if(isFull()==false){
            tab[indexEnd++] = pr;
            tab[indexEnd-1].setMomentZgłoszenia(kolejnosc);
            kolejnosc ++;

            for (int i = 0; i < indexEnd-1; i++){
                for (int j = 0; j < indexEnd-1; j++){
                    if(tab[j].getDlugosc() > tab[j + 1].getDlugosc()){
                        temp = tab[j];
                        tab[j] = tab[j + 1];
                        tab[j + 1] = temp;
                    }
                }
            }
            //sortowanko! UWAGA od inexEnd-1!!!
        }
        //tutaj zmienić, aby przydodawaniu sortowało
    }

    public void UsunProces(){
        //tutaj zmienić znowu!
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
