import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static List<Integer> breadthFirstSearch(int[][] matrix, int start, int goal) {
		int matrixColumn = matrix[0].length;
		// breadth first search
		Queue<Integer> OPEN = new LinkedList<>();
		// depth first search
		// Stack<Integer> OPEN = new Stack<>();
		List<Integer> CLOSED = new ArrayList<Integer>();
		Map<Integer, Integer> childParents = new HashMap<Integer, Integer>();
		
		OPEN.add(start);
		
		while(!OPEN.isEmpty()) {
			
			int n = OPEN.poll();
			// int n = OPEN.pop();
			List<Integer> child = new ArrayList<Integer>();
			for(int i = 0; i < matrixColumn; i++) {
				if(matrix[n][i] == 1 && i != n && !CLOSED.contains(i)) {
					childParents.put(i, n);
					child.add(i);
				}	
			}
			
			for(int i : child) {
				if (i == goal) {
					LinkedList<Integer> res = new LinkedList<Integer>();
					res.add(i);
					while(i != start) {
						i = childParents.get(i);
						res.add(i);
					}
					Collections.reverse(res);
					return res;
				} else {
					if(!CLOSED.contains(i))
						OPEN.add(i);
				}
			}
			CLOSED.add(n);
		}
		
		return null;
				
	}
	
	
	public static void main(String[] args) throws IOException {
		
		String fileContent = "";
		String filePath = "C:\\Users\\IT Supporter\\eclipse-workspace\\TimKiem\\src\\matrix.txt";
		
		// Read file to a String
		 try {
		      File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		         fileContent += myReader.nextLine().trim();
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 
		 // split string into separate row
		 String[] matrix = fileContent.split("},");
		 for(int i = 0; i < matrix.length; i++) {
			 matrix[i] = matrix[i].substring(1);
		 }
		 matrix[matrix.length - 1] = matrix[matrix.length - 1].substring(0, matrix[matrix.length - 1].length() - 1);
		 
		 
		 // count matrix's row and column
		 int rows = matrix.length;
		 int columns = matrix[0].split(", ").length;
		 
		 
		 int[][] matrixx = new int[rows][columns];
		 
		 
		 // convert string into a two dimensional array
		 for(int i = 0; i < rows; i++) {
			 String[] str = matrix[i].split(", ");
			 for(int j = 0; j < columns; j++) {
				 matrixx[i][j] = Integer.valueOf(str[j]);
			 }
		 }
		 
		 // Call breadth first search or depth first search
		 for(int i = 0; i < 13; i++) 
			 System.out.println(breadthFirstSearch(matrixx, 0, i));
//		
//		int [][] 
//				matrix = {
//						
//				 //      0  1  2  3  4  5  6  7  8  9  10 11 12 13
//			            {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//			            {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//			            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//			            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//			            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//			            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//			            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//			            {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
//			            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//			            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
//			            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
//			            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
//			            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
//			            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//			};
//		
	}
}




