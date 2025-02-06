import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{



    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
        if (chessColor.equals(ChessColor.BLACK)) setName('P');
        if (chessColor.equals(ChessColor.WHITE)) setName('p');
        setChessColor(chessColor);
        setSource(source);
    }

    public List<ChessboardPoint> canMoveTo(){
        if (this.getChessColor().equals(ChessColor.BLACK)&&this.getSource().getX()==1){
            List<ChessboardPoint> list=new ArrayList<>();
            list.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-1));
            list.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()));
            list.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+1));
            list.add(new ChessboardPoint(this.getSource().getX()+2,this.getSource().getY()));
            return list;
        } else if (this.getChessColor().equals(ChessColor.BLACK)&&this.getSource().getX()==7){
            return new ArrayList<>();
        } else if (this.getChessColor().equals(ChessColor.WHITE)&&this.getSource().getX()==6){
            List<ChessboardPoint> list=new ArrayList<>();
            list.add(new ChessboardPoint(this.getSource().getX()-2,this.getSource().getY()));
            list.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-1));
            list.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()));
            list.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+1));
            return list;
        } else if (this.getChessColor().equals(ChessColor.WHITE)&&this.getSource().getX()==0){
            return new ArrayList<>();
        } else if (this.getChessColor().equals(ChessColor.BLACK)){
            List<ChessboardPoint> list=new ArrayList<>();
            list.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-1));
            list.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()));
            list.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+1));
            return list;
        } else if (this.getChessColor().equals(ChessColor.WHITE)){
            List<ChessboardPoint> list=new ArrayList<>();
            list.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-1));
            list.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()));
            list.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+1));
            return list;
        } else return new ArrayList<>();
    }
}
