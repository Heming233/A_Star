package services;

import entity.Node;

/**
 * @author Heming233
 * @version v1.0
 */

public interface moveService {
    //玩家移动方块
    public boolean moveByHand(Node node,int number);

    //A*算法自动求解
    public boolean autoSearchRoad(Node node);

    //初始化结点
     public void update(Node node);

    //二维数组转一维
    public int[] toOne(int[][] old);

    //一维数组转二维
    public int[][] toTwo(int[] old);

    //产生随机不重复一维数组
    public int[] randomArray();
}
