import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(int x,int y, ChessColor color) {
        super();
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(color);
        if(color.equals(ChessColor.WHITE)){
            name='q';}
        else if(color.equals(ChessColor.BLACK)){
            name='Q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> q=new ArrayList<>();
        for(int i=1;i<8;i++){
            if(super.getSource().getX()+i>=0&&super.getSource().getX()+i<=7&&super.getSource().getY()-i>=0&&super.getSource().getY()-i<=7){
                if(chessComponent[super.getSource().getX()+i][super.getSource().getY()-i].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()+i][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()-i));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()-i));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getX()+i>=0&&super.getSource().getX()+i<=7&&super.getSource().getY()+i>=0&&super.getSource().getY()+i<=7){
                if(chessComponent[super.getSource().getX()+i][super.getSource().getY()+i].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()+i][super.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                q.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()+i));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()+i));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getX()-i>=0&&super.getSource().getX()-i<=7&&super.getSource().getY()-i>=0&&super.getSource().getY()-i<=7){
                if(chessComponent[super.getSource().getX()-i][super.getSource().getY()-i].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()-i][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()-i));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()-i));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getX()-i>=0&&super.getSource().getX()-i<=7&&super.getSource().getY()+i>=0&&super.getSource().getY()+i<=7){
                if(chessComponent[super.getSource().getX()-i][super.getSource().getY()+i].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()-i][super.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()+i));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()+i));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getY()-i>=0&&super.getSource().getY()-i<=7){
                if(chessComponent[super.getSource().getX()][super.getSource().getY()-i].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX(),super.getSource().getY()-i));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX(),super.getSource().getY()-i));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getY()+i>=0&&super.getSource().getY()+i<=7){
                if(chessComponent[super.getSource().getX()][super.getSource().getY()+i].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()][super.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX(),super.getSource().getY()+i));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX(),super.getSource().getY()+i));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getX()+i>=0&&super.getSource().getX()+i<=7){
                if(chessComponent[super.getSource().getX()+i][super.getSource().getY()].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()+i][super.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()));
                    break;
                }
            }
        }
        for(int i=1;i<8;i++){
            if(super.getSource().getX()-i>=0&&super.getSource().getX()-i<=7){
                if(chessComponent[super.getSource().getX()-i][super.getSource().getY()].getChessColor().equals(super.getChessColor())){
                    break;
                }else if(chessComponent[super.getSource().getX()-i][super.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                    q.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()));}
                else{
                    q.add(new ChessboardPoint(super.getSource().getX()-i,super.getSource().getY()));
                    break;
                }
            }
        }
        return q;
    }

}
