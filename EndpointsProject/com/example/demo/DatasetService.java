package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class DatasetService {
    private final Map<String, Complaint> complaintMap = new HashMap<>();
    private String path;

    public DatasetService(String path) {
        this.path = path;
        readFromCSV();
    }

    /**
     * Reads the dataset line by line, separate the words by comma, creates new Complaint objects and adds them to map
     */
    public void readFromCSV() {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(splitBy);
                complaintMap.put(values[0], new Complaint(values[0], values[1], values[2], values[3], values[4], values[5], values[6],
                        values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15],
                        values[16], values[17], values[18], values[19], values[20], values[21], values[22], values[23],
                        values[24], values[25], values[26], values[27], values[28], values[29], values[30], values[31],
                        values[32], values[33], values[34]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Eroare la deschiderea fisierului CSV");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Eroare la citirea din CSV");
            e.printStackTrace();
        }
    }

    /**
     * Uses Jackson to automatically convert the map into JSON
     * @return Total number of complaints as JSON object
     */
    public Map<String, Integer> getComplaintsNumberJson() {
        Map<String, Integer> complaintsNumber = new HashMap<>();
        complaintsNumber.put("complaintsNumber", complaintMap.size());
        return complaintsNumber;
    }

    /**
     * Creates a stream from complaintMap, groups the elements by KY_CD and counts them
     * @return A map where KY_CD is paired with its number of events
     */
    public Map<String, Long> getStatsGroupByKy_Cd() {
        return complaintMap.values().stream().collect(Collectors.groupingBy(
                Complaint::getKy_cd,
                Collectors.counting()
        ));
    }

    /**
     * Checks if the id is associated with an event. If not, returns false.
     * If the id is found, it deletes the event from map.
     * Reads the dataset and creates a temporary file where we save all the events, except for the one we want to delete.
     * It deletes the events from the dataset and copies the remaining events from temporary file into it.
     * At the end it deletes the temporary file, as it is no longer needed and returns true;
     * @param id id of event that we want to delete
     * @return false if the id was not found, true otherwise.
     * @throws IOException
     */
    public Boolean deleteById(String id) throws IOException {
        // caut id ul
        if (!complaintMap.containsKey(id)) {
            return false;
        } else {
            complaintMap.remove(id);

            String myFilePath = "C:\\Users\\Raul\\Documents\\Facultate\\JavaRaul\\RetinaProject\\src\\main\\NYPD_Complaint_Data_Historic.csv";
            String tempFilePath = "C:\\\\Users\\\\Raul\\\\Documents\\\\Facultate\\\\JavaRaul\\\\RetinaProject\\\\src\\\\main\\\\resources\\\\tempFile.txt";
            File tempFile = new File(tempFilePath);
            FileWriter writeToTempFile = new FileWriter(tempFile);
            String splitBy = ",";
            String line = "";

            try {
                BufferedReader br = new BufferedReader(new FileReader(myFilePath));
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(splitBy);
                    if (!Objects.equals(values[0], id)) { // o pun in newFile
                        writeToTempFile.write(line);
                        writeToTempFile.write("\n");
                    }
                }

                FileWriter writeToMyFile = new FileWriter(myFilePath);
                writeToMyFile.write("");

                writeToMyFile.close();
                writeToTempFile.close();

                FileInputStream tempFileIn = new FileInputStream(tempFilePath);
                FileOutputStream myFileOut = new FileOutputStream(myFilePath);
                int byteValue = byteValue = tempFileIn.read();
                while (byteValue != -1) {
                    myFileOut.write(byteValue);
                    byteValue = tempFileIn.read();
                }

                tempFileIn.close();
                myFileOut.close();
                tempFile.delete();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * Adds the new event to map, creates a String to emulate the CSV format and adds to the end of the file.
     * @param complaint Event we want to add to dataset
     * @return
     */
    public String addComplaint(Complaint complaint) {
        complaintMap.put(complaint.getCmplnt_num(), complaint);

        String toAdd = "\n" + complaint.getCmplnt_num() + "," + "null" + ","+ "null" + "," + "null" + "," + "null" + "," + "null" + ","
                + "null" + "," + complaint.getKy_cd() + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + ","
                + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + ","
                + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + "," + "null" + ","
                + "null" + "," + "null" + "," + "null" + ",";
        try {
            Files.write(Paths.get("C:\\Users\\Raul\\Documents\\Facultate\\JavaRaul\\RetinaProject\\src\\main\\NYPD_Complaint_Data_Historic.csv")
                    , toAdd.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Complaint with num=" + complaint.getCmplnt_num() + " added";
    }

    public Map<String, Complaint> showMap() {
        return complaintMap;
    }
}
