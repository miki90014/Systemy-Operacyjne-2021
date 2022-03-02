package Procesy;

public class Proces {
    private String numerProcesu;
    private int dlugosc;
    private int momentZgłoszenia;
    private int czasOczekiwania;


    public Proces(String numerProcesu, int dlugosc, int momentZgłoszenia){
        this.numerProcesu = numerProcesu;
        this.dlugosc = dlugosc;
        this.momentZgłoszenia = momentZgłoszenia;
    }

    public int getCzasOczekiwania() {
        return czasOczekiwania;
    }

    public void setCzasOczekiwania(int czasOczekiwania) {
        this.czasOczekiwania = czasOczekiwania;
    }

    public void setMomentZgłoszenia(int momentZgłoszenia) {
        this.momentZgłoszenia = momentZgłoszenia;
    }


    public int getDlugosc() {
        return dlugosc;
    }

    public void DanyProces(){
        System.out.println(numerProcesu + " " + dlugosc + " "+ czasOczekiwania + " " + momentZgłoszenia);
    }
}
