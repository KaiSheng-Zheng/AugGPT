import java.util.ArrayList;
import java.util.List;


public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0, 0);
    private ChessColor chessColor;
    private int power;
    private ChessComponent[][] chessComponents;

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getPower() {
        return power;
    }


    public KingChessComponent(int x, int y, char name,ChessComponent[][] chessComponents) {
        this.source.setX(x);
        this.source.setY(y);
        this.setChessColor(name);
        super.name = name;
        this.setCnt(name);
        this.chessComponents = chessComponents;
        super.setSource(new ChessboardPoint(x,y));
    }

    public void setChessColor(char name) {
        if (name == 'k') {
            this.chessColor = ChessColor.WHITE;
        }
        if (name == 'K') {
            this.chessColor = ChessColor.BLACK;
        }
    }

    public void setCnt(char name) {
        if (name == 'k') {
            this.power = 1;
        }
        if (name == 'K') {
            this.power = -1;
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
        if (source.getX() == destination.getX()&&Math.abs(destination.getY()-source.getY())==1) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()&&Math.abs(destination.getX()-source.getX())==1) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }else if (source.getX()+source.getY() == destination.getX()+destination.getY()&&Math.abs(destination.getX()-source.getX())==1) {
            int row = source.getX()+source.getY();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row-col][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY()-source.getX() == destination.getY()-destination.getX()&&Math.abs(destination.getX()-source.getX())==1) {
            int n = source.getY()-source.getX();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][n+row] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }
}