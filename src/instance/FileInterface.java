package instance;
import nuage.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileInterface {

	public static void generatePerformanceChart(
			ArrayList<ArrayList<Float>> performanceChart, 
			ArrayList<Integer> numberOfCenters, String nameFile)
					throws FileNotFoundException, IOException {
		File fileToWrite = new File("./resources/" + nameFile);
		BufferedWriter bufferedWriter = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(fileToWrite), "UTF-8"));
		
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
	
	public static void writeInstance(Instance instance, String nameFile) 
			throws FileNotFoundException,
				   UnsupportedEncodingException,
				   IOException {
		String file =   "1\n"
					  + "\n"
					  + instance.getSizeGraph() + "," + instance.getNbCentres()
					  + "\n";
		for (int i = 0; i < instance.getSizeGraph(); i++) {
			file += instance.getGraphe().get(i).getCoordX() + ","
						+ instance.getGraphe().get(i).getCoordY() + ",";
		}
		file = file.substring(0, file.length() - 1);
		
		File fileToWrite = new File("./instances/" + nameFile + ".txt");
		BufferedWriter bufferedWriter =
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(fileToWrite), "UTF-8"));
		bufferedWriter.write(file);
		bufferedWriter.close();
	}
	
	public static Instance readInstance(String file, int offset)
		throws UnsupportedEncodingException,
			   FileNotFoundException,
			   IOException {
		File fileToRead = new File("./instances/" + file + ".txt");
		BufferedReader bufferedReader =
				new BufferedReader(
						new InputStreamReader(
								new FileInputStream(fileToRead), "UTF-8"));
		int nbInstances = Integer.parseInt(bufferedReader.readLine());
		int nbPoints = 0;
		int nbCentres = 0;
		ArrayList<Point> points = new ArrayList<Point>();
		
		bufferedReader.readLine();
		String ligne = bufferedReader.readLine();
		String[] donnees = ligne.split(",");
		
		if (offset > nbInstances-1) {
			throw new IOException();
		} else {
			for (int i = 0; i < offset; i++) {
				bufferedReader.readLine();
				bufferedReader.readLine();
				donnees = bufferedReader.readLine().split(",");
			}
			nbPoints = Integer.parseInt(donnees[0]);
			nbCentres = Integer.parseInt(donnees[1]);
			
			String[] coordPoints = bufferedReader.readLine().split(",");
			for (int i = 0; i < coordPoints.length; i += 2) {
				points.add(new Point(
						Float.parseFloat(coordPoints[i]),
						Float.parseFloat(coordPoints[i+1])
						));
			}
		}
		Instance instance = new Instance(points ,nbCentres);
		return instance;
	}
	
}
