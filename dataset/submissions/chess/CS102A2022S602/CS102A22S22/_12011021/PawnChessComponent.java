import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public ChessboardPoint source;
    private final ChessColor chessColor;

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super();
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> locations=new ArrayList<>();
        if(this.chessColor==ChessColor.BLACK){
            if(this.source.getX()==1){
                if(!new ChessboardPoint(2,this.source.getY()).available()){;
                }else if((new ChessboardPoint(2,this.source.getY()).available())&!(new ChessboardPoint(3,this.source.getY()).available())){
                    locations.add(new ChessboardPoint(2,this.source.getY()));
                }else {
                    locations.add(new ChessboardPoint(2,this.source.getY()));
                    locations.add(new ChessboardPoint(3,this.source.getY()));
                }
                if(new ChessboardPoint(2,this.source.getY()-1).mapping().getChessColor()==ChessColor.WHITE){
                    locations.add(new ChessboardPoint(2,this.source.getY()-1));
                }
                if(new ChessboardPoint(2,this.source.getY()+1).mapping().getChessColor()==ChessColor.WHITE){
                    locations.add(new ChessboardPoint(2,this.source.getY()+1));
                }

            }else{
                if(new ChessboardPoint(this.source.getX()+1,this.source.getY()).available()){
                    locations.add(new ChessboardPoint(this.source.getX()+1,this.source.getY()));
                }
                if (new ChessboardPoint(this.source.getX()+1,this.source.getY()-1).mapping().getChessColor()==ChessColor.WHITE){
                    locations.add(new ChessboardPoint(this.source.getX()+1,this.source.getY()-1));
                }
                if (new ChessboardPoint(this.source.getX()+1,this.source.getY()+1).mapping().getChessColor()==ChessColor.WHITE){
                    locations.add(new ChessboardPoint(this.source.getX()+1,this.source.getY()+1));
                }
            }
        }else {
            if(this.source.getX()==6){
                if(!new ChessboardPoint(5,this.source.getY()).available()){;
                }else if((new ChessboardPoint(5,this.source.getY()).available())&!(new ChessboardPoint(4,this.source.getY()).available())){
                    locations.add(new ChessboardPoint(5,this.source.getY()));
                }else {
                    locations.add(new ChessboardPoint(5,this.source.getY()));
                    locations.add(new ChessboardPoint(4,this.source.getY()));
                }
                if(new ChessboardPoint(5,this.source.getY()-1).mapping().getChessColor()==ChessColor.BLACK){
                    locations.add(new ChessboardPoint(5,this.source.getY()-1));
                }
                if(new ChessboardPoint(5,this.source.getY()+1).mapping().getChessColor()==ChessColor.BLACK){
                    locations.add(new ChessboardPoint(5,this.source.getY()+1));
                }

            }else{
                if(new ChessboardPoint(this.source.getX()-1,this.source.getY()).available()){
                    locations.add(new ChessboardPoint(this.source.getX()-1,this.source.getY()));
                }
                if (new ChessboardPoint(this.source.getX()-1,this.source.getY()-1).mapping().getChessColor()==ChessColor.BLACK){
                    locations.add(new ChessboardPoint(this.source.getX()-1,this.source.getY()-1));
                }
                if (new ChessboardPoint(this.source.getX()-1,this.source.getY()+1).mapping().getChessColor()==ChessColor.BLACK){
                    locations.add(new ChessboardPoint(this.source.getX()-1,this.source.getY()+1));
                }
            }
        }
        return locations;
    }
}