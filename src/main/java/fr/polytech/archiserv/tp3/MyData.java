package fr.polytech.archiserv.tp3;

public class MyData {
    int id;
    String string;
    long date;

    public MyData() {}

    public MyData(int id, String string) {
        this.id = id;
        this.string = string;
        this.date = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "id=" + id +
                ", string='" + string + '\'' +
                ", date=" + date +
                '}';
    }
}

