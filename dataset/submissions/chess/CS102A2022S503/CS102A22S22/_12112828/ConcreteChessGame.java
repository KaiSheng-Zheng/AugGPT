import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public  class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer=ChessColor.WHITE;
    public ConcreteChessGame(){}
    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer){
        this.chessComponents=new ChessComponent[8][8];
        this.currentPlayer=ChessColor.WHITE;
    }
    public ChessColor getChessColor(ChessComponent chessComponent){
        if ((chessComponent.name>='A') && (chessComponent.name<='Z')){
            return ChessColor.BLACK;
        }
        else if ((chessComponent.name>='a') && (chessComponent.name<='z')){
            return ChessColor.WHITE;
        }
        return ChessColor.NONE;
    }
    @Override
    public void loadChessGame(List<String> chessboard){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
                if (chessboard.get(i).charAt(j)=='K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if (chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK);
                }
                else if (chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE);
                }
                else if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE);
                }
            }
        }
        if (chessboard.get(8).charAt(0)=='b'){
            this.currentPlayer=ChessColor.BLACK;
        }else if (chessboard.get(8).charAt(0)=='w'){
            this.currentPlayer=ChessColor.WHITE;
        }
    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer; }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }
    @Override
    public String getChessboardGraph(){
        StringBuilder result=new StringBuilder();
        for (int i=0;i<8;i++){
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j].name);
            }
            if(i!=7){
                    result.append("\n");
            }
        }
        return String.valueOf(result);
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        if (player==(ChessColor.NONE)){
            return null;
        }
        int queenNumber=0;
        int rookNumber=0;
        int knightNumber=0;
        int bishopNumber=0;
        int pawnNumber=0;
        int KingNumber=0;
        String result="";
        if(player==(ChessColor.WHITE)){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='k'){
                        KingNumber++;
                    }
                    if (chessComponents[i][j].name=='q'){
                        queenNumber++;
                    }
                    if (chessComponents[i][j].name=='r'){
                        rookNumber++;
                    }
                    if (chessComponents[i][j].name=='n'){
                        knightNumber++;
                    }
                    if (chessComponents[i][j].name=='b'){
                        bishopNumber++;
                    }
                    if (chessComponents[i][j].name=='p'){
                        pawnNumber++;
                    }
                }
            }
            if (KingNumber<1){
                result=String.format("%sk %d",result,1-KingNumber);
            }
            if (queenNumber<1){
                result=String.format("%s\nq %d",result,1-queenNumber);
            }
            if (rookNumber<2){
                result=String.format("%s\nr %d",result,2-rookNumber);
            }
            if (bishopNumber<2){
                result=String.format("%s\nb %d",result,2-bishopNumber);
            }
            if (knightNumber<2){
                result= String.format("%s\nn %d",result,2-knightNumber);
            }
            if (pawnNumber<8){
                result= String.format("%s\np %d",result,8-pawnNumber);
            }
        }
        if (player==(ChessColor.BLACK)){
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name=='K'){
                        KingNumber++;
                    }
                    if (chessComponents[i][j].name=='Q'){
                        queenNumber++;
                    }
                    if (chessComponents[i][j].name=='R'){
                        rookNumber++;
                    }
                    if (chessComponents[i][j].name=='N'){
                        knightNumber++;
                    }
                    if (chessComponents[i][j].name=='B'){
                        bishopNumber++;
                    }
                    if (chessComponents[i][j].name=='P'){
                        pawnNumber++;
                    }
                }
            }
            if (KingNumber<1){
                result=String.format("%sK %d",result,1-KingNumber);
            }
            if (queenNumber<1){
                result=String.format("%s\nQ %d",result,1-queenNumber);
            }
            if (rookNumber<2){
                result=String.format("%s\nR %d",result,2-rookNumber);
            }
            if (bishopNumber<2){
                result=String.format("%s\nB %d",result,2-bishopNumber);
            }
            if (knightNumber<2){
                result=String.format("%s\nN %d",result,2-knightNumber);
            }
            if (pawnNumber<8){
                result=String.format("%s\nP %d",result,8-pawnNumber);
            }
        }
        return result;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
//        ChessComponent chess= getChess(source.getX(),source.getY());
//        return chess.canMoveTo();
        if ((chessComponents[source.getX()][source.getY()].name=='K') || (chessComponents[source.getX()][source.getY()].name=='k')){
            ArrayList<ChessboardPoint> canMovePoints;
            KingChessComponent chessComponent=new KingChessComponent(source,getChessColor(chessComponents[source.getX()][source.getY()]));
            canMovePoints=(ArrayList<ChessboardPoint>) chessComponent.canMoveTo();
            for (int i = 0;i < canMovePoints.size(); i++) {
                if (!moveChess1(source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY())){
                    canMovePoints.remove(i);
                    i--;
                }
            }
            canMovePoints.sort(new Sort());
            return canMovePoints;
        }else if ((chessComponents[source.getX()][source.getY()].name=='Q') || (chessComponents[source.getX()][source.getY()].name=='q')){
            ArrayList<ChessboardPoint> canMovePoints;
            QueenChessComponent chessComponent=new QueenChessComponent(source,getChessColor(chessComponents[source.getX()][source.getY()]));
            canMovePoints=(ArrayList<ChessboardPoint>) chessComponent.canMoveTo();
            for (int i = 0; i < canMovePoints.size(); i++) {
                if (!moveChess1(source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY())){
                    canMovePoints.remove(i);
                    i--;
                }
            }
            canMovePoints.sort(new Sort());
            return canMovePoints;
        }else if ((chessComponents[source.getX()][source.getY()].name=='R') || (chessComponents[source.getX()][source.getY()].name=='r')){
            ArrayList<ChessboardPoint> canMovePoints;
            RookChessComponent chessComponent=new RookChessComponent(source,getChessColor(chessComponents[source.getX()][source.getY()]));
            canMovePoints=(ArrayList<ChessboardPoint>) chessComponent.canMoveTo();
            for (int i = 0; i < canMovePoints.size(); i++) {
                if (!moveChess1(source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY())){
                    canMovePoints.remove(i);
                    i--;
                }
            }
            canMovePoints.sort(new Sort());
            return canMovePoints;
        }else if ((chessComponents[source.getX()][source.getY()].name=='B') || (chessComponents[source.getX()][source.getY()].name=='b')){
            ArrayList<ChessboardPoint> canMovePoints;
            BishopChessComponent chessComponent=new BishopChessComponent(source,getChessColor(chessComponents[source.getX()][source.getY()]));
            canMovePoints=(ArrayList<ChessboardPoint>) chessComponent.canMoveTo();
            for (int i = 0; i < canMovePoints.size(); i++) {
                if (!moveChess1(source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY())){
                    canMovePoints.remove(i);
                    i--;
                }
            }
            canMovePoints.sort(new Sort());
            return canMovePoints;
        }else if ((chessComponents[source.getX()][source.getY()].name=='N') || (chessComponents[source.getX()][source.getY()].name=='n')){
            List<ChessboardPoint> canMovePoints;
            KnightChessComponent chessComponent=new KnightChessComponent(source,getChessColor(chessComponents[source.getX()][source.getY()]));
            canMovePoints= chessComponent.canMoveTo();
            for (int i = 0; i < canMovePoints.size(); i++) {
                if (!moveChess1(source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY())){
                    canMovePoints.remove(i);
                    i--;
                }
            }
            canMovePoints.sort(new Sort());
            return canMovePoints;
        }else if ((chessComponents[source.getX()][source.getY()].name=='P') || (chessComponents[source.getX()][source.getY()].name=='p')){
            List<ChessboardPoint> canMovePoints;
            PawnChessComponent chessComponent=new PawnChessComponent(source,getChessColor(chessComponents[source.getX()][source.getY()]));
            canMovePoints= chessComponent.canMoveTo();
            for (int i = 0; i < canMovePoints.size(); i++) {
                if (!moveChess1(source.getX(),source.getY(),canMovePoints.get(i).getX(),canMovePoints.get(i).getY())){
                    canMovePoints.remove(i);
                    i--;
                }
            }
            canMovePoints.sort(new Sort());
            return canMovePoints;
        }else if (chessComponents[source.getX()][source.getY()].name=='_'){
            return new ArrayList<>();
        }
        return null;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if ( targetX>7 | targetX<0 | targetY>7 | targetY<0 ){
            return false;
        }else if (chessComponents[sourceX][sourceY].name=='_') {
            return false;
        }else if (getCanMovePoints(new ChessboardPoint(sourceX,sourceY)).contains(new ChessboardPoint(targetX,targetY)) & chessComponents[sourceX][sourceY].chessColor==currentPlayer){
            chessComponents[targetX][targetY].source=new ChessboardPoint(targetX,targetY);
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE);
            if (currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
                return true;
            }
            if (currentPlayer==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }
            return true;
        }
       return false;
    }
    public boolean moveChess1(int sourceX, int sourceY, int targetX, int targetY) {
        if ( targetX>7 | targetX<0 | targetY>7 | targetY<0){
            return false;
        }else if (chessComponents[sourceX][sourceY].name=='_' ){
            return false;
        } else if (( /*currentPlayer==ChessColor.BLACK && */ chessComponents[targetX][targetY].chessColor!=ChessColor.BLACK && chessComponents[sourceX][sourceY].name=='R') |( chessComponents[targetX][targetY].chessColor!=ChessColor.WHITE && /*currentPlayer==ChessColor.WHITE && */ chessComponents[sourceX][sourceY].name=='r')){
            //if ( new RookChessComponent(new ChessboardPoint(sourceX,sourceY),chessComponents[sourceX][sourceY].chessColor).canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                if (sourceX==targetX){
                    if (Math.abs(targetY-sourceY)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for(int i=1;i<Math.abs(sourceY-targetY);i++){
                        if (chessComponents[sourceX][Math.max(sourceY,targetY)-i].name!='_'){
                            return false;
                        }
                    }
                }
                if (sourceY==targetY) {
                    if (Math.abs(targetX-sourceX)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for (int i = 1; i < Math.abs(sourceX - targetX); i++) {
                        if (chessComponents[Math.max(sourceX, targetX) - i][sourceY].name != '_') {
                            return false;
                        }
                    }
                }
                return true;
            //}
        }else if ((chessComponents[targetX][targetY].chessColor!=ChessColor.BLACK &&/* currentPlayer==ChessColor.BLACK && */chessComponents[sourceX][sourceY].name=='B') || (chessComponents[targetX][targetY].chessColor!=ChessColor.WHITE && /*currentPlayer==ChessColor.WHITE &&*/ chessComponents[sourceX][sourceY].name=='b')){
            //if (new BishopChessComponent(new ChessboardPoint(sourceX,sourceY),chessComponents[sourceX][sourceY].chessColor).canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
                if (targetY-sourceY==targetX-sourceX){
                    if (Math.abs(targetY-sourceY)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for (int i = 1; i <Math.abs(targetX-sourceX) ; i++) {
                        int x=Math.max(sourceX,targetX);
                        int y=Math.max(sourceY,targetY);
                        if (chessComponents[x-i][y-i].name!='_'){
                            return false;
                        }
                    }
                }
                if (targetX-sourceX==sourceY-targetY){
                    if (Math.abs(targetY-sourceY)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for (int i = 1; i <Math.abs(targetX-sourceX) ; i++) {
                        if (chessComponents[Math.max(sourceX,targetX)-i][Math.min(sourceY,targetY)+i].name!='_'){
                            return false;
                        }
                    }
                }
                return true;
            //}
        }else if ((chessComponents[targetX][targetY].chessColor!=ChessColor.BLACK && /*currentPlayer==ChessColor.BLACK && */ chessComponents[sourceX][sourceY].name=='Q') || (chessComponents[targetX][targetY].chessColor!=ChessColor.WHITE && /*currentPlayer==ChessColor.WHITE &&*/ chessComponents[sourceX][sourceY].name=='q')){
            //if (new QueenChessComponent(new ChessboardPoint(sourceX,sourceY),chessComponents[sourceX][sourceY].chessColor).canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
                if (sourceX==targetX){
                    if (Math.abs(targetY-sourceY)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for(int i=1;i<Math.abs(sourceY-targetY);i++){
                        if (chessComponents[sourceX][Math.max(sourceY,targetY)-i].name!='_'){
                            return false;
                        }
                    }
                }
                if (sourceY==targetY) {
                    if (Math.abs(targetX-sourceX)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for (int i = 1; i < Math.abs(sourceX - targetX); i++) {
                        if (chessComponents[Math.max(sourceX, targetX) - i][sourceY].name != '_') {
                            return false;
                        }
                    }
                }
                if (targetY-sourceY==targetX-sourceX){
                    if (Math.abs(targetY-sourceY)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for (int i = 1; i <Math.abs(targetX-sourceX) ; i++) {
                        if (chessComponents[Math.min(sourceX,targetX)+i][Math.min(sourceY,targetY)+i].name!='_'){
                            return false;
                        }
                    }
                }
                if (targetX-sourceX==sourceY-targetY){
                    if (Math.abs(targetY-sourceY)==1){
                        return chessComponents[targetX][targetY].chessColor !=chessComponents[sourceX][sourceY].chessColor;
                    }
                    for (int i = 1; i <Math.abs(targetX-sourceX) ; i++) {
                        if (chessComponents[Math.max(sourceX,targetX)-i][Math.min(sourceY,targetY)+i].name!='_'){
                            return false;
                        }
                    }
                }
                return true;
            //}
        } else if ((chessComponents[targetX][targetY].chessColor!=ChessColor.BLACK && /*currentPlayer==ChessColor.BLACK && */chessComponents[sourceX][sourceY].name=='N') || (chessComponents[targetX][targetY].chessColor!=ChessColor.WHITE && /*currentPlayer==ChessColor.WHITE && */chessComponents[sourceX][sourceY].name=='n')){
             return true;
        }else if ((chessComponents[targetX][targetY].chessColor!=ChessColor.BLACK && /*currentPlayer==ChessColor.BLACK && */chessComponents[sourceX][sourceY].name=='K') || (chessComponents[targetX][targetY].chessColor!=ChessColor.WHITE && /*currentPlayer==ChessColor.WHITE && */chessComponents[sourceX][sourceY].name=='k')){
            return true;
        }else if (chessComponents[targetX][targetY].chessColor!=ChessColor.BLACK && /*currentPlayer==ChessColor.BLACK && */chessComponents[sourceX][sourceY].name=='P'){
//            if (new PawnChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK).canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
                if (sourceY==targetY){
                    if (targetX-sourceX==1){
                        return chessComponents[targetX][targetY].name == '_';
                    }
                    for (int i = 1; i <targetX-sourceX ; i++) {
                        if (chessComponents[sourceX+i][targetY].name!='_'){
                            return false;
                        }
                    }
                }else return chessComponents[targetX][targetY].name != '_';
                return true;
            //}
//            return false;
        }else if (chessComponents[targetX][targetY].chessColor!=ChessColor.WHITE && /*currentPlayer==ChessColor.WHITE && */chessComponents[sourceX][sourceY].name=='p') {
//            if (new PawnChessComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.WHITE).canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
                if (sourceY == targetY) {
                    if (sourceX-targetX==1){
                        return chessComponents[targetX][targetY].name == '_';
                    }
                    for (int i = 1; i < sourceX - targetX; i++) {
                        if (chessComponents[sourceX - i][targetY].name != '_') {
                            return false;
                        }
                    }
                } else return chessComponents[targetX][targetY].name != '_';
                return true;
            //}
//            return false;
        }
        return false;
    }
    private static class Sort implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            return p1.getX()==p2.getX()?p1.getY()-p2.getY():p1.getX()-p2.getX();
        }
    }
}
