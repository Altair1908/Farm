package lesson7;

public class Farmer {
    protected int resFarmer; //текущее кол-во ресурсов фермера

    public Farmer(int resFarmer) {
        this.resFarmer = resFarmer;
    }
    public void setResFarmer(int resFarmer) {
        this.resFarmer = resFarmer;
    }
    public int getResFarmer() {
        return resFarmer;
    }


    public void spendRes(){
        this.resFarmer = this.resFarmer - 10;
    }
    public void collRes(){
        this.resFarmer = this.resFarmer + 10;
    }
    public void feedHome(){

    }
    public void shooWild(){

    }
}
