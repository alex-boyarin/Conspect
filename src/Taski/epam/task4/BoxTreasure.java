package Taski.epam.task4;

import Taski.epam.task4.treasures.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static Taski.epam.task4.RandomUtil.getRandom;

public final class BoxTreasure {
    private static List<Treasure> treasures;

    private BoxTreasure() {
    }

    private static List<Treasure> generatorTreasure() {
        List<Treasure> treasureList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int typeNumber = getRandom(TypeTreasure.values().length);
            int coast = getRandom(2000);
            if (i % 2 == 0) {
                coast *= 3;
                treasureList.add(new TreasureGold(i, "Gold", TypeTreasure.values()[typeNumber], coast));
            } else if (i % 3 == 0) {
                coast *= 2;
                treasureList.add(new TreasureSilver(i, "Silver", TypeTreasure.values()[typeNumber], coast));
            } else {
                treasureList.add(new TreasureBronze(i, "Bronze", TypeTreasure.values()[typeNumber], coast));
            }
        }
        return treasureList;
    }

    public static List<Treasure> listTreasure() {

        File dir = new File("caveDragon");
        dir.mkdir();
        File file = new File(dir + File.separator + "treasurelist.dat");
        if (file.length() == 0) {
            treasures = generatorTreasure();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(file))) {
                objectOutputStream.writeObject(treasures);
                return treasures;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(file))) {
                treasures = (List<Treasure>) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return treasures;
    }
}
