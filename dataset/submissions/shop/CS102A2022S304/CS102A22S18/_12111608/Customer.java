import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart;
    private float wallet;
    private ArrayList<Store> stores;

    public Customer(String name, float wallet) {
        cnt++;
        this.id=cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart=new ArrayList<>();
    }
    public boolean rateProduct(Product product, int rating){
        if(rating<=5&&rating>=1){product.setRating(rating);return true;}
        else{return false;}
    }
    public void updateWallet(float amount){
        this.wallet=this.wallet+amount;
    }
    public boolean purchaseProduct(Store store, Product product){
        if(store.hasProduct(product)&&(wallet>=product.getPrice())){
            wallet-=product.getPrice();
            shoppingCart.add(product);
            stores.add(store);
            return true;
            }return false;
        }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> newProducts =new ArrayList<>(shoppingCart);
        if(sortMethod.equals(SortBy.Price)) {
            for (int i = 0; i < newProducts.size(); i++) {
                for (int j = i; j+1 < newProducts.size(); j++) {
                    if (newProducts.get(i).getPrice() > newProducts.get(j + 1).getPrice()) {
                        Product temp = newProducts.get(i);
                        newProducts.set(i, newProducts.get(j + 1));
                        newProducts.set(j + 1, temp);
                    }
                }
            }
            outPrint(newProducts);
        }if(sortMethod.equals(SortBy.Rating)){
            for (int i = 0; i < newProducts.size(); i++) {
                for (int j = i; j+1 < newProducts.size(); j++) {
                    if (newProducts.get(i).getAvgRating() > newProducts.get(j + 1).getAvgRating()) {
                        Product temp = newProducts.get(i);
                        newProducts.set(i, newProducts.get(j + 1));
                        newProducts.set(j + 1, temp);
                    }
                }
            }outPrint(newProducts);
        }if(sortMethod.equals(SortBy.PurchaseTime)){
            outPrint(newProducts);
        }
    }
    public void outPrint( ArrayList<Product> newProductList){
        for(Product i:newProductList){
            System.out.println(i.toString());
        }
    }
    public boolean refundProduct(Product product){
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).equals(product)){
                shoppingCart.remove(product);
                wallet+=product.getPrice();
                stores.get(i).backIncome(product.getPrice());
                return true;
            }
        }
        return false;
    }
}
