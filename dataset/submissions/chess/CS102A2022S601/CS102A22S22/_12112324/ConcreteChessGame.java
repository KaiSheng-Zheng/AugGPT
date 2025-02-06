import java.util.ArrayList;
import java.util.List;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard;
    public ConcreteChessGame(){
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'K' ->
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                    case 'Q' ->
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                    case 'R' ->
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                    case 'B' ->
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                    case 'N' ->
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                    case 'P' ->
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j));
                    case 'k' ->
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                    case 'q' ->
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                    case 'r' ->
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                    case 'b' ->
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                    case 'n' ->
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                    case 'p' ->
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessComponent(chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        this.chessboard.addAll(chessboard);
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }
    @Override
    public String getChessboardGraph() {
        String s = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", chessboard.get(0), chessboard.get(1),
                chessboard.get(2), chessboard.get(3), chessboard.get(4), chessboard.get(5), chessboard.get(6),
                chessboard.get(7));
        return s;
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        int k = 0, q = 0, r = 0, b = 0, n = 0, p = 0;
        ArrayList<String> str = new ArrayList<>();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    ChessComponent c = chessComponents[i][j];
                    if(c.getChessColor()==ChessColor.BLACK){
                        if(c instanceof KingChessComponent) k++;
                        else if(c instanceof QueenChessComponent) q++;
                        else if(c instanceof RookChessComponent) r++;
                        else if(c instanceof BishopChessComponent) b++;
                        else if(c instanceof KnightChessComponent) n++;
                        else if(c instanceof PawnChessComponent) p++;
                    }
                }
            }
            if (k != 1) str.add(String.format("K %d\n", 1 - k));
            if (q != 1) str.add(String.format("Q %d\n", 1 - q));
            if (r != 2) str.add(String.format("R %d\n", 2 - r));
            if (b != 2) str.add(String.format("B %d\n", 2 - b));
            if (n != 2) str.add(String.format("N %d\n", 2 - n));
            if (p != 8) str.add(String.format("P %d\n", 8 - p));
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    ChessComponent c = chessComponents[i][j];
                    if(c.getChessColor()==ChessColor.WHITE){
                        if(c instanceof KingChessComponent) k++;
                        else if(c instanceof QueenChessComponent) q++;
                        else if(c instanceof RookChessComponent) r++;
                        else if(c instanceof BishopChessComponent) b++;
                        else if(c instanceof KnightChessComponent) n++;
                        else if(c instanceof PawnChessComponent) p++;
                    }
                }
            }
            if (k != 1) str.add(String.format("k %d\n", 1 - k));
            if (q != 1) str.add(String.format("q %d\n", 1 - q));
            if (r != 2) str.add(String.format("r %d\n", 2 - r));
            if (b != 2) str.add(String.format("b %d\n", 2 - b));
            if (n != 2) str.add(String.format("n %d\n", 2 - n));
            if (p != 8) str.add(String.format("p %d\n", 8 - p));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : str) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int row = source.getX();
        int col = source.getY();
        return chessComponents[row][col].canMoveTo();
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getChessColor() == currentPlayer) {
            if(chessComponents[sourceX][sourceY].canMoveTo().size() > 0){
                for (int i = 0; i < chessComponents[sourceX][sourceY].canMoveTo().size(); i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setChessboardPoint(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY));
                    chessComponents[targetX][targetY].setChessComponent(chessComponents);
                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
            }
        }
        return false;
    }
}