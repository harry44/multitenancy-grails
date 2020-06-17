
package epayment.bbs;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.4
 * 2018-01-10T12:51:57.365+05:30
 * Generated source version: 3.0.4
 */

@WebFault(name = "BBSException", targetNamespace = "http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary")
public class INetaxeptProcessBBSExceptionFaultFaultMessage extends Exception {
    
    private org.datacontract.schemas._2004._07.bbs_epayment.BBSException bbsException;

    public INetaxeptProcessBBSExceptionFaultFaultMessage() {
        super();
    }
    
    public INetaxeptProcessBBSExceptionFaultFaultMessage(String message) {
        super(message);
    }
    
    public INetaxeptProcessBBSExceptionFaultFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public INetaxeptProcessBBSExceptionFaultFaultMessage(String message, org.datacontract.schemas._2004._07.bbs_epayment.BBSException bbsException) {
        super(message);
        this.bbsException = bbsException;
    }

    public INetaxeptProcessBBSExceptionFaultFaultMessage(String message, org.datacontract.schemas._2004._07.bbs_epayment.BBSException bbsException, Throwable cause) {
        super(message, cause);
        this.bbsException = bbsException;
    }

    public org.datacontract.schemas._2004._07.bbs_epayment.BBSException getFaultInfo() {
        return this.bbsException;
    }
}
