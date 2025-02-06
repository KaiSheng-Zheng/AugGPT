import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

   public List<ChessboardPoint> canMoveTo(){
      List a=new ArrayList<>();
          for(int i=0;i<8;i++){
              for (int j=0;j<8;j++){
                  ChessboardPoint destination =new ChessboardPoint(i,j);
                  if (getChessColor()==ChessColor.BLACK){
                      if (destination.getX()-getSource().getX()<=2&&destination.getX()-getSource().getX()>0){
                          if (getSource().getY()==destination.getY()){
                              if (getSource().getX()+2==destination.getX()){
                                  if (getSource().getX()==1){
                                      if (Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                      a.add(destination);
                                      continue;
                                      }
                                      else{continue;}
                                  }
                                  else {continue;}
                              }
                              if(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                  a.add(destination);
                                  continue;
                              }
                              else {continue; }
                          }
                          else if (Math.abs(getSource().getY()-destination.getY())==1&&destination.getX()-getSource().getX()==1){
                              if(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                  continue;
                              }else { a.add(destination);
                              continue;}
                          }
                          else {continue;}
                      }
                      else
                      {
                          continue;
                      }
                  }
                  else {
                      if (getSource().getX()-destination.getX()<=2&&getSource().getX()-destination.getX()>0){
                          if (getSource().getY()==destination.getY()){
                              if (destination.getX()+2==getSource().getX()){
                                  if (getSource().getX()==6){
                                      if (Board.getChessComponent1()[destination.getX()][destination.getY()]instanceof EmptySlotComponent){
                                          a.add(destination);
                                          continue;
                                      }
                                  else{continue;}}
                                  else {continue;}
                              }
                              if(Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                  a.add(destination);
                                  continue;
                              }
                              else {continue;}
                          }
                          else if (Math.abs(getSource().getY()-destination.getY())==1&&getSource().getX()-destination.getX()==1){
                             if (Board.getChessComponent1()[destination.getX()][destination.getY()] instanceof EmptySlotComponent){
                                 continue;
                              }
                              else{ a.add(destination);
                              continue;}
                          }
                          else {continue;}
                      }
                      else
                      {
                          continue;
                      }}
              }
          }

return a;  }
}
