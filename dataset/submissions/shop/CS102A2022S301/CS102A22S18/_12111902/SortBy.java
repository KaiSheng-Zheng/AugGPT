
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public enum SortBy {
        PurchaseTime(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                        return 0;
                }
        }), Rating(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                        if (o1 instanceof Product&&o2 instanceof Product){

                                Product p1=(Product) o1;
                                Product p2=(Product) o2;

                                if (p1.getAvgRating()== p2.getAvgRating()){
                                        return Integer.compare(p1.getId(),p2.getId());
                                }else {
                                        return Float.compare(p1.getAvgRating(), p2.getAvgRating());
                                }

                        }

                        throw new RuntimeException();
                }

        }), Price(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                        if (o1 instanceof Product&&o2 instanceof Product){

                                Product p1=(Product) o1;
                                Product p2=(Product) o2;

                                if (p1.getPrice()== p2.getPrice()){
                                        return Integer.compare(p1.getId(),p2.getId());
                                }else {
                                        return Float.compare(p1.getPrice(), p2.getPrice());
                                }

                        }

                        throw new RuntimeException();
                }

        });

        private Comparator comparator;
        private ArrayList<Product> shoppingCart;

        SortBy(Comparator comparator) {

                this.comparator=comparator;

        }

        public void setShoppingCart(ArrayList<Product> shoppingCart) {
                this.shoppingCart = shoppingCart;
        }


        public void showShoppingCart() {
                Object [] products=shoppingCart.toArray();
                Arrays.sort(products,comparator);

                for (Object product : products) {
                        System.out.println(product);
                }

        }
}
