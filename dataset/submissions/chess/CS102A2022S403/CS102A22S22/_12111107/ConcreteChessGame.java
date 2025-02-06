import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size() - 1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                char x = chessboard.get(i).charAt(j);
                switch (x) {
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, x);
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, x);
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, x);
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, x);
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, x);
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, x);
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, x);
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, x);
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, x);
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, x);
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, x);
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, x);
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, x);
                        break;
                }
                int count = chessboard.size() - 1;
                char y = chessboard.get(count).charAt(0);
                if (y == 'w') {
                    this.currentPlayer = ChessColor.WHITE;
                } else this.currentPlayer = ChessColor.BLACK;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].chessboard = chessComponents;
            }
        }

    }

    public String getChessboardGraph() {
        String string = "";
        char z;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                z = chessComponents[i][j].getName();
                string = string + z;
            }
            string = String.format("%s\n", string);
        }
        return string;
    }

    public String getCapturedChess(ChessColor player) {
        String string = "";
        int[] white = {0, 0, 0, 0, 0, 0};
        int[] black = {0, 0, 0, 0, 0, 0};
        char X;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                X = chessComponents[i][j].getName();
                switch (X) {
//                    King>Queen>Rooks>Bishops>Knights>Pawns
                    case 'K':
                        black[0] += 1;
                        break;
                    case 'Q':
                        black[1] += 1;
                        break;
                    case 'R':
                        black[2] += 1;
                        break;
                    case 'B':
                        black[3] += 1;
                        break;
                    case 'N':
                        black[4] += 1;
                        break;
                    case 'P':
                        black[5] += 1;
                        break;
                    case 'k':
                        white[0] += 1;
                        break;
                    case 'q':
                        white[1] += 1;
                        break;
                    case 'r':
                        white[2] += 1;
                        break;
                    case 'b':
                        white[3] += 1;
                        break;
                    case 'n':
                        white[4] += 1;
                        break;
                    case 'p':
                        white[5] += 1;
                        break;
                }
            }
        }
        String BK = String.format("K %d\n", 1 - black[0]);
        if (black[0] == 1) {
            BK = "";
        }
        String BQ = String.format("Q %d\n", 1 - black[1]);
        if (black[1] == 1) {
            BQ = "";
        }
        String BR = String.format("R %d\n", 2 - black[2]);
        if (black[2] == 2) {
            BR = "";
        }
        String BB = String.format("B %d\n", 2 - black[3]);
        if (black[3] == 2) {
            BB = "";
        }
        String BN = String.format("N %d\n", 2 - black[4]);
        if (black[4] == 2) {
            BN = "";
        }
        String BP = String.format("P %d", 8 - black[5]);
        if (black[5] == 8) {
            BP = "";
        }
        String WK = String.format("k %d\n", 1 - white[0]);
        if (white[0] == 1) {
            WK = "";
        }
        String WQ = String.format("q %d\n", 1 - white[1]);
        if (white[1] == 1) {
            WQ = "";
        }
        String WR = String.format("r %d\n", 2 - white[2]);
        if (white[2] == 2) {
            WR = "";
        }
        String WB = String.format("b %d\n", 2 - white[3]);
        if (white[3] == 2) {
            WB = "";
        }
        String WN = String.format("n %d\n", 2 - white[4]);
        if (white[4] == 2) {
            WN = "";
        }
        String WP = String.format("p %d", 8 - white[5]);
        if (white[5] == 8) {
            WP = "";
        }
        if (player == ChessColor.WHITE) {
            string = String.format("%s%s%s%s%s%s", WK, WQ, WR, WB, WN, WP);
        } else string = String.format("%s%s%s%s%s%s", BK, BQ, BR, BB, BN, BP);
        return string;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        return comparable(canMovePoints);
    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7 && currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
            ChessComponent temp1 = chessComponents[sourceX][sourceY];
            ChessComponent temp2 = chessComponents[targetX][targetY];
            if (temp2.getChessColor() != temp1.getChessColor()) {
                List<ChessboardPoint> a = getCanMovePoints(new ChessboardPoint(sourceX, sourceY));
                for (int i = 0; i < a.size(); i++) {
                    if (chessComponents[targetX][targetY].getSource() == a.get(i)) {
                        chessComponents[targetX][targetY] = temp1;
                        chessComponents[targetX][targetY].setName(temp1.name);
                        chessComponents[targetX][targetY].setChessColor(temp1.getChessColor());
                        chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY), ChessColor.NONE,'_');
                        if (currentPlayer == ChessColor.BLACK)
                            currentPlayer = ChessColor.WHITE;
                        else currentPlayer = ChessColor.BLACK;
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public List<ChessboardPoint> comparable(List<ChessboardPoint> canMovePoints) {
        List<ChessboardPoint> canMovePoint = new ArrayList<>();
        List<Integer> integers;
        if (canMovePoints != null) {
            while (canMovePoints.size() != 0) {
                integers = new ArrayList<>();
                for (ChessboardPoint movePoint : canMovePoints) {
                    if (movePoint != null) {
                        int tempX = movePoint.getX();
                        int tempY = movePoint.getY();
                        integers.add(tempX * 8 + tempY);
                    }
                }
                int Pos1 = integers.indexOf(Collections.min(integers));
                canMovePoint.add(canMovePoints.get(Pos1));
                canMovePoints.remove(Pos1);
            }
        }
        return canMovePoint;
    }
}