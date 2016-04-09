package main.itrade.data.dtos.limit;

/**
 * Created by Tanat on 4/8/2016.
 */
public class Commission {

    private String name;
    private double flat;
    private double rate;
    private double period;
    private double min;

    public Commission() {
    }

    public Commission(String name, double flat, double rate, double period, double min) {
        this.name = name;
        this.flat = flat;
        this.rate = rate;
        this.period = period;
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFlat() {
        return flat;
    }

    public void setFlat(double flat) {
        this.flat = flat;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        this.period = period;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}