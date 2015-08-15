package facebookCoding;
//import java.util.*;
public class ProductNoDivision {
	public static int[] product(int[] A){
	    if (A == null || A.length == 0)
	        return A;
	    int rst[] = new int[A.length];
	    rst[0] = 1;
	    //Arrays.fill(rst, 1);
	    int product = A[0];
	    for (int i = 1; i < A.length; i++){
	        rst[i] = product;
	        product *= A[i];
	    }
	    
	    product = A[A.length - 1];
	    for (int i = A.length - 2; i >= 0; i--){
	        rst[i] *= product;
	        product *= A[i];
	    }
	    return rst; 
	}

	public static void main(String[] args) {
		int[] A = {1, 3, 4, 5};
		for (int i : product(A)){
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
