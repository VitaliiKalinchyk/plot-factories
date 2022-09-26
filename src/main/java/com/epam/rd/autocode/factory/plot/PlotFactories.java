package com.epam.rd.autocode.factory.plot;

import java.util.Arrays;
import java.util.StringJoiner;

class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return () -> () -> hero.name() + " is young and adorable. " + hero.name() + " and " + beloved.name() +
                " love each other. " + villain.name() +
                " interferes with their happiness, but loses in the end.";
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return () -> () -> "In the beginning, " + hero.name() + " feels a bit awkward and uncomfortable. " +
                "But personal issue fades, when a big trouble comes - " + epicCrisis.name() + ". " +
                hero.name() + " stands up against it, but with no success at first. " +
                "But then, by putting self together and with the help of friends, " +
                "including spectacular, funny " + funnyFriend.name() + ", " + hero.name() +
                " restores the spirit, " + "overcomes the crisis and gains gratitude and respect.";
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        String heroesString;
        if (heroes.length == 1) {
            heroesString = "the brave " +heroes[0].name();
        } else {
            StringJoiner theBraveHeroes = new StringJoiner(", the brave ", "the brave ", " and the brave");
            Arrays.stream(heroes).limit(heroes.length - 1).forEach(hero -> theBraveHeroes.add(hero.name()));
            heroesString = theBraveHeroes + " " + heroes[heroes.length - 1].name();
        }
        return () -> () -> epicCrisis.name() +" threatens the world. But " + heroesString + " " +
                (heroes.length == 1 ? "is" : "are") + " on guard. So, no way that intrigues of " +
                villain.name() + " will bend the willpower of " +
                (heroes.length == 1 ? "the inflexible hero." : "inflexible heroes.");
    }
}
