public class functest {

	static void funcaoTeste(){

		/** Variaveis de valores aleatórios */
		int[] valores = {30,56,300,280};
		int espaco = 40;
		int largura = 50;
		int gradient = 10;
		String titulo = "Vendas 2019 2020";		
		String tituloxx = "Mês";
		String tituloyy = "Valores";
		Color cor = new Color(19,136,255);
		boolean teste11 = false;
		
		/** Testes de funções GRAFICOS */
		ColorImage teste = Graficos.vertical2D(valores,espaco,largura,cor);
		ColorImage teste2 = Graficos.softVertical2D(valores,espaco,largura,cor,gradient);
		ColorImage teste3 = Graficos.scatterPlot(valores,espaco,largura,cor);
		ColorImage teste4 = Graficos.rotateImage(teste);
		ColorImage teste5 = Graficos.rotateImage(teste2);
		
		/** Testes da Class Graphic */
		
		Graphic teste6 = new Graphic(teste);
		Graphic teste8 = new Graphic(teste2,titulo,tituloxx,tituloyy);
		teste6.changeTitle(titulo);
		teste6.changeTitleXX(tituloxx);
		teste6.changeTitleYY(tituloyy);
		teste6.setTransp(true);
		ColorImage teste15 = teste6.getImage();
		
		
		ColorImage teste7 = teste6.getImage();
		String informacao = teste6.getInfo();
		
		/** Testes da Class GraphicLibrary */		
		
		GraphicsLibrary teste9 = new GraphicsLibrary(teste6);
		Graphic[] teste10 = new Graphic[5];
		teste10[0] =teste6;
		//teste10[0] =teste8;
		teste10[3] =teste8;
		teste10[1] =teste8;
		teste10[4] =teste8;
		Graphic teste14 = new Graphic(new ColorImage(200,300));
	
		GraphicsLibrary teste12 = new GraphicsLibrary(teste10);
		//teste11 = teste6.isEmpty();
	
		
		
		
	}
	
}
