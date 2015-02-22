package cubePairs;

import java.util.*;
public class FindCubeTester {

	public static void main(String[] args) {
		FindCube fc = new FindCube();
		long startTime = System.nanoTime();
		List<List<String>> rst = fc.sameCubeSums(100);
		System.out.println("Running time: " + ((System.nanoTime() - startTime) /1000) + "ms");
		for (List<String> pairs : rst) {
			for (String s : pairs) {
				System.out.print(s + " ");
			}
			System.out.println(" ");
		}
	}

}
