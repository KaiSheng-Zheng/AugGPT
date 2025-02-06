import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }


    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'q';
        } else {
            super.name = 'Q';
        }
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'q';
        } else {
            super.name = 'Q';
        }
    }

    public QueenChessComponent() {
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    public QueenChessComponent(ChessColor chessColor) {
        super(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'q';
        } else {
            super.name = 'Q';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessboard = getChessComponents();
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> Points = new ArrayList<>();

        int q=0,w=0,e=0,r=0;
        for (int i=1;;i++){
            if (x-i==-1||y+i==8){q=i-1;break;}
            if (chessboard[x-i][y+i].getChessColor().equals(getChessColor())){q=i-1;break;}
            if (!chessboard[x-i][y+i].getChessColor().equals(getChessColor())&&!chessboard[x-i][y+i].getChessColor().equals(ChessColor.NONE)){q=i;break;}
        }
        for (int i=1;i<=q;i++){
            Points.add(new ChessboardPoint(x-i,y+i));
        }for (int i=1;;i++){
            if (x+i==8||y+i==8){w=i-1;break;}
            if (chessboard[x+i][y+i].getChessColor().equals(getChessColor())){w=i-1;break;}
            if (!chessboard[x+i][y+i].getChessColor().equals(getChessColor())&&!chessboard[x+i][y+i].getChessColor().equals(ChessColor.NONE)){w=i;break;}
        }
        for (int i=1;i<=w;i++){
            Points.add(new ChessboardPoint(x+i,y+i));
        }for (int i=1;;i++){
            if (x-i==-1||y-i==-1){e=i-1;break;}
            if (chessboard[x-i][y-i].getChessColor().equals(getChessColor())){e=i-1;break;}
            if (!chessboard[x-i][y-i].getChessColor().equals(getChessColor())&&!chessboard[x-i][y-i].getChessColor().equals(ChessColor.NONE)){e=i;break;}
        }
        for (int i=1;i<=e;i++){
            Points.add(new ChessboardPoint(x-i,y-i));
        }for (int i=1;;i++){
            if (y-i==-1||x+i==8){r=i-1;break;}
            if (chessboard[x+i][y-i].getChessColor().equals(getChessColor())){r=i-1;break;}
            if (!chessboard[x+i][y-i].getChessColor().equals(getChessColor())&&!chessboard[x+i][y-i].getChessColor().equals(ChessColor.NONE)){r=i;break;}
        }
        for (int i=1;i<=r;i++){
            Points.add(new ChessboardPoint(x+i,y-i));
        }

        for(int i = x - 1; i >= 0; i--){
            if(chessboard[i][y].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(i,y));
            }else{
                if(chessboard[i][y].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }

        for(int i = x + 1; i < 8; i++){
            if(chessboard[i][y].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(i,y));
            }else{
                if(chessboard[i][y].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }

        for(int j = y - 1; j >= 0; j--){
            if(chessboard[x][j].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(x,j));
            }else{
                if(chessboard[x][j].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(x,j));
                }
                break;
            }
        }


        for(int j = y + 1; j < 8; j++){
            if(chessboard[x][j].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(x,j));
            }else{
                if(chessboard[x][j].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(x,j));
                }
                break;
            }
        }

        return Points;
    }
}
