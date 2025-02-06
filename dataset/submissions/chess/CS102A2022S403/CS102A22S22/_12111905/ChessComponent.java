import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public static ChessComponent[][] chessComponents;

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent() {
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>can=new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        int[] dx = {0,1,1,1,0,-1,-1,-1};
        int[] dy = {1,1,0,-1,-1,-1,0,1};
        for (int i = 0; i < 8; i++) {
            if (x + dx[i] < 8 && x + dx[i] >= 0 && y + dy[i] < 8 && y + dy[i] >= 0 &&
                    chessComponents[x + dx[i]][y + dy[i]].getChessColor() != chessComponents[x][y].getChessColor()) {
                can.add(new ChessboardPoint(x + dx[i], y + dy[i]));
            }
        }
        return can;
    }

}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>can=new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i=1;x+i<=7;i++){
            if (chessComponents[x+i][y].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x+i,y));
                if (chessComponents[x+i][y].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;x-i>=0;i++){
            if (chessComponents[x-i][y].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x-i,y));
                if (chessComponents[x-i][y].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y+i<=7;i++){
            if (chessComponents[x][y+i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x,y+i));
                if (chessComponents[x][y+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y-i>=0;i++){
            if (chessComponents[x][y-i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x,y-i));
                if (chessComponents[x][y-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y+i<=7&&x+i<=7;i++){
            if (chessComponents[x+i][y+i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x+i,y+i));
                if (chessComponents[x+i][y+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }

        for (int i=1;y-i>=0&&x-i>=0;i++){
            if (chessComponents[x-i][y-i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x-i,y-i));
                if (chessComponents[x-i][y-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y+i<=7&&x-i>=0;i++){
            if (chessComponents[x-i][y+i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x-i,y+i));
                if (chessComponents[x-i][y+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y-i>=0&&x+i<=7;i++){
            if (chessComponents[x+i][y-i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x+i,y-i));
                if (chessComponents[x+i][y-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        return can;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint>can=new ArrayList<>();
        for (int i=1;x+i<=7;i++){
            if (chessComponents[x+i][y].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x+i,y));
                if (chessComponents[x+i][y].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;x-i>=0;i++){
            if (chessComponents[x-i][y].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x-i,y));
                if (chessComponents[x-i][y].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y+i<=7;i++){
            if (chessComponents[x][y+i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x,y+i));
                if (chessComponents[x][y+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y-i>=0;i++){
            if (chessComponents[x][y-i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x,y-i));
                if (chessComponents[x][y-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        return can;
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint>can=new ArrayList<>();
        for (int i=1;y+i<=7&&x+i<=7;i++){
            if (chessComponents[x+i][y+i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x+i,y+i));
                if (chessComponents[x+i][y+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }

        for (int i=1;y-i>=0&&x-i>=0;i++){
            if (chessComponents[x-i][y-i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x-i,y-i));
                if (chessComponents[x-i][y-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y+i<=7&&x-i>=0;i++){
            if (chessComponents[x-i][y+i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x-i,y+i));
                if (chessComponents[x-i][y+i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        for (int i=1;y-i>=0&&x+i<=7;i++){
            if (chessComponents[x+i][y-i].getChessColor()!=chessComponents[x][y].getChessColor()){
                can.add(new ChessboardPoint(x+i,y-i));
                if (chessComponents[x+i][y-i].getChessColor()!=ChessColor.NONE){
                    break;
                }
            }else break;
        }
        return can;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint>can=new ArrayList<>();
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        for (int i = 0; i < 8; i++) {
            if (x + dx[i] < 8 && x + dx[i] >= 0 && y + dy[i] < 8 && y + dy[i] >= 0 &&
                    chessComponents[x + dx[i]][y + dy[i]].getChessColor() != chessComponents[x][y].getChessColor()) {
                can.add(new ChessboardPoint(x + dx[i], y + dy[i]));
            }
        }
        return can;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint>can=new ArrayList<>();
        if (chessComponents[x][y].getChessColor() == ChessColor.WHITE) {
            if (x > 0 && chessComponents[x-1][y].getChessColor() == ChessColor.NONE) {
                can.add(new ChessboardPoint(x-1, y ));
            }
            if (x == 6 && chessComponents[x-1][y].getChessColor() == ChessColor.NONE &&
                    chessComponents[x-2][y].getChessColor() == ChessColor.NONE) {
                can.add(new ChessboardPoint(x-2, y ));
            }
            if (y > 0 && x > 0 && chessComponents[x - 1][y - 1].getChessColor() == ChessColor.BLACK) {
                can.add(new ChessboardPoint(x - 1, y - 1));
            }
            if (x > 0 && y < 7 && chessComponents[x + 1][y + 1].getChessColor() == ChessColor.BLACK) {
                can.add(new ChessboardPoint(x - 1, y + 1));
            }
        } else {
            if (x < 7 && chessComponents[x+1][y].getChessColor() == ChessColor.NONE) {
                can.add(new ChessboardPoint(x+1, y));
            }
            if (x == 1 && chessComponents[x+1][y].getChessColor() == ChessColor.NONE &&
                    chessComponents[x+2][y].getChessColor() == ChessColor.NONE) {
                can.add(new ChessboardPoint(x+2, y ));
            }
            if (x < 7 && y > 0 && chessComponents[x + 1][y - 1].getChessColor() == ChessColor.WHITE) {
                can.add(new ChessboardPoint(x + 1, y - 1));
            }
            if (y < 7 && x < 7 && chessComponents[x + 1][y + 1].getChessColor() == ChessColor.WHITE) {
                can.add(new ChessboardPoint(x + 1, y + 1));
            }
        }
        return can;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}