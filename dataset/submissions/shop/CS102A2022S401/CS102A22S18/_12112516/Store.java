import java.util.ArrayList;

class Store {
    private static  int cnt = 0;
    private int id;
    private String name;
    private ArrayList<Product> productList = new ArrayList<>();
    private float income;




    public Store(String name, ArrayList<Product> productList, float income){
        this.name = name;
        this.income = income;
        this.productList.addAll(productList);
        cnt = cnt + 1;
        id = cnt;
    }

    public Store(String name){
        this(name, new ArrayList<>(), 0f);

    }




    public boolean hasProduct(Product product){
        boolean x = false;
        if(this.productList.isEmpty()){
            return false;
        }
        else{
            for (Product value : this.productList) {
                if (value.getId() == product.getId()) {
                    x = true;
                    break;
                }
            }
            return x;
        }
    }



    public boolean addProduct(Product product){
        if(this.hasProduct(product)){
            return false;
        }
        else{
            this.productList.add(product);
            return true;
        }
    }



    public boolean removeProduct(Product product){
        if(this.hasProduct(product)){
            this.productList.remove(product);
            return true;
        }else return false;
    }



    public ArrayList<Product> getProductList(){
        return productList;
    }


    public void transact(Product product, int method){
        switch (method){
            case 0 :
                this.income += product.getPrice();
                this.removeProduct(product);
                break;
            case 1 :
                this.income -= product.getPrice();
                this.addProduct(product);
                break;
        }
    }


    public int getId(){
        return id;
    }
}
