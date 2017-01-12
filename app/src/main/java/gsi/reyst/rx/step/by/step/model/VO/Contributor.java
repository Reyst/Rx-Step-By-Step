package gsi.reyst.rx.step.by.step.model.VO;

import java.io.Serializable;

public class Contributor implements Serializable {

    private String name;

    public Contributor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
