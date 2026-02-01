package com.rockmann.meilisearch.web;

import com.rockmann.meilisearch.dto.PaginatedResult;
import com.rockmann.meilisearch.dto.PropertyDTO;
import com.rockmann.meilisearch.dto.request.SearchCriteria;
import com.rockmann.meilisearch.holders.ApiPaths;
import com.rockmann.meilisearch.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiPaths.PROPERTIES)
@RequiredArgsConstructor
public class PropertyController {

    final PropertyService propertyService;

    @GetMapping
    public PaginatedResult<PropertyDTO> getProperties(SearchCriteria criteria, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int size) {
        return propertyService.getProperties(criteria, page, size);
    }
}