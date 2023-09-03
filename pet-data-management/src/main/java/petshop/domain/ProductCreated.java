package petshop.domain;

import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
@ToString
public class ProductCreated extends AbstractEvent {

    private String name;
    private Object price;
    private String description;
}
