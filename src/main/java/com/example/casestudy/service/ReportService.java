package com.example.casestudy.service;

import org.springframework.core.io.InputStreamResource;

import java.util.concurrent.CompletableFuture;

public interface ReportService {

    public CompletableFuture<InputStreamResource> generateExcelFile();
}
