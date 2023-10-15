package org.ohorodnik.utilityapps.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.ohorodnik.utilityapps.entity.CarAssignmentType;
import org.ohorodnik.utilityapps.entity.CarType;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CarDto {
    private int id;
    private String name;
    private String licencePlate;
    private UserDto driver;
    private int weightCapacity;
    private Boolean cooler;
    private Boolean available;
    private int travelCost;
    private String vinCode;
    private String productionYear;
    private Double carLength;
    private Double carWidth;
    private Double carHeight;
    private Double carWeight;
    private CarType carType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime shiftStartTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime shiftEndTime;

    private CarAssignmentType carAssignmentType;
}
