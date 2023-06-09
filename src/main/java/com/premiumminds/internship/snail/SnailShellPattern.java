package com.premiumminds.internship.snail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
	
	

	public Future<int[]> getSnailShell(int[][] matrix) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<int[]> result = executor.submit(() -> {
		  
			if(matrix == null || matrix.length == 0) {
				int [] sortedArray = new int[0];
				return sortedArray;
			}
			
			if(matrix.length != matrix[0].length) {
				throw new IllegalArgumentException("A matriz deve ser uma matriz quadrada!!!");
			}

		  final int arrayLength = matrix.length*matrix.length;
		  int [] sortedArray = new int[arrayLength];
		  int top = 0;
		  int left = 0;
		  int down = matrix.length-1;
		  int rigth = matrix.length-1;
		  int r = 0;

		  while(r < arrayLength) {
			  //varre a matriz no topo da esquerda para a direita
			  for(int i = 0; i < rigth-top; i++) {
				  sortedArray[r] = matrix[left][left + i];
				  r++;
			  }
			  //varre a matriz no lado direito topo de cima para a baixo
			  for(int i = 0; i < down-top; i++) {
				  sortedArray[r] = matrix[top + i][down];
				  r++;
			  }
			  top++;
			  //varre a matriz na base da direita para a esquerda		 
			  for(int i = rigth; i >= left; i--) {
				  sortedArray[r] = matrix[rigth][i];
				  r++;
			  }
			  down--;
			  rigth--;
			  //varre a matriz na base no lado esquerdo de baixo para cima
			  for(int i = rigth; i >= top; i--) {
				  sortedArray[r] = matrix[i][left];
				  r++;
			  }
			  left++;
		  }
		  return sortedArray;
	  });

	  executor.shutdown();
	  return result;
  };
}
