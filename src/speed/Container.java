package speed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Container {

    private List<Double> values;

    public Container() {
        values = new ArrayList<>();
    }

    public void add(double val) {
        values.add(val);
    }

    public void setToStart() {
        values = new ArrayList<>();
    }

    public Double min() {
        return Collections.min(values);
    }

    public Double max() {
        return Collections.max(values);
    }

    // единственное, что при очень больших данных может быть переполнение, надо про это помнить
    public Double mean() {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        double mean = sum/(double)values.size();
        return mean;
    }

    // тоже надо помнить про переполнение
    public Double integral() {
        if (values.size() > 1) {
            double integral = 0;
            for (int i = 1; i < values.size(); i++) {
                double dt = values.get(i) - values.get(i-1);
                integral += Math.abs(values.get(i))*dt;
            }
            return integral;
        } else {
            return null;
        }
    }

    // тоже надо помнить про переполнение
    public Double std() {
        if (values.size() > 0) {
            double sum=0;
            double mean = mean();
            for(int i=0;i<values.size();i++)
            {
                sum+=Math.pow((values.get(i)-mean),2);
            }
            double meanD=sum/(values.size()-1);
            double deviation=Math.sqrt(meanD);
            return deviation;
        } else {
            return null;
        }
    }

    public Iterator<Double> getValues() {
        return values.iterator();
    }

    public static void main(String[] args) {
        Container container = new Container();

        container.add(1.0);
//        container.add(1.5);
        container.add(2.0);
        container.add(2.5);

        double mean = container.mean();
        System.out.println(mean);
        System.out.println(container.min());
        System.out.println(container.max());
        System.out.println(container.integral());
        System.out.println(container.std());
    }
}


