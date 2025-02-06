import java.util.ArrayList;
import java.util.Comparator;
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
        if (chessboard.size() == 9) {
            for (int i = 0; i < 8; i++) {
                if (chessboard.get(i).length() == 8) {
                    for (int j = 0; j < 8; j++) {
                        if (chessboard.get(i).charAt(j) == 'R') {
                            RookChessComponent rook = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', this.chessComponents);
                            chessComponents[i][j] = rook;
                        }
                        if (chessboard.get(i).charAt(j) == 'N') {
                            KnightChessComponent knight = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N', this.chessComponents);
                            chessComponents[i][j] = knight;
                        }
                        if (chessboard.get(i).charAt(j) == 'B') {
                            BishopChessComponent bishop = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B', this.chessComponents);
                            chessComponents[i][j] = bishop;
                        }
                        if (chessboard.get(i).charAt(j) == 'Q') {
                            QueenChessComponent queen = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q', this.chessComponents);
                            chessComponents[i][j] = queen;
                        }
                        if (chessboard.get(i).charAt(j) == 'K') {
                            KingChessComponent king = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', this.chessComponents);
                            chessComponents[i][j] = king;
                        }
                        if (chessboard.get(i).charAt(j) == 'P') {
                            PawnChessComponent pawn = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', this.chessComponents);
                            chessComponents[i][j] = pawn;
                        }
                        if (chessboard.get(i).charAt(j) == 'r') {
                            RookChessComponent rook = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', this.chessComponents);
                            chessComponents[i][j] = rook;
                        }
                        if (chessboard.get(i).charAt(j) == 'n') {
                            KnightChessComponent knight = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n', this.chessComponents);
                            chessComponents[i][j] = knight;
                        }
                        if (chessboard.get(i).charAt(j) == 'b') {
                            BishopChessComponent bishop = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b', this.chessComponents);
                            chessComponents[i][j] = bishop;
                        }
                        if (chessboard.get(i).charAt(j) == 'q') {
                            QueenChessComponent queen = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q', this.chessComponents);
                            chessComponents[i][j] = queen;
                        }
                        if (chessboard.get(i).charAt(j) == 'k') {
                            KingChessComponent king = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', this.chessComponents);
                            chessComponents[i][j] = king;
                        }
                        if (chessboard.get(i).charAt(j) == 'p') {
                            PawnChessComponent pawn = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', this.chessComponents);
                            chessComponents[i][j] = pawn;
                        }
                        if (chessboard.get(i).charAt(j) == '_') {
                            EmptySlotComponent empty = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_', this.chessComponents);
                            chessComponents[i][j] = empty;
                        }
                    }
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder r1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r1.append(chessComponents[0][i].getName());
        }
        StringBuilder r2 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r2.append(chessComponents[1][i].getName());
        }
        StringBuilder r3 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r3.append(chessComponents[2][i].getName());
        }
        StringBuilder r4 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r4.append(chessComponents[3][i].getName());
        }
        StringBuilder r5 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r5.append(chessComponents[4][i].getName());
        }
        StringBuilder r6 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r6.append(chessComponents[5][i].getName());
        }
        StringBuilder r7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r7.append(chessComponents[6][i].getName());
        }
        StringBuilder r8 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            r8.append(chessComponents[7][i].getName());
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder STR = new StringBuilder();
        int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0, cnt6 = 0;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'K') {
                        cnt1++;
                    } else if (chessComponents[i][j].getName() == 'Q') {
                        cnt2++;
                    } else if (chessComponents[i][j].getName() == 'R') {
                        cnt3++;
                    } else if (chessComponents[i][j].getName() == 'B') {
                        cnt4++;
                    } else if (chessComponents[i][j].getName() == 'N') {
                        cnt5++;
                    } else if (chessComponents[i][j].getName() == 'P') {
                        cnt6++;
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                String str = null;
                if (i == 0 && cnt1 == 0) {
                    str = String.format("%c %d\n", 'K', 1);
                    STR.append(str);
                } else if (i == 1 && cnt2 == 0) {
                    str = String.format("%c %d\n", 'Q', 1);
                    STR.append(str);
                } else if (i == 2 && cnt3 != 2) {
                    str = String.format("%c %d\n", 'R', 2 - cnt3);
                    STR.append(str);
                } else if (i == 3 && cnt4 != 2) {
                    str = String.format("%c %d\n", 'B', 2 - cnt4);
                    STR.append(str);
                } else if (i == 4 && cnt5 != 2) {
                    str = String.format("%c %d\n", 'N', 2 - cnt5);
                    STR.append(str);
                } else if (i == 5 && cnt6 != 8) {
                    str = String.format("%c %d\n", 'P', 8 - cnt6);
                    STR.append(str);
                }
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'k') {
                        cnt1++;
                    } else if (chessComponents[i][j].getName() == 'q') {
                        cnt2++;
                    } else if (chessComponents[i][j].getName() == 'r') {
                        cnt3++;
                    } else if (chessComponents[i][j].getName() == 'b') {
                        cnt4++;
                    } else if (chessComponents[i][j].getName() == 'n') {
                        cnt5++;
                    } else if (chessComponents[i][j].getName() == 'p') {
                        cnt6++;
                    }
                }
            }
            for (int i = 0; i < 6; i++) {
                String str;
                if (i == 0 && cnt1 == 0) {
                    str = String.format("%c %d\n", 'k', 1);
                    STR.append(str);
                } else if (i == 1 && cnt2 == 0) {
                    str = String.format("%c %d\n", 'q', 1);
                    STR.append(str);
                } else if (i == 2 && cnt3 != 2) {
                    str = String.format("%c %d\n", 'r', 2 - cnt3);
                    STR.append(str);
                } else if (i == 3 && cnt4 != 2) {
                    str = String.format("%c %d\n", 'b', 2 - cnt4);
                    STR.append(str);
                } else if (i == 4 && cnt5 != 2) {
                    str = String.format("%c %d\n", 'n', 2 - cnt5);
                    STR.append(str);
                } else if (i == 5 && cnt6 != 8) {
                    str = String.format("%c %d\n", 'p', 8 - cnt6);
                    STR.append(str);
                }
            }
        }
        return String.valueOf(STR);
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        ChessComponent u = this.chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = new ArrayList<ChessboardPoint>();
        for (int i = 0; i < u.canMoveTo().size(); i++) {
            canMovePoints.add(u.canMoveTo().get(i));
        }
        canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (0 <= sourceX && sourceX <= 7 && 0 <= sourceY && sourceY <= 7 && 0 <= targetX && targetX <= 7 && 0 <= targetY && targetY <= 7) {
            ChessComponent s = chessComponents[sourceX][sourceY];
            if (currentPlayer == s.getChessColor()) {
                if (s.canMoveTo().size() != 0) {
                    for (int i = 0; i < s.canMoveTo().size(); i++) {
                        if (s.canMoveTo().get(i).getX() == targetX
                                && s.canMoveTo().get(i).getY() == targetY) {
                            if (chessComponents[targetX][targetY].getChessColor() != s.getChessColor()) {
                                s.setSource(new ChessboardPoint(targetX, targetY));
                                chessComponents[targetX][targetY] = s;
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                                for (int j = 0; j < 8; j++) {
                                    for (int k = 0; k < 8; k++) {
                                        chessComponents[j][k].setChessComponents(this.chessComponents);
                                    }
                                }
                                if (this.currentPlayer == ChessColor.BLACK) {
                                    setCurrentPlayer(ChessColor.WHITE);
                                } else if (this.currentPlayer == ChessColor.WHITE) {
                                    setCurrentPlayer(ChessColor.BLACK);
                                }
                                return true;
                            }
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
}
