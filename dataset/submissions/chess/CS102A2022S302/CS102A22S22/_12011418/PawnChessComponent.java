import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y, ChessColor chessColor, char name) {
        this.setSource(x, y);
        this.setChessColor(chessColor);
        this.setName(name);
        ChessComponent[][] chessComponents = new ChessComponent[8][8];
        this.setChessboard(chessComponents); // construct a chessComponents of 8*8
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessboardPoint source = new ChessboardPoint(x, y);
        List<ChessboardPoint> coordinates = new ArrayList<>();

        if (this.getChessColor() == ChessColor.WHITE){
            if (source.offset(-2,0) != null && this.getSource().getX() == 6){
                if (this.getChessboard()[x - 2][y].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(-2,0));
                }
            } // only the first movement
            if (source.offset(-1,0) != null){
                if (this.getChessboard()[x - 1][y].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(-1,0));
                }
            } // normal movement
            if (source.offset(-1,-1) != null){
                if (this.getChessboard()[x - 1][y - 1].getChessColor() == ChessColor.BLACK){
                    coordinates.add(source.offset(-1,-1));
                }
            } // capture
            if (source.offset(-1,1) != null){
                if (this.getChessboard()[x - 1][y + 1].getChessColor() == ChessColor.BLACK){
                    coordinates.add(source.offset(-1,1));
                }
            } // capture
        } else if (this.getChessColor() == ChessColor.BLACK){
            if (source.offset(2,0) != null && this.getSource().getX() == 1){
                if (this.getChessboard()[x + 2][y].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(2,0));
                }
            } // only the first movement
            if (source.offset(1,0) != null){
                if (this.getChessboard()[x + 1][y].getChessColor() == ChessColor.NONE){
                    coordinates.add(source.offset(1,0));
                }
            } // normal movement
            if (source.offset(1,-1) != null){
                if (this.getChessboard()[x + 1][y - 1].getChessColor() == ChessColor.WHITE){
                    coordinates.add(source.offset(1,-1));
                }
            } // capture
            if (source.offset(1,1) != null){
                if (this.getChessboard()[x + 1][y + 1].getChessColor() == ChessColor.WHITE){
                    coordinates.add(source.offset(1,1));
                }
            } // capture
        }
        return coordinates;
    }
}
