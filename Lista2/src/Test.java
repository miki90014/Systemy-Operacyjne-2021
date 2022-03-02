public class Test {
    public static void main(String [] arg){
        int MAX = 100;
        int glowica = MAX/2;
        int zamowienia [] = new int[30];
        zamowienia = Generator.LosowanieZamowien(MAX, zamowienia);

        int t1[]=new int[zamowienia.length];
        int t2[]=new int[zamowienia.length];
        int t3[]=new int[zamowienia.length];
        int t4[]=new int[zamowienia.length];
        int t5[]=new int[zamowienia.length];
        int t6[]=new int[zamowienia.length];

        for(int i=0; i<zamowienia.length; i++){
            System.out.print(zamowienia[i] + " ");
        }
        for(int i=0; i<zamowienia.length; i++){
            t1[i] = zamowienia[i];
        }
        for(int i=0; i<zamowienia.length; i++){
            t2[i] = zamowienia[i];
        }
        for(int i=0; i<zamowienia.length; i++){
            t3[i] = zamowienia[i];
        }
        for(int i=0; i<zamowienia.length; i++){
            t4[i] = zamowienia[i];
        }
        for(int i=0; i<zamowienia.length; i++){
            t5[i] = zamowienia[i];
        }
        for(int i=0; i<zamowienia.length; i++){
            t6[i] = zamowienia[i];
        }




        System.out.println("");
        System.out.println("");
        System.out.println("FCFS:");
        Algorytmy.FCFS(t1,glowica);

        glowica = MAX/2;
        System.out.println("");
        System.out.println("SSTF:");
        Algorytmy.SSTF(t2,glowica, MAX);

        glowica = MAX/2;
        System.out.println("");
        System.out.println("SCAN:");
        Algorytmy.SCAN(t3, glowica, MAX);

        glowica = MAX/2;
        System.out.println("");
        System.out.println("CSCAN:");
        Algorytmy.CSCAN(t4, glowica, MAX);

        glowica=MAX/2;
        System.out.println("");
        System.out.println("EDF:");
        Algorytmy.EDF2(t5, glowica, MAX);

        glowica=MAX/2;
        System.out.println("");
        System.out.println("FD-SCAN:");
        Algorytmy.FDSCAN(t6, glowica, MAX);



    }
}
