import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        if(getSource().offset(1,2)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(1,2))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(1,2));}
        }
        if(getSource().offset(2,1)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(2,1))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(2,1));}
        }if(getSource().offset(-1,2)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(-1,2))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-1,2));}
        }if(getSource().offset(-2,1)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(-2,1))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-2,1));}
        }if(getSource().offset(1,-2)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(1,-2))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(1,-2));}
        }if(getSource().offset(2,-1)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(2,-1))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(2,-1));}
        }if(getSource().offset(-1,-2)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(-1,-2))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-1,-2));}
        }if(getSource().offset(-2,-1)!=null){
            if (ConcreteChessGame.getColor(getSource().offset(-2,-1))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-2,-1));}
        }
        return canMoveToPoints;
    }

}
