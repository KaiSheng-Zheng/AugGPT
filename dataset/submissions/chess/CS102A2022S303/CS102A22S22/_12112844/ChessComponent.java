import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][]chessboard;


    public ChessComponent(){}
    public ChessComponent(ChessComponent[][]chessboard){
        this.chessboard=chessboard;
    }

    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessboard=chessBoard;
    }


    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


    public ChessboardPoint getMyPosition(){return source;}

    public void setChessboard(ChessComponent component){
        this.chessboard[component.getMyPosition().getX()][component.getMyPosition().getY()]=component;
    }

    public ChessColor getChessColor(){return chessColor;}

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public boolean addQRBcanMovePointAssistant(int i, int j, List movingList){
        if (chessboard[i][j].chessColor==ChessColor.NONE){
            movingList.add(chessboard[i][j].getMyPosition());
            return true;
        }
        else if (chessboard[i][j].chessColor!=this.getChessColor())
        {movingList.add(chessboard[i][j].getMyPosition());
            return false;
        }
        else{
            return false;
        }
    }

    public static boolean  isInChessboard(int i,int j){
        if ((0<=i)&&(i<=7)&&(0<=j)&&(j<=7)){
            return true;
        }
        else {return false;}
    }

}
class KingChessComponent extends ChessComponent {
    public KingChessComponent(char kOrK,int X,int Y){
        super.name=kOrK;
        if (kOrK=='k'){super.setChessColor(ChessColor.WHITE);}
        else {super.setChessColor(ChessColor.BLACK);}
        super.setSource(new ChessboardPoint(X,Y));
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movingList = new ArrayList<>();

        for (int i = getMyPosition().getX() - 1; i <= getMyPosition().getX() + 1; i++) {
            for (int j = getMyPosition().getY() - 1; j <= getMyPosition().getY() + 1; j++) {
                if ((i >= 0) && (i <= 7) && (j >= 0) && (j <= 7)) {
                    if ((chessboard[i][j].getChessColor()) != this.getChessColor()) {
                        boolean hasAnotherKing = false;
                        for (int a = i - 1; a <= i + 1; a++) {
                            for (int b = j - 1; b <= j + 1; b++) {
                                if (isInChessboard(a,b)) {
                                    if (((chessboard[a][b].toString() == "K") || (chessboard[a][b].toString() == "k"))
                                            && (chessboard[a][b].toString() != this.toString())) {
                                        hasAnotherKing = true;
                                    }
                                }
                            }
                        }
                        if (hasAnotherKing == false) {
                            movingList.add(chessboard[i][j].getMyPosition());
                        }
                    }
                }

            }
        }
        return movingList;
    }
}
class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char qOrQ,int X,int Y){
        super.name=qOrQ;
        if (qOrQ=='q'){super.setChessColor(ChessColor.WHITE);}
        else {super.setChessColor(ChessColor.BLACK);}
        super.setSource(new ChessboardPoint(X,Y));
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movingList = new ArrayList<>();
        boolean NcanMoveFurther = true;
        boolean EcanMoveFurther = true;
        boolean WcanMoveFurther = true;
        boolean ScanMoveFurther = true;
        boolean NWcanMoveFurther = true;
        boolean NEcanMoveFurther = true;
        boolean SEcanMoveFurther = true;
        boolean SWcanMoveFurther = true;
        int I,J;

        I= getMyPosition().getX()-1;
        J= getMyPosition().getY()-1;
        while (isInChessboard(I,J)) {
            if (NWcanMoveFurther==false){break;}
            NWcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I--;J--;
        }


        I= getMyPosition().getX()-1;
        J= getMyPosition().getY()+1;
        while (isInChessboard(I,J)) {
            if (NEcanMoveFurther==false){break;}
            NEcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I--;J++;
        }

        I= getMyPosition().getX()+1;
        J= getMyPosition().getY()-1;
        while (isInChessboard(I,J)) {
            if (SWcanMoveFurther==false){break;}
            SWcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I++;J--;
        }
        I= getMyPosition().getX()+1;
        J= getMyPosition().getY()+1;
        while (isInChessboard(I,J)) {
            if (SEcanMoveFurther==false){break;}
            SEcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I++;J++;
        }

        I= getMyPosition().getX();
        J= getMyPosition().getY()-1;
        while (isInChessboard(I,J)) {
            if (WcanMoveFurther==false){break ;}
            WcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            J--;
        }

        I= getMyPosition().getX();
        J= getMyPosition().getY()+1;
        while (isInChessboard(I,J)) {
            if (EcanMoveFurther==false){break ;}
            EcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            J++;
        }
        I= getMyPosition().getX()-1;
        J= getMyPosition().getY();
        while (isInChessboard(I,J)) {
            if (NcanMoveFurther==false){break ;}
            NcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I--;
        }
        I= getMyPosition().getX()+1;
        J= getMyPosition().getY();
        while (isInChessboard(I,J)) {
            if (ScanMoveFurther==false){break ;}
            ScanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I++;
        }
        return movingList;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent(char rOrR,int X,int Y){
        super.name=rOrR;
        if (rOrR=='r'){super.setChessColor(ChessColor.WHITE);}
        else {super.setChessColor(ChessColor.BLACK);}
        super.setSource(new ChessboardPoint(X,Y));
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movingList = new ArrayList<>();
        boolean NcanMoveFurther = true;
        boolean EcanMoveFurther = true;
        boolean WcanMoveFurther = true;
        boolean ScanMoveFurther = true;
        int I,J;
        I= getMyPosition().getX();
        J= getMyPosition().getY()-1;
        while (isInChessboard(I,J)) {
            if (WcanMoveFurther==false){break ;}
            WcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            J--;
        }

        I= getMyPosition().getX();
        J= getMyPosition().getY()+1;
        while (isInChessboard(I,J)) {
            if (EcanMoveFurther==false){break ;}
            EcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            J++;
        }
        I= getMyPosition().getX()-1;
        J= getMyPosition().getY();
        while (isInChessboard(I,J)) {
            if (NcanMoveFurther==false){break ;}
            NcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I--;
        }
        I= getMyPosition().getX()+1;
        J= getMyPosition().getY();
        while (isInChessboard(I,J)) {
            if (ScanMoveFurther==false){break ;}
            ScanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I++;
        }
        return movingList;
    }
}
 class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char bOrB,int X,int Y){
        super.name=bOrB;
        if (bOrB=='b'){super.setChessColor(ChessColor.WHITE);}
        else {super.setChessColor(ChessColor.BLACK);}
        super.setSource(new ChessboardPoint(X,Y));
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movingList = new ArrayList<>();
        boolean NWcanMoveFurther = true;
        boolean NEcanMoveFurther = true;
        boolean SEcanMoveFurther = true;
        boolean SWcanMoveFurther = true;
        int I,J;
        I= getMyPosition().getX()-1;
        J= getMyPosition().getY()-1;
        while (isInChessboard(I,J)) {
            if (NWcanMoveFurther==false){break;}
            NWcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I--;J--;
        }


        I= getMyPosition().getX()-1;
        J= getMyPosition().getY()+1;
        while (isInChessboard(I,J)) {
            if (NEcanMoveFurther==false){break;}
            NEcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I--;J++;
        }

        I= getMyPosition().getX()+1;
        J= getMyPosition().getY()-1;
        while (isInChessboard(I,J)) {
            if (SWcanMoveFurther==false){break;}
            SWcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I++;J--;
        }
        I= getMyPosition().getX()+1;
        J= getMyPosition().getY()+1;
        while (isInChessboard(I,J)) {
            if (SEcanMoveFurther==false){break;}
            SEcanMoveFurther = addQRBcanMovePointAssistant(I, J, movingList);
            I++;J++;
        }

        return movingList;
    }
}
 class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char nOrN,int X,int Y){
        super.name=nOrN;
        if (nOrN=='n'){super.setChessColor(ChessColor.WHITE);}
        else {super.setChessColor(ChessColor.BLACK);}
        super.setSource(new ChessboardPoint(X,Y));
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=getMyPosition().getX();
        int y= getMyPosition().getY();
        List<ChessboardPoint>movingList=new ArrayList<>();
        addNcanMovePointAssistant(x-2,y+1,movingList);
        addNcanMovePointAssistant(x-2,y-1,movingList);
        addNcanMovePointAssistant(x-1,y+2,movingList);
        addNcanMovePointAssistant(x+1,y+2,movingList);
        addNcanMovePointAssistant(x+2,y+1,movingList);
        addNcanMovePointAssistant(x+2,y-1,movingList);
        addNcanMovePointAssistant(x-1,y-2,movingList);
        addNcanMovePointAssistant(x+1,y-2,movingList);
        return movingList;

    }


    public void addNcanMovePointAssistant(int i,int j,List movingList){
        if ((i>=0)&&(i<=7)&&(j>=0)&&(j<=7)&&(chessboard[i][j].getChessColor()!=this.getChessColor())){
            movingList.add(chessboard[i][j].getMyPosition());
        }
    }
}
 class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char pOrP, int X, int Y) {
        super.name = pOrP;
        if (pOrP == 'p') {
            super.setChessColor(ChessColor.WHITE);
        } else {
            super.setChessColor(ChessColor.BLACK);
        }
        super.setSource(new ChessboardPoint(X, Y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> movingList = new ArrayList<>();
        int x = getMyPosition().getX();
        int y = getMyPosition().getY();
        switch (super.toString()) {
            case "P":
                if (x == 1) {
                    if (chessboard[2][y].getChessColor() ==ChessColor.NONE) {
                        movingList.add(chessboard[2][y].getMyPosition());
                    }
                    if (chessboard[3][y].getChessColor() ==ChessColor.NONE) {
                        movingList.add(chessboard[3][y].getMyPosition());
                    }
                } else {
                    if (isInChessboard(x+1,y)){
                        if (chessboard[x + 1][y].getChessColor() ==ChessColor.NONE) {
                            movingList.add(chessboard[x + 1][y].getMyPosition());
                        }
                    }
                }
                if (isInChessboard(x + 1, y + 1)) {
                    if ((chessboard[x + 1][y + 1].getChessColor() != super.getChessColor()) && (chessboard[x + 1][y + 1].getChessColor() != ChessColor.NONE)) {
                        movingList.add(chessboard[x + 1][y + 1].getMyPosition());
                    }
                }
                if (isInChessboard(x+1,y-1)) {
                    if ((chessboard[x + 1][y - 1].getChessColor() != super.getChessColor()) && (chessboard[x + 1][y - 1].getChessColor() != ChessColor.NONE)) {
                        movingList.add(chessboard[x + 1][y - 1].getMyPosition());
                    }
                }
                break;


            case "p":
                if (x == 6) {
                    if (super.chessboard[5][y].getChessColor()==ChessColor.NONE) {
                        movingList.add(super.chessboard[5][y].getMyPosition());
                    }
                    if (chessboard[4][y].getChessColor()==ChessColor.NONE) {
                        movingList.add(chessboard[4][y].getMyPosition());
                    }
                } else {
                    if (chessboard[x-1][y ].getChessColor() ==ChessColor.NONE) {
                        movingList.add(chessboard[x-1][y].getMyPosition());
                    }
                }
                if (isInChessboard(x-1,y+1)) {
                    if ((chessboard[x - 1][y + 1].getChessColor() != super.getChessColor()) && (chessboard[x - 1][y + 1].getChessColor() != ChessColor.NONE)) {
                        movingList.add(chessboard[x - 1][y + 1].getMyPosition());
                    }
                }
                if (isInChessboard(x-1,y-1)) {
                    if ((chessboard[x - 1][y - 1].getChessColor() != super.getChessColor()) && (chessboard[x - 1][y - 1].getChessColor() != ChessColor.NONE)) {
                        movingList.add(chessboard[x - 1][y - 1].getMyPosition());
                    }
                }
                break;
        }
        return movingList;
    }
}
 class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x,int y){
        super.name='_';
        super.setChessColor(ChessColor.NONE);
        super.setSource(new ChessboardPoint(x,y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}






