package petshop.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class 밤12시 extends AbstractEvent {

    private Long id;

    public 밤12시() {
        super();
    }
}
//>>> DDD / Domain Event
