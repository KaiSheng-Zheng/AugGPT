import java.util.LinkedList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {


    public BishopChessComponent(ChessColor chessColor,ChessboardPoint source) {
        if(chessColor==ChessColor.WHITE){
            this.name='b';
        }else {
            this.name = 'B';
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

        return coordinates;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
