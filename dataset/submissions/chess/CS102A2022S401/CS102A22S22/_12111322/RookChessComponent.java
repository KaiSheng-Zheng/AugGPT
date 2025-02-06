import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        for(int i = 1;getSource().offset(i,0)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(i,0))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(i,0));
            }
            if(ConcreteChessGame.getColor(getSource().offset(i,0))!=ChessColor.NONE){
                break;
            }
        }
        for(int i = 1;getSource().offset(0,i)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(0,i))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(0,i));
            }
            if(ConcreteChessGame.getColor(getSource().offset(0,i))!=ChessColor.NONE){
                break;
            }
        }
        for(int i = 1;getSource().offset(-i,0)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(-i,0))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-i,0));
            }
            if(ConcreteChessGame.getColor(getSource().offset(-i,0))!=ChessColor.NONE){
                break;
            }
        }
        for(int i = 1;getSource().offset(0,-i)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(0,-i))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(0,-i));
            }
            if(ConcreteChessGame.getColor(getSource().offset(0,-i))!=ChessColor.NONE){
                break;
            }
        }

        return canMoveToPoints;
    }

}
