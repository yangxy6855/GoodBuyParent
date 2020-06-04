package entity;


import lombok.Data;

@Data
public class ApiResponse {
    private Object data;
    private String msg;
    private int code;

}
