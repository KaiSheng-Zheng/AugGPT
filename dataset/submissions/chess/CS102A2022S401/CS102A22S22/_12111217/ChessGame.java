import java.util.List;

    public interface ChessGame {
        abstract void loadChessGame(List<String> chessboard);
        abstract ChessColor getCurrentPlayer();
        abstract ChessComponent getChess(int x,int y);
        abstract String getChessboardGraph();
        public abstract String getCapturedChess(ChessColor player);
    }
