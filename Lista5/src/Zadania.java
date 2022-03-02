import java.util.Random;

import static java.lang.Math.abs;

public class Zadania {
    int wymagana_pamiec;
    public Zadania(){
        Random generator = new Random();
        this.wymagana_pamiec =abs(generator.nextInt()%10);
    }
}
