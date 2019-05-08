package randomTests;

public class Testing {

	public static void main(String[] args) {
		String[] line = new String[10];
		line[0] = "23";
        line[1] = null;
        line[2] = "56";
        line[3] = "34";
        line[4] = "78";
        line[5] = "23";
        line[6] = null; 
        line[7] = "56"; 
        line[8] = "34"; 
        line[9] = "78";
		
		for (int i = 0; i < line.length; i++){
            if (line[i] == null){
                for (int j = i + 1; j < line.length; j++){
                    line[j-1] = line[j];
                }
                line[line.length-1] = null;
                break;
            }
        }
		
		for (int i = 0; i < line.length; i++){
            if (line[i] == null){
                for (int j = i + 1; j < line.length; j++){
                    line[j-1] = line[j];
                }
                line[line.length-1] = null;
                break;
            }
        }
		
		for (int j=0; j<line.length; j++){
            System.out.println(line[j]);
        }
	}

}
