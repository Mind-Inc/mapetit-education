package com.mindinc.edu.rest.controller;

import com.mindinc.edu.integration.service.OnSearchService;
import com.mindinc.edu.rest.beckn.model.search.SearchRequest;
import com.mindinc.edu.rest.beckn.model.response.Response;
import com.mindinc.edu.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/v1/search")
public class SearchController {

    private final OnSearchService onSearchService;

    @Autowired
    public SearchController(OnSearchService onSearchService) {
        this.onSearchService = onSearchService;
    }

    @PostMapping
    public Response search(@RequestBody SearchRequest body) {
        log.info("Received search request {}", body);
        CompletableFuture.runAsync(() -> {
            try {
                this.onSearchService.execute(body);
            } catch (Exception e) {
                log.error("error while sending on_search reply", e);
            }
        });

        return ResponseBuilder.buildResponseEntity(body.getContext());
    }

}
