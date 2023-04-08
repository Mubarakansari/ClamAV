package com.clamav.dto;

import lombok.*;

@Getter
@Setter
public class GenericResponse {
    private String fileName;
    private boolean isVirus;
    private String size;
    private Object virusName;
    private String errorMessage;

    public GenericResponse(String fileName, String size, boolean isVirus, Object virusName) {
        this.fileName = fileName;
        this.size = size;
        this.isVirus = isVirus;
        this.virusName = virusName;
    }

    public GenericResponse(String fileName, String size, boolean isVirus, Object virusName, String errorMessage) {
        this.fileName = fileName;
        this.size = size;
        this.isVirus = isVirus;
        this.virusName = virusName;
        this.errorMessage = errorMessage;
    }
}
