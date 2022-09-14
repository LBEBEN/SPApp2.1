package pl.sportplusopole.excelExport;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.Number;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.sportplusopole.customer.Customer;
import pl.sportplusopole.customer.CustomerService;
import pl.sportplusopole.trainer.Trainer;


import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
@Repository
public class JExcel {

    public void exportToExcel(List<Customer> customers, String name) throws IOException, WriteException{
        WritableWorkbook workbook = null;
        int r = 1; // numer wiersza
        try {
            // tworzę plik
        File file = new File(".");
        String path = file.getAbsolutePath();
        String fileLocation = path.substring(0,path.length()-1)+name+".xls";

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

            for(Customer c : customers){
                Number cId = new Number(0, r, c.getClientId(), cellFormat);
                sheet.addCell(cId);
                Label cName = new Label(1, r,c.getName() , cellFormat);
                sheet.addCell(cName);
                Label cSurname = new Label(2, r,c.getSurname() , cellFormat);
                sheet.addCell(cSurname);
                Label cCartNumber = new Label(3, r,c.getCartNumber() , cellFormat);
                sheet.addCell(cCartNumber);
                Label cDeposite;
                if(c.isCartDeposit()){cDeposite = new Label(4, r, "OPŁACONO", cellFormat);}
                else {cDeposite = new Label(4, r, "NIE OPŁACONO", cellFormat);}
                sheet.addCell(cDeposite);
                Label cEmail = new Label(5, r,c.getEmail(), cellFormat);
                sheet.addCell(cEmail);
                Label cPhoneNumber = new Label(6, r,c.getPhoneNumber() , cellFormat);
                sheet.addCell(cPhoneNumber);
                Label cBucklet = new Label(7, r,c.getBucklet().getName() , cellFormat);
                sheet.addCell(cBucklet);
                Number buckletPrice = new Number(8, r, c.getBucklet().getPrice() , cellFormat);
                sheet.addCell(buckletPrice);
                Label cPurchaseDate = new Label(9, r, String.valueOf(c.getPurchaseDate()) , cellFormat);
                sheet.addCell(cPurchaseDate);
                Label cExpiryDate = new Label(10, r,String.valueOf(c.getExpiryDate()) , cellFormat);
                sheet.addCell(cExpiryDate);
                Optional <Trainer> getTrainer = Optional.ofNullable(c.getTrainer());
                if(getTrainer.isPresent()){
                Label trainerName = new Label(11, r,c.getTrainer().getName() , cellFormat);
                sheet.addCell(trainerName);
                Label trainerSurname = new Label(12, r,c.getTrainer().getSurname() , cellFormat);
                sheet.addCell(trainerSurname);}
                else {
                    Label trainerName = new Label(11, r,"" , cellFormat);
                    sheet.addCell(trainerName);
                    Label trainerSurname = new Label(12, r,"" , cellFormat);
                    sheet.addCell(trainerSurname);
                }
                Label cComment = new Label(13, r,c.getComment() , cellFormat);
                sheet.addCell(cComment);
                r++;
            }
            workbook.write();
        }
        finally {
            if(workbook != null){
                workbook.close();
            }
        }

    }
}
