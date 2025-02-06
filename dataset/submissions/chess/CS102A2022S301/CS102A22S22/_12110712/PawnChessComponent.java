import java.util.ArrayList;
import java.util.List;


public class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0, 0);
    private ChessColor chessColor;
    private int power;
    private ChessComponent[][] chessComponents;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getPower() {
        return power;
    }

    public PawnChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.source.setX(x);
        this.source.setY(y);
        this.setChessColorAndOriginY(name);
        super.name = name;
        this.setCnt(name);
        this.chessComponents = chessComponents;
        super.setSource(new ChessboardPoint(x,y));
    }

    public char getName() {
        return name;
    }

    public void setChessColorAndOriginY(char name) {
        if (name == 'p') {
            this.chessColor = ChessColor.WHITE;
        }
        if (name == 'P') {
            this.chessColor = ChessColor.BLACK;
        }
    }

    public void setCnt(char name) {
        if (name == 'p') {
            this.power = 6;
        }
        if (name == 'P') {
            this.power = -6;
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                ChessboardPoint chessboardPoint=new ChessboardPoint(i,j);
                if (couldMoveTo(chessComponents,chessboardPoint)&&chessComponents[i][j].getChessColor()!=this.getChessColor()){
                    canMove.add(new ChessboardPoint(i,j));}}}
        return canMove;
    }
    public boolean couldMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if ((source.getY() == destination.getY())&&source.getX()==6
                &&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE
                &&((destination.getX()-source.getX())>=-2)&&((destination.getX()-source.getX()))<0) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX());
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else if (source.getY() == destination.getY()&&source.getX()==1
                &&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK
                &&((destination.getX()-source.getX())<=2)&&((destination.getX()-source.getX())>0)) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX())+1; row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }else if (source.getY() == destination.getY()&&(destination.getX()-source.getX())==-1
                &&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE
        ) {
            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return false;
            }
        }
        else if (source.getY() == destination.getY()&&(destination.getX()-source.getX())==1
                &&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK
        ) {
            if (!(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return false;
            }
        }else if ((destination.getX()-source.getX())==-1&&Math.abs(destination.getY()-source.getY())==1
                &&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.WHITE) {
            if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return false;
            }}
        else if ((destination.getX()-source.getX())==1&&Math.abs(destination.getY()-source.getY())==1
                &&chessComponents[source.getX()][source.getY()].getChessColor()==ChessColor.BLACK) {
            if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                return false;
            }}
        else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }

}