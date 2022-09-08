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
import java.util.Optional;


@Transactional
@RequiredArgsConstructor
@Service
@Repository
public class JExcel {

    private final CustomerService customerService;

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

            for(Customer c : customerService.showALL()){
                Number cId = new Number(0, 1, c.getClientId(), cellFormat);
                sheet.addCell(cId);
                Label cName = new Label(1, 1,c.getName() , cellFormat);
                sheet.addCell(cName);
                Label cSurname = new Label(2, 1,c.getSurname() , cellFormat);
                sheet.addCell(cSurname);
                Label cCartNumber = new Label(3, 1,c.getCartNumber() , cellFormat);
                sheet.addCell(cCartNumber);
                Label cDeposite;
                if(c.isCartDeposit()){cDeposite = new Label(4, 1, "OPŁACONO", cellFormat);}
                else {cDeposite = new Label(4, 1, "NIE OPŁACONO", cellFormat);}
                sheet.addCell(cDeposite);
                Label cEmail = new Label(5, 1,c.getEmail(), cellFormat);
                sheet.addCell(cEmail);
                Label cPhoneNumber = new Label(6, 1,c.getPhoneNumber() , cellFormat);
                sheet.addCell(cPhoneNumber);
                Label cBucklet = new Label(7, 1,c.getBucklet().getName() , cellFormat);
                sheet.addCell(cBucklet);
                Number buckletPrice = new Number(8, 1, c.getBucklet().getPrice() , cellFormat);
                sheet.addCell(buckletPrice);
                Label cPurchaseDate = new Label(9, 1, String.valueOf(c.getPurchaseDate()) , cellFormat);
                sheet.addCell(cPurchaseDate);
                Label cExpiryDate = new Label(10, 1,String.valueOf(c.getExpiryDate()) , cellFormat);
                sheet.addCell(cExpiryDate);
                Optional <Trainer> getTrainer = Optional.ofNullable(c.getTrainer());
                if(getTrainer.isPresent()){
                Label trainerName = new Label(11, 1,c.getTrainer().getName() , cellFormat);
                sheet.addCell(trainerName);
                Label trainerSurname = new Label(12, 1,c.getTrainer().getSurname() , cellFormat);
                sheet.addCell(trainerSurname);}
                else {
                    Label trainerName = new Label(11, 1,"" , cellFormat);
                    sheet.addCell(trainerName);
                    Label trainerSurname = new Label(12, 1,"" , cellFormat);
                    sheet.addCell(trainerSurname);
                }
                Label cComment = new Label(13, 1,c.getComment() , cellFormat);
                sheet.addCell(cComment);
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
