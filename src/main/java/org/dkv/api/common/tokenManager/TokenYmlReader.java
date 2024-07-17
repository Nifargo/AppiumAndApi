package org.dkv.api.common.tokenManager;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class TokenYmlReader {
    public static String token() {
        return readYAMLFile("refreshToken", "refresh_token");
    }

    public static String secret() {
        return readYAMLFile("refreshToken", "client_secret");
    }
}
