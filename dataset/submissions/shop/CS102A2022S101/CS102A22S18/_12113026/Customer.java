import java.util.ArrayList;

public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id;  // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart; // The list of purchased products; default is empty.
    private ArrayList<Store> storeList; //storeList.get(i) is store where shoppingCart.get(i) was purchased
    private float wallet;

    public Customer(String name, float wallet) {
        this.id = ++cnt;
        this.name = name;
        this.wallet = wallet;
        this.shoppingCart = new ArrayList<>();
        this.storeList = new ArrayList<>();
    }

    public boolean rateProduct(Product product, int rating) {
        return product.setRating(rating);
    }

    public void updateWallet(float amount) {
        this.wallet += amount;
    }
    public boolean purchaseProduct(Store store, Product product) {
        if(!store.hasProduct(product) || product.getPrice() > wallet)
            return false;

        shoppingCart.add(product);
        storeList.add(store);
        this.updateWallet(-product.getPrice());
        store.transact(product, 0);
        return true;
    }

    public void viewShoppingCart(SortBy sortMethod){
        Product[] sortedArray = getSortedCart(sortMethod);
        for(Product p : sortedArray){
            System.out.println(p.toString());
        }
    }

    public boolean refundProduct(Product product) {
        if (!shoppingCart.contains(product))
            return false;

        int index = shoppingCart.indexOf(product);

        storeList.remove(index).transact(product, 1);
        shoppingCart.remove(index);

        this.updateWallet(product.getPrice());

        return true;
    }
    private Product[] getSortedCart(SortBy sortMethod){
        int size = shoppingCart.size();
        Product[] sortedArray = new Product[size];
        
        if(sortMethod == SortBy.PurchaseTime)
            return shoppingCart.toArray(sortedArray);

        float[] sortValues = new float[size];
        int[] sortTo = new int[size];

        switch (sortMethod){
            case Price:
                for(int i=0; i<size; i++)
                    sortValues[i] = shoppingCart.get(i).getPrice();
                break;
            case Rating:
                for(int i=0; i<size; i++)
                    sortValues[i] = shoppingCart.get(i).getAvgRating();
                break;
        }

        for(int i=0; i<size-1; i++){
            for(int j=i+1; j<size; j++){
                if(sortValues[i]>sortValues[j])
                    sortTo[i]++;
                else
                    sortTo[j]++;
            }
        }

        for(int i=0; i<size; i++){
            sortedArray[sortTo[i]] = shoppingCart.get(i);
        }
        return sortedArray;
    }
}
