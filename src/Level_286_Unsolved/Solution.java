package Level_286_Unsolved;


import java.util.*;

class Solution {
    public static final int INF = 2147483647;
    Queue<Node> queue = new LinkedList<>();
    HashSet<Node> usedNodes = new HashSet<>();
    int[][] rooms = null;
    int length = 1;

    class Node {
        int x = -1;
        int y = -1;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public void wallsAndGates(int[][] rooms) {
        //拷贝数组
        this.rooms = new int[rooms.length][];
        for (int i = 0; i < this.rooms.length; i++) {
            this.rooms[i] = new int[rooms[i].length];
            for (int k = 0; k < this.rooms[i].length; k++) {
                this.rooms[i][k] = rooms[i][k];
            }
        }

        //遍历
        for (int y = 0; y < rooms.length; y++) {
            for (int x = 0; x < rooms[y].length; x++) {
                calculateDistance(x, y, this.rooms);
            }
        }

        //复制返回
        for (int i = 0; i < this.rooms.length; i++) {
            for (int k = 0; k < this.rooms[i].length; k++) {
                rooms[i][k] = this.rooms[i][k];
            }
        }
    }

    //计算(x,y)处到最近门距离
    private void calculateDistance(int x, int y, int[][] rooms) {
        //判断特殊情况,即rooms[x][y]==0和-1
        if (rooms[x][y] == 0 || rooms[x][y] == -1) {
            return;
        }
        queue.offer(new Node(x, y));//添加首节点
        usedNodes.add(new Node(x, y));

        {
            int times = 1;//节点
            while (!queue.isEmpty()) {
                int addedNum = 0;//加入的节点数
                for (int i = 1; i <= times; i++) {
                    addedNum += addNextNodes(queue.peek());//添加队列头元素的所有子节点并检查是否有目标节点
                    if (addedNum == -2) {//找到目标节点
                        rooms[x][y] = length;
                        length =1;
                        queue.clear();
                        usedNodes.clear();
                        return;
                    }
                    //未找到目标节点
                    queue.poll();
                }
                times = addedNum;
                length++;//开始下一轮搜索
            }
        }
        rooms[x][y] = INF;//未找到目标节点
        length =1;
        queue.clear();
        usedNodes.clear();
    }

    /**
     * 返回添加的节点个数k,找到目标节点返回-2
     */
    private int addNextNodes(Node peek) {
        int nums = 0;
        for (int x = peek.x - 1; x <= peek.x + 1; x++) {
            for (int y = peek.x - 1; y <= peek.x + 1; y++) {
                //检查节点是否越界
                if (isValidNode(x, y)) {
                    //检查节点是否已遍历过
                    if (!usedNodes.contains(new Node(x, y))) {
                        //检查是否为目标节点
                        if (rooms[x][y] == 0) {
                            return -2;
                        } else {
                            //添加已遍历过的节点到Queue和Set
                            nums++;
                            Node visited = new Node(x, y);
                            queue.offer(visited);
                            usedNodes.add(visited);
                        }
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 判断是否越界
     */
    private boolean isValidNode(int x, int y) {
        //先判断是否越界
        if (x >= rooms.length || x < 0) {
            return false;
        } else if (y >= rooms[x].length || y < 0) {
            return false;
        }

        //判断节点是否为可走路径？否决
        return true;
    }
}
