package gildedrose.qualitystrategy;

import gildedrose.Item;

public class AgedBrieStrategy implements QualityStrategy {
    private static final int MAX_QUALITY = 50;
    @Override
    public int calculateQuality(Item item) {
        return item.quality < MAX_QUALITY ? item.quality + 1 : MAX_QUALITY;
    }
}