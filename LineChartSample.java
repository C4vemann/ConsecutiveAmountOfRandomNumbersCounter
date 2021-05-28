import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 import java.util.Random;
 
public class LineChartSample extends Application {
    static int[] nums;

    static int getLargestValue(int[] x){
        int largest = -1;

        for(int i = 0; i < x.length; i++){
            if(x[i] > largest){
                largest = x[i];
            }
        }

        return largest;
    }

    
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number Line");
        yAxis.setLabel("Amount of Consecutive Numbers");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Amount Of Consecutive Numbers Given By Java's Random Number Generator");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        for(int i = 0; i < nums.length; i++){
            series.getData().add(new XYChart.Data(i, nums[i]));
        }
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(-1);
        xAxis.setUpperBound(10);
        xAxis.setTickUnit(1);
        xAxis.setMinorTickVisible(false);

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(-1);
        yAxis.setUpperBound(getLargestValue(nums)+1);
        yAxis.setTickUnit(1);
        yAxis.setMinorTickVisible(false);
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args){
        MyRandom.writeToFile(Integer.parseInt(args[0]));
        Sup2 a = new Sup2("./input.txt");
        nums = a.getOutput();
        launch(args);
    }
}