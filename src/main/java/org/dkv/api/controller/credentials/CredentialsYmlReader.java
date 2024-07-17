package org.dkv.api.controller.credentials;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class CredentialsYmlReader {

    public static String userName() {
        return readYAMLFile("credentials", "username");
    }

    public static String password() {
        return readYAMLFile("credentials", "password");
    }
}
