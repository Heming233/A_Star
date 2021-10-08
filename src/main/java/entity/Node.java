package entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Heming233
 * @version v1.0
 */

@Data
@NoArgsConstructor//配置无参构造方法
@AllArgsConstructor//配置有参构造方法
public class Node {
    private int[] position=new int[9];  //当前局面，元素编号为位置，元素数值为在该位置的数字
    private int depth;  //当前深度；从初始位置走到当前位置的步数
    private int evaluation; //从起始位置到目标位置的预估最小步数
    private int misPosition;    //当前位置到目标位置的预估最小步数
    private Node parent;    //当前位置的父状态
}

