public class Graphic {

	private ColorImage imagem;
	private String titulo;
	private String xx;
	private String yy;
	private boolean transp;


	Graphic(ColorImage imagem){
		this.imagem = imagem;
		this.transp = false;
	}

	Graphic(ColorImage imagem, String titulo,String xx,String yy){
		this.imagem = imagem;
		this.titulo = titulo;
		this.xx = xx;
		this.yy = yy;
		this.transp = false;
	}


	/** 1 - adicionar/modificar titulo grafico */
	void changeTitle(String titulo){
		this.titulo = titulo;
	}

	/** 2- adicionar/modificar titulo do eixo dos XX */

	void changeTitleXX(String xx){
		this.xx = xx;
	}

	/** 3- adicionar/modificar titulo do eixo dos YY */

	void changeTitleYY(String yy){
		this.yy = yy;
	}

	/** 4- definir gráfico transparente */

	void setTransp(boolean transp){
		this.transp = transp;	
	}


	/** 5- obter imagem associada ao gráfico */

	ColorImage getImage(){

		if(transp == true){
			ColorImage imagem2 = new ColorImage(imagem.getWidth(),imagem.getHeight());
			for (int i = 0 ; i < imagem.getWidth();i++)
				for (int j = 0 ; j < imagem.getHeight();j++)
					if(imagem.getColor(i,j) != new Color(0,0,0)) {
						if( (i %2 == 0 && j %2 != 0 ) || (i %2 != 0 && j %2 == 0))
							imagem2.setColor(i,j,new Color(0,0,0));
						else
							imagem2.setColor(i,j,imagem.getColor(i,j));
					}
			return imagem2;
		}
		else 
			return imagem;
	}

	/** 6- obter toda informação textual associadas a um gráfico */

	String getInfo(){
		return ("Titulo:" + titulo + ", Eixo dos XX :" + xx + ", Eixo dos YY:" + yy + ".") ;
	}


	/** Verifica se o grafico é nulo */

	boolean isEmpty(){
		for(int i = 0; i <imagem.getWidth(); i++)
			for(int j =0 ; j < imagem.getHeight(); j++)
				if( imagem.isBlack(i,j) != true)
					return false;
		return true;
	}


}
