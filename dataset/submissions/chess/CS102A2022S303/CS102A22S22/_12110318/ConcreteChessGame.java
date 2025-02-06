import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint N = new ChessboardPoint(i, j);
                switch (chessboard.get(i).charAt(j)) {
                    case 'k':
                        KingChessComponent C1 = new KingChessComponent(N, ChessColor.WHITE);
                        chessComponents[i][j] = C1;
                        break;
                    case 'K':
                        KingChessComponent C2 = new KingChessComponent(N, ChessColor.BLACK);
                        chessComponents[i][j] = C2;
                        break;
                    case '_':
                        EmptySlotComponent C3 = new EmptySlotComponent(N, ChessColor.NONE);
                        chessComponents[i][j] = C3;
                        break;
                    case 'N':
                        KnightChessComponent C4 = new KnightChessComponent(N, ChessColor.BLACK);
                        chessComponents[i][j] = C4;
                        break;
                    case 'n':
                        KnightChessComponent C5 = new KnightChessComponent(N, ChessColor.WHITE);
                        chessComponents[i][j] = C5;
                        break;
                    case 'p':
                        PawnChessComponent C6 = new PawnChessComponent(N, ChessColor.WHITE);
                        chessComponents[i][j] = C6;
                        break;
                    case 'P':
                        PawnChessComponent C7 = new PawnChessComponent(N, ChessColor.BLACK);
                        chessComponents[i][j] = C7;
                        break;
                    case 'q':
                        QueenChessComponent C8 = new QueenChessComponent(N, ChessColor.WHITE);
                        chessComponents[i][j] = C8;
                        break;
                    case 'Q':
                        QueenChessComponent C9 = new QueenChessComponent(N, ChessColor.BLACK);
                        chessComponents[i][j] = C9;
                        break;
                    case 'r':
                        RookChessComponent C10 = new RookChessComponent(N, ChessColor.WHITE);
                        chessComponents[i][j] = C10;
                        break;
                    case 'R':
                        RookChessComponent C11 = new RookChessComponent(N, ChessColor.BLACK);
                        chessComponents[i][j] = C11;
                        break;
                    case 'b':
                        BishopChessComponent C12 = new BishopChessComponent(N, ChessColor.WHITE);
                        chessComponents[i][j] = C12;
                        break;
                    case 'B':
                        BishopChessComponent C13 = new BishopChessComponent(N, ChessColor.BLACK);
                        chessComponents[i][j] = C13;
                        break;
                }
            }
        }
        if (chessboard.get(chessboard.size() - 1).equals("w")) {
            setCurrentPlayer(ChessColor.WHITE);
        } else if ((chessboard.get(chessboard.size() - 1).equals("b"))) {
            setCurrentPlayer(ChessColor.BLACK);
        } else {
            setCurrentPlayer(ChessColor.WHITE);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
    }

    public int countLeftChess(String str, String s) {
        String str1 = str.replaceAll(s, "");
        int len1 = str.length(), len2 = str1.length();
        int count = len1 - len2;
        return count;
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sb.append(chessComponents[i][j].name);
            }
            if (i < 7) {
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder capture = new StringBuilder();
        if (player == ChessColor.WHITE) {
            if (countLeftChess(getChessboardGraph(), "k") != 1) {
                capture.append("k 1\n");
            }
            if (countLeftChess(getChessboardGraph(), "q") != 1) {
                capture.append("q 1\n");
            }
            if (countLeftChess(getChessboardGraph(), "r") != 2) {
                capture.append("r ");
                capture.append(2 - countLeftChess(getChessboardGraph(), "r"));
                capture.append("\n");
            }
            if (countLeftChess(getChessboardGraph(), "b") != 2) {
                capture.append("b ");
                capture.append(2 - countLeftChess(getChessboardGraph(), "b"));
                capture.append("\n");
            }
            if (countLeftChess(getChessboardGraph(), "n") != 2) {
                capture.append("n ");
                capture.append(2 - countLeftChess(getChessboardGraph(), "n"));
                capture.append("\n");
            }
            if (countLeftChess(getChessboardGraph(), "p") != 8) {
                capture.append("p ");
                capture.append(8 - countLeftChess(getChessboardGraph(), "p"));
                capture.append("\n");
            }
        }
        if (player == ChessColor.BLACK) {
            if (countLeftChess(getChessboardGraph(), "K") != 1) {
                capture.append("K 1\n");
            }
            if (countLeftChess(getChessboardGraph(), "Q") != 1) {
                capture.append("Q 1\n");
            }
            if (countLeftChess(getChessboardGraph(), "R") != 2) {
                capture.append("R ");
                capture.append(2 - countLeftChess(getChessboardGraph(), "R"));
                capture.append("\n");
            }
            if (countLeftChess(getChessboardGraph(), "B") != 2) {
                capture.append("B ");
                capture.append(2 - countLeftChess(getChessboardGraph(), "B"));
                capture.append("\n");
            }
            if (countLeftChess(getChessboardGraph(), "N") != 2) {
                capture.append("N ");
                capture.append(2 - countLeftChess(getChessboardGraph(), "N"));
                capture.append("\n");
            }
            if (countLeftChess(getChessboardGraph(), "P") != 8) {
                capture.append("P ");
                capture.append(8 - countLeftChess(getChessboardGraph(), "P"));
                capture.append("\n");
            }
        }
        return capture.toString();
    }

        @Override
        public List<ChessboardPoint> getCanMovePoints (ChessboardPoint source){
            List<ChessboardPoint> canMovePoints = new ArrayList<>();
            canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
            Collections.sort(canMovePoints);
            return canMovePoints;
        }
    

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int a = 0;
        if (getChess(sourceX, sourceY).getChessColor() != currentPlayer) {
            return false;
        }
        if (sourceX<0||sourceX>7||targetX<0||targetX>7||sourceY<0||sourceY>7||targetY<0||targetY>7){
            return false;
        }
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        ChessComponent[][] beforeMove = chessComponents;
        ChessComponent[][] afterMove = chessComponents;
        List<ChessboardPoint> canMovePoints = getCanMovePoints(source);
        for (int i = 0; i < canMovePoints.size(); i++) {
            if (canMovePoints.get(i).getX() == targetX && canMovePoints.get(i).getY() == targetY) {
                a = 1;
            }
        }
        if (a == 1) {
            afterMove[targetX][targetY] = beforeMove[sourceX][sourceY];
            afterMove[targetX][targetY].setSource(target);
            afterMove[sourceX][sourceY] = new EmptySlotComponent(source, ChessColor.NONE);
            afterMove[sourceX][sourceY].setSource(source);
            chessComponents = afterMove;
            if (currentPlayer == ChessColor.WHITE) {
                currentPlayer = ChessColor.BLACK;
            } else {
                currentPlayer = ChessColor.WHITE;
            }
        }
        return a == 1;
    }
}

