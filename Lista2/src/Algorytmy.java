import java.util.Arrays;

import static java.lang.Math.abs;

public class Algorytmy {
    public static void FCFS(int [] tab, int glowica){
        int licznik=0;
        for(int i=0; i<tab.length; i++){
            licznik= licznik + abs(glowica - tab[i]);
            glowica = tab[i];
            System.out.print(tab[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);

    }

    public static void SSTF(int [] tab, int glowica, int MAX){
        int licznik=0;
        int tem=0;
        int min=MAX;
        int minin = 0;
        int mininin = 0;
        for(int i=0; i<tab.length; i++){
            min=MAX;
            minin = 0;
            mininin = 0;
            for(int j=0; j<tab.length; j++){
                if(tab[j]!=MAX+1) {
                    tem = abs(glowica - tab[j]);
                    if (tem < min) {
                        min = tem;
                        minin = tab[j];
                        mininin = j;
                    }
                }
            }
            glowica = minin;
            licznik = licznik + min;
            System.out.print(minin + " ");
            tab[mininin] = MAX+1;
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);
    }

    public static void SCAN(int [] tab, int glowica, int MAX){
        int licznik =0;
        Arrays.sort(tab);
        int j=0;
        int k=0;
        for(int i=0; i<tab.length; i++){
            if(glowica<tab[i]){
                j=i-1;
                k=i;
                break;
            }
        }
        while(j!=0){
            System.out.print(tab[j]+" ");
            licznik = licznik+abs(glowica - tab[j]);
            glowica = tab[j];
            j--;
        }
        System.out.print(tab[j]+" ");
        licznik = licznik+abs(glowica - tab[j]);
        glowica = tab[j];
        licznik = licznik+abs(glowica - 0);
        glowica = 0;


        for(int i=k; i<tab.length; i++){
            System.out.print(tab[i]+" ");
            licznik = licznik+abs(glowica - tab[i]);
            glowica = tab[i];
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);
    }

    public static void CSCAN(int [] tab, int glowica, int MAX){
        int licznik =0;
        Arrays.sort(tab);
        int j=0;
        int k=0;
        for(int i=0; i<tab.length; i++){
            if(glowica<tab[i]){
                j=i;
                k=i-1;
                break;
            }
        }
        while(j<tab.length){
            System.out.print(tab[j]+" ");
            licznik = licznik+abs(glowica - tab[j]);
            glowica = tab[j];
            j++;
        }
        licznik = licznik+abs(glowica - 0);
        glowica = 0;
        for(int i=0; i<=k; i++){
            System.out.print(tab[i]+" ");
            licznik = licznik+abs(glowica - tab[i]);
            glowica = tab[i];
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);

    }

    public static void EDF(int [] tab, int glowica, int MAX){
        int licznik=0;
        int tem=0;
        int min=MAX;
        int k=0;
        int m=0;
        int los;
        int minin = 0;
        int mininin = 0;
        int tab1[] = new int[tab.length];
        int tab2[] = new int[tab.length];
        for(int i=0; i<tab1.length; i++){
            if(k<tab1.length){
                los = Generator.LosowanieIlosciZamoiwen();
                k=k+los;
                for(int j=0; j<=los; j++) {
                    if (m + j < tab.length) {
                        tab1[m + j] = tab[m + j];
                    }
                }
                m=m+los;

            }
            if(k>tab1.length){
                k=tab1.length;
            }
            min=MAX;
            minin = 0;
            mininin = 0;
            for(int j=0; j<k; j++){
                if(tab1[j]!=MAX+1) {
                    tem = abs(glowica - tab1[j]);
                    if (tem < min) {
                        min = tem;
                        minin = tab1[j];
                        mininin = j;
                    }
                }
            }
            glowica = minin;
            licznik = licznik + min;
            System.out.print(minin + " ");
            tab1[mininin] = MAX+1;
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);
    }

    public static void FDSCAN(int [] tab, int glowica, int MAX) {
        int licznik =0;
        int k=1;
        int tab1 [] = new int[tab.length];
        int los=0;
        int m=1;
        int ile=1;

        int tem=0;
        int min=MAX;
        int minin = 0;
        int mininin = 0;


        tab1[0]=tab[0];
        licznik = abs(glowica-tab[0]);
        glowica = tab[0];

        for(int i=1; i<tab1.length; i++){
            tab1[i]=MAX+1;
        }

        int o=MAX+1;


        while(ile<tab.length){
            while(o!=0){
                tem=0;
                min=MAX;
                minin = 0;
                mininin = 0;
                if(k<tab1.length){
                    los = Generator.LosowanieIlosciZamoiwen();
                    k=k+los;
                    for(int j=0; j<=los; j++) {
                        if (m + j < tab.length) {
                            tab1[m + j] = tab[m + j];
                        }
                    }
                    m=m+los;
                }
                if(k>tab1.length){
                    k=tab1.length;
                }
                for(int i=0; i<k; i++){
                    for(int j=0; j<k; j++){
                        if(tab1[j]<glowica){
                            if(tab1[j]!=MAX+1) {
                                tem = abs(glowica - tab1[j]);
                                if (tem < min) {
                                    min = tem;
                                    minin = tab1[j];
                                    mininin = j;
                                }
                            }
                        }
                    }
                }
                if(min==MAX){
                    o=0;
                }
                else{
                    glowica = minin;
                    licznik = licznik + min;
                    System.out.print(minin + " ");
                    tab1[mininin] = MAX+1;
                    ile++;
                }
            }
            licznik = licznik+abs(glowica - 0);
            glowica = 0;

            while(o!=MAX){
                tem=0;
                min=MAX;
                minin = 0;
                mininin = 0;
                if(k<tab1.length){
                    los = Generator.LosowanieIlosciZamoiwen();
                    k=k+los;
                    for(int j=0; j<=los; j++) {
                        if (m + j < tab.length) {
                            tab1[m + j] = tab[m + j];
                        }
                    }
                    m=m+los;
                }
                if(k>tab1.length){
                    k=tab1.length;
                }
                for(int i=0; i<k; i++){
                    for(int j=0; j<k; j++){
                        if(tab1[j]>glowica){
                            if(tab1[j]!=MAX+1) {
                                tem = abs(glowica - tab1[j]);
                                if (tem < min) {
                                    min = tem;
                                    minin = tab1[j];
                                    mininin = j;
                                }
                            }
                        }
                    }
                }
                if(min==MAX){
                    o=MAX;
                }
                else{
                    glowica = minin;
                    licznik = licznik + min;
                    System.out.print(minin + " ");
                    tab1[mininin] = MAX+1;
                    ile++;
                }
            }
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);
    }

    public static void EDF2(int [] tab, int glowica, int MAX){
        int licznik=0;
        int tem=0;
        int min=MAX;
        int k=0;
        int m=0;
        int los;
        int los2;
        int minin = 0;
        int mininin = 0;
        int minprio =0;
        int priorytetMAX = 5;
        int n=0;
        int tab1[] = new int[tab.length];
        int tab2[] = new int[tab.length];
        for(int i=0; i<tab1.length; i++){
            if(k<tab1.length){
                los = Generator.LosowanieIlosciZamoiwen();
                k=k+los;
                for(int j=0; j<=los; j++) {
                    if (m + j < tab.length) {
                        tab1[m + j] = tab[m + j];
                        los2 = Generator.LosowaniePriorytetu();
                        tab2[m+j] = los2;
                    }
                }
                m=m+los;

            }
            if(k>tab1.length){
                k=tab1.length;
            }
            min=MAX;
            minin = 0;
            mininin = 0;
            n=0;
            minprio=MAX;
            for(int j=0; j<k; j++){
                for(int b=0; b<k; b++) {
                    if (tab1[b] != MAX + 1) {
                        if (tab2[b] == n) {
                            tem = abs(glowica - tab1[b]);
                            if (tem < min && n <= minprio) {
                                min = tem;
                                minin = tab1[b];
                                mininin = b;
                                minprio = n;
                            }
                        }
                    }
                }
                if(n<priorytetMAX){
                    n++;
                }
                if(min!=MAX){
                    break;
                }
            }
            if(minprio!=MAX) {
                glowica = minin;
                licznik = licznik + min;
                System.out.print(minin + "p:" + minprio + " ");
                tab1[mininin] = MAX + 1;
            }
        }
        System.out.println(" ");
        System.out.println("Ilosc przejsc przez cylindry: " + licznik);
    }
}


