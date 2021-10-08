package services.impl;

import entity.Node;
import services.checkService;

import java.util.Arrays;

/**
 * @author Heming233
 * @version v1.0
 */

public class checkServiceImpl implements checkService {
    @Override
    public boolean isCompleted(Node node, Node correct){
        return Arrays.equals(node.getPosition(),correct.getPosition());
    }

    @Override
    public boolean isSolvable(Node node){
        int reverse=0;
        int[] array=node.getPosition();

        //求一维化的初始状态逆序和
        for(int i=0 ; i<9 ; i++){
            for(int j=0 ; j<i ; j++){
                if(array[j]>array[i]){
                    reverse++;
                }
            }
        }

        //根据题意，目标状态一维化后逆序和为奇数，所以初始状态逆序和为奇数则有解
        if(reverse%2!=0){
            return true;
        }
        else{
            return false;
        }
    }

}
