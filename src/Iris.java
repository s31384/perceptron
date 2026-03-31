public class Iris {
    private double[] vector;
    private String type;


    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String type) {
        this.vector = new double[] {sepalLength, sepalWidth, petalLength, petalWidth};
        this.type = type;
    }
    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth) {
        this.vector = new double[] {sepalLength, sepalWidth, petalLength, petalWidth};
        this.type = "";
    }



    public String getType() {
        return type;
    }

    public double[] getVector() {
        return vector;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return vector[0]+","+vector[1]+","+vector[2]+","+vector[3]+","+type;
    }
}
