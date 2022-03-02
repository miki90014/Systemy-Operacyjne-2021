package Proces;

public class Proces {
    String idProcesu;
    int czasPrzybycia;
    int dlugosc;
    int oczekiwanie;
    int kolejnosc;
    int ilezostalo;

    public Proces(String idProcesu, int dlugosc, int czasPrzybycia, int kolejnosc){
        this.idProcesu = idProcesu;
        this.dlugosc = dlugosc;
        this.czasPrzybycia = czasPrzybycia;
        this.kolejnosc = kolejnosc;

    }

    public void Dane(){
        System.out.println(getKolejnosc()+" "+getIdProcesu() + " "+getDlugosc()+" "+getCzasPrzybycia()+" "+getOczekiwanie());
    }

    public int getIlezostalo() {
        return ilezostalo;
    }

    public int getOczekiwanie() {
        return oczekiwanie;
    }

    public String getIdProcesu() {
        return idProcesu;
    }

    public int getCzasPrzybycia() {
        return czasPrzybycia;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public int getKolejnosc() {
        return kolejnosc;
    }

    public void setOczekiwanie(int oczekiwanie) {
        this.oczekiwanie = oczekiwanie;
    }

    public void setIdProcesu(String idProcesu) {
        this.idProcesu = idProcesu;
    }

    public void setCzasPrzybycia(int czasPrzybycia) {
        this.czasPrzybycia = czasPrzybycia;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public void setIlezostalo(int ilezostalo) {
        this.ilezostalo = ilezostalo;
    }

    public void setKolejnosc(int kolejnosc) {
        this.kolejnosc = kolejnosc;
    }
}
