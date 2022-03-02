package Test;

import Algorytmy.Algorytmy;
import Strony.Strona;

import java.util.Random;

import static java.lang.Math.abs;

public class Main {
    public static void main(String arg[]){
        Strona [] st = new Strona [12];
        Strona [] st1 = new Strona [10000];
        int n;
        Random r = new Random();
        for(int i=0; i< st1.length; i++){
            n=abs(r.nextInt()%10);
            st1[i] = new Strona();
            st1[i].setNumer(n);
        }
        for(int i=0; i<st.length; i++){
            st[i] = new Strona();
        }
        st[0].setNumer(1);
        st[1].setNumer(2);
        st[2].setNumer(3);
        st[3].setNumer(4);
        st[4].setNumer(1);
        st[5].setNumer(2);
        st[6].setNumer(5);
        st[7].setNumer(1);
        st[8].setNumer(2);
        st[9].setNumer(3);
        st[10].setNumer(4);
        st[11].setNumer(5);
        System.out.println("Test dla małych liczb: ");
        System.out.println("=======Ilosc Ramek: "+3+"=============");
        Algorytmy m = new Algorytmy(3,st);
        System.out.println("Random: " +m.Random());
        System.out.println("FIFO: "+m.FIFO());
        System.out.println("LRU: "+m.LRU());
        System.out.println("Optymalny: "+m.Optymalny());
        System.out.println("LRU ap: "+m.LRUap());
        System.out.println("=======Ilosc Ramek: "+4+"=============");
        m = new Algorytmy(4,st);
        System.out.println("Random: " +m.Random());
        System.out.println("FIFO: "+m.FIFO());
        System.out.println("LRU: "+m.LRU());
        System.out.println("Optymalny: "+m.Optymalny());
        System.out.println("LRU ap: "+m.LRUap());
        int f1=3;
        int f2=4;
        int f3=10;
        System.out.println("=======Ilosc Ramek: "+f1+"=============");
        Algorytmy m1 = new Algorytmy(f1, st1);
        System.out.println("Random: " +m1.Random());
        System.out.println("FIFO: "+m1.FIFO());
        System.out.println("LRU: "+m1.LRU());
        System.out.println("LRU ap: "+m1.LRUap());
        System.out.println("Optymalny: "+m1.Optymalny());
        m1 = new Algorytmy(f2, st1);
        System.out.println("=======Ilosc Ramek: "+f2+"=============");
        System.out.println("Random: " +m1.Random());
        System.out.println("FIFO: "+m1.FIFO());
        System.out.println("LRU: "+m1.LRU());
        System.out.println("LRU ap: "+m1.LRUap());
        System.out.println("Optymalny: "+m1.Optymalny());
        m1 = new Algorytmy(f3, st1);
        System.out.println("=======Ilosc Ramek: "+f3+"=============");
        System.out.println("Random: " +m1.Random());
        System.out.println("FIFO: "+m1.FIFO());
        System.out.println("LRU: "+m1.LRU());
        System.out.println("LRU ap: "+m1.LRUap());
        System.out.println("Optymalny: "+m1.Optymalny());
        //m1.Show();*/
    }
}
