import java.util.List;

public interface ChessGame {
    ChessColor currentPlayer = null;
    ChessComponent Chess = null;
    String ChessboardGraph = null;
    String CapturedChess = null;

   default void loadChessGame(List<String> chessboard) {
    }

    default ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    default ChessComponent getChess(int x, int y) {
        return Chess;
    }

    default String getChessboardGraph() {
        return ChessboardGraph;
    }

     default String getCapturedChess(ChessColor player) {
        return CapturedChess;
    }

    default boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    default List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }


}
