package services;

import entity.Node;

import java.util.Arrays;

/**
 * @author Heming233
 * @version v1.0
 */

public interface checkService {

    //检查当前状态是否到达目的状态
    public boolean isCompleted(Node node,Node correct);

    //检查当前状态是否有解
    public boolean isSolvable(Node node);


}
