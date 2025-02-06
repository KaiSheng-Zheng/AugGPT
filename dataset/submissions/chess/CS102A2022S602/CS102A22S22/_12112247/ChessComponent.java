import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessComponent[][] chessComponents;
    protected ChessboardPoint source=new ChessboardPoint(0,0);//?????????
    protected ChessColor chessColor=ChessColor.WHITE;//????
    protected char name;

    //should design
    /*public ChessComponent(ChessboardPoint source , ChessColor chessColor , char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }*/

    public ChessComponent(/*ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] chessComponents*/){
        /*this.source=source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;*/
    };
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(int x , int y){
        ChessboardPoint middle = new ChessboardPoint(x,y);
        source=middle;

    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name=name;
    }
    public char getName(){
        return name;
    }

    public ChessColor BlackOrWriteOrNone(char chess){
        if(chess=='R' || chess=='N' || chess=='B' || chess=='Q' || chess=='K' || chess=='P'){
            return ChessColor.BLACK;
        }else if(chess=='_'){
            return ChessColor.NONE;
        }
        return ChessColor.WHITE;
    }
    public ChessboardPoint canMoveToHelp(int dx,int dy){
        ChessboardPoint afterMove = source.offset(dx, dy);
        if(afterMove!=null && !BlackOrWriteOrNone(chessComponents[afterMove.getX()][afterMove.getY()].getName()).equals(chessColor)){
            return afterMove;//still in board and can't eat teammate
        }
            return null;

    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}
