import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public int[][] count = new int[2][6];
    public String s0 = "kqrbnp";
    public String s1 = "KQRBNP";
    public int[] sc = {1, 1, 2, 2, 2, 8};

    @Override
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).equals("w")) setCurrentPlayer(ChessColor.WHITE);
        if (chessboard.get(8).equals("b")) setCurrentPlayer(ChessColor.BLACK);
        for (int i = 0; i < 6; i++) {
            count[0][i] = 0; //0 white lower;1 black upper
            count[1][i] = 0;//kqrbnp
        }
        for (int j = 0; j < 8; j++) {
            String line = chessboard.get(j);
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                ChessboardPoint chessboardPoint = new ChessboardPoint(j, i);
                ChessComponent pc = new EmptySlotComponent();

                pc.setChessColor(ChessColor.NONE);
                pc.setSource(chessboardPoint);
                pc.setName('_');
                if (ch == 'n' || ch == 'N') {
                    pc = new KnightChessComponent();
                    if (ch == 'n') {
                        pc.setChessColor(ChessColor.WHITE);
                        pc.setName('n');
                        count[0][4]++;
                    } else {
                        pc.setChessColor(ChessColor.BLACK);
                        pc.setName('N');
                        count[1][4]++;
                    }
                }
                if (ch == 'p' || ch == 'P') {
                    pc = new PawnChessComponent();
                    if (ch == 'p') {
                        pc.setChessColor(ChessColor.WHITE);
                        pc.setName('p');
                        count[0][5]++;
                    } else {
                        pc.setChessColor(ChessColor.BLACK);
                        pc.setName('P');
                        count[1][5]++;
                    }
                }
                if (ch == 'b' || ch == 'B') {
                    pc = new BishopChessComponent();
                    if (ch == 'b') {
                        pc.setChessColor(ChessColor.WHITE);
                        pc.setName('b');
                        count[0][3]++;
                    } else {
                        pc.setChessColor(ChessColor.BLACK);
                        pc.setName('B');
                        count[1][3]++;
                    }
                }
                if (ch == 'r' || ch == 'R') {
                    pc = new RookChessComponent();
                    if (ch == 'r') {
                        pc.setChessColor(ChessColor.WHITE);
                        pc.setName('r');
                        count[0][2]++;
                    } else {
                        pc.setChessColor(ChessColor.BLACK);
                        pc.setName('R');
                        count[1][2]++;
                    }
                }
                if (ch == 'k' || ch == 'K') {
                    pc = new KingChessComponent();
                    if (ch == 'k') {
                        pc.setChessColor(ChessColor.WHITE);
                        pc.setName('k');
                        count[0][0]++;
                    } else {
                        pc.setChessColor(ChessColor.BLACK);
                        pc.setName('K');
                        count[1][0]++;
                    }
                }
                if (ch == 'q' || ch == 'Q') {
                    pc = new QueenChessComponent();
                    if (ch == 'q') {
                        pc.setChessColor(ChessColor.WHITE);
                        pc.setName('q');
                        count[0][1]++;
                    } else {
                        pc.setChessColor(ChessColor.BLACK);
                        pc.setName('Q');
                        count[1][1]++;
                    }
                }
                chessComponents[j][i] = pc;

                chessComponents[j][i].setSource(chessboardPoint);
            }

        }

        ChessComponent.setChessboard(this.chessComponents);
    }

    @Override

    public ChessColor getCurrentPlayer() {

        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    /**
     * @return
     */
    @Override
    public String getChessboardGraph() {
        String s = new String();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s += chessComponents[i][j];
            }
            s += "\n";
        }
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s = "";
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 6; i++) {
                if ((sc[i] - count[0][i]) > 0) s += s0.charAt(i) + " " + String.valueOf((sc[i] - count[0][i])) + "\n";
            }
        }
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 6; i++) {
                if ((sc[i] - count[1][i]) > 0) s += s1.charAt(i) + " " + String.valueOf((sc[i] - count[1][i])) + "\n";
            }
        }
        return s;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent source = this.getChess(sourceX, sourceY);
        if (targetX < 0 || targetX > 7 || targetY < 0 || targetY > 7) {
            return false;
        }
        ChessComponent target = this.getChess(targetX, targetY);
        List<ChessboardPoint> l = getCanMovePoints(source.getSource());
        //is mine && can move
        for (int i = 0; i < l.size(); i++) {
            if (targetX == l.get(i).getX() && targetY == l.get(i).getY()&&source.getChessColor().equals(getCurrentPlayer())) {
                this.chessComponents[targetX][targetY] = source;
                this.chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                this.chessComponents[sourceX][sourceY] = new EmptySlotComponent();//change component
                this.chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                this.chessComponents[sourceX][sourceY].setChessColor(ChessColor.NONE);
                if (getCurrentPlayer() == ChessColor.WHITE) {
                    for (int j = 0; j < 6; j++) {
                        if (target.getName()==s1.charAt(j)) count[1][j]--;
                    }
                    setCurrentPlayer(ChessColor.BLACK);
                }
                else {
                    for (int j = 0; j < 6; j++) {
                        if (target.getName()==s0.charAt(j)) count[0][j]--;
                    }
                    setCurrentPlayer(ChessColor.WHITE);//swap player
                }
                return true;
            }
        }
        return false;
    }

    public List<ChessboardPoint> sortby(List<ChessboardPoint> list) {
        Collections.sort(list,
                new Comparator<ChessboardPoint>() {
                    public int compare(ChessboardPoint p1, ChessboardPoint p2) {
                        int v1 = p1.getX();
                        int v2 = p2.getX();
                        if (v1 > v2) {
                            return 1;
                        }
                        if (v1 == v2) {
                            int vv1 = p1.getY();
                            int vv2 = p2.getY();
                            if (vv1 > vv2) {
                                return 1;
                            }
                            if (vv1 == vv2) {
                                return 0;
                            }
                            return -1;
                        }
                        return -1;
                    }
                });
        return list;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        // 1. find chess according to source
        // 2. as below statement:
        // 3.sort canMovePoints by x - y ascending order return canMovePoints;
        //comparable make it can be
        ChessComponent chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
//        rule
        return sortby(canMovePoints);
    }
}
