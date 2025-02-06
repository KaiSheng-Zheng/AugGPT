
import java.util.List;
public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public ChessComponent() {
        this.chessComponents=new ChessComponent[8][8];
        this.chessColor=ChessColor.WHITE;
    }
    //should design
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j]=chessComponents[i][j];
            }
        }
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }


    // should design
    public boolean hasChess(int dx, int dy) {
        ChessboardPoint target = this.getSource().offset(dx, dy);
        if (target!=null) {
            if(chessComponents[target.getX()][target.getY()] instanceof EmptySlotComponent){
            return false;}
            else return true;
        } else return true;
    }

    public boolean hasDifferentChess(int dx, int dy) {
        ChessboardPoint target = this.getSource().offset(dx, dy);
        if (target != null&&this!=null) {
            if (this.hasChess(dx, dy) && Character.isUpperCase(name) != Character.isUpperCase(chessComponents[target.getX()][target.getY()].name)) {
                return true;}
            else return false;
        }else return false;
        }


    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public boolean canMove(ChessboardPoint target){
        List<ChessboardPoint> chessboardPoints=this.canMoveTo();
        for (ChessboardPoint chessboardPoint:chessboardPoints) {
            if(target.getX()==chessboardPoint.getX()&&target.getY()==chessboardPoint.getY()){
                return true;
            }
        }
        return false;
    }

}
