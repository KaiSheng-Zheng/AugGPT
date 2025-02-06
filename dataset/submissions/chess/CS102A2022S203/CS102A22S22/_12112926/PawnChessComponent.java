import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor, char name,ChessboardPoint source) {
        this.name = name;
        setChessColor(chessColor);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cor = new ArrayList<>();
        ChessboardPoint chess = new ChessboardPoint(getSource().getX(), getSource().getY());
        if (getChessColor() == ChessColor.BLACK) {
            if (getSource().getX() ==1){
                if(getChessBoard()[chess.getX()+1][chess.getY()]instanceof EmptySlotComponent
                        &&getChessBoard()[chess.getX()+2][chess.getY()]instanceof EmptySlotComponent){
                    cor.add(new ChessboardPoint(chess.getX()+1,chess.getY()));
                    cor.add(new ChessboardPoint(chess.getX()+2,chess.getY()));
                }
                else if(getChessBoard()[chess.getX()+1][chess.getY()]instanceof EmptySlotComponent
                        &&!(getChessBoard()[chess.getX()+2][chess.getY()]instanceof EmptySlotComponent)){
                    cor.add(new ChessboardPoint(chess.getX()+1,chess.getY()));
                }
            }
            else{
                if(getChessBoard()[chess.getX()+1][chess.getY()]instanceof EmptySlotComponent){
                    cor.add(new ChessboardPoint(chess.getX()+1,chess.getY()));
                }
            }
            if(!(getChessBoard()[chess.getX()+1][chess.getY()+1]instanceof EmptySlotComponent)&&
                    !(getChessBoard()[chess.getX()+1][chess.getY()-1]instanceof EmptySlotComponent)){
                if((getChessBoard()[chess.getX()+1][chess.getY()+1].getChessColor()!=getChessColor())&&
                        (getChessBoard()[chess.getX()+1][chess.getY()-1].getChessColor()!=getChessColor())) {
                    cor.add(new ChessboardPoint(chess.getX() + 1, chess.getY() + 1));
                    cor.add(new ChessboardPoint(chess.getX() + 1, chess.getY() - 1));
                }
                else if((getChessBoard()[chess.getX()+1][chess.getY()+1].getChessColor()==getChessColor())&&
                        (getChessBoard()[chess.getX()+1][chess.getY()-1].getChessColor()!=getChessColor())){
                    cor.add(new ChessboardPoint(chess.getX() + 1, chess.getY() - 1));
                }
                else if(getChessBoard()[chess.getX()+1][chess.getY()+1].getChessColor()!=getChessColor()&&
                        (getChessBoard()[chess.getX()+1][chess.getY()-1].getChessColor()==getChessColor())){
                    cor.add(new ChessboardPoint(chess.getX() + 1, chess.getY() + 1));
                }
            }
            else if(getChessBoard()[chess.getX()+1][chess.getY()+1]instanceof EmptySlotComponent&&
                    !(getChessBoard()[chess.getX()+1][chess.getY()-1]instanceof EmptySlotComponent)){ // potential ArrayIndexOutOfBound if Y == 0
                if(getChessBoard()[chess.getX()+1][chess.getY()-1].getChessColor()!=getChessColor()) {
                    cor.add(new ChessboardPoint(chess.getX() + 1, chess.getY() - 1));
                }
            }
            else if(!(getChessBoard()[chess.getX()+1][chess.getY()+1]instanceof EmptySlotComponent)&&
                    getChessBoard()[chess.getX()+1][chess.getY()+1]instanceof EmptySlotComponent){
                if(getChessBoard()[chess.getX()+1][chess.getY()+1].getChessColor()!=getChessColor()){
                    cor.add(new ChessboardPoint(chess.getX() + 1, chess.getY() + 1));
                }
            }
        }
        else{
            if (getSource().getX() ==6){
                if(getChessBoard()[chess.getX()-1][chess.getY()]instanceof EmptySlotComponent
                        &&getChessBoard()[chess.getX()-2][chess.getY()]instanceof EmptySlotComponent){
                    cor.add(new ChessboardPoint(chess.getX()-1,chess.getY()));
                    cor.add(new ChessboardPoint(chess.getX()-2,chess.getY()));
                }
                else if(getChessBoard()[chess.getX()-1][chess.getY()]instanceof EmptySlotComponent
                        &&!(getChessBoard()[chess.getX()-2][chess.getY()]instanceof EmptySlotComponent)){
                    cor.add(new ChessboardPoint(chess.getX()-1,chess.getY()));
                }
            }
            else{
                if(getChessBoard()[chess.getX()-1][chess.getY()]instanceof EmptySlotComponent){
                    cor.add(new ChessboardPoint(chess.getX()-1,chess.getY()));
                }
            }
            if(!(getChessBoard()[chess.getX()-1][chess.getY()+1]instanceof EmptySlotComponent)&&
                    !(getChessBoard()[chess.getX()-1][chess.getY()-1]instanceof EmptySlotComponent)){
                if((getChessBoard()[chess.getX()-1][chess.getY()+1].getChessColor()!=getChessColor())&&
                        (getChessBoard()[chess.getX()-1][chess.getY()-1].getChessColor()!=getChessColor())) {
                    cor.add(new ChessboardPoint(chess.getX() - 1, chess.getY() + 1));
                    cor.add(new ChessboardPoint(chess.getX() - 1, chess.getY() - 1));
                }
                else if((getChessBoard()[chess.getX()-1][chess.getY()+1].getChessColor()==getChessColor())&&
                        (getChessBoard()[chess.getX()-1][chess.getY()-1].getChessColor()!=getChessColor())){
                    cor.add(new ChessboardPoint(chess.getX() - 1, chess.getY() - 1));
                }
                else if(getChessBoard()[chess.getX()-1][chess.getY()+1].getChessColor()!=getChessColor()&&
                        (getChessBoard()[chess.getX()-1][chess.getY()-1].getChessColor()==getChessColor())){
                    cor.add(new ChessboardPoint(chess.getX() - 1, chess.getY() + 1));
                }
            }
            else if(getChessBoard()[chess.getX()-1][chess.getY()+1]instanceof EmptySlotComponent&&
                    !(getChessBoard()[chess.getX()-1][chess.getY()-1]instanceof EmptySlotComponent)){
                if(getChessBoard()[chess.getX()-1][chess.getY()-1].getChessColor()!=getChessColor()) {
                    cor.add(new ChessboardPoint(chess.getX() - 1, chess.getY() - 1));
                }
            }
            else if(!(getChessBoard()[chess.getX()-1][chess.getY()+1]instanceof EmptySlotComponent)&&
                    getChessBoard()[chess.getX()-1][chess.getY()+1]instanceof EmptySlotComponent){
                if(getChessBoard()[chess.getX()-1][chess.getY()+1].getChessColor()!=getChessColor()) {
                    cor.add(new ChessboardPoint(chess.getX() - 1, chess.getY() + 1));
                }
            }
        }
        return cor;
    }
}
