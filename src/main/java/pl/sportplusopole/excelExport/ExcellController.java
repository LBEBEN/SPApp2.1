package pl.sportplusopole.excelExport;

import jxl.write.WriteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sportplusopole.excelExport.JExcel;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ExcellController {

    private final JExcel excel;

    @RequestMapping("/export")
    @ResponseBody
    public String export() throws WriteException, IOException {
        excel.exportToExcel();
        return "Wygenerowano";
    }
}
