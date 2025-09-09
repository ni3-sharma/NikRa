package Constant;

//add all constant value in this interface
public interface Constant {
public interface Constant {
    String BASEURL="";
    String errorMsg="Api Calling fail";
    String POST="POST";
    String GET="GET";
    String PUT="PUT";
    
    // Dropdown function
    static String[] dropdown() {
        return new String[]{POST, GET, PUT};
    }
}
```