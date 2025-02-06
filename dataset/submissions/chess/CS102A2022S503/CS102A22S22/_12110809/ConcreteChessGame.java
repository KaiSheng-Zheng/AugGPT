import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame{

    public ConcreteChessGame(){
        c.captured = new ArrayList<>();
    }
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    @Override
    public void loadChessGame(List<String> chessboard) {
        c.map = new HashMap();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[j][i] = match(chessboard.get(i).charAt(j));
                chessComponents[j][i].to(j, i);
            }
        }

        currentPlayer = chessboard.get(8).equals("w") ? ChessColor.WHITE : ChessColor.BLACK;
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
        StringBuilder strB = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                strB.append(((ChessComponent) c.map.get(10*j+i)).name);
            }
            strB.append("\n");
        }
        return strB.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        if(player == ChessColor.NONE) return null;

        int[] simp = new int[6];
        String mark = "kqrbkp";

        for (ChessComponent cc:
             c.captured) {
            int ind = mark.indexOf(Character.toLowerCase(cc.name));
            if(ind != -1 && cc.getChessColor() == player) simp[ind]++;
        }

        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = simp[i];
            if (num != 0) {
                strB.append(mark.charAt(i) + " " + num + "\n");
            }
        }

        if(player == ChessColor.WHITE) return strB.toString();
        else return strB.toString().toUpperCase();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint) {
        int x = chessboardPoint.getX(), y = chessboardPoint.getY();

        if(x < 0 || x > 7 ||
                y < 0 || y > 7) return new ArrayList<ChessboardPoint>();

        ArrayList<ChessboardPoint> list = new ArrayList<>();
        list.addAll(chessComponents[x][y].canMoveTo());

        //sort

        return list;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX < 0 || sourceX > 7 ||
                sourceY < 0 || sourceY > 7 ||
                targetX < 0 || targetX > 7 ||
                targetY < 0 || targetY > 7) return false;

        ChessComponent current = chessComponents[sourceX][sourceY];
        ArrayList<ChessboardPoint> list = (ArrayList<ChessboardPoint>) current.canMoveTo();
        ChessboardPoint targetPoint = new ChessboardPoint(targetX, targetY);

        boolean judge = false;
        for (ChessboardPoint testPoint:
             list) {
            if(targetPoint.equals(testPoint)){
                judge = true;
                break;
            }
        }

        if(judge){
            current.to(targetX, targetY);
        }

        return judge;
    }

    //own methods
    ChessComponent match(char c){
        if(c == '_'){
            ChessComponent chessComponent = new EmptySlotComponent();
            chessComponent.name = c;
            chessComponent.setChessColor(ChessColor.NONE);
            return chessComponent;
        }
        boolean bla = false;
        if(Character.isUpperCase(c)) {
            bla = true;
            c = (char) (c+'a'-'A');
        }

        ChessComponent chessComponent = null;
        switch (c){
            case 'k':
                chessComponent = new KingChessComponent();
                chessComponent.name = c;
                break;
            case 'q':
                chessComponent = new QueenChessComponent();
                chessComponent.name = c;
                break;
            case 'b':
                chessComponent = new BishopChessComponent();
                chessComponent.name = c;
                break;
            case 'n':
                chessComponent = new KnightChessComponent();
                chessComponent.name = c;
                break;
            case 'r':
                chessComponent = new RookChessComponent();
                chessComponent.name = c;
                break;
            case 'p':
                chessComponent = new PawnChessComponent();
                chessComponent.name = c;
                break;
        }

        chessComponent.setChessColor(bla ? ChessColor.BLACK : ChessColor.WHITE);
        return chessComponent;
    }
}

interface ChessGame {
    void loadChessGame(List<String> chessboard);

    ChessColor getCurrentPlayer();

    ChessComponent getChess(int x, int y);

    String getChessboardGraph();

    public String getCapturedChess(ChessColor player);

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint chessboardPoint);

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY);


}

class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public ChessboardPoint offset(int dx, int dy){
        int nX = x+dx, nY = y+dy;
        if(nX < 0 || nX > 7 || nY < 0 || nY > 7){
            return null;
        }else {
            return new ChessboardPoint(nX, nY);
        }
    }

    public int code(){
        return 10*x+y;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ChessboardPoint)) return false;
        ChessboardPoint point = (ChessboardPoint) obj;
        return x == point.x && y == point.y;
    }

    //to string
    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    //GS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

enum ChessColor {
    BLACK, WHITE, NONE;
}















class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(){
        name = '_';
        setChessColor(ChessColor.NONE);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}

class KingChessComponent extends ChessComponent{

    static final int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static final int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int X = x()+dx[i], Y = y()+dy[i];

            if(X >= 0 && X <= 7 && Y >= 0 && Y <= 7 &&
            piece(X, Y).getChessColor() != getChessColor()){
                list.add(new ChessboardPoint(X, Y));
            }
        }
        return list;
    }
}

class KnightChessComponent extends ChessComponent{


    static final int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static final int[] dy = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int X = x()+dx[i], Y = y()+dy[i];

            if(X >= 0 && X <= 7 && Y >= 0 && Y <= 7 &&
                    piece(X, Y).getChessColor() != getChessColor()){
                list.add(new ChessboardPoint(X, Y));
            }
        }
        return list;
    }
}

class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> list = new ArrayList<>();

        ChessColor ene = getChessColor() == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
        int dy = getChessColor() == ChessColor.WHITE ? -1 : 1;
        int line = getChessColor() == ChessColor.WHITE ? 6 : 1;
        int ddl = getChessColor() == ChessColor.WHITE ? 0 : 7;

        if(y() != ddl &&
                piece(x(), y()+dy).getChessColor() == ChessColor.NONE){
            list.add(new ChessboardPoint(x(), y()+dy));

            if(y() == line &&
                    piece(x(), y()+2*dy).getChessColor() == ChessColor.NONE){
                list.add(new ChessboardPoint(x(), y()+2*dy));
            }
        }


        if(y() != ddl){

            int Y = y()+dy;

            if(x() != 0){
                int X = x()-1;
                if(piece(X, Y).getChessColor() == ene){
                    list.add(new ChessboardPoint(X, Y));
                }
            }

            if(x() != 7){
                int X = x()+1;
                if(piece(X, Y).getChessColor() == ene){
                    list.add(new ChessboardPoint(X, Y));
                }
            }
        }

        return list;
    }
}

class QueenChessComponent extends ChessComponent{

    static final int[] dx = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessColor ene = getChessColor() == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;

        for (int i = 0; i < 8; i++) {
            int X = x(), Y = y();
            do{
                X += dx[i];
                Y += dy[i];
                if(X >= 0 && X <= 7 && Y >= 0 && Y <= 7){
                    ChessColor ju = piece(X, Y).getChessColor();
                    if(ju == ChessColor.NONE){
                        list.add(new ChessboardPoint(X, Y));
                    } else if (ju == ene) {
                        list.add(new ChessboardPoint(X, Y));
                        break;
                    }else break;
                }else break;
            }while (true);
        }
        return list;
    }
}

class RookChessComponent extends ChessComponent{

    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessColor ene = getChessColor() == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;

        for (int i = 0; i < 4; i++) {
            int X = x(), Y = y();
            do{
                X += dx[i];
                Y += dy[i];
                if(X >= 0 && X <= 7 && Y >= 0 && Y <= 7){
                    ChessColor ju = piece(X, Y).getChessColor();
                    if(ju == ChessColor.NONE){
                        list.add(new ChessboardPoint(X, Y));
                    } else if (ju == ene) {
                        list.add(new ChessboardPoint(X, Y));
                        break;
                    }else break;
                }else break;
            }while (true);
        }
        return list;
    }
}

class BishopChessComponent extends ChessComponent{

    static int[] dx = new int[]{1, 1, -1, -1};
    static int[] dy = new int[]{1, -1, 1, -1};
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessColor ene = getChessColor() == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;

        for (int i = 0; i < 4; i++) {
            int X = x(), Y = y();
            do{
                X += dx[i];
                Y += dy[i];
                if(X >= 0 && X <= 7 && Y >= 0 && Y <= 7){
                    ChessColor ju = piece(X, Y).getChessColor();
                    if(ju == ChessColor.NONE){
                        list.add(new ChessboardPoint(X, Y));
                    } else if (ju == ene) {
                        list.add(new ChessboardPoint(X, Y));
                        break;
                    }else break;
                }else break;
            }while (true);
        }
        return list;
    }
}



class c{
    public static HashMap map = new HashMap();

    public static ArrayList<ChessComponent> captured = new ArrayList<ChessComponent>(){};
}



