import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    protected char name;
    private ChessboardPoint source;

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> location = new ArrayList<>();

        int i = source.getX();
        int j = source.getY();

        if(this.chessColor == ChessColor.BLACK){
            if(i==1){
                if(chessComponents[i+1][j].getName() == '_'){
                    ChessboardPoint destination1 = new ChessboardPoint(i+1,j);
                    location.add(destination1);
                    if(chessComponents[i+2][j].getName() == '_'){
                        ChessboardPoint destination2 = new ChessboardPoint(i+2,j);
                        location.add(destination2);
                    }
                }

                if(j+1>=0&&j+1<=7&&chessComponents[i+1][j+1].getName() != '_'){
                    if(chessComponents[i+1][j+1].getChessColor() == ChessColor.WHITE){
                        ChessboardPoint destination = new ChessboardPoint(i+1,j+1);
                        location.add(destination);
                    }
                }
                if(j-1>=0&&j-1<=7&&chessComponents[i+1][j-1].getName() != '_'){
                    if(chessComponents[i-1][j+1].getChessColor() == ChessColor.WHITE){
                        ChessboardPoint destination = new ChessboardPoint(i+1,j-1);
                        location.add(destination);
                    }
                }

            }
            else if (i!=1){
                if(i+1<=7&&chessComponents[i+1][j].getName() == '_'){
                    ChessboardPoint destination = new ChessboardPoint(i+1,j);
                    location.add(destination);
                }
                if(i+1<=7&&j+1<=7&&chessComponents[i+1][j+1].getName() != '_'){
                    if(chessComponents[i+1][j+1].getChessColor() == ChessColor.WHITE){
                        ChessboardPoint destination = new ChessboardPoint(i+1,j+1);
                        location.add(destination);
                    }
                }
                if(i+1<=7&&j-1>=0&&chessComponents[i+1][j-1].getName() != '_'){
                    if(chessComponents[i+1][j-1].getChessColor() == ChessColor.WHITE){
                        ChessboardPoint destination = new ChessboardPoint(i+1,j-1);
                        location.add(destination);
                    }
                }
            }
        }

        else if(this.chessColor == ChessColor.WHITE){
            if(i==6){
                if(chessComponents[i-1][j].getName() == '_'){
                    ChessboardPoint destination1 = new ChessboardPoint(i-1,j);
                    location.add(destination1);
                    if(chessComponents[i-2][j].getName() == '_'){
                        ChessboardPoint destination2 = new ChessboardPoint(i-2,j);
                        location.add(destination2);
                    }
                }

                if(i-1>=0&&j-1>=0&&chessComponents[i-1][j-1].getName() != '_'){
                    if(chessComponents[i-1][j-1].getChessColor() == ChessColor.BLACK){
                        ChessboardPoint destination = new ChessboardPoint(i-1,j-1);
                        location.add(destination);
                    }
                }
                if(i-1>=0&&j+1<=7&&chessComponents[i-1][j+1].getName() != '_'){
                    if(chessComponents[i-1][j+1].getChessColor() == ChessColor.BLACK){
                        ChessboardPoint destination = new ChessboardPoint(i-1,j+1);
                        location.add(destination);
                    }
                }

            }
            else if (i!=6){
                if(i-1>=0&&j<=7&&chessComponents[i-1][j].getName() == '_'){
                    ChessboardPoint destination = new ChessboardPoint(i-1,j);
                    location.add(destination);
                }
                if(i-1>=0&&j+1<=7&&chessComponents[i-1][j+1].getName() != '_'){
                    if(chessComponents[i-1][j+1].getChessColor() == ChessColor.BLACK){
                        ChessboardPoint destination = new ChessboardPoint(i-1,j+1);
                        location.add(destination);
                    }
                }
                if(i-1>=0&&i-1>=0&&chessComponents[i-1][j-1].getName() != '_'){
                    if(chessComponents[i-1][j-1].getChessColor() == ChessColor.BLACK){
                        ChessboardPoint destination = new ChessboardPoint(i-1,j-1);
                        location.add(destination);
                    }
                }
            }
        }
        return location;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        this.chessColor = chessColor;
        this.name = name;
        this.source = source;
        this.chessComponents = chessComponents;
        super.setChessColor(chessColor);
        super.setName(name);
        super.setSource(source);
        super.setChessComponents(chessComponents);
    }
}
