import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    ChessboardPoint chessboardPoint;
    ChessColor chessColor;
    ChessComponent[][] chessComponents ;
    QueenChessComponent( ChessboardPoint source ,ChessColor chessColor, ChessComponent[][] chessComponents ){
        super.setSource(source.getX(),source.getY());
        super.setChessColor(chessColor);
        super.setChessComponents(chessComponents);
        this.chessboardPoint = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> RNG = new ArrayList<>();
        ChessboardPoint source = getSource();
        for(int i = 1 ; i < 1+Math.min(source.getX(),source.getY()) ; i++){
            if(source.getY()-i>=0&& source.getX()-i>=0){
                if(chessComponents[source.getX()-i][source.getY()-i].getChessColor() == ChessColor.NONE){
                    RNG.add(new ChessboardPoint(source.getX()-i, source.getY()-i));
                }else if(chessComponents[source.getX()-i][source.getY()-i].getChessColor() == this.chessColor){
                    break;
                }else if(chessComponents[source.getX()-i][source.getY()-i].getChessColor() != ChessColor.NONE&&
                        chessComponents[source.getX()-i][source.getY()-i].getChessColor() != this.chessColor){
                    RNG.add(new ChessboardPoint(source.getX()-i, source.getY()-i));break;}
            }
        }
        for(int i = 1 ; i < 8-Math.max(source.getX(), source.getY()) ; i++){
            if(chessComponents[source.getX()+i][source.getY()+i].getChessColor() == ChessColor.NONE){
                RNG.add(new ChessboardPoint(source.getX()+i, source.getY()+i));
            }else if(chessComponents[source.getX()+i][source.getY()+i].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[source.getX()+i][source.getY()+i].getChessColor() != ChessColor.NONE&&
                    chessComponents[source.getX()+i][source.getY()+i].getChessColor() != this.chessColor){
                RNG.add(new ChessboardPoint(source.getX()+i, source.getY()+i));break;
            }
        }
        for(int i = 1 ; i < 1+Math.min(8-source.getX(),source.getY()) ; i++){
            if(source.getY()-i>=0){
                if(chessComponents[source.getX()+i][source.getY()-i].getChessColor() == ChessColor.NONE){
                    RNG.add(new ChessboardPoint(source.getX()+i, source.getY()-i));
                }else if(chessComponents[source.getX()+i][source.getY()-i].getChessColor() == this.chessColor){
                    break;
                }else if(chessComponents[source.getX()+i][source.getY()-i].getChessColor() != ChessColor.NONE&&
                        chessComponents[source.getX()+i][source.getY()-i].getChessColor() != this.chessColor){
                    RNG.add(new ChessboardPoint(source.getX()+i, source.getY()-i));break;}
            }
        }
        for(int i = 1 ; i <= Math.min(source.getX(),8-source.getY()) ; i++){
            if(source.getX()-i>=0){
                if(chessComponents[source.getX()-i][source.getY()+i].getChessColor() == ChessColor.NONE){
                    RNG.add(new ChessboardPoint(source.getX()-i, source.getY()+i));
                }else if(chessComponents[source.getX()-i][source.getY()+i].getChessColor() == this.chessColor){
                    break;
                }else if(chessComponents[source.getX()-i][source.getY()+i].getChessColor() != ChessColor.NONE&&
                        chessComponents[source.getX()-i][source.getY()+i].getChessColor() != this.chessColor){
                    RNG.add(new ChessboardPoint(source.getX()-i, source.getY()+i));break;}
            }
        }
        for (int i = source.getX()-1 ; i >= 0 ; i--){
            if(chessComponents[i][source.getY()].getChessColor() == ChessColor.NONE){
                RNG.add(new ChessboardPoint(i,source.getY()));
            }else if(chessComponents[i][source.getY()].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[i][source.getY()].getChessColor() != this.chessColor&&
                    chessComponents[i][source.getY()].getChessColor() != ChessColor.NONE){
                RNG.add(new ChessboardPoint(i,source.getY()));break;
            }
        }for (int i = source.getX()+1 ; i < 8 ; i++){
            if(chessComponents[i][source.getY()].getChessColor() == ChessColor.NONE){
                RNG.add(new ChessboardPoint(i,source.getY()));
            }else if(chessComponents[i][source.getY()].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[i][source.getY()].getChessColor() != this.chessColor&&
                    chessComponents[i][source.getY()].getChessColor() != ChessColor.NONE){
                RNG.add(new ChessboardPoint(i,source.getY()));break;
            }
        }for (int i = source.getY()-1 ; i >= 0 ; i--){
            if(chessComponents[source.getX()][i].getChessColor() == ChessColor.NONE){
                RNG.add(new ChessboardPoint(source.getX(),i));
            }else if(chessComponents[source.getX()][i].getChessColor() == this.chessColor) {
                break;
            }else if(chessComponents[source.getX()][i].getChessColor() != this.chessColor&&
                    chessComponents[source.getX()][i].getChessColor() != ChessColor.NONE){
                RNG.add(new ChessboardPoint(source.getX(),i));break;
            }
        }for (int i = source.getY()+1 ; i < 8 ; i++){
            if(chessComponents[source.getX()][i].getChessColor() == ChessColor.NONE){
                RNG.add(new ChessboardPoint(source.getX(),i));
            }else if(chessComponents[source.getX()][i].getChessColor() == this.chessColor){
                break;
            }else if(chessComponents[source.getX()][i].getChessColor() != this.chessColor&&
                    chessComponents[source.getX()][i].getChessColor() != ChessColor.NONE){
                RNG.add(new ChessboardPoint(source.getX(),i));break;
            }
        }
        return RNG;
    }
}
