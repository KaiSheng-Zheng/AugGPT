import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();
        int x = getSource().getX(); int y = getSource().getY();
        ChessColor chessColor = getChessColor();

        if (chessColor==ChessColor.BLACK&x==1){
            chessboardPointList.add(new ChessboardPoint(x+1, y));
            chessboardPointList.add(new ChessboardPoint(x+2, y));
            if (y+1<=7) {
                if (chessboard[x + 1][y + 1].getChessColor()==ChessColor.WHITE){
                    chessboardPointList.add(new ChessboardPoint(x + 1, y + 1));
                }}
            if (y - 1>=0){
                if (chessboard[x + 1][y - 1].getChessColor()==ChessColor.WHITE) {
                    chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
                }}
        }
        else if (chessColor==ChessColor.WHITE&x==6) {
            chessboardPointList.add(new ChessboardPoint(x - 1, y));
            chessboardPointList.add(new ChessboardPoint(x - 2, y));
            if (y+1<=7) {
                if (chessboard[x - 1][y + 1].getChessColor()==ChessColor.BLACK) {
                    chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
                }}
            if (y - 1>=0){
                if (chessboard[x - 1][y - 1].getChessColor()==ChessColor.BLACK) {
                    chessboardPointList.add(new ChessboardPoint(x - 1, y - 1));
                }}
        }
        else {
            if (chessColor==ChessColor.BLACK&x<=6){
                if (chessboard[x+1][y].getChessColor()==ChessColor.NONE){
                    chessboardPointList.add(new ChessboardPoint(x+1, y));
                }
                if (y+1<=7) {
                    if (chessboard[x + 1][y + 1].getChessColor()==ChessColor.WHITE) {
                        chessboardPointList.add(new ChessboardPoint(x + 1, y + 1));
                    }}
                if (y - 1>=0){
                    if (chessboard[x + 1][y - 1].getChessColor()==ChessColor.WHITE) {
                        chessboardPointList.add(new ChessboardPoint(x + 1, y - 1));
                    }}
            }
            else if (getChessColor()==ChessColor.WHITE&x!=0){
                if (chessboard[x-1][y].getChessColor()==ChessColor.NONE){
                    chessboardPointList.add(new ChessboardPoint(x-1, y));
                }
                if (y+1<=7) {
                    if (chessboard[x - 1][y + 1].getChessColor()==ChessColor.BLACK) {
                        chessboardPointList.add(new ChessboardPoint(x - 1, y + 1));
                    }}
                if (y - 1>=0){
                    if (chessboard[x - 1][y - 1].getChessColor()==ChessColor.BLACK) {
                        chessboardPointList.add(new ChessboardPoint(x - 1, y - 1));
                    }}
            }
        }
        chessboardPointList.sort(new SortByXY());
        return chessboardPointList;
    }

    public String toString(){
        if (getChessColor()==ChessColor.WHITE)return "p";
        else return "P";
    }
}
