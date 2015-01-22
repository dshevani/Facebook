package cubePairs;
import java.util.*;
public class FindCube {
	public List<List<String>> sameCubeSums(int range) {
		if (range <= 0)
			throw new IllegalArgumentException("range must be positive");
		List<List<String>> rst = new ArrayList<List<String>> ();
		PriorityQueue<CubePair> pq = new PriorityQueue<CubePair> ();
		for (int i = 1; i < range; i++) {
			pq.add(new CubePair(i, i + 1));
		}
		int prev = 0;
		int maxSize = 0;
		while (!pq.isEmpty()) {
			maxSize = Math.max(maxSize, pq.size());
			CubePair curr = pq.poll();
			if (pq.isEmpty())
				break;
			if (curr.hasEqualSum(pq.peek())) {
				addList(rst, curr, pq.peek());
				if (curr.getFirst() < pq.peek().getFirst())
					curr = pq.poll();
				else
					pq.poll();
			}
			if (curr.getFirst() <= prev)
				continue;
			for (int i = curr.getSecond() + 1; i <= range; i++) {
				CubePair tmp = new CubePair(curr.getFirst(), i);
				if (tmp.hasEqualSum(pq.peek())) {
					addList(rst, tmp, pq.peek());
				}
				else {
					pq.add(tmp);
				}
			}
			prev = curr.getFirst();
		}
		System.out.println("max queue size: " + maxSize);
		return rst;
	}
	private void addList(List<List<String>> rst, CubePair pair1, CubePair pair2) {
		List<String> pair = new ArrayList<String> ();
		pair.add(pair1.toString());
		pair.add(pair2.toString());
		rst.add(new ArrayList<String> (pair));
	}
	/*private CubePair contains(PriorityQueue<CubePair> q, CubePair curr) {
		for (CubePair cp : q) {
			if (curr.hasEqualSum(cp))
				return cp;
		}
		return null;
	}*/
	public List<List<String>> sameCubeSums2(int range) {
		if (range <= 0)
			throw new IllegalArgumentException("range must be positive");
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		List<List<String>> rst = new ArrayList<List<String>> ();
		for (int i = 1; i < range; i++) {
			for (int j = i + 1; j <= range; j++) {
				int cubeSum = (int)(Math.pow(i, 3) + Math.pow(j, 3));
				if (!map.containsKey(cubeSum)) {
					map.put(cubeSum, new ArrayList<String> ());
					map.get(cubeSum).add(String.valueOf(i) + "; " + String.valueOf(j));
				}
				else 
					map.get(cubeSum).add(String.valueOf(i) + "; " + String.valueOf(j));
			}
		}
		for (List<String> pairs : map.values()) {
			if (pairs.size() > 1) 
				rst.add(pairs);
		}
		return rst;
	}
	
	

}
