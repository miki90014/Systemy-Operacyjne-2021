import java.util.Random;

import static java.lang.Math.abs;

public class Generator {

    public static int [] LosowanieZamowien(int Max, int [] tab){

        Random generator = new Random();
        for(int i=0; i<tab.length; i++){
            tab[i] =abs(generator.nextInt()%Max);
        }
        return tab;
    }

    public static int LosowanieIlosciZamoiwen(){
        Random generator = new Random();
        int tab;
        tab = abs(generator.nextInt()%5);
        return tab;
    }

    public static int LosowaniePriorytetu(){
        Random generator = new Random();
        int tab;
        tab = abs(generator.nextInt()%5);
        return tab;
    }
}
