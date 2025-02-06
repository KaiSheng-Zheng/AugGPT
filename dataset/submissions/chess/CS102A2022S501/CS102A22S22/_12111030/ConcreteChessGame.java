import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(){
        this.chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void loadChessGame(List<String> chessboard){
        if(chessboard.get(8).equals("b")){
            currentPlayer=ChessColor.BLACK;
        }
        if(chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);

                if(chessboard.get(i).charAt(j)=='k'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setName('k');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='K'){
                    chessComponents[i][j] = new KingChessComponent();
                    chessComponents[i][j].setName('K');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setName('q');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='Q'){
                    chessComponents[i][j] = new QueenChessComponent();
                    chessComponents[i][j].setName('Q');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='b'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setName('b');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='B'){
                    chessComponents[i][j] = new BishopChessComponent();
                    chessComponents[i][j].setName('B');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='n'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setName('n');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='N'){
                    chessComponents[i][j] = new KnightChessComponent();
                    chessComponents[i][j].setName('N');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='r'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setName('r');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='R'){
                    chessComponents[i][j] = new RookChessComponent();
                    chessComponents[i][j].setName('R');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='p'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName('p');
                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='P'){
                    chessComponents[i][j] = new PawnChessComponent();
                    chessComponents[i][j].setName('P');
                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
                    chessComponents[i][j].setSource(chessboardPoint);
                }
                if(chessboard.get(i).charAt(j)=='_'){
                    chessComponents[i][j] = new EmptySlotComponent();
                    chessComponents[i][j].setName('_');
                    chessComponents[i][j].setChessColor(ChessColor.NONE);
                    chessComponents[i][j].setSource(chessboardPoint);
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
        StringBuilder a0 = new StringBuilder();
        StringBuilder a1 = new StringBuilder();
        StringBuilder a2 = new StringBuilder();
        StringBuilder a3 = new StringBuilder();
        StringBuilder a4 = new StringBuilder();
        StringBuilder a5 = new StringBuilder();
        StringBuilder a6 = new StringBuilder();
        StringBuilder a7 = new StringBuilder();

        for(int i=0;i<8;i++){
            a0.append(chessComponents[0][i]);
        }
        for(int i=0;i<8;i++){
            a1.append(chessComponents[1][i]);
        }
        for(int i=0;i<8;i++){
            a2.append(chessComponents[2][i]);
        }
        for(int i=0;i<8;i++){
            a3.append(chessComponents[3][i]);
        }
        for(int i=0;i<8;i++){
            a4.append(chessComponents[4][i]);
        }
        for(int i=0;i<8;i++){
            a5.append(chessComponents[5][i]);
        }
        for(int i=0;i<8;i++){
            a6.append(chessComponents[6][i]);
        }
        for(int i=0;i<8;i++){
            a7.append(chessComponents[7][i]);
        }
        return a0+"\n"+a1+"\n"+a2+"\n"
                +a3+"\n"+a4+"\n"+a5+"\n"
                +a6+"\n"+a7;
    }


    @Override
    public String getCapturedChess(ChessColor player) {
        int num1 = 1;
        int num2 = 1;
        int num3 = 2;
        int num4 = 2;
        int num5 = 2;
        int num6 = 8;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(player==ChessColor.BLACK){
                    if(chessComponents[i][j].getName()=='K'){
                        num1--;
                    }
                    if(chessComponents[i][j].getName()=='Q'){
                        num2--;
                    }
                    if(chessComponents[i][j].getName()=='R'){
                        num3--;
                    }
                    if(chessComponents[i][j].getName()=='B'){
                        num4--;
                    }
                    if(chessComponents[i][j].getName()=='N'){
                        num5--;
                    }
                    if(chessComponents[i][j].getName()=='P'){
                        num6--;
                    }
                }
                if(player==ChessColor.WHITE){
                    if(chessComponents[i][j].getName()=='k'){
                        num1--;
                    }
                    if(chessComponents[i][j].getName()=='q'){
                        num2--;
                    }
                    if(chessComponents[i][j].getName()=='r'){
                        num3--;
                    }
                    if(chessComponents[i][j].getName()=='b'){
                        num4--;
                    }
                    if(chessComponents[i][j].getName()=='n'){
                        num5--;
                    }
                    if(chessComponents[i][j].getName()=='p'){
                        num6--;
                    }
                }
            }
        }
        if(player==ChessColor.BLACK){
            StringBuilder result =  new StringBuilder();
            if(num1!=0){
                result.append('K');result.append(' ');result.append(num1);result.append("\n");
            }
            if(num2!=0){
                result.append('Q');result.append(' ');result.append(num2);result.append("\n");
            }
            if(num3!=0){
                result.append('R');result.append(' ');result.append(num3);result.append("\n");
            }
            if(num4!=0){
                result.append('B');result.append(' ');result.append(num4);result.append("\n");
            }
            if(num5!=0){
                result.append('N');result.append(' ');result.append(num5);result.append("\n");
            }
            if(num6!=0){
                result.append('P');result.append(' ');result.append(num6);
            }
            return result.toString();
        }
        if(player==ChessColor.WHITE){
            StringBuilder result =  new StringBuilder();
            if(num1!=0){
                result.append('k');result.append(' ');result.append(num1);result.append("\n");
            }
            if(num2!=0){
                result.append('q');result.append(' ');result.append(num2);result.append("\n");
            }
            if(num3!=0){
                result.append('r');result.append(' ');result.append(num3);result.append("\n");
            }
            if(num4!=0){
                result.append('b');result.append(' ');result.append(num4);result.append("\n");
            }
            if(num5!=0){
                result.append('n');result.append(' ');result.append(num5);result.append("\n");
            }
            if(num6!=0){
                result.append('p');result.append(' ');result.append(num6);
            }
            return result.toString();
        }
        else return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> result = new ArrayList<>();
        int sx = source.getX();
        int sy = source.getY();
        List<ChessboardPoint> m = chessComponents[sx][sy].canMoveTo();
        if(m.size()==0){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(move(sx,sy,i,j)){
                        result.add(new ChessboardPoint(i,j));
                    }
                }
            }
            return result;
        }
        else{
            return m;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
        if(chessComponents[sourceX][sourceY].getName()=='_'){
            return false;
        }
        else{
            if(currentPlayer==ChessColor.BLACK){
                if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                        (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                        (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                    return false;
                }
                else{
                    if(chessComponents[sourceX][sourceY].getName()=='P'){
                        if((targetX==sourceX+1)&&(Math.abs(targetY-sourceY)==1)&&
                                (!(chessComponents[targetX][targetY].getName()=='_'))){
                            currentPlayer=ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('P');
                            return true;
                        }
                        else{
                            if(sourceX==1){
                                if((targetX==2)&&(chessComponents[targetX][targetY].getName()=='_')&&(targetY==sourceY)){
                                    currentPlayer=ChessColor.WHITE;
                                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                    chessComponents[sourceX][sourceY].setName('_');
                                    chessComponents[targetX][targetY] = new PawnChessComponent();
                                    chessComponents[targetX][targetY].setName('P');
                                    return true;
                                }
                                if((targetX==3)&&(chessComponents[targetX][targetY].getName()=='_')&&
                                        (chessComponents[2][sourceY].getName()=='_')&&(targetY==sourceY)){
                                    currentPlayer=ChessColor.WHITE;
                                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                    chessComponents[sourceX][sourceY].setName('_');
                                    chessComponents[targetX][targetY] = new PawnChessComponent();
                                    chessComponents[targetX][targetY].setName('P');
                                    return true;
                                }
                                else return false;
                            }
                            if(sourceX==7){
                                return false;
                            }
                            else{
                                if((targetX==sourceX+1)&&(targetY==sourceY)&&(chessComponents[targetX][targetY].getName()=='_')){
                                    currentPlayer=ChessColor.WHITE;
                                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                    chessComponents[sourceX][sourceY].setName('_');
                                    chessComponents[targetX][targetY] = new PawnChessComponent();
                                    chessComponents[targetX][targetY].setName('P');
                                    return true;
                                }
                                else return false;
                            }
                        }
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='R'){
                        if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY))){
                            return false;
                        }
                        else{
                            if(sourceX==targetX){
                                for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                    if(chessComponents[sourceX][i].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            if(sourceY==targetY){
                                for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                    if(chessComponents[i][sourceY].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            currentPlayer=ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new RookChessComponent();
                            chessComponents[targetX][targetY].setName('R');
                            return true;
                        }
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='B'){
                        if((Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY))&&(targetX!=sourceX)){
                            int d = Math.abs(targetX-sourceX);
                            int row=(targetX-sourceX)/d;
                            int col=(targetY-sourceY)/d;
                            for(int i=1;i<d;i++){
                                if(!(chessComponents[sourceX+i*row][sourceY+i*col].getName()=='_')){
                                    return false;
                                }
                            }
                            currentPlayer=ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new BishopChessComponent();
                            chessComponents[targetX][targetY].setName('B');
                            return true;
                        }
                        else{
                            return false;
                        }

                    }
                    if(chessComponents[sourceX][sourceY].getName()=='q'){
                        if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY)
                                ||(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)&&sourceX!=targetX))){
                            return false;
                        }
                        else{
                            if(sourceX==targetX){
                                for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                    if(chessComponents[sourceX][i].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            if(sourceY==targetY){
                                for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                    if(chessComponents[i][sourceY].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            if(Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY)){
                                int d = Math.abs(targetX-sourceX);
                                int row=(targetX-sourceX)/d;
                                int col=(targetY-sourceY)/d;
                                for(int i=1;i<d;i++){
                                    if(chessComponents[sourceX+i*row][sourceY+i*col].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                        }
                        currentPlayer=ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('Q');
                        return true;
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='N'){
                        if(((Math.abs(targetX-sourceX)==2)&&(Math.abs(targetY-sourceY)==1))
                                ||((Math.abs(targetX-sourceX)==1)&&(Math.abs(targetY-sourceY)==2))){
                            currentPlayer = ChessColor.WHITE;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new KnightChessComponent();
                            chessComponents[targetX][targetY].setName('N');
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='K'){
                        if (((sourceX==targetX)&&(Math.abs(sourceY-targetY)==1))||
                                ((sourceY==targetY)&&(Math.abs(sourceX-targetX)==1))||
                                ((Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))&&(Math.abs(sourceX-targetX)==1))){
                            if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                                    (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                                    (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                        currentPlayer = ChessColor.WHITE;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KingChessComponent();
                        chessComponents[targetX][targetY].setName('K');
                        return true;
                    }
                    else return false;
                }
            }
            if(currentPlayer==ChessColor.WHITE){
                if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                        (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                        (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                    return false;
                }
                else{
                    if(chessComponents[sourceX][sourceY].getName()=='p'){
                        if((targetX==sourceX-1)&&(Math.abs(targetY-sourceY)==1)&&
                                (!(chessComponents[targetX][targetY].getName()=='_'))){
                            currentPlayer=ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new PawnChessComponent();
                            chessComponents[targetX][targetY].setName('p');
                            return true;
                        }
                        else{
                            if(sourceX==6){
                                if((targetX==5)&&(chessComponents[targetX][targetY].getName()=='_')&&(targetY==sourceY)){
                                    currentPlayer=ChessColor.BLACK;
                                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                    chessComponents[sourceX][sourceY].setName('_');
                                    chessComponents[targetX][targetY] = new PawnChessComponent();
                                    chessComponents[targetX][targetY].setName('p');
                                    return true;
                                }
                                if((targetX==4)&&(chessComponents[targetX][targetY].getName()=='_')&&
                                        (chessComponents[5][sourceY].getName()=='_')&&(targetY==sourceY)){
                                    currentPlayer=ChessColor.BLACK;
                                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                    chessComponents[sourceX][sourceY].setName('_');
                                    chessComponents[targetX][targetY] = new PawnChessComponent();
                                    chessComponents[targetX][targetY].setName('p');
                                    return true;
                                }
                                else return false;
                            }
                            if(sourceX==0){
                                return false;
                            }
                            else{
                                if((targetX==sourceX-1)&&(targetY==sourceY)&&(chessComponents[targetX][targetY].getName()=='_')){
                                    currentPlayer=ChessColor.BLACK;
                                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                                    chessComponents[sourceX][sourceY].setName('_');
                                    chessComponents[targetX][targetY] = new PawnChessComponent();
                                    chessComponents[targetX][targetY].setName('p');
                                    return true;
                                }
                                else return false;
                            }
                        }
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='r'){
                        if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY))){
                            return false;
                        }
                        else{
                            if(sourceX==targetX){
                                for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                    if(chessComponents[sourceX][i].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            if(sourceY==targetY){
                                for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                    if(chessComponents[i][sourceY].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            currentPlayer=ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new RookChessComponent();
                            chessComponents[targetX][targetY].setName('r');
                            return true;
                        }
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='b'){
                        if((Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY))&&(targetX!=sourceX)){
                            int d = Math.abs(targetX-sourceX);
                            int row=(targetX-sourceX)/d;
                            int col=(targetY-sourceY)/d;
                            for(int i=1;i<d;i++){
                                if(!(chessComponents[sourceX+i*row][sourceY+i*col].getName()=='_')){
                                    return false;
                                }
                            }
                            currentPlayer=ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new BishopChessComponent();
                            chessComponents[targetX][targetY].setName('b');
                            return true;
                        }
                        else{
                            return false;
                        }

                    }
                    if(chessComponents[sourceX][sourceY].getName()=='q'){
                        if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY)
                                ||(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)&&sourceX!=targetX))){
                            return false;
                        }
                        else{
                            if(sourceX==targetX){
                                for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                    if(chessComponents[sourceX][i].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            if(sourceY==targetY){
                                for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                    if(chessComponents[i][sourceY].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                            if(Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY)){
                                int d = Math.abs(targetX-sourceX);
                                int row=(targetX-sourceX)/d;
                                int col=(targetY-sourceY)/d;
                                for(int i=1;i<d;i++){
                                    if(chessComponents[sourceX+i*row][sourceY+i*col].getName()!='_'){
                                        return false;
                                    }
                                }
                            }
                        }
                        currentPlayer=ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new QueenChessComponent();
                        chessComponents[targetX][targetY].setName('q');
                        return true;
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='n'){
                        if(((Math.abs(targetX-sourceX)==2)&&(Math.abs(targetY-sourceY)==1))
                                ||((Math.abs(targetX-sourceX)==1)&&(Math.abs(targetY-sourceY)==2))){
                            currentPlayer=ChessColor.BLACK;
                            chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                            chessComponents[sourceX][sourceY].setName('_');
                            chessComponents[targetX][targetY] = new KnightChessComponent();
                            chessComponents[targetX][targetY].setName('n');
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    if(chessComponents[sourceX][sourceY].getName()=='k'){
                        if (((sourceX==targetX)&&(Math.abs(sourceY-targetY)==1))||
                                ((sourceY==targetY)&&(Math.abs(sourceX-targetX)==1))||
                                ((Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))&&(Math.abs(sourceX-targetX)==1))){
                            if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                                    (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                                    (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                                return false;
                            }
                        }
                        else {
                            return false;
                        }
                        currentPlayer = ChessColor.BLACK;
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                        chessComponents[sourceX][sourceY].setName('_');
                        chessComponents[targetX][targetY] = new KingChessComponent();
                        chessComponents[targetX][targetY].setName('k');
                        return true;
                    }
                }
            }
            else return false;
        }
        //return true;
        return false;
    }
    public boolean move(int sourceX, int sourceY, int targetX, int targetY) {
        chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
        if(chessComponents[sourceX][sourceY].getName()=='_'){
            return false;
        }
        else{
            if(chessComponents[sourceX][sourceY].getName()=='P'){
                if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                        (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                        (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                    return false;
                }
                else{
                    if((targetX==sourceX+1)&&(Math.abs(targetY-sourceY)==1)&&
                            (!(chessComponents[targetX][targetY].getName()=='_'))){
                        return true;
                    }
                    else{
                        if(sourceX==1){
                            if((targetX==2)&&(chessComponents[targetX][targetY].getName()=='_')&&(targetY==sourceY)){
                                return true;
                            }
                            if((targetX==3)&&(chessComponents[targetX][targetY].getName()=='_')&&
                                    (chessComponents[2][sourceY].getName()=='_')&&(targetY==sourceY)){
                                return true;
                            }
                            else return false;
                        }
                        if(sourceX==7){
                            return false;
                        }
                        else{
                            if((targetX==sourceX+1)&&(targetY==sourceY)&&(chessComponents[targetX][targetY].getName()=='_')){
                                return true;
                            }
                            else return false;
                        }
                    }
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='R'){
                if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY))){
                    return false;
                }
                else{
                    if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                            (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                            (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                        return false;
                    }
                    else{
                        if(sourceX==targetX){
                            for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                if(chessComponents[sourceX][i].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                        if(sourceY==targetY){
                            for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                if(chessComponents[i][sourceY].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='B'){
                if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                        (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                        (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                    return false;
                }
                else{
                    if((Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY))&&(targetX!=sourceX)){
                        int d = Math.abs(targetX-sourceX);
                        int row=(targetX-sourceX)/d;
                        int col=(targetY-sourceY)/d;
                        for(int i=1;i<d;i++){
                            if(chessComponents[sourceX+i*row][sourceY+i*col].getName()!='_'){
                                return false;
                            }
                        }
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='Q'){
                if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY)
                        ||(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)&&sourceX!=targetX))){
                    return false;
                }
                else{
                    if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                            (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                            (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                        return false;
                    }
                    else{
                        if(sourceX==targetX){
                            for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                if(chessComponents[sourceX][i].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                        if(sourceY==targetY){
                            for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                if(chessComponents[i][sourceY].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                        if(Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY)){
                            int d = Math.abs(targetX-sourceX);
                            int row=(targetX-sourceX)/d;
                            int col=(targetY-sourceY)/d;
                            for(int i=1;i<d;i++){
                                if(chessComponents[sourceX+i*row][sourceY+i*col].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='N'){
                if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                        (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                        (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                    return false;
                }
                else{
                    if(((Math.abs(targetX-sourceX)==2)&&(Math.abs(targetY-sourceY)==1))
                            ||((Math.abs(targetX-sourceX)==1)&&(Math.abs(targetY-sourceY)==2))){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].getName() == 'K'){
                if (((sourceX==targetX)&&(Math.abs(sourceY-targetY)==1))||
                        ((sourceY==targetY)&&(Math.abs(sourceX-targetX)==1))||
                        ((Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))&&(Math.abs(sourceX-targetX)==1))){
                    if((chessComponents[targetX][targetY].getName()=='K')||(chessComponents[targetX][targetY].getName()=='Q')||
                            (chessComponents[targetX][targetY].getName()=='B')||(chessComponents[targetX][targetY].getName()=='N')||
                            (chessComponents[targetX][targetY].getName()=='R')||(chessComponents[targetX][targetY].getName()=='P')){
                        return false;
                    }
                }
                else {
                    return false;
                }
                return true;
            }
            if(chessComponents[sourceX][sourceY].getName()=='p'){
                if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                        (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                        (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                    return false;
                }
                else{
                    if((targetX==sourceX-1)&&(Math.abs(targetY-sourceY)==1)&&
                            (!(chessComponents[targetX][targetY].getName()=='_'))){
                        return true;
                    }
                    else{
                        if(sourceX==6){
                            if((targetX==5)&&(chessComponents[targetX][targetY].getName()=='_')&&(targetY==sourceY)){
                                return true;
                            }
                            if((targetX==4)&&(chessComponents[targetX][targetY].getName()=='_')&&
                                    (chessComponents[5][sourceY].getName()=='_')&&(targetY==sourceY)){
                                return true;
                            }
                            else return false;
                        }
                        if(sourceX==0){
                            return false;
                        }
                        else{
                            if((targetX==sourceX-1)&&(targetY==sourceY)&&(chessComponents[targetX][targetY].getName()=='_')){
                                return true;
                            }
                            else return false;
                        }
                    }
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='r'){
                if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY))){
                    return false;
                }
                else{
                    if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                            (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                            (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                        return false;
                    }
                    else{
                        if(sourceX==targetX){
                            for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                if(chessComponents[sourceX][i].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                        if(sourceY==targetY){
                            for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                if(chessComponents[i][sourceY].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='b'){
                if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                        (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                        (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                    return false;
                }
                else {
                    if((Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY))&&(targetX!=sourceX)){
                        int d = Math.abs(targetX-sourceX);
                        int row=(targetX-sourceX)/d;
                        int col=(targetY-sourceY)/d;
                        for(int i=1;i<d;i++){
                            if(chessComponents[sourceX+i*row][sourceY+i*col].getName()!='_'){
                                return false;
                            }
                        }
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='q'){
                if(!((sourceX==targetX&&sourceY!=targetY)||(sourceX!=targetX&&sourceY==targetY)
                        ||(Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY)&&sourceX!=targetX))){
                    return false;
                }
                else{
                    if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                            (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                            (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                        return false;
                    }
                    else{
                        if(sourceX==targetX){
                            for(int i=Math.min(sourceY,targetY)+1;i<Math.max(sourceY,targetY);i++){
                                if(chessComponents[sourceX][i].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                        if(sourceY==targetY){
                            for(int i=Math.min(sourceX,targetX)+1;i<Math.max(sourceX,targetX);i++){
                                if(chessComponents[i][sourceY].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                        if(Math.abs(targetX-sourceX)==Math.abs(targetY-sourceY)){
                            int d = Math.abs(targetX-sourceX);
                            int row=(targetX-sourceX)/d;
                            int col=(targetY-sourceY)/d;
                            for(int i=1;i<d;i++){
                                if(chessComponents[sourceX+i*row][sourceY+i*col].getName()!='_'){
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            if(chessComponents[sourceX][sourceY].getName()=='n'){
                if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                        (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                        (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                    return false;
                }
                else {
                    if(((Math.abs(targetX-sourceX)==2)&&(Math.abs(targetY-sourceY)==1))
                            ||((Math.abs(targetX-sourceX)==1)&&(Math.abs(targetY-sourceY)==2))){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
            }
            if (chessComponents[sourceX][sourceY].getName() == 'k'){
                if (((sourceX==targetX)&&(Math.abs(sourceY-targetY)==1))||
                        ((sourceY==targetY)&&(Math.abs(sourceX-targetX)==1))||
                        ((Math.abs(sourceX-targetX)==Math.abs(sourceY-targetY))&&(Math.abs(sourceX-targetX)==1))){
                    if((chessComponents[targetX][targetY].getName()=='k')||(chessComponents[targetX][targetY].getName()=='q')||
                            (chessComponents[targetX][targetY].getName()=='b')||(chessComponents[targetX][targetY].getName()=='n')||
                            (chessComponents[targetX][targetY].getName()=='r')||(chessComponents[targetX][targetY].getName()=='p')){
                        return false;
                    }
                }
                else {
                    return false;
                }
                return true;
            }
            else return false;
        }
    }
}
