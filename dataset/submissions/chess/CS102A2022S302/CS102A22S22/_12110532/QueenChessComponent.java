import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = 1; i < 8-this.getSource().getY(); i++) {
            if (this.getChessboard()[this.getSource().getX()]
                    [this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(0,i));
            }else if (this.getChessboard()[this.getSource().getX()]
                    [this.getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(0,i));
                break;
            }
        }
        for (int i = 1; i <this.getSource().getY()+1 ; i++) {
            if (this.getChessboard()[this.getSource().getX()]
                    [this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(0,-i));
            }else if (this.getChessboard()[this.getSource().getX()]
                    [this.getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(0,-i));
                break;
            }
        }
        for (int i = 1; i < 8 - this.getSource().getX(); i++) {
            if (this.getChessboard()[this.getSource().getX()+i]
                    [this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(i,0));
            }else if (this.getChessboard()[this.getSource().getX()+i]
                    [this.getSource().getY()].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(i,0));
                break;
            }
        }
        for (int i = 1; i <this.getSource().getX()+1 ; i++) {
            if (this.getChessboard()[this.getSource().getX()-i]
                    [this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(-i,0));
            }else if (this.getChessboard()[this.getSource().getX()-i]
                    [this.getSource().getY()].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(-i,0));
                break;
            }
        }

        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            if (this.getChessboard()[x + i][y + i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(i, i));
            } else if (this.getChessboard()[x + i][y + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(i, i));
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            if (this.getChessboard()[x - i][y + i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-i, i));
            } else if (this.getChessboard()[x - i][y + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(-i, i));
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (this.getChessboard()[x - i][y - i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-i, -i));
            } else if (this.getChessboard()[x - i][y - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(-i, -i));
                break;
            }
        }
        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            if (this.getChessboard()[x + i][y - i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(i, -i));
            } else if (this.getChessboard()[x + i][y - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(i, -i));
                break;
            }
        }

        return move;
    }
}
