import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponent) {

        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponent;

        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);

    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint chess = getSource();

        List<ChessboardPoint> arrayList = new ArrayList<>();
        if (chess.getX() - 2 >= 0 && chess.getY() - 1 >= 0) {
            if (this.chessColor != chessComponents[chess.getX() - 2][chess.getY() - 1].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX() - 2, chess.getY() - 1));
            }
        }

        if (chess.getX() - 2 >= 0 && chess.getY() + 1 < 8 ) {
            if (this.chessColor != chessComponents[chess.getX() - 2][chess.getY() + 1].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX() - 2, chess.getY() + 1));
            }
        }
        if (chess.getX() - 1 >= 0 && chess.getY() - 2 >= 0) {
            if (this.chessColor != chessComponents[chess.getX() - 1][chess.getY() - 2].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX() - 1, chess.getY() - 2));
            }
        }
        if (chess.getX() - 1 >= 0 && chess.getY() + 2 < 8 ) {
            if (this.chessColor != chessComponents[chess.getX() - 1][chess.getY() + 2].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX() - 1, chess.getY() +2));
            }
        }
        if (chess.getX() + 1 < 8  && chess.getY() - 2 >= 0) {
            if (this.chessColor != chessComponents[chess.getX() +1][chess.getY() - 2].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX() +1, chess.getY() - 2));
            }
        }
        if (chess.getX() +1 < 8 && chess.getY() +2   <8) {
            if (this.chessColor != chessComponents[chess.getX() +1][chess.getY() +2].getChessColor()) {
                arrayList.add(new ChessboardPoint(chess.getX() +1, chess.getY() +2));
            }
        }if (chess.getX() + 2 <8 && chess.getY() - 1 >= 0) {
            if(this.chessColor != chessComponents[chess.getX()+2][chess.getY()-1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX() +2, chess.getY()-1));}
        }if (chess.getX() + 2 <8  && chess.getY()+ 1  <8) {
            if(this.chessColor != chessComponents[chess.getX()+2][chess.getY()+1].getChessColor()){
                arrayList.add(new ChessboardPoint(chess.getX() +2, chess.getY()+1));
           System.out.println(this.chessColor);
            System.out.println(chessComponents[chess.getX()+2][chess.getY()+1].getChessColor());
            }
        }
        return arrayList;
    }
}
