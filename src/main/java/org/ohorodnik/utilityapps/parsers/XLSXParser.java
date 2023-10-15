package org.ohorodnik.utilityapps.parsers;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.ohorodnik.utilityapps.dto.TaskDto;
import org.ohorodnik.utilityapps.exception.XLSXParserException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class XLSXParser {

    @Value("${xslxparser.sheetIndex}")
    private int sheetIndex;

    @Value("${xslxparser.rowToStartCountFrom}")
    private int rowToStartCountFrom;

    @Value("${xslxparser.locationCellIndex}")
    private int locationCellIndex;

    @Value("${xslxparser.weightCellIndex}")
    private int weightCellIndex;

    public List<TaskDto> parseXlsxFile(MultipartFile file, String date) {

        if (file.isEmpty()) {
            return List.of();
        }
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            int rowCount = sheet.getLastRowNum();

            if (rowCount < rowToStartCountFrom + 1) {
                return List.of();
            }

            List<TaskDto> templateEntities = new ArrayList<>();

            for (int currentRow = rowToStartCountFrom; currentRow < rowCount; currentRow++) {
                Row row = sheet.getRow(currentRow);

                Cell locationCell = row.getCell(locationCellIndex);
                Cell weightCell = row.getCell(weightCellIndex);

                if (locationCell != null && weightCell != null) {
                    templateEntities.add(
                            createTaskDto(
                                    locationCell.getStringCellValue(),
                                    weightCell.getNumericCellValue(),
                                    date)
                    );
                }
            }

            return templateEntities;
        } catch (RuntimeException | IOException e) {
            log.error("Error occurred while parsing xlsx file", e.getCause());
            throw new XLSXParserException("Error occurred while parsing xlsx file", e);
        }
    }

    private TaskDto createTaskDto(String originAddress, Double weight, String date) {
        TaskDto task = new TaskDto();
        task.setDescription(originAddress);
        task.setExecutionDate(LocalDate.parse(date));
        task.setDeliveryWeight(weight);
        return task;
    }
}
