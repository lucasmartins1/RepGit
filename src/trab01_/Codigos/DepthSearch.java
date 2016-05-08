package trab01_.Codigos;


public class DepthSearch {
	private Graph g;
	private String[] colors;
	private int[] starts;
	private int[] ends;
	private int time;
	
	// para os caminhos
	private int goodPath[];
	private boolean verify;
	
	/*
	 * colors:
	 *		w: white
	 * 		g: gray
	 *		b: black
	 */
	
	public DepthSearch(Graph g){
		this.g 		= g;
		this.time	= 0;
		this.colors = new String[g.getSizeVertex()];
		this.starts = new int[g.getSizeVertex()];
		this.ends 	= new int[g.getSizeVertex()];
		
		this.goodPath = new int[g.getSizeVertex()];
		this.verify = true;
	}
	
	public boolean process(int num){
		if(num >= g.getSizeVertex())
                    return false;
		for(int i=0; i< g.getSizeVertex(); i++){
			this.colors[i] = "w";
			this.goodPath[i] = -1;
		}
		
		this.time = 0;
		
		if(colors[num].equals("w")){
			visit(num); // visito o vértice inicial
		}
        verify = false;
		for(int i=0; i< g.getSizeVertex(); i++){
			if(colors[i].equals("w")){
				visit(i); // visito o vértice
			}
		}
                
                return true;
	}
	
	protected void visit(int i){
		this.colors[i] = "g";
		this.time++;
		this.starts[i] = time;
		
		for(int j=0; j < g.getSizeVertex(); j++){
			if(g.verifyAdjacency(i, j)){
				if(colors[j] == "w"){
					visit(j);
					if(verify) goodPath[j] = i;
				}
			}
		}
		colors[i] = "b";
		this.time++;
		ends[i] = this.time;
		
	}
	
	public int[] getGoodPath(){
		return goodPath;
	}
	
	public String show(){
            String imp = "";
		for(int i=0; i< g.getSizeVertex(); i++){
                    imp = imp+i+"\nChegada:" + starts[i]+"\nFinal:" + ends[i]+"\n\n";
		}
                return imp;
	}
}
