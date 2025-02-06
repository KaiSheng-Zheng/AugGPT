import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    public static ChessComponent[][] getchessComponents;
    private ChessColor currentPlayer;
    private List<String> chessboard;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        getchessComponents = chessComponents;
        currentPlayer = ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        getchessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        getchessComponents = chessComponents;
        this.chessboard = chessboard;
        for (int i = 0; i < chessboard.size(); i++) {
            if (i <= 7) {
                for (int j = 0; j < 8; j++) {
                    String kind = String.valueOf(chessboard.get(i).charAt(j));
                    switch (kind) {
                        case "_" -> chessComponents[i][j] = new EmptySlotComponent();
                        case "P" -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                        case "p" -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                        case "R" -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                        case "r" -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                        case "N" -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                        case "n" -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                        case "B" -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                        case "b" -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                        case "Q" -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                        case "q" -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                        case "K" -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                        case "k" -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                    }
                }
            } else {
                if (Objects.equals(chessboard.get(i), "w")) {
                    currentPlayer = ChessColor.WHITE;
                } else {
                    currentPlayer = ChessColor.BLACK;
                }
            }
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
        String str = "";
        for (int i = 0; i < chessComponents.length; i++) {
            String stri = "";
            for (int j = 0; j < 8; j++) {
                stri += chessComponents[i][j];
            }
            str += String.format("%s\n", stri);
        }
        return str;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int Pp = 8;
        int Rr = 2;
        int Nn = 2;
        int Bb = 2;
        int Qq = 1;
        int Kk = 1;
        String str = "";
        switch (player) {
            case BLACK -> {
                for (int i = 0; i < chessComponents.length; i++) {
                    for (int j = 0; j < 8; j++) {
                        String kind = String.valueOf(chessComponents[i][j]);
                        switch (kind) {
                            case "K" -> Kk--;
                            case "Q" -> Qq--;
                            case "B" -> Bb--;
                            case "N" -> Nn--;
                            case "R" -> Rr--;
                            case "P" -> Pp--;
                        }
                    }
                }
                if (Kk != 0) {
                    str += String.format("K %d\n", Kk);
                }
                if (Qq != 0) {
                    str += String.format("Q %d\n", Qq);
                }
                if (Rr != 0) {
                    str += String.format("R %d\n", Rr);
                }
                if (Bb != 0) {
                    str += String.format("B %d\n", Bb);
                }
                if (Nn != 0) {
                    str += String.format("N %d\n", Nn);
                }
                if (Pp != 0) {
                    str += String.format("P %d\n", Pp);
                }
                return str;
            }
            case WHITE -> {
                for (int i = 0; i < chessComponents.length; i++) {
                    for (int j = 0; j < 8; j++) {
                        String kind = String.valueOf(chessComponents[i][j]);
                        switch (kind) {
                            case "k" -> Kk--;
                            case "q" -> Qq--;
                            case "b" -> Bb--;
                            case "n" -> Nn--;
                            case "r" -> Rr--;
                            case "p" -> Pp--;
                        }
                    }
                }
                if (Kk != 0) {
                    str += String.format("k %d\n", Kk);
                }
                if (Qq != 0) {
                    str += String.format("q %d\n", Qq);
                }
                if (Rr != 0) {
                    str += String.format("r %d\n", Rr);
                }
                if (Bb != 0) {
                    str += String.format("b %d\n", Bb);
                }
                if (Nn != 0) {
                    str += String.format("n %d\n", Nn);
                }
                if (Pp != 0) {
                    str += String.format("p %d\n", Pp);
                }
                return str;
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chessboardPoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        chessboardPoints.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() == o2.getX()) {
                    if (o1.getY() > o2.getY()) {
                        return 1;
                    } else if (o1.getY() == o2.getY()) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        return chessboardPoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (Ingraph(sourceX) && Ingraph(sourceY) && Ingraph(targetX) && Ingraph(targetY)) {
            if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
                List<ChessboardPoint> chessboardPoints = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                ChessboardPoint target = new ChessboardPoint(targetX, targetY);
                boolean inin = false;
                for (int i = 0; i < chessboardPoints.size(); i++) {
                    if (chessboardPoints.get(i).getX() == targetX && chessboardPoints.get(i).getY() == targetY) {
                        inin = true;
                        break;
                    }
                }
                if (inin) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    currentPlayer = ChangeColor(currentPlayer);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean Ingraph(int a) {
        return (a <= 7 && a >= 0);
    }

    public ChessColor ChangeColor(ChessColor chessColor) {
        if (chessColor == ChessColor.WHITE) {
            return ChessColor.BLACK;
        } else if (chessColor == ChessColor.BLACK) {
            return ChessColor.WHITE;
        } else {
            return ChessColor.NONE;
        }
    }
}
