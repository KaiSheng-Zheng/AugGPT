import java.util.ArrayList;

public class Customer {
    private static int cnt ;
    private int id;
    private String name;
    private float wallet;
    private ArrayList<Integer> ratings;
    private ArrayList<Product> shoppingCart=new ArrayList<Product>();

    public Customer(String name, float wallet){
        cnt++;
        id=cnt;
        this.name=name;
        this.wallet=wallet;
    }
    public boolean rateProduct(Product product, int rating){
        return product.setRating(rating);
    }
    public void updateWallet(float amount){
        wallet+=amount;
    }
    private ArrayList<Store> storelist=new ArrayList<Store>();
    public boolean purchaseProduct(Store store, Product product){
        boolean result1=false;
        boolean result2=true;
        if(store.hasProduct(product)){
            if(wallet>= product.getPrice()){
                store.transact(product,0);
                shoppingCart.add(product);
                wallet-=product.getPrice();
                result1=true;
                for(int i=0;i<storelist.size();i++){
                    if(storelist.get(i).getId()==store.getId()){
                        result2=false;
                    }
                }
                if(result2){
                    storelist.add(store);
                }
            }
        }
        return result1;
    }
    public void viewShoppingCart(SortBy sortMethod){
        ArrayList<Product> shoppingCartX=new ArrayList<>(shoppingCart);
        switch (sortMethod) {
            case Price:
                for (int p = 0; p < shoppingCartX.size(); p++) {
                    for (int q = p + 1; q < shoppingCartX.size(); q++) {
                        if (shoppingCartX.get(q).getPrice() < shoppingCartX.get(p).getPrice()) {
                            Product productj = shoppingCartX.get(q);
                            Product producti = shoppingCartX.get(p);
                            shoppingCartX.set(p, productj);
                            shoppingCartX.set(q, producti);
                        }
                    }
                }
                for (int o = 0;o<shoppingCartX.size();o++){
                    System.out.println(shoppingCartX.get(o).toString());
                }
                break;
            case PurchaseTime:
                for (int y = 0;y<shoppingCartX.size();y++){
                    System.out.println(shoppingCartX.get(y).toString());
                }
                break;
            case Rating:
                for (int m = 0; m < shoppingCartX.size(); m++) {
                    for (int n = m + 1; n < shoppingCartX.size(); n++) {
                        if (shoppingCartX.get(m).getAvgRating() > shoppingCartX.get(n).getAvgRating()) {
                            Product productj = shoppingCartX.get(n);
                            Product producti = shoppingCartX.get(m);
                            shoppingCartX.set(m, productj);
                            shoppingCartX.set(n, producti);
                        }
                    }
                }
                for (int x = 0;x<shoppingCartX.size();x++){
                    System.out.println(shoppingCartX.get(x).toString());
                }
        }
    }
    public boolean refundProduct(Product product){
        boolean jiaran=false;int m=-1;int n=-1;
        for(int p=0;p<shoppingCart.size();p++){
            if(shoppingCart.get(p).getId()==product.getId()){
                jiaran=true;m=p;
            }
        }
        for(int q=0;q<storelist.size();q++){
            if(storelist.get(q).getId()==product.getStore()){
                n=q;
            }
        }
        if(jiaran){
            wallet+=shoppingCart.get(m).getPrice();
            shoppingCart.remove(m);
            storelist.get(n).addProduct(product);
            storelist.get(n).setIncome(product.getPrice());
        }
        return jiaran;
    }
}
