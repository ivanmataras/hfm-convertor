package ru.hfm.console;

import org.junit.Test;
import ru.hfm.convertor.Convertor;
import ru.hfm.convertor.Parameters;

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
    public void generalTest(){

    }

    @Test

    public void balanceReadTest() {

        this.parameters = new Parameters();

        this.parameters.setInputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\Расшифровка  МАРТ 2017.xlsx");
        this.parameters.setOutputFile("E:\\Development\\HFM convertor project\\HFM март 2017\\output.txt");
        this.parameters.setSheetName("загр баланс");
        this.parameters.setSectionName(" ");
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

}
