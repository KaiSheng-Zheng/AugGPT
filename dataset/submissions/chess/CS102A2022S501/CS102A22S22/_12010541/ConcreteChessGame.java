

import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint source = new ChessboardPoint(i, j);
                char name = chessboard.get(i).charAt(j);
                ChessColor color;
                if (65 <= (int)name && (int)name <= 90) {
                    color = ChessColor.BLACK;
                }else if (97 <= (int)name && (int)name <= 122) {
                    color = ChessColor.WHITE;
                }else {
                    color = ChessColor.NONE;
                }

                switch (name) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent('R', color, source);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent('r', color, source);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent('N', color, source);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent('n', color, source);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent('B', color, source);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent('b', color, source);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent('Q', color, source);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent('q', color, source);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent('K', color, source);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent('k', color, source);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent('P', color, source);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent('p', color, source);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent('_', color, source);
                        break;
                }

                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }

        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        }else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }else {
            currentPlayer = ChessColor.NONE;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                builder.append(String.valueOf(chessComponents[i][j].getName()));
            }
            builder.append("\n");
        }
        builder.deleteCharAt(builder.length()-1);
        //builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public String getCapturedChess(ChessColor player) {
        int[] count = new int[6];
        int[] contrast = new int[6];
        contrast[0] = 1;    // king
        contrast[1] = 1;    // queen
        contrast[2] = 2;    // rooks
        contrast[3] = 2;    // bishops
        contrast[4] = 2;    // knights
        contrast[5] = 8;    // pawns

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        count[0]++;
                    }else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        count[1]++;
                    }else if (chessComponents[i][j] instanceof RookChessComponent) {
                        count[2]++;
                    }else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        count[3]++;
                    }else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        count[4]++;
                    }else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        count[5]++;
                    }
                }
            }
        }

        String white = "kqrbnp";
        String black = "KQRBNP";
        String result = null;

        if (player == ChessColor.BLACK) {
            char[] name = black.toCharArray();
            result = fillIn(count, contrast, name);
        }else if (player == ChessColor.WHITE) {
            char[] name = white.toCharArray();
            result = fillIn(count, contrast, name);
        }
        return result;
    }

    public String fillIn(int[] count, int[] contrast, char[] name) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] < contrast[i]) {
                builder.append(name[i]);
                builder.append(" ");
                builder.append(contrast[i] - count[i]);
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMove = chess.canMoveTo();

        Collections.sort(canMove, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() < o2.getX()) {
                    return -1;
                }else if (o1.getX() > o2.getX()) {
                    return 1;
                }else {
                    if (o1.getY() < o2.getY()) {
                        return -1;
                    }else if (o1.getY() > o2.getY()) {
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }
        });
        return canMove;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent sourceChess = chessComponents[sourceX][sourceY];
        ChessComponent targetChess = chessComponents[targetX][targetY];
        boolean isSucceeded = false;

        if (sourceChess.getChessColor().equals(currentPlayer)) {
            List<ChessboardPoint> canMove = getCanMovePoints(sourceChess.getSource());
            for (int i = 0; i < canMove.size(); i++) {
//                if (canMove.get(i).equals(targetChess.getSource())) {
                if (canMove.get(i).getX() == targetChess.getSource().getX() && canMove.get(i).getY() == targetChess.getSource().getY()) {
                    sourceChess.setSource(targetX, targetY);
                    chessComponents[targetX][targetY] = sourceChess;

                    targetChess.setSource(sourceX, sourceY);
                    targetChess.setChessColor(ChessColor.NONE);
                    targetChess.setName('_');
                    chessComponents[sourceX][sourceY] = targetChess;
                    isSucceeded = true;
                }
            }

            currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    this.chessComponents[i][j].setChessComponents(chessComponents);
                }
            }
        }
        return isSucceeded;
    }
}
