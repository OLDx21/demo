package com.example.demo.service;


import com.example.demo.data.CryproRepository;
import com.example.demo.model.CryptoClass;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CryptoService {

    @Autowired
    CryproRepository repository;

    /**
     * Task 1 and 2
     *
     *Method to use once at the first start of the server, to write data to the database
     **/
    @PostConstruct
    public void init() {
        List<CryptoClass> CryptoInfo = new ArrayList<>();
        FileInputStream flso = null;
        try {
            flso = new FileInputStream("D:\\crypto\\Crypto task .csv.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(flso);

            double unix;
            int tradecount;
            String symbol;
            Date date;
            double open, high, low, close, VolumeADA, VolumeUSDT;
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MMM-yyyy");


            for (int i = 2; i <= workbook.getSheetAt(0).getLastRowNum(); i++) {

                unix = workbook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue();
                date = formatter2.parse(workbook.getSheetAt(0).getRow(i).getCell(1).toString());
                symbol = workbook.getSheetAt(0).getRow(i).getCell(2).toString();
                open = workbook.getSheetAt(0).getRow(i).getCell(3).getNumericCellValue();
                high = workbook.getSheetAt(0).getRow(i).getCell(4).getNumericCellValue();
                low = workbook.getSheetAt(0).getRow(i).getCell(5).getNumericCellValue();
                close = workbook.getSheetAt(0).getRow(i).getCell(6).getNumericCellValue();
                VolumeADA = workbook.getSheetAt(0).getRow(i).getCell(7).getNumericCellValue();
                VolumeUSDT = workbook.getSheetAt(0).getRow(i).getCell(8).getNumericCellValue();
                tradecount = (int) workbook.getSheetAt(0).getRow(i).getCell(9).getNumericCellValue();

                CryptoInfo.add(new CryptoClass(unix, date, symbol, open, high, low, close, VolumeADA, VolumeUSDT, tradecount));

            }


            repository.saveAll(CryptoInfo);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (flso != null) {
                    flso.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Page<CryptoClass> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Task 5
     */
    public List<CryptoClass> getStatistics(int month, int year) {
        List<CryptoClass> allInfo = repository.findAll();
        List<CryptoClass> cryptoClassList = new ArrayList<>();

        for (int i = 0; i < allInfo.size(); i++) {
            if (allInfo.get(i).getDate().getMonth() == month && allInfo.get(i).getDate().getYear() == year) {
                cryptoClassList.add(allInfo.get(i));
            }
        }
        allInfo = null;
        return cryptoClassList;
    }

    /**
     * Task 4
     */
    public List<CryptoClass> findByMonth(Date firstdayofmonth, Date lastdayofmonth) {
        return repository.findByDateBetween(firstdayofmonth, lastdayofmonth);
    }
}
