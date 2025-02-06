import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source=new ChessboardPoint(0,0);
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame qiPan=null;

    public void setQiPan(ConcreteChessGame qiPan) {
        this.qiPan = qiPan;
    }

    public ConcreteChessGame getQiPan() {
        return qiPan;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    protected boolean virgin=true;

    public void desecrate(){
        virgin=false;
    }

    public ChessComponent(){
    }
    public ChessComponent(int x,int y){
        source.setX(x);
        source.setY(y);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        if(chessColor==ChessColor.WHITE){
            return String.valueOf((char) (name+32));
        }
        return String.valueOf(name);
    }
    public boolean valid(int dx,int dy){
        if (source.getX()+dx>7|source.getX()+dx<0){
            return false;
        }
        if (source.getY()+dy>7|source.getY()+dy<0){
            return false;
        }
        if (qiPan!=null){
            if (this.chessColor==qiPan.getChess(source.getX()+dx,source.getY()+dy).chessColor){
                return false;
            }
        }
        return true;
    }

}
