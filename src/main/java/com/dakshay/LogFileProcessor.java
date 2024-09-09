package com.dakshay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LogFileProcessor {

    private final Map<String, Map<String, Set<String>>> logMap;

    public LogFileProcessor() {
        this.logMap = new HashMap<>();
    }

    public void prepareData(String fileName) {
        BufferedReader objReader = null;
        try {
            objReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Main.class.getResourceAsStream("/" + fileName))));
            populateData(objReader);

        } catch (IOException e) {
            System.out.println("Error Parsing File");
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                System.out.println("Error Closing File");
            }
        }
    }


    private void populateData(BufferedReader objReader) throws IOException {
        String log;
        while ((log = objReader.readLine()) != null) {
            String[] word = log.split(",");
            Long timestamp = Long.parseLong(word[0]);
            String pageId = word[1];
            String userId = word[2];
            String timestampKey = Utils.getTimestampKey(timestamp);
            Map<String, Set<String>> dateMap = logMap.getOrDefault(userId, new HashMap<>());
            Set<String> pageIds = dateMap.getOrDefault(timestampKey, new HashSet<>());
            pageIds.add(pageId);
            dateMap.put(timestampKey,pageIds);
            logMap.put(userId,dateMap);
        }
    }

    public List<String> loyalCustomers() {
        List<String> loyalCust = new ArrayList<>();
        this.logMap.forEach( (user,dateMap) ->{
            if(dateMap.keySet().size()<2) return;
            AtomicBoolean isUnique  = new AtomicBoolean(true);
            dateMap.forEach((date,pageIds) ->{
                if(pageIds.size()<2) {
                    isUnique.set(false);
                }
            });
            if(isUnique.get()) loyalCust.add(user);
        });
        return loyalCust;
    }


}
