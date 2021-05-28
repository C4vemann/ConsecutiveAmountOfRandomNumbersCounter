class Sup{
	static char current = '\0';
	static int currentSize = 0;
	static int[] output = new int[10];

	static void algorithm(char[] buff){
		int p1 = 0;
		int p2 = 0;

		if(buff.length == 0){
			return;
		}
		while(p1 != buff.length && p2 != buff.length){
			if(compareValue(buff[p1], buff[p2])){
				current = buff[p1];
				currentSize++;
				p2++;
			}else{
				if(compareLength(currentSize,output[Character.getNumericValue(current)])){
					output[Character.getNumericValue(current)] = currentSize;
				}
				p1 = p2;
				current = buff[p1];
				currentSize = 0;
			}
		}
		if(compareLength(currentSize,output[Character.getNumericValue(current)])){
			output[Character.getNumericValue(current)] = currentSize;
		}
	}

	static boolean compareValue(char c1, char c2){
		if(c1 == c2){
			return true;
		} else{
			return false;
		}
	}
	static boolean compareLength(int x1, int x2){
		if(x1 > x2){
			return true;
		}
		else{
			return false;
		}
	}
	static int[] getOutput(){
		return output;
	}
	static void printOutput(){
		System.out.print("[");
		for(int i : output){
			System.out.print(i + ", ");
		}
		System.out.println("]");
	}
	static void printBuff(char[] membuf){
		System.out.print("[");
		for(char c : membuf){
			System.out.print(c + ", ");
		}
		System.out.println("]");
	}
}
