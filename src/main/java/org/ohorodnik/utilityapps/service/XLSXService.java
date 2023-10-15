package org.ohorodnik.utilityapps.service;

import org.ohorodnik.utilityapps.dto.TaskDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface XLSXService {

    List<TaskDto> getTemplateInfo(MultipartFile file, String date);
}
