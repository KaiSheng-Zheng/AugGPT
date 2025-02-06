import java.util.LinkedList;
import java.util.List;

class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor,ChessboardPoint source){
        if(chessColor==ChessColor.WHITE){
            this.name='q';
        }else {
            this.name = 'Q';
        }
        this.setChessColor(chessColor);
        this.setSource(source);
    }
    public List<ChessboardPoint> canMoveTo(){
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> coordinates = new LinkedList<>();
        ChessColor selectColor =chessComponents[x][y].getChessColor();

        for(int i=1;i<8;i++){
            if((getSource().offset(i,-i)!=null)) {
                if ((chessComponents[x+i][y - i].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(i, -i));
                }
            }

            if((getSource().offset(i,-i)==null)){
                break;
            }
            if((chessComponents[x+i][y-i].getChessColor()!=ChessColor.NONE)){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if((getSource().offset(i,i)!=null)) {
                if ((chessComponents[x + i][y + i].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(i, i));
                }
            }
            if((getSource().offset(i,i)==null)){
                break;
            }
            if ((chessComponents[x+i][y+i].getChessColor()!=ChessColor.NONE)){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if((getSource().offset(-i,i)!=null)) {
                if ((chessComponents[x - i][y + i].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(-i, i));
                }
            }
            if((getSource().offset(-i,i)==null)){
                break;
            }
            if((chessComponents[x-i][y+i].getChessColor()!=ChessColor.NONE)){
                break;
            }
        }
        for(int i=1;i<8;i++){
            if((getSource().offset(-i,-i)!=null)) {
                if ((chessComponents[x - i][y - i].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(-i, -i));
                }
            }
            if((getSource().offset(-i,-i)==null)){
                break;
            }
            if (chessComponents[x-i][y-i].getChessColor()!=ChessColor.NONE){
                break;
            }
        }
        for(int i=1;i<8;i++) {
            if ((getSource().offset(i, 0) != null) ) {
                if ((chessComponents[x+i ][y].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(i, 0));
                }
            }
            if ((getSource().offset(i, 0) == null)){
                break;
            }
            if ((chessComponents[x+i][y].getChessColor() != ChessColor.NONE)) {
                break;
            }
        }
        for(int i=1;i<8;i++) {
            if ((getSource().offset(-i, 0) != null) ) {
                if ((chessComponents[x-i][y].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(-i, 0));
                }
            }
            if ((getSource().offset(-i, 0) == null)){
                break;
            }
            if((chessComponents[x-i ][y].getChessColor() != ChessColor.NONE)) {
                break;
            }
        }

        for(int i=1;i<8;i++) {
//            System.out.println(y);
//            System.out.println(x+i);
            if ((getSource().offset(0, i) != null) ) {
                if ((chessComponents[x][y+i].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(0, i));
                }
            }
            if ((getSource().offset(0, i) == null)){
                break;
            }
            if( (chessComponents[x][y+i].getChessColor() != ChessColor.NONE)) {
                break;
            }
        }
        for(int i=1;i<8;i++) {
            if ((getSource().offset(0, -i) != null) ) {
                if ((chessComponents[x][y-i].getChessColor() != selectColor)) {
                    coordinates.add(getSource().offset(0, -i));
                }
            }
            if ((getSource().offset(0, -i) == null)){
                break;
            }
            if((chessComponents[x][y-i].getChessColor() != ChessColor.NONE)) {
                break;
            }
        }

        return coordinates;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}
