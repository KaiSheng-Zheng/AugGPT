import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public ChessboardPoint source;
    private final ChessColor chessColor;

    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
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
        for (int i = 1; i < 8; i++) {
            ChessboardPoint locationLeft=new ChessboardPoint(this.source.getX()-i,this.source.getY());
            if(locationLeft.getX()>=0&locationLeft.available()){
                locations.add(locationLeft);
            }else if(locationLeft.getX()>=0&!locationLeft.available()){
                if (locationLeft.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationLeft);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint locationRight=new ChessboardPoint(this.source.getX()+i,this.source.getY());
            if(locationRight.getX()<8&locationRight.available()){
                locations.add(locationRight);
            }else if(locationRight.getX()<8&!locationRight.available()){
                if (locationRight.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationRight);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint locationUp=new ChessboardPoint(this.source.getX(),this.source.getY()+i);
            if(locationUp.getY()<8&locationUp.available()){
                locations.add(locationUp);
            }else if(locationUp.getY()<8&!locationUp.available()){
                if (locationUp.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationUp);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint locationDown=new ChessboardPoint(this.source.getX(),this.source.getY()-i);
            if(locationDown.getY()>=0&locationDown.available()){
                locations.add(locationDown);
            }else if(locationDown.getY()>=0&!locationDown.available()){
                if (locationDown.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationDown);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i <8; i++) {
            ChessboardPoint locationRU=new ChessboardPoint(this.source.getX()+i,this.source.getY()+i);
            if(locationRU.getX()<8&locationRU.getY()<8&locationRU.available()){
                locations.add(locationRU);
            }else if(locationRU.getX()<8&locationRU.getY()<8&!locationRU.available()){
                if (locationRU.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationRU);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint locationLU=new ChessboardPoint(this.source.getX()-i,this.source.getY()+i);
            if(locationLU.getX()>=0&locationLU.getY()<8&locationLU.available()){
                locations.add(locationLU);
            }else if(locationLU.getX()>=0&locationLU.getY()<8&!locationLU.available()){
                if (locationLU.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationLU);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i <8; i++) {
            ChessboardPoint locationRD=new ChessboardPoint(this.source.getX()+i,this.source.getY()-i);
            if(locationRD.getX()<8&locationRD.getY()>=0&locationRD.available()){
                locations.add(locationRD);
            }else if(locationRD.getX()<8&locationRD.getY()>=0&!locationRD.available()){
                if (locationRD.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationRD);
                }
                break;
            }else {
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint locationLD=new ChessboardPoint(this.source.getX()-i,this.source.getY()-i);
            if (locationLD.getX()>=0&locationLD.getY()>=0&locationLD.available()){
                locations.add(locationLD);
            }else if (locationLD.getX()>=0&locationLD.getY()>=0&!locationLD.available()){
                if (locationLD.mapping().getChessColor() != this.chessColor) {
                    locations.add(locationLD);
                }
                break;
            }else {
                break;
            }
        }
        return locations;
    }

}