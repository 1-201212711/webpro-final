package egovframework.student;

/**
 * @Class Name : StudentVO.java
 * @Description : Student VO class
 * @Modification Information
 *
 * @author 1.201600001
 * @since 2016.11.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class StudentVO {

	/** number */
    private java.lang.String number;
    
    /** name */
    private java.lang.String name;
    
    private java.lang.String no;
    
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
    
    // 추가된 no 객체
    
    public java.lang.String getNo() {
        return this.no;
    }
    
    public void setNo(java.lang.String no) {
        this.no = no;
    }
    
}
