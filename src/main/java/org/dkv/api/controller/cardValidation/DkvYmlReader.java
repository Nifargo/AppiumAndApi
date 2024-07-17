package org.dkv.api.controller.cardValidation;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class DkvYmlReader {

    public static String dkvCardId() {
        return readYAMLFile("card", "dkvCardNumber");
    }

    public static String dkvCustomerId() {
        return readYAMLFile("card", "dkvCustomerId");
    }

    public static String dkvExpiredDate() {
        return readYAMLFile("card", "dkvExpiredDate");
    }
}
