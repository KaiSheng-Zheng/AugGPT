import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    ArrayList<String> SourcePoints;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, List<String> chessboard) {
        super(source, chessColor, name, chessboard);
        SourcePoints = (ArrayList<String>) chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        ChessboardPoint destination1 = KingChessComponent.super.source.offset(-1, -1);
        ChessboardPoint destination2 = KingChessComponent.super.source.offset(-1, 0);
        ChessboardPoint destination3 = KingChessComponent.super.source.offset(-1, 1);
        ChessboardPoint destination4 = KingChessComponent.super.source.offset(0, -1);
        ChessboardPoint destination5 = KingChessComponent.super.source.offset(0, 1);
        ChessboardPoint destination6 = KingChessComponent.super.source.offset(1, -1);
        ChessboardPoint destination7 = KingChessComponent.super.source.offset(1, 0);
        ChessboardPoint destination8 = KingChessComponent.super.source.offset(1, 1);
        if (super.getChessColor()==ChessColor.BLACK) {
            if (destination1 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() - 1) > 94) {
                canmoveto.add(destination1);
            }
            if (destination2 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY()) > 94) {
                canmoveto.add(destination2);
            }
            if (destination3 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() +1) > 94) {
                canmoveto.add(destination3);
            }
            if (destination4 != null && (int) SourcePoints.get(source.getX()).charAt(source.getY() -1) > 94) {
                canmoveto.add(destination4);
            }
            if (destination5 != null && (int) SourcePoints.get(source.getX()).charAt(source.getY()+1) > 94) {
                canmoveto.add(destination5);
            }
            if (destination6 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() -1) > 94) {
                canmoveto.add(destination6);
            }
            if (destination7 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY()) > 94) {
                canmoveto.add(destination7);
            }
            if (destination8 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() + 1) > 94) {
                canmoveto.add(destination8);
            }
        }
        if (super.getChessColor()==ChessColor.WHITE) {
            if (destination1 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() - 1) <96) {
                canmoveto.add(destination1);
            }
            if (destination2 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() ) <96) {
                canmoveto.add(destination2);
            }
            if (destination3 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() +1) <96) {
                canmoveto.add(destination3);
            }
            if (destination4 != null && (int) SourcePoints.get(source.getX() ).charAt(source.getY() -1) <96) {
                canmoveto.add(destination4);
            }
            if (destination5 != null && (int) SourcePoints.get(source.getX() ).charAt(source.getY() +1) <96) {
                canmoveto.add(destination5);
            }
            if (destination6 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() -1) <96) {
                canmoveto.add(destination6);
            }
            if (destination7 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY()) <96) {
                canmoveto.add(destination7);
            }
            if (destination8 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() + 1) <96) {
                canmoveto.add(destination8);
            }
        }

        return canmoveto;
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