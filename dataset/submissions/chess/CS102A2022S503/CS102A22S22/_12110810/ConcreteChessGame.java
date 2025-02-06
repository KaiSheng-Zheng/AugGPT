import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
             return null;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}
