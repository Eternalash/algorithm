package per.rost.pom.algorithm.datastructure;

/**
 * Author:bryan.c
 * Date:2021/9/7
 */
public class State {
    // 图节点的 id
    public int id;
    // 从 start 节点到当前节点的距离
    public int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
