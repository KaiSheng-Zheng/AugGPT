import java.util.*;

public class PawnChessComponent extends ChessComponent{
    private final ChessComponent[][] chessComponents;
    public PawnChessComponent(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> out = new ArrayList<ChessboardPoint>();
        ArrayList<ChessComponent> chessComponents1 = new ArrayList<ChessComponent>();
        for (int i = 0; i < 8; i++) {
            chessComponents1.addAll(Arrays.asList(chessComponents[i]).subList(0, 8));
        }

        int playerValue;
        playerValue = this.getChessColor()==ChessColor.BLACK ? 1:-1;
        int x0 = getSource().getX();
        int y0 = getSource().getY();
        int[] dx = {1,1,1};
        int[] dy = {-1,0,1};
        for (int i = 0; i < 3; i++) {
            int x = x0 + dx[i]*playerValue;
            int y = y0 + dy[i]*playerValue;
            if (x<0 || x>7 || y<0 || y>7){
                continue;
            }
            for (ChessComponent chessComponent : chessComponents1){
                if (Objects.equals(chessComponent.getSource(), new ChessboardPoint(x, y))){
                    if (chessComponent.getChessColor()==ChessColor.NONE && dy[i]==0){
                        out.add(new ChessboardPoint(x, y));
                        for (ChessComponent chessComponent2 : chessComponents1){
                            if (Objects.equals(chessComponent2.getSource(), new ChessboardPoint(x+dx[i]*playerValue, y))){
                                if ((x0==1 && playerValue==1) || (x0==6 && playerValue==-1)){
                                    if (chessComponent2.getChessColor()==ChessColor.NONE){
                                        out.add(new ChessboardPoint(x+dx[i]*playerValue, y));
                                    }
                                }

                            }
                        }
                    }else if (chessComponent.getChessColor()!=ChessColor.NONE && chessComponent.getChessColor()!=this.getChessColor() && dy[i]!=0) {
                        out.add(new ChessboardPoint(x, y));
                    }
                }

            }

        }

//        switch (playerValue){
//            case 1 -> {
//
//            }
//        }
//        int addFirst;
//        for (ChessComponent chessComponent : chessComponents1){
//            if (Objects.equals(chessComponent.getSource(), new ChessboardPoint(x0 + playerValue, y0)) && chessComponent.getChessColor()==ChessColor.NONE){
//                out.add(new ChessboardPoint(x0+playerValue,y0));
//                addFirst = 1;
//            }
//        }
//        for (ChessComponent chessComponent : chessComponents1){
//            if (Objects.equals(chessComponent.getSource(), new ChessboardPoint(x0 + 2*playerValue, y0)) && chessComponent.getChessColor()==ChessColor.NONE && addFirst==1){
//                out.add(new ChessboardPoint(x0+2*playerValue,y0));
//            }
//        }
//        for (ChessComponent chessComponent : chessComponents1){
//            if (Objects.equals(chessComponent.getSource(), new ChessboardPoint(x0 + 2*playerValue, y0)) && chessComponent.getChessColor()==ChessColor.NONE && addFirst==1){
//                out.add(new ChessboardPoint(x0+2*playerValue,y0));
//            }
//        }

        Collections.sort(out);
        return out;
    }


}

