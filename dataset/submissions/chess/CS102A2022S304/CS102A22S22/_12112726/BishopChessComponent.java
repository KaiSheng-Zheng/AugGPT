import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }


    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'b';
        } else {
            super.name = 'B';
        }
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'b';
        } else {
            super.name = 'B';
        }
    }

    public BishopChessComponent() {
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    public BishopChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'b';
        } else {
            super.name = 'B';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] a = getChessComponents();
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> list = new ArrayList<>();
        int q=0,w=0,e=0,r=0;
        for (int i=1;;i++){
            if (x-i==-1||y+i==8){q=i-1;break;}
            if (a[x-i][y+i].getChessColor().equals(getChessColor())){q=i-1;break;}
            if (!a[x-i][y+i].getChessColor().equals(getChessColor())&&!a[x-i][y+i].getChessColor().equals(ChessColor.NONE)){q=i;break;}
        }
        for (int i=1;i<=q;i++){
            list.add(new ChessboardPoint(x-i,y+i));
        }for (int i=1;;i++){
            if (x+i==8||y+i==8){w=i-1;break;}
            if (a[x+i][y+i].getChessColor().equals(getChessColor())){w=i-1;break;}
            if (!a[x+i][y+i].getChessColor().equals(getChessColor())&&!a[x+i][y+i].getChessColor().equals(ChessColor.NONE)){w=i;break;}
        }
        for (int i=1;i<=w;i++){
            list.add(new ChessboardPoint(x+i,y+i));
        }for (int i=1;;i++){
            if (x-i==-1||y-i==-1){e=i-1;break;}
            if (a[x-i][y-i].getChessColor().equals(getChessColor())){e=i-1;break;}
            if (!a[x-i][y-i].getChessColor().equals(getChessColor())&&!a[x-i][y-i].getChessColor().equals(ChessColor.NONE)){e=i;break;}
        }
        for (int i=1;i<=e;i++){
            list.add(new ChessboardPoint(x-i,y-i));
        }for (int i=1;;i++){
            if (y-i==-1||x+i==8){r=i-1;break;}
            if (a[x+i][y-i].getChessColor().equals(getChessColor())){r=i-1;break;}
            if (!a[x+i][y-i].getChessColor().equals(getChessColor())&&!a[x+i][y-i].getChessColor().equals(ChessColor.NONE)){r=i;break;}
        }
        for (int i=1;i<=r;i++){
            list.add(new ChessboardPoint(x+i,y-i));
        }
        return list;
    }
}
