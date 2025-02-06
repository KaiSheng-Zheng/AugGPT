import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;

    public RookChessComponent() {
        super();
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> list = new ArrayList<>();
        int x = this.source.getX();
        int y = this.source.getY();


        for (int i=x+1;i<8;i++) {
            if (chessComponent[i][y].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(i,y));

                if (chessComponent[i][y].getChessColor() != ChessColor.NONE) {
                    break;
                }
            } else {
                break;
            }
        }



        for (int i=y+1;i<8;i++) {
            if (chessComponent[x][i].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(x,i));

                if (chessComponent[x][i].getChessColor() != ChessColor.NONE) {
                    break;
                }
            } else {
                break;
            }
        }


        for (int i=x-1;i>=0;i--) {
            if (chessComponent[i][y].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(i,y));

                if (chessComponent[i][y].getChessColor() != ChessColor.NONE) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i=y-1;i>=0;i--) {
            if (chessComponent[x][i].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(x,i));

                if (chessComponent[x][i].getChessColor() != ChessColor.NONE) {
                    break;
                }
            } else {
                break;
            }
        }

        if (list.size() != 0) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }


    @Override
    public void setSource(int targetX, int targetY) {
        this.source = new ChessboardPoint(targetX,targetY);
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public ChessboardPoint getChessboardPoint() {
        return super.getChessboardPoint();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
