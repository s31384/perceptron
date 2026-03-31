
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Iris> trainingSet = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("iris.txt"))){
            String line = br.readLine();
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                double sepalLength = Double.parseDouble(tokens[0]);
                double sepalWidth = Double.parseDouble(tokens[1]);
                double petalLength = Double.parseDouble(tokens[2]);
                double petalWidth = Double.parseDouble(tokens[3]);
                String type = tokens[4];
                Iris iris = new Iris(sepalLength, sepalWidth, petalLength, petalWidth, type);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}