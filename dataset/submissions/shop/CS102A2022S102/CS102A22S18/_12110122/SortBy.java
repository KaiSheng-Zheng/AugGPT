import java.util.ArrayList;

public enum SortBy {
    PurchaseTime(1),
    Rating(2),
    Price(3);

    private final int s;

    private SortBy(int a){
        s = a;
    }

    public void sort (ArrayList<Product> c){
        switch (s){
            case 1:
                sortByTime(c);
                break;
            case 2:
                sortByRating(c);
                break;
            case 3:
                sortByPrice(c);
                break;
        }
    }

    private static void sortByTime(ArrayList<Product> a){
        for (Product p:a){
            System.out.println(p.toString());
        }
    }

    private static void sortByRating(ArrayList<Product> a){
        ArrayList<Product> b = new ArrayList<>(a);
        if (b.size() > 1){
            for (int i = 1;i < b.size();i++){
                int j = i;
                while (j >= 1 && judge1(b.get(j - 1), b.get(j))){
                    Product p = b.get(j);
                    b.remove(j);
                    b.add(j - 1,p);
                    j--;
                }
            }
        }
        for (Product p:b)
            System.out.println(p.toString());
    }

    private static void sortByPrice(ArrayList<Product> a){
        ArrayList<Product> b = new ArrayList<>(a);
        if (b.size() > 1){
            for (int i = 1;i < b.size();i++){
                int j = i;
                while (j >= 1&&judge2(b.get(j - 1), b.get(j))){
                    Product p = b.get(j);
                    b.remove(j);
                    b.add(j - 1,p);
                    j--;
                }
            }
        }
        for (Product p:b)
            System.out.println(p.toString());
    }

    public static boolean judge1(Product p1,Product p2){
        if (p1.getAvgRating() <= p2.getAvgRating()){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean judge2(Product p1,Product p2){
        return !(p1.getPrice() <= p2.getPrice());
    }


}
