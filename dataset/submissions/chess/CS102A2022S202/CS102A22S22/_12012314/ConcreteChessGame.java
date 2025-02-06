import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)=='_') chessComponents[i][j] = new EmptyChessComponent();
                if (chessboard.get(i).charAt(j)=='K') chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='k') chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='Q') chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='q') chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='B') chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='b') chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='R') chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='r') chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='P') chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='p') chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE);
                if (chessboard.get(i).charAt(j)=='N') chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK);
                if (chessboard.get(i).charAt(j)=='n') chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE);
            }
        }
        if (chessboard.get(8).charAt(0) == 'w'){
            this.currentPlayer = ChessColor.WHITE;
        }
        else this.currentPlayer = ChessColor.BLACK;
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
        String a = "";
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                a = a + component.toString();
            }
            a = a + "\n";
        }
        return a;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String a = "";
        int K = 1, Q = 1, B = 2, N = 2, R = 2, P = 8;
        if (player == ChessColor.BLACK){
            for (ChessComponent[] chessComponent : chessComponents) {
                for (ChessComponent component : chessComponent) {
                    if (component.toString().equals("K")) K--;
                    if (component.toString().equals("Q")) Q--;
                    if (component.toString().equals("B")) B--;
                    if (component.toString().equals("N")) N--;
                    if (component.toString().equals("R")) R--;
                    if (component.toString().equals("P")) P--;
                }
            }
            if (K!=0) a = a + "K "+K+"\n";
            if (Q!=0) a = a + "Q "+Q+"\n";
            if (R!=0) a = a + "R "+R+"\n";
            if (B!=0) a = a + "B "+B+"\n";
            if (N!=0) a = a + "N "+N+"\n";
            if (P!=0) a = a + "P "+P+"\n";
        }
        else if (player == ChessColor.WHITE){
            for (ChessComponent[] chessComponent : chessComponents) {
                for (ChessComponent component : chessComponent) {
                    if (component.toString().equals("k")) K--;
                    if (component.toString().equals("q")) Q--;
                    if (component.toString().equals("b")) B--;
                    if (component.toString().equals("n")) N--;
                    if (component.toString().equals("r")) R--;
                    if (component.toString().equals("p")) P--;
                }
            }
            if (K!=0) a = a + "k "+K+"\n";
            if (Q!=0) a = a + "q "+Q+"\n";
            if (R!=0) a = a + "r "+R+"\n";
            if (B!=0) a = a + "b "+B+"\n";
            if (N!=0) a = a + "n "+N+"\n";
            if (P!=0) a = a + "p "+P+"\n";
        }
        return a;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint point = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint point1 = new ChessboardPoint(targetX,targetY);
        if (getCanMovePoints(point).contains(point1)){
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptyChessComponent();
            return true;
        }
        else return false;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }
}