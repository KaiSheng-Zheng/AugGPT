import java.util.*;

public   class  BishopChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Yada = new ArrayList<>();
        ChessboardPoint a = getSource();

        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() + i > 7 || this.getSource().getX() + i > 7) {
                break;
            }else {
                if (getChess(this.getSource().getX() + i,this.getSource().getY()+i).getChessColor()==ChessColor.NONE){
                     Yada.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() + i));
                }else if (getChess(this.getSource().getX() + i,this.getSource().getY()+i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Yada.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() + i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() - i < 0 || this.getSource().getX() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX() - i,this.getSource().getY() - i).getChessColor()==ChessColor.NONE){
                    Yada.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() - i));
                }else if (getChess(this.getSource().getX() - i,this.getSource().getY() - i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Yada.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() - i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() - i < 0 || this.getSource().getX() + i > 7) {
                break;
            }else {
                if (getChess(this.getSource().getX() + i,this.getSource().getY() - i).getChessColor()==ChessColor.NONE){
                    Yada.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() - i));
                }else if (getChess(this.getSource().getX() + i,this.getSource().getY() - i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Yada.add(new ChessboardPoint(getSource().getX() + i,getSource().getY() - i));
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (this.getSource().getY() + i > 7  || this.getSource().getX() - i < 0) {
                break;
            }else {
                if (getChess(this.getSource().getX() - i,this.getSource().getY() + i).getChessColor()==ChessColor.NONE){
                    Yada.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() + i));
                }else if (getChess(this.getSource().getX() - i,this.getSource().getY() + i).getChessColor()==this.getChessColor()){
                    break;
                }else {
                    Yada.add(new ChessboardPoint(getSource().getX() - i,getSource().getY() + i));
                    break;
                }
            }
        }

        return Yada;
    }
    public int  IsThereOtherPiece (int a,int b){
        if ((chessboard[a][b].getName() == '_' )){return 1;}
        else if(chessboard[a][b].getChessColor() == getChessColor()){
                return 2;
        }else {
            return 3;
        }
    }


}
