import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class KingChessComponent extends ChessComponent{
    public ChessboardPoint source;
    private final ChessColor chessColor;

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
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

    public boolean willDie(){
        boolean willDie=false;
        if(this.chessColor==ChessColor.BLACK){
            for (int i = 17; i < 32; i++) {
                for (int j = 0; j < data.allChessComponent[i].canMoveTo().size(); j++) {
                    if (this.source.getX() == data.allChessComponent[i].canMoveTo().get(j).getX() & this.source.getY() == data.allChessComponent[i].canMoveTo().get(j).getY()) {
                        willDie = true;
                        break;
                    }
                }
            }
            if((Math.abs(this.source.getX()-data.allChessComponent[16].getSource().getX())<=1)&(Math.abs(this.source.getY()-data.allChessComponent[16].getSource().getY())<=1)){
                willDie=true;
            }
        }else {
            for (int i = 1; i < 16; i++) {
                for (int j = 0; j < data.allChessComponent[i].canMoveTo().size(); j++) {
                    if (this.source.getX() == data.allChessComponent[i].canMoveTo().get(j).getX() & this.source.getY() == data.allChessComponent[i].canMoveTo().get(j).getY()) {
                        willDie = true;
                        break;
                    }
                }
            }
            if((Math.abs(this.source.getX()-data.allChessComponent[0].getSource().getX())<=1)&(Math.abs(this.source.getY()-data.allChessComponent[0].getSource().getY())<=1)){
                willDie=true;
            }
        }
        return willDie;
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> locations=new ArrayList<>();
        ChessboardPoint location1=new ChessboardPoint(this.source.getX()-1,this.source.getY()-1);
        ChessboardPoint location2=new ChessboardPoint(this.source.getX()-1,this.source.getY());
        ChessboardPoint location3=new ChessboardPoint(this.source.getX()-1,this.source.getY()+1);
        ChessboardPoint location4=new ChessboardPoint(this.source.getX(),this.source.getY()-1);
        ChessboardPoint location5=new ChessboardPoint(this.source.getX(),this.source.getY()+1);
        ChessboardPoint location6=new ChessboardPoint(this.source.getX()+1,this.source.getY()-1);
        ChessboardPoint location7=new ChessboardPoint(this.source.getX()+1,this.source.getY());
        ChessboardPoint location8=new ChessboardPoint(this.source.getX()+1,this.source.getY()+1);
        if(this.chessColor==ChessColor.BLACK) {
            if(location1.getX()>=0&location1.getY()>=0&location1.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location1);
            }
            if(location2.getX()>=0&location2.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location2);
            }
            if(location3.getX()>=0&location3.getY()<8&location3.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location3);
            }
            if(location4.getY()>=0&location4.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location4);
            }
            if(location5.getY()<8&location5.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location5);
            }
            if(location6.getX()<8&location6.getY()>=0&location6.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location6);
            }
            if(location7.getX()<8&location7.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location7);
            }
            if(location8.getX()<8&location8.getY()<8&location8.mapping().getChessColor()!=ChessColor.BLACK){
                locations.add(location8);
            }
        }else {
            if(location1.getX()>=0&location1.getY()>=0&location1.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location1);
            }
            if(location2.getX()>=0&location2.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location2);
            }
            if(location3.getX()>=0&location3.getY()<8&location3.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location3);
            }
            if(location4.getY()>=0&location4.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location4);
            }
            if(location5.getY()<8&location5.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location5);
            }
            if(location6.getX()<8&location6.getY()>=0&location6.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location6);
            }
            if(location7.getX()<8&location7.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location7);
            }
            if(location8.getX()<8&location8.getY()<8&location8.mapping().getChessColor()!=ChessColor.WHITE){
                locations.add(location8);
            }
        }
        return locations;
    }

    public List<ChessboardPoint> canMoveTo(int a){
        ChessboardPoint copy=this.source;
        List<ChessboardPoint> locations=new ArrayList<>();
        ChessboardPoint location1=new ChessboardPoint(this.source.getX()-1,this.source.getY()-1);
        ChessboardPoint location2=new ChessboardPoint(this.source.getX()-1,this.source.getY());
        ChessboardPoint location3=new ChessboardPoint(this.source.getX()-1,this.source.getY()+1);
        ChessboardPoint location4=new ChessboardPoint(this.source.getX(),this.source.getY()-1);
        ChessboardPoint location5=new ChessboardPoint(this.source.getX(),this.source.getY()+1);
        ChessboardPoint location6=new ChessboardPoint(this.source.getX()+1,this.source.getY()-1);
        ChessboardPoint location7=new ChessboardPoint(this.source.getX()+1,this.source.getY());
        ChessboardPoint location8=new ChessboardPoint(this.source.getX()+1,this.source.getY()+1);
        if(this.chessColor==ChessColor.BLACK) {
            if(location1.getX()>=0&location1.getY()>=0&location1.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location1;
                if(!this.willDie()){
                    locations.add(location1);
                }
                this.source=copy;
            }
            if(location2.getX()>=0&location2.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location2;
                if(!this.willDie()){
                    locations.add(location2);
                }
                this.source=copy;
            }
            if(location3.getX()>=0&location3.getY()<8&location3.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location3;
                if(!this.willDie()){
                    locations.add(location3);
                }
                this.source=copy;
            }
            if(location4.getY()>=0&location4.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location4;
                if(!this.willDie()){
                    locations.add(location4);
                }
                this.source=copy;
            }
            if(location5.getY()<8&location5.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location5;
                if(!this.willDie()){
                    locations.add(location5);
                }
                this.source=copy;
            }
            if(location6.getX()<8&location6.getY()>=0&location6.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location6;
                if(!this.willDie()){
                    locations.add(location6);
                }
                this.source=copy;
            }
            if(location7.getX()<8&location7.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location7;
                if(!this.willDie()){
                    locations.add(location7);
                }
                this.source=copy;
            }
            if(location8.getX()<8&location8.getY()<8&location8.mapping().getChessColor()!=ChessColor.BLACK){
                this.source=location8;
                if(!this.willDie()){
                    locations.add(location8);
                }
                this.source=copy;
            }
        }else {
            if(location1.getX()>=0&location1.getY()>=0&location1.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location1;
                if(!this.willDie()){
                    locations.add(location1);
                }
                this.source=copy;
            }
            if(location2.getX()>=0&location2.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location2;
                if(!this.willDie()){
                    locations.add(location2);
                }
                this.source=copy;
            }
            if(location3.getX()>=0&location3.getY()<8&location3.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location3;
                if(!this.willDie()){
                    locations.add(location3);
                }
                this.source=copy;
            }
            if(location4.getY()>=0&location4.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location4;
                if(!this.willDie()){
                    locations.add(location4);
                }
                this.source=copy;
            }
            if(location5.getY()<8&location5.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location5;
                if(!this.willDie()){
                    locations.add(location5);
                }
                this.source=copy;
            }
            if(location6.getX()<8&location6.getY()>=0&location6.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location6;
                if(!this.willDie()){
                    locations.add(location6);
                }
                this.source=copy;
            }
            if(location7.getX()<8&location7.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location7;
                if(!this.willDie()){
                    locations.add(location7);
                }
                this.source=copy;
            }
            if(location8.getX()<8&location8.getY()<8&location8.mapping().getChessColor()!=ChessColor.WHITE){
                this.source=location8;
                if(!this.willDie()){
                    locations.add(location8);
                }
                this.source=copy;
            }
        }
        return locations;
    }
}