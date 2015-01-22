package cubePairs;


public class CubePair implements Comparable<CubePair> {
	//num1 will always be smaller than num2
	private int num1;
	private int num2;
	private int cubeSum;
	public CubePair(int a, int b) {
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		num1 = a;
		num2 = b;
		cubeSum = (int)(Math.pow(num1, 3) + Math.pow(num2, 3));
	}
	public boolean hasEqualSum(CubePair cp) {
		return cp.cubeSum == cubeSum;
	}
	public boolean equals(CubePair cp) {
		return num1 == cp.num1 && num2 == cp.num2;
	}
	public int getFirst() {
		return num1;
	}
	public int getSecond() {
		return num2;
	}
	public String toString() {
		return String.valueOf(num1) + ", " + String.valueOf(num2) + ";";
	}
	@Override
	public int compareTo(CubePair cp) {
		return cubeSum - cp.cubeSum;
	}
}
