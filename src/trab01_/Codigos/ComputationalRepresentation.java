package trab01_.Codigos;


public abstract class ComputationalRepresentation {
    
	protected int sizeVertex;
    
	public ComputationalRepresentation(int sizeVertex){
        this.sizeVertex = sizeVertex;
    }
    
    public abstract void addEdge(int u, int v, int w);
    public abstract void addEdgeD(int u, int v, int w);
    public abstract boolean verifyAdjacency(int u, int v);
    public abstract String show();
    public abstract int getWeight(int u, int v);
}
