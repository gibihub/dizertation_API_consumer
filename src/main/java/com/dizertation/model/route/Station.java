package com.dizertation.model.route;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Station {

    private String id;
    private String name;
    private double lat;
    private double lon;
}
