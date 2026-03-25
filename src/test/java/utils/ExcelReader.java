package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelReader {

    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";

    // Entry method (dynamic test name)
    public static Object[][] getData(String sheetName, Method method) {
        List<Map<String, String>> list = getDataAsMap(sheetName, method.getName());

        Object[][] data = new Object[list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);
        }

        return data;
    }

    // Core logic: returns List of Map (columnName -> value)
    public static List<Map<String, String>> getDataAsMap(String sheetName, String testName) {

        List<Map<String, String>> testDataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new RuntimeException("Header row missing");
            }

            int colCount = headerRow.getPhysicalNumberOfCells();

            // Read column headers
            List<String> headers = new ArrayList<>();
            for (int i = 0; i < colCount; i++) {
                headers.add(headerRow.getCell(i).toString());
            }

            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell testCell = row.getCell(0);

                if (testCell != null &&
                        testCell.toString().equalsIgnoreCase(testName)) {

                    Map<String, String> rowData = new HashMap<>();

                    for (int j = 0; j < colCount; j++) {
                        Cell cell = row.getCell(j);

                        String key = headers.get(j);
                        String value = (cell == null) ? "" : cell.toString();

                        rowData.put(key, value);
                    }

                    testDataList.add(rowData);
                }
            }

            return testDataList;

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file", e);
        }
    }
}