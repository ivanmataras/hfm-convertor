package ru.hfm.console;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.hfm.convertor.Convertor;
import ru.hfm.convertor.Parameters;

import java.io.File;

/*
 * Main class
 *
 * @author imataras
 * @since 04.04.2017
 */

public class LauncherTest {

    Parameters parameters;
    Convertor convertor;

    @Test
    @Before
    public void testXLSXFile() {


    }

    @Test
    public void balanceReadTest() {

        this.parameters = new Parameters();

        this.parameters.setInputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\Расшифровка  МАРТ 2017.xlsx");
        this.parameters.setOutputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\output.txt");
        this.parameters.setSheetName("загр баланс перемеш");
        this.parameters.setSectionName("BALANCE_LOCSTAT");
        this.parameters.setScenario("Actual");
        this.parameters.setYear(2017);
        this.parameters.setMonth(3);
        this.parameters.setFirstRowNumber(4);
        this.parameters.setLastRowNumber(51);
        this.parameters.setColumnNumberSourceFMEntity(0);
        this.parameters.setColumnNumberSourceFMAccount(1);
        this.parameters.setColumnNumberSourceICP(2);
        this.parameters.setColumnNumberSourceCustom1(3);
        this.parameters.setColumnNumberSourceCustom2(4);
        this.parameters.setColumnNumberSourceCustom3(5);
        this.parameters.setColumnNumberSourceCustom4(6);
        this.parameters.setColumnNumberAmount(7);

        convertor = new Convertor();
        convertor.convert(this.parameters);

    }

    @Ignore
    public void balanceReadTestNoInputFileParameter() {

        this.parameters = new Parameters();

        this.parameters.setInputFile("");
        this.parameters.setOutputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\output.txt");
        this.parameters.setSheetName("загр баланс");
        this.parameters.setSectionName("");
        this.parameters.setScenario("Actual");
        this.parameters.setYear(2017);
        this.parameters.setMonth(3);
        this.parameters.setFirstRowNumber(4);
        this.parameters.setLastRowNumber(51);
        this.parameters.setColumnNumberSourceFMEntity(0);
        this.parameters.setColumnNumberSourceFMAccount(1);
        this.parameters.setColumnNumberSourceICP(2);
        this.parameters.setColumnNumberSourceCustom1(3);
        this.parameters.setColumnNumberSourceCustom2(4);
        this.parameters.setColumnNumberSourceCustom3(5);
        this.parameters.setColumnNumberSourceCustom4(6);
        this.parameters.setColumnNumberAmount(7);

        convertor = new Convertor();
        convertor.convert(this.parameters);

    }

    @Ignore
    public void balanceReadTestNoSheetParameter() {

        this.parameters = new Parameters();

        this.parameters.setInputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\Расшифровка  МАРТ 2017.xlsx");
        this.parameters.setOutputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\output.txt");
        this.parameters.setSheetName("");
        this.parameters.setSectionName("");
        this.parameters.setScenario("Actual");
        this.parameters.setYear(2017);
        this.parameters.setMonth(3);
        this.parameters.setFirstRowNumber(4);
        this.parameters.setLastRowNumber(51);
        this.parameters.setColumnNumberSourceFMEntity(0);
        this.parameters.setColumnNumberSourceFMAccount(1);
        this.parameters.setColumnNumberSourceICP(2);
        this.parameters.setColumnNumberSourceCustom1(3);
        this.parameters.setColumnNumberSourceCustom2(4);
        this.parameters.setColumnNumberSourceCustom3(5);
        this.parameters.setColumnNumberSourceCustom4(6);
        this.parameters.setColumnNumberAmount(7);

        convertor = new Convertor();
        convertor.convert(this.parameters);

    }

    @Ignore
    public void balanceReadTestNoCellsParameters() {

        this.parameters = new Parameters();

        this.parameters.setInputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\Расшифровка  МАРТ 2017.xlsx");
        this.parameters.setOutputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\output.txt");
        this.parameters.setSheetName("");
        this.parameters.setSectionName("");
        this.parameters.setScenario("Actual");
        this.parameters.setYear(2017);
        this.parameters.setMonth(3);
        this.parameters.setFirstRowNumber(4);
        this.parameters.setLastRowNumber(51);
        this.parameters.setColumnNumberSourceFMEntity(0);
        this.parameters.setColumnNumberSourceFMAccount(0);
        this.parameters.setColumnNumberSourceICP(0);
        this.parameters.setColumnNumberSourceCustom1(0);
        this.parameters.setColumnNumberSourceCustom2(0);
        this.parameters.setColumnNumberSourceCustom3(0);
        this.parameters.setColumnNumberSourceCustom4(0);
        this.parameters.setColumnNumberAmount(0);

        convertor = new Convertor();
        convertor.convert(this.parameters);

    }

}
