package common.bankarskiSistem.resources.implementation;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.DBNodeComposite;
import common.bankarskiSistem.resources.enums.AttributeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attribute extends DBNodeComposite {


    private AttributeType attributeType;
    private int length;
    private Attribute inRelationWith;

    public Attribute(String name, DBNode parent) {
        super(name, parent);
    }

    public Attribute(String name, DBNode parent, AttributeType attributeType, int length) {
        super(name, parent);
        this.attributeType = attributeType;
        this.length = length;
    }

    @Override
    public void addChild(DBNode child) {
        if (child != null && child instanceof AttributeConstraint){
            AttributeConstraint attributeConstraint = (AttributeConstraint) child;
            this.getChildren().add(attributeConstraint);
        }
    }


}

