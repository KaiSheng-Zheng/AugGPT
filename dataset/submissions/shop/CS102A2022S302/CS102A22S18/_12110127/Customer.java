import java.util.ArrayList;
public class Customer {
    private static int cnt; // initialized to 0, and will increase by 1 when the constructor is called.
    private int id; // unique for each customer and the value is set to cnt.
    private String name;
    private ArrayList<Product> shoppingCart = new ArrayList<>(); // The list of purchased products default is empty.
    private float wallet;

    public Customer(String name, float wallet) {
        cnt++;
        this.name = name;
        this.wallet = wallet;
        this.id = cnt;
    }

    public boolean rateProduct(Product product, int rating) {
        if (product.setRating(rating)) {
            return true;
        } else return false;
    }

    public void updateWallet(float amount) {
        wallet += amount;
    }

    public boolean purchaseProduct(Store store, Product product) {
        if (store.hasProduct(product) && wallet >= product.getPrice()) {
            store.transact(product, 0);
            shoppingCart.add(product);
            updateWallet(-product.getPrice());
            return true;
        } else {
            return false;
        }
    }
    public void sortbypurchaseTime() {
        if (shoppingCart.size() != 0) {
            for (int i = 0; i < shoppingCart.size(); i++) {
                System.out.println(shoppingCart.get(i).toString());
            }
        }
    }
    public void sortbyPrice() {
        float graph[]=new float[shoppingCart.size()];
        float temp;int temp2;int time[]=new int[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) {
            time[i]=i+1;
        }
        for (int i = 0; i < shoppingCart.size(); i++) {
            graph[i]=shoppingCart.get(i).getPrice();
        }
        for (int i = 0; i < graph.length-1; i++) {
            for (int j = 0; j < graph.length-1-i; j++) {
                if (graph[j]>graph[j+1]){
                    temp=graph[j];
                    graph[j]=graph[j+1];
                    graph[j+1]=temp;
                    temp2=time[j];
                    time[j]=time[j+1];
                    time[j+1]=temp2;

                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (i <= graph.length - 1) {
                if (graph[i] != graph[i + 1]) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(j).getPrice() == graph[i]) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                }else {
                    if (time[i]<=time[i+1]){
                        for (int j = 0; j < shoppingCart.size(); j++) {
                            if (shoppingCart.get(j).getPrice()==graph[j]){
                                System.out.println(shoppingCart.get(j).toString());
                            }
                        }
                        for (int j = 0; j < shoppingCart.size(); j++) {
                            if (shoppingCart.get(j).getPrice()==graph[i+1]){
                                System.out.println(shoppingCart.get(j).toString());
                            }
                        }
                    }
                }
            }
        }
    }
    public void  sortbyRating() {
        float graph[] = new float[shoppingCart.size()];
        float temp;
        int temp2;
        int time[] = new int[shoppingCart.size()];
        for (int i = 0; i < shoppingCart.size(); i++) {
            time[i] = i + 1;
        }
        for (int i = 0; i < shoppingCart.size(); i++) {
            graph[i] = shoppingCart.get(i).getAvgRating();
        }
        for (int i = 0; i < graph.length - 1; i++) {
            for (int j = 0; j < graph.length - 1 - i; j++) {
                if (graph[j] > graph[j + 1]) {
                    temp = graph[j];
                    graph[j] = graph[j + 1];
                    graph[j + 1] = temp;
                    temp2 = time[j];
                    time[j] = time[j + 1];
                    time[j + 1] = temp2;

                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (i <= graph.length - 1) {
                if (graph[i] != graph[i + 1]) {
                    for (int j = 0; j < shoppingCart.size(); j++) {
                        if (shoppingCart.get(j).getAvgRating() == graph[i]) {
                            System.out.println(shoppingCart.get(j).toString());
                        }
                    }
                } else {
                    if (time[i] <= time[i + 1]) {
                        for (int j = 0; j < shoppingCart.size(); j++) {
                            if (shoppingCart.get(j).getAvgRating() == graph[j]) {
                                System.out.println(shoppingCart.get(j).toString());
                            }
                        }
                        for (int j = 0; j < shoppingCart.size(); j++) {
                            if (shoppingCart.get(j).getAvgRating() == graph[i + 1]) {
                                System.out.println(shoppingCart.get(j).toString());
                            }
                        }
                    }
                }
            }
        }
    }
    public void viewShoppingCart(SortBy sortMethod) {
        if (shoppingCart.size() != 0) {
            if (sortMethod.equals(SortBy.PurchaseTime)) {
                sortbypurchaseTime();
            }
            if (sortMethod.equals(SortBy.Price)) {
                sortbyPrice();
            }
            if (sortMethod.equals(SortBy.Rating)) {
                sortbyRating();
            }
        }
    }

    public boolean refundProduct(Product product) {
        if (shoppingCart.size() != 0) {
            if (shoppingCart.contains(product)) {
                wallet += product.getPrice();
                shoppingCart.remove(product);
                return true;
            }
        }
        return false;
    }
}