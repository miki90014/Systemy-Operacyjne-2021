import java.util.Random;

import static java.lang.Math.abs;

public class System  {
    Procesor [] procesory;

    public System(int ilosc){
        procesory = new Procesor[ilosc];
        for(int i=0; i<ilosc; i++) {
            this.procesory[i] = new Procesor();

        }
    }

    public void Strategia1(int czas, int prog, int z){
        int t=0;
        Random generator = new Random();
        int temp;
        int temp2;
        int ilosc_migracji=0;
        int ilosc_zapytan=0;
        while(t==czas){
            t++;
            temp=generator.nextInt()%10;
            if(temp%3==0) {
                Zadania x = new Zadania();
                temp = abs(generator.nextInt() % procesory.length);
                int ile = 0;
                boolean p = false;
                while (z == ile) {
                    ile++;
                    ilosc_zapytan++;
                    temp2 = abs(generator.nextInt() % procesory.length);
                    if (procesory[temp2].pamiec > prog) {
                        procesory[temp2].DodajProces(x);
                        p = true;
                        ilosc_migracji++;
                        break;
                    }
                }
                if (p == false) {
                    procesory[temp].DodajProces(x);
                }

            }
        }
        System.out.println("Ilosc zapytan: "+ilosc_zapytan);
        System.out.println("Ilosc migracji: "+ilosc_migracji);
        int srednia=0;
        for(int i=0; i<procesory.length; i++){
            srednia=srednia+procesory[i].pamiec;
        }
        System.out.println("Srednie obciazenie: "+(double)srednia/(double)procesory.length);

    }


}