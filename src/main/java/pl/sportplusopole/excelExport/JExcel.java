package pl.sportplusopole.excelExport;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.Number;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sportplusopole.customer.Customer;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class JExcel {
    public void exportToExcel() throws IOException, WriteException{
        WritableWorkbook workbook = null;
        try {
            // tworzę plik
        File file = new File(".");
        String path = file.getAbsolutePath();
        String fileLocation = path.substring(0,path.length()-1)+"temp.xls";

        workbook = Workbook.createWorkbook(new File(fileLocation));
        //tworzę nagłówki
            WritableSheet sheet = workbook.createSheet("Klienci", 0);

            WritableCellFormat headerFormat = new WritableCellFormat();
            WritableFont font = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD);
            headerFormat.setFont(font);
            headerFormat.setBackground(Colour.GRAY_25);
            headerFormat.setWrap(true);
            headerFormat.setAlignment(Alignment.CENTRE);


            Label headerLabel = new Label(0, 0, "Id klienta", headerFormat);
            sheet.setColumnView(0, 20);
            sheet.setRowView(0,360);
            sheet.addCell(headerLabel);

            headerLabel = new Label(1, 0, "Imię", headerFormat);
            sheet.setColumnView(1, 30);
            sheet.addCell(headerLabel);

            headerLabel = new Label(2, 0, "Nazwisko", headerFormat);
            sheet.setColumnView(2, 30);
            sheet.addCell(headerLabel);

            headerLabel = new Label(3, 0, "Nr karty", headerFormat);
            sheet.setColumnView(3, 20);
            sheet.addCell(headerLabel);

            headerLabel = new Label(4, 0, "Depozyt", headerFormat);
            sheet.setColumnView(4, 20);
            sheet.addCell(headerLabel);

            headerLabel = new Label(5, 0, "Email", headerFormat);
            sheet.setColumnView(5, 30);
            sheet.addCell(headerLabel);

            headerLabel = new Label(6, 0, "Telefon", headerFormat);
            sheet.setColumnView(6, 20);
            sheet.addCell(headerLabel);

            headerLabel = new Label(7, 0, "Karnet", headerFormat);
            sheet.setColumnView(7, 20);
            sheet.addCell(headerLabel);

            headerLabel = new Label(8, 0, "Cena", headerFormat);
            sheet.setColumnView(8, 30);
            sheet.addCell(headerLabel);

            headerLabel = new Label(9, 0, "Data zakupu", headerFormat);
            sheet.setColumnView(9, 20);
            sheet.addCell(headerLabel);

            headerLabel = new Label(10, 0, "Ważny do", headerFormat);
            sheet.setColumnView(10, 20);
            sheet.addCell(headerLabel);

            headerLabel = new Label(11, 0, "Imię trenera", headerFormat);
            sheet.setColumnView(11, 30);
            sheet.addCell(headerLabel);

            headerLabel = new Label(12, 0, "Nazwisko trenera", headerFormat);
            sheet.setColumnView(12, 30);
            sheet.addCell(headerLabel);

            headerLabel = new Label(13, 0, "Uwagi", headerFormat);
            sheet.setColumnView(13, 50);
            sheet.addCell(headerLabel);

            // zapełniam arkusz
            WritableCellFormat cellFormat = new WritableCellFormat();
            cellFormat.setWrap(true);

            Label cellLabel = new Label(0, 1, "John Smith", cellFormat);
            sheet.addCell(cellLabel);
            Number cellNumber = new Number(1, 1, 20, cellFormat);
            sheet.addCell(cellNumber);

            workbook.write();
        }
        finally {
            if(workbook != null){
                workbook.close();
            }
        }

    }
}
