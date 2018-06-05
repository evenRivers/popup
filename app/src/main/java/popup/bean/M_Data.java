package popup.bean;

import java.io.Serializable;


/**
 * 自我数据
 */

public class M_Data implements Serializable {

    private int	id = -1			;
    private String name			;

    private boolean isChecked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}



