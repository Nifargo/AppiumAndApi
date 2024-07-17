package org.dkv.api.controller.cardSynchronization;

import org.dkv.api.model.cardSynchronization.CardPojo;

import java.util.List;

import static common.ymlReader.YmlRunner.readYAMLFiles;

public class CardSyncYmlReader {

    public static List<CardPojo> getSyncCard() {
        return readYAMLFiles("syncCards", CardPojo.class);
    }
}
