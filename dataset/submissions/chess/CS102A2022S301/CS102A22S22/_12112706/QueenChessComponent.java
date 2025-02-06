import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {

        this.chessColor=chessColor;
        super.source = source;
        if (super.chessColor.getName().equals("Black"))
            super.name = 'Q';
        if (super.chessColor.getName().equals("White"))
            super.name = 'q';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList output = new ArrayList<ChessboardPoint>();
        for (int i = -1; i + source.getX() >= 0 &&i + source.getY() >= 0; i--) {
            if (chessComponents[source.getX() + i][source.getY()+i] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX() + i, source.getY()+i));
            else if (chessComponents[source.getX() + i][source.getY()+i].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX() + i, source.getY()+i));
                break;
            }else break;
        }for (int i = 1; i + source.getX() < 8&&i+source.getY()<8; i++) {
            if (chessComponents[source.getX() + i][source.getY()+i] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX() + i, source.getY()+i));
            else if (chessComponents[source.getX() + i][source.getY()+i].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX() + i, source.getY()+i));
                break;
            }else break;
        }
        for (int i = 1; i + source.getY() < 8&&source.getX()-i>=0; i++) {
            if (chessComponents[source.getX()-i][source.getY() + i] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX()-i, source.getY() + i));
            else if (chessComponents[source.getX()-i][source.getY() + i].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX()-i, source.getY() + i));
                break;
            }else break;
        }
        for (int i = -1; i + source.getY() >= 0&&source.getX()-i<8; i--) {
            if (chessComponents[source.getX()-i][source.getY() + i] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX()-i, source.getY() + i));
            else if (chessComponents[source.getX()-i][source.getY()+i].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX()-i, source.getY() + i));
                break;
            }else break;
        }
        for (int i = -1; i + source.getX() >= 0; i--) {
            if (chessComponents[source.getX() + i][source.getY()] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX() + i, source.getY()));
            else if (chessComponents[source.getX() + i][source.getY()].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX() + i, source.getY()));
                break;
            }else break;
        }for (int i = 1; i + source.getX() < 8; i++) {
            if (chessComponents[source.getX() + i][source.getY()] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX() + i, source.getY()));
            else if (chessComponents[source.getX() + i][source.getY()].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX() + i, source.getY()));
                break;
            }else break;
        }
        for (int i = 1; i + source.getY() < 8; i++) {
            if (chessComponents[source.getX()][source.getY() + i] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX(), source.getY() + i));
            else if (chessComponents[source.getX()][source.getY() + i].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX(), source.getY() + i));
                break;
            }else break;
        }
        for (int i = -1; i + source.getY() >= 0; i--) {
            if (chessComponents[source.getX()][source.getY() + i] instanceof EmptySlotComponent)
                output.add(new ChessboardPoint(source.getX(), source.getY() + i));
            else if (chessComponents[source.getX() ][source.getY()+i].chessColor.getName() != chessComponents[source.getX()][source.getY()].chessColor.getName()) {
                output.add(new ChessboardPoint(source.getX(), source.getY() + i));
                break;
            }else break;
        }
        return output;
    }

    public String toString() {
        return String.valueOf(this.name);
    }
}