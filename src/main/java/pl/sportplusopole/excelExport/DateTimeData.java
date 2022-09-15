package pl.sportplusopole.excelExport;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DateTimeData")
@Data
public class DateTimeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_Id")
    private int dataId;

    @Column(name = "month_name")
    private String monthName;

}
