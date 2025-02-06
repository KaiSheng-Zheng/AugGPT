import java.util.ArrayList;

public class Customer {
    private static int cnt=0;
    private int id;
    private String name;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();
    private float wallet;
    public Customer(String name, float wallet){
        this.name=name;
        this.wallet=wallet;
        cnt++;
        this.id=cnt;
    }
    public boolean rateProduct(Product product, int rating){
        if (rating>=1&&rating<=5){
            product.setRating(rating);
            return true;
        }else return false;
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if (store.hasProduct(product)&&wallet>= product.getPrice()){
            product.store=store;
            wallet-= product.getPrice();
            this.shoppingCart.add(product);
            store.removeProduct(product);
            store.setIncome(store.getIncome()+ product.getPrice());
            return true;
        }else return false;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product>  arrayList = shoppingCart;
        switch (sortMethod){
            case PurchaseTime:
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println(arrayList.get(i));
                }break;

            case Rating:
                arrayList.sort(new compareavgrating());
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println(arrayList.get(i));
                }break;

            case Price:
                arrayList.sort(new compareprice());
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.println(arrayList.get(i));
                }break;
        }

    }
    public boolean refundProduct(Product product){
        if (shoppingCart.contains(product)){
            shoppingCart.remove(product);
            updateWallet(product.getPrice());
            product.store.getProductList().add(product);
            product.store.setIncome(product.store.getIncome()- product.getPrice());
            return true;
        }else return false;
    }
}
