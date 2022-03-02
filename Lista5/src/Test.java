public class Test {
    public static void main(String [] arg){
        SO system = new SO(70);
        System.out.println("STRATEGIA 1");
        system.Strategia1(3000, 60,1000);
        System.out.println("========================");
        System.out.println("STRATEGIA 2");
        system.Strategia2(3000, 60);
        System.out.println("========================");
        System.out.println("STRATEGIA 3");
        system.Strategia3(3000, 60,10,0.1);

    }
}
