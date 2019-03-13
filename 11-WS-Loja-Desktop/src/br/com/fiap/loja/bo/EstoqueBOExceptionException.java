
/**
 * EstoqueBOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.com.fiap.loja.bo;

public class EstoqueBOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1552431063519L;
    
    private br.com.fiap.loja.bo.EstoqueBOStub.EstoqueBOException faultMessage;

    
        public EstoqueBOExceptionException() {
            super("EstoqueBOExceptionException");
        }

        public EstoqueBOExceptionException(java.lang.String s) {
           super(s);
        }

        public EstoqueBOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public EstoqueBOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(br.com.fiap.loja.bo.EstoqueBOStub.EstoqueBOException msg){
       faultMessage = msg;
    }
    
    public br.com.fiap.loja.bo.EstoqueBOStub.EstoqueBOException getFaultMessage(){
       return faultMessage;
    }
}
    