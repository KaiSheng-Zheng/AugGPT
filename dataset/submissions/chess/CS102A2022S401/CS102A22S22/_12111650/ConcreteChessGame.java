import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = ChessComponent.chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame(ChessComponent[][] chessComponents,ChessColor currentPlayer){
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame(){
        currentPlayer = ChessColor.WHITE;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
          for(int i = 0;i<chessboard.size()-1;i++){
              for(int y = 0;y<chessboard.get(i).length();y++){
                  ChessboardPoint P = new ChessboardPoint(i,y);
                  switch (chessboard.get(i).charAt(y)){
                      case 'r':
                          chessComponents[i][y] = new RookChessComponent(P,ChessColor.WHITE,'r');
                          break;
                      case 'R':
                          chessComponents[i][y] = new RookChessComponent(P,ChessColor.BLACK,'R');
                          break;
                      case 'b':
                          chessComponents[i][y] = new BishopChessComponent(P,ChessColor.WHITE,'b');
                          break;
                      case 'B':
                          chessComponents[i][y] = new BishopChessComponent(P,ChessColor.BLACK,'B');
                          break;
                      case 'n':
                          chessComponents[i][y] = new KnightChessComponent(P,ChessColor.WHITE,'n');
                          break;
                      case 'N':
                          chessComponents[i][y] = new KnightChessComponent(P,ChessColor.BLACK,'N');
                          break;
                      case 'q':
                          chessComponents[i][y] = new QueenChessComponent(P,ChessColor.WHITE,'q');
                          break;
                      case 'Q':
                          chessComponents[i][y] = new QueenChessComponent(P,ChessColor.BLACK,'Q');
                          break;
                      case 'K':
                          chessComponents[i][y] = new KingChessComponent(P,ChessColor.BLACK,'K');
                          break;
                      case 'k':
                          chessComponents[i][y] = new KingChessComponent(P,ChessColor.WHITE,'k');
                          break;
                      case 'p':
                          chessComponents[i][y] = new PawnChessComponent(P,ChessColor.WHITE,'p');
                          break;
                      case 'P':
                          chessComponents[i][y] = new PawnChessComponent(P,ChessColor.BLACK,'P');
                          break;
                      case '_':
                          chessComponents[i][y] = new EmptySlotComponent(P,ChessColor.NONE,'_');
                  }
              }
              if(Objects.equals(chessboard.get(chessboard.size() - 1), "b")){
                  this.currentPlayer = ChessColor.BLACK;
              }
          }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder result = new StringBuilder();
        String s1 = "\n";
        for(int i=0;i<chessComponents.length;i++){
            for(int y = 0;y<chessComponents[i].length;y++){
                result.append(chessComponents[i][y].getName());
            }
            result.append(s1);
            if(i == 7) break;
        }
        return result.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String s = getChessboardGraph();
        String component = s.replaceAll("\n","");
        String blackWhite = component.replaceAll("_","");
        if(player == ChessColor.BLACK){
            int K = 0;
            int Q = 0;
            int R = 0;
            int B = 0;
            int N = 0;
            int P = 0;
            for(int i =0;i<blackWhite.length();i++){
                if(blackWhite.charAt(i)=='K'){
                    K++;
                }
                else if(blackWhite.charAt(i)=='Q'){
                    Q++;
                }
                else if(blackWhite.charAt(i)=='R'){
                    R++;
                }
                else if(blackWhite.charAt(i)=='B'){
                    B++;
                }
                else if(blackWhite.charAt(i)=='N'){
                    N++;
                }
                else if(blackWhite.charAt(i)=='P'){
                    P++;
                }
            }
            StringBuilder answer = new StringBuilder();
            if(K != 1){
                answer.append("K 1\n");
            }
            if(Q != 1){
                answer.append("Q 1\n");
            }
            if(R != 2){
                int cha = 2-R;
                String a = "R "+cha+"\n";
                answer.append(a);
            }
            if(B != 2){
                int cha = 2-B;
                String a = "B "+cha+"\n";
                answer.append(a);
            }
            if(N != 2){
                int cha = 2-N;
                String a = "N "+cha+"\n";
                answer.append(a);
            }
            if(P != 8){
                int cha = 8-P;
                String a = "P "+cha+"\n";
                answer.append(a);
            }
            return answer.toString();
        }
        else{
            int k = 0;
            int q = 0;
            int r = 0;
            int b = 0;
            int n = 0;
            int p = 0;
            for(int i =0;i<blackWhite.length();i++){
                if(blackWhite.charAt(i)=='k'){
                    k++;
                }
                else if(blackWhite.charAt(i)=='q'){
                    q++;
                }
                else if(blackWhite.charAt(i)=='r'){
                    r++;
                }
                else if(blackWhite.charAt(i)=='b'){
                    b++;
                }
                else if(blackWhite.charAt(i)=='n'){
                    n++;
                }
                else if(blackWhite.charAt(i)=='p'){
                    p++;
                }
            }
            StringBuilder answer = new StringBuilder();
            if(k != 1){
                answer.append("k 1\n");
            }
            if(q != 1){
                answer.append("q 1\n");
            }
            if(r != 2){
                int cha = 2-r;
                String a = "r "+cha+"\n";
                answer.append(a);
            }
            if(b != 2){
                int cha = 2-b;
                String a = "b "+cha+"\n";
                answer.append(a);
            }
            if(n != 2){
                int cha = 2-n;
                String a = "n "+cha+"\n";
                answer.append(a);
            }
            if(p != 8){
                int cha = 8-p;
                String a = "p "+cha+"\n";
                answer.append(a);
            }
            return answer.toString();
        }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent start = getChess(source.getX(),source.getY());
        List<ChessboardPoint> ans = start.canMoveTo();
        List<ChessboardPoint> aa = new ArrayList<>();
        List<ChessboardPoint> p1 = new ArrayList<>();
        List<ChessboardPoint> p2 = new ArrayList<>();
        List<ChessboardPoint> p3 = new ArrayList<>();
        List<ChessboardPoint> p4 = new ArrayList<>();
        List<ChessboardPoint> p5 = new ArrayList<>();
        List<ChessboardPoint> p6 = new ArrayList<>();
        List<ChessboardPoint> p7 = new ArrayList<>();
        List<ChessboardPoint> p8 = new ArrayList<>();
        if(ans.isEmpty()){
            return ans;
        }
        else {
            for(int i=0;i<ans.size()-1;i++){
                boolean flag = false;
                for (int j =0;j<ans.size()-1;j++){
                    int x1 = ans.get(j).getX();
                    int x2 = ans.get(j+1).getX();
                    if(x1>x2){
                        ChessboardPoint tem1 = ans.get(j);
                        ChessboardPoint tem2 = ans.get(j+1);
                        ans.set(j,tem2);
                        ans.set(j+1,tem1);
                        flag = true;
                    }
                }
                if (!flag){
                    break;
                }
            }
            for (ChessboardPoint P : ans){
                if(P.getX() == 0){
                    p1.add(P);
                }
                else if(P.getX() == 1){
                    p2.add(P);
                }
                else if(P.getX() == 2){
                    p3.add(P);
                }
                else if(P.getX() == 3){
                    p4.add(P);
                }
                else if(P.getX() == 4){
                    p5.add(P);
                }
                else if(P.getX() == 5){
                    p6.add(P);
                }
                else if(P.getX() == 6){
                    p7.add(P);
                }
                else if(P.getX() == 7){
                    p8.add(P);
                }
            }
            if(!p1.isEmpty()){
                for(int i=0;i<p1.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p1.size()-1;j++){
                        int y1 = p1.get(j).getY();
                        int y2 = p1.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p1.get(j);
                            ChessboardPoint tem2 = p1.get(j+1);
                            p1.set(j,tem2);
                            p1.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p2.isEmpty()){
                for(int i=0;i<p2.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p2.size()-1;j++){
                        int y1 = p2.get(j).getY();
                        int y2 = p2.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p2.get(j);
                            ChessboardPoint tem2 = p2.get(j+1);
                            p2.set(j,tem2);
                            p2.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p3.isEmpty()){
                for(int i=0;i<p3.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p3.size()-1;j++){
                        int y1 = p3.get(j).getY();
                        int y2 = p3.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p3.get(j);
                            ChessboardPoint tem2 = p3.get(j+1);
                            p3.set(j,tem2);
                            p3.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p4.isEmpty()){
                for(int i=0;i<p4.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p4.size()-1;j++){
                        int y1 = p4.get(j).getY();
                        int y2 = p4.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p4.get(j);
                            ChessboardPoint tem2 = p4.get(j+1);
                            p4.set(j,tem2);
                            p4.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p5.isEmpty()){
                for(int i=0;i<p5.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p5.size()-1;j++){
                        int y1 = p5.get(j).getY();
                        int y2 = p5.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p5.get(j);
                            ChessboardPoint tem2 = p5.get(j+1);
                            p5.set(j,tem2);
                            p5.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p6.isEmpty()){
                for(int i=0;i<p6.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p6.size()-1;j++){
                        int y1 = p6.get(j).getY();
                        int y2 = p6.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p6.get(j);
                            ChessboardPoint tem2 = p6.get(j+1);
                            p6.set(j,tem2);
                            p6.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p7.isEmpty()){
                for(int i=0;i<p7.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p7.size()-1;j++){
                        int y1 = p7.get(j).getY();
                        int y2 = p7.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p7.get(j);
                            ChessboardPoint tem2 = p7.get(j+1);
                            p7.set(j,tem2);
                            p7.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            if(!p8.isEmpty()){
                for(int i=0;i<p8.size()-1;i++){
                    boolean flag = false;
                    for (int j =0;j<p8.size()-1;j++){
                        int y1 = p8.get(j).getY();
                        int y2 = p8.get(j+1).getY();
                        if(y1>y2){
                            ChessboardPoint tem1 = p8.get(j);
                            ChessboardPoint tem2 = p8.get(j+1);
                            p8.set(j,tem2);
                            p8.set(j+1,tem1);
                            flag = true;
                        }
                    }
                    if (!flag){
                        break;
                    }
                }
            }
            aa.addAll(p1);
            aa.addAll(p2);
            aa.addAll(p3);
            aa.addAll(p4);aa.addAll(p5);aa.addAll(p6);aa.addAll(p7);aa.addAll(p8);
            return aa;
        }
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(sourceX<0||sourceX>7||sourceY<0||sourceY>7||targetX<0||targetY>7){
            return false;
        }
        else {
            ChessComponent start = getChess(sourceX,sourceY);
            ChessComponent end1 = getChess(targetX,targetY);
            ChessboardPoint end = new ChessboardPoint(targetX,targetY);
            ChessboardPoint start1 = new ChessboardPoint(sourceX,sourceY);
            if(start.getChessColor() == getCurrentPlayer()){
                if(getCanMovePoints(start1).contains(end)){
                    swapChess(start,end1);
                    swapColor();
                    return true;
                }
                else return false;
            }
            else return false;
        }
    }
    public void swapChess (ChessComponent p1 , ChessComponent p2){
        int x1 = p1.getSource().getX();
        int y1 = p1.getSource().getY();
        int x2 = p2.getSource().getX();
        int y2 = p2.getSource().getY();
        char b = p1.getName();
        if(b =='b'||b=='B'){
            chessComponents[x2][y2] = new BishopChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'k'||b == 'K'){
            chessComponents[x2][y2] = new KingChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'n'||b == 'N'){
            chessComponents[x2][y2] = new KnightChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'p'||b == 'P'){
            chessComponents[x2][y2] = new PawnChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else if(b == 'q'||b == 'Q'){
            chessComponents[x2][y2] = new QueenChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        else {
            chessComponents[x2][y2] = new RookChessComponent(new ChessboardPoint(x2,y2),p1.getChessColor(), p1.getName());
        }
        chessComponents[x1][y1] = new EmptySlotComponent(new ChessboardPoint(x1,y1),ChessColor.NONE,'_');

    }
    public void swapColor() {
        if(getCurrentPlayer()==ChessColor.BLACK){
            setCurrentPlayer(ChessColor.WHITE);
        }else setCurrentPlayer(ChessColor.BLACK);
    }
}
