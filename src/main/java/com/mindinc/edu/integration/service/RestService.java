package com.mindinc.edu.integration.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindinc.edu.rest.builder.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RestService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public RestService() {
        this.restTemplate = new RestTemplate();
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        restTemplate.getMessageConverters().stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .map(converter -> (MappingJackson2HttpMessageConverter) converter)
                .forEach(converter -> converter.setObjectMapper(objectMapper));
    }

    public String post(Object requestBody, String url) throws JsonProcessingException {
        String stringBody = objectMapper.writeValueAsString(requestBody);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION,  ResponseBuilder.generateAuthHeader(stringBody));

        HttpEntity<Object> request = new HttpEntity<>(stringBody, headers);
        var response = restTemplate.postForObject(url, request, String.class);

        log.info("BAP response {}", response);

        return response;
    }
}
