import java.util.List;

public interface ChessGame {
    public abstract ChessColor getCurrentPlayer();
    public abstract ChessComponent getChess(int x, int y);
    public abstract String getChessboardGraph();
    public abstract String getCapturedChess(ChessColor player);
    public abstract List<ChessboardPoint>canMoveTo();
    public abstract boolean moveChess(int sourceX,int sourceY,int targetX,int targetY);
    public abstract List<ChessboardPoint> getCanMovePoints(ChessboardPoint source);


}