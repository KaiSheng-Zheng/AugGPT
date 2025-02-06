public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return String.format("(%d,%d)",x,y);
    }

    public ChessboardPoint offset(int dx, int dy){
        int xx= this.getX()+dx;
        int yy=this.getY()+dy;
        if((xx>=0&xx<8)&(yy>=0&yy<8)) {
            return new ChessboardPoint(xx,yy);
        }else {
            return null;
        }
    }

    public boolean available(){
        boolean yes=true;
        for (int i = 0; i < 32; i++) {
            if(this.x== data.allChessComponent[i].getSource().getX()&this.y==data.allChessComponent[i].getSource().getY()){
                yes=false;
                break;
            }
        }
        return yes;
    }

    public ChessComponent mapping(){
        if(this.available()){
            return new EmptySlotComponent(new ChessboardPoint(x,y));
        }else {
            for (int i = 0; i < 32; i++) {
                if(this.x== data.allChessComponent[i].getSource().getX()&this.y==data.allChessComponent[i].getSource().getY()){
                    return data.allChessComponent[i];
                }
            }
        }
        return null;
    }
}