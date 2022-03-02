package SJF;

import Procesy.Proces;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Komparatory {
    public void Sortowanie(Proces [] pr){
        CzasCompare komp = new CzasCompare();
        Arrays.sort(pr,komp);
    }

    static class CzasCompare implements Comparator<Proces> {
        public int compare(Proces o1, Proces o2) {
            if (o1.getDlugosc() > o2.getDlugosc()) return 1;
            else
                return -1;
        }
    }
}
