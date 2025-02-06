import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        char p;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                p = chessboard.get(i).charAt(j);
                ChessboardPoint c = new ChessboardPoint(i, j);
                chessComponents[i][j] = p == '_' ? new EmptySlotComponent(c, p, chessComponents) : p == 'p' || p == 'P' ? new PawnChessComponent(c, p, chessComponents) : p == 'Q' || p == 'q' ? new QueenChessComponent(c, p, chessComponents) : p == 'K' || p == 'k' ? new KingChessComponent(c, p, chessComponents) : p == 'R' || p == 'r' ? new RookChessComponent(c, p, chessComponents) : p == 'B' || p == 'b' ? new BishopChessComponent(c, p, chessComponents) : new KnightChessComponent(c, p, chessComponents);
            }
        }
        currentPlayer = chessboard.get(8).equals("w") ? ChessColor.WHITE : ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder SB = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                SB.append(chessComponents[i][j].toString());
            }
            ans.append(SB.toString());
            ans.append("\n");
            SB = new StringBuilder();
        }
        return ans.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        StringBuilder SB = new StringBuilder();
        if (player == ChessColor.WHITE) {
            map.put("k", 1);
            map.put("q", 1);
            map.put("r", 2);
            map.put("b", 2);
            map.put("n", 2);
            map.put("p", 8);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String s = chessComponents[i][j].toString();
                    if (map.containsKey(s)) {
                        map.replace(s, map.get(s) - 1);
                    }
                }
            }
        } else {
            map.put("K", 1);
            map.put("Q", 1);
            map.put("R", 2);
            map.put("B", 2);
            map.put("N", 2);
            map.put("P", 8);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String s = chessComponents[i][j].toString();
                    if (map.containsKey(s)) {
                        map.replace(s, map.get(s) - 1);
                    }
                }
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            int value = map.get(key);
            if (value != 0) {
                SB.append(key);
                SB.append(" ");
                SB.append(value);
                SB.append("\n");
            }
        }
        return SB.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent master = chessComponents[source.getX()][source.getY()];
//        String log = getChessboardGraph();
        List<ChessboardPoint> canMovePoints = master.canMoveTo();
        Comparator<ChessboardPoint> c = new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() > o2.getY()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };
        canMovePoints.sort(c);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint from = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint to = new ChessboardPoint(targetX, targetY);
        ChessComponent cc = chessComponents[sourceX][sourceY];
        if (getCanMovePoints(from).contains(to) && cc.getSide() != ChessColor.NONE && currentPlayer == cc.getSide()) {
            chessComponents[targetX][targetY] = cc;
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(from, '_', chessComponents);
            currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
            cc.moveTo(to);
            return true;
        } else {
            return false;
        }
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}
