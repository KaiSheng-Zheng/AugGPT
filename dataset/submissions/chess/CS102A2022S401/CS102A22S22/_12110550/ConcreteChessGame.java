import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }
    
    public static ChessComponent checkBig(char chess) {
        if (chess == 'R') {
            RookChessComponent rook=new RookChessComponent();
            rook.name='R';
            return rook;
        } else if (chess == 'N') {
            KnightChessComponent knight=new KnightChessComponent();
            knight.name='N';
            return knight;
        } else if (chess == 'B') {
            BishopChessComponent bis=new BishopChessComponent();
            bis.name='B';
            return bis;
        } else if (chess == 'Q') {
            QueenChessComponent queen=new QueenChessComponent();
            queen.name='Q';
            return queen;
        } else if (chess == 'K') {
            KingChessComponent king=new KingChessComponent();
            king.name='K';
            return king;
        }else {
            PawnChessComponent pawn=new PawnChessComponent();
            pawn.name='P';
            return pawn;
        }
    }

    public static ChessComponent checkSmall(char chess){
        if (chess == 'r') {
            RookChessComponent rook=new RookChessComponent();
            rook.name='r';
            return rook;
        } else if (chess == 'n') {
            KnightChessComponent knight=new KnightChessComponent();
            knight.name='n';
            return knight;
        } else if (chess == 'b') {
            BishopChessComponent bis=new BishopChessComponent();
            bis.name='b';
            return bis;
        } else if (chess == 'q') {
            QueenChessComponent queen=new QueenChessComponent();
            queen.name='q';
            return queen;
        } else if (chess == 'k') {
            KingChessComponent king=new KingChessComponent();
            king.name='k';
            return king;
        }else {
            PawnChessComponent pawn=new PawnChessComponent();
            pawn.name='p';
            return pawn;
        }
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < chessboard.size()-1; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                char c=chessboard.get(i).charAt(j);
                if(c>='A' && c<='Z'){
                    ChessComponent chess=checkBig(c);
                    chess.setChessColor(ChessColor.BLACK);
                    chess.setSource(i,j);
                    chessComponents[i][j]=chess;
                }else if(c>='a' && c<='z'){
                    ChessComponent chess=checkSmall(c);
                    chess.setChessColor(ChessColor.WHITE);
                    chess.setSource(i,j);
                    chessComponents[i][j]=chess;
                }else {
                    ChessComponent chess= new EmptySlotComponent();
                    chess.setChessColor(ChessColor.NONE);
                    chess.setSource(i,j);
                    chess.name='_';
                    chessComponents[i][j]=chess;
                }
            }
        }

        if(Objects.equals(chessboard.get(8), "w")){
            this.currentPlayer=ChessColor.WHITE;
        }else  if(Objects.equals(chessboard.get(8), "b")){
            this.currentPlayer=ChessColor.BLACK;
        }

        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                chessComponents[i][j].setChessComponents(chessComponents);
            }
        }
    }

    public String getChessboardGraph(){
        StringBuilder needReturn=new StringBuilder();
        for (int i = 0; i < chessComponents.length-1; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                needReturn.append(chessComponents[i][j]);
            }
            needReturn.append("\n");
        }
        for (int i = 0; i < chessComponents[7].length; i++) {
            needReturn.append(chessComponents[7][i]);
        }
        return needReturn.toString();
    }


    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getCapturedChess(ChessColor player) {
        int p=0,r=0,n=0,b=0,q=0,k=0;
        StringBuilder needReturn=new StringBuilder();
        if(player==ChessColor.WHITE){
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j<chessComponents[i].length; j++) {
                    char point=chessComponents[i][j].name;
                    switch (point){
                        case 'p':
                            p++;
                            break;
                        case 'r':
                            r++;
                            break;
                        case 'n':
                            n++;
                            break;
                        case 'b':
                            b++;
                            break;
                        case 'q':
                            q++;
                            break;
                        case 'k':
                            k++;
                            break;
                        default:
                            break;


                    }
                }

            }

            if(k!=1){
                needReturn.append("k "+1+"\n");
            }
            if(q!=1){
                needReturn.append("q "+1+"\n");
            }
            if(r!=2){
                int rr=2-r;
                needReturn.append("r ").append(rr).append("\n");
            }
            if(b!=2){
                int bb=2-b;
                needReturn.append("b ").append(bb).append("\n");
            }
            if(n!=2){
                int nn=2-n;
                needReturn.append("n ").append(nn).append("\n");
            }
            if(p!=8){
                int pp=8-p;
                needReturn.append("p ").append(pp).append("\n");
            }
            return needReturn.toString();
        }else {
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    char point=chessComponents[i][j].name;
                    switch (point){
                        case 'P':
                            p++;
                            break;
                        case 'R':
                            r++;
                            break;
                        case 'N':
                            n++;
                            break;
                        case 'B':
                            b++;
                            break;
                        case 'Q':
                            q++;
                            break;
                        case 'K':
                            k++;
                            break;
                        default:
                            break;


                    }
                }

            }

            if(k!=1){
                needReturn.append("K "+1+"\n");
            }
            if(q!=1){
                needReturn.append("Q "+1+"\n");
            }
            if(r!=2){
                int rr=2-r;
                needReturn.append("R ").append(rr).append("\n");
            }
            if(b!=2){
                int bb=2-b;
                needReturn.append("B ").append(bb).append("\n");
            }
            if(n!=2){
                int nn=2-n;
                needReturn.append("N ").append(nn).append("\n");
            }
            if(p!=8){
                int pp=8-p;
                needReturn.append("P ").append(pp).append("\n");
            }
            return needReturn.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent current=getChess(source.getX(),source.getY());
        List<ChessboardPoint> sort=current.canMoveTo();
        if(sort==null){
            return new ArrayList<>();
        }else {
            sort=sortChessPoint(sort);
            return sort;
        }

    }

    public List<ChessboardPoint> sortChessPoint (List <ChessboardPoint> points){
        List <ChessboardPoint> sorted=new ArrayList<>();
        List <ChessboardPoint> temp=new ArrayList<>();
        int length=points.size();

        for (int i = 0; i < length; i++) {
            ChessboardPoint small=points.get(0);
            for (int j = 0; j < points.size(); j++) {
                if(points.get(j).getX()<small.getX()){
                    small=points.get(j);
                }
            }
            temp.add(small);
            points.remove(small);
        }

        for (int i = 0; i < length; i++) {
            ChessboardPoint sma=temp.get(0);
            for (int j = 0; j < temp.size(); j++) {
                if(temp.get(j).getX()==sma.getX()){
                    if(temp.get(j).getY()<sma.getY()){
                        sma=temp.get(j);
                    }
                }
            }
            sorted.add(sma);
            temp.remove(sma);
        }

        return sorted;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent current=getChess(sourceX,sourceY);
        if(current.getChessColor()==currentPlayer){
            EmptySlotComponent empty=new EmptySlotComponent();
            List<ChessboardPoint> canMove=current.canMoveTo();
            ChessboardPoint move=new ChessboardPoint(targetX,targetY);
            if(canMove.contains(move)){
                current.setSource(targetX,targetY);
                chessComponents[targetX][targetY]=current;
                chessComponents[sourceX][sourceY]=empty;

                for (int i = 0; i < chessComponents.length; i++) {
                    for (int j = 0; j < chessComponents[i].length; j++) {
                        chessComponents[i][j].setChessComponents(chessComponents);
                    }
                }

                if(current.getChessColor()==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }else if(current.getChessColor()==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }

                return true;
            }else {
                return false;
            }

        }else {
            return false;
        }

    }

    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

}
