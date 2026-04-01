
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Iris> trainingSet = new ArrayList<>();
        List<Iris> testSet = new ArrayList<>();

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
                if(i % 5 == 0){
                    trainingSet.add(iris);
                }else testSet.add(iris);
                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Collections.shuffle(trainingSet);
        Collections.shuffle(testSet);


        Perceptron perceptron = new Perceptron(new double[]{0,0,0,0} , 0.5, 0.01, 0.01 );
        for(int i = 0; i < 5; i++){
        for(Iris iris: trainingSet){
            if(iris.getType().equals("Iris-setosa")){
                perceptron.learn(iris.getVector(), 1);
            }else {perceptron.learn(iris.getVector(), 0);}
        }

        }

        int rightAnswers = 0;

        for(Iris iris: testSet){
            int setosa = 0;
            if(iris.getType().equals("Iris-setosa")){
                setosa =1 ;
            }

            int classifed = perceptron.classify(iris.getVector());
            if(setosa == classifed){
                rightAnswers++;
            }

            System.out.println(iris.getType() + " " + classifed );
        }
        double accuracy = (double) rightAnswers /testSet.size() * 100;

        System.out.println("Accuracy: " + accuracy);

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String[] tokens = s.split(",");

        Iris iris = new Iris(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        perceptron.classify(iris.getVector());

        System.out.println(perceptron.classify(iris.getVector()));
    }



}