import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessComponent chess ;
    private ChessComponent movedChess;
    private List<ChessboardPoint> canMoveList;
    public RookChessComponent(char name){
        this.name=name;
        if (name=='R'){
            setChessColor(ChessColor.BLACK);}
        else {setChessColor(ChessColor.WHITE);}
    }
    public RookChessComponent(){
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {ChessComponent[][] chessboard = ChessComponent.chessboard;
        canMoveList = new ArrayList<>();
        ChessboardPoint origin = new ChessboardPoint(this.getSource().getX(),this.getSource().getY());
        this.setSource(origin);
        for (int i = this.getSource().getY()+1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX(),i);
            movedChess = chessboard[this.getSource().getX()][i];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        for (int i = this.getSource().getY()-1; i > -1; i--) {

            ChessboardPoint toMove = new ChessboardPoint(this.getSource().getX(),i);
            movedChess = chessboard[this.getSource().getX()][i];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        for (int i = this.getSource().getX()+1; i < 8; i++) {

            ChessboardPoint toMove = new ChessboardPoint(i,this.getSource().getY());
            movedChess = chessboard[i][this.getSource().getY()];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
        for (int i = this.getSource().getX()-1; i > -1; i--) {

            ChessboardPoint toMove = new ChessboardPoint(i,this.getSource().getY());
            movedChess = chessboard[i][this.getSource().getY()];
            if (movedChess.getChessColor() == this.getChessColor()){break;}
            else if (movedChess.getChessColor() == ChessColor.NONE){canMoveList.add(toMove);}
            else {canMoveList.add(toMove);break;}

        }
         canMoveList.remove(origin);
         return canMoveList;}


}

