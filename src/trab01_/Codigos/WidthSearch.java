package trab01_.Codigos;


public class WidthSearch {
	private Graph g;
	private String[] colors;
	private int pi[];
	private int distance[];
	private Queue q;
	
	public WidthSearch(Graph g){
		this.g = g;
		this.colors = new String[g.getSizeVertex()];
		this.pi = new int[g.getSizeVertex()];
		this.distance = new int[g.getSizeVertex()];
		this.q = new Queue();
	}
	
	public boolean process(int num){
                if(num >= g.getSizeVertex())
                    return false;
		int s = num;
		int w = 0;
		for(int i=0; i<g.getSizeVertex(); i++){
			colors[i] = "w";
			distance[i] = Integer.MAX_VALUE;
			pi[i] = -1;
		}

		colors[s] = "g";
		distance[s] = 0;
		pi[s] = -1;
		q.add(s, w);
		
		while(!q.verifyEmpty()){
			Item u = q.getHead();
			q.remove();
			for(int v=0; v<g.getSizeVertex(); v++){
				if(g.verifyAdjacency(u.getValue(), v)){
					if(colors[v] == "w"){
						colors[v] = "g";
						distance[v] = distance[u.getValue()]+1;
						pi[v] = u.getValue();
						q.add(v, w);
					}
				}
			}
			colors[u.getValue()] = "b";
		}
                return true;
	}
	
	public int[] getPi(){
		return this.pi;
	}
	
	public String[] getColors(){
		return this.colors;
	}
	
	public String show(){
                String imp = "";
		for(int i=0; i< g.getSizeVertex(); i++){
                    if(distance[i] == Integer.MAX_VALUE)
                        imp+="D ["+i+"]: XX\n";
                    else
                        imp+="D ["+i+"]: "+distance[i]+"\n";
		}
                return imp;
	}
}
