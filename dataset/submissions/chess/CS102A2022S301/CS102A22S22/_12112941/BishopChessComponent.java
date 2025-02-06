import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessColor color;
    ChessComponent[][] a;
    public BishopChessComponent(ChessComponent[][] a){
        this.a=a;
        if (name=='B')
            color=ChessColor.BLACK;
        else if (name=='b')
            color=ChessColor.WHITE;
    }
//    public ChessColor getColor() {
//        return color;
//    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPointList=new ArrayList<>();
        int i5=1;
        int i6=1;
        int i7=1;

        int j5=-1;
        int j6=-1;
        int j7=-1;

        if (name=='B'){
            while (ConcreteChessGame.x+i5 <= 7&&ConcreteChessGame.y+i5 <= 7) {
                if (a[ConcreteChessGame.x+i5][ConcreteChessGame.y + i5].name >=95) {
                    if (a[ConcreteChessGame.x+i5][ConcreteChessGame.y + i5].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i5, ConcreteChessGame.y + i5));
                        i5++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i5, ConcreteChessGame.y + i5));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x+j5 >= 0&&ConcreteChessGame.y+j5 >= 0) {
                if (a[ConcreteChessGame.x+j5][ConcreteChessGame.y + j5].name >=95) {
                    if (a[ConcreteChessGame.x+j5][ConcreteChessGame.y + j5].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j5, ConcreteChessGame.y + j5));
                        j5--;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j5, ConcreteChessGame.y + j5));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x+j6 >= 0&&ConcreteChessGame.y+i6 <= 7) {
                if (a[ConcreteChessGame.x+j6][ConcreteChessGame.y + i6].name >=95) {
                    if (a[ConcreteChessGame.x+j6][ConcreteChessGame.y + i6].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j6, ConcreteChessGame.y + i6));
                        j6--;
                        i6++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j6, ConcreteChessGame.y + i6));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x+i7 <= 7&&ConcreteChessGame.y+j7 >= 0) {
                if (a[ConcreteChessGame.x+i7][ConcreteChessGame.y + j7].name >=95) {
                    if (a[ConcreteChessGame.x+i7][ConcreteChessGame.y + j7].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i7, ConcreteChessGame.y + j7));
                        j7--;
                        i7++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i7, ConcreteChessGame.y + j7));
                        break;
                    }
                }
                else
                    break;
            }
        }
        if (name=='b'){
            while (ConcreteChessGame.x+i5 <= 7&&ConcreteChessGame.y+i5 <= 7) {
                if (a[ConcreteChessGame.x+i5][ConcreteChessGame.y + i5].name <=95) {
                    if (a[ConcreteChessGame.x+i5][ConcreteChessGame.y + i5].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i5, ConcreteChessGame.y + i5));
                        i5++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i5, ConcreteChessGame.y + i5));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x+j5 >= 0&&ConcreteChessGame.y+j5 >= 0) {
                if (a[ConcreteChessGame.x+j5][ConcreteChessGame.y + j5].name <=95) {
                    if (a[ConcreteChessGame.x+j5][ConcreteChessGame.y + j5].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j5, ConcreteChessGame.y + j5));
                        j5--;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j5, ConcreteChessGame.y + j5));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x+j6 >= 0&&ConcreteChessGame.y+i6 <= 7) {
                if (a[ConcreteChessGame.x+j6][ConcreteChessGame.y + i6].name <=95) {
                    if (a[ConcreteChessGame.x+j6][ConcreteChessGame.y + i6].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j6, ConcreteChessGame.y + i6));
                        j6--;
                        i6++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+j6, ConcreteChessGame.y + i6));
                        break;
                    }
                }
                else
                    break;
            }
            while (ConcreteChessGame.x+i7 <= 7&&ConcreteChessGame.y+j7 >= 0) {
                if (a[ConcreteChessGame.x+i7][ConcreteChessGame.y + j7].name <=95) {
                    if (a[ConcreteChessGame.x+i7][ConcreteChessGame.y + j7].name ==95) {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i7, ConcreteChessGame.y + j7));
                        j7--;
                        i7++;
                    }
                    else {
                        chessboardPointList.add(new ChessboardPoint(ConcreteChessGame.x+i7, ConcreteChessGame.y + j7));
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
