import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ConcreteChessGame Game;

    public void setChessGame(ConcreteChessGame chessGame) {
        this.Game = chessGame;
    }

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public boolean isBlack(){
        return this.chessColor == ChessColor.BLACK;
    }

    public boolean isHeng(ChessboardPoint targetPoint){
        return targetPoint.getX() == source.getX();
    }

    public boolean isShu(ChessboardPoint targetPoint){
        return targetPoint.getY() == source.getY();
    }

    public boolean isXie(ChessboardPoint targetPoint){
        return Math.abs(targetPoint.getX() - source.getX()) == Math.abs(targetPoint.getY() - source.getY());
    }

    public boolean notPrevented(ChessboardPoint targetPoint){
        if (isHeng(targetPoint)){
            for (int i = Math.min(targetPoint.getY(),source.getY()) + 1; i < Math.max(targetPoint.getY(),source.getY()); i++) {
                if (Game.getChess(source.getX(),i).getChessColor() != ChessColor.NONE){
                    return false;
                }
            }
            return true;
        }
        if (isShu(targetPoint)){
            for (int i = Math.min(targetPoint.getX(),source.getX()) + 1; i < Math.max(targetPoint.getX(),source.getX()); i++) {
                if (Game.getChess(i,source.getY()).getChessColor() != ChessColor.NONE){
                    return false;
                }
            }
            return true;
        }
        if (isXie(targetPoint)){
            boolean direction = (source.getX()-targetPoint.getX() == source.getY()-targetPoint.getY()); //if true: -> \ if false: -> /
            int gap = Math.abs(source.getX() - targetPoint.getX());
            if (direction){
                for (int i = 1; i < gap; i++) {
                    if (Game.getChess((Math.min(source.getX(),targetPoint.getX()) + i),(Math.min(source.getY(),targetPoint.getY()) + i)).getChessColor() != ChessColor.NONE){
                        return false;
                    }
                }
            }else {
                for (int i = 1; i < gap; i++) {
                    if (Game.getChess(Math.min(source.getX(),targetPoint.getX()) + i,Math.max(source.getY(),targetPoint.getY()) - i).getChessColor() != ChessColor.NONE){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean notOut(ChessboardPoint point,int dx,int dy){
        return point.getX() + dx >= 0 && point.getX() + dx <= 7 && point.getY() + dy >= 0 && point.getY() + dy <= 7;
    }
}