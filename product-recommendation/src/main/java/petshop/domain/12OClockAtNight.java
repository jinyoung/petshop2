package petshop.domain;

import petshop.domain.*;
import petshop.infra.AbstractEvent;
import java.util.*;
import lombok.*;
import java.time.LocalDate;


//<<< DDD / Domain Event
@Data
@ToString
public class 12OClockAtNight extends AbstractEvent {

    private Long id;

    public 12OClockAtNight(){
        super();
    }
}
//>>> DDD / Domain Event