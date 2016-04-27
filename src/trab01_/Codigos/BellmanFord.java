package trab01_.Codigos;

import java.util.ArrayList;

public class BellmanFord {
    private Graph g;
    private int d[];
    private int pi[];
    private ArrayList<Edge> A;

    public BellmanFord(Graph g){
        this.g = g;
        this.d = new int[g.getSizeVertex()];
        this.pi = new int[g.getSizeVertex()];
        this.A = new ArrayList<Edge>();
    }

    protected void relax(int u, int v){
        if(d[v] > (d[u] + g.getWeight(u, v))){
            d[v] = d[u] + g.getWeight(u, v);
            pi[v] = u;
        }
    }

    protected boolean bellman(int num, char tipo){
        int s = num;
        // inicializa !!
        for(int i=0; i<g.getSizeVertex(); i++){
            d[i] = 999999;
            pi[i] = -1;
        }
        d[s] = 0;

        A = g.getEdges();

        // Processa o Bellman !!
        if(tipo=='d'){
            for(int i = 0; i<g.getSizeVertex(); i++){
                for(int j=0; j<A.size(); j++){
                        relax(A.get(j).getFrom(), A.get(j).getTo());
                }
            }
        }
        if(tipo=='g'){
            for(int i = 0; i<g.getSizeVertex(); i++){
                for(int j=0; j<A.size(); j++){
                        relax(A.get(j).getFrom(), A.get(j).getTo());
                        relax(A.get(j).getTo(), A.get(j).getFrom());
                }
            }
        }

        for(int j=0; j<A.size(); j++){
            if(d[A.get(j).getTo()] > d[A.get(j).getFrom()] + g.getWeight(A.get(j).getFrom(), A.get(j).getTo()))
                    return false;
        }
        return true;	
    }

    public String process(int num, char tipo){
        String imp="";
            if(bellman(num, tipo)){
                for(int i=0; i<g.getSizeVertex(); i++){
                    if(d[i] == 999999)
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
            return "Não foi possível executar um caminho mínimo";
    }
}
