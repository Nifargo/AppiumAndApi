package common.ymlReader;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static common.systemLogger.AppLogger.logger;

public class YmlRunner {

    public static String readYAMLFile(String file, String key) {
        try (InputStream input = new FileInputStream("src/test/resources/data/ymlData/" + file + ".yml")) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(input);
            return processYamlDataString(data, file, key);
        } catch (Exception e) {
            handleYamlException(file, e);
        }
        return null;
    }

    public static <T> List<T> readYAMLFiles(String file, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        try (InputStream input = new FileInputStream("src/test/resources/data/ymlData/" + file + ".yml")) {
            Yaml yaml = new Yaml();

            Iterable<Object> yamlIterable = yaml.loadAll(input);

            return processYamlList(yamlIterable, clazz);
        } catch (Exception e) {
            handleYamlException(file, e);
        }
        return result;
    }

    private static String processYamlDataString(Map<String, Object> data, String file, String key) {
        if (!data.containsKey(key)) {
            throw new RuntimeException("Key " + key + " not found in YAML file: " + file);
        }
        return data.get(key).toString();
    }

    private static void handleYamlException(String file, Exception e) {
        logger.error("Error reading YAML file: " + file, e);
        throw new RuntimeException("Error reading YAML file: " + file, e);
    }

    public static <T> List<T> processYamlList(Iterable<Object> yamlIterable, Class<T> clazz) {
        List<T> result = new ArrayList<>();

        for (Object obj : yamlIterable) {
            if (obj instanceof Map<?, ?> map) {

                T instance = createObjectFromMap(map, clazz);
                result.add(instance);
            }
        }

        return result;
    }

    private static <T> T createObjectFromMap(Map<?, ?> map, Class<T> clazz) {
        T instance = null;

        try {
            instance = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                String fieldName = field.getName();
                Object value = map.get(fieldName);

                if (value != null) {
                    field.setAccessible(true);
                    field.set(instance, value.toString());
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return instance;
    }
}
