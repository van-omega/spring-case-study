package com.example.casestudy.controller;

import com.example.casestudy.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;



@RestController
@RequestMapping("/report")
public class ReportController {

    ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @GetMapping("/download-excel")
    public CompletableFuture<ResponseEntity<InputStreamResource>> downloadExcel() {
        return reportService.generateExcelFile().thenApply(resource -> ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource));
    }
}
