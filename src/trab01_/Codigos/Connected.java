package trab01_.Codigos;

public class Connected {
	private Graph g;
	private int numComp;
	private int components[];
	
	public Connected(Graph g){
		this.g = g;
		this.components = new int[g.getSizeVertex()];
	}

    public void depthSearch() {
        for (int i = 0; i < components.length; i++) {
            components[i] = -1;
        }
        int idComp = -1;
        for (int i = 0; i < components.length; i++) {
            if (components[i] == -1) {
                idComp++;
                visit(i, idComp);
            }
        }
        this.numComp = idComp+1;
    }
    
    public String result(){
    	String text = "";
    	text += "Número de componentes: "+numComp+"\n";
    	for(int i=0; i<numComp; i++){
    		text += "Componente:"+i+"\n";
    		text += "   Vértices:\n   ";
    		for(int j=0; j<components.length; j++){
    			if(components[j] == i){
    				text += j+"-";
    			}
    		}
    		text += "\n";
    	}
    	
    	return text;
    }

    private void visit(int vert, int idComp) {
        components[vert] = idComp;
        for(int i=0; i<g.getSizeVertex(); i++){
        	if(g.verifyAdjacency(vert, i)){
        		if (components[i] == -1) {
                    visit(i, idComp);
                }
        	}
        }
    }

    public int getNumComponents(){        
        return numComp;
    }

    public int[] getComponents() {
        return components;
    }
}
