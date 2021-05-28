import java.nio.file.*;
import java.nio.*;
import java.nio.charset.*;
import java.io.BufferedReader;
import java.io.IOException;

class Sup2{
    static Path path = null;
    static BufferedReader reader = null;
    static char[] memoryBuffer;

    Sup2(String s){
    	try{
			path = FileSystems.getDefault().getPath(s);
			reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			memoryBuffer = algorithm();
			Sup.algorithm(memoryBuffer);
    	} catch(IOException e){
    		System.out.println(e);
    	}
    }

    static int[] getOutput(){
    	return Sup.getOutput();
    }

    static char[] algorithm(){
    	try{
	    	int temp = -1;
	    	char temp2 = '\0';

	    	String tempArr = "";

	    	while((temp = reader.read()) != -1){
	    		if(temp >= 48 && temp <= 57){
	    			temp2 = (char)temp;
	    			tempArr = new String(tempArr + Character.toString(temp2));
	    		}
	    	}

	    	return tempArr.toCharArray();
    	} catch(IOException e){
    		System.out.println(e);
    	}
    	return null;
    }

}