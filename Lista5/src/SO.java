import java.util.HashSet;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class SO  {
    Procesor [] procesory;

    public SO(int ilosc){
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
        double [] sredniawt = new double[czas];
        while(t!=czas){
            t++;
            temp=generator.nextInt()%10;
            if(temp%3==0) {
                Zadania x = new Zadania();
                temp = abs(generator.nextInt() % procesory.length);
                int ile = 0;
                boolean p = false;
                while (z != ile) {
                    ile++;
                    ilosc_zapytan++;
                    temp2 = abs(generator.nextInt() % procesory.length);
                    if (procesory[temp2].pamiec < prog) {
                        procesory[temp2].DodajProces(x);
                        p = true;
                        ilosc_migracji++;
                        break;
                    }
                }
                if (p == false) {
                    if(x.wymagana_pamiec+procesory[temp].pamiec<100) {
                        procesory[temp].DodajProces(x);
                    }
                    else{
                        break;
                    }
                }

            }
            temp=generator.nextInt();
            if(temp%4==0){
                temp = abs(generator.nextInt() % procesory.length);
                procesory[temp].UsunProces();
            }
            sredniawt[t-1]=0;
            for(int i=0; i<procesory.length; i++){
                sredniawt[t-1] = sredniawt[t-1]+ (double)procesory[i].pamiec;
            }
            sredniawt[t-1] = sredniawt[t-1]/(double) procesory.length;
        }
        System.out.println("Ilosc zapytan: "+ilosc_zapytan);
        System.out.println("Ilosc migracji: "+ilosc_migracji);
        int srednia=0;
        double temp3;
        double temp4=0;
        double temp5=0;
        double temp6=0;
        for(int i=0; i<procesory.length; i++){
            srednia=srednia+procesory[i].pamiec;
        }
        temp3=(double)srednia/(double)procesory.length;
        System.out.println("Srednie obciazenie na zakonczenie startegii: "+temp3);
        for(int i=0; i<procesory.length; i++){
            temp4 = temp4 + abs(temp3 -(double)procesory[i].pamiec );
        }
        temp4 = temp4/(double) procesory.length;
        System.out.println("Srednie odchylenie dla powyzszej sredniej: "+temp4);
        for(int i=0; i<czas; i++){
            temp5 = temp5+sredniawt[i];
        }
        temp5 = temp5/(double)czas;
        System.out.println("Srednie obciazenie: "+temp5);
        for(int i=0; i<czas; i++){
            temp6 = temp6+abs(temp5 -sredniawt[i]);
        }
        temp6=temp6/(double) czas;
        System.out.println("Srednie odchylenie dla powyzszej sredniej: "+temp6);


    }

    public void Strategia2(int czas, int prog){
        int t=0;
        Random generator = new Random();
        int temp;
        int temp2;
        int ilosc_migracji=0;
        int ilosc_zapytan=0;
        HashSet<Integer> hash = new HashSet<>();
        double [] sredniawt = new double[czas];
        while(t!=czas){
            t++;
            temp=generator.nextInt()%10;
            if(temp%3==0) {
                Zadania x = new Zadania();
                temp = abs(generator.nextInt() % procesory.length);
                if(procesory[temp].pamiec>prog){
                    hash = new HashSet<>();
                    while(true){
                        temp2 = abs(generator.nextInt() % procesory.length);
                        hash.add(temp2);
                        ilosc_zapytan++;
                        if(procesory[temp2].pamiec<prog){
                            procesory[temp2].DodajProces(x);
                            ilosc_migracji++;
                            break;
                        }
                        if(hash.size()==procesory.length-1){
                            break;
                        }
                    }
                }
                else{
                    procesory[temp].DodajProces(x);
                }

            }
            temp=generator.nextInt();
            if(temp%4==0){
                temp = abs(generator.nextInt() % procesory.length);
                procesory[temp].UsunProces();
            }
            sredniawt[t-1]=0;
            for(int i=0; i<procesory.length; i++){
                sredniawt[t-1] = sredniawt[t-1]+ (double)procesory[i].pamiec;
            }
            sredniawt[t-1] = sredniawt[t-1]/(double) procesory.length;
        }
        System.out.println("Ilosc zapytan: "+ilosc_zapytan);
        System.out.println("Ilosc migracji: "+ilosc_migracji);
        int srednia=0;
        double temp3;
        double temp4=0;
        double temp5=0;
        double temp6=0;
        for(int i=0; i<procesory.length; i++){
            srednia=srednia+procesory[i].pamiec;
        }
        temp3=(double)srednia/(double)procesory.length;
        System.out.println("Srednie obciazenie po zakonczeniu: "+temp3);
        for(int i=0; i<procesory.length; i++){
            temp4 = temp4 + abs(temp3 -(double)procesory[i].pamiec );
        }
        temp4 = temp4/(double) procesory.length;
        System.out.println("Srednie odchylenie dla powyzszej sredniej: "+temp4);
        for(int i=0; i<czas; i++){
            temp5 = temp5+sredniawt[i];
        }
        temp5 = temp5/(double)czas;
        System.out.println("Srednie obciazenie: "+temp5);
        for(int i=0; i<czas; i++){
            temp6 = temp6+abs(temp5 -sredniawt[i]);
        }
        temp6=temp6/(double) czas;
        System.out.println("Srednie odchylenie dla powyzszej sredniej: "+temp6);
    }
    public void Strategia3(int czas, int prog, int progr, double ileProcent){
        int t=0;
        Random generator = new Random();
        int temp;
        int temp2;
        int ilosc_migracji=0;
        int ilosc_zapytan=0;
        HashSet<Integer> hash = new HashSet<>();
        double [] sredniawt = new double[czas];
        while(t!=czas){
            t++;
            temp=generator.nextInt()%10;
            if(temp%3==0) {
                Zadania x = new Zadania();
                temp = abs(generator.nextInt() % procesory.length);
                if(procesory[temp].pamiec>prog){
                    hash = new HashSet<>();
                    while(true){
                        temp2 = abs(generator.nextInt() % procesory.length);
                        hash.add(temp2);
                        ilosc_zapytan++;
                        if(procesory[temp2].pamiec<prog){
                            procesory[temp2].DodajProces(x);
                            ilosc_migracji++;
                            break;
                        }
                        if(hash.size()==procesory.length-1){
                            break;
                        }
                    }
                }
                else{
                    procesory[temp].DodajProces(x);
                }

            }
            temp=generator.nextInt();
            if(temp%4==0){
                temp = abs(generator.nextInt() % procesory.length);
                procesory[temp].UsunProces();
            }
            for(int i=0; i<procesory.length; i++){
                if(procesory[i].pamiec<progr){
                    hash = new HashSet<>();
                    while(true){
                        temp2 = abs(generator.nextInt() % procesory.length);
                        hash.add(temp2);
                        ilosc_zapytan++;
                        if(procesory[temp2].pamiec>prog){
                            double ile = (double)procesory[temp2].procesy.size()*ileProcent;
                            int ile2 = (int) ile;
                            while(ile2!=0){
                                ile2--;
                                procesory[i].DodajProces(procesory[temp2].getZadanie());
                                procesory[temp2].UsunProces();
                                ilosc_migracji++;
                            }
                            break;
                        }
                        if(hash.size()==procesory.length-1){
                            break;
                        }
                    }
                }
            }
            sredniawt[t-1]=0;
            for(int i=0; i<procesory.length; i++){
                sredniawt[t-1] = sredniawt[t-1]+ (double)procesory[i].pamiec;
            }
            sredniawt[t-1] = sredniawt[t-1]/(double) procesory.length;
        }
        System.out.println("Ilosc zapytan: "+ilosc_zapytan);
        System.out.println("Ilosc migracji: "+ilosc_migracji);
        int srednia=0;
        double temp3;
        double temp4=0;
        double temp5=0;
        double temp6=0;
        for(int i=0; i<procesory.length; i++){
            srednia=srednia+procesory[i].pamiec;
        }
        temp3=(double)srednia/(double)procesory.length;
        System.out.println("Srednie obciazenie po zakonczeniu: "+temp3);
        for(int i=0; i<procesory.length; i++){
            temp4 = temp4 + abs(temp3 -(double)procesory[i].pamiec );
        }
        temp4 = temp4/(double) procesory.length;
        System.out.println("Srednie odchylenie dla powyzszej sredniej: "+temp4);
        for(int i=0; i<czas; i++){
            temp5 = temp5+sredniawt[i];
        }
        temp5 = temp5/(double)czas;
        System.out.println("Srednie obciazenie: "+temp5);
        for(int i=0; i<czas; i++){
            temp6 = temp6+abs(temp5 -sredniawt[i]);
        }
        temp6=temp6/(double) czas;
        System.out.println("Srednie odchylenie dla powyzszej sredniej: "+temp6);

    }


}