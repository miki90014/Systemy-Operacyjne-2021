public class Test {
    public static void main(String [] arg){
        Algorytmy so = new Algorytmy(100, 500, 60, 5, 600);
        System.out.println("Przydzial rowny");
        so.PrzydzialRowny();
        System.out.println("Przydzial proporcjonalny");
        so.PrzydzialProporcjonalny();
        System.out.println("Sterowanie Czestoscia Strony");
        so.SterowanieCzestosciaStrony(2,5);
        System.out.println("Model Strefowy");
        so.ModelStrefowy(600);
    }
}
