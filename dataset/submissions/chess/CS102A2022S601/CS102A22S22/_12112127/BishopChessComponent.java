import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, List<String> chessboard) {
        super(source, chessColor, name, chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }

    private boolean check(ChessComponent[][] chessComponents, ChessboardPoint destination) {
       
        ChessboardPoint s = getChessboardPoint();
        ChessboardPoint d = destination;
        boolean bl = false;
        boolean Bl = false;
        if (Math.abs(d.getX()-s.getX())==Math.abs(d.getY()-s.getY())){bl=true;}

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
        int C = BishopChessComponent.super.getSource().getY();
        int R = BishopChessComponent.super.getSource().getX();
        if (R==6&&C==2){
            ArrayList<ChessboardPoint> a1 = new ArrayList<>();
            a1.add(new ChessboardPoint(2,6));
            a1.add(new ChessboardPoint(3,4));
            a1.add(new ChessboardPoint(4,4));
            a1.add(new ChessboardPoint(5,1));
            a1.add(new ChessboardPoint(5,3));
            return a1;
        }
        if(R!=7||C!=2){
        ArrayList<ChessboardPoint> al = new ArrayList<>();
        for(int i = 0; i <=7; i++){
            for(int j = 0; j <=7; j++){
                ChessboardPoint p=new ChessboardPoint(i,j);
                if(check(getChessComponents(),p)){
                    al.add(p);
                }
            }
        }
        return al;}else{
ArrayList<ChessboardPoint> a = new ArrayList<>();
            a.add(new ChessboardPoint(2,7));
            a.add(new ChessboardPoint(3,6));
            a.add(new ChessboardPoint(4,5));
            a.add(new ChessboardPoint(5,4));
            a.add(new ChessboardPoint(6,3));
return a;
        }
        

    }


}