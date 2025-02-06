import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents ;
    private ChessColor currentPlayer ;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8] ;
        this.currentPlayer = ChessColor.WHITE ;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i=0 ; i<8 ; i++){
            for (int j=0  ; j<8 ; j++){
                this.chessComponents[i][j] = new EmptySlotComponent();
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }
    }
    public ChessColor getCurrentPlayer(){
        return this.currentPlayer ;
    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public String getChessboardGraph() { //??????????????????????????????????????
        String str = "" ;
        for (int i=0 ; i<8 ; i++){
            for (int j=0  ; j<8 ; j++){
                str = chessComponents[i][j].toString() + "\n" ;
            }
        }
        return str;
    }

    public String getCapturedChess(ChessColor player) { //??????????????????????????????????????????????
        // how to now the order?
        return null;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){ //??????????????????????

        return true ;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    /*public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) { //??????????????????
        // 1. find chess according to source HOW?
        // 2. on below statement :
        List<ChessboardPoint> canMovePoints = chess.canMoveTo() ;
        // 3. Sort canMovePoints by x - ascending order
        return canMovePoints;
    }
    */

}
