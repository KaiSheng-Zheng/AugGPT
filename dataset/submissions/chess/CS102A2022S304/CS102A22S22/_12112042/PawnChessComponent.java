import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent() {

    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint source = getSource();
               if (this.chessColor == ChessColor.BLACK) {
                    if (source.getX() == 1) {
                        ChessboardPoint a1 = new ChessboardPoint(source.getX()+2,source.getY());
                        ChessboardPoint a2 = new ChessboardPoint(source.getX()+1,source.getY());
                        if (chessboard[source.getX()+2][source.getY()] instanceof EmptySlotComponent) {
                            list.add(a1);
                        }
                        if (chessboard[source.getX()+1][source.getY()] instanceof EmptySlotComponent) {
                            list.add(a2);
                        }
                        if(source.getY()-1>=0){
                            ChessboardPoint a3 = new ChessboardPoint(source.getX()+1,source.getY()-1);
                            if(!(chessboard[source.getX()+1][source.getY()-1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()-1].chessColor != this.chessColor){
                                list.add(a3);
                            }
                        }
                        if(source.getY()+1<=7){
                            ChessboardPoint a4 = new ChessboardPoint(source.getX()+1,source.getY()+1);
                            if(!(chessboard[source.getX()+1][source.getY()+1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()+1].chessColor != this.chessColor){
                                list.add(a4);
                            }
                        }
                    } else if (source.getX() != 1) {
                        if(source.getX()+1<=7){
                            ChessboardPoint a1 = new ChessboardPoint(source.getX()+1,source.getY());
                            if (chessboard[source.getX()+1][source.getY()] instanceof EmptySlotComponent) {
                                list.add(a1);
                            }
                            if(source.getY()-1>=0){
                                ChessboardPoint a3 = new ChessboardPoint(source.getX()+1,source.getY()-1);
                                if(!(chessboard[source.getX()+1][source.getY()-1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()-1].chessColor != this.chessColor){
                                    list.add(a3);
                                }
                            }
                            if(source.getY()+1<=7){
                                ChessboardPoint a4 = new ChessboardPoint(source.getX()+1,source.getY()+1);
                                if(!(chessboard[source.getX()+1][source.getY()+1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()+1].chessColor != this.chessColor){
                                    list.add(a4);
                                }
                            }
                        }
                    }
                } else if (this.chessColor == ChessColor.WHITE) {
                    if (source.getX() == 6) {
                        ChessboardPoint a1 = new ChessboardPoint(source.getX()-2,source.getY());
                        ChessboardPoint a2 = new ChessboardPoint(source.getX()-1,source.getY());
                        if (chessboard[source.getX()-2][source.getY()] instanceof EmptySlotComponent) {
                            list.add(a1);
                        }
                        if (chessboard[source.getX()-1][source.getY()] instanceof EmptySlotComponent) {
                            list.add(a2);
                        }
                        if(source.getY()-1>=0){
                            ChessboardPoint a3 = new ChessboardPoint(source.getX()-1,source.getY()-1);
                            if(!(chessboard[source.getX()-1][source.getY()-1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()-1].chessColor != this.chessColor){
                                list.add(a3);
                            }
                        }
                        if(source.getY()+1<=7){
                            ChessboardPoint a4 = new ChessboardPoint(source.getX()-1,source.getY()+1);
                            if(!(chessboard[source.getX()-1][source.getY()+1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()+1].chessColor != this.chessColor){
                                list.add(a4);
                            }
                        }
                    } else  {
                        if(source.getX()-1>=0){
                            ChessboardPoint a1 = new ChessboardPoint(source.getX()-1,source.getY());
                            if (chessboard[source.getX()-1][source.getY()] instanceof EmptySlotComponent) {
                                list.add(a1);
                            }
                            if(source.getY()-1>=0){
                                ChessboardPoint a3 = new ChessboardPoint(source.getX()-1,source.getY()-1);
                                if(!(chessboard[source.getX()-1][source.getY()-1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()-1].chessColor != this.chessColor){
                                    list.add(a3);
                                }
                            }
                            if(source.getY()+1<=7){
                                ChessboardPoint a4 = new ChessboardPoint(source.getX()-1,source.getY()+1);
                                if(!(chessboard[source.getX()-1][source.getY()+1]instanceof EmptySlotComponent) && chessboard[source.getX()+1][source.getY()+1].chessColor != this.chessColor){
                                    list.add(a4);
                                }
                            }
                        }
                    }
                }
        if(list.size() == 0){
            return new ArrayList<>();
        }else{
            return list;
        }
    }
}
