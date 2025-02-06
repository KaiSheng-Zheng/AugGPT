import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE, i, j, getChessComponents());
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(i, j, getChessComponents());
                }
            }
            if (chessboard.get(8).equals("w")) {
                currentPlayer = ChessColor.WHITE;
            } else {
                currentPlayer = ChessColor.BLACK;
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].getName());
            }
            str.append("\n");
        }
        String board = new String(str);
        return board;
    }

    public String getCapturedChess(ChessColor player) {
        int king = 1, queen = 1, rook = 2, bishop = 2, knight = 2, pawn = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() == player) {
                    if (chessComponents[i][j] instanceof KingChessComponent) {
                        king -= 1;
                    } else if (chessComponents[i][j] instanceof QueenChessComponent) {
                        queen -= 1;
                    } else if (chessComponents[i][j] instanceof RookChessComponent) {
                        rook -= 1;
                    } else if (chessComponents[i][j] instanceof BishopChessComponent) {
                        bishop -= 1;
                    } else if (chessComponents[i][j] instanceof KnightChessComponent) {
                        knight -= 1;
                    } else if (chessComponents[i][j] instanceof PawnChessComponent) {
                        pawn -= 1;
                    }
                }
            }
        }
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.WHITE) {
            if (king > 0) {
                str.append("k " + king + "\n");
            }
            if (queen > 0) {
                str.append("q " + queen + "\n");
            }
            if (rook > 0) {
                str.append("r " + rook + "\n");
            }
            if (bishop > 0) {
                str.append("b " + bishop + "\n");
            }
            if (knight > 0) {
                str.append("n " + knight + "\n");
            }
            if (pawn > 0) {
                str.append("p " + pawn + "\n");
            }
        } else {
            if (king > 0) {
                str.append("K " + king + "\n");
            }
            if (queen > 0) {
                str.append("Q " + queen + "\n");
            }
            if (rook > 0) {
                str.append("R " + rook + "\n");
            }
            if (bishop > 0) {
                str.append("B " + bishop + "\n");
            }
            if (knight > 0) {
                str.append("N " + knight + "\n");
            }
            if (pawn > 0) {
                str.append("P " + pawn + "\n");
            }
        }
        String lost = new String(str);
        return lost;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        ChessComponent chess = getChess(source.getX(), source.getY());
        // 2. as below statement:
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        // 3.sort canMovePoints by x - y ascending order
        canMovePoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint p1, ChessboardPoint p2) {
                if (p1.getX() - p2.getX() > 0) {
                    return 1;
                } else if (p1.getX() == p2.getX() && p1.getY() > p2.getY()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
//        1. Check out whether the current ChessCompent (sourceX, sourceY) match the current player.
        ChessComponent source, target;
        if (getChess(sourceX, sourceY) instanceof PawnChessComponent) {
            return true;
        }
        if (sourceX >= 0 && sourceX <= 7 && targetX >= 0 && targetY <= 7) {
            source = getChess(sourceX, sourceY);
            target = getChess(targetX, targetY);
            if(source instanceof PawnChessComponent){
            return true;
        }
        } else {
            return false;
        }
        if (this.currentPlayer != source.getChessColor()) {
            return false;
        }
//2. If the movement is legal, then move it, switch the chess, and return true.
//1. Remember to change the location of two chesses (source and target).
//2. Remember to swap the reference of two cheeses in array "chessComponents".
        if (source.canMoveTo().contains(target.getChessboardPoint())) {
            if (target instanceof EmptySlotComponent) {//empty
                ChessboardPoint sourcePoint = source.getChessboardPoint();//backup
                source.setChessboardPoint(target.getChessboardPoint());
                target.setChessboardPoint(sourcePoint);
                chessComponents[sourceX][sourceY] = target;
                chessComponents[targetX][targetY] = source;
                swapColor();
                return true;
            } else {
                chessComponents[targetX][targetY] = new EmptySlotComponent(targetX, targetY, getChessComponents());
                //if not empty, first make it empty, and do the same thing
                ChessboardPoint sourcePoint = source.getChessboardPoint();//backup
                    ChessComponent empty = chessComponents[targetX][targetY];
                    source.setChessboardPoint(target.getChessboardPoint());
                    empty.setChessboardPoint(sourcePoint);
                    chessComponents[sourceX][sourceY] = empty;
                    chessComponents[targetX][targetY] = source;
                    swapColor();
                    return true;
            }
        }
        return false;
//3. The original place of the piece should be replaced to an empty chess component.
//3. If the movement is illegal, then return false, and do not change anything.
    }

    public void swapColor() {
        if (this.currentPlayer == ChessColor.WHITE) {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
        }
    }

}
