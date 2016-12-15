package mx.emite.sdk;

import lombok.Getter;
import lombok.Setter;
import mx.emite.sdk.clientes.ClienteJson;
import mx.emite.sdk.clientes.operaciones.emisores.DescargaMasiva;
import mx.emite.sdk.clientes.operaciones.emisores.Estatus;
import mx.emite.sdk.clientes.operaciones.emisores.Servicios;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32Cancelador;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32Correo;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32DescargaAcuseXml;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32DescargaXml;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32Pdf;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32PdfAcuse;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32SelladorYTimbrador;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32SelladorYTimbradorGenericoTxt;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32SelladorYTimbradorGenericoXml;
import mx.emite.sdk.clientes.operaciones.emisores.cfdi32.Cfdi32Timbrador;
import mx.emite.sdk.clientes.operaciones.emisores.dpiva10.DpIva10Correo;
import mx.emite.sdk.clientes.operaciones.emisores.dpiva10.DpIva10DescargaXml;
import mx.emite.sdk.clientes.operaciones.emisores.dpiva10.DpIva10Pdf;
import mx.emite.sdk.clientes.operaciones.emisores.dpiva10.DpIva10SelladorYTimbrador;
import mx.emite.sdk.clientes.operaciones.emisores.dpiva10.DpIva10Timbrador;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32Cancelador;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32Correo;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32DescargaAcuseXml;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32DescargaXml;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32Pdf;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32PdfAcuse;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32SelladorYTimbrador;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32SelladorYTimbradorGenericoTxt;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32SelladorYTimbradorGenericoXml;
import mx.emite.sdk.clientes.operaciones.emisores.nom32.Nom32Timbrador;
import mx.emite.sdk.clientes.operaciones.emisores.ret10.Ret10Cancelador;
import mx.emite.sdk.clientes.operaciones.emisores.ret10.Ret10Correo;
import mx.emite.sdk.clientes.operaciones.emisores.ret10.Ret10DescargaXml;
import mx.emite.sdk.clientes.operaciones.emisores.ret10.Ret10Pdf;
import mx.emite.sdk.clientes.operaciones.emisores.ret10.Ret10SelladorYTimbrador;
import mx.emite.sdk.clientes.operaciones.emisores.ret10.Ret10Timbrador;
import mx.emite.sdk.clientes.operaciones.emisores.valida32.Valida32Validador;
import mx.emite.sdk.enums.Ambiente;


/**
 * @author enrique
 *
 *	EmiteAPI es la clase principal de consumo de emisores
 *
 *	
 */
public class EmiteAPI {

	
	private final ClienteJson cliente;
	
	private final Servicios servicios;
	private final DescargaMasiva descargamasiva;
	private final Valida32Validador valida32_validador;
	private final Estatus estatus;
	
	private final Cfdi32Timbrador cfdi32_timbrador;
	private final Cfdi32SelladorYTimbrador cfdi32_selladorytimbrador;
	private final Cfdi32SelladorYTimbradorGenericoXml cfdi32_selladorytimbradorgenericoxml;
	private final Cfdi32SelladorYTimbradorGenericoTxt cfdi32_selladorytimbradorgenericotxt;
	private final Cfdi32Cancelador cfdi32_cancelador;
	private final Cfdi32DescargaXml cfdi32_descargaxml;
	private final Cfdi32DescargaAcuseXml cfdi32_descargaacusexml;
	private final Cfdi32Pdf cfdi32_pdf;
	private final Cfdi32PdfAcuse cfdi32_pdfacuse;
	private final Cfdi32Correo cfdi32_correo;
	
	
	private final Nom32Timbrador nom32_timbrador;
	private final Nom32SelladorYTimbrador nom32_selladorytimbrador;
	private final Nom32SelladorYTimbradorGenericoXml nom32_selladorytimbradorgenericoxml;
	private final Nom32SelladorYTimbradorGenericoTxt nom32_selladorytimbradorgenericotxt;
	private final Nom32DescargaXml nom32_descargaxml;
	private final Nom32DescargaAcuseXml nom32_descargaacusexml;
	private final Nom32Pdf nom32_pdf;
	private final Nom32PdfAcuse nom32_pdfacuse;
	
	private final Nom32Cancelador nom32_cancelador;
	private final Nom32Correo nom32_correo;
	
	
	private final Ret10SelladorYTimbrador ret10_selladorytimbrador;
	private final Ret10Timbrador ret10_timbrador;
	private final Ret10Correo ret10_correo;
	private final Ret10Pdf ret10_pdf;
	private final Ret10Cancelador ret10_cancelador;
	private final Ret10DescargaXml ret10_descargaxml;
	
	private final DpIva10SelladorYTimbrador dpiva10_selladorytimbrador;
	private final DpIva10Timbrador dpiva10_timbrador;
	private final DpIva10DescargaXml dpiva10_descargaxml;
	private final DpIva10Pdf dpiva10_pdf;
	private final DpIva10Correo dpiva10_correo;
	
	@Getter @Setter
	private String usuarioWs,contrasenaWs;
	
	/**
	 * Se crea un objeto de tipo api, mediante el cual se ejecutarán todos los servicios implementados
	 * 
	 * @param ambiente 
	 * <h3>PRODUCCION</h3><p>Ambiente productivo</p>
	 * <h3>PRUEBAS</h3><p>Ambiente de pruebas</p>
	 * <h3>LOCAL</h3><p>Ambiente de uso exclusivo emite</p>
	 * @see Ambiente
	 */
	public EmiteAPI(final Ambiente ambiente){
		this(ambiente,null,null);
	}
	
	/**
	 * Se crea un objeto de tipo api, mediante el cual se ejecutarán todos los servicios implementados
	 * 
	 * @param ambiente 
	 * <h3>PRODUCCION</h3><p>Ambiente productivo</p>
	 * <h3>PRUEBAS</h3><p>Ambiente de pruebas</p>
	 * <h3>LOCAL</h3><p>Ambiente de uso exclusivo emite</p>
	 * @param usuarioWs usuario del WebService para almacenamiento local
	 * @param contrasenaWs contraseña del WebService para almacenamiento local
	 * @see Ambiente
	 */
	public EmiteAPI(final Ambiente ambiente,final String usuarioWs,final String contrasenaWs){
		this.cliente=new ClienteJson(ambiente);
		this.usuarioWs=usuarioWs;
		this.contrasenaWs=contrasenaWs;
		
		this.servicios=new Servicios(this.cliente);
		this.estatus=new Estatus(this.cliente);
		
		this.cfdi32_timbrador=new Cfdi32Timbrador(this.cliente);
		this.cfdi32_cancelador=new Cfdi32Cancelador(this.cliente);
		this.cfdi32_selladorytimbrador=new Cfdi32SelladorYTimbrador(this.cliente);
		this.cfdi32_selladorytimbradorgenericoxml=new Cfdi32SelladorYTimbradorGenericoXml(this.cliente);
		this.cfdi32_selladorytimbradorgenericotxt=new Cfdi32SelladorYTimbradorGenericoTxt(this.cliente);
		this.cfdi32_descargaxml=new Cfdi32DescargaXml(this.cliente);
		this.cfdi32_descargaacusexml=new Cfdi32DescargaAcuseXml(this.cliente);
		this.cfdi32_pdf = new Cfdi32Pdf(this.cliente);
		this.cfdi32_pdfacuse = new Cfdi32PdfAcuse(this.cliente);
		this.cfdi32_correo=new Cfdi32Correo(this.cliente);
		
		this.descargamasiva=new DescargaMasiva(this.cliente);
		
		this.valida32_validador=new Valida32Validador(this.cliente);
		
		this.nom32_timbrador=new Nom32Timbrador(this.cliente);
		this.nom32_selladorytimbrador=new Nom32SelladorYTimbrador(this.cliente);
		this.nom32_cancelador=new Nom32Cancelador(this.cliente);
		this.nom32_selladorytimbradorgenericoxml=new Nom32SelladorYTimbradorGenericoXml(this.cliente);
		this.nom32_selladorytimbradorgenericotxt=new Nom32SelladorYTimbradorGenericoTxt(this.cliente);
		this.nom32_descargaxml=new Nom32DescargaXml(this.cliente);
		this.nom32_descargaacusexml=new Nom32DescargaAcuseXml(this.cliente);
		this.nom32_pdf = new Nom32Pdf(this.cliente);
		this.nom32_pdfacuse = new Nom32PdfAcuse(this.cliente);
		this.nom32_correo=new Nom32Correo(this.cliente);
		this.ret10_selladorytimbrador=new Ret10SelladorYTimbrador(this.cliente);
		this.ret10_cancelador=new Ret10Cancelador(this.cliente);
		this.ret10_correo=new Ret10Correo(this.cliente);
		this.ret10_descargaxml=new Ret10DescargaXml(this.cliente);
		this.ret10_pdf=new Ret10Pdf(this.cliente);
		this.ret10_timbrador=new Ret10Timbrador(this.cliente);
		this.dpiva10_selladorytimbrador = new DpIva10SelladorYTimbrador(this.cliente);
		this.dpiva10_timbrador = new DpIva10Timbrador(this.cliente);
		this.dpiva10_descargaxml = new DpIva10DescargaXml(this.cliente);
		this.dpiva10_pdf = new DpIva10Pdf(this.cliente);
		this.dpiva10_correo = new DpIva10Correo(this.cliente);
	}
	
	/**
	 * Servicio de listado de Servicios
	 * @return servicios
	 * @since 0.0.1
	 */
	public Servicios servicios(){
		return servicios;
	}

	/**
	 * Servicio Timbrado de CFDI 3.2
	 * @return cfdi32_timbrador
	 * @since 0.0.1
	 */
	public Cfdi32Timbrador cfdi32_Timbrador(){
		return cfdi32_timbrador;
	}
	
	
	
	/**
	 * Servicio de Sellado y Timbrado de CFDI 3.2
	 * @return cfdi32_selladorytimbrador
	 * @since 0.0.1
	 */
	public Cfdi32SelladorYTimbrador cfdi32_SelladorTimbrador(){
		return cfdi32_selladorytimbrador;
	}
	

	/**
	 * Servicio de Cancelación de CFDI 3.2
	 * @return cfdi32_cancelador
	 * @since 0.0.2
	 */
	public Cfdi32Cancelador cfdi32_Cancelador(){
		return cfdi32_cancelador;
	}
	
	/**
	 * Servicio de Descarga de CFDI 3.2
	 * @return cfdi32_descargaxml
	 * @since 0.0.2
	 */
	public Cfdi32DescargaXml cfdi32_DescargaXml(){
		return cfdi32_descargaxml;
	}
	
	/**
	 * Servicio de Descarga Acuses de Cancelación
	 * @return cfdi32_descargaacusexml
	 * @since 0.0.2
	 */
	public Cfdi32DescargaAcuseXml cfdi32_DescargaAcuseXml(){
		return cfdi32_descargaacusexml;
	}

	/**
	 * Servicio de Descarga de Pdf
	 * @return cfdi32_pdf
	 * @since 0.0.2
	 */
	public Cfdi32Pdf cfdi32_pdf(){
		return cfdi32_pdf;
	}
	
	/**
	 * Servicio de Descarga de Pdf de acuse
	 * @return cfdi32_pdfacuse
	 * @since 0.0.2
	 */
	public Cfdi32PdfAcuse cfdi32_DescargaAcusePdf(){
		return cfdi32_pdfacuse;
	}
	
	/**
	 * Servicio de Envio de Correos
	 * @return cfdi32_correo
	 * @since 0.0.2
	 */
	public Cfdi32Correo cfdi32_Correo(){
		return cfdi32_correo;
	}
	
	/**
	 * Servicio Timbrado de Xml Genérico 3.2
	 * @return cfdi32_selladorytimbradorgenericoxml
	 * @since 0.1.1
	 */
	public Cfdi32SelladorYTimbradorGenericoXml cfdi32_SelladorTimbradorGenericoXml(){
		return cfdi32_selladorytimbradorgenericoxml;
	}
	
	/**
	 * Servicio Timbrado de Txt Genérico 3.2
	 * @return cfdi32_selladorytimbradorgenericotxt
	 * @since 0.1.1
	 */
	public Cfdi32SelladorYTimbradorGenericoTxt cfdi32_SelladorTimbradorGenericoTxt(){
		return cfdi32_selladorytimbradorgenericotxt;
	}
	
	/**
	 * Servicio de Descarga Masiva
	 * @return descargamasiva
	 * @since 0.0.2
	 */
	public DescargaMasiva descargamasiva(){
		return descargamasiva;
	}
	
	/**
	 * Servicio de Validación de CFDI
	 * @return valida32_validador
	 * @since 0.0.9
	 */
	public Valida32Validador valida32_Validador(){
		return valida32_validador;
	}
	
	/**
	 * Servicio de Sellado y Timbrado de Nomina 3.2
	 * @return nom32_selladorytimbrador
	 * @since 0.1.0
	 */
	public Nom32SelladorYTimbrador nom32_SelladorTimbrador(){
		return nom32_selladorytimbrador;
	}
	
	/**
	 * Servicio Timbrado de Nómina de CFDI 3.2
	 * @return nom32_timbrador
	 * @since 0.1.0
	 */
	public Nom32Timbrador nom32_Timbrador(){
		return nom32_timbrador;
	}
	
	/**
	 * Servicio de Cancelación de CFDI 3.2
	 * @return nom32_cancelador
	 * @since 0.1.1
	 */
	public Nom32Cancelador nom32_Cancelador(){
		return nom32_cancelador;
	}
	
	/**
	 * Servicio de Envio de Correos de nómina
	 * @return nom32_correo
	 * @since 0.1.1
	 */
	public Nom32Correo nom32_Correo(){
		return nom32_correo;
	}
	
	/**
	 * Servicio Timbrado de Xml Genérico 3.2 de nómina
	 * @return nom32_selladorytimbradorgenericoxml
	 * @since 0.1.1
	 */
	public Nom32SelladorYTimbradorGenericoXml nom32_SelladorTimbradorGenericoXml(){
		return nom32_selladorytimbradorgenericoxml;
	}
	
	/**
	 * Servicio Timbrado de Txt Genérico 3.2 de nómina
	 * @return nom32_selladorytimbradorgenericotxt
	 * @since 0.1.1
	 */
	public Nom32SelladorYTimbradorGenericoTxt nom32_SelladorTimbradorGenericoTxt(){
		return nom32_selladorytimbradorgenericotxt;
	}
	
	/**
	 * Servicio de Descarga de Pdf de nomina
	 * @return nom32_pdf
	 * @since 0.1.1
	 */
	public Nom32Pdf nom32_pdf(){
		return nom32_pdf;
	}
	
	/**
	 * Servicio de Descarga de Pdf de acuse
	 * @return nom32_pdfacuse
	 * @since 0.1.1
	 */
	public Nom32PdfAcuse nom32_DescargaAcusePdf(){
		return nom32_pdfacuse;
	}
	
	/**
	 * Servicio de Descarga de CFDI 3.2 de nómina
	 * @return nom32_descargaxml
	 * @since 0.1.1
	 */
	public Nom32DescargaXml nom32_DescargaXml(){
		return nom32_descargaxml;
	}
	
	/**
	 * Servicio de Descarga Acuses de Cancelación de Nómina
	 * @return nom32_descargaacusexml
	 * @since 0.1.1
	 */
	public Nom32DescargaAcuseXml nom32_DescargaAcuseXml(){
		return nom32_descargaacusexml;
	}
	
	/**
	 * Servicio de Consulta de Estatus de Emisores
	 * @return estatus
	 * @since 0.1.2
	 */
	public Estatus estatus(){
		return estatus;
	}
	
	/**
	 * Servicio de Sellado y Timbrado de Retenciones
	 * @return estatus
	 * @since 0.1.4
	 */
	public Ret10SelladorYTimbrador ret10_SelladorTimbrador(){
		return ret10_selladorytimbrador;
	}
	
	/**
	 * Servicio de Descarga de Pdf de retenciones
	 * @return ret10_pdf
	 * @since 0.1.5
	 */
	public Ret10Pdf ret10_Pdf(){
		return ret10_pdf;
	}
	
	/**
	 * Servicio de envio de correo de retenciones
	 * @return nom32_pdf
	 * @since 0.1.5
	 */
	public Ret10Correo ret10_Correo(){
		return ret10_correo;
	}
	
	/**
	 * Servicio de Cancelación de Retenciones 1.0
	 * @return ret10_cancelador
	 * @since 0.1.5
	 */
	public Ret10Cancelador ret10_Cancelador(){
		return ret10_cancelador;
	}
	
	/**
	 * Servicio Timbrado de Retenciones 1.0
	 * @return ret10_timbrador
	 * @since 0.1.5
	 */
	public Ret10Timbrador ret10_Timbrador(){
		return ret10_timbrador;
	}
	
	/**
	 * Servicio de Descarga de Retenciones 1.0
	 * @return ret10_descargaxml
	 * @since 0.1.5
	 */
	public Ret10DescargaXml ret10_DescargaXml(){
		return ret10_descargaxml;
	}

	/**
	 * Servicio de Sellado y Timbrado de DP IVA 1.0
	 * @return dpiva10_SelladorTimbrador
	 * @since 0.1.8
	 */
	public DpIva10SelladorYTimbrador dpiva10_SelladorTimbrador() {
		return dpiva10_selladorytimbrador;
	}
	
	/**
	 * Servicio de Timbrado de DP IVA 1.0
	 * @return dpiva10_Timbrador
	 * @since 0.1.8
	 */
	public DpIva10Timbrador dpiva10_Timbrador() {
		return dpiva10_timbrador;
	}
	
	/**
	 * Servicio de Descarga de Declaraciones de Proveedores de IVA 1.0
	 * @return dpiva10_descargaxml
	 * @since 0.1.8
	 */
	public DpIva10DescargaXml dpiva10_DescargaXml(){
		return dpiva10_descargaxml;
	}
	
	/**
	 * Servicio de Descarga de Declaraciones de Proveedores de IVA 1.0
	 * @return dpiva10_pdf
	 * @since 0.1.8
	 */
	public DpIva10Pdf dpiva10_Pdf(){
		return dpiva10_pdf;
	}
	
	/**
	 * Servicio de envio de correo de Declaraciones de Proveedores de IVA 1.0
	 * @return dpiva10_pdf
	 * @since 0.1.8
	 */
	public DpIva10Correo dpiva10_Correo(){
		return dpiva10_correo;
	}
	
}
