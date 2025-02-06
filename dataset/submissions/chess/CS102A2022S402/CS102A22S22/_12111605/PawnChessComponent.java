import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name, ChessColor chessColor, ChessboardPoint chessboardPoint) {
        this.setName(name);
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> List = new ArrayList<>();

        if (this.getChessColor() == ChessColor.WHITE) {
            if (this.getSource().getY()!=0 && this.getSource().getY()!=7){
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY()));
                }
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));
                }
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                }
                if (getChessComponents()[4][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && getChessComponents()[5][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && this.getSource().getX() == 6) {
                    List.add(new ChessboardPoint(4, this.getSource().getY()));
                }
            }else if (this.getSource().getY()==0){
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY()));
                }
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1));
                }
                if (getChessComponents()[4][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && getChessComponents()[5][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && this.getSource().getX() == 6) {
                    List.add(new ChessboardPoint(4, this.getSource().getY()));
                }
            }else if (this.getSource().getY()==7){
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY()));
                }
                if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    List.add(new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1));
                }
                if (getChessComponents()[4][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && getChessComponents()[5][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && this.getSource().getX() == 6) {
                    List.add(new ChessboardPoint(4, this.getSource().getY()));
                }
            }
        }
        if (this.getChessColor() == ChessColor.BLACK) {
            if (this.getSource().getY()!=0&&this.getSource().getY()!=7){
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY()));
                }
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));
                }
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                }
                if (getChessComponents()[3][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && getChessComponents()[2][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && this.getSource().getX() == 1) {
                    List.add(new ChessboardPoint(3, this.getSource().getY()));
                }
            }else if (this.getSource().getY()==0){
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY()));
                }
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1));
                }
                if (getChessComponents()[3][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && getChessComponents()[2][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && this.getSource().getX() == 1) {
                    List.add(new ChessboardPoint(3, this.getSource().getY()));
                }
            }else if (this.getSource().getY()==7){
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY()].getChessColor() == ChessColor.NONE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY()));
                }
                if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    List.add(new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1));
                }
                if (getChessComponents()[3][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && getChessComponents()[2][this.getSource().getY()].getChessColor() == ChessColor.NONE
                        && this.getSource().getX() == 1) {
                    List.add(new ChessboardPoint(3, this.getSource().getY()));
                }
            }
            
        }

        return List;
    }


}
