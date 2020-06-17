package it.myrent.ee.db;

import it.aessepi.utils.BundleUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.apache.commons.lang.builder.EqualsBuilder;

/** @author Hibernate CodeGenerator */
public class MROldRigaContrattoNoleggioPPay implements it.aessepi.utils.db.PersistentInstance, MROldRigaDocumento {

    /** identifier field */
    private Integer id;
    private MROldContrattoNoleggio contrattoNoleggio;
    private Integer numeroRigaContrattoNoleggio;
    private String descrizione;
    private String unitaMisura;
    private Double quantita;
    private Double prezzoUnitario;
    private Double sconto;
    private Double scontoFisso;
    private Double totaleImponibileRiga;
    private Double totaleIvaRiga;
    private Double totaleRiga;
    private MROldCodiciIva codiceIva;
    private MROldPianoDeiConti codiceSottoconto;
    private MROldOptional optional;
    private MROldCarburante carburante;
    private Boolean tempoKm;
    private Boolean tempoExtra;
    private Boolean franchigia;
    private MROldParcoVeicoli veicolo;
    public static final ResourceBundle bundle = BundleUtils.getBundle("it/myrent/ee/db/Bundle");
    private static final MessageFormat TO_STRING_MESSAGE_FORMAT = new MessageFormat(bundle.getString("RigaDocumentoFiscale.msgDescrizione0Quantita1Prezzo2Imponibile3Totale4"));

    /** default constructor */
    public MROldRigaContrattoNoleggioPPay() {
        setTempoKm(false);
        setTempoExtra(false);
        setFranchigia(false);
    }

    public MROldRigaContrattoNoleggioPPay(MROldRigaDocumentoFiscale row, MROldContrattoNoleggio agreement) {

        setTempoKm(false);
        setTempoExtra(false);
        setFranchigia(false);
        
        if (row==null)
            return;
        
        //id=row.getId();

        contrattoNoleggio=agreement;
        numeroRigaContrattoNoleggio=row.getNumeroRigaFattura();
        descrizione=row.getDescrizione();
        unitaMisura=row.getUnitaMisura();
        quantita=row.getQuantita();
        prezzoUnitario=row.getPrezzoUnitario();
        sconto=row.getSconto();
        scontoFisso=row.getScontoFisso();
        totaleImponibileRiga=row.getTotaleImponibileRiga();
        totaleIvaRiga=row.getTotaleIvaRiga();
        totaleRiga=row.getTotaleRiga();
        codiceIva=row.getCodiceIva();
        codiceSottoconto=row.getCodiceSottoconto();
        optional=row.getOptional();
        carburante=row.getCarburante();
        tempoKm=row.getTempoKm();
        tempoExtra=row.getTempoExtra();
        franchigia=row.getFranchigia();
        veicolo=row.getVeicolo();
    }

    public Integer getId() {
        return this.id;




    }

    public void setId(Integer id) {
        this.id = id;




    }

    public MROldContrattoNoleggio getContrattoNoleggio() {
        return this.contrattoNoleggio;




    }

    public void setContrattoNoleggio(MROldContrattoNoleggio contrattoNoleggio) {
        this.contrattoNoleggio = contrattoNoleggio;




    }

    public Integer getNumeroRigaContrattoNoleggio() {
        return this.numeroRigaContrattoNoleggio;




    }

    public void setNumeroRigaContrattoNoleggio(Integer numeroRigaContrattoNoleggio) {
        this.numeroRigaContrattoNoleggio = numeroRigaContrattoNoleggio;




    }

    public String getDescrizione() {
        return this.descrizione;




    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;




    }

    public String getUnitaMisura() {
        return this.unitaMisura;




    }

    public void setUnitaMisura(String unitaMisura) {
        this.unitaMisura = unitaMisura;




    }

    public Double getQuantita() {
        return this.quantita;




    }

    public void setQuantita(Double quantita) {
        this.quantita = quantita;




    }

    public Double getPrezzoUnitario() {
        return this.prezzoUnitario;




    }

    public void setPrezzoUnitario(Double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;




    }

    public Double getSconto() {
        return this.sconto;




    }

    public void setSconto(Double sconto) {
        this.sconto = sconto;




    }

    public Double getScontoFisso() {
        return this.scontoFisso;




    }

    public void setScontoFisso(Double scontoFisso) {
        this.scontoFisso = scontoFisso;




    }

    public Double getTotaleImponibileRiga() {
        return this.totaleImponibileRiga;




    }

    public void setTotaleImponibileRiga(Double totaleImponibileRiga) {
        this.totaleImponibileRiga = totaleImponibileRiga;




    }

    public Double getTotaleIvaRiga() {
        return this.totaleIvaRiga;




    }

    public void setTotaleIvaRiga(Double totaleIvaRiga) {
        this.totaleIvaRiga = totaleIvaRiga;




    }

    public Double getTotaleRiga() {
        return this.totaleRiga;




    }

    public void setTotaleRiga(Double totaleRiga) {
        this.totaleRiga = totaleRiga;




    }

    public void setCodiceIva(MROldCodiciIva codiceIva) {
        this.codiceIva = codiceIva;




    }

    public MROldCodiciIva getCodiceIva() {
        return codiceIva;




    }

    public void setCodiceSottoconto(MROldPianoDeiConti codiceSottoconto) {
        this.codiceSottoconto = codiceSottoconto;




    }

    public MROldPianoDeiConti getCodiceSottoconto() {
        return codiceSottoconto;




    }

    public String toString() {
        return TO_STRING_MESSAGE_FORMAT.format(new Object[]{
                    getDescrizione(),
                    getQuantita(),
                    getPrezzoUnitario(),
                    getTotaleImponibileRiga(),
                    getTotaleRiga(),
                    (getContrattoNoleggio().getPrefisso() != null ? getContrattoNoleggio().getPrefisso() : "") + " " + getContrattoNoleggio().getNumero()
                });




    }

    public boolean equals(Object other) {
        if (!(other instanceof MROldRigaContrattoNoleggioPPay)) {
            return false;




        }
        MROldRigaContrattoNoleggioPPay castOther = (MROldRigaContrattoNoleggioPPay) other;




        return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();




    }

    public Object getDocumento() {
        return contrattoNoleggio;




    }

    public void setDocumento(Object documento) {
        contrattoNoleggio = (MROldContrattoNoleggio) documento;




    }

    public void setNumeroRigaDocumento(Integer numeroRiga) {
        this.numeroRigaContrattoNoleggio = numeroRiga;




    }

    public Integer getNumeroRigaDocumento() {
        return numeroRigaContrattoNoleggio;




    }

    public MROldOptional getOptional() {
        return optional;




    }

    public void setOptional(MROldOptional optional) {
        this.optional = optional;




    }

    public MROldCarburante getCarburante() {
        return carburante;




    }

    public void setCarburante(MROldCarburante carburante) {
        this.carburante = carburante;




    }

    public Boolean getTempoKm() {
        return tempoKm;




    }

    public void setTempoKm(Boolean tempoKm) {
        this.tempoKm = tempoKm;




    }

    public Boolean getTempoExtra() {
        return tempoExtra;




    }

    public void setTempoExtra(Boolean tempoExtra) {
        this.tempoExtra = tempoExtra;




    }

    public Boolean getFranchigia() {
        return franchigia;




    }

    public void setFranchigia(Boolean franchigia) {
        this.franchigia = franchigia;




    }

    public MROldParcoVeicoli getVeicolo() {
        return veicolo;




    }

    public void setVeicolo(MROldParcoVeicoli veicolo) {
        this.veicolo = veicolo;




    }

    public Boolean isRigaDescrittiva() {
        boolean rigaDescrittiva =
                (getDescrizione() != null
                && getQuantita() == null
                && getPrezzoUnitario() == null
                && getSconto() == null
                && getScontoFisso() == null
                && getCodiceIva() == null
                && getCodiceSottoconto() == null);




        return rigaDescrittiva;


    }
}
