package ru.hfm.coverter;

import org.junit.Test;
/**
 * Created by i.mataras on 04.04.2017.
 */
public class LauncherTest {

    @Test
    public void generalTest(){

        final String[] args = new String[2];
        args[0] = "test0";
        args[1] = "test1";

        final Launcher launcher = new Launcher();
        launcher.main(args);

    }
}
