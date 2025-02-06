public class LocalData {
private static ChessComponent[][] p;

    public static void setChess (int x, int y, ChessComponent p) {
        LocalData.p[x][y] = p;
    }

    public static ChessComponent getChess(int x, int y) {
        return p[x][y];
    }
}
