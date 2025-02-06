import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    private List<String> SourcePoints;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, List<String> ChessList) {
        super(source,chessColor,name,ChessList);
        this.SourcePoints=ChessList;
    }

      @Override
    public List<ChessboardPoint> canMoveTo() {
        int X=super.getSource().getX(); int Y=super.getSource().getY();
        List<ChessboardPoint> move= new ArrayList<>();
        if (super.getChessColor()==ChessColor.WHITE) {
            int A = 1;
           if (X + A < 8) {
                if (SourcePoints.get(X + A).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X + A, Y));
                } else if ((int) SourcePoints.get(X + A).charAt(Y) < 95) {
                    move.add(new ChessboardPoint(X + A, Y));
            }}
            int B=1;
            if (X - B >= 0) {
                if (SourcePoints.get(X - B).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X - B, Y));
                } else if ((int) SourcePoints.get(X - B).charAt(Y) < 95) {
                    move.add(new ChessboardPoint(X -B, Y));
            }}
            int C= 1;
            if (Y + C < 8) {
                if (SourcePoints.get(X).charAt(Y+C) == '_') {
                    move.add(new ChessboardPoint(X , Y+C));
                } else if ((int) SourcePoints.get(X ).charAt(Y+C) < 95) {
                    move.add(new ChessboardPoint(X , Y+C));
            }}
            int D=1;
            if (Y- D >= 0) {
                if (SourcePoints.get(X).charAt(Y- D) == '_') {
                    move.add(new ChessboardPoint(X , Y- D));
                } else if ((int) SourcePoints.get(X).charAt(Y- D) < 95) {
                    move.add(new ChessboardPoint(X , Y- D));
            }}
            int E=1;
            if (X+E<8&&Y+E<8) {
                if (SourcePoints.get(X+E).charAt(Y+E) == '_') {
                    move.add(new ChessboardPoint(X+E , Y+E));
                } else if ((int) SourcePoints.get(X+E).charAt(Y+E) < 95) {
                    move.add(new ChessboardPoint(X+E, Y+E));
            }}
            int F=1;
            if (X-F>=0&&Y-F>=0) {
                if (SourcePoints.get(X-F).charAt(Y-F) == '_') {
                    move.add(new ChessboardPoint(X-F , Y-F));
                } else if ((int) SourcePoints.get(X-F).charAt(Y-F) < 95) {
                    move.add(new ChessboardPoint(X-F, Y-F));
            }}
            int G=1;
            if (X-G>=0&&Y+G<8) {
                if (SourcePoints.get(X-G).charAt(Y+G) == '_') {
                    move.add(new ChessboardPoint(X-G , Y+G));
                } else if ((int) SourcePoints.get(X-G).charAt(Y+G) < 95) {
                    move.add(new ChessboardPoint(X-G, Y+G));
            }}
            int H=1;
            if (Y-H>=0&&X+H<8) {
                if (SourcePoints.get(X+H).charAt(Y-H) == '_') {
                    move.add(new ChessboardPoint(X+H , Y-H));
                } else if ((int) SourcePoints.get(X+H).charAt(Y-H) <95) {
                    move.add(new ChessboardPoint(X+H, Y-H));
            }}
        }
        else if (super.getChessColor()==ChessColor.BLACK){
            int A = 1;
            if (X + A < 8) {
                if (SourcePoints.get(X + A).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X + A, Y));
                } else if ((int) SourcePoints.get(X + A).charAt(Y) > 95) {
                    move.add(new ChessboardPoint(X + A, Y));
                }
            }
            int B=1;
            if (X - B >= 0) {
                if (SourcePoints.get(X - B).charAt(Y) == '_') {
                    move.add(new ChessboardPoint(X - B, Y));
                } else if ((int) SourcePoints.get(X - B).charAt(Y) > 95) {
                    move.add(new ChessboardPoint(X -B, Y));}
            }
            int C= 1;
            if (Y + C < 8) {
                if (SourcePoints.get(X).charAt(Y+C) == '_') {
                    move.add(new ChessboardPoint(X , Y+C));
                } else if ((int) SourcePoints.get(X).charAt(Y+C) > 95) {
                    move.add(new ChessboardPoint(X , Y+C));
                }
            }
            int D=1;
            if (Y- D >= 0) {
                if (SourcePoints.get(X).charAt(Y- D) == '_') {
                    move.add(new ChessboardPoint(X , Y- D));
                } else if ((int) SourcePoints.get(X).charAt(Y- D) > 95) {
                    move.add(new ChessboardPoint(X , Y- D));}
            }
            int E=1;
            if (X+E<8&&Y+E<8) {
                if (SourcePoints.get(X+E).charAt(Y+E) == '_') {
                    move.add(new ChessboardPoint(X+E , Y+E));
                } else if ((int) SourcePoints.get(X+E).charAt(Y+E) > 95) {
                    move.add(new ChessboardPoint(X+E, Y+E));}
            }
            int F=1;
            if (X-F>=0&&Y-F>=0) {
                if (SourcePoints.get(X-F).charAt(Y-F) == '_') {
                    move.add(new ChessboardPoint(X-F , Y-F));
                } else if ((int) SourcePoints.get(X-F).charAt(Y-F) > 95) {
                    move.add(new ChessboardPoint(X-F, Y-F));}
            }
            int G=1;
            if (X-G>=0&&Y+G<8) {
                if (SourcePoints.get(X-G).charAt(Y+G) == '_') {
                    move.add(new ChessboardPoint(X-G , Y+G));
                } else if ((int) SourcePoints.get(X-G).charAt(Y+G) > 95) {
                    move.add(new ChessboardPoint(X-G, Y+G));}
            }
            int H=1;
            if (Y-H>=0&&X+H<8) {
                if (SourcePoints.get(X+H).charAt(Y-H) == '_') {
                    move.add(new ChessboardPoint(X+H , Y-H));
                } else if ((int) SourcePoints.get(X+H).charAt(Y-H) > 95) {
                    move.add(new ChessboardPoint(X+H, Y-H));}
            }

        }
        Collections.sort(move);
        return move;
    }
}

