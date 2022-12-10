package SubGames;
public class Sleep {
    private final String[] sleeps = {"Very Tired", "Tired", "Normal", "Rested", "Well Rested"};
    private int num;

    public Sleep(int num) {
        this.num = num;
    }

    public String checkString() {
        return sleeps[num/20];
    }

    public int getNum() {
        return num;
    }

    public void addSleep(int num) {
        if((this.num + num) > 99) {
            this.num = 99;
        } else {
            this.num += num;
        }
    }

    public void decreaseSleep(int num) {
        if((this.num - num) < 0) {
            this.num = 0;
        } else {
            this.num -= num;
        }
    }

}
