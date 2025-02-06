import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public ChessboardPoint source;
    private final ChessColor chessColor;

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
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
        ChessboardPoint location1=new ChessboardPoint(this.source.getX()-2,this.source.getY()-1);
        ChessboardPoint location2=new ChessboardPoint(this.source.getX()-1,this.source.getY()-2);
        ChessboardPoint location3=new ChessboardPoint(this.source.getX()+1,this.source.getY()-2);
        ChessboardPoint location4=new ChessboardPoint(this.source.getX()+2,this.source.getY()-1);
        ChessboardPoint location5=new ChessboardPoint(this.source.getX()-2,this.source.getY()+1);
        ChessboardPoint location6=new ChessboardPoint(this.source.getX()-1,this.source.getY()+2);
        ChessboardPoint location7=new ChessboardPoint(this.source.getX()+1,this.source.getY()+2);
        ChessboardPoint location8=new ChessboardPoint(this.source.getX()+2,this.source.getY()+1);
        if ((location1.getX()>=0&location1.getX()<8)&(location1.getY()>=0&location1.getY()<8)&(location1.mapping().getChessColor()!=this.chessColor)){
            locations.add(location1);
        }
        if ((location2.getX()>=0&location2.getX()<8)&(location2.getY()>=0&location2.getY()<8)&(location2.mapping().getChessColor()!=this.chessColor)){
            locations.add(location2);
        }
        if ((location3.getX()>=0&location3.getX()<8)&(location3.getY()>=0&location3.getY()<8)&(location3.mapping().getChessColor()!=this.chessColor)){
            locations.add(location3);
        }
        if ((location4.getX()>=0&location4.getX()<8)&(location4.getY()>=0&location4.getY()<8)&(location4.mapping().getChessColor()!=this.chessColor)){
            locations.add(location4);
        }
        if ((location5.getX()>=0&location5.getX()<8)&(location5.getY()>=0&location5.getY()<8)&(location5.mapping().getChessColor()!=this.chessColor)){
            locations.add(location5);
        }
        if ((location6.getX()>=0&location6.getX()<8)&(location6.getY()>=0&location6.getY()<8)&(location6.mapping().getChessColor()!=this.chessColor)){
            locations.add(location6);
        }
        if ((location7.getX()>=0&location7.getX()<8)&(location7.getY()>=0&location7.getY()<8)&(location7.mapping().getChessColor()!=this.chessColor)){
            locations.add(location7);
        }
        if ((location8.getX()>=0&location8.getX()<8)&(location8.getY()>=0&location8.getY()<8)&(location8.mapping().getChessColor()!=this.chessColor)){
            locations.add(location8);
        }
        return locations;
    }

}