import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessComponent chess ;
    private ChessComponent movedChess;
    private List<ChessboardPoint> canMoveList;
    public KnightChessComponent(char name){
        this.name=name;
        if (name=='N'){
            setChessColor(ChessColor.BLACK);}
        else {setChessColor(ChessColor.WHITE);}
    }
    public KnightChessComponent(){

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
ChessComponent[][] chessboard = ChessComponent.chessboard;
         ChessboardPoint origin = new ChessboardPoint(this.getSource().getX(),this.getSource().getY());
         canMoveList = new ArrayList<>();
        ChessboardPoint toMove = new ChessboardPoint(getSource().getX()-2,getSource().getY()+1);

        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()-2][this.getSource().getY()+1];
        if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

         toMove = new ChessboardPoint(getSource().getX()-2,getSource().getY()-1);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()-2][this.getSource().getY()-1];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

        toMove = new ChessboardPoint(getSource().getX()+2,getSource().getY()+1);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()+2][this.getSource().getY()+1];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

        toMove = new ChessboardPoint(getSource().getX()+2,getSource().getY()-1);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()+2][this.getSource().getY()-1];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

        toMove = new ChessboardPoint(getSource().getX()-1,getSource().getY()+2);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()-1][this.getSource().getY()+2];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

        toMove = new ChessboardPoint(getSource().getX()+1,getSource().getY()+2);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()+1][this.getSource().getY()+2];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

        toMove = new ChessboardPoint(getSource().getX()-1,getSource().getY()-2);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()-1][this.getSource().getY()-2];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}

        toMove = new ChessboardPoint(getSource().getX()+1,getSource().getY()-2);
        if (toMove.getX()<8 && toMove.getX()>-1 && toMove.getY() <8 && toMove.getY()>-1 ){
            movedChess = chessboard[getSource().getX()+1][this.getSource().getY()-2];
            if (movedChess.getChessColor() != this.getChessColor()){canMoveList.add(toMove);}}


        return canMoveList;
    }
}
