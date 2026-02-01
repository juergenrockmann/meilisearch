package com.rockmann.meilisearch.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Index;
import com.meilisearch.sdk.model.SearchResultPaginated;
import com.rockmann.meilisearch.dto.PaginatedResult;
import com.rockmann.meilisearch.dto.PropertyDTO;
import com.rockmann.meilisearch.dto.request.SearchCriteria;
import com.rockmann.meilisearch.holders.Indices;
import com.rockmann.meilisearch.repository.queries.PropertyQueryBuilder;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PropertyRepository {

    final Client meilisearchClient;

    final ObjectMapper objectMapper;

    public PaginatedResult<PropertyDTO> search(SearchCriteria criteria, int page, int size) {

        Index propertiesIndex = meilisearchClient.index(Indices.PRODUCTS);

        SearchResultPaginated response = (SearchResultPaginated) propertiesIndex.search(
                PropertyQueryBuilder.buildQuery(criteria, page, size)
        );

        List<PropertyDTO> properties = new ArrayList<>();

        response.getHits().forEach(hit -> {
            PropertyDTO propertyDTO = objectMapper.convertValue(hit, PropertyDTO.class);
            properties.add(propertyDTO);
        });

        return PaginatedResult.of(page, size, response.getTotalHits(), response.getTotalPages(), properties);
    }
}