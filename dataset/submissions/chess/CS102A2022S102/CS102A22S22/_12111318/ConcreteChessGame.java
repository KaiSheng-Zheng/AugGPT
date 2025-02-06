import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public List<ChessboardPoint> getCanMovePoints1(ChessboardPoint source) {
        return null;

    }
    public boolean newMove1(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[targetX][targetY].getChessColor().equals(chessComponents[sourceX][sourceY].getChessColor()))
            return false;
        ChessComponent component = chessComponents[sourceX][sourceY];
        if (!component.canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            return false;
        } else {
            if (component instanceof PawnChessComponent) {
                if (sourceX == targetX) {
                    if (Math.abs(sourceY - targetY) == 1
                            && chessComponents[targetX][targetY].getChessColor().equals(ChessColor.NONE)) {
                        return true;
                    }
                    return Math.abs(sourceY - targetY) == 2
                            && chessComponents[targetX][targetY].getChessColor().equals(ChessColor.NONE)
                            && chessComponents[targetX][(targetY + sourceY) / 2].getChessColor().equals(ChessColor.NONE);
                } else {
                    return false;
                }
            } else if (component instanceof KnightChessComponent
                    || component instanceof KingChessComponent) {
                return true;
            } else {
                int dx = Integer.compare(targetX - sourceX, 0);
                int dy = Integer.compare(targetY - sourceY, 0);
                int x = sourceX + dx;
                int y = sourceY + dy;
                return true;
            }
        }
    }
    public int mapAdded(char c) {
        switch (c) {
            case 'K':
            case 'k':
                return 6;
            case 'Q':
            case 'q':
                return 5;
            case 'R':
            case 'r':
                return 4;
            case 'B':
            case 'b':
                return 3;
            case 'N':
            case 'n':
                return 2;
            case 'P':
            default:
                return -1;
        }
    }

    public String newgetCapturedChess1(ChessColor player) {
        Map<Character, Integer> capturedChess = new HashMap<>();
        capturedChess.put('P', 8);
        capturedChess.put('p', 8);
        capturedChess.put('K', 1);
        capturedChess.put('k', 1);
        capturedChess.put('Q', 1);
        capturedChess.put('q', 1);
        capturedChess.put('R', 2);
        for (ChessComponent[] chessComponent : chessComponents) {
            for (ChessComponent component : chessComponent) {
                if (!component.getChessColor().equals(ChessColor.NONE)) {
                    capturedChess.merge(component.a, -1, Integer::sum);
                }
            }
        }
        return null;
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder builder = new StringBuilder();
        int[] acid = new int[12];
        int[] base = new int[12];
        for (int i=1; i<13; i++){
            acid[i-1] = 0;
        }
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                switch (chessComponents[i][j].a) {
                    case 'B' -> acid[0]++;
                    case 'K' -> acid[1]++;
                    case 'N' -> acid[2]++;
                    case 'P' -> acid[3]++;
                    case 'Q' -> acid[4]++;
                    case 'R' -> acid[5]++;
                    case 'b' -> acid[6]++;
                    case 'k' -> acid[7]++;
                    case 'n' -> acid[8]++;
                    case 'p' -> acid[9]++;
                    case 'q' -> acid[10]++;
                    case 'r' -> acid[11]++;
                }
            }
        }
        base[11] = 2-acid[11];
        base[10] = 1-acid[10];
        base[9] = 8-acid[9];
        base[8] = 2-acid[8];
        base[7] = 1-acid[7];
        base[6] = 2-acid[6];
        base[5] = 2-acid[5];
        base[4] = 1-acid[4];
        base[3] = 8-acid[3];
        base[2] = 2-acid[2];
        base[1] = 1-acid[1];
        base[0] = 2-acid[0];
        if (base[7] != 0&&player==ChessColor.WHITE){
            builder.append('k');
            builder.append(' ');
            builder.append(base[7]);
            builder.append("\n");
        }
        if (base[10] != 0&&player==ChessColor.WHITE){
            builder.append('q');
            builder.append(' ');
            builder.append(base[10]);
            builder.append("\n");
        }
        if (base[11] != 0&&player==ChessColor.WHITE){
            builder.append('r');
            builder.append(' ');
            builder.append(base[11]);
            builder.append("\n");
        }
        if (base[6] != 0&&player==ChessColor.WHITE){
            builder.append('b');
            builder.append(' ');
            builder.append(base[6]);
            builder.append("\n");
        }
        if (base[8] != 0&&player==ChessColor.WHITE){
            builder.append('n');
            builder.append(' ');
            builder.append(base[8]);
            builder.append("\n");
        }
        if (base[9] != 0&&player==ChessColor.WHITE){
            builder.append('p');
            builder.append(' ');
            builder.append(base[9]);
            builder.append("\n");
        }
        if (base[1] != 0&&player == ChessColor.BLACK){
            builder.append('K');
            builder.append(' ');
            builder.append(base[1]);
            builder.append("\n");
            }
        if (base[4] != 0&&player == ChessColor.BLACK){
            builder.append('Q');
            builder.append(' ');
            builder.append(base[4]);
            builder.append("\n");
        }
        if (base[5] != 0&&player == ChessColor.BLACK){
            builder.append('R');
            builder.append(' ');
            builder.append(base[5]);
            builder.append("\n");
        }
        if (base[0] != 0&&player == ChessColor.BLACK){
            builder.append('B');
            builder.append(' ');
            builder.append(base[0]);
            builder.append("\n");
        }
        if (base[2] != 0&&player == ChessColor.BLACK) {
            builder.append('N');
            builder.append(' ');
            builder.append(base[2]);
            builder.append("\n");
        }
        if (base[3] != 0&&player == ChessColor.BLACK) {
            builder.append('P');
            builder.append(' ');
            builder.append(base[3]);
            builder.append("\n");
        }
        return builder.toString();
    }
    public ConcreteChessGame() {
        begin();
    }
    private void begin() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i= 0; i<8; i++){
            for (int j= 0; j<8; j++){
                char s = chessboard.get(i).charAt(j);
                switch (s) {
                    case 'B' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.BLACK, 'B');
                    case '_' -> chessComponents[i][j] = new EmptyChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.NONE, '_');
                    case 'K' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.BLACK, 'K');
                    case 'N' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.BLACK, 'N');
                    case 'P' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.BLACK, 'P');
                    case 'Q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.BLACK, 'Q');
                    case 'R' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.BLACK, 'R');
                    case 'b' -> chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.WHITE, 'b');
                    case 'k' -> chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.WHITE, 'k');
                    case 'n' -> chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.WHITE, 'n');
                    case 'p' -> chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.WHITE, 'p');
                    case 'q' -> chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.WHITE, 'q');
                    case 'r' -> chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessComponents, ChessColor.WHITE, 'r');
                }
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }else {
            currentPlayer = ChessColor.BLACK;
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }
    @Override
    public ChessComponent getChess(int a, int b) {
        return chessComponents[a][b];
    }
    public ChessComponent[][] getChessComponents(){
        return chessComponents;
    }
    public String newgetChessboardGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                sb.append(chessComponents[i][j].a);
            }
            if (i != 7) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    @Override
    public String getChessboardGraph() {
        StringBuilder[] str1 = new StringBuilder[8];
        for (int a=0; a<8; a++){
            str1[a] = new StringBuilder("0");
        }for (int a= 0; a<8; a++){
            for (int b=0; b<8; b++){
                str1[a].append(chessComponents[a][b].a);
            }
        }

        return str1[0].substring(1,9) + "\n" + str1[1].substring(1,9) +"\n" +str1[2].substring(1,9) + "\n" +str1[3].substring(1,9) +"\n"+str1[4].substring(1,9)+"\n"+str1[5].substring(1,9)+"\n"+str1[6].substring(1,9) +"\n" +str1[7].substring(1,9);
    }
    public boolean newmoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor()))
            return false;
        if (true) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            return true;
        }
        return false;
    }
    @Override
    public boolean moveChess(int pointX, int pointY, int targetX, int targetY) {
        for (int a = 0;a < 8;a++) {
            for (int b=0; b<8; b++){
                System.out.print(chessComponents[a][b].a);
            }
            System.out.println(" ");
        }
        System.out.println(getCapturedChess(ChessColor.WHITE));
        boolean a=chessComponents[pointX][pointY].getChessColor().equals(currentPlayer);
        if (a) {
            if (getCanMovePoints(chessComponents[pointX][pointY].getpoint()).contains(chessComponents[targetX][targetY].getpoint())) {
                chessComponents[targetX][targetY] = chessComponents[pointX][pointY];
                chessComponents[targetX][targetY].setpoint(new ChessboardPoint(targetX,targetY));
                chessComponents[pointX][pointY] = new EmptyChessComponent(new ChessboardPoint(pointX,pointY), chessComponents, ChessColor.NONE, '_');
                if (getCurrentPlayer() == ChessColor.WHITE) {
                    currentPlayer = ChessColor.BLACK;
                } else {
                    currentPlayer = ChessColor.WHITE;
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint point) {
        ChessComponent component = chessComponents[point.getX()][point.getY()];
        List<ChessboardPoint> canMovePoints = component.canMoveTo();
        canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return canMovePoints;
    }
    private void init1() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }
    public ChessColor newgetCurrentPlayer1() {
        return currentPlayer;
    }
    public ChessComponent newgetChess(int x, int y) {
        return chessComponents[x][y];
    }
    
}
