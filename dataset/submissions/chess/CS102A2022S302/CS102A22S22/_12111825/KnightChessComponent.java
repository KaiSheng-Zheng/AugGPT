import java.util.ArrayList;
import java.util.List;

public   class KnightChessComponent extends ChessComponent{


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KnightMoveList = new ArrayList<>();

        //Two forward, one right
        if (this.getSource().getY() + 2 <= 7 && this.getSource().getX() + 1 <= 7){
            if (getChess(this.getSource().getX() + 1,this.getSource().getY() + 2).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() + 2));
            } else if (getChess(this.getSource().getX() + 1,this.getSource().getY()  + 2 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() +  2));
            }

        }

        //Two forward,one left
        if (this.getSource().getY() + 2 <= 7 && this.getSource().getX() - 1 >= 0 ){
            if (getChess(this.getSource().getX() - 1,this.getSource().getY() + 2).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() +  2));
            }else if (getChess(this.getSource().getX() - 1,this.getSource().getY()  + 2 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() +  2));
            }
        }
        //Two backward, one right
        if (this.getSource().getY() - 2 >= 0 && this.getSource().getX() + 1 <= 7){
            if (getChess(this.getSource().getX() + 1,this.getSource().getY() - 2).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() - 2));
            }else if (getChess(this.getSource().getX() + 1,this.getSource().getY()  - 2 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() -  2));
            }
        }
        //Two backward,one left
        if (this.getSource().getY() - 2 >= 0 && this.getSource().getX() - 1 >= 0 ){
            if (getChess(this.getSource().getX() - 1,this.getSource().getY() - 2).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() -  2));
            }else if (getChess(this.getSource().getX() - 1,this.getSource().getY()  - 2 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() -  2));
            }
        }
        //One forward, two right
        if (this.getSource().getY() + 1 <= 7 && this.getSource().getX() + 2 <= 7){
            if (getChess(this.getSource().getX() + 2,this.getSource().getY() + 1).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() + 2,getSource().getY() + 1));
            }else if (getChess(this.getSource().getX() + 2,this.getSource().getY()  +1 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() + 2,getSource().getY() + 1));
            }
        }
        //One forward, two left
        if (this.getSource().getY() + 1 <= 7 && this.getSource().getX() - 2 >= 0){
            if (getChess(this.getSource().getX() - 2,this.getSource().getY() + 1).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() -  2,getSource().getY() + 1));
            }else if (getChess(this.getSource().getX() - 2,this.getSource().getY()  +1 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() -  2,getSource().getY() + 1));
            }
        }
        //One backward, two right
        if (this.getSource().getY() - 1 >= 0 && this.getSource().getX() + 2 <= 7){
            if (getChess(this.getSource().getX() + 2,this.getSource().getY() - 1).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() +  2,getSource().getY() - 1));
            }else if (getChess(this.getSource().getX() + 2,this.getSource().getY()  - 1 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() +  2,getSource().getY() - 1));
            }

        }
        //One backward, two left
        if (this.getSource().getY() - 1 >= 0 && this.getSource().getX() - 2 >= 0){
            if (getChess(this.getSource().getX() - 2,this.getSource().getY() - 1).getChessColor()==ChessColor.NONE){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() -  2,getSource().getY() - 1));
            }else if (getChess(this.getSource().getX() - 2,this.getSource().getY()  - 1 ).getChessColor()!=this.getChessColor()){
                KnightMoveList.add(new ChessboardPoint(getSource().getX() -  2,getSource().getY() - 1));
            }

        }
        return KnightMoveList;
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
