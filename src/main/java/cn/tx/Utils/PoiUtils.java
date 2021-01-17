package cn.tx.Utils;

import cn.tx.model.Video;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * poi 操作excel
 */
public class PoiUtils {


    /**
     * 返回需要创建的Excel表格的类型
     * @param filePath
     * @return
     * @throws Exception
     */
    private Workbook getWriteWorkBoolType(String filePath) throws Exception{
        if (filePath.toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook();
        } else if (filePath.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook();
        } else {
            //抛出自定的业务异常
            throw new Exception("excel格式文件错误");
        }
    }
    /**
     * 打开路径名所在的excel表格的类型
     * @param filePath
     * @return
     * @throws Exception
     */
    private  Workbook getReadWorkBookType(String filePath) throws Exception {
        //xls-2003, xlsx-2007
        FileInputStream is = null;

        try {
            is = new FileInputStream(filePath);
            if ( filePath.toLowerCase().endsWith("xlsx") ) {
                return new XSSFWorkbook(is);
            } else if ( filePath.toLowerCase().endsWith("xls") ) {
                return new HSSFWorkbook(is);
            } else {
                //  抛出自定义的业务异常
                throw new Exception("excel格式文件错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            return null;
        }
    }

    /**
     * 读取excel表格中的内容
     * @param sourceFilePath
     * @return
     * @throws Exception
     */
    public List<String> readExcel(String sourceFilePath) throws Exception {
        Workbook workbook = null;

        try {
            workbook = getReadWorkBookType(sourceFilePath);
            List<String> contents = Lists.newArrayList();

            //获取第一个sheet 可以有多个sheet顺序读取
            Sheet sheet = workbook.getSheetAt(0);
            //第0行是表名，忽略，从第二行开始读取
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                Cell cell = row.getCell(0);
                contents.add(getCellStringVal(cell).trim());
            }
            return contents;
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }

    /**
     * 返回单元格的内容
     * @param cell
     * @return
     */
    private String getCellStringVal(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                return cell.getStringCellValue();
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            case ERROR:
                return String.valueOf(cell.getErrorCellValue());
            default:
                return null;
        }
    }

    /**
     *数据写道所在路径的excel表格中
     * @param targetFilePath
     * @param
     * @throws Exception
     */
    public  void  writeExcel(String targetFilePath,
                           List<Video> list) throws Exception {
        Workbook workbook = null;
        FileOutputStream fos = null;

        //返回所在文件的类型
        workbook = getWriteWorkBoolType(targetFilePath);

        //创建sheet
        Sheet sheet = workbook.createSheet("第一个sheet");
        //在sheet第一行写出表单的各个字段名
        int i = 0 ;
        Row titleRow = sheet.createRow(i++);
        titleRow.createCell(0).setCellValue("视频名称");
        titleRow.createCell(1).setCellValue("视频大小(MB)");
        titleRow.createCell(2).setCellValue("视时长(00:00:00)");

        //每行的单元格一次写入
        for (Video video : list) {
            //第1行作为表格列名，所以从第2行开始读取
            try {
                Row row = sheet.createRow(i++);
                Cell cellTenantId = row.createCell(0);
                cellTenantId.setCellValue(video.getName());
                Cell cellPoiId = row.createCell(1);
                cellPoiId.setCellValue(video.getSize());
                Cell cellTriID= row.createCell(2);
                cellTriID.setCellValue(video.getTime());
            } catch (Exception e) {
               e.printStackTrace();
            }
        }

        //写入到文件流中
        try {
            fos = new FileOutputStream(targetFilePath);
            workbook.write(fos);
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        } finally {
            IOUtils.closeQuietly(workbook);
        }
    }

}
