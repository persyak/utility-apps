package org.ohorodnik.utilityapps.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.ohorodnik.utilityapps.entity.AddressDetails;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TaskDto {

    private int id;
    private String description;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate executionDate;
    private AddressDetails addressDetails;
    private CarDto car;
    private CarDto requestedCar;

    // Routing part
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime deliveryStart;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime deliveryFinish;
    private boolean frozen;
    private double deliveryWeight;
    private double pickupWeight;
    private boolean dropped;

    private Long routePointId;
}
