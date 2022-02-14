public class GraphicsLibrary {

	private int MAX = 30;
	private Graphic[] biblioteca;



	GraphicsLibrary(Graphic grafico){
		this.biblioteca = new Graphic[MAX];
		this.biblioteca[0] = grafico; 	
	}

	GraphicsLibrary(Graphic[] grafico){
		this.biblioteca = new Graphic[MAX];                             
		if(grafico.length > biblioteca.length)
			throw new IllegalArgumentException(" Tamanho do vetor excede tamanho da biblioteca");
		removeEmpty(grafico);
		for (int i = 0; i < grafico.length;i++)
			biblioteca[i] = grafico [i];

	}



	void removeEmpty(Graphic[] grafico){
		for(int i = 0 ; i < grafico.length-1 ; i++) 
			if(grafico[i] == null || grafico[i].isEmpty() == true) {
				grafico[i] = grafico[i+1];
				grafico[i+1] = null; //new Graphic(new ColorImage(1,1));
			}

	}
}
