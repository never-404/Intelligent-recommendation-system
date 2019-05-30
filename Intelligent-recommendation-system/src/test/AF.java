package test;

import java.util.ArrayList;  
import java.util.Stack;  
  
public class AF {  
  
    boolean isAF = true;  
    Graph graph;  
    int n;  
    int start, end;  
    Stack<Integer> theStack;  
  
    private ArrayList<Integer> tempList;  
    private String counterexample;
    public String resultLine = " ";
    public String resultLineExample;
  
    public AF(Graph graph, int start, int end) {  
        this.graph = graph;  
        this.start = start;  
        this.end = end;  
    }  
  
    public boolean getResult() {  
        graph.printGraph();  
        n = graph.getN();  //顶点数
        theStack = new Stack<Integer>();  
  
        if (!isConnectable(start, end)) {      // 判断连个节点是否能连通  
            isAF = false;  
            counterexample = "节点之间没有通路";
            resultLineExample = counterexample;
        } else {  
            for (int j = 0; j < n; j++) {  
                tempList = new ArrayList<Integer>();  
                for (int i = 0; i < n; i++) {  
                    tempList.add(0);  
                }  
                graph.getVertexList()[j].setAllVisitedList(tempList);  
            }  
  
            isAF = af(start, end);  
        }  
        return isAF;  
    }  
  
    private boolean af(int start, int end) {  
        graph.getVertexList()[start].setWasVisited(true); // mark it  
        theStack.push(start); // push it  
  
        while (!theStack.isEmpty()) {  
            int v = getAdjUnvisitedVertex(theStack.peek());  
            if (v == -1) // if no such vertex,  
            {  
                tempList = new ArrayList<Integer>();  
                for (int j = 0; j < n; j++) {  
                    tempList.add(0);  
                }  
                graph.getVertexList()[theStack.peek()]  
                        .setAllVisitedList(tempList);// 把栈顶节点访问过的节点链表清空  
                theStack.pop();  
            } else // if it exists,  
            {  
                theStack.push(v); // push it  
            }  
  
            if (!theStack.isEmpty() && end == theStack.peek()) {  
                graph.getVertexList()[end].setWasVisited(false); // mark it  
                printTheStack(theStack);  
                System.out.println();
                resultLine += "<br>";
                theStack.pop();  
            }  
        }  
  
        return isAF;  
    }  
  
    // 判断连个节点是否能连通  
    private boolean isConnectable(int start, int end) {  
        ArrayList<Integer> queue = new ArrayList<Integer>();  
        ArrayList<Integer> visited = new ArrayList<Integer>();  
        queue.add(start);  
        while (!queue.isEmpty()) {  
            for (int j = 0; j < n; j++) {  
                if (graph.getAdjMat()[start][j] == 1 && !visited.contains(j)) {  
                    queue.add(j);  
                }  
            }  
            if (queue.contains(end)) {  
                return true;  
            } else {  
                visited.add(queue.get(0));  
                queue.remove(0);  
                if (!queue.isEmpty()) {  
                    start = queue.get(0);  
                }  
            }  
        }  
        return false;  
    }  
  
    public String counterexample() {  
        for (Integer integer : theStack) {  
            counterexample += graph.displayVertex(integer);  
            
            if (integer != theStack.peek()) {  
                counterexample += "-->";  
            }  
        }  
        resultLineExample = counterexample;
        return counterexample;  
    }  
  
    // 与节点v相邻，并且这个节点没有被访问到，并且这个节点不在栈中  
    public int getAdjUnvisitedVertex(int v) {  
        ArrayList<Integer> arrayList = graph.getVertexList()[v]  
                .getAllVisitedList();  
        for (int j = 0; j < n; j++) {  
            if (graph.getAdjMat()[v][j] == 1 && arrayList.get(j) == 0  
                    && !theStack.contains(j)) {  
                graph.getVertexList()[v].setVisited(j);  
                return j;  
            }  
        }  
        return -1;  
    } // end getAdjUnvisitedVertex()  
  
    public void printTheStack(Stack<Integer> theStack2) {  
        for (Integer integer : theStack2) {  
            System.out.print(graph.displayVertex(integer)); 
            resultLine += graph.displayVertex(integer);
            if (integer != theStack2.peek()) {  
                System.out.print("-->"); 
                resultLine += "-->";
            }  
        }  
    }  
    public String getResultLine()
    {
    	/*for(int i=0;i<resultLine.length();i++)
    	{
    		
    		if(resultLine.charAt(i)=='\0')
    		{
    			
    		}
    		
    	}*/
    	return resultLine;
    }
  
}  