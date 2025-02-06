import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public List<String> chessboard;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        for (int i = 0; i < 9; i++) {
            if (i < 8) {
                for (int j = 0; j < 8; j++) {
                    ChessboardPoint source = new ChessboardPoint(i, j);
                    switch (chessboard.get(i).charAt(j)) {
                        case 'K':
                            chessComponents[i][j] = new KingChessComponent(source, ChessColor.BLACK, 'K');
                            break;
                        case 'N':
                            chessComponents[i][j] = new KnightChessComponent(source, ChessColor.BLACK, 'N');
                            break;
                        case 'P':
                            chessComponents[i][j] = new PawnChessComponent(source, ChessColor.BLACK, 'P');
                            break;
                        case 'Q':
                            chessComponents[i][j] = new QueenChessComponent(source, ChessColor.BLACK, 'Q');
                            break;
                        case 'R':
                            chessComponents[i][j] = new RookChessComponent(source, ChessColor.BLACK, 'R');
                            break;
                        case 'B':
                            chessComponents[i][j] = new BishopChessComponent(source, ChessColor.BLACK, 'B');
                            break;
                        case 'k':
                            chessComponents[i][j] = new KingChessComponent(source, ChessColor.WHITE, 'k');
                            break;
                        case 'n':
                            chessComponents[i][j] = new KnightChessComponent(source, ChessColor.WHITE, 'n');
                            break;
                        case 'p':
                            chessComponents[i][j] = new PawnChessComponent(source, ChessColor.WHITE, 'p');
                            break;
                        case 'q':
                            chessComponents[i][j] = new QueenChessComponent(source, ChessColor.WHITE, 'q');
                            break;
                        case 'r':
                            chessComponents[i][j] = new RookChessComponent(source, ChessColor.WHITE, 'r');
                            break;
                        case 'b':
                            chessComponents[i][j] = new BishopChessComponent(source, ChessColor.WHITE, 'b');
                            break;
                        case '_':
                            chessComponents[i][j] = new EmptySlotComponent(source, ChessColor.NONE, '_');
                            break;
                    }
                }
            } else if (chessboard.get(i).charAt(0) == 'b') {
                currentPlayer = ChessColor.BLACK;
                break;
            } else {
                currentPlayer = ChessColor.WHITE;
                break;
            }
        }
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++)
                chessComponents[i][j].setChessComponents(chessComponents);
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        int a = chessboard.size();
        String str = "";
        for (int i = 0; i < a - 1; i++) {
            str = str.concat(chessboard.get(i)).concat("\n");
        }
        return str;
    }

    public String getCapturedChess(ChessColor player) {
        String str = "";
        int kCount = 1, qCount = 1, rCount = 2, bCount = 2, nCount = 2, pCount = 8, KCount = 1, QCount = 1, RCount = 2, BCount = 2, NCount = 2, PCount = 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'K':
                        KCount--;
                        break;
                    case 'N':
                        NCount--;
                        break;
                    case 'P':
                        PCount--;
                        break;
                    case 'Q':
                        QCount--;
                        break;
                    case 'R':
                        RCount--;
                        break;
                    case 'B':
                        BCount--;
                        break;
                    case 'k':
                        kCount--;
                        break;
                    case 'n':
                        nCount--;
                        break;
                    case 'p':
                        pCount--;
                        break;
                    case 'q':
                        qCount--;
                        break;
                    case 'r':
                        rCount--;
                        break;
                    case 'b':
                        bCount--;
                        break;
                    case '_':
                        break;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            if (KCount != 0) {
                str = str.concat("K ").concat(String.valueOf(KCount)).concat("\n");
            }
            if (QCount != 0) {
                str = str.concat("Q ").concat(String.valueOf(QCount)).concat("\n");
            }
            if (RCount != 0) {
                str = str.concat("R ").concat(String.valueOf(RCount)).concat("\n");
            }
            if (BCount != 0) {
                str = str.concat("B ").concat(String.valueOf(BCount)).concat("\n");
            }
            if (NCount != 0) {
                str = str.concat("N ").concat(String.valueOf(NCount)).concat("\n");
            }
            if (PCount != 0) {
                str = str.concat("P ").concat(String.valueOf(PCount)).concat("\n");
            }
        }
        if (player == ChessColor.WHITE) {
            if (kCount != 0) {
                str = str.concat("k ").concat(String.valueOf(kCount)).concat("\n");
            }
            if (qCount != 0) {
                str = str.concat("q ").concat(String.valueOf(qCount)).concat("\n");
            }
            if (rCount != 0) {
                str = str.concat("r ").concat(String.valueOf(rCount)).concat("\n");
            }
            if (bCount != 0) {
                str = str.concat("b ").concat(String.valueOf(bCount)).concat("\n");
            }
            if (nCount != 0) {
                str = str.concat("n ").concat(String.valueOf(nCount)).concat("\n");
            }
            if (pCount != 0) {
                str = str.concat("p ").concat(String.valueOf(pCount)).concat("\n");
            }
        }
        return str;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        return canMovePoints;

    }

    private void changePlayer() {
        if (currentPlayer == ChessColor.BLACK) {
            currentPlayer = ChessColor.WHITE;
        }
        if (currentPlayer == ChessColor.WHITE) {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY] instanceof EmptySlotComponent) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].toString().charAt(0) <= 'z' && 'a' <= chessComponents[sourceX][sourceY].toString().charAt(0)) {
            return currentPlayer == ChessColor.WHITE;
        }
        if (chessComponents[sourceX][sourceY].toString().charAt(0) <= 'Z' && 'A' <= chessComponents[sourceX][sourceY].toString().charAt(0)) {
            return currentPlayer == ChessColor.BLACK;
        }
        List<ChessboardPoint> chessboardPoints = chessComponents[sourceX][sourceY].canMoveTo();
        int n = chessboardPoints.size();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            char a = chessComponents[sourceX][sourceY].toString().charAt(0);
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), currentPlayer, a);
                ChessboardPoint source = new ChessboardPoint(targetX, targetY);
                switch (a) {
                    case 'K':
                        chessComponents[targetX][targetY] = new KingChessComponent(source, ChessColor.BLACK, 'K');
                        break;
                    case 'N':
                        chessComponents[targetX][targetY] = new KnightChessComponent(source, ChessColor.BLACK, 'N');
                        break;
                    case 'P':
                        chessComponents[targetX][targetY] = new PawnChessComponent(source, ChessColor.BLACK, 'P');
                        break;
                    case 'Q':
                        chessComponents[targetX][targetY] = new QueenChessComponent(source, ChessColor.BLACK, 'Q');
                        break;
                    case 'R':
                        chessComponents[targetX][targetY] = new RookChessComponent(source, ChessColor.BLACK, 'R');
                        break;
                    case 'B':
                        chessComponents[targetX][targetY] = new BishopChessComponent(source, ChessColor.BLACK, 'B');
                        break;
                    case 'k':
                        chessComponents[targetX][targetY] = new KingChessComponent(source, ChessColor.WHITE, 'k');
                        break;
                    case 'n':
                        chessComponents[targetX][targetY] = new KnightChessComponent(source, ChessColor.WHITE, 'n');
                        break;
                    case 'p':
                        chessComponents[targetX][targetY] = new PawnChessComponent(source, ChessColor.WHITE, 'p');
                        break;
                    case 'q':
                        chessComponents[targetX][targetY] = new QueenChessComponent(source, ChessColor.WHITE, 'q');
                        break;
                    case 'r':
                        chessComponents[targetX][targetY] = new RookChessComponent(source, ChessColor.WHITE, 'r');
                        break;
                    case 'b':
                        chessComponents[targetX][targetY] = new BishopChessComponent(source, ChessColor.WHITE, 'b');
                        break;
                    case '_':
                        chessComponents[targetX][targetY] = new EmptySlotComponent(source, ChessColor.NONE, '_');
                        break;
                }
                for(int i = 0; i < 8; i++)
                    for(int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChessComponents(chessComponents);
                    }
                return true;
            }


        }
        return false;
        }
    }
