import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint des=new ChessboardPoint(i,j);
                if(this.canMoveTo(ConcreteChessGame.getStaticchessComponents(),des)){
                    result.add(des);
                }
            }
        }
        return result;
    }

    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor, name);
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = this.getChessboardPoint();
        if(destination.getX()>7||destination.getX()<0||destination.getY()>7||destination.getY()<0){return false;}
        switch (this.getChessColor()) {
            case BLACK:
                if (source.getX() == 1 && source.getY() == destination.getY() &&
                        chessComponents[destination.getX()][destination.getY()]
                                instanceof EmptySlotComponent){
                    if (destination.getX() - source.getX() == 1 ||
                            destination.getX() - source.getX() == 2) {
                        return true;
                    }}
                if (source.getY() == destination.getY() &&
                        destination.getX() - source.getX() == 1 &&
                        chessComponents[destination.getX()][destination.getY()]
                                instanceof EmptySlotComponent) {
                    return true;
                }
                if(destination.getX()- source.getX()==1
                        &&Math.abs(destination.getY()- source.getY())==1&&
                        chessComponents[destination.getX()][destination.getY()].getChessColor().
                                equals(ChessColor.WHITE)){
                    return true;
                }
                return false;

            case WHITE:
                if (source.getX() == 6 && source.getY() == destination.getY() &&
                        chessComponents[destination.getX()][destination.getY()]
                                instanceof EmptySlotComponent) {
                    if ( source.getX()-destination.getX() ==1 ||
                            source.getX()-destination.getX() == 2) {
                        return true;
                    }}
                if (source.getY() == destination.getY() &&
                        source.getX()-destination.getX() == 1 &&
                        chessComponents[destination.getX()][destination.getY()]
                                instanceof EmptySlotComponent) {
                    return true;
                }
                if(source.getX()-destination.getX()==1&&
                        Math.abs(destination.getY()- source.getY())==1&&
                        chessComponents[destination.getX()][destination.getY()].getChessColor().
                                equals(ChessColor.BLACK)){
                    return true;
                }
                return false;
        }
        return true;
    }

    public ChessboardPoint getChessboardPoint(){
        return super.getChessboardPoint();
    }

    public ChessColor getChessColor(){
        return super.getChessColor();
    }
}
