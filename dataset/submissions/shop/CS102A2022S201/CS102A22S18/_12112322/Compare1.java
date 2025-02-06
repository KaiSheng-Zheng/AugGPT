import java.util.Comparator;


public class Compare1 implements Comparator{


    public int compare(Object a, Object b) {

        float firstPrice=((Product) a).getPrice();
        float secondPrice=((Product) b).getPrice();

        float c = firstPrice-secondPrice;
        if (c > 0)
            return 1;
        else if (c < 0)
            return -1;
        else
            return 0;
    }
}
