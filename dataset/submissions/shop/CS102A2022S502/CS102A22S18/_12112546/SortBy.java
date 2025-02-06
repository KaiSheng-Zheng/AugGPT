import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public enum SortBy {
    PurchaseTime, Rating, Price;

    private float rates;
    private int price;

    public float getRates() {
        return rates;
    }

    public int getPrice() {
        return price;
    }


    public String PurchaseTime(){
        return toString();
    }

    public String Rating(){
        ArrayList<Float> rates = new ArrayList<>();
        rates.add(getRates());
        for (int i = 0; i < rates.size() - 1; i++) {
            for (int j = 0; j < rates.size() - i - 1; j++) {
                float a = rates.get(j);
                float b = rates.get(j + 1);
                float temp = 0;
                if (a > b){
                    b = rates.get(j);
                    temp = rates.get(j + 1);
                }
            }
        }

        String s = "";
        for (int i = 0; i < rates.size(); i++) {
            s = s.concat(toString()).concat("\r\n");
        }
        return s;
    }

    public String Price(){
        ArrayList<Float> prices = new ArrayList<>();
        prices.add(getRates());
        for (int i = 0; i < prices.size() - 1; i++) {
            for (int j = 0; j < prices.size() - i - 1; j++) {
                float a = prices.get(j);
                float b = prices.get(j + 1);
                float temp = 0;
                if (a > b){
                    b = prices.get(j);
                    temp = prices.get(j + 1);
                }
            }
        }

        String s = "";
        for (int i = 0; i < prices.size(); i++) {
            s = s.concat(toString()).concat("\r\n");
        }
        return s;
    }
}
