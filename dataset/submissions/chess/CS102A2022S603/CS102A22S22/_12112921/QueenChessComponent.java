import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessColor chessColor){
        setChessColor(chessColor);
        if(chessColor==ChessColor.BLACK){
            setName('Q');
        }
        else{
            setName('q');
        }
    }
    public boolean canMove(ChessComponent[][] chessComponents,ChessboardPoint source, ChessboardPoint destination) {
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessColor){
            return false;
        }
        else {
            if (Math.abs(destination.getX()-source.getX()) ==Math.abs(destination.getY()-source.getY())) {
                //judge if there's other chess blocking
                if(source.getX()<destination.getX()&&source.getY()<destination.getY()||source.getX()>destination.getX()&&source.getY()>destination.getY()){
                    for (int col = Math.min(source.getY(), destination.getY()) + 1,row=Math.min(source.getX(), destination.getX()) + 1;
                         col < Math.max(source.getY(), destination.getY()); col++,row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
                else if(source.getX()>destination.getX()&&source.getY()<destination.getY()){
                    for(int row=source.getX()-1,col=source.getY()+1;col<destination.getY();row--,col++){
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
                else if(source.getX()<destination.getX()&&source.getY()>destination.getY()){
                    for(int row=destination.getX()-1,col=destination.getY()+1;col<source.getY();row--,col++){
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            return false;
                        }
                    }
                }
            }
            else if(source.getX() == destination.getX()) {
                //judge if there's other chess blocking
                int row = source.getX();
                for (int col = Math.min(source.getY(), destination.getY()) + 1;
                     col < Math.max(source.getY(), destination.getY()); col++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            else if (source.getY() == destination.getY()) {
                int col = source.getY();
                for (int row = Math.min(source.getX(), destination.getX()) + 1;
                     row < Math.max(source.getX(), destination.getX()); row++) {
                    if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint>list = new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(source.getX()==i&&source.getY()==j){
                }
                else {
                    if(canMove(chessComponents,source,new ChessboardPoint(i,j))){
                        list.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return list;
    }
}
