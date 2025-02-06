import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        if((getSource().offset(1,0)!=null)&&(ConcreteChessGame.getColor(getSource().offset(1,0))!= this.getChessColor())){
            canMoveToPoints.add(getSource().offset(1,0));
        }
        if(getSource().offset(0,1)!=null&&ConcreteChessGame.getColor(getSource().offset(0,1))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(0,1));
        }
        if(getSource().offset(-1,0)!=null&&ConcreteChessGame.getColor(getSource().offset(-1,0))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(-1,0));
        }
        if(getSource().offset(0,-1)!=null&&ConcreteChessGame.getColor(getSource().offset(0,-1))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(0,-1));
        }
        if(getSource().offset(1,1)!=null&&ConcreteChessGame.getColor(getSource().offset(1,1))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(1,1));
        }
        if(getSource().offset(-1,-1)!=null&&ConcreteChessGame.getColor(getSource().offset(-1,-1))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(-1,-1));
        }
        if(getSource().offset(1,-1)!=null&&ConcreteChessGame.getColor(getSource().offset(1,-1))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(1,-1));
        }
        if(getSource().offset(-1,1)!=null&&ConcreteChessGame.getColor(getSource().offset(-1,1))!= this.getChessColor()){
            canMoveToPoints.add(getSource().offset(-1,1));
        }
        return canMoveToPoints;
    }

}
