import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private List<ChessboardPoint> move= new ArrayList<>();
    private List<String> SourcePoints;

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name,List<String> ChessList) {
        super(source,chessColor,name,ChessList);
        this.SourcePoints=ChessList;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int X=super.getSource().getX(); int Y=super.getSource().getY();
        List<ChessboardPoint> move= new ArrayList<>();
        if (super.getChessColor()==ChessColor.WHITE) {
            int E=1;
            while (X+E<8&&Y+E<8) {
                if (SourcePoints.get(X+E).charAt(Y+E) == '_') {
                    move.add(new ChessboardPoint(X+E , Y+E));
                    E++;
                } else if ((int) SourcePoints.get(X+E).charAt(Y+E) < 95) {
                    move.add(new ChessboardPoint(X+E, Y+E));break;
                }else if ((int) SourcePoints.get(X+E).charAt(Y+E) > 95){break;}
            }
            int F=1;
            while (X-F>=0&&Y-F>=0) {
                if (SourcePoints.get(X-F).charAt(Y-F) == '_') {
                    move.add(new ChessboardPoint(X-F , Y-F));
                    F++;
                } else if ((int) SourcePoints.get(X-F).charAt(Y-F) < 95) {
                    move.add(new ChessboardPoint(X-F, Y-F));break;
                }else if ((int) SourcePoints.get(X-F).charAt(Y-F) > 95){break;}
            }
            int G=1;
            while (X-G>=0&&Y+G<8) {
                if (SourcePoints.get(X-G).charAt(Y+G) == '_') {
                    move.add(new ChessboardPoint(X-G , Y+G));
                    G++;
                } else if ((int) SourcePoints.get(X-G).charAt(Y+G) < 95) {
                    move.add(new ChessboardPoint(X-G, Y+G));break;
                }else if ((int) SourcePoints.get(X-G).charAt(Y+G) > 95){break;}
            }
            int H=1;
            while (Y-H>=0&&X+H<8) {
                if (SourcePoints.get(X+H).charAt(Y-H) == '_') {
                    move.add(new ChessboardPoint(X+H , Y-H));
                    H++;
                } else if ((int) SourcePoints.get(X+H).charAt(Y-H) <95) {
                    move.add(new ChessboardPoint(X+H, Y-H));break;
                }else if ((int) SourcePoints.get(X+H).charAt(Y-H) > 95){break;}
            }

        }
        else if (super.getChessColor()==ChessColor.BLACK){
            int E=1;
            while (X+E<8&&Y+E<8) {
                if (SourcePoints.get(X+E).charAt(Y+E) == '_') {
                    move.add(new ChessboardPoint(X+E , Y+E));
                    E++;
                } else if ((int) SourcePoints.get(X+E).charAt(Y+E) > 95) {
                    move.add(new ChessboardPoint(X+E, Y+E));break;
                }else if ((int) SourcePoints.get(X+E).charAt(Y+E) < 95){break;}
            }
            int F=1;
            while (X-F>=0&&Y-F>=0) {
                if (SourcePoints.get(X-F).charAt(Y-F) == '_') {
                    move.add(new ChessboardPoint(X-F , Y-F));
                    F++;
                } else if ((int) SourcePoints.get(X-F).charAt(Y-F) > 95) {
                    move.add(new ChessboardPoint(X-F, Y-F));break;
                }else if ((int) SourcePoints.get(X-F).charAt(Y-F) < 95){break;}
            }
            int G=1;
            while (X-G>=0&&Y+G<8) {
                if (SourcePoints.get(X-G).charAt(Y+G) == '_') {
                    move.add(new ChessboardPoint(X-G , Y+G));
                    G++;
                } else if ((int) SourcePoints.get(X-G).charAt(Y+G) > 95) {
                    move.add(new ChessboardPoint(X-G, Y+G));break;
                }else if ((int) SourcePoints.get(X-G).charAt(Y+G) < 95){break;}
            }
            int H=1;
            while (Y-H>=0&&X+H<8) {
                if (SourcePoints.get(X+H).charAt(Y-H) == '_') {
                    move.add(new ChessboardPoint(X+H , Y-H));
                    H++;
                } else if ((int) SourcePoints.get(X+H).charAt(Y-H) > 95) {
                    move.add(new ChessboardPoint(X+H, Y-H));break;
                }else if ((int) SourcePoints.get(X+H).charAt(Y-H) < 95){break;}
            }

        }
        Collections.sort(move);
        return move;
    }
}