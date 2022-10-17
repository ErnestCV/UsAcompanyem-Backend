package org.hackathon.grup3.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class CSVParser {

    @SneakyThrows
    public String parseFile(File file) {

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {

            //Initialize variables
            List<String> fieldNames;
            List<Map<String, Object>> mapList = null;

            //Check if file has content
            String csvLine = fileReader.readLine();
            if (csvLine != null) {
                //Get field names from csv header
                fieldNames = new ArrayList<>(convertCSVToStringList(csvLine));

                //Initialize
                mapList = new ArrayList<>();

                //Read all lines from file
                csvLine = fileReader.readLine();
                while (csvLine != null) {
                    //Get csv line as list of strings
                    List<String> currentLine = convertCSVToStringList(csvLine);
                    Map<String, Object> map = new LinkedHashMap<>();

                    //Put each value in the corresponding key (field name)
                    for (int i = 0; i < fieldNames.size(); i++) {
                        Object current = currentLine.get(i);
                        if (i == 0) {
                            //Seccions censals
                            map.put(fieldNames.get(i), current.toString());
                        } else {
                            //Check if the value is a number. This may be changed to createDouble, etc.
                            if (NumberUtils.isCreatable(current.toString())) {
                                map.put(fieldNames.get(i), NumberUtils.createNumber(current.toString()));
                            } else {
                                map.put(fieldNames.get(i), current.toString());
                            }
                        }
                    }
                    mapList.add(map);

                    csvLine = fileReader.readLine();
                }
            }
            return mapToJSON(mapList);
        }
    }

    private List<String> convertCSVToStringList(String csvString) {

        //Convert CSV to list of Strings
        return new ArrayList<>(Arrays.asList(csvString.split(",")));
    }

    private String mapToJSON(List<Map<String, Object>> mapList) throws JsonProcessingException {

        //Uses ObjectMapper to convert the list of maps to a JSON
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(mapList);
    }
}
