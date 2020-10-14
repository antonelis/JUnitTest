package gildedrose.qualitystrategy;

import gildedrose.Item;

public class QualityStrategyFactory {

    public static QualityStrategy getStrategy(Item item) {

        switch (item.name) {
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstageStrategy();

            case "Aged Brie":
                return new AgedBrieStrategy();

            case "Sulfuras, Hand of Ragnaros":
                return new SulfurusStrategy();

            case "Conjured Mana Cake":
                return new ConjuredStrategy();

            default:
                return new DefaultStrategy();
        }
    }
}
