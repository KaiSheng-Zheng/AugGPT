
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents;
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public PawnChessComponent(ChessboardPoint point,ChessColor color,ChessComponent[][] chessComponents){
        super(point,color);
        setChessComponents(chessComponents);
    }

    @Override
    public String toString(){
        if(this.getChessColor()==ChessColor.BLACK) return "P";
        else return "p";
    }

    public boolean canM(ChessboardPoint point){
        ChessboardPoint source = getSource();
        switch (this.getChessColor()){
            case WHITE :{
                int a=source.getX()-point.getX();int b=point.getY()-source.getY();
                if(a*b==0){
                    switch (a) {
                        case 1:
                            return chessComponents[point.getX()][point.getY()] instanceof EmptySlotComponent;
                        case 2:
                            return (source.getX() == 6 && chessComponents[point.getX()][point.getY()] instanceof EmptySlotComponent);
                        default:
                            return false;
                    }
                }else if(Math.abs(b)*a==1){
                    return chessComponents[point.getX()][point.getY()].getChessColor()==ChessColor.BLACK;
                }else return false;
            }
            case BLACK :{
                //zou 1 zou 2 chi
                int a=point.getX()-source.getX();int b=point.getY()-source.getY();
                if(a*b==0){
                    switch (a) {
                        case 1:
                            return chessComponents[point.getX()][point.getY()] instanceof EmptySlotComponent;
                        case 2:
                            return (source.getX() == 1 && chessComponents[point.getX()][point.getY()] instanceof EmptySlotComponent);
                        default:
                            return false;
                    }
                }else if(Math.abs(b)*a==1){
                    return chessComponents[point.getX()][point.getY()].getChessColor()==ChessColor.WHITE;
                }else return false;
            }
            default:return false;
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> List=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint point=new ChessboardPoint(i,j);
                if(canM(point)){
                    List.add(point);
                }
            }
        }
        return List;
    }
}
