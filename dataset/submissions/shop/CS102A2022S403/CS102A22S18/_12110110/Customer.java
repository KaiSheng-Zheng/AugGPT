import java.util.*;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private float wallet;
    private HashMap<Product,Store> StoryForProduct = new HashMap<>();

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        shoppingCart=new ArrayList<>();
        this.wallet=wallet;
    }

    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product) && wallet>= product.getPrice()){
            store.transact(product,0);
            wallet -= product.getPrice();
            shoppingCart.add(product);
            StoryForProduct.put(product,store);
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        Product[] temp = shoppingCart.toArray(new Product[0]);
        switch (sortMethod){
            case PurchaseTime:
                for (Product x : shoppingCart){
                    System.out.println(x);
                }
                break;
            case Rating:
                Comparator<Product> temp1 = (a, b) -> Float.compare(a.getAvgRating(), b.getAvgRating());
                Arrays.sort(temp, temp1);
                for (Product x : temp){
                    System.out.println(x);
                }
                break;
            case Price:
                Comparator<Product> temp2 = (a, b) -> Float.compare(a.getPrice(), b.getPrice());
                Arrays.sort(temp, temp2);
                for (Product x : temp){
                    System.out.println(x);
                }
                break;
        }
    }
    public boolean refundProduct(Product product){
        for (Product x:shoppingCart){
            if (x.getId()==product.getId()){
                wallet+= product.getPrice();
                shoppingCart.remove(product);
                StoryForProduct.get(product).transact(product,1);
                StoryForProduct.remove(product);
                return true;
            }
        }
        return false;
    }


}
