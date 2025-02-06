import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    protected ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();

    public ChessComponent(ChessboardPoint source, char name,ChessComponent[][] chessboard) {
        this.source = source;
        this.name = name;
        this.chessboard = chessboard;
        if(Character.isUpperCase(name)){
            chessColor = ChessColor.BLACK;
        }else if(Character.isLowerCase(name)){
            chessColor = ChessColor.WHITE;
        }else{
            chessColor = ChessColor.NONE;
        }
    }

    private boolean hasEat = false;

    public boolean checkCanMove(ChessboardPoint pt) {

        if(pt == null) return false;

        if(chessboard[pt.getX()][pt.getY()].getColor()==ChessColor.NONE){
            return true;
        }

        if(chessboard[pt.getX()][pt.getY()].getColor()==chessColor){
            return false;
        }else{
            if(!hasEat) {
                hasEat = true;
                return true;
            }else{
                return false;
            }
        }
    }

    public void goPawn(){
        ChessboardPoint pos = source;
        ChessboardPoint pt = pos;

        if(chessColor == ChessColor.BLACK){
            if(checkPawnCanMove(pt.offset(1,0))){
                canMovePoints.add(pt.offset(1,0));
            }

            pt = pos;
            if(checkPawnCanMove(pt.offset(1,-1))){
                canMovePoints.add(pt.offset(1,-1));
            }

            pt = pos;
            if(checkPawnCanMove(pt.offset(1,1))){
                canMovePoints.add(pt.offset(1,1));
            }

            pt = pos;
            if(pt.getX() == 1){
                if(checkPawnCanMove(pt.offset(2,0))){
                    canMovePoints.add(pt.offset(2,0));
                }
            }
        }

        if(chessColor == ChessColor.WHITE){
            if(checkPawnCanMove(pt.offset(-1,0))){
                canMovePoints.add(pt.offset(-1,0));
            }

            pt = pos;
            if(checkPawnCanMove(pt.offset(-1,-1))){
                canMovePoints.add(pt.offset(-1,-1));
            }

            pt = pos;
            if(checkPawnCanMove(pt.offset(-1,1))){
                canMovePoints.add(pt.offset(-1,1));
            }

            pt = pos;
            if(pt.getX() == 6){
                if(checkPawnCanMove(pt.offset(-2,0))){
                    canMovePoints.add(pt.offset(-2,0));
                }
            }
        }
    }

    public boolean checkPawnCanMove(ChessboardPoint pt) {
        if(pt == null){
            return false;
        }

        int x = pt.getX();
        int y = pt.getY();

        if(chessboard[x][y].getColor()==chessColor){
            return false;
        }else if(chessboard[x][y].getColor()==ChessColor.NONE){
            return source.getY() == y;
        }else{
            return source.getY() != y;
        }
    }


    public void goKnight(){
        ChessboardPoint pos = source;
        ChessboardPoint pt = pos;

        if(checkCanMove(pt.offset(1,2))){
            pt = pt.offset(1,2);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(2,1))){
            pt = pt.offset(2,1);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(2,-1))){
            pt = pt.offset(2,-1);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(1,-2))){
            pt = pt.offset(1,-2);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(-1,-2))){
            pt = pt.offset(-1,-2);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(-2,-1))){
            pt = pt.offset(-2,-1);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(-2,1))){
            pt = pt.offset(-2,1);
            canMovePoints.add(pt);
        }

        pt = pos;
        if(checkCanMove(pt.offset(-1,2))){
            pt = pt.offset(-1,2);
            canMovePoints.add(pt);
        }
    }

    public void goCross() {
        ChessboardPoint pos = source;
        ChessboardPoint pt = pos;
        while(checkCanMove(pt.offset(0,1))){
            pt = pt.offset(0,1);
            canMovePoints.add(pt);
        }

        pt = pos;
        while(checkCanMove(pt.offset(0,-1))){
            pt = pt.offset(0,-1);
            canMovePoints.add(pt);
        }

        pt = pos;
        while(checkCanMove(pt.offset(-1,0))){
            pt = pt.offset(-1,0);
            canMovePoints.add(pt);
        }

        pt = pos;
        while(checkCanMove(pt.offset(1,0))){
            pt = pt.offset(1,0);
            canMovePoints.add(pt);
        }
    }

    public void goSlash(){
        ChessboardPoint pos = source;
        ChessboardPoint pt = pos;
        while(checkCanMove(pt.offset(1,1))){
            pt = pt.offset(1,1);
            if(!canMovePoints.contains(pt)) {
                canMovePoints.add(pt);
            }else continue;
        }

        pt = pos;
        while(checkCanMove(pt.offset(1,-1))){
            pt = pt.offset(1,-1);
            if(!canMovePoints.contains(pt)) {
                canMovePoints.add(pt);
            }else continue;
        }

        pt = pos;
        while(checkCanMove(pt.offset(-1,1))){
            pt = pt.offset(-1,1);
            if(!canMovePoints.contains(pt)) {
                canMovePoints.add(pt);
            }else continue;
        }

        pt = pos;
        while(checkCanMove(pt.offset(-1,-1))){
            pt = pt.offset(-1,-1);
            if(!canMovePoints.contains(pt)) {
                canMovePoints.add(pt);
            }else continue;
        }
//        System.out.println(canMovePoints.get(1));
    }

    public ChessColor getColor(){
        return this.chessColor;
    }

    public ChessComponent(){}

    public ChessboardPoint getSource(){
        return source;
    }

    public char getName(){ return name; }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
