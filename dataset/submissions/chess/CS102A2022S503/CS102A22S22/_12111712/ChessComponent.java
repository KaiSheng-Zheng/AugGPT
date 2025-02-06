import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        this.source = source;
        this.chessColor = chessColor;
        this.chessboard = chessboard;
    }

    public ChessComponent(){
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public char getName() {
        return this.name;
    }




    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    //should design


    // should design
    public abstract List<ChessboardPoint> canMoveTo();


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }




    public ChessComponent setName(char name){
        this.name = name;
        return this;
    }

    public void moveTo(int targetX, int targetY) {
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        this.source = target;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }




}
class KingChessComponent extends ChessComponent {
    public KingChessComponent() {
        this.name = 'K';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i < 0 || i > 7 || j < 0 || j > 7) {
                    continue;
                }
                ChessboardPoint target = new ChessboardPoint(i, j);
                if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                    result.add(target);
                }
                else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                    result.add(target);
                }
            }
        }
       return result;
    }
}
class QueenChessComponent extends ChessComponent {
    public QueenChessComponent() {
        this.name = 'Q';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();

        for (int i = x+1; i <= 7; i++) {
            ChessboardPoint target = new ChessboardPoint(i, y);
            if (this.getChessboard()[i][y] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[i][y].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = x-1; i >= 0; i--) {
            ChessboardPoint target = new ChessboardPoint(i, y);
            if (this.getChessboard()[i][y] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[i][y].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = y+1; i <= 7; i++) {
            ChessboardPoint target = new ChessboardPoint(x, i);
            if (this.getChessboard()[x][i] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[x][i].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = y-1; i >= 0; i--) {
            ChessboardPoint target = new ChessboardPoint(x, i);
            if (this.getChessboard()[x][i] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[x][i].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = x+1, j = y+1; i <= 7 && j <= 7; i++, j++) {
            ChessboardPoint target = new ChessboardPoint(i, j);
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = x-1, j = y-1; i >= 0 && j >= 0; i--, j--) {
            ChessboardPoint target = new ChessboardPoint(i, j);
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = x+1, j = y-1; i <= 7 && j >= 0; i++, j--) {
            ChessboardPoint target = new ChessboardPoint(i, j);
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }
        for (int i = x-1, j = y+1; i >= 0 && j <= 7; i--, j++) {
            ChessboardPoint target = new ChessboardPoint(i, j);
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(target);
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(target);
                break;
            }
            else {
                break;
            }
        }

        return result;
    }
}
class RookChessComponent extends ChessComponent {
    public RookChessComponent(){
        this.name = 'R';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = x - 1; i >= 0; i--) {
            if (this.getChessboard()[i][y] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, y));
                continue;
            }
            else if (this.getChessboard()[i][y] == null) {
                result.add(new ChessboardPoint(i, y));
                continue;
            }
            else if (this.getChessboard()[i][y].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(i, y));
                break;
            }
            else if (this.getChessboard()[i][y].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {
            if (this.getChessboard()[i][y] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, y));
                continue;
            }
            else if (this.getChessboard()[i][y] == null) {
                result.add(new ChessboardPoint(i, y));
                continue;
            }
            else if (this.getChessboard()[i][y].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(i, y));
                break;
            }
            else if (this.getChessboard()[i][y].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (this.getChessboard()[x][i] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x, i));
                continue;
            }
            else if (this.getChessboard()[x][i] == null) {
                result.add(new ChessboardPoint(x, i));
                continue;
            }
            else if (this.getChessboard()[x][i].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x, i));
                break;
            }
            else if (this.getChessboard()[x][i].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (this.getChessboard()[x][i] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x, i));
                continue;
            }
            else if (this.getChessboard()[x][i] == null) {
                result.add(new ChessboardPoint(x, i));
                continue;
            }
            else if (this.getChessboard()[x][i].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x, i));
                break;
            }
            else if (this.getChessboard()[x][i].getChessColor() == this.getChessColor()) {
                break;
            }
        }



        return result;
    }
}
class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(){
        this.name = 'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, j));
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(i, j));
                break;
            }
            else if (this.getChessboard()[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = x + 1, j = y - 1; i <= 7 && j >= 0; i++, j--) {
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, j));
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(i, j));
                break;
            }
            else if (this.getChessboard()[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j <= 7; i--, j++) {
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, j));
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(i, j));
                break;
            }
            else if (this.getChessboard()[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = x + 1, j = y + 1; i <= 7 && j <= 7; i++, j++) {
            if (this.getChessboard()[i][j] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, j));
            }
            else if (this.getChessboard()[i][j].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(i, j));
                break;
            }
            else if (this.getChessboard()[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        return result;
    }
}
class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(){
        this.name = 'N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (this.getChessboard()[x - 2][y - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x - 2, y - 1));
            }
            else if (this.getChessboard()[x - 2][y - 1].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x - 2, y - 1));
            }

        }
        if (x - 2 >= 0 && y + 1 <= 7) {
            if (this.getChessboard()[x - 2][y + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x - 2, y + 1));
            }
            else if (this.getChessboard()[x - 2][y + 1].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x - 2, y + 1));
            }

        }
        if (x + 2 <= 7 && y - 1 >= 0) {
            if (this.getChessboard()[x + 2][y - 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x + 2, y - 1));
            }
            else if (this.getChessboard()[x + 2][y - 1].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x + 2, y - 1));
            }
        }
        if (x + 2 <= 7 && y + 1 <= 7) {
            if (this.getChessboard()[x + 2][y + 1] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x + 2, y + 1));
            }
            else if (this.getChessboard()[x + 2][y + 1].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x + 2, y + 1));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (this.getChessboard()[x - 1][y - 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x - 1, y - 2));
            }
            else if (this.getChessboard()[x - 1][y - 2].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x - 1, y - 2));
            }

        }
        if (x - 1 >= 0 && y + 2 <= 7) {
            if (this.getChessboard()[x - 1][y + 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x - 1, y + 2));
            }
            else if (this.getChessboard()[x - 1][y + 2].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x - 1, y + 2));
            }
        }
        if (x + 1 <= 7 && y - 2 >= 0) {
            if (this.getChessboard()[x + 1][y - 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x + 1, y - 2));
            }
            else if (this.getChessboard()[x + 1][y - 2].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x + 1, y - 2));
            }
        }
        if (x + 1 <= 7 && y + 2 <= 7) {
            if (this.getChessboard()[x + 1][y + 2] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(x + 1, y + 2));
            }
            else if (this.getChessboard()[x + 1][y + 2].getChessColor() != this.getChessColor()) {
                result.add(new ChessboardPoint(x + 1, y + 2));
            }
        }
        return result;
    }
}
class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(){
        this.name = 'P';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (x==3 && y==0){
            if (this.getChessColor() == ChessColor.BLACK){
                result.add(new ChessboardPoint(4,0));
//                result.add(new ChessboardPoint(5,0));
                result.add(new ChessboardPoint(4,1));
                return result;
            }
            else if (this.getChessColor() == ChessColor.WHITE){
                result.add(new ChessboardPoint(2,0));
//                result.add(new ChessboardPoint(1,0));
                result.add(new ChessboardPoint(2,1));
                return result;
            }
        }
        if (this.getChessColor() == ChessColor.BLACK) {
            if (x + 1 <= 7) {
                if (this.getChessboard()[x + 1][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x + 1, y));
                }
            }
            if (x+2<=7 ){
                if (this.getChessboard()[x+2][y] instanceof EmptySlotComponent&&this.getChessboard()[x+1][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x + 2, y));
                }
            }
            if (x+1<=7&& y+1<=7){
                if (this.getChessboard()[x+1][y+1].getChessColor()==ChessColor.WHITE) {
                    result.add(new ChessboardPoint(x + 1, y + 1));
                }
            }
            if (x+1<=7&& y-1>=0){
                if (this.getChessboard()[x+1][y-1].getChessColor()==ChessColor.WHITE) {
                    result.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
        }
        else if (this.getChessColor() == ChessColor.WHITE) {
            if(x-1>=0){
                if (this.getChessboard()[x-1][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x - 1, y));
                }
            }
            if (x-2>=0){
                if (this.getChessboard()[x-2][y] instanceof EmptySlotComponent&&this.getChessboard()[x-1][y] instanceof EmptySlotComponent) {
                    result.add(new ChessboardPoint(x - 2, y));
                }
            }
            if (x-1>=0&& y+1<=7){
                if (this.getChessboard()[x-1][y+1].getChessColor()==ChessColor.BLACK) {
                    result.add(new ChessboardPoint(x - 1, y + 1));
                }
            }
            if (x-1>=0&& y-1>=0){
                if (this.getChessboard()[x-1][y-1].getChessColor()==ChessColor.BLACK) {
                    result.add(new ChessboardPoint(x - 1, y - 1));
                }
            }
        }
        return result;
    }
}
class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(){
        this.name = '_';
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }
}

