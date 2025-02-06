
import java.util.List;
public interface ChessGame {
    void loadChessGame(List<String> chessboard);
    ChessColor getCurrentPlayer();
    ChessComponent getChess(int x, int y);
    String getChessboardGraph();
    public String getCapturedChess(ChessColor player);

}
