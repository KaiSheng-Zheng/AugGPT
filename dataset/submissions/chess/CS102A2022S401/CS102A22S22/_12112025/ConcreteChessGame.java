import java.util.ArrayList;
import java.util.List;

public abstract class ConcreteChessGame extends ChessComponent implements ChessGame {
    private ChessComponent KingChessComponent;
    private ChessComponent QueenChessComponent;
    private ChessComponent RookChessComponent;
    private ChessComponent BishopChessComponent;
    private ChessComponent KnightChessComponent;
    private ChessComponent PawnChessComponent;
    private ChessComponent EmptySlotComponent;

    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    @Override
    public String getChessboardGraph() {
        return getChessboardGraph();
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    public ConcreteChessGame(){}
    public void loadChessGame(List<String> chessboard){
        chessboard.set(0,"RNBQKBNR");
        chessboard.set(1,"PPPPPPPP");
        chessboard.set(2,"________");
        chessboard.set(3,"________");
        chessboard.set(4,"________");
        chessboard.set(5,"________");
        chessboard.set(6,"pppppppp");
        chessboard.set(7,"rnbqkbnr");
        chessboard.set(8,"w");
    }



    public String getCapturedChess(ChessColor player) {
        return getCapturedChess(player);
    }
    public ChessComponent getChess(int x, int y) {
        return getChess(x,y);
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (sourceX==targetX|sourceY==targetY){
            return true;
        }else return false;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }



}
