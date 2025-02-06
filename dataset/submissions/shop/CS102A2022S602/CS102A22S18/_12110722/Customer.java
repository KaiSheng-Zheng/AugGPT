import java.util.ArrayList;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<Product>();// The list of purchased products; default is empty.
    private float wallet;
    private static int purchaseCnt;


    public Customer(String name, float wallet) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.wallet = wallet;
    }

    public void addToCart(Product product) {
        shoppingCart.add(product);
        purchaseCnt++;
        product.setPurchaseTime(purchaseCnt);
    }

    public float getWallet() {
        return wallet;
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product)) {
            if (getWallet() >= product.getPrice()) {
                store.transact(product, 0);
                product.setTag(store);
                //this will automatically sortby time.
                addToCart(product);
                updateWallet(- product.getPrice());
                purchaseCnt++;
                product.setPurchaseTime(purchaseCnt);


                return true;

            } else {
                return false;
            }
        } else {
            return false;
        }
    }



    public static void swap(ArrayList<Product> arrayList, int index1, int index2) {
        Product temp1 = arrayList.get(index2);
        arrayList.set(index2, arrayList.get(index1));
        arrayList.set(index1, temp1);
    }

    public void viewShoppingCart(SortBy sortMethod) {
        if(shoppingCart.size()==0){
            System.out.println("");
            return;
        }
        if(shoppingCart.size()==1){
            System.out.println(shoppingCart.get(0));
            return;
        }
        ArrayList<Product> temp0 = new ArrayList<>(shoppingCart.size()+1);
        if (sortMethod == SortBy.PurchaseTime) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
            return;
        }
        else if (sortMethod == SortBy.Price) {
            float price1 = 0;
            float price2 = 0;
            for (int i = 0; i < shoppingCart.size(); i++) {
                temp0.set(i, shoppingCart.get(i));
            }
            boolean check = true;
            for (int i = 0; i < shoppingCart.size(); i++) {
                check = true;
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    price1 = temp0.get(j).getPrice();
                    price2 = temp0.get(j + 1).getPrice();
                    if (price1 - price2 > 0.00000000000001) {
                        swap(temp0, j, (j + 1));
                        check = false;
                    }
                    if (price1 - price2 < 0.000000000000001 && price1 - price2 > - 0.00000000000001) {
                        if (temp0.get(j).getPurchaseTime() > temp0.get(j + 1).getPurchaseTime()) {
                            swap(temp0, j, j + 1);
                            check = false;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
            }
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(temp0.get(i).toString());
            }
            return;
        }
        else if (sortMethod == SortBy.Rating) {
            float rate1 = 0;
            float rate2 = 0;
            for (int i = 0; i < shoppingCart.size(); i++) {
                temp0.set(i, shoppingCart.get(i));
            }
            boolean check = true;
            for (int i = 1; i < shoppingCart.size(); i++) {
                check = true;
                for (int j = 0; j < shoppingCart.size() - i; j++) {
                    rate1 = temp0.get(j).getAvgRating();
                    rate2 = temp0.get(j + 1).getAvgRating();
                    if (rate1 - rate2 > 0.0000000000000001) {
                        swap(temp0, j, (j + 1));
                        check = false;
                    }
                    if (rate1 - rate2 < 0.000000000000001 && rate1 - rate2 > - 0.0000000000000000001) {
                        if (temp0.get(j).getPurchaseTime() > temp0.get(j + 1).getPurchaseTime()) {
                            swap(temp0, j, j + 1);
                            check = false;
                        }
                    }
                    if (check) {
                        break;
                    }
                }
            }
            return;
        }
    }

    public boolean refundProduct(Product product) {
        if(product.getTag()==null){
            return false;
        }
        if(shoppingCart.contains(product)){
            float price = product.getPrice();
            updateWallet(price);
            product.setPurchaseTime(0);
            shoppingCart.remove(product);
            product.getTag().transact(product,1);
            return true;
        }
        return false;
    }
}