package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestEmpty()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { };
    assertArrayEquals(result, expected);
  }
  
  @Test
  public void ScreenLockinPatternTest1X1()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 7 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 7 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest2X2()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2}, { 8, 9}};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 9, 8 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void ScreenLockinPatternTest3X3()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  public void ScreenLockinPatternTest10X10()
	      throws InterruptedException, ExecutionException, TimeoutException {
	    int[][] matrix = { {8, 3, 5, 6, 7, 2, 5, 1, 4, 4}, {8, 1, 4, 4, 9, 3, 5, 5, 3, 7},
	    				 {1, 6, 2, 4, 6, 1, 3, 8, 3, 6}, {9, 7, 2, 3, 9, 8, 8, 1, 5, 1}, 
	    				 {3, 7, 6, 7, 6, 4, 1, 2, 3, 1}, {1, 5, 4, 9, 4, 9, 8, 4, 8, 2}, 
	    				 {2, 5, 9, 6, 3, 9, 9, 6, 5, 2}, {3, 9, 1, 1, 3, 2, 8, 5, 2, 5}, 
	    				 {9, 8, 2, 6, 1, 2, 9, 6, 4, 8}, {8, 8, 9, 8, 1, 6, 3, 6, 4, 8} };
	    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
	    int[] result = count.get(10, TimeUnit.SECONDS);
	    int[] expected = { 8, 3, 5, 6, 7, 2, 5, 1, 4, 4, 
	    		7, 6, 1, 1, 2, 2, 5, 8, 8, 4, 6, 3, 6, 1, 
	    		8, 9, 8, 8, 9, 3, 2, 1, 3, 9, 1, 8, 1, 4, 
	    		4, 9, 3, 5, 5, 3, 3, 5, 3, 8, 5, 2, 4, 6, 
	    		9, 2, 1, 6, 2, 8, 9, 5, 5, 7, 7, 6, 2, 4, 
	    		6, 1, 3, 8, 1, 2, 4, 6, 5, 8, 2, 3, 1, 1, 
	    		9, 4, 6, 2, 3, 9, 8, 8, 1, 8, 9, 9, 3, 6, 9, 7, 6, 4, 9, 4 };
	    assertArrayEquals(result, expected);
	  }

}