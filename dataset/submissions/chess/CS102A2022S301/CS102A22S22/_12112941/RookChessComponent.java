import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessColor color;
    ChessComponent[][] a;
    public RookChessComponent(ChessComponent[][] a){
        this.a=a;
        if (name=='R')
            color=ChessColor.BLACK;
        else if (name=='r')
            color=ChessColor.WHITE;
    }
    public ChessColor getColor() {
        return color;
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPointList=new ArrayList<>();
        int i1=1;
        int i2=1;
        int i3=1;
        int i4=1;
        int j1=-1;
        int j2=-1;
        int j3=-1;
        int j4=-1;
        if (name=='R') {
            while (ConcreteChessGame.y + i1 <= 7) {
                if (a[ConcreteChessGame.x][ConcreteChessGame.y + i1].name >=95) {
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + i1].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + i1));
                        i1++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + i1));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.y + j1 >=0 ) {
                if (a[ConcreteChessGame.x][ConcreteChessGame.y + j1].name >=95) {
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + j1].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + j1));
                        j1--;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + j1));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x + i2 <= 7) {
                if (a[ConcreteChessGame.x+i2][ConcreteChessGame.y ].name >=95) {
                    if (a[ConcreteChessGame.x+i2][ConcreteChessGame.y ].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i2, ConcreteChessGame.y ));
                        i2++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i2, ConcreteChessGame.y ));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x + j2 >=0 ) {
                if (a[ConcreteChessGame.x+j2][ConcreteChessGame.y ].name >=95) {
                    if (a[ConcreteChessGame.x+j2][ConcreteChessGame.y ].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j2, ConcreteChessGame.y ));
                        j2--;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j2, ConcreteChessGame.y ));
                        break;
                    }
                }
                else
                    break;
            }

        }
        if (name=='r') {
            while (ConcreteChessGame.y + i3 <= 7) {
                if (a[ConcreteChessGame.x][ConcreteChessGame.y + i3].name <=95) {
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + i3].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + i3));
                        i3++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + i3));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.y + j3 >=0 ) {
                if (a[ConcreteChessGame.x][ConcreteChessGame.y + j3].name <=95) {
                    if (a[ConcreteChessGame.x][ConcreteChessGame.y + j3].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + j3));
                        j3--;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x, ConcreteChessGame.y + j3));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x + i4 <= 7) {
                if (a[ConcreteChessGame.x+i4][ConcreteChessGame.y ].name <=95) {
                    if (a[ConcreteChessGame.x+i4][ConcreteChessGame.y ].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i4, ConcreteChessGame.y ));
                        i4++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i4, ConcreteChessGame.y ));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x + j4 >=0 ) {
                if (a[ConcreteChessGame.x+j4][ConcreteChessGame.y ].name <=95) {
                    if (a[ConcreteChessGame.x+j4][ConcreteChessGame.y ].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j4, ConcreteChessGame.y ));
                        j4--;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j4, ConcreteChessGame.y ));
                        break;
                    }
                }
                else
                    break;
            }

        }
        chessboardPointList.sort(new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX()>o2.getX())
                    return 1;
                else if (o1.getX()<o2.getX())
                    return -1;
                else {
                    if (o1.getY() >o2.getY())
                        return 1;
                    else if (o1.getY() < o2.getY())
                        return -1;
                    else
                        return 0;
                }
            }
        });
        return chessboardPointList;


    }
}
