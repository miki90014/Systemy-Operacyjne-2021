package Algorytmy;
import Strony.Strona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class Algorytmy {
    int wielkośćRamki;
    int licznik;
    int puste;
    Strona [] strony;
    Strona [] ramki;
    Strona [] tab;
    Strona [][] pokaz;

    public Algorytmy(int wielkośćRamki, Strona [] strony){
        this.wielkośćRamki = wielkośćRamki;
        this.ramki = new Strona[wielkośćRamki];
        this.strony = strony;
        this.licznik =0;
        this.tab = new Strona[strony.length];
        this.pokaz = new Strona[strony.length][wielkośćRamki];
    }

    public int FIFO(){
        licznik=0;
        puste=0;
        for(int i=0; i<strony.length; i++){
            tab[i] = strony[i];
        }

        for(int i=0; i<ramki.length; i++){
            ramki[i] = null;
        }
        Strona temp;
        boolean k=true;
        int m=0;
        for(int i=0; i< tab.length; i++){
            temp = tab[i];
            k=true;
            if(puste <wielkośćRamki){
                for(int j=0; j<puste; j++){
                    if(temp.getNumer()==ramki[j].getNumer()){
                        k=false;
                        break;
                    }
                }
                if(k==true) {
                    ramki[puste] = temp;
                    licznik++;
                    puste++;
                    m++;
                }
            }
            else{
                for(int j=0; j<wielkośćRamki; j++) {
                    if (temp.getNumer() == ramki[j].getNumer()) {
                        k = false;
                        break;
                    }
                }
                if(k==true) {
                    ramki[m%wielkośćRamki] = temp;
                    licznik++;
                    m++;
                    puste++;
                }
            }
            for(int p=0; p<wielkośćRamki; p++){
                pokaz[i][p]=ramki[p];
            }
        }
        return licznik;
    }

    public int Random(){
        licznik =0;
        for(int i=0; i<strony.length; i++){
            tab[i] = strony[i];
        }

        for(int i=0; i<ramki.length; i++){
            ramki[i] = null;
        }
        Strona temp;
        boolean k=true;
        int m=0;
        for(int i=0; i< tab.length; i++){
            temp = tab[i];
            k=true;
            if(puste <wielkośćRamki){
                for(int j=0; j<puste; j++){
                    if(temp.getNumer()==ramki[j].getNumer()){
                        k=false;
                        break;
                    }
                }
                if(k==true) {
                    ramki[puste] = temp;
                    licznik++;
                    puste++;
                    m++;
                }
            }
            else{
                for(int j=0; j<wielkośćRamki; j++) {
                    if (temp.getNumer() == ramki[j].getNumer()) {
                        k = false;
                        break;
                    }
                }
                if(k==true) {
                    Random r = new Random();
                    m=abs(r.nextInt());
                    ramki[m%wielkośćRamki] = temp;
                    licznik++;
                    puste++;
                }
            }
            for(int p=0; p<wielkośćRamki; p++){
                pokaz[i][p]=ramki[p];
            }
        }
        return licznik;
    }

    public int LRU(){
        licznik=0;
        puste=0;
        for(int i=0; i<strony.length; i++){
            tab[i] = strony[i];
        }
        int [] pom = new int [wielkośćRamki];

        for(int i=0; i<ramki.length; i++){
            ramki[i] = null;
        }
        Strona temp;
        boolean k=true;
        int m=0;
        for(int i=0; i< tab.length; i++){
            temp = tab[i];
            k=true;
            if(puste <wielkośćRamki){
                for(int j=0; j<puste; j++){
                    if(temp.getNumer()==ramki[j].getNumer()){
                        k=false;
                        break;
                    }
                }
                if(k==true) {
                    ramki[puste] = temp;
                    licznik++;
                    puste++;
                }
            }
            else{
                for(int j=0; j<wielkośćRamki; j++) {
                    if (temp.getNumer() == ramki[j].getNumer()) {
                        k = false;
                        break;
                    }
                }
                if(k==true) {
                    int id=0;
                    int n=0;
                    int ind=i-1;
                    for(int j=0; j<wielkośćRamki; j++) {
                        pom[j] = 0;
                    }
                    while (n <= wielkośćRamki) {
                            for (int p = 0; p < wielkośćRamki; p++) {
                                if (tab[ind].getNumer() == ramki[p].getNumer()) {
                                    pom[p] = pom[p] + 1;
                                    if (pom[p] == 1) {
                                        n++;
                                    }
                                    break;
                                }
                            }
                            ind = ind - 1;
                            if(ind<0){
                                break;
                            }
                        }

                        id = 0;
                        int minimum = 100000;
                        for (int j = 0; j < wielkośćRamki; j++) {
                            if (pom[j] < minimum) {
                                minimum = pom[j];
                                id = j;
                            }
                        }
                    ramki[id] = temp;
                    licznik++;
                }
            }
            for(int p=0; p<wielkośćRamki; p++){
                pokaz[i][p]=ramki[p];
            }
        }
        return licznik;
    }

    public int LRUap(){
        licznik=0;
        puste=0;
        tab = new Strona[strony.length];
        for(int i=0; i<strony.length; i++){
            tab[i] = strony[i];
        }

        for(int i=0; i<ramki.length; i++){
            ramki[i] = null;
        }

        Strona temp;
        boolean k;
        boolean n;
        for(int i=0; i< tab.length; i++){
            temp = tab[i];
            k=true;
            n=false;
            if(puste <wielkośćRamki){
                for(int j=0; j<puste; j++){
                    ramki[j].setJakdawno(1);
                    if(temp.getNumer()==ramki[j].getNumer()){
                        k=false;
                        break;
                    }
                }
                if(k==true) {
                    ramki[puste] = temp;
                    licznik++;
                    puste++;
                }
            }
            else {
                for(int j=0; j<wielkośćRamki; j++) {
                    if (temp.getNumer() == ramki[j].getNumer()) {
                        k = false;
                        ramki[j].setJakdawno(1);
                        break;
                    }
                }
                if(k==true) {
                    for(int j=0; j<wielkośćRamki; j++){
                        if(ramki[j].getJakdawno()==0){
                            ramki[j].setNumer(temp.getNumer());
                            ramki[j].setJakdawno(1);
                            licznik++;
                            n=true;
                            break;
                        }
                        else{
                            ramki[j].setJakdawno(0);
                        }
                    }
                    if(n==false){
                        licznik++;
                        ramki[0].setNumer(temp.getNumer());
                        ramki[0].setJakdawno(1);

                    }
                }

            }
        }

        return licznik;
    }

    public int Optymalny(){
        licznik=0;
        puste=0;
        for(int i=0; i<strony.length; i++){
            tab[i] = strony[i];
        }

        for(int i=0; i<ramki.length; i++){
            ramki[i] = null;
        }
        Strona temp;
        int temp2;
        boolean k=true;
        int m=0;
        for(int i=0; i< tab.length; i++){
            temp = tab[i];
            k=true;
            if(puste <wielkośćRamki){
                for(int j=0; j<puste; j++){
                    if(temp.getNumer()==ramki[j].getNumer()){
                        k=false;
                        break;
                    }
                }
                if(k==true) {
                    ramki[puste] = temp;
                    ramki[puste].setJakdawno(1);
                    licznik++;
                    puste++;
                    m++;
                }
            }
            else{
                for(int j=0; j<wielkośćRamki; j++) {
                    if (temp.getNumer() == ramki[j].getNumer()) {
                        k = false;
                        break;
                    }
                }
                if(k==true) {
                    temp2 = szukaj(ramki, tab, i);
                    ramki[temp2] = temp;
                    licznik++;
                }
            }
            for(int p=0; p<wielkośćRamki; p++){
                pokaz[i][p]=ramki[p];
            }
        }
        return licznik;
    }

    public int szukaj(Strona ramki [], Strona tab [], int i){
        ArrayList <Strona> temp = new ArrayList<>();
        Strona o;
        for(int j=0; j< ramki.length; j++){
            o= ramki [j];
            temp.add(o);
        }
        for(int j=i; j<tab.length; j++){
            for(int k=0; k<temp.size(); k++){
                if (temp.get(k).getNumer() == tab[j].getNumer()) {
                        temp.remove(k);
                    }
                }
                if(temp.size()==1){
                    for(int y=0; y<ramki.length; y++){
                        if(temp.get(0).getNumer()==ramki[y].getNumer()){
                            return y;
                        }
                    }
                }

            }
        return 0;

    }

    public void Pokaz(){
        System.out.print("S  ");
        for(int i=0; i<wielkośćRamki; i++){
            System.out.print("F"+i);
            System.out.print("  ");
        }
        System.out.println("");
        for(int i=0; i< tab.length; i++){
            System.out.print(tab[i].getNumer() + "   ");
            for(int j=0; j<wielkośćRamki; j++){
                if(pokaz[i][j] ==null){
                    System.out.print("   ");
                }
                else {
                    System.out.print(pokaz[i][j].getNumer() + "   ");
                }
            }
            System.out.println("");
        }
    }


}
