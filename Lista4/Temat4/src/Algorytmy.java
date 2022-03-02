import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static java.lang.Math.abs;

public class Algorytmy {
    private Proces[] procesy;
    private int IloscDostepnychRamek;
    private int IloscOdwolan;
    public Algorytmy(int n, int IloscDostepnychRamek, int zakres, int promien, int iloscOdwolan){
        this.IloscDostepnychRamek =IloscDostepnychRamek;
        this.procesy = new Proces[n];
        this.IloscOdwolan = iloscOdwolan;

        Random generator = new Random();
        int temp=0;
        HashSet<Integer> hash;
        for(int i=0; i<procesy.length; i++) {
            temp=0;
            hash = new HashSet<>();
            procesy[i] = new Proces(iloscOdwolan);
            procesy[i].nazwa = i+1;
            procesy[i].odwolania[0] = abs(generator.nextInt()) % zakres;
            for (int j = 1; j < iloscOdwolan; j++) {
                int odwolanie = procesy[i].odwolania[j-1] - promien + generator.nextInt(1 + promien * 2);
                procesy[i].odwolania[j] = Math.max(0, Math.min(zakres, odwolanie));
            }
            //System.out.println("Proces "+procesy[i].nazwa+" "+"odwolania:");
            for(int j=0; j<iloscOdwolan; j++){
                hash.add(procesy[i].odwolania[j]);
                //System.out.print(procesy[i].odwolania[j]+" ");
            }
            /*System.out.println(" ");
            System.out.println(" ");*/
            temp = hash.size();
            procesy[i].zapotrzebowanie= temp;
        }
    }
    public void PrzydzialRowny(){
        int k=IloscDostepnychRamek /procesy.length;
        int bledy=0;
        for(int i=0; i<procesy.length; i++){
            procesy[i].bledy=0;
            procesy[i].iloscRamek=0;
        }

        for(int i=0; i<procesy.length; i++){
            procesy[i].iloscRamek = k;
            if(procesy[i].iloscRamek<procesy[i].zapotrzebowanie){
                procesy[i].bledy =  procesy[i].zapotrzebowanie  -procesy[i].iloscRamek;
                bledy = bledy+procesy[i].bledy;
            }
            else{
                procesy[i].bledy =0;
            }
            //System.out.println("Procesor "+procesy[i].nazwa + " zapotrzebowanie: "+procesy[i].zapotrzebowanie + " ilosc stron: "
                    //+procesy[i].iloscRamek + " bledy: "+procesy[i].bledy+"\n");
        }
        System.out.println("Ilosc bledow "+bledy);
    }
    public void PrzydzialProporcjonalny(){
        int S=0;
        int bledy =0 ;
        double temp;
        for(int i=0; i<procesy.length; i++){
            procesy[i].bledy=0;
            procesy[i].iloscRamek=0;
            S= S +procesy[i].zapotrzebowanie;
        }
        for(int i=0; i< procesy.length; i++){
            temp = ((double)procesy[i].zapotrzebowanie/(double)S);
            temp = temp *IloscDostepnychRamek;
            procesy[i].iloscRamek = (int) temp;
            if(procesy[i].iloscRamek<procesy[i].zapotrzebowanie){
                procesy[i].bledy =  procesy[i].zapotrzebowanie  -procesy[i].iloscRamek;
                bledy = bledy+procesy[i].bledy;
            }
            else{
                procesy[i].bledy =0;
            }
            //System.out.println("Procesor "+procesy[i].nazwa + " zapotrzebowanie: "+procesy[i].zapotrzebowanie + " ilosc stron: "
                    //+procesy[i].iloscRamek + " bledy: "+procesy[i].bledy+"\n");
        }
        System.out.println("Ilosc bledow "+bledy);
    }
    public void SterowanieCzestosciaStrony(int minimum, int maximum){
        int k=IloscDostepnychRamek /procesy.length;
        int bledy=0;
        int ZwolnioneRamki=0;
        int temp=0;
        for(int i=0; i<procesy.length; i++) {
            procesy[i].iloscRamek = k;
            if(procesy[i].iloscRamek<procesy[i].zapotrzebowanie){
                procesy[i].bledy =  procesy[i].zapotrzebowanie  -procesy[i].iloscRamek;
                bledy = bledy+procesy[i].bledy;
            }
            else{
                procesy[i].bledy =0;
            }
        }
        for(int i=0; i<procesy.length; i++){
            if(procesy[i].bledy<minimum){
                //System.out.print("Był: bledy: "+procesy[i].bledy+" ramki "+procesy[i].iloscRamek+"     ");
                temp = minimum-procesy[i].bledy;
                ZwolnioneRamki =ZwolnioneRamki+ temp;
                procesy[i].iloscRamek = procesy[i].iloscRamek - temp;
                if(procesy[i].iloscRamek<procesy[i].zapotrzebowanie){
                    procesy[i].bledy =  procesy[i].zapotrzebowanie  -procesy[i].iloscRamek;
                }
                else{
                    procesy[i].bledy =0;
                }
            }
            if(procesy[i].bledy>maximum){
                //System.out.print("Był: bledy: "+procesy[i].bledy+" ramki "+procesy[i].iloscRamek+"     ");
                if(ZwolnioneRamki>maximum){
                    temp = procesy[i].bledy;
                    ZwolnioneRamki=ZwolnioneRamki-maximum;
                    procesy[i].iloscRamek = procesy[i].iloscRamek + (temp-maximum);
                    if(procesy[i].iloscRamek<procesy[i].zapotrzebowanie){
                        procesy[i].bledy =  procesy[i].zapotrzebowanie  -procesy[i].iloscRamek;
                    }
                    else{
                        procesy[i].bledy =0;
                    }
                }
                else{
                    temp = procesy[i].bledy;
                    procesy[i].iloscRamek = procesy[i].iloscRamek + ZwolnioneRamki;
                    ZwolnioneRamki=0;
                    if(procesy[i].iloscRamek<procesy[i].zapotrzebowanie){
                        procesy[i].bledy =  procesy[i].zapotrzebowanie  -procesy[i].iloscRamek;
                    }
                    else{
                        procesy[i].bledy =0;
                    }
                }
            }
            bledy = bledy + procesy[i].bledy;
            //System.out.println("Procesor "+procesy[i].nazwa + " zapotrzebowanie: "+procesy[i].zapotrzebowanie + " ilosc stron: "
                    //+procesy[i].iloscRamek + " bledy: "+procesy[i].bledy+"\n");
        }
        System.out.println("Ilosc bledow "+bledy);
    }

    public void ModelStrefowy(int okno){
        int bledy =0 ;
        for(int i=0; i<procesy.length; i++){
            procesy[i].bledy=0;
            procesy[i].iloscRamek=0;
        }
        HashSet<Integer> hash;
        int temp=0;
        int uzyteRamki=0;
        int j=0;
        while(temp<IloscOdwolan) {
            uzyteRamki=IloscDostepnychRamek;
            for (int i = 0; i < procesy.length; i++) {
                hash = new HashSet<>();
                j=0;
                while(j<okno || temp+j!=IloscOdwolan){
                    hash.add(procesy[i].odwolania[j+temp]);
                    j++;
                }
                procesy[i].iloscRamek = hash.size();
                uzyteRamki = uzyteRamki-procesy[i].iloscRamek;
                if(uzyteRamki<0){
                    bledy=bledy+1;
                }
            }
            temp=temp+okno;
        }
        System.out.println("Ilosc bledow "+bledy);

    }

}
