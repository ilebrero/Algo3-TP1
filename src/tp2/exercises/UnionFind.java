package tp2.exercises;

public class UnionFind {
	private int[] sets;
	
	public UnionFind(int n) {
		sets = new int[n];
		for (int i = 0; i < sets.length; i++) {
			sets[i] = i;
		}
	}
	
	public int find(int n) {
		int father = sets[n];
		while (father != sets[father]) {
			father = sets[father];
		}
		sets[n] = father;
		return father;
	}
	
	public boolean compare(int n1, int n2){
		return find(n1) == find(n2);
	}
	
	public void union(int n1, int n2){
		int n1set = find(n1);
		int n2set = find(n2);
		sets[n1set] = n2set;
	}
}
