public class csvOutputBean {
    String type;
    double loss, target;
    Stats stats;

    public csvOutputBean(String type, double loss, double target, Stats stats){
        this.type = type;
        this.loss = loss;
        this.target = target;
        this.stats = stats;
    }
}
