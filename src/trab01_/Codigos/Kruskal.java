import java.util.ArrayList;

public class Kruskal {
	private Graph g; // grafo vindo de parâmetro
	private ArrayList<Edge> A; // Lista de arestas ordenadas por peso
	private int T[]; // árvores de arestas
	private boolean V[]; // vertices visitadas
	private Graph X;
	
	public Kruskal(Graph g){
		this.g = g;	
		this.A = g.getEdges();
		this.T = new int[g.getSizeVertex()];
		this.V = new boolean[g.getSizeVertex()];
		this.X = new Graph(g.getSizeVertex(), new ListAdjacency(g.getSizeVertex()));
	}
	
	protected void QuickSort(){
		int size = A.size();
		size--;
		quickSortHelper(0, size);
	}
	
	protected int QuickSortPartition(int first, int last){
		int pivo = A.get(first).getWeight();
		
		int leftmark = first++;
		int rightmark = last;
		
		boolean done = false;
		
		while(done == false){
			while(leftmark <= rightmark && A.get(leftmark).getWeight() <= pivo)
				leftmark++;
			while(A.get(rightmark).getWeight() >= pivo && rightmark >= leftmark)
				rightmark--;
			
			if(rightmark < leftmark){
				done = true;
			}else{
				Edge temp = A.get(leftmark);
				A.set(leftmark, A.get(rightmark));
				A.set(rightmark, temp);
			}	
		} // fim while
		Edge temp = A.get(first);
		A.set(first, A.get(rightmark));
		A.set(rightmark, temp);
		
		return rightmark;
	}
	
	protected void quickSortHelper(int first, int last){
		int splitpoint;
		if(first < last){
			splitpoint = QuickSortPartition(first, last);
			
			quickSortHelper(first, splitpoint--);
			quickSortHelper(splitpoint++, last);
		}
	}
	
	protected void bubbleSort(){
		int size = A.size() - 1;
		for(int i=size; i>=1; i--){
			for(int j=0; j<i; j++){
				if(A.get(j).getWeight() > A.get(j+1).getWeight()){
					Edge aux = A.get(j);
					A.set(j, A.get(j+1));
					A.set(j+1, aux);
				}
			}
		}
	}
	
	protected boolean belongsToUandV(int u, int v){
		if(T[u] == T[v]) return true;
		return false;
	}

	
	public Graph process(){
		for(int i=0; i<g.getSizeVertex(); i++){
			T[i] = i;
			V[i] = false;
		}

		bubbleSort();
		
		for(int i=0; i<A.size(); i++){
			// se não pertence na mesma árvore
			if( belongsToUandV( A.get(i).getFrom(), A.get(i).getTo() ) == false ){
				if(V[A.get(i).getFrom()] == false){
					// união !!
					T[A.get(i).getFrom()] = A.get(i).getTo();
					V[A.get(i).getFrom()] = true;
					X.addEdge(A.get(i).getFrom(), A.get(i).getTo(), A.get(i).getWeight());
				}
				else if(V[A.get(i).getTo()] == false){
					// união !!
					T[A.get(i).getTo()] = A.get(i).getFrom();
					V[A.get(i).getTo()] = true;
					X.addEdge(A.get(i).getTo(), A.get(i).getFrom(), A.get(i).getWeight());
				}
			}
		}
		
		return X;

	}
	
	
}
