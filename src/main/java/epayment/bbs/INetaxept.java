package epayment.bbs;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.4
 * 2018-01-10T12:51:57.432+05:30
 * Generated source version: 3.0.4
 * 
 */
@WebService(targetNamespace = "http://BBS.EPayment", name = "INetaxept")
@XmlSeeAlso({com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, ObjectFactory.class, org.datacontract.schemas._2004._07.bbs_epayment.ObjectFactory.class})
public interface INetaxept {

    @WebMethod(operationName = "Query", action = "http://BBS.EPayment/INetaxept/Query")
    @Action(input = "http://BBS.EPayment/INetaxept/Query", output = "http://BBS.EPayment/INetaxept/QueryResponse", fault = {@FaultAction(className = INetaxeptQueryAuthenticationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/QueryAuthenticationExceptionFault"), @FaultAction(className = INetaxeptQueryQueryExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/QueryQueryExceptionFault")})
    @RequestWrapper(localName = "Query", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.Query")
    @ResponseWrapper(localName = "QueryResponse", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.QueryResponse")
    @WebResult(name = "QueryResult", targetNamespace = "http://BBS.EPayment")
    public org.datacontract.schemas._2004._07.bbs_epayment.QueryResponse query(
        @WebParam(name = "merchantId", targetNamespace = "http://BBS.EPayment")
        java.lang.String merchantId,
        @WebParam(name = "token", targetNamespace = "http://BBS.EPayment")
        java.lang.String token,
        @WebParam(name = "request", targetNamespace = "http://BBS.EPayment")
        org.datacontract.schemas._2004._07.bbs_epayment.QueryRequest request
    ) throws INetaxeptQueryAuthenticationExceptionFaultFaultMessage, INetaxeptQueryQueryExceptionFaultFaultMessage;

    @WebMethod(operationName = "Batch", action = "http://BBS.EPayment/INetaxept/Batch")
    @Action(input = "http://BBS.EPayment/INetaxept/Batch", output = "http://BBS.EPayment/INetaxept/BatchResponse", fault = {@FaultAction(className = INetaxeptBatchAuthenticationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/BatchAuthenticationExceptionFault"), @FaultAction(className = INetaxeptBatchGenericErrorFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/BatchGenericErrorFault"), @FaultAction(className = INetaxeptBatchMerchantTranslationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/BatchMerchantTranslationExceptionFault")})
    @RequestWrapper(localName = "Batch", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.Batch")
    @ResponseWrapper(localName = "BatchResponse", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.BatchResponse")
    @WebResult(name = "BatchResult", targetNamespace = "http://BBS.EPayment")
    public org.datacontract.schemas._2004._07.bbs_epayment.ArrayOfProcessResponse batch(
        @WebParam(name = "merchantId", targetNamespace = "http://BBS.EPayment")
        java.lang.String merchantId,
        @WebParam(name = "token", targetNamespace = "http://BBS.EPayment")
        java.lang.String token,
        @WebParam(name = "requests", targetNamespace = "http://BBS.EPayment")
        org.datacontract.schemas._2004._07.bbs_epayment.ArrayOfProcessRequest requests
    ) throws INetaxeptBatchAuthenticationExceptionFaultFaultMessage, INetaxeptBatchGenericErrorFaultFaultMessage, INetaxeptBatchMerchantTranslationExceptionFaultFaultMessage;

    @WebMethod(operationName = "Register", action = "http://BBS.EPayment/INetaxept/Register")
    @Action(input = "http://BBS.EPayment/INetaxept/Register", output = "http://BBS.EPayment/INetaxept/RegisterResponse", fault = {@FaultAction(className = INetaxeptRegisterValidationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterValidationExceptionFault"), @FaultAction(className = INetaxeptRegisterAuthenticationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterAuthenticationExceptionFault"), @FaultAction(className = INetaxeptRegisterGenericErrorFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterGenericErrorFault"), @FaultAction(className = INetaxeptRegisterMerchantTranslationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterMerchantTranslationExceptionFault"), @FaultAction(className = INetaxeptRegisterUniqueTransactionIdExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterUniqueTransactionIdExceptionFault"), @FaultAction(className = INetaxeptRegisterSecurityExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterSecurityExceptionFault"), @FaultAction(className = INetaxeptRegisterBBSExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/RegisterBBSExceptionFault")})
    @RequestWrapper(localName = "Register", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.Register")
    @ResponseWrapper(localName = "RegisterResponse", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.RegisterResponse")
    @WebResult(name = "RegisterResult", targetNamespace = "http://BBS.EPayment")
    public org.datacontract.schemas._2004._07.bbs_epayment.RegisterResponse register(
        @WebParam(name = "merchantId", targetNamespace = "http://BBS.EPayment")
        java.lang.String merchantId,
        @WebParam(name = "token", targetNamespace = "http://BBS.EPayment")
        java.lang.String token,
        @WebParam(name = "request", targetNamespace = "http://BBS.EPayment")
        org.datacontract.schemas._2004._07.bbs_epayment.RegisterRequest request
    ) throws INetaxeptRegisterValidationExceptionFaultFaultMessage, INetaxeptRegisterAuthenticationExceptionFaultFaultMessage, INetaxeptRegisterGenericErrorFaultFaultMessage, INetaxeptRegisterMerchantTranslationExceptionFaultFaultMessage, INetaxeptRegisterUniqueTransactionIdExceptionFaultFaultMessage, INetaxeptRegisterSecurityExceptionFaultFaultMessage, INetaxeptRegisterBBSExceptionFaultFaultMessage;

    @WebMethod(operationName = "Process", action = "http://BBS.EPayment/INetaxept/Process")
    @Action(input = "http://BBS.EPayment/INetaxept/Process", output = "http://BBS.EPayment/INetaxept/ProcessResponse", fault = {@FaultAction(className = INetaxeptProcessValidationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ProcessValidationExceptionFault"), @FaultAction(className = INetaxeptProcessAuthenticationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ProcessAuthenticationExceptionFault"), @FaultAction(className = INetaxeptProcessGenericErrorFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ProcessGenericErrorFault"), @FaultAction(className = INetaxeptProcessMerchantTranslationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ProcessMerchantTranslationExceptionFault"), @FaultAction(className = INetaxeptProcessNotSupportedExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ProcessNotSupportedExceptionFault"), @FaultAction(className = INetaxeptProcessBBSExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ProcessBBSExceptionFault")})
    @RequestWrapper(localName = "Process", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.Process")
    @ResponseWrapper(localName = "ProcessResponse", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.ProcessResponse")
    @WebResult(name = "ProcessResult", targetNamespace = "http://BBS.EPayment")
    public org.datacontract.schemas._2004._07.bbs_epayment.ProcessResponse process(
        @WebParam(name = "merchantId", targetNamespace = "http://BBS.EPayment")
        java.lang.String merchantId,
        @WebParam(name = "token", targetNamespace = "http://BBS.EPayment")
        java.lang.String token,
        @WebParam(name = "request", targetNamespace = "http://BBS.EPayment")
        org.datacontract.schemas._2004._07.bbs_epayment.ProcessRequest request
    ) throws INetaxeptProcessValidationExceptionFaultFaultMessage, INetaxeptProcessAuthenticationExceptionFaultFaultMessage, INetaxeptProcessGenericErrorFaultFaultMessage, INetaxeptProcessMerchantTranslationExceptionFaultFaultMessage, INetaxeptProcessNotSupportedExceptionFaultFaultMessage, INetaxeptProcessBBSExceptionFaultFaultMessage;

    @WebMethod(operationName = "CheckAvailability", action = "http://BBS.EPayment/INetaxept/CheckAvailability")
    @Action(input = "http://BBS.EPayment/INetaxept/CheckAvailability", output = "http://BBS.EPayment/INetaxept/CheckAvailabilityResponse")
    @RequestWrapper(localName = "CheckAvailability", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.CheckAvailability")
    @ResponseWrapper(localName = "CheckAvailabilityResponse", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.CheckAvailabilityResponse")
    @WebResult(name = "CheckAvailabilityResult", targetNamespace = "http://BBS.EPayment")
    public java.lang.String checkAvailability();

    @WebMethod(operationName = "Recon", action = "http://BBS.EPayment/INetaxept/Recon")
    @Action(input = "http://BBS.EPayment/INetaxept/Recon", output = "http://BBS.EPayment/INetaxept/ReconResponse", fault = {@FaultAction(className = INetaxeptReconSecurityExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ReconSecurityExceptionFault"), @FaultAction(className = INetaxeptReconValidationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ReconValidationExceptionFault"), @FaultAction(className = INetaxeptReconAuthenticationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ReconAuthenticationExceptionFault"), @FaultAction(className = INetaxeptReconGenericErrorFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ReconGenericErrorFault"), @FaultAction(className = INetaxeptReconMerchantTranslationExceptionFaultFaultMessage.class, value = "http://BBS.EPayment/INetaxept/ReconMerchantTranslationExceptionFault")})
    @RequestWrapper(localName = "Recon", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.Recon")
    @ResponseWrapper(localName = "ReconResponse", targetNamespace = "http://BBS.EPayment", className = "epayment.bbs.ReconResponse")
    @WebResult(name = "ReconResult", targetNamespace = "http://BBS.EPayment")
    public org.datacontract.schemas._2004._07.bbs_epayment.ReconResponse recon(
        @WebParam(name = "merchantId", targetNamespace = "http://BBS.EPayment")
        java.lang.String merchantId,
        @WebParam(name = "token", targetNamespace = "http://BBS.EPayment")
        java.lang.String token,
        @WebParam(name = "request", targetNamespace = "http://BBS.EPayment")
        org.datacontract.schemas._2004._07.bbs_epayment.ReconRequest request
    ) throws INetaxeptReconSecurityExceptionFaultFaultMessage, INetaxeptReconValidationExceptionFaultFaultMessage, INetaxeptReconAuthenticationExceptionFaultFaultMessage, INetaxeptReconGenericErrorFaultFaultMessage, INetaxeptReconMerchantTranslationExceptionFaultFaultMessage;
}