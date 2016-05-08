package trab01_.Codigos;

public class CheckPath {
    private Graph g;
    
    public CheckPath(Graph g) {
        this.g = g;
    }

    public String processWidthSearch(int u, int v){
    	WidthSearch x = new WidthSearch(g);
    	x.process(u);
    	String colors[] = x.getColors();
    	int pi[] = x.getPi();
    	String text = "";
    	if(colors[u].equals("b") && colors[v].equals("b")){
    		text += "Existe caminho de "+u+" até "+v+"\n";
    		int aux = pi[v];
    		text += v;
    		while(aux != -1){
    			text += "<-"+aux;
    			aux = pi[aux];
    		}
    		text += "\n\n";
    	}
    	else text += "Não existe caminho";
    	return text;
    }
    
    public String processDepthSearch(int u, int v){
    	DepthSearch x = new DepthSearch(g);
    	x.process(u);
    	int gp[] = x.getGoodPath();
    	String text = "";
    	if(gp[v] != -1){
	    	text += "Existe caminho de "+u+" até "+v+"\n";
			int aux = gp[v];
			text += v;
			while(aux != -1){
				text += "<-"+aux;
				aux = gp[aux];
			}
			text += "\n\n";
    	}else text += "Não existe caminho";
    	
    	return text;
    }

}