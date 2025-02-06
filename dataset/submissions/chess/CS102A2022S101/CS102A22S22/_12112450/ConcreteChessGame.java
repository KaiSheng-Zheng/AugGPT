import java.util.List;

public abstract class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame (){
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public ChessComponent getChessComponents(int X, int Y) {
        return chessComponents[X][Y];
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                this.chessComponents[i][j] = new EmptySlotComponent();
                this.chessComponents[i][j].setChessboard(this.chessComponents);
            }
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {return this.currentPlayer;}
    @Override
    public String getChessboardGraph() {return null; }
    @Override
    public String getCapturedChess(ChessColor player){return null;}
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according source
        ChessComponent chess = this.getChessComponents(source.getX(),source.getY());
        //2. as below statement
        List <ChessboardPoint> canMovePoints = chess.canMoveTo();
        //3. sort canMovePoints by x=y ascending order
        return canMovePoints;
    }
    public ChessComponent getChess(int sourceX, int sourceY, int targetX, int targetY) {
        return chessComponents[targetX][targetY];}
    /*if(chess instanceof KingChessComponent)
            else if (chess instanceof QueenChessComponent)
            else if (chess instanceof RookChessComponent)

     */
}
