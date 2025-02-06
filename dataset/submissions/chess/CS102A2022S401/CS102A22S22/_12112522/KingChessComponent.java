import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    public KingChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessColor color = getChessColor();
        List<ChessboardPoint> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);
                if(i==source.getX()){
                    if(((j==getSource().getY()+1)||(j==getSource().getY()-1))&&(chessComponent[i][j].getChessColor()!=color
                            ||chessComponent[i][j].getChessColor()==ChessColor.NONE)){
                        list.add(chessboardPoint);
                    }
                }else if(j==source.getY()){
                    if(((i==source.getX()+1)||(i==source.getX()-1))&&(chessComponent[i][j].getChessColor()!=color
                            ||chessComponent[i][j].getChessColor()==ChessColor.NONE)){
                        list.add(chessboardPoint);
                    }
                }else if((i==source.getX()+1&&j==getSource().getY()+1)||(i==source.getX()-1&&j==getSource().getY()+1)||
                        (i==source.getX()+1&&j==getSource().getY()-1)||(i==source.getX()-1&&j==getSource().getY()-1)){
                    if(chessComponent[i][j].getChessColor()!=color||chessComponent[i][j].getChessColor()==ChessColor.NONE){
                        list.add(chessboardPoint);
                    }
                }else if(i== source.getX()&&j==source.getY()){

                }
            }
        }

        return list;
    }
}
