package com.rockmann.meilisearch.service.impl;

import com.rockmann.meilisearch.dto.PaginatedResult;
import com.rockmann.meilisearch.dto.PropertyDTO;
import com.rockmann.meilisearch.dto.request.SearchCriteria;
import com.rockmann.meilisearch.repository.PropertyRepository;
import com.rockmann.meilisearch.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    final PropertyRepository propertyRepository;

    @Override
    public PaginatedResult<PropertyDTO> getProperties(SearchCriteria criteria, int page, int size) {
        return propertyRepository.search(criteria, page, size);
    }

}