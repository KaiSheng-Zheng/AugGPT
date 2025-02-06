import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        SourcePoints= (ArrayList<String>) chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> al=new ArrayList<>();
        if (super.getChessColor()==ChessColor.BLACK) {
            if (super.getSource().getX() < 7) {
                if (SourcePoints.get(super.getSource().getX() + 1).charAt(super.getSource().getY()) == '_') {
                    al.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()));
                }
            }
            if (super.getSource().getX() == 1) {
                if ((int) SourcePoints.get(super.getSource().getX() + 2).charAt(super.getSource().getY()) == '_') {
                    al.add(new ChessboardPoint(super.getSource().getX() + 2, super.getSource().getY()));
                }
            }
            if (super.getSource().getX() < 7) {
                if (super.getSource().getY() < 7) {
                    if ((int) SourcePoints.get(super.getSource().getX() + 1).charAt(super.getSource().getY() + 1) > 96) {
                        al.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() + 1));
                    }
                }
                if (super.getSource().getY() >= 1) {
                    if ((int) SourcePoints.get(super.getSource().getX() + 1).charAt(super.getSource().getY() - 1) > 96) {
                        al.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() - 1));
                    }
                }
            }
        }else {
            if (super.getSource().getX() >= 1) {
                if (SourcePoints.get(super.getSource().getX() - 1).charAt(super.getSource().getY()) == '_') {
                    al.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()));
                }
            }
            if (super.getSource().getX() == 7) {
                if ((int) SourcePoints.get(super.getSource().getX() - 2).charAt(super.getSource().getY()) == '_') {
                    al.add(new ChessboardPoint(super.getSource().getX() - 2, super.getSource().getY()));
                }
            }
            if (super.getSource().getX() >= 1) {
                if (super.getSource().getY() >= 1) {
                    if ((int) SourcePoints.get(super.getSource().getX() - 1).charAt(super.getSource().getY() - 1) < 91) {
                        al.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() - 1));
                    }
                }
                if (super.getSource().getY() < 7) {
                    if ((int) SourcePoints.get(super.getSource().getX() - 1).charAt(super.getSource().getY() + 1) < 91) {
                        al.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() + 1));
                    }
                }
            }
        }

        for (int i=0;i<al.size();i++){
            for (int j=i+1;j<al.size();j++){
                if (al.get(i).getX()>al.get(j).getX()){

                    Collections.swap(al,i,j);
                }else if (


                        al.get(i).getX()==al.get(j).getX()&&al.get(i).getY()>al.get(j).getY()){
                    Collections.swap(al,i,j);
                }
            }
        }
        return al;
    }
    public void setName(char a) {
        super.setName(a);
    }

    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
    }

    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

}
