package com.example.casestudy.implementation;

import com.example.casestudy.entity.BookTrack;
import com.example.casestudy.repository.AuthorRepository;
import com.example.casestudy.repository.BookRepository;
import com.example.casestudy.repository.BookTrackRepository;
import com.example.casestudy.repository.PersonRepository;
import com.example.casestudy.service.ReportService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.example.casestudy.constants.AppConstants.*;

@Service
public class ReportServiceImpl implements ReportService {

    BookRepository bookRepository;
    AuthorRepository authorRepository;
    PersonRepository personRepository;
    BookTrackRepository bookTrackRepository;


    @Autowired
    public ReportServiceImpl(BookRepository bookRepository,
                             AuthorRepository authorRepository,
                             PersonRepository personRepository,
                             BookTrackRepository bookTrackRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.personRepository = personRepository;
        this.bookTrackRepository = bookTrackRepository;
    }

    @Async
    public CompletableFuture<InputStreamResource> generateExcelFile() {
        List<BookTrack> bookTrack = bookTrackRepository.findAll();
        byte[] excelContent = generateExcelContent(bookTrack);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(excelContent));

        return CompletableFuture.completedFuture(resource);
    }

    private byte[] generateExcelContent(List<BookTrack> bookTracks) {
        try {
            // Create a new Excel workbook
            Workbook workbook = new XSSFWorkbook();

            // Create a new sheet
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            //Create headers for each column
            String[] headers = {HDR_BOOK_TITLE, HDR_AUTHOR_NAME, HDR_BORROWED_BY, HDR_EXPECTED_RETURN_DT};
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerCellStyle);
            }

            // Write data to the sheet
            for (int i = 1; i < bookTracks.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(bookTracks.get(i).getBook().getTitle());
                dataRow.createCell(1).setCellValue(getAuthorName(bookTracks.get(i)));
                dataRow.createCell(2).setCellValue(bookTracks.get(i).getPerson().getName());
                dataRow.createCell(3).setCellValue(formatDate(bookTracks.get(i).getExpectedReturnDate()));
            }

            // Write the workbook content to a ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            workbook.close();

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getAuthorName(BookTrack bookTrack){
        return bookTrack.getBook().getAuthor().getFirstName() + " " + bookTrack.getBook().getAuthor().getLastName();
    }

    private String formatDate(LocalDate date){
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter).toString();
    }
}
