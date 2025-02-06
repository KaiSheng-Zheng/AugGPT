import java.util.List;

public interface ChessGame {
	abstract public void loadChessGame(List<String> chessboard);

	abstract public ChessColor getCurrentPlayer();

	abstract public ChessComponent getChess(int x, int y);

	abstract public String getChessboardGraph();

	abstract public String getCapturedChess(ChessColor player);

	abstract public List<ChessboardPoint> getCanMovePoints(ChessboardPoint p);

	abstract public boolean moveChess(int a, int b, int c, int d);
}
