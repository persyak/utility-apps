package org.ohorodnik.utilityapps.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapPoint {

    private String address; // Geocoded address
    private double latitude;
    private double longitude;
}
