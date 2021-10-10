package services.impl;

import entity.Node;
import services.panelService;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Heming233
 * @version v1.0
 */

public class panelServiceImpl extends moveServiceImpl implements panelService {
    @Override
    public void initUI(Graphics g) {
    }

    @Override
    public void showStep(ArrayList<Node> close){
        Iterator<Node> it=close.iterator();
        while(it.hasNext()){
            for(int i=0; i<9; i++){
                System.out.print(it.next().getPosition()[i]+" ");
                if((i+1)%3==0){
                    System.out.println();
                }
            }
        }
        System.out.println();
    }
}
