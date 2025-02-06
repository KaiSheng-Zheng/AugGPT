import java.util.Comparator;


public class Compare implements Comparator{


    public int compare(Object a, Object b) {

        float firstRating = ((Product) a).getAvgRating();
        float secondRating = ((Product) b).getAvgRating();

        float c = firstRating - secondRating;
        if (c > 0)
            return 1;
        else if (c < 0)
            return -1;
        else
            return 0;
    }
}

