package common.bankarskiSistem.resources.implementation;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.DBNodeComposite;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Entity extends DBNodeComposite {

    public Entity(String name, DBNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(DBNode child) {
        if (child != null && child instanceof Attribute){
            Attribute attribute = (Attribute) child;
            this.getChildren().add(attribute);
        }

    }
}
