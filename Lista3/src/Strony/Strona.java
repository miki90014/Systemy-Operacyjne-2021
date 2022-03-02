package Strony;

public class Strona {
    int dlugosc;
    int numer;
    int jakdawno;

    public Strona(){
        this.numer=0;
        this.dlugosc=0;
        this.jakdawno=0;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public int getJakdawno() {
        return jakdawno;
    }

    public void setJakdawno(int jakdawno) {
        this.jakdawno = jakdawno;
    }
}
