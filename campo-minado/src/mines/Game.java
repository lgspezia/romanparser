package mines;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    int[][] minas;
    boolean[][] conquistas;
    boolean[][] caminhoAberto;
    int[] colored;
    List<int[]> colorList = new ArrayList<int[]>();

    int larguraGrid = 8;
    int alturaGrid = 8;
    int tamanhoCampo = 50;
    int numMinas = 10;
    boolean clickInicial=true;
    Random rand;

    void configurador() {
      
      minas=new int[larguraGrid][alturaGrid];
      conquistas = new boolean[larguraGrid][alturaGrid];
      caminhoAberto = new boolean[larguraGrid][alturaGrid];

      for (int x = 0; x < larguraGrid; x++) {
        for (int y = 0; y<alturaGrid; y++) {
          minas[x][y] = 0;
          conquistas[x][y] = false;
          caminhoAberto[x][y] = false;
        }
      }
    }
    void colocarMinas(){
      int idx = 0;
      while(idx<numMinas) {

    	int x = rand.nextInt((larguraGrid));
        int y = rand.nextInt((alturaGrid));

        if(minas[x][y] == 1)continue;
        minas[x][y] = 1;
        idx++;
      }
    }
    void limparMinas() {
      for(int x=0; x<larguraGrid; x++){
        for(int y=0; y<alturaGrid; y++){
          minas[x][y] = 0;
        }
      }
    }
    
    void colorir(int corA, int corB, int corC) {
    	this.colored = new int[]{corA, corB, corC};
    	colorList.add(colored);
    }

    void desarmar(int x,int y){

      if (isLimite(x,y)) return;
      if (caminhoAberto[x][y]) return;
      caminhoAberto[x][y] = true;
      if (calcularProximo(x,y) > 0) return;

      desarmar(x-1, y-1);
      desarmar(x-1, y+1);
      desarmar(x+1, y-1);
      desarmar(x+1, y+1);

      desarmar(x-1, y);
      desarmar(x+1, y);
      desarmar(x, y-1);
      desarmar(x, y+1);
    }


    boolean isLimite(int x,int y) {
      return x < 0||y < 0||x >= larguraGrid||y >= alturaGrid;
    }

    int calcularProximo(int x,int y){
      int indice = 0;
      if (isLimite(x,y)) {
        return 0;
      }

      for(int oX=-1; oX<=1; oX++) {

        for(int oY=-1; oY<=1; oY++) {

          if (isLimite(oX+x,oY+y)) {
            continue;
          }
          indice += minas[oX+x][oY+y];
        }
      }
      return indice;
    }


    // Desenho do Tabuleiro
    public void desenharTabuleiro() {
    	
		for (int x = 0; x < larguraGrid; x++) {
	
	        for (int y = 0; y < alturaGrid; y++) {
	
	           // Cores das celulas do tabuleiro
	          String col1 = "--";
	          String col2 = "XX";
	
	          String corTexto = "00";
	          String colcheteFundo = "[ ]";
	          String chavesFundo = "( )";
	          
	
	          int proximo = calcularProximo(x,y);
	
	          if (conquistas[x][y]) {
	            col1 = chavesFundo;
	            col2 = colcheteFundo;
	          } else if (caminhoAberto[x][y]) {
	            col1 = colcheteFundo;
	            col2 = chavesFundo;
	          }
	
	          boolean alternar = (x+y)%2 == 0;
	          if (alternar) {	            
	            System.out.println(col2);
	          } else {
	        	System.out.println(col1);	            
	          }
	
	          if (proximo == 1) corTexto = col2;
	          if (proximo == 2) corTexto = col1;
	          if (proximo == 3) corTexto = colcheteFundo;
	          if (proximo == 4) corTexto = chavesFundo;
	          if (proximo == 5) corTexto = col1;
	          if (proximo == 6) corTexto = col2;
	
	          // rect(x*tamanhoCampo, y*tamanhoCampo, tamanhoCampo, tamanhoCampo);
	          System.out.println(x*tamanhoCampo + y*tamanhoCampo + tamanhoCampo + tamanhoCampo);
	
	          if (proximo > 0 && caminhoAberto[x][y]) {
	        	  System.out.println(corTexto);
	          }
	        }
	      }

    }

}
