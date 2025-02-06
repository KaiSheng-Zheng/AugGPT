import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        for (int i = 1; i <= Math.min(this.getSource().getX(),7-this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(-i,i));
            }else if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(-i,i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(this.getSource().getX(),this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(-i,-i));
            }else if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(-i,-i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(7-this.getSource().getX(),this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(i,-i));
            }else if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(i,-i));
                break;
            }
        }

        for (int i = 1; i <= Math.min(7-this.getSource().getX(),7-this.getSource().getY()); i++) {
            if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(i,i));
            }else if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(i,i));
                break;
            }
        }

        for (int i = 1; i <= 7-this.getSource().getY(); i++) {

            if (this.getChessboard()[this.getSource().getX()][this.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(0,i));
            }else if (this.getChessboard()[this.getSource().getX()][this.getSource().getY()+i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(0,i));
                break;
            }
        }


        for (int i = 1; i <= this.getSource().getY(); i++) {

            if (this.getChessboard()[this.getSource().getX()][this.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(0,-i));
            }else if (this.getChessboard()[this.getSource().getX()][this.getSource().getY()-i].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(0,-i));
                break;
            }
        }


        for (int i = 1; i <= this.getSource().getX(); i++) {

            if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(-i,0));
            }else if (this.getChessboard()[this.getSource().getX()-i][this.getSource().getY()].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(-i,0));
                break;
            }
        }

        for (int i = 1; i <= 7-this.getSource().getX(); i++) {

            if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                move.add(this.getSource().offset(i,0));
            }else if (this.getChessboard()[this.getSource().getX()+i][this.getSource().getY()].getChessColor().equals(this.getChessColor())){
                break;
            }else {
                move.add(this.getSource().offset(i,0));
                break;
            }
        }
        return move;
    }


}
