import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private List<String> chessboard;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

//    public ConcreteChessGame() {
//        chessComponents = new ChessComponent[8][8];
//        currentPlayer = ChessColor.WHITE;
//        chessboard = new ArrayList<>();
//    }

    public void loadChessGame(List<String> chessboard) {//
        ChessColor chessColor = ChessColor.NONE;
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 95) {
                    chessComponents[i][j] = new EmptySlotChessComponent(new ChessboardPoint(i, j));
                }
                if (chessboard.get(i).charAt(j) <= 90) {
                    chessColor = ChessColor.BLACK;
                }
                if (chessboard.get(i).charAt(j) >= 97) {
                    chessColor = ChessColor.WHITE;
                }
                switch (chessboard.get(i).charAt(j)) {
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessColor, 'k');
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessColor, 'q');
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessColor, 'r');
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessColor, 'b');
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessColor, 'n');
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessColor, 'p');
                        break;
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessColor, 'K');
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessColor, 'Q');
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessColor, 'R');
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessColor, 'B');
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessColor, 'N');
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessColor, 'P');
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotChessComponent(new ChessboardPoint(i, j));
                        break;
                }
                chessComponents[i][j].setFatherGame(this);
            }
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String result=null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                stringBuilder.append(chessComponents[i][j]);
            }
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int wleft[] = new int[]{1, 1, 2, 2, 2, 8};
        char bname[]=new char[]{'K','Q','R','B','N','P'};
        char wname[]=new char[]{'k','q','r','b','n','p'};
        int bleft[] = new int[]{1, 1, 2, 2, 2, 8};
        StringBuilder stringBuilderb=new StringBuilder();
        StringBuilder stringBuilderw=new StringBuilder();
        String result = null;
        for (ChessComponent nowr[] : chessComponents) {
            for (ChessComponent now : nowr) {
                    switch (now.name) {
                        case 'k':
                            wleft[0]--;
                            break;
                        case 'q':
                            wleft[1]--;
                            break;
                        case 'r':
                            wleft[2]--;
                            break;
                        case 'b':
                            wleft[3]--;
                            break;
                        case 'n':
                            wleft[4]--;
                            break;
                        case 'p':
                            wleft[5]--;
                            break;
                        case 'K':
                            bleft[0]--;
                            break;
                        case 'Q':
                            bleft[1]--;
                            break;
                        case 'R':
                            bleft[2]--;
                            break;
                        case 'B':
                            bleft[3]--;
                            break;
                        case 'N':
                            bleft[4]--;
                            break;
                        case 'P':
                            bleft[5]--;
                            break;
                    }
                }
            }
        if (player.equals(ChessColor.BLACK)){
            for (int i = 0; i < bleft.length; i++) {
                if (bleft[i]!=0){
                    stringBuilderb.append(String.format("%s %d\n",bname[i],bleft[i]));
                }
            }
            result=stringBuilderb.toString();
        }
        if (player.equals(ChessColor.WHITE)){
            for (int i = 0; i < wleft.length; i++) {
                if (wleft[i]!=0){
                    stringBuilderw.append(String.format("%s %d\n",wname[i],wleft[i]));
                }
            }
            result=stringBuilderw.toString();
        }
        return result;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public ChessComponent getChess(ChessboardPoint point) {
        return chessComponents[point.getX()][point.getY()];
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ArrayList<ChessboardPoint> chess = (ArrayList<ChessboardPoint>) getChess(source).canMoveTo();
        Comparator<ChessboardPoint> X = Comparator.comparing(ChessboardPoint :: getX);
        Comparator<ChessboardPoint> Y = Comparator.comparing(ChessboardPoint :: getY);
        chess.sort(X.thenComparing(Y));
        return chess;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean flag1;
        boolean flag2;
        boolean flag3;
        ChessboardPoint start = new ChessboardPoint(sourceX,sourceY);
        ChessboardPoint end = new ChessboardPoint(targetX,targetY);
        flag1 = chessComponents[sourceX][sourceY].name <= 90 && currentPlayer.equals(ChessColor.BLACK);
        flag2 = chessComponents[sourceX][sourceY].name >= 97 && currentPlayer.equals(ChessColor.WHITE);
        flag3 = false;

        for (ChessboardPoint p : this.getCanMovePoints(start)) {
            if (p.getX()==targetX && p.getY() == targetY) {
                flag3 = true;
            }
        }
        if ((flag1 || flag2) && flag3) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = new EmptySlotChessComponent(new ChessboardPoint(sourceX,sourceY));
            chessComponents[sourceX][sourceY].setFatherGame(this);
            chessComponents[targetX][targetY].setSource(targetX,targetY);
            switchPlayer();
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        if (this.currentPlayer.equals(ChessColor.WHITE)) {
            this.currentPlayer = ChessColor.BLACK;
            return;
        }
        this.currentPlayer = ChessColor.WHITE;
    }
}
