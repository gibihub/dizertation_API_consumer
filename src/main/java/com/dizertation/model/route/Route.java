package com.dizertation.model.route;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Route {

    private String id;
    private String longName;

    private Extent extent;
    private Direction direction;
}
