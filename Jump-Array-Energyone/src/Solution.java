import java.util.*;
/**
 * 
 * @author JaisudhaJeyaraman
 *
 */
public class Solution {
	List<String> inputnm = null;
	List<String> arrElements = null;
	int testcase = 0;
	
	public static void main(String[] args) {
		try {
			Solution inst = new Solution();
			Scanner input = new Scanner(System.in);
			List<String> lines = new ArrayList<String>();
			String lineNew;
			while (input.hasNextLine()) {
				lineNew = input.nextLine();
				if (lineNew.isEmpty()) {
					break;
				}
				lines.add(lineNew);
			}
			inst.parseInput(lines);
			inst.jumpOnStepCount();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Prints yes or no based on the sept count and the rule
	 * Walk one step forward or backward,Make a jump of exactly length forward
	 * move from position x to x+1, x-1 or x+m if  
	 * (The new position contains 0/The new position is greater than n-1).
	 */
	private void jumpOnStepCount() {
		for (int i = 0; i < testcase; i++) {
			try {
				int[] nm = null;

				nm = new int[2];
				nm[0] = Integer.parseInt(inputnm.get(i).split(" ")[0]);
				nm[1] = Integer.parseInt(inputnm.get(i).split(" ")[1]);


				int[] value = null;
				int listCnt = 0;

				listCnt = arrElements.get(i).split(" ").length;
				value = new int[listCnt];

				for (int j = 0; j < listCnt; j++) {
					value[j] = Integer
							.parseInt(arrElements.get(i).split(" ")[j]);
				}

				int visitedIt = 0;
				int positivevisit=0;
				for (int k = 0; k < value.length;) {
					if (value[k] == 0) {
						if (value[k + nm[1]] == 0 && (k + nm[1] != positivevisit)) {
							positivevisit = k+nm[1];
							k = k + nm[1];
							continue;
						} else {
							if(value[k + 1] == 0 && k+1 != visitedIt) {
								k = k + 1;
								continue;
							} else {
								if(k!= 0 && value[k - 1] == 0 && (k - 1 != visitedIt)) {
									visitedIt = k;									
									k = k - 1;
									continue;
								} else {
									System.out.println("NO");
									break;
								}
							}
						}
					} else {
						System.out.println("NO");
						break;
					}
				}

			} catch (ArrayIndexOutOfBoundsException er) {
				System.out.println("YES");
			}
		}
	}	
	/**
	 * parst the given console input
	 * @param inpLines
	 * @throws Exception
	 */
	public void parseInput(List<String> inpLines) throws Exception {
		testcase = Integer.parseInt(inpLines.get(0));
		inputnm = new ArrayList<String>();
		arrElements = new ArrayList<String>();
		for (int i = 1; i < inpLines.size(); i++) {
			if (i % 2 == 0)
				arrElements.add(inpLines.get(i));
			else
				inputnm.add(inpLines.get(i));
		}
	}
}
