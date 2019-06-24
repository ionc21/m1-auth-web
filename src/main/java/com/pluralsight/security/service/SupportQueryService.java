package com.pluralsight.security.service;

import com.pluralsight.security.model.SupportQueryDto;

import java.util.List;

public interface SupportQueryService {

    List<SupportQueryDto> getSupportQueriesForUser();

    SupportQueryDto getSupportQueryById(String queryId);

    List<SupportQueryDto> getSupportQueriesForAllUsers();

}
