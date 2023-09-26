package com.mindinc.edu.integration.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindinc.edu.rest.beckn.model.common.*;
import com.mindinc.edu.rest.beckn.model.search.SearchMessage;
import com.mindinc.edu.rest.beckn.model.search.SearchRequest;
import com.mindinc.edu.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class OnSearchService {

    private final RestService restService;
    private final JobProvider jobProvider;
    private final CompanyProfileProvider companyProfileProvider;

    @Autowired
    public OnSearchService(
            JobProvider jobProvider,
            CompanyProfileProvider companyProfileProvider,
            RestService restService) {
        this.restService = restService;
        this.jobProvider = jobProvider;
        this.companyProfileProvider = companyProfileProvider;
    }

    public void execute(SearchRequest searchRequest) throws JsonProcessingException {
        Objects.requireNonNull(searchRequest);

        var companyName = Optional.of(searchRequest)
                .map(SearchRequest::getMessage)
                .map(SearchMessage::getIntent)
                .map(Intent::getProvider)
                .map(Provider::getDescriptor)
                .map(Descriptor::getName)
                .orElse("NOT APPLICABLE");

        var jobTitle = Optional.of(searchRequest)
                .map(SearchRequest::getMessage)
                .map(SearchMessage::getIntent)
                .map(Intent::getItem)
                .map(Item::getDescriptor)
                .map(Descriptor::getName)
                .orElse("NOT APPLICABLE");

        var skills = Optional.of(searchRequest)
                .map(SearchRequest::getMessage)
                .map(SearchMessage::getIntent)
                .map(Intent::getItem)
                .map(Item::getTags)
                .map(tags -> tags.stream()
                        .map(TagGroup::getList)
                        .flatMap(List::stream)
                        .map(Tag::getValue)
                        .toList()
                )
                .orElse(List.of());

        var jobs = jobProvider.getJobs(jobTitle, jobTitle, skills, companyName);
        var context = ResponseBuilder.buildContext(searchRequest.getContext(), ContextAction.ON_SEARCH.value());
        var catalog = buildCatalog(jobs);
        var requestBody = OnSearchRequest.builder()
                .context(context)
                .message(OnSearchMessage.builder()
                        .catalog(catalog)
                        .build())
                .build();
        var url = context.getBapUri().concat(ContextAction.ON_SEARCH.value());

        log.info("Sending request to BAP: {}", url);

        restService.post(requestBody, url);
    }

    private Catalog buildCatalog(Set<Job> jobs) {
        Catalog catalog = new Catalog();
        catalog.setBppDescriptor(new Descriptor("Mapetit jobs"));
        catalog.setBppProviders(jobs.stream().map(this::jobToProvider).toList());

        return catalog;
    }

    private Provider jobToProvider(Job job) {

        var companyProfile = companyProfileProvider.getCompanyProfile(job.getCompanyId()).orElse(null);
        assert companyProfile != null;

        Provider provider = new Provider();
        provider.setId(String.valueOf(job.getCompanyId()));
        provider.setDescriptor(new Descriptor(companyProfile.getName()));

        provider.setLocations(
                List.of(
                        Location.builder()
                                .id(UUID.randomUUID().toString())
                                .address("Golden gates 10")
                                .city(City.builder().name("Bangalore").build())
                                .state(State.builder().name("Karnataka").build())
                                .country(Country.builder().name("India").build())
                                .build()
                )
        );

        provider.setItems(
                List.of(
                        Item.builder()
                                .id(String.valueOf(job.getJobId()))
                                .descriptor(Descriptor.builder()
                                        .name(job.getTitle())
                                        .longDesc(job.getDescription())
                                        .build())
                                .locationIds(List.of("1"))
                                .build()
                )
        );

        return provider;
    }
}
