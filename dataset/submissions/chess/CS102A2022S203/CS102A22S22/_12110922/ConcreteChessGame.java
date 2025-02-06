import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        chessComponents = new ChessComponent[8][8];
        for (int i = 0; i < 8; i++) {
            String line = chessboard.get(i);
 
            for (int j = 0; j < 8; j++) {
                char ch = line.charAt(j);
                if (ch == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(
                            new ChessboardPoint(i, j));
                } else {
                    ChessColor color = Character.isUpperCase(ch)
                            ? ChessColor.BLACK
                            : ChessColor.WHITE;
                    ch = Character.toUpperCase(ch);
                    if (ch == 'R') {
                        chessComponents[i][j] = new RookChessComponent(
                                new ChessboardPoint(i, j), color);
                    } else if (ch == 'N') {
  
                        chessComponents[i][j] = new KnightChessComponent(
                                new ChessboardPoint(i, j), color);
                    } else if (ch == 'B') {
                        chessComponents[i][j] = new BishopChessComponent(
                                new ChessboardPoint(i, j), color);
                    } else if (ch == 'Q') {
                        chessComponents[i][j] = new QueenChessComponent(
                                new ChessboardPoint(i, j), color);
                    } else if (ch == 'K') {
                        chessComponents[i][j] = new KingChessComponent(
                                new ChessboardPoint(i, j), color);
                    } else if (ch == 'P') {
                        chessComponents[i][j] = new PawnChessComponent(
                                new ChessboardPoint(i, j), color);
                    }
                }
                
                chessComponents[i][j].setGame(this);
            }
        }

        String line = chessboard.get(8);
        if (line.charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        String graph = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph += chessComponents[i][j].toString();
            }
            graph += "\n";
        }
        return graph.trim();
    }

    public String getCapturedChess(ChessColor player) {
        int[] total = { 1, 1, 2, 2, 2, 8 };
        char[] names = { 'K', 'Q', 'R', 'B', 'N', 'P' };
        int[] current = { 0, 0, 0, 0, 0, 0 };

        if (player == ChessColor.WHITE) {
            for (int k = 0; k < total.length; k++) {
                names[k] = Character.toLowerCase(names[k]);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char name = chessComponents[i][j].getName();
                for (int k = 0; k < total.length; k++) {
                    if (name == names[k]) {
                        current[k]++;
                    }
                }
            }
        }

        String s = "";
        for (int k = 0; k < total.length; k++) {
            int n = total[k] - current[k];
            if (n > 0) {
                s += names[k] + " " + n + "\n";
            }
        }
        return s;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return chessComponents[source.getX()][source.getY()].canMoveTo();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX,
            int targetY) {
        if(chessComponents[sourceX][sourceY] instanceof EmptySlotComponent) {
            return false;
        }
        
        if(chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) {
            return false;
        }
        
        List<ChessboardPoint> points = getCanMovePoints(
                new ChessboardPoint(sourceX, sourceY));

        for (ChessboardPoint chessboardPoint : points) {
            if (chessboardPoint.getX() == targetX
                    && chessboardPoint.getY() == targetY) {
 
                ChessComponent temp = chessComponents[sourceX][sourceY];
                chessComponents[sourceX][sourceY] = chessComponents[targetX][targetY];
                chessComponents[targetX][targetY] = temp;
                
                if(currentPlayer == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                }else {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
    }

}