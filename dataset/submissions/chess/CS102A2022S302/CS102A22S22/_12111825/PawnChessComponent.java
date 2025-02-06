import java.util.ArrayList;
import java.util.List;

public  class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> PawnMoveList = new ArrayList<>();
        ArrayList<ChessboardPoint> BLACKPawnInitials = new ArrayList<>();
        ArrayList<ChessboardPoint> WHITEPawnInitials = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            BLACKPawnInitials.add(new ChessboardPoint(i,6));
            WHITEPawnInitials.add(new ChessboardPoint(i,1));
        }
        //check color
        if (getChessColor() == ChessColor.BLACK){
            //check whether it has been moved
            if (BLACKPawnInitials.contains(getSource())){
                if (getSource().offset(0,-1) != null){
                    if (IsThereOtherPiece(getSource().getX(),getSource().getY() - 1) == 1){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY() - 1));
                    }
                }
                if (getSource().offset(0,-2) != null){
                    if (IsThereOtherPiece(getSource().getX(),getSource().getY() - 2) == 1){
                        if (getChess(this.getSource().getX() ,this.getSource().getY() - 1).getChessColor()==ChessColor.NONE){
                            PawnMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY() - 2));
                        }
                        
                    }
                }
                if (getSource().offset(1,-1) != null){
                    if (IsThereOtherPiece(getSource().getX() + 1,getSource().getY() - 1) == 3){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() - 1) );
                    }
                }
                if (getSource().offset(-1,-1) != null){
                    if (IsThereOtherPiece(getSource().getX() - 1,getSource().getY() - 1) == 3){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() - 1) );
                    }
                }
            }else{
                if (getSource().offset(0,-1) != null){
                    if (IsThereOtherPiece(getSource().getX(),getSource().getY() - 1) == 1){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY() - 1));
                    }
                }
                if (getSource().offset(1,-1) != null){
                    if (IsThereOtherPiece(getSource().getX() + 1,getSource().getY() - 1) == 3){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() - 1) );
                    }
                }
                if (getSource().offset(-1,-1) != null){
                    if (IsThereOtherPiece(getSource().getX() - 1,getSource().getY() - 1) == 3){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() - 1) );
                    }
                }


            }
        }
        if (getChessColor() == ChessColor.WHITE){
            if (WHITEPawnInitials.contains(getSource())){
                if (getSource().offset(0,1) != null){
                    if (IsThereOtherPiece(getSource().getX(),getSource().getY() + 1) == 1){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY() + 1));
                    }
                }
                if (getSource().offset(0,2) != null){
                    if (IsThereOtherPiece(getSource().getX(),getSource().getY() + 2) == 1){
                        if (getChess(this.getSource().getX() ,this.getSource().getY() + 1).getChessColor()==ChessColor.NONE){
                            PawnMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY() + 2));
                        }

                    }
                }
                if (getSource().offset(1,1) != null){
                    if (getChess(this.getSource().getX() +1,this.getSource().getY()  +1 ).getChessColor()!=this.getChessColor()){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() + 1) );
                    }
                }
                if (getSource().offset(-1,1) != null){
                    if (getChess(this.getSource().getX() -1,this.getSource().getY()  +1 ).getChessColor()!=this.getChessColor()){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() + 1) );
                    }
                }
            }else {
                if (getSource().offset(0,1) != null){
                    if (IsThereOtherPiece(getSource().getX(),getSource().getY() + 1) == 1){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX(),getSource().getY() + 1));
                    }
                }
                if (getSource().offset(1,1) != null){
                    if (getChess(this.getSource().getX() +1,this.getSource().getY()  +1 ).getChessColor()!=this.getChessColor()){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() + 1,getSource().getY() + 1) );
                    }
                }
                if (getSource().offset(-1,1) != null){
                    if (getChess(this.getSource().getX() -1,this.getSource().getY()  +1 ).getChessColor()!=this.getChessColor()){
                        PawnMoveList.add(new ChessboardPoint(getSource().getX() - 1,getSource().getY() + 1) );
                    }
                }
            }
        }
        return PawnMoveList;
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
