import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private ChessboardPoint chessboardPoint;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    ChessComponent rookChessComponent = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R', chessComponents);
                    chessComponents[i][j] = rookChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    ChessComponent knightChessComponent = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                    chessComponents[i][j] = knightChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    ChessComponent bishopChessComponent = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                    chessComponents[i][j] = bishopChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    ChessComponent queenChessComponent = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                    chessComponents[i][j] = queenChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    ChessComponent kingChessComponent = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K', chessComponents);
                    chessComponents[i][j] = kingChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    ChessComponent pawnChessComponent = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P', chessComponents);
                    chessComponents[i][j] = pawnChessComponent;
                } else if (chessboard.get(i).charAt(j) == '_') {
                    ChessComponent emptySlotComponent = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                    chessComponents[i][j] = emptySlotComponent;
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    ChessComponent rookChessComponent = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r', chessComponents);
                    chessComponents[i][j] = rookChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    ChessComponent knightChessComponent = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                    chessComponents[i][j] = knightChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    ChessComponent bishopChessComponent = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                    chessComponents[i][j] = bishopChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    ChessComponent queenChessComponent = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                    chessComponents[i][j] = queenChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    ChessComponent kingChessComponent = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k', chessComponents);
                    chessComponents[i][j] = kingChessComponent;
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    ChessComponent pawnChessComponent = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p', chessComponents);
                    chessComponents[i][j] = pawnChessComponent;
                }
            }
        }
        if (chessboard.get(8).equals("w"))
            this.currentPlayer = ChessColor.WHITE;
        else
            this.currentPlayer = ChessColor.BLACK;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        if (x >= 0 && x < 8 && y < 8 && y >= 0) {
            return chessComponents[x][y];
        } else {
            return null;
        }
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder y = null;
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            y = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'R') {
                    y.append('R');
                } else if (chessComponents[i][j].name == 'N') {
                    y.append('N');
                } else if (chessComponents[i][j].name == 'B') {
                    y.append('B');
                } else if (chessComponents[i][j].name == 'Q') {
                    y.append('Q');
                } else if (chessComponents[i][j].name == 'K') {
                    y.append('K');
                } else if (chessComponents[i][j].name == 'P') {
                    y.append('P');
                } else if (chessComponents[i][j].name == '_') {
                    y.append('_');
                } else if (chessComponents[i][j].name == 'r') {
                    y.append('r');
                } else if (chessComponents[i][j].name == 'n') {
                    y.append('n');
                } else if (chessComponents[i][j].name == 'b') {
                    y.append('b');
                } else if (chessComponents[i][j].name == 'q') {
                    y.append('q');
                } else if (chessComponents[i][j].name == 'k') {
                    y.append('k');
                } else if (chessComponents[i][j].name == 'p') {
                    y.append('p');
                }
            }
            x.append(y + "\n");
        }
        return x.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder p = new StringBuilder();
        int[] y = new int[]{1, 1, 2, 2, 2, 8};//, 1, 1, 2, 2, 2, 8};
        int[] x = new int[6];//{1, 1, 2, 2, 2, 8};//, 1, 1, 2, 2, 2, 8};
        String[] O = new String[]{"K", "Q", "R", "B", "N", "P"};
        String[] o = new String[]{"k", "q", "r", "b", "n", "p"};
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'R') {
                        x[2]++;
                        //String RR = String.valueOf(x[2]);
                    } else if (chessComponents[i][j].name == 'N') {
                        x[4]++;
                        //String NN = String.valueOf(x[4]);
                    } else if (chessComponents[i][j].name == 'B') {
                        x[3]++;
                        //String BB = String.valueOf(x[3]);
                    } else if (chessComponents[i][j].name == 'Q') {
                        x[1]++;
                        // String QQ = String.valueOf(x[1]);
                    } else if (chessComponents[i][j].name == 'K') {
                        x[0]++;
                        //String KK = String.valueOf(x[0]);
                    } else if (chessComponents[i][j].name == 'P') {
                        x[5]++;
                        //String PP = String.valueOf(x[5]);
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'r') {
                        x[2]++;
                        //String rr = String.valueOf(x[2]);
                    } else if (chessComponents[i][j].name == 'n') {
                        x[4]++;
                        //String nnn = String.valueOf(x[4]);
                    } else if (chessComponents[i][j].name == 'b') {
                        x[3]++;
                        //String bb = String.valueOf(x[3]);
                    } else if (chessComponents[i][j].name == 'q') {
                        x[1]++;
                        //String qq = String.valueOf(x[1]);
                    } else if (chessComponents[i][j].name == 'k') {
                        x[0]++;
                        //String kk = String.valueOf(x[0]);
                    } else if (chessComponents[i][j].name == 'p') {
                        x[5]++;
                        // String pp = String.valueOf(x[5]);
                    }
                }
            }
        }
        for (int k = 0; k < 6; k++) {
            if (player == ChessColor.BLACK) {
                if (x[k] != y[k]) {
                    if (p.toString().equals("")) {
                        p.append(O[k] + " " + (y[k] - x[k]));
                    } else {
                        p.append("\n" + O[k] + " " + (y[k] - x[k]));
                    }
                }
            } else {
                if (x[k] != y[k]) {
                    if (p.toString().equals("")) {
                        p.append(o[k] + " " + (y[k] - x[k]));
                    } else {
                        p.append("\n" + o[k] + " " + (y[k] - x[k]));
                    }
                }
            }
        }
        return p.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        return chess.canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (sourceX<0||sourceX>7){
            return false;
        }
        if (targetX<0||targetY>7){
            return false;
        }
        ChessComponent point = chessComponents[sourceX][sourceY];
        ChessboardPoint destination = new ChessboardPoint(targetX, targetY);
        if (point instanceof EmptySlotComponent){
            return false;
        }
        System.out.println(this.chessComponents[sourceX][sourceY].getChessColor());
        System.out.println(this.currentPlayer);
        if (this.chessComponents[sourceX][sourceY].getChessColor() == this.currentPlayer){
            if (point.canMoveTo().size()==0){
                return false;
            }
            for (int i=0;i<chessComponents[sourceX][sourceY].canMoveTo().size();i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).toString().equals(destination.toString())) {
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY), ChessColor.NONE, '_');
                    chessComponents[targetX][targetY].setSource(destination);
                    chessComponents[targetX][targetY].setChessComponents(chessComponents);
                    currentPlayer=(currentPlayer==ChessColor.WHITE?ChessColor.BLACK:ChessColor.WHITE);
                    return true;
                }
            }
        }
        return false;
    }
    }


