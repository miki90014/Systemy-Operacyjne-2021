public class Proces {
    int nazwa;
    int iloscRamek;
    int zapotrzebowanie;
    int []odwolania;
    int bledy;

    public Proces(int odwolania){
        this.nazwa=0;
        this.iloscRamek=0;
        this.zapotrzebowanie=0;
        this.bledy=0;
        this.odwolania= new int[odwolania];
    }

    public int getIloscRamek() {
        return iloscRamek;
    }

    public int getNazwa() {
        return nazwa;
    }

    public int getBledy() {
        return bledy;
    }

    public int getZapotrzebowanie() {
        return zapotrzebowanie;
    }

    public void setBledy(int bledy) {
        this.bledy = bledy;
    }

    public void setIloscRamek(int iloscRamek) {
        this.iloscRamek = iloscRamek;
    }

    public void setNazwa(int nazwa) {
        this.nazwa = nazwa;
    }

    public void setZapotrzebowanie(int zapotrzebowanie) {
        this.zapotrzebowanie = zapotrzebowanie;
    }
}
