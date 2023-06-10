package com.premiumminds.internship.snail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SnailShellPattern implements ISnailShellPattern {
   /* @param matrix matrix of numbers to go through
   * @return order array of values that represent a snail shell pattern
   */

	public Future<int[]> getSnailShell(int[][] matrix) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<int[]> result = executor.submit(() -> {
			int length = matrix[0].length;

			if(matrix == null || length == 0) {
				int [] sortedArray = new int[0];
				return sortedArray;
			}
			
			if(matrix.length != length) {
				throw new IllegalArgumentException("A matriz deve ser uma matriz quadrada!!!");
			}
			
			if(length == 1) {
				int [] sortedArray = new int[1];
				sortedArray[0] = matrix[0][0];
				return sortedArray;
			}

		  final int arrayLength = length*length;
		  int [] sortedArray = new int[arrayLength];
		  int top = 0;
		  int left = 0;
		  int rigth = length-1;
		  int r = 0;
		  int i;
		  while(r < arrayLength) {
			  //varre a matriz no topo da esquerda para a direita
			  for( i = 0; i < rigth-top; i++) {
				  sortedArray[r] = matrix[left][left + i];
				  r++;
			  }
			  //varre a matriz no lado direito topo de cima para a baixo
			  for( i = 0; i < rigth-top; i++) {
				  sortedArray[r] = matrix[top + i][rigth];
				  r++;
			  }
			  top++;
			  //varre a matriz na base da direita para a esquerda		 
			  for( i = rigth; i >= left; i--) {
				  sortedArray[r] = matrix[rigth][i];
				  r++;
			  }
			  rigth--;
			  //varre a matriz na base no lado esquerdo de baixo para cima
			  for( i = rigth; i >= top; i--) {
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