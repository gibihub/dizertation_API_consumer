package com.dizertation.model.route;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Direction {

    private String id;
    private String title;
    private List<Station> stations;
}
