import java.util.ArrayList;


public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> forRefund = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }



    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet = wallet + amount;
    }



    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && product.getPrice() <= wallet) {
            wallet = wallet - product.getPrice();
            shoppingCart.add(product);
            forRefund.add(store);
            store.transact(product, 0);
            return true;
        } else {
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        ArrayList<Product> forSort1 = new ArrayList<>(shoppingCart);
        ArrayList<Product> forSort2 = new ArrayList<>(shoppingCart);
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            forSort1.sort((product1, product2) -> {
                float temp1=product1.getAvgRating();
                float temp2=product2.getAvgRating();
                return ((temp1-temp2)>=0)?1:-1;
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(forSort1.get(i).toString());
            }
        }
        if (sortMethod == SortBy.Price) {
            forSort2.sort((P1, P2) -> {
                float temp1=P1.getPrice();
                float temp2=P2.getPrice();
                return ((temp1-temp2)>=0)?1:-1;
            });
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(forSort2.get(i).toString());
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.contains(product)){
            if (forRefund.get(shoppingCart.indexOf(product)).hasProduct(product)) {
                forRefund.get(shoppingCart.indexOf(product)).transact(product, 1);
            }
            shoppingCart.remove(product);
            updateWallet(product.getPrice());

            return true;
        }else {
            return false;
        }
    }

    public ArrayList<Product> ratingSort(ArrayList<Product> forSort) {
        ArrayList<Product> bigChuCun = new ArrayList<>(forSort);
        for (int i = 0; i < forSort.size(); i++) {
            for (int j = 0; j < forSort.size(); j++) {
                if (forSort.get(j).getAvgRating() > forSort.get(i).getAvgRating()) {
                    Product chuCun = forSort.get(j);
                    forSort.add(j, forSort.get(j + 1));
                    forSort.add(j + 1, chuCun);
                }
            }
        }
        for (int i = 0; i < forSort.size(); i++) {
            for (int j = 0; j < forSort.size(); j++) {
                if (forSort.get(j).getAvgRating() == forSort.get(i).getAvgRating()) {
                    Product Temp1 = forSort.get(j);
                    Product Temp2 = forSort.get(i);
                    if (bigChuCun.indexOf(Temp1) < bigChuCun.indexOf(Temp2) && forSort.indexOf(Temp1) > forSort.indexOf(Temp2)) {
                        forSort.set(forSort.indexOf(Temp1), Temp2);
                        forSort.set(forSort.indexOf(Temp2), Temp1);
                    }
                    if (bigChuCun.indexOf(Temp1) > bigChuCun.indexOf(Temp2) && forSort.indexOf(Temp1) < forSort.indexOf(Temp2)) {
                        forSort.set(forSort.indexOf(Temp1), Temp2);
                        forSort.set(forSort.indexOf(Temp2), Temp1);
                    }
                }
            }
        }
        return forSort;
    }

    public ArrayList<Product> priceSort(ArrayList<Product> forSort) {
        ArrayList<Product> bigChuCun2 = new ArrayList<>(forSort);
        for (int i = 0; i < forSort.size(); i++) {
            for (int j = 0; j < forSort.size(); j++) {
                if (forSort.get(j).getPrice() > forSort.get(i).getPrice()) {
                    Product chuCun2 = forSort.get(j);
                    forSort.add(j, forSort.get(j + 1));
                    forSort.add(j + 1, chuCun2);
                }
            }
        }
        for (int i = 0; i < forSort.size(); i++) {
            for (int j = 0; j < forSort.size(); j++) {
                if (forSort.get(j).getPrice() == forSort.get(i).getPrice()) {
                    Product Temp1 = forSort.get(j);
                    Product Temp2 = forSort.get(i);
                    if (bigChuCun2.indexOf(Temp1) < bigChuCun2.indexOf(Temp2) && forSort.indexOf(Temp1) > forSort.indexOf(Temp2)) {
                        forSort.set(forSort.indexOf(Temp1), Temp2);
                        forSort.set(forSort.indexOf(Temp2), Temp1);
                    }
                    if (bigChuCun2.indexOf(Temp1) > bigChuCun2.indexOf(Temp2) && forSort.indexOf(Temp1) < forSort.indexOf(Temp2)) {
                        forSort.set(forSort.indexOf(Temp1), Temp2);
                        forSort.set(forSort.indexOf(Temp2), Temp1);
                    }
                }
            }
        }
        return forSort;
    }
}
