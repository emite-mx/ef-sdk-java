package mx.emite.sdk.errores;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;




public enum I_Api_Errores {
	
	OK(0,"OK"),
	SERVICIO_NODISPONIBLE(1,"Servicio no disponible"),
	PROCESANDO_RESPUESTA(2,"Procesando respuesta"),
	DESERIALIZANDO(3,"Deserializando objeto"),
	SERIALIZANDO(4,"Serializando objeto"),
	DECODIFICANDO(5,"Decodificando cadena en Base64"),
	CODIFICANDO(5,"Codificando cadena a Base64"),
	LEYENDO_ARCHIVO(6,"Error al leer el archivo"),
	GUARDANDOARCHIVO(7,"Guardando archivo"),
	//Errores del cliente
	CLIENTE_REQUEST_INVALIDO(100,"Petición inválida"),
	CLIENTE_TOKEN_INVALIDO(101,"Token inválido"),
	CLIENTE_TOKEN_EXPIRADO(102,"Token expirado"),
	CLIENTE_TOKEN_TIPOUSUARIO(103,"Token pertenece a un tipo de usuario incorrecto"),
	CLIENTE_TOKEN_INTEGRADOR_INEXISTENTE(104,"El usuario integrador no existe"),
	CLIENTE_TOKEN_INTEGRADOR_CONTRASENA(105,"La contraseña del integrador es incorrecta"),
	CLIENTE_TOKEN_INTEGRADOR_DESHABILITADO(106,"El integrador se encuentra deshabilitado"),
	CLIENTE_TOKEN_INTEGRADOR_GENERANDO(107,"Error interno generando token"),
	CLIENTE_EMISOR_INVALIDO(108,"El rfc del emisor difiere de las credenciales proporcionadas"),
	CLIENTE_XML_YATIMBRADO(109,"El xml ya se encuentra timbrado"),
	CLIENTE_XML_BASE64(110,"El xml enviado no esta expresado en Base64"),
	CLIENTE_XML_INVALIDO(111,"El documento enviado no es un archivo XML válido"),
	CLIENTE_XML_TIPO_NOSOPORTADO(112,"El tipo de documento aún no es soportado"),
	CLIENTE_XML_INFO_NOENCONTRADO(113,"No se encontro uno de los campos en el documento"),
	CLIENTE_XML_UUID_INVALIDO(114,"El uuid enviado no corresponde al uuid que contiene el XML"),
	CLIENTE_XML_SERIE_INVALIDO(115,"La serie enviada no corresponde a la serie que contiene el XML"),
	CLIENTE_XML_FOLIO_INVALIDO(116,"El folio enviado no corresponde al folio que contiene el XML"),
	CLIENTE_XML_FECHA_INVALIDO(117,"La fecha enviada no corresponde a la fecha que contiene el XML"),
	CLIENTE_XML_TOTAL_INVALIDO(118,"El total enviado no corresponde a el total que contiene el XML"),
	CLIENTE_CSD_CER_INVALIDO(119,"El certificado público .cer, no puede ser leido"),
	CLIENTE_CSD_KEY_INVALIDO(120,"El certificado privado .key, no puede ser leido"),
	CLIENTE_REQUEST_ZIP(121,"El archivo zip esta dañado"), 
	CLIENTE_PLANTILLA_INVALIDA(122,"La plantilla solicitada no existe"),
	CLIENTE_XML_MALFORMADO(123,"El documento enviado es un documento XML mal formado"),
	
	//Errores de proxy de timbrado
	PROXY_TIMBRANDO(140,"Error al timbrar el XML"),
	PROXY_TIMBRANDO_RESPUESTA(141,"No se obtuvo respuesta del timbrador"),
	PROXY_YATIMBRADO(142,"El xml ya esta timbrado"),
	PROXY_XML_DATOINVALIDO(143,"Error al convertir un campo del XML"),
	PROXY_CANCELANDO(144,"Error al cancelar los uuids"),
	PROXY_CANCELANDO_RESPUESTA(145,"No se obtuvo respuesta del cancelador"),
	PROXY_GENERANDO_PDF(146,"Error generando PDF"),
	PROXY_ENVIANDO_CORREO(147,"Error enviando correo"),
	PROXY_LEYENDO_XML(148,"Error al leer el XML"),
	PROXY_LEYENDO_TXT(149,"Error al leer el archivo de texto"),
	PROXY_GENERANDO_COMPROBANTE(150,"Error al generar el comprobante"),
	PROXY_GENERANDO_CADENAORIGINAL(151,"Error al generar la cadena original"),
	PROXY_GENERANDO_PFX(152,"Error generando PFX de cancelación"),
	PROXY_DESENCRIPTANDO(153,"Error al desencriptar información"),
	PROXY_GENERANDO_ZIP(154,"Error al generar el ZIP"),
	PROXY_VALIDANDO(155,"Error validando comprobante"),
	PROXY_VALIDANDO_RESPUESTA(156,"No se obtuvo respuesta del validador"),
	PROXY_MASIVA_ENPROCESO(157,"La consulta se esta ejecutando, espere a que termine el proceso"),
	PROXY_SERVICIONODISPONIBLE(158,"Servicio no disponible"),
	PROXY_CONSULTANDOSAT(159,"Consultando Sat"),
	//Errores de scot
	SCOT_CONSUMIENDO(160,"Error ejecutando transacción de consumo"),
	SCOT_EMITE_CONTRASENA(161,"El token interno es inválido"),
	SCOT_EMITE_TIPO_TIMBRE(162,"El tipo de timbre no se encuentra en el catálogo"),
	SCOT_EMITE_USUARIO_EMISOR(163,"No se encontro ningún emisor con el usuario enviado al WS"),
	SCOT_EMITE_USUARIO_EMISOR_CONTRASENA(164,"La contraseña del emisor es incorrecta"),
	SCOT_EMITE_USUARIO_TIPO(165,"No se encontro el tipo de timbre asignado al emisor"),
	SCOT_EMITE_INTEGRADOR_DESHABILITADO(166,"El integrador esta deshabilitado"),
	SCOT_EMITE_EMISOR_DESHABILITADO(167,"El emisor esta deshabilitado"),
	SCOT_EMISOR_PREPAGO_AGOTADOS(168,"Los timbres asignados al emisor de prepago estan agotados"),
	SCOT_INTEGRADOR_PREPAGO_AGOTADOS(169,"El integrador no cuenta con timbres por asignar"),
	SCOT_EMITE_EMISOR_LIBERADO(170,"El emisor aún no ha sido liberado por parte de Emite"),
	SCOT_EMITE_TIPO_INCORRECTO(171,"El tipo de timbre es incorrecto"),
	SCOT_EMITE_EMISOR_SUCURSAL(172,"El emisor requiere que se envie el nombre de sucursal"),
	SCOT_EMITE_EMISOR_SUCURSAL_NOEXISTE(173,"El emisor no cuenta con la sucursal enviada"),
	SCOT_TOKEN_CONSUMO_GENERANDO(174,"Error al generar el token de consumo"),
	SCOT_TOKEN_CONSUMO_INVALIDO(175,"Token de Consumo inválido"),
	SCOT_TOKEN_TIMBRES_TAMANO(176,"El numero de timbres del token difiere al número de timbres enviados"),     
	SCOT_XML_EMISOR_INVALIDO(177,"El rfc del emisor difiere de las credenciales proporcionadas"),
	SCOT_CONSUMIENDO_SINRESPUESTA(178,"No se obtuvo respuesta del servicio de consumo"),
	SCOT_EMISORES_GUARDANDO(179,"Error guardando emisor"),
	SCOT_EMISORES_REPETIDO(180,"El rfc del emisor ya esta dado de alta"),
	SCOT_EMISORES_NOEXISTE(181,"El rfc del emisor no esta dado de alta"),
	SCOT_EMISORES_NOPERMITESUCURSALES(182,"El tipo de emisor no permite la inserción de sucursales"),
	SCOT_SUCURSALES_GUARDANDO(183,"Error guardando sucursal"),
	SCOT_CSDS_GUARDANDO(184,"Error al guardar el CSD"),
	SCOT_UUID_NOEXISTE(185,"El uuid no existe"),
	SCOT_DESCARGANDO_XML(186,"Error al descargar XML de scot"),
	SCOT_TIMBRANDO_CORTEMENSUAL(187,"Error al timbrar corte mensual"),
	SCOT_FACTURAS_EMITE_TIMBRANDO(188,"Error al timbrar factura Emite"),
	SCOT_EMISOR_CSDNOEXISTE(189,"El emisor no cuenta con CSD cargado en SCOT"),
	SCOT_SELLANDO(190,"Error al sellar con el CSD"),
	SCOT_GUARDANDO_FACTURA(191,"Error al guardar la factura en la BD"),
	SCOT_EMITE_INTEGRADOR_NOEXISTE(192,"El integrador no existe"), 
	SCOT_EMITE_INTEGRADOR_CONTRASENA(193,"La contraseña de integrador es incorrecta"),
	SCOT_RECEPTOR_NOENCONTRADO(194,"El receptor no ha sido encontrado"),
	SCOT_BUSQUEDA_VACIA(195,"La consulta no arrojó resultados"),
	//Errores de timbrador
	
	EF_CANCELA_EXITOSAMENTE(201,"UUID Cancelado exitosamente"),
	EF_CANCELA_PREVIAMENTE_CANCELADO(202,"UUID Previamente cancelado"),
	EF_CANCELA_UUIDNOCORRESPONDE(203,"UUID No corresponde el RFC del emisor y de quien solicita la cancelación."),
	EF_CANCELA_NOEXISTE(205,"UUID No existe"),
	EF_CANCELA_USUARIOINVALIDO(300,"El usuario con el que se quiere conectar es inválido"),
	EF_CANCELA_XMLMALFORMADO(301,"XML mal formado"),
	EF_SELLO_INVALIDO(302	, "El sello es inválido"),
	EF_CSD_NOCORRESPONDERFC(303	, "El CSD del emisor no corresponde al RFC que viene como emisor en el comprobante."),
	EF_CSD_REVOCADO(304	, "El CSD del emisor ha sido revocado o no se encuentra en la lista de contribuyentes. "),
	EF_FECHA_VIGENCIA_CSD(305	, "La fecha de emisión no esta dentro de la vigencia del CSD del emisor."),
	EF_CERTIFICADO_ESFIEL(306	, "El certificado corresponde a una FIEL. Debe utilizar un CSD."),
	EF_TIMBREPREVIO(307	, "El CFDI contiene un timbre previo "),
	EF_CERTIFICADO_NO_FIRMADO(308	, "El CFDI contiene un certificado no firmado por una entidad autorizada (SAT)"),
	EF_CERTIFICADO_INVALIDO(310	, "El CFDI contiene un certificado inválido"),
	EF_FECHA_72HORAS(401	, "El rango de la fecha de generación no puede ser mayor a 72 horas"),
	EF_EMISOR_REGIMEN(402	, "El RFC del emisor no tiene régimen autorizado"),
	EF_FECHA2011(403,"La fecha de emisión no es posterior al 01 de enero 2011"),
	EF_AUTENTICACION(501,"Autenticación no válida."),
	EF_NOENCONTRADO(502,"Comprobante no encontrado."),
	EF_METADATOS(503,"Los metadatos recibidos no son válidos."),
	EF_ESTRUCTURA(504,"La estructura del comprobante recibido no es válida."),
	EF_METADATOS_EMISOR(505,"Los metadatos proporcionados no corresponden al emisor."),
	EF_PREVIAMENTE_TIMBRADO(506	, "Comprobante timbrado anteriormente"),
	EF_PREVIAMENTE_CANCELADO(507	, "Comprobante previamente cancelado"),
	EF_INFORMACION_INVALIDA(601,"La información para buscar el comprobante no es válida."),
	EF_CFDI_NOEXISTE(602,"Comprobante que se desea descargar no existe."), 
	
	PORTAL_AUTENTICACION(1001,"Error de autenticación (credenciales inválidas)"),
	PORTAL_GENERANDO_FACTURA(1002,"Error al generar la factura"),  
	PORTAL_TIMBRANDO(1003,"Error al timbrar el comprobante"), 
	PORTAL_NOIMPLEMENTADO(1004,"No implementado"),
	PORTAL_UUID_NOENCONTRADO(1005,"UUID no encontrado"),
	PORTAL_UUID_INCORRECTO(1006,"Error validando UUID"),
	PORTAL_GUARDANDO(1007,"Error al guardar en la BD"),
	PORTAL_RECEPCIONES_ARCHIVOS(1008,"No se encontrarón los archivos para recepción"),
	PORTAL_RECEPCIONES_PROCESANDO(1009,"Error procesando recepción"),
	
	CONNECT_DATOSINSUFICIENTES(2010,"Datos insuficientes"),
	CONNECT_CONFIGURACION(2011,"Error en configuración"),
	CONNECT_TIMBRANDO(2012,"Error al timbrar"),

	
	ENVIO_CANCELACION_TOKENCANCELACION(4000,"Obteniendo token de cancelación"),
	ENVIO_CANCELACION_VACIOS(4001,"Parámetros vacios"),
	ENVIO_CANCELACION_CERTIFICADOINVALIDO(4002,"El certificado pfx es inválido"),
	ENVIO_CANCELACION_CONTRASENAINVALIDA(4003,"La contraseña del pfx es inválida"),
	ENVIO_CANCELACION_FIRMANDOXML(4004,"Error generando la firma del XML de cancelación"),
	ENVIO_CANCELACION_ERRORSERVIDOR(4005,"Error del servidor"),
	ENVIO_CANCELACION_GENERANDOHASH(4006,"Generando hash de envio"),
	ENVIO_CANCELACION_FIRMANDO(4007,"Firmando envio"),
	ENVIO_CANCELACION_CODIFICANDOCERTIFICADO(4008,"Codificando el certificado"),
	ENVIO_CANCELACION_SERVICIOCANCELACION(4009,"Servicio de cancelación del SAT no disponible"),
	ENVIO_CANCELACION_LEYENDORESPUESTA(4010,"Leyendo la respuesta del SAT"),
	ENVIO_CANCELACION_ENMANTENIMIENTO(4999,"El servicio de cancelación de encuentra en mantenimiento, intente mas tarde"),
	
	ENVIO_RETENCIONES_SUBIENDOXML(5002,"Error al subir XML"),
	
	TIMBRADOR_XMLINVALIDO(301,"El documento no es un XML válido"),
	TIMBRADOR_TIMBREPREVIO(307,"Timbre previo"),
	TIMBRADOR_VALIDACIONXSD(301,"Error de estructura (validando el XML contra el XSD)"),
	TIMBRADOR_VALIDACIONFECHA(401,"Validando fecha de expedición"),
	TIMBRADOR_VALIDACIONCERTIFICADO(308,"Error validando certificado de emisor"),
	TIMBRADOR_CSDAPOCRIFO(308,"El CSD del emisor no fue firmado por los certificados de autoridad del SAT"),
	TIMBRADOR_EMISORCSD(303,"El rfc del CSD no corresponde al rfc del emisor del comprobante"),
	TIMBRADOR_CSDVIGENCIA(305,"La fecha de emisión no esta dentro de la vigencia del CSD del emisor"),
	TIMBRADOR_SELLOINVALIDO(302,"El sello de emisor no es válido"),
	TIMBRADOR_CSDFIEL(306,"El certificado es FIEL y no CSD"),
	TIMBRADOR_SERVICIONODISPONIBLE(350,"Servicio temporalmente fuera de servicio"),
	TIMBRADOR_LCO_REVOCADO(304,"El CSD del emisor esta revocado"),
	TIMBRADOR_LCO(402,"El certificado no se encuentra en la LCO"),
	TIMBRADOR_HSM(351,"Error en consumo de HSM"),
	TIMBRADOR_ENVIANDOCOMPROBANTE(352,"Error al enviar el comprobante al SAT"), 
	
	CANCELADOR_RETENCIONES_UUIDPROCESADO(1200,"UUID Procesado"),
	CANCELADOR_RETENCIONES_UUIDCANCELADO(1201,"UUID Cancelado"),
	CANCELADOR_RETENCIONES_UUIDPREVIAMENTECANCELADO(1202,"UUID Cancelado"),
	CANCELADOR_RETENCIONES_UUIDNOENCONTRADO(1203,"UUID No encontrado o no corresponde al emisor"),
	CANCELADOR_RETENCIONES_UUIDNOAPLICABLECANCELACION(1204,"UUID No aplicable para cancelación"),
	CANCELADOR_RETENCIONES_UUIDNOEXISTE(1205,"UUID No existe"),
	CANCELADOR_RETENCIONES_UUIDNOCORRESPONDE(1206,"UUID no corresponde a un CFDI del Sector Primario"),
	CANCELADOR_RETENCIONES_AUTENTICACION(1300,"Autenticación no válida"),
	CANCELADOR_RETENCIONES_XMLMALFORMADO(1301,"XML mal formado"),
	CANCELADOR_RETENCIONES_ESTRUCTURAFOLIOS(1302,"Estructura de folios no válida"),
	CANCELADOR_RETENCIONES_ESTRUCTURARFC(1303,"Estructura de RFC no válida"),
	CANCELADOR_RETENCIONES_ESTRUCTURAFECHA(1304,"Estructura de fecha no válida"),
	CANCELADOR_RETENCIONES_CERTIFICADONOEMISOR(1305,"Certificado no corresponde al emisor"),
	CANCELADOR_RETENCIONES_CERTIFICADONOVIGENTE(1306,"Certificado no vigente"),
	CANCELADOR_RETENCIONES_CERTIFICADOESFIEL(1307,"Uso de FIEL no permitido"),
	CANCELADOR_RETENCIONES_CERTIFICADOREVOCADO(1308,"Certificado revocado o caduco"),
	CANCELADOR_RETENCIONES_FIRMAMALFORMADA(1309,"Firma mal formada o inválida"),
	
	VALIDADOR_SINTIMBRE(5001,"El comprobante no contiene TimbreFiscal"),
	VALIDADOR_PROCESANDOXML(5002,"Error al leer el XML"), 
	VALIDADOR_SELLOINVALIDO(5003,"Sello del comprobante inválido"),
	VALIDADOR_CERTIFICADO(5004,"Error validando certificado emisor"),
	VALIDADOR_CERTIFICADOSAT(5005,"Error al recuperar certificado de PAC"),
	VALIDADOR_SELLOPACINVALIDO(5006,"Sello del pac inválido"),
	VALIDADOR_CONSULTANDOSAT(5007,"Servicio de Consulta del SAT no disponible"),
	VALIDADOR_CFDINOEXISTESAT(5008,"El uuid no esta registrado ante el SAT"),
	VALIDADOR_CFDINOESTAVIGENTESAT(5009,"El uuid no esta vigente ante el SAT"),
	VALIDADOR_GENERANDOPDF(5010,"Error al generar el pdf de validación"), 
	
	;
	
	
	private Integer id;
	 
	private String titulo;
		
	I_Api_Errores(Integer val,String titulo){
		this.id=val;
		this.titulo=titulo;
		
		
	}
	public static I_Api_Errores getTipo(Integer estatus) {
		for(I_Api_Errores e:values()){
			if(e.id.equals(estatus))
				return e;
		}
		return CLIENTE_REQUEST_INVALIDO;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public String getError(){
		return id.toString();
	}

	
	public String getDescripcion() {
		return titulo;
	}
	@Override
	public String toString() {
		return titulo;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public boolean compara(String compara) {
		return id==null?false:compara==null?false:id.equals(Integer.parseInt(compara));
	}
	
	public static I_Api_Errores sacaMensajeEf(String mensaje, I_Api_Errores def) {
		if(StringUtils.isEmpty(mensaje))
			return def;
		for(I_Api_Errores i:values()){
			if(mensaje.indexOf("Error "+i.id)!=-1)
				return i; 
		}
		return def;
	}
	
	public static I_Api_Errores sacaMensajeEf(BigInteger codigo,I_Api_Errores def) {
		if(codigo==null)
			return def;
		for(I_Api_Errores i:values()){
			if(codigo.intValue()==i.id)
				return i; 
		}
		
		return def;
	}
	
	public static String getTipo(Integer estatus,
			I_Api_Errores defaultnoencontrado) {
		final I_Api_Errores tipo = getTipo(estatus);
		if(tipo==null)
			return defaultnoencontrado.getDescripcion();
		return tipo.getDescripcion();
	}
	public static List<ApiError> catalogo() {
		final List<ApiError> res = new ArrayList<>();
		for(I_Api_Errores e:values()){
			res.add(new ApiError(e));
		}
		return res;
	}
	
	
}