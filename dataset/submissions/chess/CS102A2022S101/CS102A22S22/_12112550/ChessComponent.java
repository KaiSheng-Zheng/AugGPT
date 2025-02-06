import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected int capturedCnt;
//    protected ChessComponent[][] chessComponents;
    protected ConcreteChessGame concreteChessGame;

    public ChessComponent(){}
    public ChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
    }
    public ChessComponent(char name,ChessboardPoint source,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.name = name;
        this.source = source;
        this.chessColor = chessColor;
        this.concreteChessGame = concreteChessGame;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    public ChessColor getChessColor(){return this.chessColor;}
    public char getName(){return this.name;}
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public int getCapturedCnt(){return this.capturedCnt;}
    public ChessboardPoint getSource(){return this.source;}
    public ConcreteChessGame getConcreteChessGame() {
        return concreteChessGame;
    }
    public ChessComponent[][] getchessComponents(ChessComponent chess){
        return chess.getConcreteChessGame().getChessComponents();
    }

    //    public boolean hasChess(int x,int y){
//        if(x<0 | x>7 |y<0 | y>7){
//            return false;
//        }
//        if(chessComponents[x][y].getName() == '_'){
//            return true;
//        }
//        return false;
//    }
    public ChessboardPoint canMovePoint(int x,int y,ChessColor color,ChessComponent chess){
        ChessComponent[][] chessComponents = getchessComponents(chess);
        if(x<0 | x>7 |y<0 | y>7){
            return null;
        }
        if(chessComponents[x][y].getChessColor() == chess.getChessColor()){
            return null;
        }
        if(chessComponents[x][y].getName() != '_' & chessComponents[x][y].getChessColor() != color){
            return new ChessboardPoint(x,y);
        }
        if(chessComponents[x][y].getName() == '_'){
            return new ChessboardPoint(x,y);
        }
        return null;
    }

    public ArrayList<ChessboardPoint> horizontalMove(ChessboardPoint originPoint,ChessComponent chess){
        ChessboardPoint move;
        ChessComponent[][] chessComponents = getchessComponents(chess);
        ArrayList<ChessboardPoint> re = new ArrayList<>();
        for (int i = -1; i >=-7 ; i--) {
            move = originPoint.offset(0,i);
            if(move != null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_' ){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        for (int i = 1; i <=7; i++) {
            move = originPoint.offset(0,i);
            if(move != null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_' ){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        if(re.size() != 0){
            return re;
        }
        return new ArrayList<>();
    }
    public ArrayList<ChessboardPoint> verticalMove(ChessboardPoint originPoint,ChessComponent chess){
        ChessboardPoint move;
        ChessComponent[][] chessComponents = getchessComponents(chess);
        ArrayList<ChessboardPoint> re = new ArrayList<>();
        for (int i = -1; i >=-7 ; i--) {
            move = originPoint.offset(i,0);
            if(move != null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_' ){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        for (int i = 1; i <=7; i++) {
            move = originPoint.offset(i,0);
            if(move != null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_' ){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        if(re.size() !=0){
            return re;
        }
        return new ArrayList<>();
    }
    public ArrayList<ChessboardPoint> diagonalMove(ChessboardPoint originPoint,ChessComponent chess){
        ChessboardPoint move;
        ChessComponent[][] chessComponents = getchessComponents(chess);
        ArrayList<ChessboardPoint> re = new ArrayList<>();
        //left up move
        for (int i = -1, j =-1; i >=-7 ; i--,j--) {
            move = originPoint.offset(i,j);
            if(move !=null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_'){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        //right up move
        for (int i = -1, j =1; i >=-7 ; i--,j++) {
            move = originPoint.offset(i,j);
            if(move !=null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_'){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        //left down move
        for (int i = 1, j =-1; i <=7 ; i++,j--) {
            move = originPoint.offset(i,j);
            if(move !=null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_'){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        //right down move
        for (int i = 1, j =1; i <=7 ; i++,j++) {
            move = originPoint.offset(i,j);
            if(move !=null){
                if(chessComponents[move.getX()][move.getY()].getChessColor() == chess.getChessColor()){
                    break;
                }
                if(chessComponents[move.getX()][move.getY()].getName() == '_'){
                    re.add(move);
                }
                if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].chessColor != chess.getChessColor()){
                    re.add(move);
                    break;
                }
            } else break;
        }
        if(re.size()!=0){
            return re;
        }
        return new ArrayList<>();
    }


//    public ChessboardPoint verticalMove(ChessboardPoint originPoint, int y){
//        return originPoint.offset(0,y);
//    }
//    public ChessboardPoint diagonalMove(ChessboardPoint originPoint, int x,int y){
//        return originPoint.offset(x,y);
//    }
}

class KingChessComponent extends ChessComponent{
    private int capturedCnt;
    public KingChessComponent(char name,ChessboardPoint chessboardPoint, ChessColor color,ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }
    public KingChessComponent(ChessColor color,int currentCnt){
        if(color == ChessColor.BLACK){
            this.name = 'K';
            setChessColor(color);
        } else {
            this.name = 'k';
            setChessColor(color);
        }
        this.capturedCnt = 1-currentCnt;
    }

    public List<ChessboardPoint> canMoveTo(){
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        if(canMovePoint(sourceX-1,sourceY-1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY-1));
        }
        if(canMovePoint(sourceX-1,sourceY,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY));
        }
        if(canMovePoint(sourceX-1,sourceY+1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY+1));
        }
        if(canMovePoint(sourceX,sourceY-1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX,sourceY-1));
        }
        if(canMovePoint(sourceX,sourceY+1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX,sourceY+1));
        }
        if(canMovePoint(sourceX+1,sourceY-1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY-1));
        }
        if(canMovePoint(sourceX+1,sourceY,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY));
        }
        if(canMovePoint(sourceX+1,sourceY+1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY+1));
        }
        if(canMovePoints.size() !=0){
            return canMovePoints;
        }
        return new ArrayList<>();
    }

    @Override
    public int getCapturedCnt() {
        return this.capturedCnt;
    }
}

class QueenChessComponent extends ChessComponent{
    private int capturedCnt;
    public QueenChessComponent(char name,ChessboardPoint chessboardPoint, ChessColor color,ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }
    public QueenChessComponent(ChessColor color,int currentCnt){
        if(color == ChessColor.BLACK){
            this.name = 'Q';
            setChessColor(color);
        } else {
            this.name = 'q';
            setChessColor(color);
        }
        this.capturedCnt = 1-currentCnt;
    }

    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint originPoint = new ChessboardPoint(getSource().getX(),getSource().getY());
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        canMovePoints.addAll(diagonalMove(originPoint,this));
        canMovePoints.addAll(horizontalMove(originPoint,this));
        canMovePoints.addAll(verticalMove(originPoint,this));
        if(canMovePoints.size() !=0 ){
            return canMovePoints;
        }
        return new ArrayList<>();
    }

    @Override
    public int getCapturedCnt() {
        return capturedCnt;
    }
}

class RookChessComponent extends ChessComponent{
    private int capturedCnt;
    public RookChessComponent(char name,ChessboardPoint chessboardPoint, ChessColor color,ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }
    public RookChessComponent(ChessColor color,int currentCnt){
        if(color == ChessColor.BLACK){
            this.name = 'R';
            setChessColor(color);
        } else {
            this.name = 'r';
            setChessColor(color);
        }
        this.capturedCnt = 2-currentCnt;
    }

    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint originPoint = new ChessboardPoint(getSource().getX(),getSource().getY());
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        canMovePoints.addAll(horizontalMove(originPoint,this));
        canMovePoints.addAll(verticalMove(originPoint,this));
        if(canMovePoints.size() !=0){
            return canMovePoints;
        }
        return new ArrayList<>();
    }

    @Override
    public int getCapturedCnt() {
        return capturedCnt;
    }
}

class BishopChessComponent extends ChessComponent{
    private int capturedCnt;
    public BishopChessComponent(char name,ChessboardPoint chessboardPoint, ChessColor color,ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }
    public BishopChessComponent(ChessColor color,int currentCnt){
        if(color == ChessColor.BLACK){
            this.name = 'B';
            setChessColor(color);
        } else {
            this.name = 'b';
            setChessColor(color);
        }
        this.capturedCnt = 2-currentCnt;
    }

    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint originPoint = new ChessboardPoint(getSource().getX(),getSource().getY());
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        canMovePoints.addAll(diagonalMove(originPoint,this));
        if(canMovePoints.size() !=0){
            return canMovePoints;
        }
        return new ArrayList<>();
    }

    @Override
    public int getCapturedCnt() {
        return capturedCnt;
    }
}

class KnightChessComponent extends ChessComponent{
    private int capturedCnt;
    public KnightChessComponent(char name,ChessboardPoint chessboardPoint, ChessColor color,ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }
    public KnightChessComponent(ChessColor color,int currentCnt){
        if(color == ChessColor.BLACK){
            this.name = 'N';
            setChessColor(color);
        } else {
            this.name = 'n';
            setChessColor(color);
        }
        this.capturedCnt = 2-currentCnt;
    }

    public List<ChessboardPoint> canMoveTo(){
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        if(canMovePoint(sourceX-1,sourceY-2,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY-2));
        }
        if(canMovePoint(sourceX-2,sourceY-1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-2,sourceY-1));
        }
        if(canMovePoint(sourceX-2,sourceY+1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-2,sourceY+1));
        }
        if(canMovePoint(sourceX-1,sourceY+2,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY+2));
        }
        if(canMovePoint(sourceX+1,sourceY-2,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY-2));
        }
        if(canMovePoint(sourceX+2,sourceY-1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+2,sourceY-1));
        }
        if(canMovePoint(sourceX+2,sourceY+1,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+2,sourceY+1));
        }
        if(canMovePoint(sourceX+1,sourceY+2,getChessColor(),this)!=null){
            canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY+2));
        }
        if(canMovePoints.size() == 0){
            return new ArrayList<>();
        }
        return canMovePoints;

    }

    @Override
    public int getCapturedCnt() {
        return capturedCnt;
    }
}

class PawnChessComponent extends ChessComponent{
    private int capturedCnt;
    public PawnChessComponent(char name,ChessboardPoint chessboardPoint, ChessColor color,ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }
    public PawnChessComponent(ChessColor color,int currentCnt){
        if(color == ChessColor.BLACK){
            this.name = 'P';
            setChessColor(color);
        } else {
            this.name = 'p';
            setChessColor(color);
        }
        this.capturedCnt = 8-currentCnt;
    }

    public ArrayList<ChessboardPoint> whitemoveTwoBlock(ChessboardPoint originPoint){
        ChessboardPoint move;
        ChessComponent[][] chessComponents = getchessComponents(this);
        ArrayList<ChessboardPoint> re = new ArrayList<>();
            for (int i = -1; i >=-2 ; i--) {
                move = originPoint.offset(i,0);
                if(move !=null){
                    if(chessComponents[move.getX()][move.getY()].getName() == '_'){
                        re.add(move);
                    }
                    if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].getChessColor() != getChessColor()){
                        break;
                    }
                }
            }
            return re;
    }
    public ArrayList<ChessboardPoint> blackmoveTwoBlock(ChessboardPoint originPoint){
        ChessboardPoint move;
        ChessComponent[][] chessComponents = getchessComponents(this);
        ArrayList<ChessboardPoint> re = new ArrayList<>();
            for (int i = 1; i <=2 ; i++) {
                move = originPoint.offset(i,0);
                if(move !=null){
                    if(chessComponents[move.getX()][move.getY()].getName() == '_'){
                        re.add(move);
                    }
                    if(chessComponents[move.getX()][move.getY()].getName() != '_' && chessComponents[move.getX()][move.getY()].getChessColor() != getChessColor()){
                        break;
                    }
                }
            }
            return re;
    }
    //this moveOneBlock include eat other chess
    public ArrayList<ChessboardPoint> moveOneBlock(ChessboardPoint originPoint,ChessColor color){
        int x = originPoint.getX();
        int y = originPoint.getY();
        ChessComponent[][] chessComponents = getchessComponents(this);
        ArrayList<ChessboardPoint> re = new ArrayList<>();
        if(color == ChessColor.BLACK){
            //move forward
            if(chessComponents[x+1][y].getName() == '_'){
                re.add(new ChessboardPoint(x+1,y));
            }
            //move diagonal to eat other
            if(chessComponents[x+1][y-1].getName() !='_' & chessComponents[x+1][y-1].getChessColor() !=ChessColor.BLACK){
                re.add(new ChessboardPoint(x+1,y-1));
            }
            if(chessComponents[x+1][y+1].getName() !='_' & chessComponents[x+1][y+1].getChessColor() !=ChessColor.BLACK){
                re.add(new ChessboardPoint(x+1,y+1));
            }
            return re;
        }
        if(color == ChessColor.WHITE){
            //move forward
            if(chessComponents[x-1][y].getName() == '_'){
                re.add(new ChessboardPoint(x-1,y));
            }
            //move diagonal to eat other
            if(chessComponents[x-1][y-1].getName() !='_' & chessComponents[x-1][y-1].getChessColor() !=ChessColor.BLACK){
                re.add(new ChessboardPoint(x-1,y-1));
            }
            if(chessComponents[x-1][y+1].getName() !='_' & chessComponents[x-1][y+1].getChessColor() !=ChessColor.BLACK){
                re.add(new ChessboardPoint(x-1,y+1));
            }
            return re;
        }
        return null;
    }

    public List<ChessboardPoint> canMoveTo(){
        int sourceX = getSource().getX();
        int sourceY = getSource().getY();
        ChessComponent[][] chessComponents = getchessComponents(this);
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        if(getChessColor() == ChessColor.WHITE){
            //first step, can move two blocks
            if(sourceX == 6){
                //move forward
                canMovePoints.addAll(whitemoveTwoBlock(new ChessboardPoint(sourceX,sourceY)));
                //move diagonally to eat other
                if(chessComponents[sourceX-1][sourceY-1].getName() !='_' & chessComponents[sourceX-1][sourceY-1].getChessColor() !=getChessColor()){
                    canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY-1));
                }
                if(chessComponents[sourceX-1][sourceY+1].getName() !='_' & chessComponents[sourceX-1][sourceY+1].getChessColor() !=getChessColor()){
                    canMovePoints.add(new ChessboardPoint(sourceX-1,sourceY+1));
                }
            } else{//second step, move one block
                canMovePoints.addAll(moveOneBlock(new ChessboardPoint(sourceX,sourceY),ChessColor.WHITE));
            }
            return canMovePoints;
        }

        if(getChessColor() == ChessColor.BLACK){
            //first step, can move two blocks
            if(sourceX == 1){
                //move forward
                canMovePoints.addAll(blackmoveTwoBlock(new ChessboardPoint(sourceX,sourceY)));
                //move diagonally to eat other
                if(chessComponents[sourceX+1][sourceY-1].getName() !='_' & chessComponents[sourceX+1][sourceY-1].getChessColor() !=getChessColor()){
                    canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY-1));
                }
                if(chessComponents[sourceX+1][sourceY+1].getName() !='_' & chessComponents[sourceX+1][sourceY+1].getChessColor() !=getChessColor()){
                    canMovePoints.add(new ChessboardPoint(sourceX+1,sourceY+1));
                }
            } else{//second step, move one block
                canMovePoints.addAll(moveOneBlock(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK));
            }
            return canMovePoints;
        }
        return new ArrayList<>();
    }

    @Override
    public int getCapturedCnt() {
        return capturedCnt;
    }
}

class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(char name,ChessboardPoint chessboardPoint, ChessColor color, ConcreteChessGame concreteChessGame){
        super(name,chessboardPoint,color,concreteChessGame);
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }

    @Override
    public int getCapturedCnt() {
        return 0;
    }
}