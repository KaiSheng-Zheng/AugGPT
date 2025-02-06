
import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            chessComponents[i] = new ChessComponent[8];
        }
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            String nowRow = chessboard.get(i);
            for (int j = 0; j < 8; j++) {
                char name = nowRow.charAt(j);
                if (name == 'r' || name == 'R') {
                    chessComponents[i][j] = new RookChessComponent(name, new ChessboardPoint(i, j));
                } else if (name == 'N' || name == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(name, new ChessboardPoint(i, j));
                } else if (name == 'B' || name == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(name, new ChessboardPoint(i, j));
                } else if (name == 'Q' || name == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(name, new ChessboardPoint(i, j));
                } else if (name == 'K' || name == 'k') {
                    chessComponents[i][j] = new KingChessComponent(name, new ChessboardPoint(i, j));
                } else if (name == 'P' || name == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(name, new ChessboardPoint(i, j));
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(name, new ChessboardPoint(i, j));
                }
            }
        }
        String currentPlayerColor = chessboard.get(8);
        if (currentPlayerColor.charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else if (currentPlayerColor.charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
        }
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
        StringBuilder graph = new StringBuilder(new String());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].getName());
            }
            if (i != 7) graph.append("\n");
        }
        return String.valueOf(graph);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        Character[] order = new Character[0];
        int[] origin = {1, 1, 2, 2, 2, 8};
        StringBuilder remains = new StringBuilder(new String());
        Map<Character, Integer> map = new HashMap<>();
        if (player == ChessColor.BLACK) {
            order = new Character[]{'K', 'Q', 'R', 'B', 'K', 'P'};
        } else if (player == ChessColor.WHITE) {
            order = new Character[]{'k', 'q', 'r', 'b', 'k', 'p'};
        }
        for (int i = 0; i < 6; i++) {
            map.put(order[i], origin[i]);
        }
        List<Character> Order = Arrays.asList(order);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessComponents[i][j].getName();
                if (Order.contains(name)) {
                    map.put(name, map.get(name) - 1);
                }
            }
        }
        for (char name : order) {
            if (map.get(name) != 0) {
                remains.append(name);
                remains.append(" ");
                remains.append(map.get(name));
                remains.append("\n");
            }
        }
        return String.valueOf(remains);
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> canMovePoints = getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        ChessboardPoint to = new ChessboardPoint(targetX, targetY);
        if(!canMovePoints.contains(to))
            return false;
        chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
        chessComponents[sourceX][sourceY] = new EmptySlotComponent('_',new ChessboardPoint(sourceX,sourceY));
        return true;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = chessComponents[x][y];
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                return o1.getX()-o1.getY() - (o2.getX() - o2.getY());
            }
        });
        return canMovePoints;
    }
}
