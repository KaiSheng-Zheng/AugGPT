import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'k';
        } else {
            super.name = 'K';
        }
    }

    public KingChessComponent() {
    }

    public KingChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'k';
        } else {
            super.name = 'K';
        }
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'k';
        } else {
            super.name = 'K';
        }
    }
    public boolean judge(int a,int b){
        boolean p=false;
        if (!chessComponents[a][b].getChessColor().equals(getChessColor())){p=true;}
        return p;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] a = getChessComponents();
        List<ChessboardPoint> list = new ArrayList<>();
        if (y+1!=8){
            if (judge(x,y+1)){list.add(new ChessboardPoint(x,y+1));}
            if (x-1!=-1){if (judge(x-1,y+1)){list.add(new ChessboardPoint(x-1,y+1));}}
            if (x+1!=8){if (judge(x+1,y+1)){list.add(new ChessboardPoint(x+1,y+1));}}
        }if (y-1!=-1){
            if (judge(x,y-1)){list.add(new ChessboardPoint(x,y-1));}
            if (x-1!=-1){if (judge(x-1,y-1)){list.add(new ChessboardPoint(x-1,y-1));}}
            if (x+1!=8){if (judge(x+1,y-1)){list.add(new ChessboardPoint(x+1,y-1));}}
        }
        if (x-1!=-1){if (judge(x-1,y)){list.add(new ChessboardPoint(x-1,y));}}
        if (x + 1 != 8) {
            if (judge(x + 1, y)) {
                list.add(new ChessboardPoint(x + 1, y));
            }
        }
        return list;
    }


}
