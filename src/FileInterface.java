import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileInterface {

	public static void generatePerformanceChart(ArrayList<ArrayList<Float>> performanceChart, ArrayList<Integer> numberOfCenters, String nameFile) throws FileNotFoundException, IOException {
		File fileToWrite = new File("./resources/" + nameFile);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileToWrite), "UTF-8"));
		
		String csv = "";
		for (int i = 0; i < numberOfCenters.size(); i++) {
			csv += numberOfCenters.get(i) + ";\n";
			for (int j = 0; j < performanceChart.get(i).size(); j+=2) {
						csv += Math.round(performanceChart.get(i).get(j)) + ";"
								+ performanceChart.get(i).get(j+1) + "\n";
			}
			bufferedWriter.write(csv);
			csv = "";
		}
		
		bufferedWriter.close();
	}
	
}
