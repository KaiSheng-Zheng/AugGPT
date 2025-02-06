import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private List<String> SourcePoints;
    private List<ChessboardPoint> move=new ArrayList<ChessboardPoint>();

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int X=super.getSource().getX(); int Y=super.getSource().getY();
        List<ChessboardPoint> move= new ArrayList<>();
        if (super.getChessColor()==ChessColor.WHITE) {
            int A = 1;
            while (X + A < 8) {
                if (SourcePoints.get(X + A).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X + A, Y));
                    A++;
                } else if ((int) SourcePoints.get(X + A).charAt(Y) < 95) {
                    move.add(new ChessboardPoint(X + A, Y));break;
                }else if ((int) SourcePoints.get(X + A).charAt(Y) > 95){
                    break;
                }
            }
            int B=1;
            while (X - B >= 0) {
                if (SourcePoints.get(X - B).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X - B, Y));
                    B++;
                } else if ((int) SourcePoints.get(X - B).charAt(Y) < 95) {
                    move.add(new ChessboardPoint(X -B, Y));break;
                }else if ((int) SourcePoints.get(X - B).charAt(Y) > 95){break;}
            }
            int C= 1;
            while (Y + C < 8) {
                if (SourcePoints.get(X).charAt(Y+C) == '_') {
                    move.add(new ChessboardPoint(X , Y+C));
                    C++;
                } else if ((int) SourcePoints.get(X ).charAt(Y+C) < 95) {
                    move.add(new ChessboardPoint(X , Y+C));break;
                }else if ((int) SourcePoints.get(X).charAt(Y+C) >95){
                    break;
                }
            }
            int D=1;
            while (Y- D >= 0) {
                if (SourcePoints.get(X).charAt(Y- D) == '_') {
                    move.add(new ChessboardPoint(X , Y- D));
                    D++;
                } else if ((int) SourcePoints.get(X).charAt(Y- D) < 95) {
                    move.add(new ChessboardPoint(X , Y- D));break;
                }else if ((int) SourcePoints.get(X).charAt(Y- D) > 95){break;}
            }

        }
        else if (super.getChessColor()==ChessColor.BLACK){
            int A = 1;
            while (X + A < 8) {
                if (SourcePoints.get(X + A).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X + A, Y));
                    A++;
                } else if ((int) SourcePoints.get(X + A).charAt(Y) > 95) {
                    move.add(new ChessboardPoint(X + A, Y));break;
                }else if ((int) SourcePoints.get(X + A).charAt(Y) < 95){
                    break;
                }
            }
            int B=1;
            while (X - B >= 0) {
                if (SourcePoints.get(X - B).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X - B, Y));
                    B++;
                } else if ((int) SourcePoints.get(X - B).charAt(Y) > 95) {
                    move.add(new ChessboardPoint(X -B, Y));break;
                }else if ((int) SourcePoints.get(X - B).charAt(Y) < 95){break;}
            }
            int C= 1;
            while (Y + C < 8) {
                if (SourcePoints.get(X).charAt(Y+C) == '_') {
                    move.add(new ChessboardPoint(X , Y+C));
                    C++;
                } else if ((int) SourcePoints.get(X ).charAt(Y+C) > 95) {
                    move.add(new ChessboardPoint(X , Y+C));break;
                }else if ((int) SourcePoints.get(X).charAt(Y+C) < 95){
                    break;
                }
            }
            int D=1;
            while (Y- D >= 0) {
                if (SourcePoints.get(X).charAt(Y- D) == '_') {
                    move.add(new ChessboardPoint(X , Y- D));
                    D++;
                } else if ((int) SourcePoints.get(X).charAt(Y- D) > 95) {
                    move.add(new ChessboardPoint(X , Y- D));break;
                }else if ((int) SourcePoints.get(X).charAt(Y- D) < 95){break;}
            }

        }
        Collections.sort(move);
        return move;
    }
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,List<String> ChessList) {
        super(source,chessColor,name,ChessList);
        this.SourcePoints=ChessList;
    }
}