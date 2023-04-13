import java.util.*;

class Node {
	Node root;
	ArrayList<Node> child;
	String val;
	Node() {
		this.child = new ArrayList<>();
	}
	public void setChild(Node n) {
		this.child.add(n);
	}
	public void setRoot(Node n) {
		this.root = n;
	}
	public Node getRoot() {
		Node cur = this;
		while(cur.root != null) cur = cur.root;
		return cur;
	}
	public void unmerge() {
		for(Node n : this.child) n.unmerge();
		this.val = null;
		this.root = null;
		this.child = new ArrayList<>();
	}
}
class Solution {
	static final int MAX = 51;
	static Node[][] map;
	static ArrayList<String> res;
	
    public String[] solution(String[] commands) {
    	res = new ArrayList<>();
    	map = new Node[MAX][MAX];
    	
    	for(int i = 1; i < MAX; i++) for(int j = 1; j < MAX; j++) map[i][j] = new Node();
    			
        for(String s : commands) {
        	String[] cmd = s.split(" ");
        	switch(cmd[0]) {
        	case "UPDATE": 
        		if (cmd.length == 4) update(cmd[1], cmd[2], cmd[3]);
        		else update(cmd[1], cmd[2]);
        		break;
        	case "MERGE":
        		merge(cmd[1], cmd[2], cmd[3], cmd[4]); break;
        	case "UNMERGE":
        		unmerge(cmd[1], cmd[2]); break;
        	case "PRINT":
        		print(cmd[1], cmd[2]); break;
        	}
        }
        return res.toArray(new String[0]);
    }
    private void update(String r, String c, String val) {
    	int R = Integer.parseInt(r), C = Integer.parseInt(c);
    	Node target = map[R][C].getRoot();
    	target.val = val;
    }
    private void update(String val1, String val2) {
    	for(int i = 1; i < MAX; i++)
    		for(int j = 1; j < MAX; j++)
    			if (val1.equals(map[i][j].val)) map[i][j].val = val2;
    }
    private void merge(String r1, String c1, String r2, String c2) {
    	int R1 = Integer.parseInt(r1), C1 = Integer.parseInt(c1);
    	int R2 = Integer.parseInt(r2), C2 = Integer.parseInt(c2);
    	
    	Node root1 = map[R1][C1].getRoot();
    	Node root2 = map[R2][C2].getRoot();
    	if (root1 == root2) return;
    	
    	if (root1.val == null) root1.val = root2.val;
		root1.setChild(root2);
		root2.setRoot(root1);
    }
    private void unmerge(String r, String c) {
    	int R = Integer.parseInt(r), C = Integer.parseInt(c);
    	Node root = map[R][C].getRoot();
    	String val = root.val;
    	root.unmerge();
    	map[R][C].val = val;
    }
    private void print(String r, String c) {
    	int R = Integer.parseInt(r), C = Integer.parseInt(c);
    	String value = map[R][C].getRoot().val;
    	res.add(value == null ? "EMPTY" : value);
    }
}