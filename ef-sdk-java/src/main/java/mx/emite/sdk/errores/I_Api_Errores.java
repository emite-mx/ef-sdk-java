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
	NOMINA_101(101,"NOM101 - El atributo fecha no cumple con el patrón requerido","El atributo fecha, Debe cumplir con el patrón  (20[1-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])"), 
	NOMINA_102(102,"NOM102 - El atributo metodoDePago no tiene el valor \"NA\"","El atributo metodoDePago Debe tener el valor “NA”."),
	NOMINA_103(103,"NOM103 - El atributo noCertificado no cumple con el patron requerido","El atributo noCertificado, Debe cumplir con el patrón [0-9]{20}"),
	NOMINA_104(104,"NOM104 - El atributo Moneda, no cumple con el valor MXN","El atributo Moneda, Se debe registrar el valor MXN"),
	NOMINA_105(105,"NOM105 - El atributo TipoCambio no tiene el valor = \"1\".","El atributo TipoCambio puede omitirse pero si se incluye deberá tener el valor \"1\"."),
	NOMINA_106(106,"NOM106 - El valor del atributo subTotal no coincide con la suma de Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos.","El valor del atributo subTotal, debe registrar la suma de los atributos Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos"),
	NOMINA_107(107,"NOM107 - El valor de descuento no es igual a Nomina12:TotalDeducciones","El atributo descuento, debe registrar el valor del campo Nomina12:TotalDeducciones"),
	NOMINA_108(108,"NOM108 - El atributo total, no cumple con el patron requerido","El atributo total, Debe cumplir con el patrón [0-9]{1,18}(.[0-9]{1,2})?"),
	NOMINA_109(109,"NOM109 - El valor del atributo total no coincide con la suma Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos.menos Nomina12:TotalDeducciones","El atributo total, Debe ser igual a la suma de Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos menos Nomina12:TotalDeducciones"),
	NOMINA_110(110,"NOM110 - El atributo tipoDeComprobante no tiene el valor = “egreso”.","El atributo tipoDeComprobante El valor registrado debe ser “egreso”."),
	NOMINA_111(111,"NOM111 - El valor del atributo LugarExpedicion no cumple con un valor en c_CodigoPostal","El atributo LugarExpedicion, Debe cumplir con el patrón [0-9]{5} que indique el código postal del lugar de expedición del comprobante (domicilio de la matriz o de la sucursal) de acuerdo con el catálogo c_CodigoPostal que se publica en la página de internet del SAT"),
	NOMINA_112MD(112,"NOM112 - El atributo motivoDescuento no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOMINA_112NC(112,"NOM112 - El atributo NumCtaPago no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOMINA_112CP(112,"NOM112 - El atributo condicionesDePago no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOMINA_112SF(112,"NOM112 - El atributo SerieFolioFiscalOrig no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOMINA_112FF(112,"NOM112 - El atributo FechaFolioFiscalOrig no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOMINA_112MF(112,"NOM112 - El atributo MontoFolioFiscalOrig no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOMINA_113(113,"NOM113 - El atributo Nomina12:Emisor:Curp. no aplica para persona moral","Si el atributo Comprobante.Emisor.rfc contiene una longitud de 12 posiciones (RFC de persona moral), entonces no debe existir el atributo Nomina12:Emisor:Curp."),
	NOMINA_114(114,"NOM114 - El atributo Nomina12:Emisor:Curp. Debe aplicar para persona fisica","Si el atributo Comprobante.Emisor.rfc contiene una longitud de 13 posiciones (RFC de persona física), entonces debe existir el atributo Nomina12:Emisor:Curp"),
	NOMINA_115(115,"NOM115 - El nodo Subcontratacion se debe registrar","Si el atributo Comprobante.Emisor.rfc se encuentra registrado en el listado de RFC inscritos en el SAT con marca de subcontratación se debe registrar el nodo Subcontratacion"),
	NOMINA_116DF(116,"NOM116 - El elemento DomicilioFiscal no debe existir","Los elementos cfdi:Comprobante.Emisor.DomicilioFiscal y ExpedidoEn No deben existir."),
	NOMINA_116EE(116,"NOM116 - El elemento ExpedidoEn no debe existir","Los elementos cfdi:Comprobante.Emisor.DomicilioFiscal y ExpedidoEn No deben existir."),
	NOMINA_117(117,"NOM117 - Solo debe existir un solo nodo RegimenFiscal","El nodo cfdi:Comprobante.Emisor.Emisor.RegimenFiscal Debe existir, solo un nodo."),
	NOMINA_118(118,"NOM118 - El atributo Regimen no cumple con un valor en  c_RegimenFiscal.","El atributo Regimen, Debe contener una clave del catálogo c_RegimenFiscal publicado en la página del SAT, de acuerdo con el tipo de Persona del emisor, es decir, persona física si el RFC del emisor tiene 13 posiciones y persona moral si tiene 12."),
	NOMINA_119(119,"NOM119 - El atributo cfdi:Comprobante.Receptor.rfc debe ser persona física (13 caracteres).","El atributo cfdi:Comprobante.Receptor.rfc Debe ser de persona física."),
	
	NOMINA_120(120,"NOM120 - El atributo cfdi:Comprobante.Receptor.rfc no es válido según la lista de RFC inscritos no cancelados en el SAT (l_RFC).","El atributo cfdi:Comprobante.Receptor.rfc, El RFC debe estar en la lista de los RFC inscritos no cancelados en el SAT. (l_RFC)."),
	NOMINA_121(121,"NOM121 - El nodo Domicilio no debe existir","El nodo cfdi:Comprobante.Receptor.Domicilio, No debe existir"),
	NOMINA_122(122,"NOM122 - El nodo concepto solo debe existir uno, sin elementos hijo","El nodo cfdi:Comprobante.Conceptos.Concepto"),
	NOMINA_123(123,"NOM123 - El atributo cfdi:Comprobante.Conceptos.Concepto.noIdentificacion no debe existir","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.noIdentificacion, No debe registrarse"),
	NOMINA_124(124,"NOM124 - El atributo cfdi:Comprobante.Conceptos.Concepto.cantidad no tiene el valor =  “1”","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.cantidad, se debe registrar el valor “1”"),
	NOMINA_125(125,"NOM125 - El atributo cfdi:Comprobante.Conceptos.Concepto.unidad no tiene el valor =  “ACT”","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.unidad, debe registrar el valor “ACT”"),
	NOMINA_126(126,"NOM126 - El atributo cfdi:Comprobante.Conceptos.Concepto.descripcion,  no tiene el valor “Pago de nómina”","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.descripcion, debe registrar el valor “Pago de nómina”"),
	NOMINA_127(127,"NOM127 - El valor del atributo.cfdi:Comprobante.Conceptos.Concepto.valorUnitario no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.valorUnitario, Debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOMINA_128(128,"NOM128 - El valor del atributo.cfdi:Comprobante.Conceptos.Concepto.Importe no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.Importe, Debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOMINA_129(129,"NOM129 - El nodo cfdi:Comprobante.Impuestos no cumple la estructura","El nodo cfdi:Comprobante.Impuestos Se debe registrar como <Impuestos/> o <Impuestos></Impuestos>"),
	//SOLO PARA CFDI 3.3
	NOMINA_130(130,"NOM130 - El atributo Moneda no tiene el valor =  “MXN”","Si versión del CFDI = 3.3 entonces en el atributo Moneda debe registrar el valor MXN"),
	NOMINA_131(131,"NOM131 - El atributo FormaPago no tiene el valor =  99","Si versión del CFDI = 3.3 entonces en el atributo FormaPago, debe tener la clave 99 que corresponde a la descripción “Por definir”."),
	NOMINA_132(132,"NOM132 - El atributo TipoDeComprobante no tiene el valor =  “Nómina”","Si versión del CFDI = 3.3 entonces en el atributo TipoDeComprobante, El valor registrado debe ser la clave N que corresponde a  “Nómina”"),
	NOMINA_133(133,"NOM133 - El atributo Nomina12:Emisor:Curp, no aplica para persona moral","Si versión del CFDI = 3.3 y el atributo Comprobante.Emisor.rfc, tiene longitud 12 (RFC de persona moral), entonces  no debe existir el atributo Nomina12:Emisor:Curp,"),
	NOMINA_134(134,"NOM134 - El atributo Nomina12:Emisor:Curp, debe aplicar para persona fisica","Si versión del CFDI = 3.3 y el atributo Comprobante.Emisor.rfc tiene longitud 13, el atributo Nomina12:Emisor:Curp, debe existir"),
	NOMINA_135(135,"NOM135 - El atributo Comprobante.Receptor.rfc, debe ser de longitud 13","Si versión del CFDI = 3.3 y el atributo Comprobante.Receptor.rfc debe ser persona fisica"),
	NOMINA_136(136,"NOM136 - El atributo Comprobante.Receptor.rfc, no está en la lista de RFC inscritos no cancelados en el SAT (l_RFC).","Si versión del CFDI = 3.3 y el atributo Comprobante.Receptor.rfc debe estar en la lista de RFC inscritos no cancelados en el SAT (l_RFC)."),
	NOMINA_137(137,"NOM137 - El nodo Comprobante.Conceptos.Concepto, Solo puede registrarse un nodo concepto, sin elementos hijo.","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto, debe registrar solo un nodo concepto sin elementos hijo."),
	NOMINA_138(138,"NOM138 - El atributo Comprobante.Conceptos.Concepto,ClaveProdServ no tiene el valor =  “84111505”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,ClaveProdServ debe registrar el valor 84111505"),
	NOMINA_139(139,"NOM139 - El atributo Comprobante.Conceptos.Concepto,NoIdentificacion, no debe existir","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,NoIdentificacion, No debe registrarse"),
	NOMINA_140(140,"NOM140 - El atributo Comprobante.Conceptos.Concepto,Cantidad no tiene el valor =  “1”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Cantidad debe registrar el valor “1”"),
	NOMINA_141(141,"NOM141 - El atributo Comprobante.Conceptos.Concepto,ClaveUnidad no tiene el valor =  “ACT”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,ClaveUnidad debe registrar el valor “ACT”"),
	NOMINA_142(142,"NOM142 - El atributo Comprobante.Conceptos.Concepto,Unidad, no debe existir","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Unidad No debe registrarse"),
	NOMINA_143(143,"NOM143 - El atributo Comprobante.Conceptos.Concepto,Descripcion no tiene el valor =  “Pago de nómina”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Descripcion debe registrar el valor “Pago de nómina”"),
	NOMINA_144(144,"NOM144 - El valor del atributo Comprobante.Conceptos.Concepto,ValorUnitario no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,ValorUnitario debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOMINA_145(145,"NOM145 - El valor del atributo Comprobante.Conceptos.Concepto,Importe no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Importe debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOMINA_146(146,"NOM146 - El valor del atributo Comprobante.Conceptos.Concepto,Descuento no es igual a el valor del campo Nomina12:TotalDeducciones","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Descuento debe registrar el valor del campo Nomina12:TotalDeducciones"),
	NOMINA_147(147,"NOM147 - El nodo Comprobante.Impuestos, no debe existir","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Impuestos. no se debe registrar "),
	//FIN CFDI 3.3
	NOMINA_148(148,"NOM148 - El nodo Nomina no se puede utilizar dentro del elemento ComplementoConcepto. ","El nodo Nomina se debe registrar como un nodo hijo del nodo Complemento en el CFDI."),
	NOMINA_149(149,"NOM149 - El nodo Nomina no tiene TotalPercepciones y/o TotalOtrosPagos","El nodo Nomina debe existir el atributo TotalPercepciones o TotalOtrosPagos, o ambos."),
	NOMINA_150(150,"NOM150 - El valor del atributo Nomina.TipoNomina no está en catálogo c_TipoNomina","El atributo Nomina.TipoNomina debe ser una clave del catálogo c_TipoNomina"),
	NOMINA_151(151,"NOM151 - El valor del atributo tipo de periodicidad no se encuentra entre 01 al 09","Si el atributo Nomina.TipoNomina es ordinaria el tipo de periodicidad de pago debe ser del 01 al 09"),
	NOMINA_152(152,"NOM152 - El valor del atributo tipo de periodicidad no es 99","Si el atributo Nomina.TipoNomina es extraordinaria el tipo de periodicidad de pago debe ser 99."),
	NOMINA_153(153,"NOM153 - El valor del atributo FechaInicialPago no es menor o igual al valor del atributo FechaFinalPago.","El atributo Nomina.FechaInicialPago  debe ser menor o igual al valor del atributo FechaFinalPago."),
	NOMINA_154(154,"NOM154 - El valor del atributo Nomina.FechaFinalPago no es mayor o igual al valor del atributo FechaInicialPago.","El atributo Nomina.FechaFinalPago debe ser mayor o igual al valor del atributo FechaInicialPago."),
	NOMINA_155(155,"NOM155 - El atributo Nomina.TotalPercepciones, no debe existir","Si el nodo percepciones no existe, el atributo Nomina.TotalPercepciones no debe existir."),
	NOMINA_156(156,"NOM156 - El valor del atributo Nomina.TotalPercepciones no coincide con la suma TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro del  nodo Percepciones.","Si el nodo percepciones existe, el valor de Nomina.TotalPercepciones debe ser igual a la suma de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro del  nodo Percepciones."),
	NOMINA_157(157,"NOM157 - El atributo Nomina.TotalDeducciones, no debe existir","Si el nodo Deducciones no existe, el valor de Nomina.TotalDeducciones , no debe existir."),
	NOMINA_158(158,"NOM158 - El valor del atributo Nomina.TotalDeducciones no coincide con la suma de los atributos TotalOtrasDeducciones más TotalImpuestosRetenidos del elemento Deducciones.","Si el nodo Deducciones existe, el valor de Nomina.TotalDeducciones debe ser igual a la suma de los atributos TotalOtrasDeducciones más TotalImpuestosRetenidos del elemento Deducciones."),
	NOMINA_159(159,"NOM159 - El valor del atributo Nomina.TotalOtrosPagos no coincide con la suma de los atributos Importe de los nodos nomina12:OtrosPagos:OtroPago","Si el nodo OtrosPagos existe, el valor de Nomina.TotalOtrosPagos debe ser igual a la suma de los atributos Importe de los nodos nomina12:OtrosPagos:OtroPago"),
	NOMINA_160(160,"NOM160 - El atributo Nomina.Emisor.RfcPatronOrigen no está inscrito en el SAT (l_RFC)","El atributo Nomina.Emisor.RfcPatronOrigen debe estar inscrito no cancelado en el SAT (l_RFC)"),
	NOMINA_161(161,"NOM161 - El atributo Nomina.Emisor.RegistroPatronal no existe","Si atributo TipoContrato esstá entre  01 al 08, el atributo Nomina.Emisor.RegistroPatronal debe existir"),
	NOMINA_162(162,"NOM162 - Uno de los atributos nomina12:Receptor: NumSeguridadSocial,  nomina12:Receptor:FechaInicioRelLaboral, nomina12:Receptor:Antigüedad,  nomina12:Receptor:RiesgoPuesto y nomina12:Receptor:SalarioDiarioIntegrado no existen","Si atributo Nomina.Emisor.RegistroPatronal existe entonce deben existir los atributos nomina12:Receptor: NumSeguridadSocial,  nomina12:Receptor:FechaInicioRelLaboral, nomina12:Receptor:Antigüedad,  nomina12:Receptor:RiesgoPuesto y nomina12:Receptor:SalarioDiarioIntegrado"),
	NOMINA_163(163,"NOM163 - El nodo Nomina.Emisor.EntidadSNCF no existe y se espera porque tiene la marca de estar adherido al SNCF.","Si el RFC del emisor existe en el listado de RFC inscritos no cancelados en el SAT (l_RFC) con marca de unidad adherida al Sistema Nacional de Coordinación Fiscal, El nodo Nomina.Emisor.EntidadSNCF debe existir "),
	NOMINA_164(164,"NOM164 - El valor del atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso no está en catálogo c_OrigenRecurso","El atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso debe ser una clave del catálogo c_OrigenRecurso publicado en el portal del SAT en internet."),
	NOMINA_165(165,"NOM165 - El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio debe existir","El atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso Si el valor registrado corresponde a la clave IM (Ingresos Mixtos), el atributo MontoRecursoPropio debe existir."),
	NOMINA_166(166,"NOM166 - El valor del atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio no es menor a la suma de los valores de los atributos TotalPercepciones y TotalOtrosPagos. ","El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio debe ser menor que la suma de los valores de los atributos TotalPercepciones y TotalOtrosPagos. "),
	NOMINA_167(167,"NOM167 - El valor del atributo Nomina.Receptor.TipoContrato no está en catálogo c_TipoContrato","El atributo Nomina.Receptor.TipoContrato debe ser una clave del catálogo c_TipoContrato publicado en el portal del SAT en internet."),
	NOMINA_168(168,"NOM168 - El valor del atributo Nomina.Receptor.TipoJornada no está en catálogo c_TipoJornada","El atributo Nomina.Receptor.TipoJornada debe ser una clave del catálogo de c_TipoJornada publicado en el portal del SAT en internet."),
	NOMINA_169(169,"NOM169 - El valor del atributo Nomina.Receptor.FechaInicioRelLaboral no es menor o igual al atributo a FechaFinalPago.","El atributo Nomina.Receptor.FechaInicioRelLaboral, debe ser menor o igual al atributo FechaFinalPago."),
	NOMINA_170(170,"NOM170 - El valor numerico del atributo Nomina.Receptor.Antigüedad no es menor o igual al cociente de (la suma del número de días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago más uno) dividido entre siete","Si el atributo Nomina.Receptor.Antigüedad cumple con el patrón P[1-9][0-9]{0,3}W, entonces el valor numérico del atributo Nomina.Receptor.Antigüedad, debe ser menor o igual al cociente de (la suma del número de días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago más uno) dividido entre siete"),
	NOMINA_171(171,"NOM171 - El valor del atributo Nomina.Receptor.Antigüedad. no cumple con el número de años, meses y días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago.","Si el atributo Nomina.Receptor.Antigüedad no cumple con el patrón P[1-9][0-9]{0,3}W, entonces el valor registrado debe corresponder con el número de años, meses y días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago."),
	NOMINA_172(172,"NOM172 - El valor del atributo Nomina.Receptor.TipoRegimen no está en catálogo c_TipoRegimen","El atributo Nomina.Receptor.TipoRegimen debe ser una clave del catálogo de c_TipoRegimen publicado en el portal del SAT en internet. "),
	NOMINA_173(173,"NOM173 - El atributo Nomina.Receptor.TipoRegimen no es 02, 03 ó 04.","Si el atributo TipoContrato tiene una clave entre los valores 01 y 08 del catálogo c_TipoContrato entonces el atributo Nomina.Receptor.TipoRegimen debe ser 02, 03 ó 04."),
	NOMINA_174(174,"NOM174 - El atributo Nomina.Receptor.TipoRegimen no está entre 05 a 09.","Si el atributo TipoContrato tiene un valor 09 ó superior entonces el atributo Nomina.Receptor.TipoRegimen debe ser 05 hasta el 99."),
	NOMINA_175(175,"NOM175 - El valor del atributo Nomina.Receptor.RiesgoPuesto no está en catálogo c_RiesgoPuesto","El atributo RiesgoPuesto debe ser una clave del catálogo de c_RiesgoPuesto publicado en el portal del SAT en internet."),
	NOMINA_176(176,"NOM176 - El valor del atributo Nomina.Receptor.PeriodicidadPago no está en catálogo c_PeriodicidadPago","El atributo PeriodicidadPago debe ser una clave del catálogo de c_PeriodicidadPago publicado en el portal del SAT en internet."),
	NOMINA_177(177,"NOM177 - El valor del atributo Nomina.Receptor.Banco no está en catálogo c_Banco","El atributo Banco debe ser una clave del catálogo de c_Banco publicado en el portal del SAT en internet."),
	NOMINA_178(178,"NOM178 - El atributo CuentaBancaria no cumple con la longitud de 10, 11, 16 ó 18 posiciones.","El atributo CuentaBancaria debe tener una longitud de 10, 11, 16 ó 18 posiciones."),
	NOMINA_179(179,"NOM179 - El nodo Banco no debe existir","Si se registra una cuenta CLABE (número con 18 posiciones), el atributo Banco no debe existir."),
	NOMINA_180(180,"NOM180 - El dígito de control debe ser correcto cuando ingresan una CLABE.","Si se registra una cuenta CLABE (número con 18 posiciones), Se debe confirmar que el dígito de control es correcto"),
	NOMINA_181(181,"NOM181 - El nodo Banco debe existir","Si se registra una cuenta de tarjeta de débito a 16 posiciones o una cuenta bancaria a 11 posiciones o un número de teléfono celular a 10 posiciones, debe existir el banco."),
	NOMINA_182(182,"NOM182 - El valor del atributo ClaveEntFed no es una clave del catálogo de c_Estado, donde la clave de país es MEX.","El valor del atributo ClaveEntFed debe ser una clave del catálogo de c_Estado, donde la clave de país es MEX."),
	NOMINA_183(183,"NOM183 - El valor del atributo Nomina.Receptor.SubContratacion.RfcLabora no está en la lista de RFC (l_RFC).","El valor del atributo Nomina.Receptor.SubContratacion.RfcLabora debe existir en la lista de RFC inscritos no cancelados en el SAT (l_RFC)."),
	NOMINA_184(184,"NOM184 - El valor de Nomina.Receptor.SubContratacion.PorcentajeTiempo no es igual a 100","El valor del atributo Nomina.Receptor.SubContratacion.PorcentajeTiempo La suma de los valores PorcentajeTiempo registrados debe ser igual a 100."),
	NOMINA_185(185,"NOM185 - La suma de los valores de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro no es igual a la suma de los valores de los atributos TotalGravado más TotalExento.","En el elemento Nomina.Percepciones , La suma de los valores de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro debe ser igual a la suma de los valores de los atributos TotalGravado más TotalExento."),
	NOMINA_186(186,"NOM186 - El valor del atributo Nomina.Percepciones.TotalSueldos , no es igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave expresada en el atributo TipoPercepcion es distinta de 022 Prima por Antigüedad, 023 Pagos por separación, 025 Indemnizaciones, 039 Jubilaciones, pensiones o haberes de retiro en una exhibición y 044 Jubilaciones, pensiones o haberes de retiro en parcialidades.","El valor del atributo Nomina.Percepciones.TotalSueldos , debe ser igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave expresada en el atributo TipoPercepcion sea distinta de 022 Prima por Antigüedad, 023 Pagos por separación, 025 Indemnizaciones, 039 Jubilaciones, pensiones o haberes de retiro en una exhibición y 044 Jubilaciones, pensiones o haberes de retiro en parcialidades."),
	NOMINA_187(187,"NOM187 - El valor del atributo Nomina.Percepciones.TotalSeparacionIndemnizacion, no es igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave en el atributo TipoPercepcion es igual a 022 Prima por Antigüedad, 023 Pagos por separación ó 025 Indemnizaciones.","El valor del atributo Nomina.Percepciones.TotalSeparacionIndemnizacion, debe ser igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave expresada en el atributo TipoPercepcion sea igual a 022 Prima por Antigüedad, 023 Pagos por separación ó 025 Indemnizaciones."),
	NOMINA_188(188,"NOM188 - El valor del atributo Nomina.Percepciones.TotalJubilacionPensionRetiro, no es igual a la suma de los atributos ImporteGravado e importeExento donde la clave expresada en el atributo TipoPercepcion es igual a 039(Jubilaciones, pensiones o haberes de retiro en una exhibición)  ó 044 (Jubilaciones, pensiones o haberes de retiro en parcialidades).","El valor del atributo Nomina.Percepciones.TotalJubilacionPensionRetiro, debe ser igual a la suma de los atributos ImporteGravado e importeExento donde la clave expresada en el atributo TipoPercepcion sea igual a 039(Jubilaciones, pensiones o haberes de retiro en una exhibición)  ó 044 (Jubilaciones, pensiones o haberes de retiro en parcialidades)."),
	NOMINA_189(189,"NOM189 - El valor del atributo Nomina.Percepciones.TotalGravado, no es igual a la suma de los atributos ImporteGravado de los nodos Percepcion.","El valor del atributo Nomina.Percepciones.TotalGravado, debe ser igual a la suma de los atributos ImporteGravado de los nodos Percepcion."),
	NOMINA_190(190,"NOM190 - El valor del atributo Nomina.Percepciones.TotalExento, no es igual a la suma de los atributos ImporteExento de los nodos Percepcion.","El valor del atributo Nomina.Percepciones.TotalExento, debe ser igual a la suma de los atributos ImporteExento de los nodos Percepcion."),
	NOMINA_191(191,"NOM191 - Los importes de los atributos ImporteGravado e ImporteExento no es mayor que cero.","El valor del atributo Nomina.Percepciones.Percepcion.ImporteGravado, Los importes de los atributos ImporteGravado e ImporteExento debe ser mayor que cero."),
	NOMINA_192(192,"NOM192 - El valor del atributo Nomina.Percepciones.Percepcion.TipoPercepcion no es una clave del catálogo de c_TipoPercepcion, donde la clave de país es MEX.","El valor del atributo Nomina.Percepciones.Percepcion.TipoPercepcion, debe ser una clave del catálogo de c_TipoPercepcion publicado en el portal del SAT en internet."),
	NOMINA_193(193,"NOM193 - El valor de TipoPercepcion no está en el catálogo c_TipoPercepcion","El atributo TipoPercepcion debe ser una clave del catálogo de c_TipoPercepcion publicado en el portal del SAT en internet."),
	NOMINA_194(194,"NOM194 - TotalSueldos, debe existir. Ya que la clave expresada en TipoPercepcion es distinta de 022, 023, 025, 039 y 044","El atributo TipoPercepcion: si la clave expresada es distinta de 022, 023, 025, 039 y 044, debe existir el atributo TotalSueldos"),
	NOMINA_195(195,"NOM195 - TotalSueldos, no debe existir. Ya que la clave expresada en TipoPercepcion es 022, 023, 025, 039 y 044","El atributo TipoPercepcion: si la clave expresada es 022, 023, 025, 039 y 044, no debe existir el atributo TotalSueldos, "),
	NOMINA_196(196,"NOM196 - TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion, debe existir. Ya que la clave expresada en TipoPercepcion es 022 ó 023 ó 025","Si la clave expresada en el atributo TipoPercepcion es 022 ó 023 ó 025, debe existir el atributo TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion"),
	NOMINA_197(197,"NOM197 - TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion, no debe existir. Ya que la clave expresada en TipoPercepcion no es 022 ó 023 ó 025","Si la clave expresada en el atributo TipoPercepcion no es 022 ó 023 ó 025, no debe existir el atributo TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion, "),
	NOMINA_198(198,"NOM198 - TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro debe existir,  ya que la clave expresada en el atributo TipoPercepcion es 039 ó 044,","Si la clave expresada en el atributo TipoPercepcion es 039 ó 044, debe existir el atributo TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro, en caso contrario no deben existir."),
	NOMINA_199(199,"NOM199 - TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro  no debe existir,  ya que la clave expresada en el atributo TipoPercepcion no es 039 ó 044,","Si la clave expresada en el atributo TipoPercepcion no es 039 ó 044, no debe existir el atributo TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro, en caso contrario no deben existir."),
	NOMINA_200(200,"NOM200 - TotalUnaExhibicion debe existir y no deben existir TotalParcialidad, MontoDiario. Ya que la clave expresada en el atributo TipoPercepcion es 039.","Si la clave expresada en el atributo TipoPercepcion es 039 debe existir TotalUnaExhibicion, no deben existir TotalParcialidad, MontoDiario."),
	NOMINA_201(201,"NOM201 - TotalUnaExhibicion no debe existir y deben existir TotalParcialidad, MontoDiario. Ya que la clave expresada en el atributo TipoPercepcion es 044.","Si la clave expresada en el atributo TipoPercepcion es 044 no debe existir TotalUnaExhibicion, deben existir TotalParcialidad, MontoDiario."),
	NOMINA_202(202,"NOM202 - El elemento AccionesOTitulos debe existir. Ya que la clave expresada en el atributo TipoPercepcion es 045.","Si la clave expresada en el atributo TipoPercepcion es 045, debe existir el elemento AccionesOTitulos, en caso contrario no debe existir.	"),
	NOMINA_203(203,"NOM203 - El elemento AccionesOTitulos no debe existir. Ya que la clave expresada en el atributo TipoPercepcion no es 045.","Si la clave expresada en el atributo TipoPercepcion no es 045, no debe existir el elemento AccionesOTitulos"),
	NOMINA_204(204,"NOM204 - El elemento HorasExtra, debe existir. Ya que la clave expresada en el atributo TipoPercepcion es 019.","Si la clave expresada en el atributo TipoPercepcion es 019, debe existir el elemento HorasExtra, en caso contrario no debe existir."),
	NOMINA_205(205,"NOM205 - El elemento HorasExtra, no debe existir. Ya que la clave expresada en el atributo TipoPercepcion no es 019.","Si la clave expresada en el atributo TipoPercepcion no es 019, no debe existir el elemento HorasExtra."),
	NOMINA_206(206,"NOM206 - El nodo Incapacidades debe existir y la suma de los campos ImporteMonetario debe ser igual a la suma de los valores ImporteGravado e ImporteExento de la percepción, Ya que la clave expresada en el atributo TipoPercepcion es 014.","Si la clave expresada en el atributo TipoPercepcion es 014 el nodo Incapacidades debe existir y la suma de los campos ImporteMonetario debe ser igual a la suma de los valores ImporteGravado e ImporteExento de la percepción."),
	NOMINA_207(207,"NOM207 - La suma de los campos ImporteMonetario debe ser igual a la suma de los valores ImporteGravado e ImporteExento de la percepción, Ya que la clave expresada en el atributo TipoPercepcion es 014.","Si la clave expresada en el atributo TipoPercepcion es 014 la suma de los campos ImporteMonetario debe ser igual a la suma de los valores ImporteGravado e ImporteExento de la percepción."),
	NOMINA_208(208,"NOM208 - El nodo TipoHoras Nomina.Percepciones.Percepcon.HorasExtra.TipoHoras no es una clave del catálogo de c_TipoHoras","El nodo TipoHoras Nomina.Percepciones.Percepcon.HorasExtra.TipoHoras debe ser una clave del catálogo de c_TipoHoras publicado en el portal del SAT en internet."),
	NOMINA_209(209,"NOM209 - Los atributos MontoDiario y TotalParcialidad no existen, ya que existe valor en TotalUnaExhibicion","Si existe valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalUnaExhibicion los atributos MontoDiario y TotalParcialidad no deben existir."),
	NOMINA_210(210,"NOM210 - El atributo MontoDiario debe existir y el atributo TotalUnaExhibicion no debe existir, ya que Nomina.Percepciones.JubilacionPensionRetiro.TotalParcialidad tiene valor","Si existe valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalParcialidad el atributo MontoDiario debe existir y el atributo TotalUnaExhibicion no debe existir."),
	NOMINA_211(211,"NOM211 - El valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalImpuestosRetenidos no es igual a la suma de los atributos Importe de las deducciones que tienen expresada la clave 002 en el atributo TipoDeduccion.","El valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalImpuestosRetenidos debe ser igual a la suma de los atributos Importe de las deducciones que tengan expresada la clave 002 en el atributo TipoDeduccion."),
	NOMINA_212(212,"NOM212 - Nomina.Percepciones.JubilacionPensionRetiro.TotalImpuestosRetenidos no debe existir ya que no existen deducciones con clave 002 en el atributo TipoDeduccion.","Si no existen deducciones con clave 002, el valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalImpuestosRetenidos no debe existir"),
	NOMINA_213(213,"NOM213 - El valor de Nomina.Deducciones.Deduccion.TipoDeduccion no es una clave del catálogo de c_TipoDeduccion","El valor de Nomina.Deducciones.Deduccion.TipoDeduccion debe ser una clave del catálogo de c_TipoDeduccion publicado en el portal del SAT en internet.	Cuando la clave expresada en este atributo sea 006, debe existir el elemento Incapacidades y el atributo Deduccion:Importe debe ser igual a la suma de los nodos Incapacidad:ImporteMonetario."),
	NOMINA_214(214,"NOM214 - Debe existir el elemento Incapacidades y el atributo Deduccion:Importe debe ser igual a la suma de los nodos Incapacidad:ImporteMonetario.	Ya que la clave expresada en Nomina.Deducciones.Deduccion.TipoDeduccion es 006","Si la clave expresada en Nomina.Deducciones.Deduccion.TipoDeduccion es 006, debe existir el elemento Incapacidades y el atributo Deduccion:Importe debe ser igual a la suma de los nodos Incapacidad:ImporteMonetario."),
	NOMINA_215(215,"NOM215 - Nomina.Deducciones.Deduccion.Importe no es mayor que cero.","NOMINA.Deducciones.Deduccion.Importe Debe ser mayor que cero."),
	NOMINA_216(216,"NOM216 - Nomina.OtrosPagos.OtroPago.TipoOtroPago debe no es una clave del catálogo de c_TipoOtroPago ","NOMINA.OtrosPagos.OtroPago.TipoOtroPago debe ser una clave del catálogo de c_TipoOtroPago publicado en el portal del SAT en internet. Si el valor de este atributo es 004 es obligatorio el nodo CompensacionSaldosAFavor. Si el valor de este atributo es 002 es obligatorio el nodo SubsidioAlEmpleo."),
	NOMINA_217(217,"NOM217 - El nodo CompensacionSaldosAFavor. dexistir, ya que el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 004","Si el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 004 es obligatorio el nodo CompensacionSaldosAFavor."),
	NOMINA_218(218,"NOM218 - El nodo SubsidioAlEmpleo. debe existir, ya que el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 002","Si el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 002 es obligatorio el nodo SubsidioAlEmpleo."),
	NOMINA_219(219,"NOM219 - Nomina.OtrosPagos.OtroPago.Importe no es ayor que cero","Nomina.OtrosPagos.OtroPago.Importe Debe ser mayor que cero"),
	NOMINA_220(220,"NOM220 - Nomina.OtrosPagos.OtroPago.SubsidioAlEmpleo.SubsidioCausado no es mayor o igual que el valor del atributo Importe”del nodo OtroPago","Nomina.OtrosPagos.OtroPago.SubsidioAlEmpleo.SubsidioCausado debe ser mayor o igual que el valor del atributo Importe”del nodo OtroPago"),
	NOMINA_221(221,"NOM221 - Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.SaldoAFavor no es mayor o igual que el valor del atributo CompensacionSaldosAFavor:RemanenteSalFav","Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.SaldoAFavor debe ser mayor o igual que el valor del atributo CompensacionSaldosAFavor:RemanenteSalFav"),
	NOMINA_222(222,"NOM222 - Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.Año  no es menor que el año en curso.","Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.Año debe ser menor que el año en curso."),
	NOMINA_223(223,"NOM223 - Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.TipoIncapacidad no es una clave del catálogo de c_TIpoIncapacidad","Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.TipoIncapacidad debe ser una clave del catálogo de c_TIpoIncapacidad publicado en el portal del SAT en internet."),
	;
	
	
	private Integer id;
	 
	private String titulo;
	private String mensaje;
		
	I_Api_Errores(Integer val,String titulo){
		this(val,titulo,null);
	}
	
	I_Api_Errores(Integer val,String titulo,String mensaje){
		this.id=val;
		this.titulo=titulo;
		this.mensaje=mensaje;
		
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
	
	public String getMensaje() {
		return mensaje;
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