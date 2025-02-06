public enum Direction {
    UP(-1,0), DOWN(1,0), LEFT(0,-1), RIGHT(0,1);
    private int co;
    private int re;

    public int getCo() {
        return co;
    }

    public int getRe() {
        return re;
    }

    public void setCo(int co) {
        this.co = co;
    }

    public void setRe(int re) {
        this.re = re;
    }
    Direction(int re, int co){
        this.re=re;
        this.co=co;
    }
}