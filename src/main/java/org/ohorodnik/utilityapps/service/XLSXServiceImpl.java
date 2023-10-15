package org.ohorodnik.utilityapps.service;

import lombok.RequiredArgsConstructor;
import org.ohorodnik.utilityapps.dto.TaskDto;
import org.ohorodnik.utilityapps.parsers.XLSXParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XLSXServiceImpl implements XLSXService{

    private final XLSXParser xlsxParser;
    @Override
    public List<TaskDto> getTemplateInfo(MultipartFile file, String date) {
        return xlsxParser.parseXlsxFile(file, date);
    }
}
