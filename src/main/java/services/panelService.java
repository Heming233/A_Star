package services;

import entity.Node;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Heming233
 * @version v1.0
 */

public interface panelService {
    //初始化画布
    public void initUI(Graphics graphics);

    //显示步骤
    public void showStep(ArrayList<Node> close);
}
