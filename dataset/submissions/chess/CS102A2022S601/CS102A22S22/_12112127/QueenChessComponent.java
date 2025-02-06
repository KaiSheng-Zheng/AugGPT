import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        SourcePoints= (ArrayList<String>) chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> al = new ArrayList<>();

        int C = QueenChessComponent.super.getSource().getY();
        int R = QueenChessComponent.super.getSource().getX();


        if (super.getChessColor() == ChessColor.BLACK) {
            for (int i = 1; i < Math.min(getSource().getY(), getSource().getX()) + 1; i++) {
                boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination1 = QueenChessComponent.super.getSource().offset(-i, -i);
                char A=SourcePoints.get(R-i).charAt(C-i);
                if (A == '_' || A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination1);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < Math.min(7 - getSource().getY(), getSource().getX()) + 1; i++) {
                boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination2 = QueenChessComponent.super.getSource().offset(-i, i);
                char A=SourcePoints.get(R-i).charAt(C+i);
                if (A == '_' || A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination2);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < Math.min(getSource().getY(), 7 - getSource().getX()) + 1; i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination3 = QueenChessComponent.super.getSource().offset(i, -i);
                char A=SourcePoints.get(R+i).charAt(C-i);
                if (A == '_' || A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination3);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < Math.min(7 - getSource().getX(), 7 - getSource().getY()) + 1;i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination4 = QueenChessComponent.super.getSource().offset(i, i);
                char A=SourcePoints.get(R+i).charAt(C+i);
                if (A == '_' ||A == 'q' ||  A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination4);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i <getSource().getY() + 1; i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination5 = QueenChessComponent.super.getSource().offset(0, -i);
                char A=SourcePoints.get(R).charAt(C-i);
                if (A == '_' || A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination5);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < 8 - getSource().getY(); i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination6 = QueenChessComponent.super.getSource().offset(0, i);
                char A=SourcePoints.get(R).charAt(C+i);
                if (A == '_' || A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination6);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < getSource().getX() + 1;i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination7 = QueenChessComponent.super.getSource().offset(-i, 0);
                char A=SourcePoints.get(R-i).charAt(C);
                if (A == '_' ||A == 'q' ||  A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination7);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < 8 - getSource().getX(); i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination8 = QueenChessComponent.super.getSource().offset(i, 0);
                char A=SourcePoints.get(R+i).charAt(C);
                if (A == '_' || A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    bl = true;}
                if (A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination8);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }
        }else{
            for (int i = 1; i < Math.min(getSource().getY(), getSource().getX()) + 1; i++) {
                boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination1 = QueenChessComponent.super.getSource().offset(-i, -i);
                char A=SourcePoints.get(R-i).charAt(C-i);
                if (A == '_' || A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination1);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < Math.min(7 - getSource().getY(), getSource().getX()) + 1; i++) {
                boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination2 = QueenChessComponent.super.getSource().offset(-i, i);
                char A=SourcePoints.get(R-i).charAt(C+i);
                if (A == '_' ||A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    Bl = false;}
                if (bl) {
                    al.add(destination2);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < Math.min(getSource().getY(), 7 - getSource().getX()) + 1; i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination3 = QueenChessComponent.super.getSource().offset(i, -i);
                char A=SourcePoints.get(R+i).charAt(C-i);
                if (A == '_' || A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    Bl = false;}
                if (bl) {
                    al.add(destination3);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < Math.min(7 - getSource().getX(), 7 - getSource().getY()) + 1;i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination4 = QueenChessComponent.super.getSource().offset(i, i);
                char A=SourcePoints.get(R+i).charAt(C+i);
                if (A == '_' ||A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    Bl = false;}
                if (bl) {
                    al.add(destination4);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i <getSource().getY() + 1; i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination5 = QueenChessComponent.super.getSource().offset(0, -i);
                char A=SourcePoints.get(R).charAt(C-i);
                if (A == '_' || A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination5);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < 8 - getSource().getY(); i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination6 = QueenChessComponent.super.getSource().offset(0, i);
                char A=SourcePoints.get(R).charAt(C+i);
                if (A == '_' || A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p' ) {
                    Bl = false;}
                if (bl) {
                    al.add(destination6);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < getSource().getX() + 1;i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination7 = QueenChessComponent.super.getSource().offset(-i, 0);
                char A=SourcePoints.get(R-i).charAt(C);
                if (A == '_' ||A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    Bl = false;}
                if (bl) {
                    al.add(destination7);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
                }
            }

            for (int i = 1; i < 8 - getSource().getX(); i++) {boolean bl=false;
                boolean Bl=true;
                ChessboardPoint destination8 = QueenChessComponent.super.getSource().offset(i, 0);
                char A=SourcePoints.get(R+i).charAt(C);
                if (A == '_' ||A == 'Q' || A == 'K' || A == 'R' || A == 'B' || A == 'N' || A == 'P') {
                    bl = true;}
                if ( A == 'q' || A == 'k' || A == 'r' || A == 'b' || A == 'n' || A == 'p') {
                    Bl = false;}
                if (bl) {
                    al.add(destination8);
                    if (A!='_'){break;}
                } else if (!Bl) {
                    break;
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
