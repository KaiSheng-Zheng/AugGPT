import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    ArrayList<String> SourcePoints;
    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        SourcePoints= (ArrayList<String>) chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();


        ChessboardPoint destination1 = KnightChessComponent.super.source.offset(-2, -1);
        ChessboardPoint destination2 = KnightChessComponent.super.source.offset(-2, 1);
        ChessboardPoint destination3 = KnightChessComponent.super.source.offset(-1, -2);
        ChessboardPoint destination4 = KnightChessComponent.super.source.offset(-1, 2);
        ChessboardPoint destination5 = KnightChessComponent.super.source.offset(1, -2);
        ChessboardPoint destination6 = KnightChessComponent.super.source.offset(1, 2);
        ChessboardPoint destination7 = KnightChessComponent.super.source.offset(2, -1);
        ChessboardPoint destination8 = KnightChessComponent.super.source.offset(2, 1);
        if (super.getChessColor()==ChessColor.BLACK) {

            if (destination1 != null && (int) SourcePoints.get(source.getX() - 2).charAt(source.getY() - 1) > 94) {
                canmoveto.add(destination1);
            }
            if (destination2 != null && (int) SourcePoints.get(source.getX() - 2).charAt(source.getY() + 1) > 94) {
                canmoveto.add(destination2);
            }
            if (destination3 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() - 2) > 94) {
                canmoveto.add(destination3);
            }
            if (destination4 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() + 2) > 94) {
                canmoveto.add(destination4);
            }
            if (destination5 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() - 2) > 94) {
                canmoveto.add(destination5);
            }
            if (destination6 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() + 2) > 94) {
                canmoveto.add(destination6);
            }
            if (destination7 != null && (int) SourcePoints.get(source.getX() + 2).charAt(source.getY() - 1) > 94) {
                canmoveto.add(destination7);
            }
            if (destination8 != null && (int) SourcePoints.get(source.getX() + 2).charAt(source.getY() + 1) > 94) {
                canmoveto.add(destination8);
            }
        }
        if (super.getChessColor()==ChessColor.WHITE) {
            if (destination1 != null && (int) SourcePoints.get(source.getX() - 2).charAt(source.getY() - 1) <96) {
                canmoveto.add(destination1);
            }
            if (destination2 != null && (int) SourcePoints.get(source.getX() - 2).charAt(source.getY() + 1) <96) {
                canmoveto.add(destination2);
            }
            if (destination3 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() - 2) <96) {
                canmoveto.add(destination3);
            }
            if (destination4 != null && (int) SourcePoints.get(source.getX() - 1).charAt(source.getY() + 2) <96) {
                canmoveto.add(destination4);
            }
            if (destination5 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() - 2) <96) {
                canmoveto.add(destination5);
            }
            if (destination6 != null && (int) SourcePoints.get(source.getX() + 1).charAt(source.getY() + 2) <96) {
                canmoveto.add(destination6);
            }
            if (destination7 != null && (int) SourcePoints.get(source.getX() + 2).charAt(source.getY() - 1) <96) {
                canmoveto.add(destination7);
            }
            if (destination8 != null && (int) SourcePoints.get(source.getX() + 2).charAt(source.getY() + 1) <96) {
                canmoveto.add(destination8);
            }
        }

        return canmoveto;
    }
}

