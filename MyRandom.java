import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

class MyRandom{


	public static int getRandomNumber(){
		Random rand = new Random();
		return rand.nextInt(100);
	}

	public static int getRandomNumber2(){
		Random rand = new Random();
		return (rand.nextInt(10) + 48);
	}

	public static char getRandomChar(){
		Random rand = new Random();
		return (char) (rand.nextInt(26) + 65);
	}

	public static void writeToFile(int x){
		try{
			FileWriter fw = new FileWriter(new File("input.txt"));
			for(int i = 0; i < x; i++){
				int temp = getRandomNumber();
				if(temp < 20 && temp >= 0){
					fw.write("\n");
				}else if(temp >= 20 && temp < 50){
					fw.write(" ");
				} else{
					fw.write(getRandomNumber2());
				}
			}
			fw.close();
		}catch(IOException e){
			System.out.println(e);
		}

	}

}