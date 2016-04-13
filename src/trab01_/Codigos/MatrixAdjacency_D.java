package trab01_.Codigos;


public class MatrixAdjacency_D extends ComputationalRepresentation{
	private int matrix[][];
	private int weight[][];
	
	public MatrixAdjacency_D(int sizeVertex){
		super(sizeVertex);
		matrix = new int[sizeVertex][sizeVertex];
		weight = new int[sizeVertex][sizeVertex];
	}
	
	public void addEdge(int u, int v, int w){
		matrix[u][v] = 1;
		weight[u][v] = w;
	}
	
	public boolean verifyAdjacency(int u, int v){
		return matrix[u][v] == 1;
	}
	
	public String show(){
            String imp="";
		for(int i=0; i<this.sizeVertex; i++){
			for(int j=0; j<this.sizeVertex; j++){
                            imp = imp+matrix[i][j]+ "(P:"+weight[i][j]+") ";
			}
			imp = imp+"\n";
		}
                return imp;
	}
	
	public int getWeight(int u, int v){
		return weight[u][v];
	}
}
