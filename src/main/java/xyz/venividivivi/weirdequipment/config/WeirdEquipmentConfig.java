package xyz.venividivivi.weirdequipment.config;

import com.google.gson.*;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WeirdEquipmentConfig {
    protected static final Logger LOGGER = LoggerFactory.getLogger("Weird Equipment Config");
    private static final File FILE = FabricLoader.getInstance().getConfigDir().resolve("weird_equipment.json").toFile();
    public static void init() {
        load();
    }

    public static void load() {
        if (FILE.exists()) {
            try (FileReader reader = new FileReader(FILE)) {
                fromJson((JsonObject) JsonParser.parseReader(reader));
            } catch (Exception e) {
                LOGGER.error("Could not load config from: '" + FILE.getPath() + "', " + e);
            }
        }
        save();
    }

    public static void save() {
        try (FileWriter writer = new FileWriter(FILE)) {
            writer.write(toJson().toString());
        } catch (IOException e) {
            LOGGER.error("Failed to save config to: '" + FILE.getPath() + "', " + e);
        }
    }

    public static void fromJson(JsonObject json) {
        try {
        } catch (JsonSyntaxException e) {
            LOGGER.error("Failed to parse member in property file");
        }
    }

    public static JsonObject toJson() {
        JsonObject json = new JsonObject();
        return json;
    }

    public static boolean hasElement(JsonArray jsonArray, String element) {
        for (JsonElement jsonElement : jsonArray) {
            if (jsonElement.getAsString().equals(element)) return true;
        }
        return false;
    }
}
