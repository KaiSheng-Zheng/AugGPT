import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.name = name;
        this.setSource(source);
        this.setChessColor(chessColor);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        switch (this.getChessColor()){
            case BLACK:{
                if(getSource().getX()==1&&ConcreteChessGame.getColor(getSource().offset(1,0))==ChessColor.NONE){
                    canMoveToPoints.add(getSource().offset(1,0));
                    if(ConcreteChessGame.getColor(getSource().offset(2,0))==ChessColor.NONE){
                        canMoveToPoints.add(getSource().offset(2,0));
                    }
                }
                if(getSource().offset(1,0)!=null&&getSource().getX()>1&&ConcreteChessGame.getColor(getSource().offset(1,0))==ChessColor.NONE){
                    canMoveToPoints.add(getSource().offset(1,0));
                }
                if(getSource().offset(1,1)!=null){
                    if(ConcreteChessGame.getColor(getSource().offset(1,1))==ChessColor.WHITE){
                        canMoveToPoints.add(getSource().offset(1,1));
                    }
                }
                if(getSource().offset(1,-1)!=null){
                    if(ConcreteChessGame.getColor(getSource().offset(1,-1))==ChessColor.WHITE){
                        canMoveToPoints.add(getSource().offset(1,-1));
                    }
                }
                break;
            }
            case WHITE:{
                if(getSource().getX()==6&&ConcreteChessGame.getColor(getSource().offset(-1,0))==ChessColor.NONE){
                    canMoveToPoints.add(getSource().offset(-1,0));
                    if(ConcreteChessGame.getColor(getSource().offset(-2,0))==ChessColor.NONE){
                        canMoveToPoints.add(getSource().offset(-2,0));
                    }
                }
                if(getSource().offset(-1,0)!=null&&getSource().getX()<6&&ConcreteChessGame.getColor(getSource().offset(-1,0))==ChessColor.NONE){
                    canMoveToPoints.add(getSource().offset(-1,0));
                }
                if(getSource().offset(-1,1)!=null){
                    if(ConcreteChessGame.getColor(getSource().offset(-1,1))==ChessColor.BLACK){
                        canMoveToPoints.add(getSource().offset(-1,1));
                    }
                }
                if(getSource().offset(-1,-1)!=null){
                    if(ConcreteChessGame.getColor(getSource().offset(-1,-1))==ChessColor.BLACK){
                        canMoveToPoints.add(getSource().offset(-1,-1));
                    }
                }
                break;
            }
            default:
                break;
        }
        return canMoveToPoints;
    }

}
