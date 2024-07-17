package org.dkv.api.controller.cardValidation;

import common.ymlReader.YmlRunner;

public class NovofleetYmlReader {

    public static String novoCardId() {
        return YmlRunner.readYAMLFile("card", "novoCardNumber");
    }

    public static String novoCustomerId() {
        return YmlRunner.readYAMLFile("card", "novoCustomerId");
    }

    public static String novoExpiredDate() {
        return YmlRunner.readYAMLFile("card", "novoExpiredDate");
    }
}
