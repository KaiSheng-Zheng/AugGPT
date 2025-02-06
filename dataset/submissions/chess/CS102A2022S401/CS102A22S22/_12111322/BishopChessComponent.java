import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();

        for(int i = 1;getSource().offset(i,i)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(i,i))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(i,i));
            }
            if(ConcreteChessGame.getColor(getSource().offset(i,i))!=ChessColor.NONE){
                break;
            }
        }
        for(int i = 1;getSource().offset(-i,-i)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(-i,-i))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-i,-i));
            }
            if(ConcreteChessGame.getColor(getSource().offset(-i,-i))!=ChessColor.NONE){
                break;
            }
        }
        for(int i = 1;getSource().offset(-i,i)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(-i,i))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(-i,i));
            }
            if(ConcreteChessGame.getColor(getSource().offset(-i,i))!=ChessColor.NONE){
                break;
            }
        }
        for(int i = 1;getSource().offset(i,-i)!=null;i++){
            if(ConcreteChessGame.getColor(getSource().offset(i,-i))!= this.getChessColor()){
                canMoveToPoints.add(getSource().offset(i,-i));
            }
            if(ConcreteChessGame.getColor(getSource().offset(i,-i))!=ChessColor.NONE){
                break;
            }
        }
        return canMoveToPoints;
    }

}
