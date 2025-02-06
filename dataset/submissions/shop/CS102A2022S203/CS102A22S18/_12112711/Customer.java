import java.util.ArrayList;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>();
    private ArrayList<Store> arr = new ArrayList<>();
    private float wallet;

    public Customer(String name, float wallet){
        cnt++;
        id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }

    public void updateWallet(float amount){
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet >= product.getPrice()){
            shoppingCart.add(product);
            arr.add(store);
            wallet -= product.getPrice();
            store.removeProduct(product);
            store.transact(product,0);
            return true;
        }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod){
        switch (sortMethod){
            case PurchaseTime:
                for (Product product : shoppingCart) {
                    System.out.println(product.toString());
                }
                break;

            case Rating:
                ArrayList<Product> rating = new ArrayList<>(shoppingCart);
                 float[] array = new float[shoppingCart.size()];

                for (int i = 0; i < shoppingCart.size(); i++) {
                    array[i] = shoppingCart.get(i).getAvgRating();
                }

                for(int i = 0; i < array.length-1;i++) {
                    for (int j = 0; j < array.length - 1 - i; j++) {
                        if (array[j] > array[j + 1]) {
                            float temp0 = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp0;

                            Product temp1 = rating.get(j);
                            rating.set(j,rating.get(j+1));
                            rating.set(j+1,temp1);
                        }
                    }
                }
                for (Product product : rating) {
                    System.out.println(product.toString());
                }
                break;

            case Price:
                ArrayList<Product> price = new ArrayList<>(shoppingCart);
                float[] array1 = new float[shoppingCart.size()];

                for (int i = 0; i < shoppingCart.size(); i++) {
                    array1[i] = shoppingCart.get(i).getPrice();
                }

                for(int i = 0; i < array1.length-1;i++) {
                    for (int j = 0; j < array1.length - 1 - i; j++) {
                        if (array1[j] > array1[j + 1]) {
                            float temp0 = array1[j];
                            array1[j] = array1[j + 1];
                            array1[j + 1] = temp0;

                            Product temp1 = price.get(j);
                            price.set(j,price.get(j+1));
                            price.set(j+1,temp1);
                        }
                    }
                }
                for (Product product : price) {
                    System.out.println(product.toString());
                }
                break;
        }
    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            Store store = arr.get(shoppingCart.indexOf(product));
            store.transact(product,1);
            arr.remove(store);
            shoppingCart.remove(product);
            wallet += product.getPrice();
            return true;
        }else{
            return false;
        }
    }
}