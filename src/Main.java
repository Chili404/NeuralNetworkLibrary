import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Data[] data = new Data[10000];
        NeuralNetwork nn = new NeuralNetwork(2,4,1);

        for(int i = 0; i < data.length; i++) {
            data[i] = new Data();
        }
        System.out.println("pre-train: " + testAll(nn, data) * 100 + "%");

        for(int i = 0; i < data.length; i++) {
            Data d = new Data();
            //System.out.printf("%s\n",d);
            nn.train(d.inputs, d.classification);
        }

        System.out.println("post-train: " + testAll(nn, data) * 100 + "%");



        /*Data[] data = new Data[1000];
        NeuralNetwork nn = new NeuralNetwork(2,2,1);

        Data d = new Data();
        d.inputs.print();
        System.out.println(d.classification[0]);
        Matrix clas = new Matrix(d.classification);
        System.out.println("-----------------------");
        nn.train(d.inputs, d.classification);*/


    }

    public static double testAll(NeuralNetwork nn, Data[] data) {
        int total = data.length;
        double correct = 0.0;
        for(int i = 0; i < data.length; i++) {
            Matrix output = nn.feedForward(new Matrix(data[i].inputs));
            if(output.data[0][0] > 0.6 && data[i].classification[0] == 1) {
                correct ++;
            }else if(output.data[0][0] < 0.4 && data[i].classification[0] == 0) {
                correct++;
            }

        }
        return correct / total;
    }
}
