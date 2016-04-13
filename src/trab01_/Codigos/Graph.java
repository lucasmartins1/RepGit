package trab01_.Codigos;


public class Graph {
	private int sizeVertex;
	private ComputationalRepresentation rep;
	public Graph(int sizeVertex, ComputationalRepresentation rep){
		this.sizeVertex = sizeVertex;
		this.rep = rep;
	}
	
	public void addEdge(int u, int v, int w){
		rep.addEdge(u, v, w);
	}

	public void addEdgeD(int u, int v, int w){
		rep.addEdge(u, v, w);
	}
	
	public boolean verifyAdjacency(int u, int v){
		return rep.verifyAdjacency(u, v);
	}
	
	public String show(){
            String imp="";
		imp = imp +"Número de Vértices: "+this.sizeVertex+"\n\n";
		imp = imp+rep.show();
                return imp;
	}
	
	public int getSizeVertex(){
		return sizeVertex;
	}
	
	public int getWeight(int u, int v){
		return rep.getWeight(u, v);
	}

}
