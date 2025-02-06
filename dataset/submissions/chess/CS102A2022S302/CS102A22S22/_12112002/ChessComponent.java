import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {


    //should design
    private ChessboardPoint source;

    //FIXME: A PUBLIC VARIABLE OF CHESS BOARD

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessComponent[][] chessboard=new ChessComponent[8][8];
    ArrayList<ChessboardPoint> list= new ArrayList<ChessboardPoint>() {};

    //FIXME: NO new here, require current concrete chess game
    //ConcreteChessGame concreteChessGame = ;
            //=new ConcreteChessGame();


    private ChessColor chessColor;

    protected char name;

//FIXME: UPDATE CHESSBOARD
    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent[][]  a(ChessComponent[][] chessboard){

        if (chessboard.equals(null)){
            return new ChessComponent[8][8];
        }
        if (chessboard[0].length!=8){
            return new ChessComponent[8][8];
        }
        this.chessboard=chessboard;
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                this.chessboard[i][j]=chessboard[i][j];
//            }
//        }
        setChessboard(chessboard);
        return this.chessboard;
    }



//    protected ChessComponent[][] chessboard(){
//        //FIXME: initialize each time or not
//        ChessComponent[][] chessboard=new ChessComponent[8][8];
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                chessboard[i][j]=concreteChessGame.getChessComponents()[i][j];
//            }
//        }
//        return chessboard;
//    }
    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] chessboard) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessboard=chessboard;

    }
//FIXME:
    public boolean examine (int x,int y){
        //avoiding the null pointer
        if (x<0||x>7||y<0||y>7){
            return false;
        }
//        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
//        if (chessboard[x][y].getChessColor().equals(chessColor)){
//            return false;
//        }else {
//            list.add(chessboardPoint);
//            return true;
//        }
        ChessboardPoint point = new ChessboardPoint(x, y);
        if (chessboard[x][y].getChessColor().equals(ChessColor.NONE) ){
            list.add(point);
            return true;
        }else if (chessboard[x][y].getChessColor().equals(this.getChessColor())) {
            return false;
        } else if (!chessboard[x][y].getChessColor().equals(this.getChessColor())){
            list.add(point);
            return true;
        }else return false;
    }
//FIXME: GET IT FROM SUBCLASS BASICALLY NO CHANGES

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

    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }



}
