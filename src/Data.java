import java.text.DecimalFormat;
import java.util.Random;

public class Data {
    Matrix inputs;
    double[] classification;

    public Data() {
        Random rand = new Random();

        double[] temp = new double[2];
        int sum = 0;
        for(int i = 0; i < 2; i++) {
            temp[i] = rand.nextInt(2);
            sum += temp[i];
        }
        inputs = new Matrix(temp);
        classification = new double[1];
        classification[0] = 1;
        if(sum != 1) {
            classification[0] = 0;
        }
    }
    @Override
    public String toString() {
        return String.format("[%f, %f] -- %f", inputs.data[0][0], inputs.data[1][0], classification[0]);
    }
}
