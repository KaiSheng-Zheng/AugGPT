import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    ArrayList<String> SourcePoints;

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, List<String> chessboard) {
        super(source, chessColor, name, chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }

    private boolean check(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint s = getChessboardPoint();
        ChessboardPoint d = destination;
        boolean bl = false;
        boolean Bl = false;
        if ((Math.abs(s.getY()-d.getY())==2&&Math.abs(s.getX()-d.getX())==1)||(Math.abs(s.getY()-d.getY())==1&&Math.abs(s.getX()-d.getX())==2)){
            bl=true;
        }
        if (bl) {char a=SourcePoints.get(d.getX()).charAt(d.getY());
            if (super.getChessColor() == ChessColor.BLACK) {
                if (a== '_' ||a=='q'||a=='k'||a=='r'||a=='b'||a=='n'||a=='p'){
                    Bl = true;
                }
            }else {
                if (a== '_' ||a=='Q'||a=='K'||a=='R'||a=='B'||a=='N'||a=='P'){
                    Bl = true;}
            }
        }
        return Bl;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> al = new ArrayList<>();
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <=7; j++){
                ChessboardPoint p=new ChessboardPoint(i,j);
                if(check(getChessComponents(),p)){
                    al.add(p);
                }
            }
        }
        return al;
    }


}