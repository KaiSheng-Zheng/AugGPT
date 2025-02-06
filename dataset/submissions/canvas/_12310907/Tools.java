public abstract class Tools {
    public static double findTheLength(int x1,int y1,int x2,int y2) {
        double rs = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
        return rs;
    }
    public static double findSlope(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return Double.POSITIVE_INFINITY;
        } else {
            return (double) (y2 - y1) / (x2 - x1);
        }
    }

}
