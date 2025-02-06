import java.util.ArrayList;
import java.util.List;


public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0, 0);
    private ChessColor chessColor;
    private int cnt;
    private ChessComponent[][] chessComponents;

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public int getCnt() {
        return cnt;
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
            this.cnt = 1;
        }
        if (name == 'K') {
            this.cnt = -1;
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMove = new ArrayList<>();
        int X = this.source.getX();
        int Y = this.source.getY();
        int newX;
        int newY;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                newX = X+i;
                newY = Y+j;
                if (newX>-1&&newX<8&&newY>-1&&newY<8&&chessComponents[newX][newY].getChessColor() != this.getChessColor()){
                    canMove.add(new ChessboardPoint(newX,newY));
                }
            }
        }
        return canMove;
    }
}
