import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessColor h, ChessboardPoint source){
        if(h.equals(ChessColor.BLACK))this.name='B';
        else this.name = 'b';
        this.setChessColor(h);
        this.setSource(source);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> xiang = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
                if(getSource().getX()+i<=7&& getSource().getY()+i<=7){
            if(chessComponents[getSource().getX() + i][getSource().getY() + i].getChessColor()==ChessColor.NONE)
                    xiang.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i ));
                if (chessComponents[getSource().getX() + i][getSource().getY() + i].getChessColor()==this.getChessColor())
                    break;
                if (!(chessComponents[getSource().getX() + i][getSource().getY() + i].getChessColor()==this.getChessColor()|| chessComponents[getSource().getX() + i][getSource().getY() + i].getChessColor()==ChessColor.NONE))
                {xiang.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i ));break;}
                }}

        for (int i = 1; i < 8; i++) {
            if(getSource().getX()+i<=7&& getSource().getY()-i>=0){
                if(chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor()==ChessColor.NONE)
                    xiang.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i ));
                if (chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor()==this.getChessColor())
                    break;
                if (!(chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor()==this.getChessColor()|| chessComponents[getSource().getX() + i][getSource().getY() - i].getChessColor()==ChessColor.NONE))
                {xiang.add(new ChessboardPoint(getSource().getX()+i, getSource().getX()-i ));break;}
            }}



        for (int i = 1; i < 8; i++) {


            if(getSource().getX()-i>=0&& getSource().getY()+i<=7){
                if(chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor().equals(ChessColor.NONE))
                xiang.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i ));
                if (chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor().equals(this.getChessColor()))
                    break;
                if (!(chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor().equals(this.getChessColor())|| chessComponents[getSource().getX() - i][getSource().getY() + i].getChessColor().equals(ChessColor.NONE)))
                {xiang.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i ));break;}
            }}

        for (int i = 1; i < 8; i++) {
            if(getSource().getY()-i>=0&& getSource().getX()-i>=0){

                //StringBuilder a1 = new StringBuilder();
                //for (int k = 0; k < 8; k++) {
                //    for (int j = 0; j < 8; j++) {
                //        a1.append(chessComponents[j][k].toString());
                //    }
                //    a1.append("\n");
                //}
                //System.out.println(a1);

                if(chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor().equals(ChessColor.NONE))
                    xiang.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i ));
                if (chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor().equals(this.getChessColor()))

                    break;
                if (!(chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor().equals(this.getChessColor())|| chessComponents[getSource().getX() - i][getSource().getY() - i].getChessColor().equals(ChessColor.NONE)))
                {xiang.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i ));break;}
            }}

        Collections.sort(xiang);
        return xiang;
    }

    public String toString() {
        return name+"";
    }


}
