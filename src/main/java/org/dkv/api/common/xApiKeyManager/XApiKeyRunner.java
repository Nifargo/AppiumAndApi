package org.dkv.api.common.xApiKeyManager;

import static common.ymlReader.YmlRunner.readYAMLFile;

public class XApiKeyRunner {

    public static String getApiKey(String key){
        return readYAMLFile("xApiKey", key);
    }
}
