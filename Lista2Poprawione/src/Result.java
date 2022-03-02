import java.util.ArrayList;

public class Result {
    public Result(int how, int interval, ArrayList f )
    {
        ArrayList<Page> PageReferences = new ArrayList<>();
        for(int a = 0; a< how; a++)
        {
            int r =(int)(Math.random()*interval);
            PageReferences.add(new Page(r, true, 0));
        }
        for(int j = 0; j<f.size(); j++)
        {
            Algorytmy a = new Algorytmy((int)f.get(j),PageReferences);
            System.out.println("\nResults with frame size: " + (int)f.get(j));
            System.out.println("FIFO: " + a.FIFO() + " RANDOM: " + a.RANDOM()+ " LRU: " + a.LRU()+ " OPT: " + a.OPT()+ " LRU_APX: " + a.LRU_APX());


        }

    }
}
