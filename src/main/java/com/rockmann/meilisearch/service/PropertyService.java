package com.rockmann.meilisearch.service;

import com.rockmann.meilisearch.dto.PaginatedResult;
import com.rockmann.meilisearch.dto.PropertyDTO;
import com.rockmann.meilisearch.dto.request.SearchCriteria;

public interface PropertyService {

    PaginatedResult<PropertyDTO> getProperties(SearchCriteria criteria, int page, int size);

}
