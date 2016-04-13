package trab01_.Codigos;


public class ListAdjacency_D extends ComputationalRepresentation{
	private List lists[];

	public ListAdjacency_D(int sizeVertex){
		super(sizeVertex);
		lists = new List[sizeVertex];
		for(int i=0; i<sizeVertex; i++){
			lists[i] = new List();
		}
	}
	
	public void addEdge(int u, int v, int w){
		lists[u].add(v, w);
	}
	
	public boolean verifyAdjacency(int u, int v){
		return lists[u].exist(v);
	}
	
	public int getWeight(int u, int v){
		return lists[u].getWeight(v);
	}
	
	public String show(){
            String imp="";
		for(int i=0; i<super.sizeVertex; i++){
                    imp = imp + "||"+i+"||-->" + lists[i].show()+"\n";
		}
                return imp;
	}
	
}
