import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {


    private ChessComponent[][] chessComponents;

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

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }


    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j] = readChessBoard(chessboard.get(i).charAt(j));
                this.chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.chessComponents[i][j].setChessComponents(this.chessComponents);
            }
        }
        if (chessboard.get(8).equals("b")) {
            setCurrentPlayer(ChessColor.BLACK);
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(this.chessComponents[i][j]);
            }
            if (i != 7) {
                str.append("\n");
            }
        }
        return new String(str);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int[] a = {1, 1, 2, 2, 2, 8};
        if (player.equals(ChessColor.WHITE)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        a[0]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'q') {
                        a[1]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'r') {
                        a[2]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'b') {
                        a[3]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'n') {
                        a[4]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'p') {
                        a[5]--;
                    }
                }
            }
            char[] b = {'k', 'q', 'r', 'b', 'n', 'p'};
            StringBuilder s = new StringBuilder();
            for (int k = 0; k < 6; k++) {
                if (a[k] != 0) {
                    s.append(b[k]);
                    s.append(' ');
                    s.append(a[k]);
                    s.append("\n");
                }
            }
            return new String(s);
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        a[0]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'Q') {
                        a[1]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'R') {
                        a[2]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'B') {
                        a[3]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'N') {
                        a[4]--;
                        continue;
                    }
                    if (chessComponents[i][j].name == 'P') {
                        a[5]--;
                    }
                }
            }
            char[] b = {'K', 'Q', 'R', 'B', 'N', 'P'};
            StringBuilder s = new StringBuilder();
            for (int k = 0; k < 6; k++) {
                if (a[k] != 0) {
                    s.append(b[k]);
                    s.append(' ');
                    s.append(a[k]);
                    s.append("\n");
                }
            }
            return new String(s);
        }

    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> newList = new ArrayList<>();
        List<ChessboardPoint> list = chessComponents[source.getX()][source.getY()].canMoveTo();
        if (list.size()==0){return newList;}
        int[] location = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            location[i] = 10 * list.get(i).getX() + list.get(i).getY();
        }
        Arrays.sort(location);

        for (int i = 0; i < location.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getY() + list.get(j).getX() * 10 == location[i]) {
                    newList.add(list.get(j));
                    break;
                }
            }
        }
return newList;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chessComponent1 = chessComponents[sourceX][sourceY];
        if (getCurrentPlayer().equals(chessComponent1.getChessColor())) {
            if (ifCanMoveTo(new ChessboardPoint(targetX, targetY),chessComponents[sourceX][sourceY])) {
                chessComponent1.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=chessComponent1;
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY), ChessColor.NONE);

                if (getCurrentPlayer().equals(ChessColor.WHITE)){setCurrentPlayer(ChessColor.BLACK);}
                else if (getCurrentPlayer().equals(ChessColor.BLACK)){setCurrentPlayer(ChessColor.WHITE);}
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static ChessComponent readChessBoard(char a) {
        ChessComponent theChess = null;
        if (a == '_') {
            theChess = new EmptySlotComponent();
        }
        if (a == 'R' || a == 'r') {
            theChess = new RookChessComponent();
            if (a == 'r') {
                theChess.setChessColor(ChessColor.WHITE);
            } else {
                theChess.setChessColor(ChessColor.BLACK);
            }
        }
        if (a == 'P' || a == 'p') {
            theChess = new PawnChessComponent();
            if (a == 'p') {
                theChess.setChessColor(ChessColor.WHITE);
            } else {
                theChess.setChessColor(ChessColor.BLACK);
            }
        }
        if (a == 'B' || a == 'b') {
            theChess = new BishopChessComponent();
            if (a == 'b') {
                theChess.setChessColor(ChessColor.WHITE);
            } else {
                theChess.setChessColor(ChessColor.BLACK);
            }
        }
        if (a == 'N' || a == 'n') {
            theChess = new KnightChessComponent();
            if (a == 'n') {
                theChess.setChessColor(ChessColor.WHITE);
            } else {
                theChess.setChessColor(ChessColor.BLACK);
            }
        }
        if (a == 'K' || a == 'k') {
            theChess = new KingChessComponent();
            if (a == 'k') {
                theChess.setChessColor(ChessColor.WHITE);
            } else {
                theChess.setChessColor(ChessColor.BLACK);
            }
        }
        if (a == 'Q' || a == 'q') {
            theChess = new QueenChessComponent();
            if (a == 'q') {
                theChess.setChessColor(ChessColor.WHITE);
            } else {
                theChess.setChessColor(ChessColor.BLACK);
            }
        }
        return theChess;
    }

    public static char writeChessBoard(ChessComponent a) {

        if (a instanceof PawnChessComponent) {
            if (a.getChessColor() == ChessColor.BLACK) {
                return 'P';
            } else {
                return 'p';
            }
        } else if (a instanceof EmptySlotComponent) {
            return '_';
        } else if (a instanceof RookChessComponent) {
            if (a.getChessColor() == ChessColor.BLACK) {
                return 'R';
            } else {
                return 'r';
            }
        } else if (a instanceof KnightChessComponent) {
            if (a.getChessColor() == ChessColor.BLACK) {
                return 'N';
            } else {
                return 'n';
            }
        } else if (a instanceof BishopChessComponent) {
            if (a.getChessColor() == ChessColor.BLACK) {
                return 'B';
            } else {
                return 'b';
            }
        } else if (a instanceof KingChessComponent) {
            if (a.getChessColor() == ChessColor.BLACK) {
                return 'K';
            } else {
                return 'k';
            }
        } else {
            if (a.getChessColor() == ChessColor.BLACK) {
                return 'Q';
            } else {
                return 'q';
            }
        }

    }public  static boolean ifCanMoveTo(ChessboardPoint target,ChessComponent source) {
        List<ChessboardPoint> chessboardPoints = source.canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }


}
