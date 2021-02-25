/***
1514 Medium
***/

class Solution {
    class Node {
        int nodeNum;
        double prob;
        public Node(int num, double prob) {
            this.nodeNum = num;
            this.prob = prob;
        }
    }
    
    class MyComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.prob > b.prob) {
                return -1;
            } else if (a.prob < b.prob) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        Node[] visited = new Node[n];
        
        for (int i = 0; i < edges.length; ++i) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (graph.containsKey(n1)) {
                graph.get(n1).add(new Node(n2, succProb[i]));
            } else {
                List<Node> list = new ArrayList<>();
                list.add(new Node(n2, succProb[i]));
                graph.put(n1, list);
            }
            
            if (graph.containsKey(n2)) {
                graph.get(n2).add(new Node(n1, succProb[i]));
            } else {
                List<Node> list = new ArrayList<>();
                list.add(new Node(n1, succProb[i]));
                graph.put(n2, list);
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue(1, new MyComparator());
        Node startNode = new Node(start, 1);
        visited[startNode.nodeNum] = startNode;
        
        pq.offer(startNode);
        
        while (pq.size() > 0) {
            Node cur = pq.poll();
            if (cur.nodeNum == end) return cur.prob;
            if (graph.containsKey(cur.nodeNum)) {
                List<Node> nei = graph.get(cur.nodeNum);
                
                for (Node cn : nei) {
                    Node next = new Node(cn.nodeNum, cur.prob * cn.prob);
                    if (visited[next.nodeNum] == null) {
                        pq.offer(next);
                        visited[next.nodeNum] = next;
                    } else {
                        Node exist = visited[next.nodeNum];
                        if (next.prob > exist.prob) {
                            visited[next.nodeNum] = next;
                            pq.offer(next);
                        }
                    }
                }
            }
        }
        
        return 0;
        
        
    }
}