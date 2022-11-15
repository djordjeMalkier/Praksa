package common.bankarskiSistem.resources.implementation;

import common.bankarskiSistem.resources.DBNode;
import common.bankarskiSistem.resources.enums.ConstraintType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeConstraint extends DBNode {

    private ConstraintType constraintType;

    public AttributeConstraint(String name, DBNode parent, ConstraintType constraintType) {
        super(name, parent);
        this.constraintType = constraintType;
    }

}
