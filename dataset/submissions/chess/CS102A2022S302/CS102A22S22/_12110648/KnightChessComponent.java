import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessColor chessColor;

    public KnightChessComponent(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a= getSource().getX();int b= getSource().getY();
        List<ChessboardPoint> answer=new ArrayList<>();
        if (a+1<8&&b+2<8){
        if (this.chessColor!=chessboard[a+1][b+2].getChessColor()){
            answer.add(new ChessboardPoint(a+1,b+2));
        }}
        if (a+2<8&&b+1<8){
            if (this.chessColor!=chessboard[a+2][b+1].getChessColor()){
                answer.add(new ChessboardPoint(a+2,b+1));
            }}
        if (a-1>=0&&b-2>=0){
            if (this.chessColor!=chessboard[a-1][b-2].getChessColor()){
                answer.add(new ChessboardPoint(a-1,b-2));
            }}
        if (a-2>=0&&b-1>=0){
            if (this.chessColor!=chessboard[a-2][b-1].getChessColor()){
                answer.add(new ChessboardPoint(a-2,b-1));
            }}
        if (a-1>=0&&b+2<8){
            if (this.chessColor!=chessboard[a-1][b+2].getChessColor()){
                answer.add(new ChessboardPoint(a-1,b+2));
            }}
        if (a-2>=0&&b+1<8){
            if (this.chessColor!=chessboard[a-2][b+1].getChessColor()){
                answer.add(new ChessboardPoint(a-2,b+1));
            }}
        if (a+2<8&&b-1>=0){
            if (this.chessColor!=chessboard[a+2][b-1].getChessColor()){
                answer.add(new ChessboardPoint(a+2,b-1));
            }}
        if (a+1<8&&b-2>=0){
            if (this.chessColor!=chessboard[a+1][b-2].getChessColor()){
                answer.add(new ChessboardPoint(a+1,b-2));
            }}
       return answer;

    }
}
