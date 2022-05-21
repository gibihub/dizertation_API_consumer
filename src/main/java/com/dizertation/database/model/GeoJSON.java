package com.dizertation.database.model;

import com.dizertation.model.geoJson.Geometry;
import com.dizertation.model.geoJson.Properties;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Document(collection = "GeoJSON")
public class GeoJSON {

    @Id
    private String id;

    private Double latitude;
    private Double longitude;
    private String name;
}
