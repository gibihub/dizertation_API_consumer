package com.dizertation.model.route;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Extent {

    private double minLat;
    private double maxLat;

    private double minLon;
    private double maxLon;
}
