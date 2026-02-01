package com.rockmann.meilisearch.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchCriteria {
    private String query; // A keyword typed by the user
    private String type; // Property type
    private Float[] location; // Geo Point [lat, lng]
    private Float radius; // the search radius from the specified location
    private int minRooms; // Minimum number of rooms
    private int maxRooms; // Maximum number of rooms
    private int minArea; // Minimum area
    private int maxArea; // Maximum area
    private int minPrice; // Minimum price
    private int maxPrice; // Maximum price
    private Float[][] geoBounds; // Bounds on the map [ [lat, lng], [lat, lng] ] (North East coords, South West Coords)
}
