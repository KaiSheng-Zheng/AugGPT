import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;

    public BishopChessComponent(ChessComponent[][] chessComponents,int i,int j) {
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(i,j));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointslist = new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(canmoveto(chessComponents,new ChessboardPoint(i,j))){
                    pointslist.add(new ChessboardPoint(i,j));
                }
            }
        }
        return pointslist;
    }

    public boolean canmoveto(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getSource();

         if(Math.abs(source.getY()-destination.getY())==Math.abs(source.getX()-destination.getX())){
             int num = Math.abs(source.getX()-destination.getX());

             if(destination.getY()>source.getY() && destination.getX()>source.getX()){
                 for(int i=1;i<num;i++){
                     if(chessComponents[source.getX()+i][source.getY()+i].getChessColor()!=ChessColor.NONE){
                         return false;
                     }
                 }
             }else if(destination.getY()>source.getY() && destination.getX()<source.getX()){
                 for(int i=1;i<num;i++){
                     if(chessComponents[source.getX()-i][source.getY()+i].getChessColor()!=ChessColor.NONE){
                         return false;
                     }
                 }
             }else if(destination.getY()<source.getY() && destination.getX()>source.getX()){
                 for(int i=1;i<num;i++){
                     if(chessComponents[source.getX()+i][source.getY()-i].getChessColor()!=ChessColor.NONE){
                         return false;
                     }
                 }
             }else if(destination.getY()<source.getY() && destination.getX()<source.getX()){
                 for(int i=1;i<num;i++){
                     if(chessComponents[source.getX()-i][source.getY()-i].getChessColor()!=ChessColor.NONE){
                         return false;
                     }
                 }
             }





             if(chessboard[destination.getX()][destination.getY()].getChessColor()!=chessboard[source.getX()][source.getY()].getChessColor()){
                 return true;
             }else return false;
         }else {
             return false;
         }
//        if (Math.abs(source.getX()-destination.getX())==Math.abs(source.getY()-destination.getY())) {
//            int x =source.getX();
//            int y=source.getY();
//            if (destination.getX()-source.getX()>0 &&destination.getY()-source.getY()>0){
//                while(x<destination.getX()-1 &&y<destination.getY()-1) {
//                    x++;
//                    y++;
//                    if (!(chessboard[x][y] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }}
//            if (destination.getX()-source.getX()<0 &&destination.getY()-source.getY()>0){
//                while(x>destination.getX()+1 &&y<destination.getY()-1) {
//                    x--;
//                    y++;
//                    if (!(chessboard[x][y] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }}
//            if (destination.getX()-source.getX()>0 &&destination.getY()-source.getY()<0){
//                while(x<destination.getX()-1 &&y>destination.getY()+1) {
//                    x++;
//                    y--;
//                    if (!(chessboard[x][y] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }}
//            if (destination.getX()-source.getX()<0 &&destination.getY()-source.getY()<0){
//                while(x>destination.getX()+1 &&y>destination.getY()+1) {
//                    x--;
//                    y--;
//                    if (!(chessboard[x][y] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }}
//        } else {
//            return false;
//        }
    }
}
