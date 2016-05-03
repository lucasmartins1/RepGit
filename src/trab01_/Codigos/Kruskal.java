package trab01_.Codigos;


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
	
	int Partition(int left, int right)
	{
		int i = left, j = right;
		int pivot = A.get((left+right)/2).getWeight();
		 
		while (i <= j) {
				while (A.get(i).getWeight() < pivot)
					i++;
				while (A.get(j).getWeight() > pivot)
					j--;
				if (i <= j) {
					Edge temp = A.get(i);
					A.set(i, A.get(j));
					A.set(j, temp);
					i++;
					j--;
				}
		  };
		 
		  return i;
	}
	 
	void QuickSort(int left, int right) {
		  int index = Partition(left, right);
		  if (left < index - 1)
				QuickSort(left, index - 1);
		  if (index < right)
				QuickSort(index, right);
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
            int size=A.size();
            size--;
		for(int i=0; i<g.getSizeVertex(); i++){
			T[i] = i;
			V[i] = false;
		}

		QuickSort(0, size);
		
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
