package gsi.reyst.rx.step.by.step.model.VO;

import java.io.Serializable;

public class Branch implements Serializable {

    private String name;

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
