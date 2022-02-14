public class Graficos {

	/** Rotação da Imagem 90º á direita */

	static ColorImage rotateImage(ColorImage imagem){
		ColorImage imagem2 = new ColorImage(imagem.getHeight(),imagem.getWidth());	
		for(int i = 0 ; i < imagem.getWidth() ; i++)
			for(int j = 0; j < imagem.getHeight(); j++)
				imagem2.setColor(imagem.getHeight()-j-1,i,imagem.getColor(i,j));
		return imagem2;
	}



	/** Cria Grafico de Dispersão */

	static ColorImage scatterPlot(int[] valores, int espaco, int largura, Color cor){
		ColorImage imagem = new ColorImage(getWidth(valores,largura,espaco), getHeight(valores));
		for (int i = 0; i < valores.length;i++)
			paintPlot(((i+1)*espaco + (i*largura)), imagem.getHeight()-valores[i],largura,imagem,cor);
		return imagem;
	}


	/** Pinta Circulo do Gráfico na Imagem */
	static void paintPlot(int x, int y,int largura, ColorImage imagem, Color cor){
		for (int i = x; i < x+largura ; i++)
			for (int j = y - (largura /2); j < y  + (largura /2); j++)
				if( (Math.pow(i-(x+(largura/2)),2) + Math.pow(j-y,2)) <= Math.pow(largura/4,2))
					imagem.setColor(i,j,cor);
	}




	/** Cria Grafico 2D vertical com gradiante*/

	static ColorImage softVertical2D(int[] valores, int espaco,int largura, Color cor, int grad){
		ColorImage imagem = new ColorImage(getWidth(valores,largura,espaco), getHeight(valores));
		for(int i = 0; i < valores.length;i ++){
			paintColun( (i+1)*espaco + (i*largura),imagem.getHeight()-valores[i],largura,imagem,cor);
			softGraphic( (i+1)*espaco + (i*largura),imagem.getHeight()-valores[i],largura,imagem,cor,grad);
		}
		return imagem;
	}



	/** Cria Gradiante no Gráfico */

	static void softGraphic (int x, int y,int largura, ColorImage imagem, Color cor, int grad){
		
		for(int i = x ; i < x+largura; i++)
			for(int j = y ; j < imagem.getHeight(); j++) {
				if(i < x+grad)
					imagem.setColor(i,j,setGradiant(cor,x+grad-i+1));
				if ( i > x + largura-grad -1 )
					imagem.setColor(i,j,setGradiant(cor,grad-(x+largura-i)+2));
				if ( j < y + grad &&  (i -x > j - y) && (x + largura - i > j - y)) 
					imagem.setColor(i,j,setGradiant(cor,y + grad - j+1));
					
				
			}
	}	

	/** Gradiante da Cor */
	
	static Color setGradiant(Color cor,int grad){
		return new Color (cor.getR()/grad,cor.getG()/grad,cor.getB()/grad);
	}


	/** Cria Grafico 2D vertical */

	static ColorImage vertical2D(int[] valores, int espaco, int largura,Color cor){
		ColorImage imagem = new ColorImage(getWidth(valores,largura,espaco), getHeight(valores));
		for(int i = 0 ; i < valores.length; i++)
			paintColun( (i+1)*espaco + (i*largura),imagem.getHeight()- valores[i],largura,imagem,cor);

		return imagem;
	}



	/** Pinta a coluna do gráfico */

	static void paintColun(int x, int y,int largura, ColorImage imagem, Color cor){
		for(int i = x; i < x+largura; i++)
			for(int j = y; j < imagem.getHeight();j++)
				imagem.setColor(i,j,cor);
	}



	/** Comprimento da Imagem */

	static int getWidth(int[] valores, int largura, int espaco){
		return (((valores.length)*largura) + ((valores.length)*espaco) + espaco);	
	}



	/** Altura da Imagem   */

	static int getHeight(int[] valores){
		return (maxValue(valores) + 20);  // 20 ref. a uma margem no topo
	}



	/** Calcular valor máximo do vector de valores */


	static int maxValue(int[] valores){
		int max = valores[0];
		for (int i =1; i< valores.length; i++)
			if(valores[i] > max)
				max = valores[i];
		return max;	
	}
			 
}
