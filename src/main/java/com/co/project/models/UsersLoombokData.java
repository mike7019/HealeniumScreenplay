package com.co.project.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class UsersLoombokData {
    String user;
    String pass;

    public static List<UsersLoombokData> setData(DataTable dataTable) {
        List<UsersLoombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, UsersLoombokData.class));
        }
        return dates;
    }


}
