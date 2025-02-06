import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public void setChessColor(ChessColor chessColor){
        super.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ans = new ArrayList<>();
        ChessboardPoint BlackGo1 = new ChessboardPoint(getSource().getX()+1, getSource().getY());
        ChessboardPoint BlackGo2 = new ChessboardPoint(getSource().getX()+2, getSource().getY());
        ChessboardPoint BlackDL = new ChessboardPoint(getSource().getX()+1, getSource().getY()-1);
        ChessboardPoint BlackDR = new ChessboardPoint(getSource().getX()+1, getSource().getY()+1);
        ChessboardPoint WhiteGo1 = new ChessboardPoint(getSource().getX()-1, getSource().getY());
        ChessboardPoint WhiteGo2 = new ChessboardPoint(getSource().getX()-2, getSource().getY());
        ChessboardPoint WhiteUL = new ChessboardPoint(getSource().getX()-1, getSource().getY()-1);
        ChessboardPoint WhiteUR = new ChessboardPoint(getSource().getX()-1, getSource().getY()+1);




        if (getSource().getX() == 1&& chessBoard[getSource().getX()][getSource().getY()].getChessColor() == ChessColor.BLACK){
            if (chessBoard[getSource().getX()+2][getSource().getY()].getChessColor()!=ChessColor.NONE &&chessBoard[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
            }
            if (chessBoard[getSource().getX()+2][getSource().getY()].getChessColor() == ChessColor.NONE && chessBoard[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE){
                ans.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
                ans.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()));
            }
            if (BlackDL.getX()!= -1){
                if (chessBoard[getSource().getX()+1][getSource().getY()-1].getChessColor() == ChessColor.WHITE){
                    ans.add(BlackDL);
                }
            }
            if (BlackDR.getX()!= -1){
                if (chessBoard[getSource().getX()+1][getSource().getY()+1].getChessColor() == ChessColor.WHITE){
                    ans.add(BlackDR);
                }
            }
        }
        if (getSource().getX() >1 && chessBoard[getSource().getX()][getSource().getY()].getChessColor() == ChessColor.BLACK){
            if (BlackGo1.getX()!= -1){
                if (chessBoard[getSource().getX()+1][getSource().getY()].getChessColor() == ChessColor.NONE){
                    ans.add(BlackGo1);
                }
            }
            if (BlackDL.getX()!= -1){
                if (chessBoard[getSource().getX()+1][getSource().getY()-1].getChessColor() == ChessColor.WHITE){
                    ans.add(BlackDL);
                }
            }
            if (BlackDR.getX()!= -1){
                if (chessBoard[getSource().getX()+1][getSource().getY()+1].getChessColor() == ChessColor.WHITE){
                    ans.add(BlackDR);
                }
            }
        }



        if (getSource().getX() ==6 && chessBoard[getSource().getX()][getSource().getY()].getChessColor() == ChessColor.WHITE){
            if (chessBoard[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE &&chessBoard[getSource().getX()-2][getSource().getY()].getChessColor() != ChessColor.NONE ){
                ans.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
            }
            if (chessBoard[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE &&chessBoard[getSource().getX()-2][getSource().getY()].getChessColor() == ChessColor.NONE ){
                ans.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
                ans.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()));
            }
            if (WhiteUL.getX()!= -1){
                if (chessBoard[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    ans.add(WhiteUL);
                }
            }
            if (WhiteUR.getX()!= -1){
                if (chessBoard[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                    ans.add(WhiteUR);
                }
            }
        }

        if (getSource().getX() <6 && chessBoard[getSource().getX()][getSource().getY()].getChessColor()==ChessColor.WHITE){
           if (WhiteGo1.getX()!= -1){
               if (chessBoard[getSource().getX()-1][getSource().getY()].getChessColor() == ChessColor.NONE){
                   ans.add(WhiteGo1);
               }
           }
            if (WhiteUL.getX()!= -1){
                if (chessBoard[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    ans.add(WhiteUL);
                }
            }
            if (WhiteUR.getX()!= -1){
                if (chessBoard[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                    ans.add(WhiteUR);
                }
            }
        }
        return ans;
    }
}
