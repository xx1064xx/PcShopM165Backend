package Program.Repository;

public class Schnittstelle {
    private String schnittstellenName;

    public Schnittstelle(String schnittstellenName) {
        this.schnittstellenName = schnittstellenName;
    }

    public String getSchnittstelle() {
        return schnittstellenName;
    }

    public void setSchnittstelle(String schnittstellenName) {
        this.schnittstellenName = schnittstellenName;
    }
}
