import java.util.ArrayList;

public class Procesor {
    ArrayList<Zadania> procesy;
    int pamiec;

    public Procesor(){
        this.pamiec = 0;
        this.procesy = new ArrayList<>();
    }

    public void DodajProces(Zadania x){
        procesy.add(x);
        pamiec = pamiec+x.wymagana_pamiec;
    }
}