package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ProductCreated extends AbstractEvent {

    private String name;
    private Money price;
    private String description;

    public ProductCreated(Product aggregate) {
        super(aggregate);
    }

    public ProductCreated() {
        super();
    }
}
//>>> DDD / Domain Event
