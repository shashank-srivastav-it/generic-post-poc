package com.backend.genericpostpoc.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pojo {
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
