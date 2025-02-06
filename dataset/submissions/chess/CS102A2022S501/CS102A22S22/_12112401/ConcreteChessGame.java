
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint source = new ChessboardPoint(i, j);
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(source, ChessColor.BLACK, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(source, ChessColor.WHITE, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(source, ChessColor.BLACK, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(source, ChessColor.WHITE, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(source, ChessColor.BLACK, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(source, ChessColor.WHITE, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(source, ChessColor.BLACK, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(source, ChessColor.WHITE, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(source, ChessColor.BLACK, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(source, ChessColor.WHITE, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(source, ChessColor.BLACK, chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(source, ChessColor.WHITE, chessComponents);
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(source, ChessColor.NONE);
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
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
        String bd;
        StringBuilder cd = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cd.append(this.chessComponents[i][j].name);
            }
            cd.append("\n");
        }
        bd = String.valueOf(cd);
        return bd;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int King = 0;int Queen = 0;int Rook = 0;
        int Bishop = 0;int Knight = 0;int Pawn = 0;
        StringBuilder b = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        King++;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        Queen++;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        Rook++;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        Bishop++;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        Knight++;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        Pawn++;
                    }
                }
            }
            if (!(King == 1)) {
                b.append("K ").append(1 - King).append("\n");
            }
            if (!(Queen == 1)) {
                b.append("Q ").append(1 - Queen).append("\n");
            }
            if (!(Rook == 2)) {
                b.append("R ").append(2 - Rook).append("\n");
            }
            if (!(Bishop == 2)) {
                b.append("B ").append(2 - Bishop).append("\n");
            }
            if (!(Knight == 2)) {
                b.append("N ").append(2 - Knight).append("\n");
            }
            if (!(Pawn == 8)) {
                b.append("P ").append(8 - Pawn).append("\n");
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        King++;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        Queen++;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        Rook++;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        Bishop++;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        Knight++;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        Pawn++;
                    }
                }
            }
            if (!(King == 1)) {
                b.append("k ").append(1 - King).append("\n");
            }
            if (!(Queen == 1)) {
                b.append("q ").append(1 - Queen).append("\n");
            }
            if (!(Rook == 2)) {
                b.append("r ").append(2 - Rook).append("\n");
            }
            if (!(Bishop == 2)) {
                b.append("b ").append(2 - Bishop).append("\n");
            }
            if (!(Knight == 2)) {
                b.append("n ").append(2 - Knight).append("\n");
            }
            if (!(Pawn == 8)) {
                b.append("p ").append(8 - Pawn).append("\n");
            }
        }
        return String.valueOf(b);
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        for (int j = 0; j < getChess(source.getX(), source.getY()).canMoveTo().size(); j++) {
            canMovePoints.add(getChess(source.getX(), source.getY()).canMoveTo().get(j));
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint destination = new ChessboardPoint(targetX, targetY);
        boolean judge = false;
        for (int i = 0; i < getCanMovePoints(source).size(); i++) {
            if (getChess(sourceX, sourceY).getChessColor() == currentPlayer) {
                if (getCanMovePoints(source).get(i).getX() == destination.getX() && getCanMovePoints(destination).get(i).getY() == destination.getY()) {
                    swapLocation(sourceX, sourceY, targetX, targetY);
                    judge = true;
                }
            }
        }
        return judge;
    }

     public void swapLocation(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint lpl = new ChessboardPoint(targetX, targetY);
        ChessboardPoint lck = new ChessboardPoint(sourceX, sourceY);
        ChessColor colors = chessComponents[sourceX][sourceY].getChessColor();
        if (chessComponents[sourceX][sourceY] instanceof QueenChessComponent) {
            chessComponents[targetX][targetY] = new QueenChessComponent(lpl, colors, chessComponents);
        }else if (chessComponents[sourceX][sourceY] instanceof BishopChessComponent) {
            chessComponents[targetX][targetY] = new BishopChessComponent(lpl, colors, chessComponents);
        }else if (chessComponents[sourceX][sourceY] instanceof KnightChessComponent) {
            chessComponents[targetX][targetY] = new KnightChessComponent(lpl, colors, chessComponents);
        }else if (chessComponents[sourceX][sourceY] instanceof PawnChessComponent) {
            chessComponents[targetX][targetY] = new PawnChessComponent(lpl, colors, chessComponents);
        }else if (chessComponents[sourceX][sourceY] instanceof RookChessComponent) {
            chessComponents[targetX][targetY] = new RookChessComponent(lpl, colors, chessComponents);
        } else if (chessComponents[sourceX][sourceY] instanceof KingChessComponent) {
            chessComponents[targetX][targetY] = new KingChessComponent(lpl, colors, chessComponents);
        }chessComponents[sourceX][sourceY] = new EmptySlotComponent(lck, ChessColor.NONE);
        if (currentPlayer == ChessColor.BLACK) {
            currentPlayer = ChessColor.WHITE;
        } else if (currentPlayer == ChessColor.WHITE) {
            currentPlayer = ChessColor.BLACK;
        }
    }
}