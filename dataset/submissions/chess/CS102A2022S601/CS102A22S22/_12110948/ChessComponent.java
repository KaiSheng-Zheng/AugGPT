import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ConcreteChessGame Game;

    //should design
    public ChessComponent(){}

    public ChessboardPoint getSource() {
        return source;
    }
    public void setChessGame(ConcreteChessGame chessGame) {
        this.Game = chessGame;
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

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {return String.valueOf(this.name);}

    public boolean inGraph(ChessboardPoint point,int dx,int dy){
        return point.getX() + dx >= 0 && point.getX() + dx <= 7 && point.getY() + dy >= 0 && point.getY() + dy <= 7;
    }
    public boolean notSelf(ChessboardPoint source,int x,int y){
        return Game.getChess(source.getX(),source.getY()).chessColor != Game.getChess(x,y).chessColor;
    }

    public boolean canVertical(ChessboardPoint source,ChessboardPoint targetSource){
        if(Math.abs(source.getX() - targetSource.getX()) == 1){
           return notSelf(source,targetSource.getX(),targetSource.getY());
        }
        int j = Math.min(source.getX(),targetSource.getX());
        while (j + 1 < Math.max(source.getX(),targetSource.getX())){
            if (Game.getChess(j + 1,source.getY()).chessColor != ChessColor.NONE){
                return false;
            }
            j++;
        }
        return true;
    }

    public boolean canCross(ChessboardPoint source,ChessboardPoint targetSource){
        if(Math.abs(source.getY() - targetSource.getY()) == 1){
            return notSelf(source,targetSource.getX(),targetSource.getY());
        }
        int i = Math.min(source.getY(),targetSource.getY());
        while (i + 1 < Math.max(source.getY(),targetSource.getY())){
            if(Game.getChess(source.getX(),i + 1).chessColor != ChessColor.NONE){
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean canSlope(ChessboardPoint source,ChessboardPoint targetSource){
        if(Math.abs(source.getX() - targetSource.getX()) == Math.abs(source.getY() - targetSource.getY()) && Math.abs(source.getY() - targetSource.getY()) == 1){
            return notSelf(source,targetSource.getX(),targetSource.getY());
        }
        int x = source.getX();
        int y = source.getY();
        if(x  < targetSource.getX() && y < targetSource.getY()){
            while (x + 1< targetSource.getX()){
                if(Game.getChess(x + 1,y + 1).getChessColor() != ChessColor.NONE){
                    return false;
                }
                x++;
                y++;
            }
        }else if(x  < targetSource.getX() && y > targetSource.getY()){
            while (x + 1 < targetSource.getX()){
                if(Game.getChess(x + 1,y - 1).getChessColor() != ChessColor.NONE){
                    return false;
                }
                x++;
                y--;
            }
        }else if(x > targetSource.getX() && y > targetSource.getY()) {
            while (x - 1 > targetSource.getX()) {
                if (Game.getChess(x - 1, y - 1).getChessColor() != ChessColor.NONE) {
                    return false;
                }
                x--;
                y--;
            }
        }else if(x > targetSource.getX() && y < targetSource.getY()) {
            while (x - 1 > targetSource.getX()) {
                if (Game.getChess(x - 1, y + 1).getChessColor() != ChessColor.NONE) {
                    return false;
                }
                x--;
                y++;
            }
        }
        return true;
    }
    public boolean noChess(ChessboardPoint source,ChessboardPoint targetSource) {
        if (source.getY() == targetSource.getY()) {
            return canVertical(source, targetSource);
        } else if (source.getX() == targetSource.getX()) {
            return canCross(source, targetSource);
        } else if (Math.abs(source.getX() - targetSource.getX()) == Math.abs(source.getY() - targetSource.getY())) {
            return canSlope(source, targetSource);
        }
        return false;
    }
    public ChessColor currentPlayer(ChessboardPoint point){
        return Game.getChess(point.getX(),point.getY()).chessColor;
    }
}
