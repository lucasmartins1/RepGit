package trab01_.Codigos;

public class Dijkstra {
	private Graph g;
	private int d[];
	private int pi[];
	// Q->nós com distancia provisória
	private boolean Q[];
	// S->nós com distancia definitiva
	private boolean S[];
	
	public Dijkstra(Graph g){
		this.g = g;
		this.d = new int[g.getSizeVertex()];
		this.pi = new int[g.getSizeVertex()];
		this.Q = new boolean[g.getSizeVertex()];
		this.S = new boolean[g.getSizeVertex()];
	}
	
	protected void relax(int u, int v){
		if(d[v] > (d[u] + g.getWeight(u, v))){
			d[v] = d[u] + g.getWeight(u, v);
			pi[v] = u;
		}
	}
	
	protected int extractMin(){
		int aux = Integer.MAX_VALUE;
		int x = Integer.MAX_VALUE;
		for(int i=0; i<g.getSizeVertex(); i++){
                    if(Q[i] == false){
                        if(d[i] < aux){
				aux = d[i];
				x = i;
			}
                    }
		}
                if(x != Integer.MAX_VALUE)
                    Q[x] = true;
		return x;
	}
	
	protected boolean emptyQ(){
		for(int i=0; i<g.getSizeVertex(); i++){
			if(Q[i] == false) return false;
		}
		return true;
	}
	
	public String process(int num, char tipo){
		int s = num;
		//inicializa
		for(int i=0; i<g.getSizeVertex(); i++){
                    d[i] = Integer.MAX_VALUE;
                    pi[i] = -1;
                    Q[i] = false;
                    S[i] = true;
		}
		d[s] = 0;
		
		while(emptyQ() == false){
			int u = extractMin();
                        if(u == Integer.MAX_VALUE)
                            break;
			// S <- S U {u}
			S[u] = false;
			for(int v=0; v<g.getSizeVertex(); v++){
                            if(g.verifyAdjacency(u, v)){
                                if(tipo=='d'){
                                    relax(u, v);
                                }
                                else if(tipo=='g'){
                                    relax(u,v);
                                    relax(v,u);
                                }
                            }
			}
		}
		
		String imp = "";
		for(int i=0; i<g.getSizeVertex(); i++){
                    if(d[i] == Integer.MAX_VALUE)
                        imp+="D["+i+"]: XX\n";
                    else
                        imp+="D["+i+"]: "+d[i]+"\n";
			//System.out.println("D["+i+"]: "+d[i]);
		}
		for(int i=0; i<g.getSizeVertex(); i++){
                    if(pi[i] == -1)
                        imp+="\nPI["+i+"]: XX";
                    else
                        imp+="\nPI["+i+"]: "+pi[i];
			//System.out.println("PI["+i+"]: "+pi[i]);
		}
                return imp;
		
	}
	
}
