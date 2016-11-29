package egovframework.student;

/**
 * @Class Name : StudentVO.java
 * @Description : Student VO class
 * @Modification Information
 *
 * @author 201212711
 * @since 2016.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class StudentVO extends StudentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** no */
    private int no;
    
    /** number */
    private java.lang.String number;
    
    /** name */
    private java.lang.String name;
    
    public int getNo() {
        return this.no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public java.lang.String getNumber() {
        return this.number;
    }
    
    public void setNumber(java.lang.String number) {
        this.number = number;
    }
    
    public java.lang.String getName() {
        return this.name;
    }
    
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
}
