package be.guho.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HistoryMixin {

    ObjectMapper MAPPER = new ObjectMapper();
    DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    String FILENAME = "calculator_history.json";

    default void addToHistory(String expression, double result) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("expression", expression);
        entry.put("result", result);
        entry.put("timestamp", LocalDateTime.now().format(FORMATTER));

        List<Map<String, Object>> history = loadHistory();
        history.add(entry);
        saveHistory(history);
    }

    private List<Map<String, Object>> loadHistory() {
        Path path = Path.of(FILENAME);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        try (Reader reader = Files.newBufferedReader(path)) {
            return MAPPER.readValue(reader, new TypeReference<>() {});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void saveHistory(List<Map<String, Object>> history) {
        Path path = Path.of(FILENAME);
        try (Writer writer = Files.newBufferedWriter(path)) {
            MAPPER.writerWithDefaultPrettyPrinter().writeValue(writer, history);
        } catch (IOException e) { }
    }
}
