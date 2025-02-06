import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] now) {
        setSource(source);
        setChessColor(chessColor);
        setName(name);
        setNow(now);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canChessMove = new ArrayList<>();

        if (getSource().getX() != 0 && getSource().getY() != 7){
            int a = 0;
            for (int i = getSource().getX() - 1; i >= 0 ; i--) {
                a++;
                if (getNow()[i][getSource().getY()+a].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()+a));
                }else if (getChessColor() != getNow()[i][getSource().getY()+a].getChessColor()){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()+a));
                    break;
                }else{
                    break;
                }
                if (getSource().getY()+a == 7){
                    break;
                }
            }
        }

        if (getSource().getX() != 0 && getSource().getY() != 0){
            int a = 0;
            for (int i = getSource().getX() - 1; i >= 0 ; i--) {
                a++;
                if (getNow()[i][getSource().getY()-a].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()-a));
                }else if (getChessColor() != getNow()[i][getSource().getY()-a].getChessColor()){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()-a));
                    break;
                }else{
                    break;
                }
                if (getSource().getY()-a == 0){
                    break;
                }
            }
        }

        if (getSource().getX() != 7 && getSource().getY() != 7){
            int a = 0;
            for (int i = getSource().getX() + 1; i < 8 ; i++) {
                a++;
                if (getNow()[i][getSource().getY()+a].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()+a));
                }else if (getChessColor() != getNow()[i][getSource().getY()+a].getChessColor()){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()+a));
                    break;
                }else{
                    break;
                }
                if (getSource().getY()+a == 7){
                    break;
                }
            }
        }

        if (getSource().getX() != 7 && getSource().getY() != 0){
            int a = 0;
            for (int i = getSource().getX() + 1; i < 8 ; i++) {
                a++;
                if (getNow()[i][getSource().getY()-a].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()-a));
                }else if (getChessColor() != getNow()[i][getSource().getY()-a].getChessColor()){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()-a));
                    break;
                }else{
                    break;
                }
                if (getSource().getY()-a == 0){
                    break;
                }
            }
        }

        if (getSource().getX() != 0){
            for (int i = getSource().getX() - 1; i >= 0 ; i--) {
                if (getNow()[i][getSource().getY()].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()));
                }else if (getChessColor() != getNow()[i][getSource().getY()].getChessColor()){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()));
                    break;
                }else{
                    break;
                }
            }
        }

        if (getSource().getX() != 7){
            for (int i = getSource().getX() + 1; i < 8 ; i++) {
                if (getNow()[i][getSource().getY()].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()));
                }else if (getChessColor() != getNow()[i][getSource().getY()].getChessColor()){
                    canChessMove.add(new ChessboardPoint(i, getSource().getY()));
                    break;
                }else{
                    break;
                }
            }
        }

        if (getSource().getY() != 0){
            for (int i = getSource().getY() - 1; i >= 0 ; i--) {
                if (getNow()[getSource().getX()][i].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(getSource().getX(),i));
                }else if (getChessColor() != getNow()[getSource().getX()][i].getChessColor()){
                    canChessMove.add(new ChessboardPoint(getSource().getX(),i));
                    break;
                }else{
                    break;
                }
            }
        }

        if (getSource().getY() != 7){
            for (int i = getSource().getY() + 1; i < 8; i++) {
                if (getNow()[getSource().getX()][i].getChessColor() == ChessColor.NONE){
                    canChessMove.add(new ChessboardPoint(getSource().getX(),i));
                }else if (getChessColor() != getNow()[getSource().getX()][i].getChessColor()){
                    canChessMove.add(new ChessboardPoint(getSource().getX(),i));
                    break;
                }else{
                    break;
                }
            }
        }


        ArrayList<ChessboardPoint> newCanChessMove = new ArrayList<>();
        for (int i = 0; i < canChessMove.size(); i++) {
            newCanChessMove.add(sort(canChessMove).get(i));
        }

        return newCanChessMove;
    }
}
