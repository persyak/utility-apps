package org.ohorodnik.utilityapps.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ohorodnik.utilityapps.dto.MapPoint;

import java.util.EnumSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode // Class is a part of JSONB structure
@ToString
public class AddressDetails {

    private MapPoint mapPoint;

    private AddressStatus status = AddressStatus.UNKNOWN; // theat default as invalid

    private Set<CarType> access = EnumSet.of(CarType.MINIVAN, CarType.VAN, CarType.TRUCK);

    private Integer serviceTime;
}
