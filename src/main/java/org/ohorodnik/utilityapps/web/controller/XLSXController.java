package org.ohorodnik.utilityapps.web.controller;

import lombok.RequiredArgsConstructor;
import org.ohorodnik.utilityapps.dto.TaskDto;
import org.ohorodnik.utilityapps.service.XLSXService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/xlsx")
public class XLSXController {

    private final XLSXService xlsxService;

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDto> parseXlsxFile(@RequestPart("file") MultipartFile file,
                                       @RequestPart("date") String date) {
        return xlsxService.getTemplateInfo(file, date);
    }
}
