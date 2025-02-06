import java.util.*;


public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents =  new ChessComponent[8][8];
//        for(int i=0;i<8;i++){
//            for(int j=0;j<8;j++) {
//                CreateComponents(i,j,'_');
//            }
//        }
        this.currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard){
        for(int line =0;line<chessboard.size();line++){
            if(line>=0&& line<8){
                for(int i=0;i<chessboard.get(line).toCharArray().length;i++){
                    if(i>=0&& i<8)
                    CreateComponents(line,i,chessboard.get(line).toCharArray()[i]);
                }
            }
            if (line == 8){
                if(chessboard.get(line).equals("w")){
                    currentPlayer = ChessColor.WHITE;
                }
                else
                {currentPlayer = ChessColor.BLACK;}

            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j] instanceof KingChessComponent){
                     ((KingChessComponent)chessComponents[i][j]).SetChessComponent(chessComponents);
                }
                if(chessComponents[i][j] instanceof BishopChessComponent){
                    ((BishopChessComponent)chessComponents[i][j]).SetChessComponent(chessComponents);
                }
                if(chessComponents[i][j] instanceof KnightChessComponent){
                    ((KnightChessComponent)chessComponents[i][j]).SetChessComponent(chessComponents);                }
                if(chessComponents[i][j]instanceof PawnChessComponent){
                    ((PawnChessComponent)chessComponents[i][j]).SetChessComponent(chessComponents);
                }
                if(chessComponents[i][j]instanceof QueenChessComponent){
                    ((QueenChessComponent)chessComponents[i][j]).SetChessComponent(chessComponents);
                }
                if(chessComponents[i][j] instanceof RookChessComponent){
                    ((RookChessComponent)chessComponents[i][j]).SetChessComponent(chessComponents);
                }
            }
        }

    }
    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        String res=new String();
        for(int i=0; i<8; i++){
            for(int j=0;j<8;j++){
                res+=chessComponents[i][j].toString();
            }
            if(i!=7){
                res+="\n";
            }
        }
        return res;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String res=new String();
        Map<Character,Integer> count=new HashMap<Character,Integer>();
        count.put('k',1);
        count.put('q',1);
        count.put('r',2);
        count.put('b',2);
        count.put('n',2);
        count.put('p',8);
        if(player==ChessColor.BLACK){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++) {
                    if(Character.isUpperCase(chessComponents[i][j].name)){
                        count.put(Character.toLowerCase(chessComponents[i][j].name),count.get(Character.toLowerCase(chessComponents[i][j].name))-1);
                    }
                }
            }
            if(count.get('k')!=0){
                res+="K "+count.get('k')+"\n";
            }
            if(count.get('q')!=0){
                res+="Q "+count.get('q')+"\n";
            }
            if(count.get('r')!=0){
                res+="R "+count.get('r')+"\n";
            }
            if(count.get('b')!=0){
                res+="B "+count.get('b')+"\n";
            }
            if(count.get('n')!=0){
                res+="N "+count.get('n')+"\n";
            }
            if(count.get('p')!=0){
                res+="P "+count.get('p')+"\n";
            }
        }else{
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++) {
                    if(Character.isLowerCase(chessComponents[i][j].name)){
                        count.put(chessComponents[i][j].name,count.get(chessComponents[i][j].name)-1);
                    }
                }
            }
            if(count.get('k')!=0){
                res+="k "+count.get('k')+"\n";
            }
            if(count.get('q')!=0){
                res+="q "+count.get('q')+"\n";
            }
            if(count.get('r')!=0){
                res+="r "+count.get('r')+"\n";
            }
            if(count.get('b')!=0){
                res+="b "+count.get('b')+"\n";
            }
            if(count.get('n')!=0){
                res+="n "+count.get('n')+"\n";
            }
            if(count.get('p')!=0){
                res+="p "+count.get('p')+"\n";
            }
        }
        return res;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        if(chessComponents[source.getX()][source.getY()] instanceof KingChessComponent){
            return ((KingChessComponent)chessComponents[source.getX()][source.getY()]).canMoveTo();
        }
        if(chessComponents[source.getX()][source.getY()] instanceof BishopChessComponent){
            return ((BishopChessComponent)chessComponents[source.getX()][source.getY()]).canMoveTo();
        }
        if(chessComponents[source.getX()][source.getY()] instanceof KnightChessComponent){
            return ((KnightChessComponent)chessComponents[source.getX()][source.getY()]).canMoveTo();
        }
        if(chessComponents[source.getX()][source.getY()] instanceof PawnChessComponent){
            return ((PawnChessComponent)chessComponents[source.getX()][source.getY()]).canMoveTo();
        }
        if(chessComponents[source.getX()][source.getY()] instanceof QueenChessComponent){
            return ((QueenChessComponent)chessComponents[source.getX()][source.getY()]).canMoveTo();
        }
        if(chessComponents[source.getX()][source.getY()] instanceof RookChessComponent){
            return ((RookChessComponent)chessComponents[source.getX()][source.getY()]).canMoveTo();
        }

        return  chessComponents[source.getX()][source.getY()].canMoveTo();

    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX>8 || sourceX<0)
            return false;
        if(sourceY>8 || sourceY<0)
            return false;
        if(targetX>8 || targetX<0)
            return false;
        if(targetY>8 || targetY<0)
            return false;
        if(chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
            return  false;
        }
        ArrayList<ChessboardPoint> ListMoveTo= (ArrayList<ChessboardPoint>) chessComponents[sourceX][sourceY].canMoveTo();
        boolean contain=false;
        for (int i = 0; i < ListMoveTo.size(); i++) {
            if(targetX==ListMoveTo.get(i).getX()&&targetY==ListMoveTo.get(i).getY()){
                contain=true;
            }
        }
        if(contain){
        /*if(ListMoveTo.contains(new ChessboardPoint(targetX,targetY))){*/
            chessComponents[targetX][targetY]= chessComponents[sourceX][sourceY];
            ChessboardPoint point=chessComponents[targetX][targetY].GetChessboardPoint().offset(targetX-sourceX,targetY-sourceY);
            if(point==null){
                return  false;
            }
            chessComponents[targetX][targetY].SetChessboardPoint(point);


            chessComponents[sourceX][sourceY]= new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            if(currentPlayer==ChessColor.BLACK)
            {currentPlayer=ChessColor.WHITE;}
            else
            { currentPlayer=ChessColor.BLACK;}
            return true;
        }

        return false;
    }

    public void CreateComponents(int x,int y,char name){
        if (name=='R' ||name=='r'){
            ChessComponent chessComponent= new RookChessComponent(new ChessboardPoint(x,y),Character.isUpperCase(name)?ChessColor.BLACK:ChessColor.WHITE,name);
            chessComponents[x][y]=chessComponent;
            return;
        }
        if (name=='N' ||name=='n'){
            ChessComponent chessComponent= new KnightChessComponent(new ChessboardPoint(x,y),Character.isUpperCase(name)?ChessColor.BLACK:ChessColor.WHITE,name);
            chessComponents[x][y]=chessComponent;
            return;
        }
        if (name=='B' ||name=='b'){
            ChessComponent chessComponent= new BishopChessComponent(new ChessboardPoint(x,y),Character.isUpperCase(name)?ChessColor.BLACK:ChessColor.WHITE,name);
            chessComponents[x][y]=chessComponent;
            return;
        }
        if (name=='Q' ||name=='q'){
            ChessComponent chessComponent= new QueenChessComponent(new ChessboardPoint(x,y),Character.isUpperCase(name)?ChessColor.BLACK:ChessColor.WHITE,name);
            chessComponents[x][y]=chessComponent;
            return;
        }
        if (name=='K' ||name=='k'){
            ChessComponent chessComponent= new KingChessComponent(new ChessboardPoint(x,y),Character.isUpperCase(name)?ChessColor.BLACK:ChessColor.WHITE,name);
            chessComponents[x][y]=chessComponent;
            return;
        }
        if (name=='P' ||name=='p') {
            ChessComponent chessComponent = new PawnChessComponent(new ChessboardPoint(x, y), Character.isUpperCase(name) ? ChessColor.BLACK : ChessColor.WHITE, name);
            chessComponents[x][y] = chessComponent;
            return;
        }
        ChessComponent chessComponent= new EmptySlotComponent(new ChessboardPoint(x,y),ChessColor.NONE,name);
        chessComponents[x][y]=chessComponent;
    }
}
