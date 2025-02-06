import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    int[] delta={1,0,1,1,0,1,-1,1,-1,0,-1,-1,0,-1,1,-1};

    public KingChessComponent(int x,int y,ChessColor color) {
        setChessColor(color);
        if(color==ChessColor.BLACK){setName('K');}
        if(color==ChessColor.WHITE){setName('k');}
        setSource(new  ChessboardPoint(x,y));
        setCheckPolymorphism(1);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> theList= new ArrayList<>();

        boolean t2;

        boolean t4;
        boolean ans;
        int  dx, dy;

       int sourceX=getSource().getX();
        int sourceY=getSource().getY();
        for (int targetX = 0; targetX <= 7; targetX++) {
            for (int targetY = 0; targetY<= 7; targetY++) {
                t2 = false;
                t4 = false;
                ans = false;
                dx = targetX - sourceX;
                dy = targetY - sourceY;

        if (dx <= 1 && dx >= -1 && dy <= 1 && dy >= -1) {
            t2 = true;
            if (dx == 0 && dy == 0) {
                t2 = false;
            }
        }
        if (sourceX < 8 && sourceX >= 0 && sourceY < 8 && sourceY >= 0
                && targetX < 8 && targetX >= 0 && targetY < 8 && targetY >= 0) {t4 = true;}

                ans =t2 && t4;

         if(ans) {
             theList.add(new ChessboardPoint(targetX, targetY));
         }
            }

}
   return theList; }
}
