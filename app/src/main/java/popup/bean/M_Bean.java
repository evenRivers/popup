package popup.bean;

import java.io.Serializable;
import java.util.List;

public class M_Bean implements Serializable{
    private String title;
    private List<M_Data> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<M_Data> getList() {
        return list;
    }

    public void setList(List<M_Data> list) {
        this.list = list;
    }
}
