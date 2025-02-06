import java.util.ArrayList;
import java.util.List;


public class KnightChessComponent extends ChessComponent {
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

    public KnightChessComponent(int x, int y, char name, ChessComponent[][] chessComponents) {
        this.source.setX(x);
        this.source.setY(y);
        this.setChessColor(name);
        super.name = name;
        this.setCnt(name);
        this.chessComponents = chessComponents;
        super.setSource(new ChessboardPoint(x,y));
    }

    public char getName() {
        return name;
    }

    public void setChessColor(char name) {
        if (name == 'n') {
            this.chessColor = ChessColor.WHITE;
        }
        if (name == 'N') {
            this.chessColor = ChessColor.BLACK;
        }
    }

    public void setCnt(char name) {
        if (name == 'n') {
            this.power = 5;
        }
        if (name == 'N') {
            this.power = -5;
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
        if (Math.pow((source.getX()-destination.getX()),2)+Math.pow((source.getY()-destination.getY()),2)==5) {
            return true;
        } else  // Not on the same row or the same column.
            return false;
    }
}