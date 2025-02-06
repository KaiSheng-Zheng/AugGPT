import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
    private static int cnt;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<>();
    private float wallet;
    private ArrayList<Store> add=new ArrayList<>();
    private ArrayList<Product> buy=new ArrayList<>();



    public Customer(String name, float wallet){
        cnt++;
        this.id=cnt;
        this.name=name;
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product,int rating){
        if(rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else{
            return false;
        }
    }

    public void updateWallet(float amount){
        wallet+=amount;
    }


    public boolean purchaseProduct(Store store, Product product) {
        if (store.getProductList().contains(product) && wallet >= product.getPrice()) {
            shoppingCart.add(product);
            wallet-= product.getPrice();
            store.transact(product,0);
            add.add(store);
            buy.add(product);
            return true;
    }else{
            return false;
        }
    }

    public void viewShoppingCart(SortBy sortMethod) {
        Product product;
        if (sortMethod == SortBy.PurchaseTime) {
            Iterator<Product> it = shoppingCart.iterator();
            while (it.hasNext()) {
                product = it.next();
                System.out.println(product.toString());
            }
        }
        if (sortMethod == SortBy.Rating) {
            Product[] rateArr = new Product[this.shoppingCart.size()];
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                rateArr[i] = this.shoppingCart.get(i);
            }
            for (int i = 0; i < rateArr.length - 1; i++) {
                for (int j = 0; j < rateArr.length - 1 - i; j++) {
                    if (rateArr[j].getAvgRating() > rateArr[j + 1].getAvgRating()) {
                        Product temp = rateArr[j];
                        rateArr[j] = rateArr[j + i];
                        rateArr[j + 1] = temp;
                    }
                    System.out.println(rateArr.toString());
                }
            }

        }
        if (sortMethod == SortBy.Price) {
            Product[] priceArr = new Product[this.shoppingCart.size()];
            for (int i = 0; i < this.shoppingCart.size(); i++) {
                priceArr[i] = this.shoppingCart.get(i);
            }
            for (int i = 0; i < priceArr.length - 1; i++) {
                for (int j = 0; j < priceArr.length - 1 - i; j++) {
                    if (priceArr[j].getPrice() > priceArr[j + 1].getPrice()) {
                        Product temp = priceArr[j];
                        priceArr[j] = priceArr[j + 1];
                        priceArr[j + 1] = temp;
                    }
                }
            }
            System.out.println(priceArr.toString());
        }






    }

    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            wallet+= product.getPrice();
            add.get(buy.indexOf(product)).transact(product,1);
            return true;
        } else {
            return false;
        }
    }


    }

