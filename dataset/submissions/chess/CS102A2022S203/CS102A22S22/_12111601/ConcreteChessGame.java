import java.util.*;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
    // should be initialized in your construct method.
    // i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
    // should be initialized in your construct method.
    // by default, set the color to white.
    private ChessColor currentPlayer;
    private Map<Character,Integer>map= new LinkedHashMap<>();

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
    }
    @Override
    public void loadChessGame(List<String> chessboard) {
        for(int i=0;i<8;i++){
            String tmpS=chessboard.get(i);
            for(int j=0;j<tmpS.length();j++){
                ChessboardPoint tmp=new ChessboardPoint(i,j);
                switch (tmpS.charAt(j)){
                    case 'R':{
                        chessComponents[i][j]=new RookChessComponent(tmp, ChessColor.BLACK,'R',chessComponents);
                        break;
                    }case 'N':{
                        chessComponents[i][j]=new KnightChessComponent(tmp, ChessColor.BLACK,'N',chessComponents);
                        break;
                    }case 'B':{
                        chessComponents[i][j]=new BishopChessComponent(tmp, ChessColor.BLACK,'B',chessComponents);
                        break;
                    }case 'Q':{
                        chessComponents[i][j]=new QueenChessComponent(tmp, ChessColor.BLACK,'Q',chessComponents);
                        break;
                    }case 'K':{
                        chessComponents[i][j]=new KingChessComponent(tmp, ChessColor.BLACK,'K',chessComponents);
                        break;
                    }case 'P':{
                        chessComponents[i][j]=new PawnChessComponent(tmp, ChessColor.BLACK,'P',chessComponents);
                        break;
                    }case '_':{
                        chessComponents[i][j]=new EmptySlotComponent(tmp, ChessColor.NONE,'_',chessComponents);
                        break;
                    }case 'r':{
                        chessComponents[i][j]=new RookChessComponent(tmp, ChessColor.WHITE,'r',chessComponents);
                        break;
                    }case 'n':{
                        chessComponents[i][j]=new KnightChessComponent(tmp, ChessColor.WHITE,'n',chessComponents);
                        break;
                    }case 'b':{
                        chessComponents[i][j]=new BishopChessComponent(tmp, ChessColor.WHITE,'b',chessComponents);
                        break;
                    }case 'q':{
                        chessComponents[i][j]=new QueenChessComponent(tmp, ChessColor.WHITE,'q',chessComponents);
                        break;
                    }case 'k':{
                        chessComponents[i][j]=new KingChessComponent(tmp, ChessColor.WHITE,'k',chessComponents);
                        break;
                    }case 'p':{
                        chessComponents[i][j]=new PawnChessComponent(tmp, ChessColor.WHITE,'p',chessComponents);
                        break;
                    }
                }
            }
            char nowPlayer=chessboard.get(8).charAt(0);
            if(nowPlayer=='w')currentPlayer=ChessColor.WHITE;
            else currentPlayer=ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder tmp=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                tmp.append(chessComponents[i][j].name);
            }
            tmp.append('\n');
        }
        return tmp.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        map.put('K',1);map.put('Q',1);map.put('R',2);
        map.put('B',2);map.put('N',2);map.put('P',8);
        map.put('k',1);map.put('q',1);map.put('r',2);
        map.put('b',2);map.put('n',2);map.put('p',8);
        StringBuilder tmp=new StringBuilder();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(chessComponents[i][j].name!='_'){
                    char nowKey=chessComponents[i][j].name;
                    map.replace(nowKey,map.get(nowKey)-1);
                }
            }
        }
        for(Map.Entry<Character,Integer>entry:map.entrySet()){
            char key=entry.getKey();
            int value=entry.getValue();
            if(value==0)continue;
            if(player==ChessColor.BLACK&&(key>='a'&&key<='z'))break;
            if(player==ChessColor.WHITE&&(key>='A'&&key<='Z'))continue;
            tmp.append(key);tmp.append(' ');tmp.append(value);
            tmp.append('\n');
        }
        return tmp.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent tmp=chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> ans=tmp.canMoveTo();
        ans.sort((o1, o2) -> {
            if(o1.getX()!=o2.getX())return o1.getX()- o2.getX();
            else return o1.getY()- o2.getY();
        });
        return ans;
    }
    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent tmp=chessComponents[sourceX][sourceY];
        if(tmp.getChessColor()!=currentPlayer)return false;
        boolean flag=false;
        List<ChessboardPoint> ans=tmp.canMoveTo();
        for(ChessboardPoint p:ans)
            if(p.getX()==targetX&&p.getY()==targetY){
                flag=true;break;
            }
        if(flag){
            tmp.setSource(new ChessboardPoint(targetX,targetY));
            chessComponents[targetX][targetY]=tmp;
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_',chessComponents);
            if(currentPlayer==ChessColor.BLACK)currentPlayer=ChessColor.WHITE;
            else currentPlayer=ChessColor.BLACK;
        }
        return flag;
    }
}
