package main.itrade.data.dtos.limit;

/**
 * Created by Tanat on 4/8/2016.
 */
public class SaveLimitDTO {

    private double creditLimit;
    private double lc;
    private double tr;
    private double be;
    private double sg;
    private double pk;

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getLc() {
        return lc;
    }

    public void setLc(double lc) {
        this.lc = lc;
    }

    public double getTr() {
        return tr;
    }

    public void setTr(double tr) {
        this.tr = tr;
    }

    public double getBe() {
        return be;
    }

    public void setBe(double be) {
        this.be = be;
    }

    public double getSg() {
        return sg;
    }

    public void setSg(double sg) {
        this.sg = sg;
    }

    public double getPk() {
        return pk;
    }

    public void setPk(double pk) {
        this.pk = pk;
    }
}
