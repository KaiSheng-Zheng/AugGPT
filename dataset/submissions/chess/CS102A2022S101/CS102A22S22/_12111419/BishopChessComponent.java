import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;

    public BishopChessComponent() {
        super();
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
        this.chessColor = chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        int x = this.source.getX();
        int y = this.source.getY();


        for (int i=x+1,j=y+1;i<8 && j<8;i++,j++) {
            if (chessComponent[i][j].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(i,j));
            } else {
                break;
            }

            if (chessComponent[i][j].getChessColor() != ChessColor.NONE && chessComponent[i][j].getChessColor() != this.chessColor) {
                break;
            }
        }


        for (int i=x-1,j=y-1;i>=0 && j>=0;i--,j--) {
            if (chessComponent[i][j].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(i,j));
            } else {
                break;
            }

            if (chessComponent[i][j].getChessColor() != ChessColor.NONE && chessComponent[i][j].getChessColor() != this.chessColor) {
                break;
            }

        }


        for (int i=x+1,j=y-1;i<8 && j>=0;i++,j--) {
            if (chessComponent[i][j].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(i,j));


            } else {
                break;
            }


            if (chessComponent[i][j].getChessColor() != ChessColor.NONE && chessComponent[i][j].getChessColor() != this.chessColor) {
                break;
            }

        }



        for (int i=x-1,j=y+1;i>=0 && j<8;i--,j++) {
            if (chessComponent[i][j].getChessColor() != this.chessColor) {

                list.add(new ChessboardPoint(i,j));


            } else {
                break;
            }


            if (chessComponent[i][j].getChessColor() != ChessColor.NONE && chessComponent[i][j].getChessColor() != this.chessColor) {
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