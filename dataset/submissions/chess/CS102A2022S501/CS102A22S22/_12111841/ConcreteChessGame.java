import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8 ; i ++){
            for (int j = 0; j < 8; j ++){
                char chess = chessboard.get(i).charAt(j);
                switch (chess) {
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                    case '_' -> chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                }
            }
        }
        for (int i = 0; i < 8 ; i ++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].chessboard = chessComponents;
            }
        }
        if (chessboard.get(8).equals("b")){
            this.currentPlayer = ChessColor.BLACK;
        }
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i ++){
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 8; j ++){
                line.append(chessComponents[i][j].name);
            }
            result.append(line).append("\n");
        }
        return result.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < 8; i ++){
            for (int j = 0; j < 8; j ++){
                char chess = chessComponents[i][j].name;
                if (player == ChessColor.WHITE && 'a' <= chess && 'z' >= chess){
                    if (map.containsKey(chess)) {
                        int n = map.get(chess);
                        map.replace(chess, n + 1);
                    } else {
                        map.put(chess, 1);
                    }
                }
                else if (player == ChessColor.BLACK && 'A' <= chess && 'Z' >= chess){
                    if (map.containsKey(chess)) {
                        int n = map.get(chess);
                        map.replace(chess, n + 1);
                    } else {
                        map.put(chess, 1);
                    }
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if (player == ChessColor.WHITE){
            if (!map.containsKey('k')){ result.append("k 1\n"); }
            if (!map.containsKey('q')){ result.append("q 1\n"); }
            if (!map.containsKey('r')){ result.append("r 2\n"); }
            else if (map.get('r') == 1) { result.append("r 1\n"); }
            if (!map.containsKey('b')){ result.append("b 2\n"); }
            else if (map.get('b') == 1) { result.append("b 1\n"); }
            if (!map.containsKey('n')){ result.append("n 2\n"); }
            else if (map.get('n') == 1) { result.append("n 1\n"); }
            if (!map.containsKey('p')){ result.append("p 8\n"); }
            else if (map.get('p') >= 1 && map.get('p') <= 7) {
                int num = 8 - map.get('p');
                result.append("p ").append(num).append("\n"); }
        }
        else if (player == ChessColor.BLACK){
            if (!map.containsKey('K')){ result.append("K 1\n"); }
            if (!map.containsKey('Q')){ result.append("Q 1\n"); }
            if (!map.containsKey('R')){ result.append("R 2\n"); }
            else if (map.get('R') == 1) { result.append("R 1\n"); }
            if (!map.containsKey('B')){ result.append("B 2\n"); }
            else if (map.get('B') == 1) { result.append("B 1\n"); }
            if (!map.containsKey('N')){ result.append("N 2\n"); }
            else if (map.get('N') == 1) { result.append("N 1\n"); }
            if (!map.containsKey('P')){ result.append("P 8\n"); }
            else if (map.get('P') >= 1 && map.get('P') <= 7) {
                int num = 8 - map.get('P');
                result.append("P ").append(num).append("\n"); }
        }
        return result.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(new PointsComparator());
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent source = chessComponents[sourceX][sourceY];
        List<ChessboardPoint> points = source.canMoveTo();
        if (source.getChessColor() != currentPlayer){ return false; }
        for (ChessboardPoint point : points) {
            if (point.getY() == targetY && point.getX() == targetX) {
                source.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY] = source;
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                return true;
            }
        }
        return false;
    }

}

class PointsComparator implements Comparator<ChessboardPoint>{
    @Override
    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
        int xCom = Integer.compare(o1.getX(), o2.getX());
        if (xCom != 0){
            return xCom;
        }
        return Integer.compare(o1.getY(), o2.getY());
    }

}
