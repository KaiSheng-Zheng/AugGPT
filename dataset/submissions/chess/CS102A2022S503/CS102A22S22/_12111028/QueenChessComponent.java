import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

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

    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor, name);
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(destination.getX()>7||destination.getX()<0||destination.getY()>7||destination.getY()<0){return false;}
        int counter=0;
        if(destination.getX()==source.getX()&&destination.getY()==source.getY()){return false;}
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()
                ==chessComponents[source.getX()][source.getY()].getChessColor())
        {return  false;}
        if(Math.abs((destination.getY() - source.getY()))  == Math.abs((destination.getX() - source.getX()) )){
            int row = source.getX();
            int col = source.getY();
            if(destination.getX()>source.getX()&&destination.getY()>source.getY()){
                for (int i = 1; i <Math.abs(destination.getY() - source.getY()); i++) {
                    // counter++;
                    if (!(chessComponents[row+i][col+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }

            else if(destination.getX()>source.getX()&&destination.getY()<source.getY()){
                for (int i = 1; i <Math.abs(destination.getY() - source.getY()); i++) {
                    // counter++;
                    if (!(chessComponents[row+i][col-i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }

            else if(destination.getX()<source.getX()&&destination.getY()>source.getY()){
                for (int i = 1; i <Math.abs(destination.getY() - source.getY()); i++) {
                    // counter++;
                    if (!(chessComponents[row-i][col+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            else if(destination.getX()<source.getX()&&destination.getY()<source.getY()) {
                for (int i = 1; i < Math.abs(destination.getY() - source.getY()); i++) {
                    //counter++;
                    if (!(chessComponents[row - i][col - i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
        }else if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


    public ChessColor getChessColor(){
        return super.getChessColor();
    }
}
