package com.gcsj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceInfo {
    int id;
    int plan;
    String area;
    Date enrollYear;
}
