package gsi.reyst.rx.step.by.step.model.VO;

import java.io.Serializable;

public class Repository implements Serializable {

    private int id;

    private String name;

    private String owner;

    public Repository(int id, String name, String owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}
