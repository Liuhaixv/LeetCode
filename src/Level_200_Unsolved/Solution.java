package Level_200_Unsolved;

import java.util.*;
import java.lang.*;

class Solution {
    int blockId = 1;//岛屿块默认分配id
    Node[][] nodeGrid;//整个网格图

    //创建Queue
    Queue<Node> queue = new LinkedList<>();
    int addedNum = 0;

    class Node {
        int id = 0;//岛屿id;
        boolean isLand;
        int x, y;

        Node(boolean isLand, int x, int y) {
            this.isLand = isLand;
            this.x = x;
            this.y = y;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public int numIslands(char[][] grid) {
        //初始化网格nodeGrid
        initialGrid(grid);
        calculateBlocks(nodeGrid);
        int result = blockId - 1;
        blockId = 1;
        return result;
    }

    private void initialGrid(char[][] grid) {
        nodeGrid = new Node[grid.length][];
        for (int x = 0; x < grid.length; x++) {
            nodeGrid[x] = new Node[grid[x].length];
            for (int y = 0; y < grid[x].length; y++) {
                nodeGrid[x][y] = new Node(grid[x][y] == '1' ? true : false, x, y);
            }
        }
    }

    private void calculateBlocks(Node[][] nodeGrid) {
        for (int x = 0; x < nodeGrid.length; x++) {
            for (int y = 0; y < nodeGrid[x].length; y++) {
                //进行一次BFS,如果(x,y)不为陆地则continue
                if (BFS(x, y))
                    blockId++;
            }
        }
    }

    /**
     * 结点不为陆地返回false
     **/
    private boolean BFS(int x, int y) {
        Node node = nodeGrid[x][y];
        if (node.id != 0 || !node.isLand)
            return false;
        //添加头结点
        queue.offer(node);
        node.id = blockId;
        //开始遍历
        int times = 1;
        while (!queue.isEmpty()) {
            for (int i = 1; i <= times; i++) {
                Node root = queue.poll();
                BFSsearchNodes(root);
            }
            times = addedNum;
            addedNum = 0;
        }
        return true;
    }

    private void BFSsearchNodes(Node root) {
        int x = root.x;
        int y = root.y;
        LinkedList<Node> list = new LinkedList<>();

        if (!isOutOfBound(x - 1, y))
            list.add(nodeGrid[x - 1][y]);
        if (!isOutOfBound(x + 1, y))
            list.add(nodeGrid[x + 1][y]);
        if (!isOutOfBound(x, y - 1))
            list.add(nodeGrid[x][y - 1]);
        if (!isOutOfBound(x, y + 1))
            list.add(nodeGrid[x][y + 1]);

        Node[] directions = new Node[list.size()];
        for (int i = 0; i < directions.length; i++) {
            directions[i] = list.poll();
        }
        for (int i = 0; i < directions.length; i++) {
            if (directions[i].id == 0 && directions[i].isLand) {
                directions[i].id = blockId;
                queue.offer(directions[i]);
                addedNum++;
            }
        }
    }

    private boolean isOutOfBound(int x, int y) {
        System.out.println(x + " " + y);
        if (x < 0 || x >= nodeGrid.length)
            return true;
        if (y < 0 || y >= nodeGrid[x].length)
            return true;
        return false;
    }
}
/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */