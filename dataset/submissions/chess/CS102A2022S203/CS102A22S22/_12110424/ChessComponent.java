import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] components=new ChessComponent[8][8];

    public ChessComponent[][] getComponents() {
        return components;
    }

    public void setComponents(ChessComponent[][] components) {
        this.components = components;
    }

    public ChessComponent() {}
    public abstract List<ChessboardPoint> canMoveTo();
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public List<ChessboardPoint> up(int up){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<up;n++){
            if (n!=0&&source.getX()-n>=0) {
                if (components[source.getX() - n][source.getY()].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX()-n, source.getY()));
                } else {
                    if (chessColor!=components[source.getX() - n][source.getY()].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX()-n, source.getY()));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> down(int down){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<down;n++){
            if (n!=0&&source.getX()+n<8) {
                if (components[source.getX() + n][source.getY()].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX()+n, source.getY()));
                } else {
                    if (chessColor!=components[source.getX() + n][source.getY()].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX()+n, source.getY()));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> left(int left){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<left;n++){
            if (n!=0&&source.getY()-n>=0) {
                if (components[source.getX() ][source.getY()-n].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX(), source.getY()-n));
                } else {
                    if (chessColor!=components[source.getX()][source.getY()-n].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX(), source.getY()-n));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> right(int right){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<right;n++){
            if (n!=0&&source.getY()+n<8) {
                if (components[source.getX()][source.getY()+n].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX(), source.getY()+n));
                } else {
                    if (chessColor!=components[source.getX() ][source.getY()+n].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX(), source.getY()+n));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> leftUp(int leftUp){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<leftUp;n++){
            if (n!=0&&source.getY()-n>=0&&source.getX()-n>=0) {
                if (components[source.getX()-n ][source.getY()-n].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX()-n, source.getY()-n));
                } else {
                    if (chessColor!=components[source.getX()-n][source.getY()-n].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX()-n, source.getY()-n));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> rightUp(int rightUp){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<rightUp;n++){
            if (n!=0&&source.getY()+n<8&&source.getX()-n>=0) {
                if (components[source.getX()-n ][source.getY()+n].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX()-n, source.getY()+n));
                } else {
                    if (chessColor!=components[source.getX()-n][source.getY()+n].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX()-n, source.getY()+n));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> leftDown(int leftDown){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<leftDown;n++){
            if (n!=0&&source.getY()-n>=0&&source.getX()+n<8) {
                if (components[source.getX()+n ][source.getY()-n].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX()+n, source.getY()-n));
                } else {
                    if (chessColor!=components[source.getX()+n][source.getY()-n].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX()+n, source.getY()-n));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
    public List<ChessboardPoint> rightDown(int rightDown){
        List<ChessboardPoint> canMove = new ArrayList<>();
        for (int n =0;n<rightDown;n++){
            if (n!=0&&source.getY()+n<8&&source.getX()+n<8) {
                if (components[source.getX()+n ][source.getY()+n].getChessColor() == ChessColor.NONE) {
                    canMove.add(new ChessboardPoint(source.getX()+n, source.getY()+n));
                } else {
                    if (chessColor!=components[source.getX()+n][source.getY()+n].getChessColor()){
                        canMove.add(new ChessboardPoint(source.getX()+n, source.getY()+n));
                    }
                    break;
                }
            }
        }
        return canMove;
    }
}