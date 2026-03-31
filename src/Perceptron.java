public class Perceptron {
    double[] scale;
    double bias;
    double alpha;
    double beta;
    public Perceptron(double[] scale, double bias, double alpha, double beta ) {
        this.scale = scale;
        this.bias = bias;
        this.alpha = alpha;
        this.beta = beta;
    }

    public int classify(double[] vector){
        if(vector.length != scale.length){
            throw new IllegalArgumentException();
        }
        double net = 0;
        for(int i = 0; i < vector.length ; i++){
            net += vector[i] * scale[i];
        }
        if (net >= bias){
            return 1;
        }else return 0;

    }

    public void learn(double[] vector, int d){
        int y = classify(vector);
        if(y!=d){
            for(int i = 0; i < vector.length; i++){
                scale[i] += vector[i] * (d - y) * alpha;
            }
            bias -= (d-y)*beta;
        }
    }

}
