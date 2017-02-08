package mx.emite.sdk.errores;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;




public enum I_Api_Errores {
	
	OK(0,"OK"),
	CANCELADOR_CFDI_EXITOSAMENTE(201,"UUID Cancelado exitosamente"),
	CANCELADOR_CFDI_PREVIAMENTE_CANCELADO(202,"UUID Previamente cancelado"),
	CANCELADOR_CFDI_UUIDNOCORRESPONDE(203,"UUID No corresponde el RFC del emisor y de quien solicita la cancelación."),
	CANCELADOR_CFDI_NOEXISTE(205,"UUID No existe"),
	CANCELADOR_CFDI_USUARIOINVALIDO(210,"El usuario con el que se quiere conectar es inválido"),
	CANCELADOR_CFDI_XMLMALFORMADO(211,"XML mal formado"),
	CANCELADOR_CFDI_TOKEN(250,"Error al consultar Token de Cancelación"),
	TIMBRADOR_VALIDACIONXSD(301,"Error de estructura (validando el XML contra el XSD)"),
	TIMBRADOR_SELLOINVALIDO(302,"El sello de emisor no es válido"),
	TIMBRADOR_EMISORCSD(303,"El rfc del CSD no corresponde al rfc del emisor del comprobante"),
	TIMBRADOR_LCO_REVOCADO(304,"El CSD del emisor ha sido revocado o no se encuentra en la lista de contribuyentes."),
	TIMBRADOR_CSDVIGENCIA(305,"La fecha de emisión no esta dentro de la vigencia del CSD del emisor"),
	TIMBRADOR_CSDFIEL(306,"El certificado corresponde a una FIEL. Debe utilizar un CSD."),
	TIMBRADOR_TIMBREPREVIO(307,"El CFDI contiene un timbre previo"),
	TIMBRADOR_VALIDACIONCERTIFICADO(308,"Error validando certificado de emisor"),
	TIMBRADOR_CSDAPOCRIFO(309,"El CSD del emisor no fue firmado por los certificados de autoridad del SAT"),
	TIMBRADOR_CERTIFICADO_INVALIDO(310,"El CFDI contiene un certificado inválido"),
	TIMBRADOR_XMLINVALIDO(349,"El documento no es un XML válido"),
	TIMBRADOR_SERVICIONODISPONIBLE(350,"Servicio temporalmente fuera de servicio"),
	TIMBRADOR_HSM(351,"Error en consumo de HSM"),
	TIMBRADOR_ENVIANDOCOMPROBANTE(352,"Error al enviar el comprobante al SAT"),
	TIMBRADOR_VALIDACIONFECHA(401,"El rango de la fecha de generación no puede ser mayor a 72 horas"),
	TIMBRADOR_LCO(402,"El certificado no se encuentra en la LCO"),
	TIMBRADOR_EMISOR_REGIMEN(403,"El RFC del emisor no tiene régimen autorizado"),
	TIMBRADOR_FECHA2011(404,"La fecha de emisión no es posterior al 01 de enero 2011"),
	TIMBRADOR_AUTENTICACION(501,"Autenticación no válida."),
	TIMBRADOR_NOENCONTRADO(502,"Comprobante no encontrado."),
	TIMBRADOR_METADATOS(503,"Los metadatos recibidos no son válidos."),
	TIMBRADOR_ESTRUCTURA(504,"La estructura del comprobante recibido no es válida."),
	TIMBRADOR_METADATOS_EMISOR(505,"Los metadatos proporcionados no corresponden al emisor."),
	TIMBRADOR_PREVIAMENTE_TIMBRADO(506,"Comprobante timbrado anteriormente"),
	TIMBRADOR_PREVIAMENTE_CANCELADO(507,"Comprobante previamente cancelado"),
	TIMBRADOR_INFORMACION_INVALIDA(601,"La información para buscar el comprobante no es válida."),
	TIMBRADOR_CFDI_NOEXISTE(602,"Comprobante que se desea descargar no existe."),
	TIMBRADOR_LRFC_GUARDANDO(603,"Guardando LRFC en Base de Datos"),
	TIMBRADOR_LCO_GUARDANDO(604,"Guardando LCO en Base de Datos"),
	TIMBRADOR_PAC_GUARDANDO(605,"Guardando Certificado PAC en Base de Datos"),
	TIMBRADOR_TOKEN(606,"Error obteniendo token del SAT"),
	TIMBRADOR_RFCNOENLRFC(607,"El rfc no se encuentra en la lRfc"),
	
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
	CONNECT_DATOSINSUFICIENTES(2010,"Datos insuficientes"),
	CONNECT_CONFIGURACION(2011,"Error en configuración"),
	CONNECT_TIMBRANDO(2012,"Error al timbrar"),
	VALIDADOR_SINTIMBRE(3001,"El comprobante no contiene TimbreFiscal"),
	VALIDADOR_PROCESANDOXML(3002,"Error al leer el XML"),
	VALIDADOR_SELLOINVALIDO(3003,"Sello del comprobante inválido"),
	VALIDADOR_CERTIFICADO(3004,"Error validando certificado emisor"),
	VALIDADOR_CERTIFICADOSAT(3005,"Error al recuperar certificado de PAC"),
	VALIDADOR_SELLOPACINVALIDO(3006,"Sello del pac inválido"),
	VALIDADOR_CONSULTANDOSAT(3007,"Servicio de Consulta del SAT no disponible"),
	VALIDADOR_CFDINOEXISTESAT(3008,"El uuid no esta registrado ante el SAT"),
	VALIDADOR_CFDINOESTAVIGENTESAT(3009,"El uuid no esta vigente ante el SAT"),
	VALIDADOR_GENERANDOPDF(3010,"Error al generar el pdf de validación"),
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
	CLIENTE_REQUEST_INVALIDO(5100,"Petición inválida"),
	CLIENTE_TOKEN_INVALIDO(5101,"Token inválido"),
	CLIENTE_TOKEN_EXPIRADO(5102,"Token expirado"),
	CLIENTE_TOKEN_TIPOUSUARIO(5103,"Token pertenece a un tipo de usuario incorrecto"),
	CLIENTE_TOKEN_INTEGRADOR_INEXISTENTE(5104,"El usuario integrador no existe"),
	CLIENTE_TOKEN_INTEGRADOR_CONTRASENA(5105,"La contraseña del integrador es incorrecta"),
	CLIENTE_TOKEN_INTEGRADOR_DESHABILITADO(5106,"El integrador se encuentra deshabilitado"),
	CLIENTE_TOKEN_INTEGRADOR_GENERANDO(5107,"Error interno generando token"),
	CLIENTE_EMISOR_INVALIDO(5108,"El rfc del emisor difiere de las credenciales proporcionadas"),
	CLIENTE_XML_YATIMBRADO(5109,"El xml ya se encuentra timbrado"),
	CLIENTE_XML_BASE64(5110,"El xml enviado no esta expresado en Base64"),
	CLIENTE_XML_INVALIDO(5111,"El documento enviado no es un archivo XML válido"),
	CLIENTE_XML_TIPO_NOSOPORTADO(5112,"El tipo de documento aún no es soportado"),
	CLIENTE_XML_INFO_NOENCONTRADO(5113,"No se encontro uno de los campos en el documento"),
	CLIENTE_XML_UUID_INVALIDO(5114,"El uuid enviado no corresponde al uuid que contiene el XML"),
	CLIENTE_XML_SERIE_INVALIDO(5115,"La serie enviada no corresponde a la serie que contiene el XML"),
	CLIENTE_XML_FOLIO_INVALIDO(5116,"El folio enviado no corresponde al folio que contiene el XML"),
	CLIENTE_XML_FECHA_INVALIDO(5117,"La fecha enviada no corresponde a la fecha que contiene el XML"),
	CLIENTE_XML_TOTAL_INVALIDO(5118,"El total enviado no corresponde a el total que contiene el XML"),
	CLIENTE_CSD_CER_INVALIDO(5119,"El certificado público .cer, no puede ser leido"),
	CLIENTE_CSD_KEY_INVALIDO(5120,"El certificado privado .key, no puede ser leido"),
	CLIENTE_REQUEST_ZIP(5121,"El archivo zip esta dañado"),
	CLIENTE_PLANTILLA_INVALIDA(5122,"La plantilla solicitada no existe"),
	CLIENTE_XML_MALFORMADO(5123,"El documento enviado es un documento XML mal formado"),
	PSRDD_TIMBRANDO(6001,"Error al timbrar comprobante"),
	PROXY_SERVICIO_NODISPONIBLE(9001,"Servicio no disponible"),
	PROXY_PROCESANDO_RESPUESTA(9002,"Procesando respuesta"),
	PROXY_DESERIALIZANDO(9003,"Deserializando objeto"),
	PROXY_SERIALIZANDO(9004,"Serializando objeto"),
	PROXY_DECODIFICANDO(9005,"Decodificando cadena en Base64"),
	PROXY_CODIFICANDO(9006,"Codificando cadena a Base64"),
	PROXY_LEYENDO_ARCHIVO(9007,"Error al leer el archivo"),
	PROXY_GUARDANDOARCHIVO(9008,"Guardando archivo"),
	PROXY_TIMBRANDO(9040,"Error al timbrar el XML"),
	PROXY_TIMBRANDO_RESPUESTA(9041,"No se obtuvo respuesta del timbrador"),
	PROXY_YATIMBRADO(9042,"El xml ya esta timbrado"),
	PROXY_XML_DATOINVALIDO(9043,"Error al convertir un campo del XML"),
	PROXY_CANCELANDO(9044,"Error al cancelar los uuids"),
	PROXY_CANCELANDO_RESPUESTA(9045,"No se obtuvo respuesta del cancelador"),
	PROXY_GENERANDO_PDF(9046,"Error generando PDF"),
	PROXY_ENVIANDO_CORREO(9047,"Error enviando correo"),
	PROXY_LEYENDO_XML(9048,"Error al leer el XML"),
	PROXY_LEYENDO_TXT(9049,"Error al leer el archivo de texto"),
	PROXY_GENERANDO_COMPROBANTE(9050,"Error al generar el comprobante"),
	PROXY_GENERANDO_CADENAORIGINAL(9051,"Error al generar la cadena original"),
	PROXY_GENERANDO_PFX(9052,"Error generando PFX de cancelación"),
	PROXY_DESENCRIPTANDO(9053,"Error al desencriptar información"),
	PROXY_GENERANDO_ZIP(9054,"Error al generar el ZIP"),
	PROXY_VALIDANDO(9055,"Error validando comprobante"),
	PROXY_VALIDANDO_RESPUESTA(9056,"No se obtuvo respuesta del validador"),
	PROXY_MASIVA_ENPROCESO(9057,"La consulta se esta ejecutando, espere a que termine el proceso"),
	PROXY_SERVICIONODISPONIBLE(9058,"Servicio no disponible"),
	PROXY_CONSULTANDOSAT(9059,"Consultando Sat"),
	SCOT_CONSUMIENDO(9160,"Error ejecutando transacción de consumo"),
	SCOT_EMITE_CONTRASENA(9161,"El token interno es inválido"),
	SCOT_EMITE_TIPO_TIMBRE(9162,"El tipo de timbre no se encuentra en el catálogo"),
	SCOT_EMITE_USUARIO_EMISOR(9163,"No se encontro ningún emisor con el usuario enviado al WS"),
	SCOT_EMITE_USUARIO_EMISOR_CONTRASENA(9164,"La contraseña del emisor es incorrecta"),
	SCOT_EMITE_USUARIO_TIPO(9165,"No se encontro el tipo de timbre asignado al emisor"),
	SCOT_EMITE_INTEGRADOR_DESHABILITADO(9166,"El integrador esta deshabilitado"),
	SCOT_EMITE_EMISOR_DESHABILITADO(9167,"El emisor esta deshabilitado"),
	SCOT_EMISOR_PREPAGO_AGOTADOS(9168,"Los timbres asignados al emisor de prepago estan agotados"),
	SCOT_INTEGRADOR_PREPAGO_AGOTADOS(9169,"El integrador no cuenta con timbres por asignar"),
	SCOT_EMITE_EMISOR_LIBERADO(9170,"El emisor aún no ha sido liberado por parte de Emite"),
	SCOT_EMITE_TIPO_INCORRECTO(9171,"El tipo de timbre es incorrecto"),
	SCOT_EMITE_EMISOR_SUCURSAL(9172,"El emisor requiere que se envie el nombre de sucursal"),
	SCOT_EMITE_EMISOR_SUCURSAL_NOEXISTE(9173,"El emisor no cuenta con la sucursal enviada"),
	SCOT_TOKEN_CONSUMO_GENERANDO(9174,"Error al generar el token de consumo"),
	SCOT_TOKEN_CONSUMO_INVALIDO(9175,"Token de Consumo inválido"),
	SCOT_TOKEN_TIMBRES_TAMANO(9176,"El numero de timbres del token difiere al número de timbres enviados"),
	SCOT_XML_EMISOR_INVALIDO(9177,"El rfc del emisor difiere de las credenciales proporcionadas"),
	SCOT_CONSUMIENDO_SINRESPUESTA(9178,"No se obtuvo respuesta del servicio de consumo"),
	SCOT_EMISORES_GUARDANDO(9179,"Error guardando emisor"),
	SCOT_EMISORES_REPETIDO(9180,"El rfc del emisor ya esta dado de alta"),
	SCOT_EMISORES_NOEXISTE(9181,"El rfc del emisor no esta dado de alta"),
	SCOT_EMISORES_NOPERMITESUCURSALES(9182,"El tipo de emisor no permite la inserción de sucursales"),
	SCOT_SUCURSALES_GUARDANDO(9183,"Error guardando sucursal"),
	SCOT_CSDS_GUARDANDO(9184,"Error al guardar el CSD"),
	SCOT_UUID_NOEXISTE(9185,"El uuid no existe"),
	SCOT_DESCARGANDO_XML(9186,"Error al descargar XML de scot"),
	SCOT_TIMBRANDO_CORTEMENSUAL(9187,"Error al timbrar corte mensual"),
	SCOT_FACTURAS_EMITE_TIMBRANDO(9188,"Error al timbrar factura Emite"),
	SCOT_EMISOR_CSDNOEXISTE(9189,"El emisor no cuenta con CSD cargado en SCOT"),
	SCOT_SELLANDO(9190,"Error al sellar con el CSD"),
	SCOT_GUARDANDO_FACTURA(9191,"Error al guardar la factura en la BD"),
	SCOT_EMITE_INTEGRADOR_NOEXISTE(9192,"El integrador no existe"),
	SCOT_EMITE_INTEGRADOR_CONTRASENA(9193,"La contraseña de integrador es incorrecta"),
	SCOT_RECEPTOR_NOENCONTRADO(9194,"El receptor no ha sido encontrado"),
	SCOT_BUSQUEDA_VACIA(9195,"La consulta no arrojó resultados"),
	PORTAL_AUTENTICACION(9501,"Error de autenticación (credenciales inválidas)"),
	PORTAL_GENERANDO_FACTURA(9502,"Error al generar la factura"),
	PORTAL_TIMBRANDO(9503,"Error al timbrar el comprobante"),
	PORTAL_NOIMPLEMENTADO(9504,"No implementado"),
	PORTAL_UUID_NOENCONTRADO(9505,"UUID no encontrado"),
	PORTAL_UUID_INCORRECTO(9506,"Error validando UUID"),
	PORTAL_GUARDANDO(9507,"Error al guardar en la BD"),
	PORTAL_RECEPCIONES_ARCHIVOS(9508,"No se encontrarón los archivos para recepción"),
	PORTAL_RECEPCIONES_PROCESANDO(9509,"Error procesando recepción"),
	NOM101(71010,"NOM101 - El atributo fecha no cumple con el patrón requerido","El atributo fecha, Debe cumplir con el patrón  (20[1-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9])"),
	NOM102(71020,"NOM102 - El atributo metodoDePago no tiene el valor NA","El atributo metodoDePago Debe tener el valor “NA”."),
	NOM103(71030,"NOM103 - El atributo noCertificado no cumple con el patron requerido","El atributo noCertificado, Debe cumplir con el patrón [0-9]{20}"),
	NOM104(71040,"NOM104 - El atributo Moneda, no cumple con el valor MXN","El atributo Moneda, Se debe registrar el valor MXN"),
	NOM105(71050,"NOM105 - El atributo TipoCambio no tiene el valor = 1","El atributo TipoCambio puede omitirse pero si se incluye deberá tener el valor 1."),
	NOM106(71060,"NOM106 - El valor del atributo subTotal no coincide con la suma de Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos.","El valor del atributo subTotal, debe registrar la suma de los atributos Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos"),
	NOM107(71070,"NOM107 - El valor de descuento no es igual a Nomina12:TotalDeducciones","El atributo descuento, debe registrar el valor del campo Nomina12:TotalDeducciones"),
	NOM108(71080,"NOM108 - El atributo total, no cumple con el patron requerido","El atributo total, Debe cumplir con el patrón [0-9]{1,18}(.[0-9]{1,2})?"),
	NOM109(71090,"NOM109 - El valor del atributo total no coincide con la suma Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos.menos Nomina12:TotalDeducciones","El atributo total, Debe ser igual a la suma de Nomina12:TotalPercepciones más Nomina12:TotalOtrosPagos menos Nomina12:TotalDeducciones"),
	NOM110(71100,"NOM110 - El atributo tipoDeComprobante no tiene el valor = “egreso”.","El atributo tipoDeComprobante El valor registrado debe ser “egreso”."),
	NOM111(71110,"NOM111 - El valor del atributo LugarExpedicion no cumple con un valor en c_CodigoPostal","El atributo LugarExpedicion, Debe cumplir con el patrón [0-9]{5} que indique el código postal del lugar de expedición del comprobante (domicilio de la matriz o de la sucursal) de acuerdo con el catálogo c_CodigoPostal que se publica en la página de internet del SAT"),
	NOM112CP(71120,"NOM112 - El atributo condicionesDePago no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOM112FF(71121,"NOM112 - El atributo FechaFolioFiscalOrig no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOM112MD(71122,"NOM112 - El atributo motivoDescuento no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOM112MF(71123,"NOM112 - El atributo MontoFolioFiscalOrig no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOM112NC(71124,"NOM112 - El atributo NumCtaPago no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOM112SF(71125,"NOM112 - El atributo SerieFolioFiscalOrig no debe existir","Los atributos motivoDescuento, NumCtaPago, condicionesDePago, SerieFolioFiscalOrig, FechaFolioFiscalOrig, MontoFolioFiscalOrig  no deben existir"),
	NOM113(71130,"NOM113 - El atributo Nomina12:Emisor:Curp. no aplica para persona moral","Si el atributo Comprobante.Emisor.rfc contiene una longitud de 12 posiciones (RFC de persona moral), entonces no debe existir el atributo Nomina12:Emisor:Curp."),
	NOM114(71140,"NOM114 - El atributo Nomina12:Emisor:Curp. Debe aplicar para persona fisica","Si el atributo Comprobante.Emisor.rfc contiene una longitud de 13 posiciones (RFC de persona física), entonces debe existir el atributo Nomina12:Emisor:Curp"),
	NOM115(71150,"NOM115 - El nodo Subcontratacion se debe registrar","Si el atributo Comprobante.Emisor.rfc se encuentra registrado en el listado de RFC inscritos en el SAT con marca de subcontratación se debe registrar el nodo Subcontratacion"),
	NOM116DF(71160,"NOM116 - El elemento DomicilioFiscal no debe existir","Los elementos cfdi:Comprobante.Emisor.DomicilioFiscal y ExpedidoEn No deben existir."),
	NOM116EE(71161,"NOM116 - El elemento ExpedidoEn no debe existir","Los elementos cfdi:Comprobante.Emisor.DomicilioFiscal y ExpedidoEn No deben existir."),
	NOM117(71170,"NOM117 - Solo debe existir un solo nodo RegimenFiscal","El nodo cfdi:Comprobante.Emisor.Emisor.RegimenFiscal Debe existir, solo un nodo."),
	NOM118(71180,"NOM118 - El valor del atributo Regimen no cumple con un valor del catálogo c_RegimenFiscal.","El atributo Regimen, Debe contener una clave del catálogo c_RegimenFiscal publicado en la página del SAT."),
	NOM119(71190,"NOM119 - El atributo Regimen no cumple con un valor de acuerdo al tipo de persona moral.","Si el atributo Comprobante.Emisor.rfc contiene una longitud de 12 posiciones (RFC de persona moral), entonces el atributo Regimen debe contener una clave de acuerdo al tipo de Persona moral."),
	NOM120(71200,"NOM120 - El atributo Regimen no cumple con un valor de acuerdo al tipo de persona física.","Si el atributo Comprobante.Emisor.rfc contiene una longitud de 13 posiciones (RFC de persona física), entonces el atributo Regimen debe contener una clave de acuerdo al tipo de Persona física."),
	NOM121(71210,"NOM121 - El atributo cfdi:Comprobante.Receptor.rfc debe ser persona física (13 caracteres).","El atributo cfdi:Comprobante.Receptor.rfc Debe ser de persona física."),
	NOM122(71220,"NOM122 - El atributo cfdi:Comprobante.Receptor.rfc no es válido según la lista de RFC inscritos no cancelados en el SAT (l_RFC).","El atributo cfdi:Comprobante.Receptor.rfc, El RFC debe estar en la lista de los RFC inscritos no cancelados en el SAT. (l_RFC)."),
	NOM123(71230,"NOM123 - El nodo Domicilio no debe existir","El nodo cfdi:Comprobante.Receptor.Domicilio, No debe existir"),
	NOM124(71240,"NOM124 - El nodo concepto solo debe existir uno, sin elementos hijo","El nodo cfdi:Comprobante.Conceptos.Concepto"),
	NOM125(71250,"NOM125 - El atributo cfdi:Comprobante.Conceptos.Concepto.noIdentificacion no debe existir","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.noIdentificacion, No debe registrarse"),
	NOM126(71260,"NOM126 - El atributo cfdi:Comprobante.Conceptos.Concepto.cantidad no tiene el valor =  “1”","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.cantidad, se debe registrar el valor “1”"),
	NOM127(71270,"NOM127 - El atributo cfdi:Comprobante.Conceptos.Concepto.unidad no tiene el valor =  “ACT”","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.unidad, debe registrar el valor “ACT”"),
	NOM128(71280,"NOM128 - El atributo cfdi:Comprobante.Conceptos.Concepto.descripcion,  no tiene el valor “Pago de nómina”","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.descripcion, debe registrar el valor “Pago de nómina”"),
	NOM129(71290,"NOM129 - El valor del atributo.cfdi:Comprobante.Conceptos.Concepto.valorUnitario no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.valorUnitario, Debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOM130(71300,"NOM130 - El valor del atributo.cfdi:Comprobante.Conceptos.Concepto.Importe no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.2 entonces en el atributo cfdi:Comprobante.Conceptos.Concepto.Importe, Debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOM131(71310,"NOM131 - El nodo cfdi:Comprobante.Impuestos no cumple la estructura","El nodo cfdi:Comprobante.Impuestos Se debe registrar como <Impuestos/> o <Impuestos></Impuestos>"),
	NOM132(71320,"NOM132 - El atributo Moneda no tiene el valor =  “MXN”","Si versión del CFDI = 3.3 entonces en el atributo Moneda debe registrar el valor MXN"),
	NOM133(71330,"NOM133 - El atributo FormaPago no tiene el valor =  99","Si versión del CFDI = 3.3 entonces en el atributo FormaPago, debe tener la clave 99 que corresponde a la descripción “Por definir”."),
	NOM134(71340,"NOM134 - El atributo TipoDeComprobante no tiene el valor =  “Nómina”","Si versión del CFDI = 3.3 entonces en el atributo TipoDeComprobante, El valor registrado debe ser la clave N que corresponde a  “Nómina”"),
	NOM135(71350,"NOM135 - El atributo Nomina12:Emisor:Curp, no aplica para persona moral","Si versión del CFDI = 3.3 y el atributo Comprobante.Emisor.rfc, tiene longitud 12 (RFC de persona moral), entonces  no debe existir el atributo Nomina12:Emisor:Curp,"),
	NOM136(71360,"NOM136 - El atributo Nomina12:Emisor:Curp, debe aplicar para persona fisica","Si versión del CFDI = 3.3 y el atributo Comprobante.Emisor.rfc tiene longitud 13, el atributo Nomina12:Emisor:Curp, debe existir"),
	NOM137(71370,"NOM137 - El atributo Comprobante.Receptor.rfc, debe ser de longitud 13","Si versión del CFDI = 3.3 y el atributo Comprobante.Receptor.rfc debe ser persona fisica"),
	NOM138(71380,"NOM138 - El atributo Comprobante.Receptor.rfc, no está en la lista de RFC inscritos no cancelados en el SAT (l_RFC).","Si versión del CFDI = 3.3 y el atributo Comprobante.Receptor.rfc debe estar en la lista de RFC inscritos no cancelados en el SAT (l_RFC)."),
	NOM139(71390,"NOM139 - El nodo Comprobante.Conceptos.Concepto, Solo puede registrarse un nodo concepto, sin elementos hijo.","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto, debe registrar solo un nodo concepto sin elementos hijo."),
	NOM140(71400,"NOM140 - El atributo Comprobante.Conceptos.Concepto,ClaveProdServ no tiene el valor =  “84111505”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,ClaveProdServ debe registrar el valor 84111505"),
	NOM141(71410,"NOM141 - El atributo Comprobante.Conceptos.Concepto,NoIdentificacion, no debe existir","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,NoIdentificacion, No debe registrarse"),
	NOM142(71420,"NOM142 - El atributo Comprobante.Conceptos.Concepto,Cantidad no tiene el valor =  “1”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Cantidad debe registrar el valor “1”"),
	NOM143(71430,"NOM143 - El atributo Comprobante.Conceptos.Concepto,ClaveUnidad no tiene el valor =  “ACT”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,ClaveUnidad debe registrar el valor “ACT”"),
	NOM144(71440,"NOM144 - El atributo Comprobante.Conceptos.Concepto,Unidad, no debe existir","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Unidad No debe registrarse"),
	NOM145(71450,"NOM145 - El atributo Comprobante.Conceptos.Concepto,Descripcion no tiene el valor =  “Pago de nómina”","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Descripcion debe registrar el valor “Pago de nómina”"),
	NOM146(71460,"NOM146 - El valor del atributo Comprobante.Conceptos.Concepto,ValorUnitario no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,ValorUnitario debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOM147(71470,"NOM147 - El valor del atributo Comprobante.Conceptos.Concepto,Importe no coincide con la suma TotalPercepciones más TotalOtrosPagos.","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Importe debe registrar la suma de los atributos TotalPercepciones más TotalOtrosPagos."),
	NOM148(71480,"NOM148 - El valor del atributo Comprobante.Conceptos.Concepto,Descuento no es igual a el valor del campo Nomina12:TotalDeducciones","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Conceptos.Concepto,Descuento debe registrar el valor del campo Nomina12:TotalDeducciones"),
	NOM149(71490,"NOM149 - El nodo Comprobante.Impuestos, no debe existir","Si versión del CFDI = 3.3 entonces en el nodo Comprobante.Impuestos. no se debe registrar "),
	NOM150(71500,"NOM150 - El nodo Nomina no se puede utilizar dentro del elemento ComplementoConcepto. ","El nodo Nomina se debe registrar como un nodo hijo del nodo Complemento en el CFDI."),
	NOM151(71510,"NOM151 - El nodo Nomina no tiene TotalPercepciones y/o TotalOtrosPagos","El nodo Nomina debe existir el atributo TotalPercepciones o TotalOtrosPagos, o ambos."),
	NOM152(71520,"NOM152 - El valor del atributo Nomina.TipoNomina no está en catálogo c_TipoNomina","El atributo Nomina.TipoNomina debe ser una clave del catálogo c_TipoNomina"),
	NOM153(71530,"NOM153 - El valor del atributo tipo de periodicidad no se encuentra entre 01 al 09","Si el atributo Nomina.TipoNomina es ordinaria el tipo de periodicidad de pago debe ser del 01 al 09"),
	NOM154(71540,"NOM154 - El valor del atributo tipo de periodicidad no es 99","Si el atributo Nomina.TipoNomina es extraordinaria el tipo de periodicidad de pago debe ser 99."),
	NOM155(71550,"NOM155 - El valor del atributo FechaInicialPago no es menor o igual al valor del atributo FechaFinalPago.","El atributo Nomina.FechaInicialPago  debe ser menor o igual al valor del atributo FechaFinalPago."),
	NOM156(71560,"NOM156 - El atributo Nomina.TotalPercepciones, no debe existir","Si el nodo percepciones no existe, el atributo Nomina.TotalPercepciones no debe existir."),
	NOM157(71570,"NOM157 - El valor del atributo Nomina.TotalPercepciones no coincide con la suma TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro del  nodo Percepciones.","Si el nodo percepciones existe, el valor de Nomina.TotalPercepciones debe ser igual a la suma de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro del  nodo Percepciones."),
	NOM158(71580,"NOM158 - El atributo Nomina.TotalDeducciones, no debe existir","Si el nodo Deducciones no existe, el valor de Nomina.TotalDeducciones , no debe existir."),
	NOM159(71590,"NOM159 - El valor del atributo Nomina.TotalDeducciones no coincide con la suma de los atributos TotalOtrasDeducciones más TotalImpuestosRetenidos del elemento Deducciones.","Si el nodo Deducciones existe, el valor de Nomina.TotalDeducciones debe ser igual a la suma de los atributos TotalOtrasDeducciones más TotalImpuestosRetenidos del elemento Deducciones."),
	NOM160(71600,"NOM160 - El valor del atributo Nomina.TotalOtrosPagos no coincide con la suma de los atributos Importe de los nodos nomina12:OtrosPagos:OtroPago","Si el nodo OtrosPagos existe, el valor de Nomina.TotalOtrosPagos debe ser igual a la suma de los atributos Importe de los nodos nomina12:OtrosPagos:OtroPago"),
	NOM161(71610,"NOM161 - El atributo Nomina.Emisor.RfcPatronOrigen no está inscrito en el SAT (l_RFC)","El atributo Nomina.Emisor.RfcPatronOrigen debe estar inscrito no cancelado en el SAT (l_RFC)"),
	NOM162(71620,"NOM162 - El atributo Nomina.Emisor.RegistroPatronal se debe registrar","Si atributo TipoContrato esstá entre  01 al 08, el atributo Nomina.Emisor.RegistroPatronal debe existir"),
	NOM163(71630,"NOM163 - El atributo Nomina.Emisor.RegistroPatronal no se debe registrar","Si atributo TipoContrato esstá entre  01 al 08, el atributo Nomina.Emisor.RegistroPatronal no debe existir"),
	NOM164(71640,"NOM164 - El(Los) atributo(s) xxxxxx debe(n) existir.","Si atributo Nomina.Emisor.RegistroPatronal existe, entonces deben existir los atributos nomina12:Receptor: NumSeguridadSocial,  nomina12:Receptor:FechaInicioRelLaboral, nomina12:Receptor:Antigüedad,  nomina12:Receptor:RiesgoPuesto y nomina12:Receptor:SalarioDiarioIntegrado."),
	NOM165(71650,"NOM165 - El nodo Nomina.Emisor.EntidadSNCF debe existir.","Si el RFC del emisor existe en el listado de RFC inscritos no cancelados en el SAT (l_RFC) con marca de unidad adherida al Sistema Nacional de Coordinación Fiscal, el nodo Nomina.Emisor.EntidadSNCF debe existir."),
	NOM166(71660,"NOM166 - El nodo Nomina.Emisor.EntidadSNCF no debe existir.","Si el RFC del emisor existe en el listado de RFC inscritos no cancelados en el SAT (l_RFC) sin marca de unidad adherida al Sistema Nacional de Coordinación Fiscal, el nodo Nomina.Emisor.EntidadSNCF no debe existir."),
	NOM167(71670,"NOM167 - El valor del atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso no cumple con un valor del catálogo c_OrigenRecurso.","El atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso debe ser una clave del catálogo c_OrigenRecurso publicado en el portal del SAT en internet."),
	NOM168(71680,"NOM168 - El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio debe existir.","El atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso Si el valor registrado corresponde a la clave IM (Ingresos Mixtos), el atributo MontoRecursoPropio debe existir."),
	NOM169(71690,"NOM169 - El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio no debe existir.","El atributo Nomina.Emisor.EntidadSNCF.OrigenRecurso Si el valor registrado es diferente a la clave IM (Ingresos Mixtos), el atributo MontoRecursoPropio no debe existir."),
	NOM170(71700,"NOM170 - El valor del atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio no es menor a la suma de los valores de los atributos TotalPercepciones y TotalOtrosPagos.","El atributo Nomina.Emisor.EntidadSNCF.MontoRecursoPropio debe ser menor que la suma de los valores de los atributos TotalPercepciones y TotalOtrosPagos."),
	NOM171(71710,"NOM171 - El valor del atributo Nomina.Receptor.TipoContrato no cumple con un valor del catálogo c_TipoContrato.","El atributo Nomina.Receptor.TipoContrato debe ser una clave del catálogo c_TipoContrato publicado en el portal del SAT en internet."),
	NOM172(71720,"NOM172 - El atributo Nomina.Receptor.TipoJornada debe ser una clave del catálogo de c_TipoJornada publicado en el portal del SAT en internet.","El valor del atributo Nomina.Receptor.TipoJornada no cumple con un valor del catálogo c_TipoJornada."),
	NOM173(71730,"NOM173 - El valor del atributo Nomina.Receptor.FechaInicioRelLaboral no es menor o igual al atributo a FechaFinalPago.","El atributo Nomina.Receptor.FechaInicioRelLaboral, debe ser menor o igual al atributo FechaFinalPago."),
	NOM174(71740,"NOM174 - El valor numerico del atributo Nomina.Receptor.Antigüedad no es menor o igual al cociente de (la suma del número de días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago más uno) dividido entre siete","Si el atributo Nomina.Receptor.Antigüedad cumple con el patrón P[1-9][0-9]{0,3}W, entonces el valor numérico del atributo Nomina.Receptor.Antigüedad, debe ser menor o igual al cociente de (la suma del número de días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago más uno) dividido entre siete"),
	NOM175(71750,"NOM175 - El valor del atributo Nomina.Receptor.Antigüedad. no cumple con el número de años, meses y días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago.","Si el atributo Nomina.Receptor.Antigüedad no cumple con el patrón P[1-9][0-9]{0,3}W, entonces el valor registrado debe corresponder con el número de años, meses y días transcurridos entre la FechaInicioRelLaboral y la FechaFinalPago."),
	NOM176(71760,"NOM176 - El valor del atributo Nomina.Receptor.TipoRegimen no cumple con un valor del catálogo c_TipoRegimen.","El atributo Nomina.Receptor.TipoRegimen debe ser una clave del catálogo de c_TipoRegimen publicado en el portal del SAT en internet."),
	NOM177(71770,"NOM177 - El atributo Nomina.Receptor.TipoRegimen no es 02, 03 ó 04.","Si el atributo TipoContrato tiene una clave entre los valores 01 y 08 del catálogo c_TipoContrato entonces el atributo Nomina.Receptor.TipoRegimen debe ser 02, 03 ó 04."),
	NOM178(71780,"NOM178 - El atributo Nomina.Receptor.TipoRegimen no está entre 05 a 09.","Si el atributo TipoContrato tiene un valor 09 ó superior entonces el atributo Nomina.Receptor.TipoRegimen debe ser 05 hasta el 99."),
	NOM179(71790,"NOM179 - El valor del atributo Nomina.Receptor.RiesgoPuesto no cumple con un valor del catálogo c_RiesgoPuesto.","El atributo RiesgoPuesto debe ser una clave del catálogo de c_RiesgoPuesto publicado en el portal del SAT en internet."),
	NOM180(71800,"NOM180 - El valor del atributo Nomina.Receptor.PeriodicidadPago no cumple con un valor del catálogo c_PeriodicidadPago.","El atributo PeriodicidadPago debe ser una clave del catálogo de c_PeriodicidadPago publicado en el portal del SAT en internet."),
	NOM181(71810,"NOM181 - El valor del atributo Nomina.Receptor.Banco no cumple con un valor del catálogo c_Banco.","El atributo Banco debe ser una clave del catálogo de c_Banco publicado en el portal del SAT en internet."),
	NOM182(71820,"NOM182 - El atributo CuentaBancaria no cumple con la longitud de 10, 11, 16 ó 18 posiciones.","El atributo CuentaBancaria debe tener una longitud de 10, 11, 16 ó 18 posiciones."),
	NOM183(71830,"NOM183 - El atributo Banco no debe existir.","Si se registra una cuenta CLABE (número con 18 posiciones), el atributo Banco no debe existir."),
	NOM184(71840,"NOM184 - El dígito de control del atributo CLABE no es correcto.","Se debe confirmar que el dígito de control es correcto."),
	NOM185(71850,"NOM185 - El atributo Banco debe existir.","Si se registra una cuenta de tarjeta de débito a 16 posiciones o una cuenta bancaria a 11 posiciones o un número de teléfono celular a 10 posiciones, debe existir el banco."),
	NOM186(71860,"NOM186 - El valor del atributo ClaveEntFed no cumple con un valor del catálogo c_Estado.","El valor del atributo ClaveEntFed debe ser una clave del catálogo de c_Estado, donde la clave de país es MEX."),
	NOM187(71870,"NOM187 - El valor del atributo Nomina.Receptor.SubContratacion.RfcLabora no está en la lista de RFC (l_RFC).","El valor del atributo Nomina.Receptor.SubContratacion.RfcLabora debe existir en la lista de RFC inscritos no cancelados en el SAT (l_RFC)."),
	NOM188(71880,"NOM188 - La suma de los valores registrados en el atributo Nomina.Receptor.SubContratacion.PorcentajeTiempo no es igual a 100.","El valor del atributo Nomina.Receptor.SubContratacion.PorcentajeTiempo La suma de los valores PorcentajeTiempo registrados debe ser igual a 100."),
	NOM189(71890,"NOM189 - La suma de los valores de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro no es igual a la suma de los valores de los atributos TotalGravado más TotalExento.","En el elemento Nomina.Percepciones , La suma de los valores de los atributos TotalSueldos más TotalSeparacionIndemnizacion más TotalJubilacionPensionRetiro debe ser igual a la suma de los valores de los atributos TotalGravado más TotalExento."),
	NOM190(71900,"NOM190 - El valor del atributo Nomina.Percepciones.TotalSueldos , no es igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave expresada en el atributo TipoPercepcion es distinta de 022 Prima por Antigüedad, 023 Pagos por separación, 025 Indemnizaciones, 039 Jubilaciones, pensiones o haberes de retiro en una exhibición y 044 Jubilaciones, pensiones o haberes de retiro en parcialidades.","El valor del atributo Nomina.Percepciones.TotalSueldos , debe ser igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave expresada en el atributo TipoPercepcion sea distinta de 022 Prima por Antigüedad, 023 Pagos por separación, 025 Indemnizaciones, 039 Jubilaciones, pensiones o haberes de retiro en una exhibición y 044 Jubilaciones, pensiones o haberes de retiro en parcialidades."),
	NOM191(71910,"NOM191 - El valor del atributo Nomina.Percepciones.TotalSeparacionIndemnizacion, no es igual a la suma de los atributos ImporteGravado e ImporteExento donde la clave en el atributo TipoPercepcion es igual a 022 Prima por Antigüedad, 023 Pagos por separación ó 025 Indemnizaciones.","La suma de los importes de los atributos ImporteGravado e ImporteExento no es mayor que cero."),
	NOM192(71920,"NOM192 - El valor del atributo Nomina.Percepciones.TotalJubilacionPensionRetiro, no es igual a la suma de los atributos ImporteGravado e importeExento donde la clave expresada en el atributo TipoPercepcion es igual a 039(Jubilaciones, pensiones o haberes de retiro en una exhibición)  ó 044 (Jubilaciones, pensiones o haberes de retiro en parcialidades).","El valor del atributo Nomina.Percepciones.TotalJubilacionPensionRetiro, debe ser igual a la suma de los atributos ImporteGravado e importeExento donde la clave expresada en el atributo TipoPercepcion sea igual a 039(Jubilaciones, pensiones o haberes de retiro en una exhibición)  ó 044 (Jubilaciones, pensiones o haberes de retiro en parcialidades)."),
	NOM193(71930,"NOM193 - El valor del atributo Nomina.Percepciones.TotalGravado, no es igual a la suma de los atributos ImporteGravado de los nodos Percepcion.","El valor del atributo Nomina.Percepciones.TotalGravado, debe ser igual a la suma de los atributos ImporteGravado de los nodos Percepcion."),
	NOM194(71940,"NOM194 - El valor del atributo Nomina.Percepciones.TotalExento, no es igual a la suma de los atributos ImporteExento de los nodos Percepcion.","El valor del atributo Nomina.Percepciones.TotalExento, debe ser igual a la suma de los atributos ImporteExento de los nodos Percepcion."),
	NOM195(71950,"NOM195 - La suma de los importes de los atributos ImporteGravado e ImporteExento no es mayor que cero.","El valor del atributo Nomina.Percepciones.Percepcion.ImporteGravado, La suma de los importes de los atributos ImporteGravado e ImporteExento debe ser mayor que cero."),
	NOM196(71960,"NOM196 - El valor del atributo Nomina.Percepciones.Percepcion.TipoPercepcion no cumple con un valor del catálogo c_TipoPercepcion.","El valor del atributo Nomina.Percepciones.Percepcion.TipoPercepcion, debe ser una clave del catálogo de c_TipoPercepcion publicado en el portal del SAT en internet."),
	NOM197NO(71970,"NOM197 - TotalSueldos, debe existir. Ya que la clave expresada en TipoPercepcion es distinta de 022, 023, 025, 039 y 044.","El atributo TipoPercepcion: si la clave expresada es distinta de 022, 023, 025, 039 y 044, debe existir el atributo TotalSueldos."),
	NOM197SI(71971,"NOM197 - TotalSueldos, debe existir. Ya que la clave expresada en TipoPercepcion es distinta de 022, 023, 025, 039 y 044.","El atributo TipoPercepcion: si la clave expresada es distinta de 022, 023, 025, 039 y 044, debe existir el atributo TotalSueldos."),
	NOM198(71980,"NOM198 - TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion, debe existir. Ya que la clave expresada en TipoPercepcion es 022 ó 023 ó 025.","Si la clave expresada en el atributo TipoPercepcion es 022 ó 023 ó 025, debe existir el atributo TotalSeparacionIndemnizacion y el elemento SeparacionIndemnizacion."),
	NOM199(71990,"NOM199 - TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro debe existir,  ya que la clave expresada en el atributo TipoPercepcion es 039 ó 044,","Si la clave expresada en el atributo TipoPercepcion es 039 ó 044, debe existir el atributo TotalJubilacionPensionRetiro y el elemento JubilacionPensionRetiro, en caso contrario no deben existir."),
	NOM200(72000,"NOM200 - TotalUnaExhibicion debe existir y no deben existir TotalParcialidad, MontoDiario. Ya que la clave expresada en el atributo TipoPercepcion es 039.","Si la clave expresada en el atributo TipoPercepcion es 039 debe existir TotalUnaExhibicion, no deben existir TotalParcialidad, MontoDiario."),
	NOM201(72010,"NOM201 - TotalUnaExhibicion no debe existir y deben existir TotalParcialidad, MontoDiario. Ya que la clave expresada en el atributo TipoPercepcion es 044.","Si la clave expresada en el atributo TipoPercepcion es 044 no debe existir TotalUnaExhibicion, deben existir TotalParcialidad, MontoDiario."),
	NOM202(72020,"NOM202 - El elemento AccionesOTitulos debe existir. Ya que la clave expresada en el atributo TipoPercepcion es 045.","Si la clave expresada en el atributo TipoPercepcion es 045, debe existir el elemento AccionesOTitulos, en caso contrario no debe existir.	"),
	NOM203(72030,"NOM203 - El elemento AccionesOTitulos no debe existir. Ya que la clave expresada en el atributo TipoPercepcion no es 045.","Si la clave expresada en el atributo TipoPercepcion no es 045, no debe existir el elemento AccionesOTitulos"),
	NOM204(72040,"NOM204 - El elemento HorasExtra, debe existir. Ya que la clave expresada en el atributo TipoPercepcion es 019.","Si la clave expresada en el atributo TipoPercepcion es 019, debe existir el elemento HorasExtra, en caso contrario no debe existir."),
	NOM205(72050,"NOM205 - El elemento HorasExtra, no debe existir. Ya que la clave expresada en el atributo TipoPercepcion no es 019.","Si la clave expresada en el atributo TipoPercepcion no es 019, no debe existir el elemento HorasExtra."),
	NOM206(72060,"NOM206 - El nodo Incapacidades debe existir, Ya que la clave expresada en el atributo TipoPercepcion es 014.","Si la clave expresada en el atributo TipoPercepcion es 014 el nodo Incapacidades debe existir."),
	NOM207(72070,"NOM207 - La suma de los campos ImporteMonetario no es igual a la suma de los valores ImporteGravado e ImporteExento de la percepción, Ya que la clave expresada en el atributo TipoPercepcion es 014.","Si la clave expresada en el atributo TipoPercepcion es 014 la suma de los campos ImporteMonetario debe ser igual a la suma de los valores ImporteGravado e ImporteExento de la percepción."),
	NOM208(72080,"NOM208 - El valor del atributo Nomina.Percepciones.Percepcon.HorasExtra.TipoHoras no cumple con un valor del catálogo c_TipoHoras.","El atributo Nomina.Percepciones.Percepcon.HorasExtra.TipoHoras debe ser una clave del catálogo de c_TipoHoras publicado en el portal del SAT en internet."),
	NOM209(72090,"NOM209 - Los atributos MontoDiario y TotalParcialidad no deben existir, ya que existe valor en TotalUnaExhibicion.","Si existe valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalUnaExhibicion los atributos MontoDiario y TotalParcialidad no deben existir."),
	NOM210(72100,"NOM210 - El atributo MontoDiario debe existir y el atributo TotalUnaExhibicion no debe existir, ya que Nomina.Percepciones.JubilacionPensionRetiro.TotalParcialidad tiene valor.","Si existe valor en el atributo Nomina.Percepciones.JubilacionPensionRetiro.TotalParcialidad el atributo MontoDiario debe existir y el atributo TotalUnaExhibicion no debe existir."),
	NOM211(72110,"NOM211 - El valor en el atributo Nomina.Deducciones.TotalImpuestosRetenidos no es igual a la suma de los atributos Importe de las deducciones que tienen expresada la clave 002 en el atributo TipoDeduccion.","El valor en el atributo Nomina.Deducciones.TotalImpuestosRetenidos debe ser igual a la suma de los atributos Importe de las deducciones que tengan expresada la clave 002 en el atributo TipoDeduccion."),
	NOM212(72120,"NOM212 - Nomina.Percepciones.JubilacionPensionRetiro.TotalImpuestosRetenidos no debe existir ya que no existen deducciones con clave 002 en el atributo TipoDeduccion.","Si no existen deducciones con clave 002, el valor en el atributo Nomina.Deducciones.TotalImpuestosRetenidos no debe existir."),
	NOM213(72130,"NOM213 - El valor del atributo Nomina.Deducciones.Deduccion.TipoDeduccion no cumple con un valor del catálogo c_TipoDeduccion.","El valor de Nomina.Deducciones.Deduccion.TipoDeduccion debe ser una clave del catálogo de c_TipoDeduccion publicado en el portal del SAT en internet."),
	NOM214(72140,"NOM214 - Debe existir el elemento Incapacidades, ya que la clave expresada en Nomina.Deducciones.Deduccion.TipoDeduccion es 006.","Si la clave expresada en Nomina.Deducciones.Deduccion.TipoDeduccion es 006, debe existir el elemento Incapacidades."),
	NOM215(72150,"NOM215 - El atributo Deduccion:Importe no es igual a la suma de los nodos Incapacidad:ImporteMonetario. Ya que la clave expresada en Nomina.Deducciones.Deduccion.TipoDeduccion es 006","Si la clave expresada en Nomina.Deducciones.Deduccion.TipoDeduccion es 006, el atributo Deduccion:Importe debe ser igual a la suma de los nodos Incapacidad:ImporteMonetario."),
	NOM216(72160,"NOM216 - Nomina.Deducciones.Deduccion.Importe no es mayor que cero.","Nomina.Deducciones.Deduccion.Importe Debe ser mayor que cero."),
	NOM217(72170,"NOM217 - El valor del atributo Nomina.OtrosPagos.OtroPago.TipoOtroPago no cumple con un valor del catálogo c_TipoOtroPago.","Nomina.OtrosPagos.OtroPago.TipoOtroPago debe ser una clave del catálogo de c_TipoOtroPago publicado en el portal del SAT en internet."),
	NOM218(72180,"NOM218 - El nodo CompensacionSaldosAFavor debe existir, ya que el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 004.","Si el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 004 es obligatorio el nodo CompensacionSaldosAFavor."),
	NOM219(72190,"NOM219 - El nodo SubsidioAlEmpleo. debe existir, ya que el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 002.","Si el valor de Nomina.OtrosPagos.OtroPago.TipoOtroPago es 002 es obligatorio el nodo SubsidioAlEmpleo."),
	NOM220(72200,"NOM220 - Nomina.OtrosPagos.OtroPago.Importe no es mayor que cero.","Nomina.OtrosPagos.OtroPago.Importe Debe ser mayor que cero."),
	NOM221(72210,"NOM221 - Nomina.OtrosPagos.OtroPago.SubsidioAlEmpleo.SubsidioCausado no es mayor o igual que el valor del atributo Importe del nodo OtroPago.","Nomina.OtrosPagos.OtroPago.SubsidioAlEmpleo.SubsidioCausado debe ser mayor o igual que el valor del atributo Importe del nodo OtroPago."),
	NOM222(72220,"NOM222 - Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.SaldoAFavor no es mayor o igual que el valor del atributo CompensacionSaldosAFavor:RemanenteSalFav.","Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.SaldoAFavor debe ser mayor o igual que el valor del atributo CompensacionSaldosAFavor:RemanenteSalFav."),
	NOM223(72230,"NOM223 - Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.Año  no es menor que el año en curso.","Nomina.OtrosPagos.OtroPago.CompensacionSaldosAFavor.Año debe ser menor que el año en curso."),
	NOM224(72240,"NOM224 - El valor del atributo Incapacidades.Incapacidad.TipoIncapacidad no cumple con un valor del catálogo c_TIpoIncapacidad.","Incapacidades.Incapacidad.TipoIncapacidad debe ser una clave del catálogo de c_TIpoIncapacidad publicado en el portal del SAT en internet."),
	NOM225(72250,"NOM225 - Error no clasificado.","Otro error no documentado."),
	
	CE001(80001,"CCE001 - El complemento aún no se encuentra liberado"),
	CE101(80101,"CCE101 - El atributo cfdi:Comprobante no tiene un valor valido","El atributo cfdi:Comprobante:version debe tener el valor 3.2. ó 3.3."),
	CE102(80102,"CCE102 - El atributo cfdi:Comprobante:fecha no cumple con el formato requerido.","El atributo cfdi:Comprobante:fecha debe cumplir con el patrón [0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]) y debe corresponder con la hora local donde se expide el comprobante."),
	CE103(80103,"CCE103 - El atributo cfdi:Comprobante:subtotal no coincide con la suma de los atributos importe de los nodos Concepto.","El atributo cfdi:Comprobante:subtotal debe ser igual a la suma de los atributos importe por cada nodo Concepto ubicado en el nodo cfdi:Comprobante:Conceptos."),
	CE104(80104,"CCE104 - El atributo cfdi:Comprobante:Moneda se debe registrar","El atributo cfdi:Comprobante:Moneda es requerido."),
	CE105(80105,"CCE105 - El atributo cfdi:Comprobante:Moneda no contiene un valor del catálogo catCFDI:c_Moneda. ","El atributo cfdi:Comprobante:Moneda, debe contener un valor del catálogo catCFDI:c_Moneda."),
	CE106(80106,"CCE106 - El atributo TipoCambio no tiene el valor \"1\" y la moneda indicada es MXN.","Si el atributo cfdi:Comprobante:Moneda es MXN, puede omitirse el atributo TipoCambio, pero si se incluye, debe tener el valor \"1\"."),
	CE107(80107,"CCE107 - El atributo cfdi:Comprobante:TipoCambio se debe registrar cuando el atributo cfdi:Comprobante:Moneda tiene un valor distinto de MXN y XXX. ","El atributo cfdi:Comprobante:TipoCambio es requerido cuando el atributo cfdi:Comprobante:Moneda tenga un valor distinto de MXN y XXX."),
	CE108(80108,"CCE108 - El atributo cfdi:Comprobante:TipoCambio no se debe registrar cuando el atributo cfdi:Comprobante:Moneda tiene el valor XXX.","El atributo cfdi:Comprobante:TipoCambio no se debe registrar cuando el atributo cfdi:Comprobante:Moneda tenga el valor XXX."),
	CE109(80109,"CCE109 - El atributo cfdi:Comprobante:TipoCambio no cumple con el patrón requerido.","El atributo cfdi:Comprobante:TipoCambio debe cumplir con el patrón [0-9]{1,14}(.([0-9]{1,6}))?."),
	CE110(80110,"CCE110 - El atributo cfdi:Comprobante:tipoDeComprobante no cumple con alguno de los valores permitidos.","El atributo cfdi:Comprobante:tipoDeComprobante debe cumplir con tener los valores \"ingreso\",  \"egreso\" o \"traslado\"."),
	CE111(80111,"CCE111 - El atributo MotivoTraslado debe registrarse cuando cfdi:Comprobante:tipoDeComprobante tiene el valor \"traslado\".","Si el atributo cfdi:Comprobante:tipoDeComprobante tiene el valor \"traslado\", se debe registrar el atributo MotivoTraslado."),
	CE112(80112,"CCE112 - El nodo Propietario se debe registrar cuando cfdi:Comprobante:tipoDeComprobante tiene el valor \"traslado\" y MotivoTraslado tiene la clave \"05\".","Si el atributo cfdi:Comprobante:tipoDeComprobante tiene el valor \"traslado\" y MotivoTraslado tiene la clave \"05\", se debe registrar el nodo Propietario."),
	CE113(80113,"CCE113 - El atributo MotivoTraslado no debe existir cuando cfdi:Comprobante:tipoDeComprobante es distinto de \"traslado\".","Si el atributo cfdi:Comprobante:tipoDeComprobante es distinto de \"traslado\", el atributo MotivoTraslado no debe existir. "),
	CE114(80114,"CCE114 - El nodo Propietario no debe existir cuando cfdi:Comprobante:tipoDeComprobante es distinto de \"traslado\" y MotivoTraslado tiene una clave distinta de \"05\".","El nodo Propietario no debe existir cuando cfdi:Comprobante:tipoDeComprobante es distinto de \"traslado\" y MotivoTraslado tiene una clave distinta de \"05\"."),
	CE115(80115,"CCE115 - El atributo cfdi:Comprobante:subtotal no coincide con la suma del cdi:Comprobante:subTotal, menos el cfdi:Comprobante:descuento, más cfdi:Comprobante:Impuestos:totalImpuestosTrasladados menos cfdi:Comprobante:Impuestos:totalImpuestosRetenidos. ","El atributo cfdi:Comprobante:total debe ser igual a la suma del cfdi:Comprobante:subTotal, menos el cfdi:Comprobante:descuento, más los impuestos trasladados (cfdi:Comprobante:Impuestos:totalImpuestosTrasladados), menos los impuestos retenidos (cfdi:Comprobante:Impuestos:totalImpuestosRetenidos)."),
	CE116(80116,"CCE116 - El atributo cfdi:Comprobante:LugarExpedicion no cumple con alguno de los valores permitidos.","El atributo cfdi:Comprobante:LugarExpedicion debe cumplir con el patrón [0-9]{5} y corresponder con una clave de código postal incluida en el catálogo catCFDI:c_CodigoPostal publicado en el portal del SAT en internet."),
	CE117(80117,"CCE117 - El atributo cfdi:Comprobante:Emisor:Nombre se debe registrar. ","El atributo cfdi:Comprobante:Emisor:Nombre se debe registrar."),
	CE118(80118,"CCE118 - El atributo cfdi:Comprobante:Emisor:DomicilioFiscal:pais debe tener el valor \"MEX\". ","El atributo pais del nodo cfdi:Comprobante:Emisor:DomicilioFiscal debe contener la clave \"MEX\" si el nodo es generado. "),
	CE119(80119,"CCE119 - El atributo cfdi:Comprobante:Emisor:ExpedidoEn:pais debe tener el valor \"MEX\". ","El atributo pais del nodo cfdi:Comprobante:Emisor:ExpedidoEn debe contener la clave \"MEX\" si el nodo es generado."),
	CE120(80120,"CCE120 - El atributo cfdi:Comprobante:Emisor:DomicilioFiscal:estado debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais tenga el valor \"MEX\". ","El atributo estado del nodo cfdi:Comprobante:Emisor:DomicilioFiscal debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais tiene el valor \"MEX\" si el nodo es generado. "),
	CE121(80121,"CCE121 - El atributo cfdi:Comprobante:Emisor:ExpedidoEn:estado debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais tenga el valor \"MEX\". ","El atributo estado del nodo cfdi:Comprobante:Emisor:ExpedidoEn debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais tiene el valor \"MEX\" si el nodo es generado. "),
	CE122(80122,"CCE122 - El atributo cfdi:Comprobante:Emisor:DomicilioFiscal:municipio debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. ","El atributo municipio del nodo cfdi:Comprobante:Emisor:DomicilioFiscal debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. "),
	CE123(80123,"CCE123 - El atributo cfdi:Comprobante:Emisor:ExpedidoEn:municipio debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. ","El atributo municipio del nodo cfdi:Comprobante:Emisor:ExpedidoEn debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. "),
	CE124(80124,"CCE124 - El atributo cfdi:Comprobante:Emisor:DomicilioFiscal:localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. ","El atributo localidad del nodo cfdi:Comprobante:Emisor:DomicilioFiscal debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. "),
	CE125(80125,"CCE125 - El atributo cfdi:Comprobante:Emisor:ExpedidoEn:localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. ","El atributo localidad del nodo cfdi:Comprobante:Emisor:ExpedidoEn debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el nodo es generado. "),
	CE126(80126,"CCE126 - El atributo cfdi:Comprobante:Emisor:DomicilioFiscal:colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal si el nodo es generado. ","El atributo colonia del nodo cfdi:Comprobante:Emisor:DomicilioFiscal debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal si el nodo es generado. "),
	CE127(80127,"CCE127 - El atributo cfdi:Comprobante:Emisor:ExpedidoEn:colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal si el nodo es generado. ","El atributo colonia del nodo cfdi:Comprobante:Emisor:ExpedidoEn debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal si el nodo es generado. "),
	CE128(80128,"CCE128 - El atributo cfdi:Comprobante:Emisor:DomicilioFiscal:codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad si el nodo es generado. ","El atributo de codigoPostal del nodo cfdi:Comprobante:Emisor:DomicilioFiscal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad si el nodo es generado. "),
	CE129(80129,"CCE129 - El atributo cfdi:Comprobante:Emisor:ExpedidoEn:codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad si el nodo es generado. ","El atributo de codigoPostal del nodo cfdi:Comprobante:Emisor:ExpedidoEn debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad si el nodo es generado. "),
	CE130(80130,"CCE130 - El nodo Comprobante.Emisor.RegimenFiscal debe tener solo un elemento hijo Regimen. ","El nodo Comprobante.Emisor.RegimenFiscal debe tener solo un elemento hijo Regimen."),
	CE131(80131,"CCE131 - El atributo cfdi:Comprobante:Emisor:RegistroFiscal:Regimen no cumple con alguno de los valores permitidos para el tipo de persona del emisor. ","El atributo cfdi:Comprobante:Emisor:RegistroFiscal:Regimen debe tener una clave del catálogo catCFDI:c_RegimenFiscal donde la columna Persona corresponda con el tipo de persona del emisor, es decir, persona física si el RFC del emisor tiene 13 posiciones y persona moral en otro caso."),
	CE132(80132,"CCE132 - El atributo cfdi:Comprobante:Receptor:rfc no tiene el valor \"XEXX010101000\" y el tipoDeComprobante tiene un valor distinto de \"traslado\" y MotivoTraslado un valor distinto de \"02\".","El atributo cfdi:Comprobante:Receptor:rfc debe tener el valor \"XEXX010101000\" cuando el tipoDeComprobante sea distinto de \"traslado\" y el atributo MotivoTraslado sea distinto de \"02\"."),
	CE133(80133,"CCE133 - El atributo cfdi:Comprobante:Receptor:rfc debe tener un RFC válido dentro de la lista de RFC's o el valor \"XEXX010101000\" cuando el tipoDeComprobante es \"traslado\" y MotivoTraslado es \"02\".","El atributo cfdi:Comprobante:Receptor:rfc puede tener el valor \"XEXX010101000\" o uno válido dentro de la lista de RFC's, cuando el tipoDeComprobante sea \"traslado\" y el atributo MotivoTraslado sea \"02\"."),
	CE134(80134,"CCE134 - El atributo cfdi:Comprobante:Receptor:nombre se debe registrar. ","El atributo cfdi:Comprobante:Receptor:nombre se debe registrar. "),
	CE135(80135,"CCE135 - El nodo cfdi:Comprobante:Receptor:Domicilio se debe registrar. ","El nodo cfdi:Comprobante:Receptor:Domicilio se debe registrar. "),
	CE136(80136,"CCE136 - El atributo cfdi:Comprobante:Receptor:Domicilio:estado debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais tenga el valor \"MEX\" si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\".","El atributo estado del nodo cfdi:Comprobante:Receptor:Domicilio debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais tenga el valor \"MEX\" si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\"."),
	CE137(80137,"CCE137 - El atributo cfdi:Comprobante:Receptor:Domicilio:municipio debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\".","El atributo municipio del nodo cfdi:Comprobante:Receptor:Domicilio debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\"."),
	CE138(80138,"CCE138 - El atributo cfdi:Comprobante:Receptor:Domicilio:localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\".","El atributo localidad del nodo cfdi:Comprobante:Receptor:Domicilio debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\"."),
	CE139(80139,"CCE139 - El atributo cfdi:Comprobante:Receptor:Domicilio:colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\".","El atributo colonia del nodo cfdi:Comprobante:Receptor:Domicilio debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\"."),
	CE140(80140,"CCE140 - El atributo cfdi:Comprobante:Receptor:Domicilio:codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\".","El atributo de codigoPostal del nodo cfdi:Comprobante:Receptor:Domicilio debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad si el atributo pais tiene el valor \"MEX\", el tipoDeComprobante es \"traslado\" y MotivoTraslado tiene el valor \"02\"."),
	CE141(80141,"CCE141 - El atributo cfdi:Comprobante:Receptor:Domicilio:pais debe ser distinto de \"MEX\" y existir en el catálogo catCFDI:c_Pais si tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\".","Si tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\", el atributo pais del nodo cfdi:Comprobante:Receptor:Domicilio debe ser distinto de \"MEX\" y debe existir en el catálogo catCFDI:c_Pais. "),
	CE142(80142,"CCE142 - El atributo cfdi:Comprobante:Receptor:Domicilio:pais debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais sea igual a la clave del pais registrada en el atributo pais del mismo nodo.","Si tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\" y el pais es distinto de \"MEX\", el atributo estado del nodo cfdi:Comprobante:Receptor:Domicilio debe contener una clave del catálogo catCFDI:c_Estado donde la columna c_Pais sea igual a la clave del pais registrada en el atributo pais del mismo nodo si es que dicha clave existe."),
	CE143(80143,"CCE143 - El atributo cfdi:Comprobante:Receptor:Domicilio:codigoPostal se debe registrar cuando tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\" y el pais es distinto de \"MEX\".","Si tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\" y el pais es distinto de \"MEX\", el atributo codigoPostal del nodo cfdi:Comprobante:Receptor:Domicilio debe existir."),
	CE144(80144,"CCE144 - El atributo cfdi:Comprobante:Receptor:Domicilio:codigoPostal debe cumplir con el patrón especificado en el catálogo catCFDI:c_Pais cuando tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\" y el pais es distinto de \"MEX\".","Si tipoDeComprobante es distinto de \"traslado\" o MotivoTraslado es distinto de \"02\" y el pais es distinto de \"MEX\", el atributo codigoPostal del nodo cfdi:Comprobante:Receptor:Domicilio debe existir y debe cumplir con el patrón especificado (en caso de que aplique). "),
	CE145(80145,"CCE145 - El atributo cfdi:Comprobante:TipoDeComprobante no cumple con alguno de los valores permitidos para este complemento.","El atributo cfdi:Comprobante:TipoDeComprobante puede tener los valores \"I\", \"E\" o \"T\". "),
	CE146(80146,"CCE146 - El atributo MotivoTraslado se debe registrar cuando el atributo cfdi:Comprobante:TipoDeComprobante tiene el valor \"T\".","El atributo MotivoTraslado se debe registrar si el valor del atributo  cfdi:Comprobante:TipoDeComprobante es \"T\"."),
	CE147(80147,"CCE147 - El nodo Propietario se debe registrar cuando el atributo cfdi:Comprobante:TipoDeComprobante tiene el valor \"T\" y MotivoTraslado tiene la clave \"05\".","El nodo Propietario se debe registrar si el valor de cfdi:Comprobante:TipoDeComprobante es \"T\" y MotivoTraslado tiene la clave \"05\"."),
	CE148(80148,"CCE148 - El nodo Propietario no se debe registrar cuando el atributo cfdi:Comprobante:TipoDeComprobante tiene un valor distinto de \"T\" y MotivoTraslado tiene una clave distinta de \"05\".","El nodo Propietario no se debe registrar si el valor de cfdi:Comprobante:TipoDeComprobante es distinto de \"T\" y MotivoTraslado tiene una clave distinta de \"05\"."),
	CE149(80149,"CCE149 - El atributo cfdi:Comprobante:Emisor:Nombre se debe registrar. ","El atributo cfdi:Comprobante:Emisor:Nombre se debe registrar. "),
	CE150(80150,"CCE150 - El atributo cfd:Comprobante:Receptor:Rfc no tiene el valor \"XEXX010101000\" y el TipoDeComprobante tiene un valor distinto de \"T\" y MotivoTraslado un valor distinto de \"02\".","El atributo cfd:Comprobante:Receptor:Rfc debe tener el valor \"XEXX010101000\" cuando el TipoDeComprobante sea distinto de \"T\" y el atributo MotivoTraslado sea distinto de \"02\"."),
	CE151(80151,"CCE151 - El atributo cfdi:Comprobante:Receptor:Rfc debe tener un RFC válido dentro de la lista de RFC's o el valor \"XEXX010101000\" cuando el TipoDeComprobante es \"T\" y MotivoTraslado es \"02\".","El atributo cfd:Comprobante:Receptor:Rfc puede tener el valor \"XEXX010101000\" o uno válido dentro de la lista de RFC's, cuando el TipoDeComprobante sea \"T\" y el atributo MotivoTraslado sea \"02\"."),
	CE152(80152,"CCE152 - El atributo cfdi:Comprobante:Receptor:Nombre se debe registrar. ","El atributo cfdi:Comprobante:Receptor:Nombre se debe registrar."),
	CE153(80153,"CCE153 - El nodo cce11:ComercioExterior no puede registrarse mas de una vez. ","El nodo cce11:ComercioExterior solo debe registrarse una vez."),
	CE154(80154,"CCE154 - El nodo cce11:ComercioExterior debe registrarse como un nodo hijo del nodo Complemento en el CFDI. ","El nodo cce11:ComercioExterior se debe registrar como un nodo hijo del nodo Complemento en el CFDI."),
	CE155(80155,"CCE155 - El nodo cce11:ComercioExterior solo puede coexistir con los complementos Timbre Fiscal Digital, otros derechos e impuestos, leyendas fiscales, recepción de pago, CFDI registro fiscal.","El nodo cce11:ComercioExterior solo puede coexistir con los complementos Timbre Fiscal Digital, otros derechos e impuestos, leyendas fiscales, recepción de pago, CFDI registro fiscal."),
	CE156(80156,"CCE156 - El atributo cfdi:FolioFiscalOrig se debe registrar si el valor de cce11:ComercioExterior:MotivoTraslado es \"01\".","Se debe registrar el UUID de la factura donde previamente se realizó la enajenación en el atributo cfdi:FolioFiscalOrig si el valor de cce11:ComercioExterior:MotivoTraslado es \"01\" y la versión del CFDI es 3.2."),
	CE157(80157,"CCE157 - El atributo cfdi:CfdiRelacionados:CfdiRelacionado:UUID se debe registrar si el valor de cce11:ComercioExterior:MotivoTraslado es \"01\" con el tipo de relación \"05\".","Se debe indicar el UUID del CfdiRelacionado de la factura donde previamente se realizó la enajenación indicando el tipo de relación \"05\" si el valor de cce11:ComercioExterior:MotivoTraslado es \"01\" y la versión del CFDI es 3.3."),
	CE158(80158,"CCE158 - El atributo XXXXX no debe existir si el valor de cce11:ComercioExterior:TipoOperacion es \"A\". ","Los atributos MotivoTraslado, ClaveDePedimento, CertificadoOrigen, NumCertificadoOrigen, NumExportadorConfiable, Incoterm, Subdivisión, TipoCambioUSD, TotalUSD y Mercancias no deben existir si el valor de cce11:ComercioExterior:TipoOperacion es \"A\". "),
	CE159(80159,"CCE159 - El atributo XXXX debe registrarse si la clave de cce11:ComercioExterior:TipoOperacion registrada es \"1\" ó \"2\".","Los atributos ClaveDePedimento, CertificadoOrigen, Incoterm, Subdivision, TipoCambioUSD, TotalUSD y Mercancias deben registrarse si la clave de cce11:ComercioExterior:TipoOperacion registrada es \"1\" ó \"2\"."),
	CE160(80160,"CCE160 - El atributo cce11:ComercioExterior:NumCertificadoOrigen no se debe registrar si el valor de cce11:ComercioExterior:CertificadoOrigen es \"0\".","El atributo NumCertificadoOrigen no debe registrarse si el valor de cce11:ComercioExterior:CertificadoOrigen es \"0\"."),
	CE161(80161,"CCE161 - El atributo cce11:ComercioExterior:NumExportadorConfiable no se debe registrar si la clave de país del receptor o del destinatario no corresponde a un país del catálogo catCFDI:c_Pais donde la columna Agrupación tenga el valor Unión Europea.","El atributo cce11:ComercioExterior:NumExportadorConfiable no debe registrarse si la clave de país del receptor o del destinatario no corresponde a un país del catálogo catCFDI:c_Pais donde la columna Agrupación tenga el valor Unión Europea."),
	CE162(80162,"CCE162 - El atributo cce11:ComercioExterior:TotalUSD no coincide con la suma de ValorDolares de las mercancías.","El atributo cce11:ComercioExterior:TotalUSD debe ser igual a la suma de los valores del atributo ValorDolares de las mercancías."),
	CE163(80163,"CCE163 - El atributo cce11:ComercioExterior:TotalUSD debe registrarse con dos decimales.","El atributo cce11:ComercioExterior:TotalUSD debe registrarse con dos decimales. "),
	CE164(80164,"CCE164 - El atributo cce11:ComercioExterior:Emisor:Curp no se debe registrar si el atributo Rfc del nodo cfdi:Comprobante:Emisor es de longitud 12.","El atributo cce11:ComercioExterior:Emisor:Curp no debe registrarse si el atributo Rfc del nodo cfdi:Comprobante:Emisor es de longitud 12."),
	CE165(80165,"CCE165 - El atributo cce11:ComercioExterior:Emisor:Curp se debe registrar si el atributo Rfc del nodo cfdi:Comprobante:Emisor es de longitud 13.","El atributo cce11:ComercioExterior:Emisor:Curp debe registrarse si el atributo Rfc del nodo cfdi:Comprobante:Emisor es de longitud 13"),
	CE166(80166,"CCE166 - El nodo cce11:ComercioExterior:Emisor:Domicilio no debe registrarse si la versión de CFDI es 3.2. ","El nodo cce11:ComercioExterior:Emisor:Domicilio no debe ser registrado si la versión de CFDI es 3.2. "),
	CE167(80167,"CCE167 - El nodo cce11:ComercioExterior:Emisor:Domicilio debe registrarse si la versión de CFDI es 3.3. ","El nodo cce11:ComercioExterior:Emisor:Domicilio debe ser registrado si la versión de CFDI es 3.3. "),
	CE168(80168,"CCE168 - El atributo cce11:ComercioExterior:Emisor:Domicilio:Pais debe tener la clave \"MEX\".","El atributo cce11:ComercioExterior:Emisor:Domicilio:Pais debe contener la clave \"MEX\" si la versión de CFDI es 3.3."),
	CE169(80169,"CCE169 - El atributo cce11:ComercioExterior:Emisor:Domicilio:Estado debe contener una clave del catálogo de catCFDI:c_Estado donde la columna c_Pais tiene el valor \"MEX\".","El atributo cce11:ComercioExterior:Emisor:Domicilio:Estado debe contener una clave del catálogo de catCFDI:c_Estado donde la columna c_Pais tiene el valor \"MEX\" si la versión de CFDI es 3.3. "),
	CE170(80170,"CCE170 - El atributo cce11:ComercioExterior:Emisor:Domicilio:Municipio debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado.","El atributo cce11:ComercioExterior:Emisor:Domicilio:Municipio debe contener una clave del catálogo de catCFDI:c_Municipio donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado si la versión de CFDI es 3.3."),
	CE171(80171,"CCE171 - El atributo cce11:ComercioExterior:Emisor:Domicilio:Localidad debe contener una clave del catálogo de catCFDI:c_Localidad donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado.","El atributo cce11:ComercioExterior:Emisor:Domicilio:Localidad debe contener una clave del catálogo de catCFDI:c_Localidad donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado solo si es registrado y la versión de CFDI es 3.3. "),
	CE172(80172,"CCE172 - El atributo cce11:ComercioExterior:Emisor:Domicilio:Colonia debe contener una clave del catálogo de catCFDI:c_Colonia donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo CodigoPostal.","El atributo cce11:ComercioExterior:Emisor:Domicilio:Colonia debe contener una clave del catálogo de catCFDI:c_Colonia donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo CodigoPostal solo si el atributo tiene una clave numérica de 4 posiciones y la versión de CFDI es 3.3. "),
	CE173(80173,"CCE173 - El atributo cce11:ComercioExterior:Emisor:Domicilio:CodigoPostal debe contener una clave del catálogo catCFDI:c_CodigoPostal donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo Municipio y si existe el atributo de Localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo Localidad.","El atributo cce11:ComercioExterior:Emisor:Domicilio:CodigoPostal debe contener una clave del catálogo catCFDI:c_CodigoPostal donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo Municipio y si existe el atributo de Localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo Localidad si la versión de CFDI es 3.3. "),
	CE174(80174,"CCE174 - El atributo cce11:ComercioExterior:Propietario:NumRegIdTrib no tiene un valor que exista en el registro del país indicado en el atributo cce1:Propietario:ResidenciaFiscal.","El atributo cce11:ComercioExterior:Propietario:NumRegIdTrib debe existir en el registro del país si la clave del país del atributo cce11:Propietario:ResidenciaFiscal tiene mecanismo de verificación en línea en el catálogo catCFDI:c_Pais. "),
	CE175(80175,"CCE175 - El atributo cce11:ComercioExterior:Propietario:NumRegIdTrib no cumple con el patrón publicado en la columna \"Formato de registro de identidad tributaria\" del país indicado en el atributo cce1:Propietario:ResidenciaFiscal.","El atributo cce11:ComercioExterior:Propietario:NumRegIdTrib debe cumplir con el patrón indicado en la columna \"Formato de registro de identidad tributaria\" si la clave del país del atributo cce11:Propietario:ResidenciaFiscal no tiene mecanismo de verificación en línea en el catálogo catCFDI:c_Pais. "),
	CE176(80176,"CCE176 - El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib no debe registrarse si la versión de CFDI es 3.3. ","El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib no debe existir si la versión de CFDI es 3.3. "),
	CE177(80177,"CCE177 - El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib debe registrarse si la versión de CFDI es 3.2. ","El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib debe existir si la versión de CFDI es 3.2. "),
	CE178(80178,"CCE178 - El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib no tiene un valor que exista en el registro del país indicado en el atributo cfdi:Comprobante:Receptor:Domicilio:pais.","El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib debe existir en el registro del país si la clave del país del atributo cfdi:Comprobante:Receptor:Domicilio:pais tiene mecanismo de verificación en línea en el catálogo catCFDI:c_Pais y la versión de CFDI es 3.2. "),
	CE179(80179,"CCE179 - El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib no cumple con el patrón publicado en la columna \"Formato de registro de identidad tributaria\" del país indicado en el atributo cfdi:Comprobante:Receptor:Domicilio:pais.","El atributo cce11:ComercioExterior:Receptor:NumRegIdTrib debe cumplir con el patrón indicado en la columna \"Formato de registro de identidad tributaria\" si la clave del país del atributo cfdi:Comprobante:Receptor:Domicilio:pais no tiene mecanismo de verificación en línea en el catálogo catCFDI:c_Pais. "),
	CE180(80180,"CCE180 - El nodo cce11:ComercioExterior:Receptor:Domicilio no debe registrarse si la versión de CFDI es 3.2. ","El nodo cce11:ComercioExterior:Receptor:Domicilio no debe ser registrado si la versión de CFDI es 3.2."),
	CE181(80181,"CCE181 - El nodo cce11:ComercioExterior:Receptor:Domicilio debe registrarse si la versión de CFDI es 3.3. ","El nodo cce11:ComercioExterior:Receptor:Domicilio debe ser registrado si la versión de CFDI es 3.3."),
	CE182(80182,"CCE182 - El atributo cce11:ComercioExterior:Receptor:Domicilio:Colonia debe tener un valor del catálogo de colonia donde la columna código postal sea igual a la clave registrada en el atributo CodigoPostal cuando la clave de país es \"MEX\", contiene una cadena numérica de cuatro posiciones y la versión de CFDI es 3.3.","El atributo cce11:ComercioExterior:Receptor:Domicilio:Colonia debe ser registrado con un valor del catálogo de colonia donde la columna código postal sea igual a la clave registrada en el atributo CodigoPostal solo si la clave de país es \"MEX\", contiene una cadena numérica de cuatro posiciones y la versión de CFDI es 3.3."),
	CE183(80183,"CCE183 - El atributo cce11:ComercioExterior:Receptor:Domicilio:Localidad debe tener un valor del catálogo de localidades (catCFDI:c_Localidad) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado cuando la clave de país es \"MEX\" y la versión de CFDI es 3.3. ","El atributo cce11:ComercioExterior:Receptor:Domicilio:Localidad debe contener una clave del catálogo de localidades (catCFDI:c_Localidad) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado solo si la clave de país es \"MEX\" y la versión de CFDI es 3.3. "),
	CE184(80184,"CCE184 - El atributo cce11:ComercioExterior:Receptor:Domicilio:Municipio debe tener un valor del catálogo de municipios (catCFDI:c_Municipio) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado cuando la clave de país es \"MEX\" y la versión de CFDI es 3.3. ","El atributo cce11:ComercioExterior:Receptor:Domicilio:Municipio debe contener una clave del catálogo de municipios (catCFDI:c_Municipio) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado solo si la clave de país es \"MEX\" y la versión de CFDI es 3.3. "),
	CE185(80185,"CCE185 - El atributo cce11:ComercioExterior:Receptor:Domicilio:Estado debe tener un valor del catálogo de estados catCFDI:c_Estado donde la columna c_Pais sea igual a la clave de país registrada en el atributo Pais y la versión de CFDI es 3.3.","El atributo cce11:ComercioExterior:Receptor:Domicilio:Estado debe contener una clave del catálogo de estados catCFDI:c_Estado donde la columna c_Pais sea igual a la clave de país registrada en el atributo Pais solo si existe la clave y la versión de CFDI es 3.3. "),
	CE186(80186,"CCE186 - El atributo cce11:ComercioExterior:Receptor:Domicilio:CodigoPostal debe cumplir con el patrón especificado para el país cuando es distinta de \"MEX\" y la versión de CFDI es 3.3. ","El atributo cce11:ComercioExterior:Receptor:Domicilio:CodigoPostal debe cumplir con el patrón especificado para el formato del código postal si la clave de país es distinta de \"MEX\", el país tiene definido un patrón y la versión de CFDI es 3.3. "),
	CE187(80187,"CCE187 - El atributo cce11:ComercioExterior:Receptor:Domicilio:CodigoPostal debe tener un valor del catálogo de códigos postales catCFDI:c_CodigoPostal donde la columna c_Estado sea igual a la clave registrada en el atributo Estado, la columna c_Municipio sea igual a la clave registrada en el atributo Municipio y la columna c_Localidad sea igual a la clave registrada en el atributo Localidad en caso de que se haya registrado cuando la clave de país es \"MEX\" y la versión de CFDI es 3.3. ","El atributo cce11:ComercioExterior:Receptor:Domicilio:CodigoPostal debe contener una clave del catálogo de códigos postales catCFDI:c_CodigoPostal donde la columna c_Estado sea igual a la clave registrada en el atributo Estado, la columna c_Municipio sea igual a la clave registrada en el atributo Municipio y la columna c_Localidad sea igual a la clave registrada en el atributo Localidad en caso de que se haya registrado, solo si la clave de país es \"MEX\" y la versión de CFDI es 3.3. "),
	CE188(80188,"CCE188 - El campo tipoDeComprobante tiene el valor \"traslado\" por lo tanto sólo podrás registrar un Destinatario.","Si tipoDeComprobante tiene el valor \"traslado\" y la versión de CFDI es 3.2 ó 3.3. sólo se puede registrar un Destinatario. "),
	CE189(80189,"CCE189 - El atributo cce11:ComercioExterior:Destinatario:NumRegIdTrib no tiene un valor que exista en el registro del país indicado en el atributo cce11:ComercioExterior:Destinatario:Domicilio:Pais.","El atributo cce11:ComercioExterior:Destinatario:NumRegIdTrib debe existir en el registro del país si la clave del país del atributo cce11:ComercioExterior:Destinatario:Domicilio:Pais tiene mecanismo de verificación en línea en el catálogo catCFDI:c_Pais. "),
	CE190(80190,"CCE190 - El atributo cce11:ComercioExterior:Destinatario:NumRegIdTrib no cumple con el patrón publicado en la columna \"Formato de registro de identidad tributaria\" del país indicado en el atributo cce11:ComercioExterior:Destinatario:Domicilio:Pais.","El atributo cce11:ComercioExterior:Destinatario:NumRegIdTrib debe cumplir con el patrón indicado en la columna \"Formato de registro de identidad tributaria\" si la clave del país del atributo cce11:ComercioExterior:Destinatario:Domicilio:Pais no tiene mecanismo de verificación en línea en el catálogo catCFDI:c_Pais. "),
	CE191(80191,"CCE191 - El atributo cce11:ComercioExterior:Destinatario:Domicilio:Colonia debe tener un valor del catálogo de colonias donde la columna código postal sea igual a la clave registrada en el atributo CodigoPostal cuando la clave de país es \"MEX\" y contiene una cadena numérica de cuatro posiciones.","El atributo cce11:ComercioExterior:Destinatario:Domicilio:Colonia debe contener una clave del catálogo de colonias donde la columna código postal sea igual a la clave registrada en el atributo CodigoPostal solo si la clave de país es \"MEX\" y contiene una cadena numérica de cuatro posiciones."),
	CE192(80192,"CCE192 - El atributo cce11:ComercioExterior:Destinatario:Domicilio:Localidad debe tener un valor del catálogo de localidades (catCFDI:c_Localidad) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado cuando la clave de país es \"MEX\". ","El atributo cce11:ComercioExterior:Destinatario:Domicilio:Localidad debe contener una clave del catálogo de localidades (catCFDI:c_Localidad) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado solo si la clave de país es \"MEX\". "),
	CE193(80193,"CCE193 - El atributo cce11:ComercioExterior:Destinatario:Domicilio:Municipio debe tener un valor del catálogo de municipios (catCFDI:c_Municipio) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado cuando la clave de país es \"MEX\".","El atributo cce11:ComercioExterior:Destinatario:Domicilio:Municipio debe contener una clave del catálogo de municipios (catCFDI:c_Municipio) donde la columna c_Estado sea igual a la clave registrada en el atributo Estado solo si la clave de país es \"MEX\"."),
	CE194(80194,"CCE194 - El atributo cce11:ComercioExterior:Destinatario:Domicilio:Estado debe tener un valor del catálogo de estados catCFDI:c_Estado donde la columna c_Pais sea igual a la clave de país registrada en el atributo Pais cuando la clave de país existe en la columna c_Pais del catálogo catCFDI:c_Estado y es diferente de \"ZZZ\".","El atributo cce11:ComercioExterior:Destinatario:Domicilio:Estado debe contener una clave del catálogo de estados catCFDI:c_Estado donde la columna c_Pais sea igual a la clave de país registrada en el atributo Pais solo si la clave de país existe en la columna c_Pais del catálogo catCFDI:c_Estado y es diferente de \"ZZZ\"."),
	CE195(80195,"CCE195 - El atributo cce11:ComercioExterior:Destinatario:Domicilio:CodigoPostal debe cumplir con el patrón especificado para el país cuando es distinta de \"MEX\". ","El atributo cce11:ComercioExterior:Destinatario:Domicilio:CodigoPostal debe cumplir con el patrón especificado para el formato del código postal si la clave de país es distinta de \"MEX\" y el país tiene definido un patrón."),
	CE196(80196,"CCE196 - El atributo cce11:ComercioExterior:Destinatario:Domicilio:CodigoPostal debe tener un valor del catálogo de códigos postales catCFDI:c_CodigoPostal donde la columna c_Estado sea igual a la clave registrada en el atributo Estado, la columna c_Municipio sea igual a la clave registrada en el atributo Municipio y la columna c_Localidad sea igual a la clave registrada en el atributo Localidad en caso de que se haya registrado cuando la clave de país es \"MEX\".","El atributo cce11:ComercioExterior:Destinatario:Domicilio:CodigoPostal debe contener una clave del catálogo de códigos postales catCFDI:c_CodigoPostal donde la columna c_Estado sea igual a la clave registrada en el atributo Estado, la columna c_Municipio sea igual a la clave registrada en el atributo Municipio y la columna c_Localidad sea igual a la clave registrada en el atributo Localidad en caso de que se haya registrado, solo si la clave de país es \"MEX\". "),
	CE197(80197,"CCE197 - El atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion se debe registrar en cada concepto. ","El atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion debe estar registrado por cada concepto registrado en el elemento cfdi:Comprobante:Conceptos."),
	CE198(80198,"CCE198 - Debe existir al menos un cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion relacionado con cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion.","El atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion debe ser igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion para al menos uno de los elementos registrados en cfdi:Comprobante:Conceptos relacionado en el nodo mercancías. "),
	CE199(80199,"CCE199 - Debe existir al menos un concepto en el nodo cfdi:Comprobante:Conceptos por cada mercancía registrada en el elemento cce1:ComercioExterior:Mercancias donde el atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion.","El nodo cfdi:Comprobante:Conceptos debe tener al menos un concepto registrado por cada mercancía registrada en el nodo cce11:ComercioExterior:Mercancias donde el atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion."),
	CE200(80200,"CCE200 - No se deben repetir elementos Mercancia donde el NoIdentificacion y la FraccionArancelaria sean iguales en el elemento cce11:ComercioExterior:Mercancias.","En el elemento cce11:ComercioExterior:Mercancias no se deben repetir elementos Mercancia donde el NoIdentificacion y la FraccionArancelaria sean iguales."),
	CE201(80201,"CCE201 - El atributo cfdi:Comprobante:Conceptos:Concepto:Cantidad no cumple con alguno de los valores permitidos cuando no se registra el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana.","El atributo cfdi:Comprobante:Conceptos:Concepto:Cantidad debe tener como valor mínimo incluyente \"0.001\" y debe cumplir con el patrón [0-9]{1,14}(.([0-9]{1,3}))? solo si el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana no está registrado."),
	CE202(80202,"CCE202 - El atributo cfdi:Comprobante:Conceptos:Concepto:Unidad no cumple con alguno de los valores permitidos cuando no se registra el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana.","El atributo cfdi:Comprobante:Conceptos:Concepto:Unidad debe tener un valor del catálogo catCFDI:c_UnidadAduana solo si el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana no está registrado."),
	CE203(80203,"CCE203 - El atributo cfdi:Comprobante:Conceptos:Concepto:ValorUnitario no cumple con alguno de los valores permitidos cuando no se registra el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana.","El atributo cfdi:Comprobante:Conceptos:Concepto:ValorUnitario debe tener como valor mínimo incluyente \"0.0001\", debe cumplir con el patrón [0-9]{1,16}(.([0-9]{1,4}))? y debe estar registrado con  la cantidad de decimales que soporte la moneda en la que se expresan las cantidades del comprobante solo si el atributo  cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana no está registrado."),
	CE204(80204,"CCE204 - El atributo cfdi:Comprobante:Conceptos:Concepto:importe debe ser mayor o igual que el límite inferior y menor o igual que el límite superior calculado.","El valor del atributo cfdi:Comprobante:Conceptos:Concepto:importe de cada concepto debe ser mayor o igual que el límite inferior y menor o igual que el límite superior calculado para cada uno. "),
	CE205(80205,"CCE205 - La suma de los campos cce11:ComercioExterior:Mercancias:Mercancia:ValorDolares distintos de \"0\" y \"1\" de todas las mercancías que tengan el mismo NoIdentificacion y éste sea igual al NoIdentificacion del concepto debe ser mayor o igual al valor mínimo y menor o igual al valor máximo calculado.","La suma de los campos cce11:ComercioExterior:Mercancias:Mercancia:ValorDolares distintos de \"0\" y \"1\" de todas las mercancías que tengan el mismo NoIdentificacion y éste sea igual al NoIdentificacion del concepto debe ser mayor o igual al valor mínimo y menor o igual al valor máximo calculado."),
	CE206(80206,"CCE206 - El atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria debe registrarse cuando el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:Unidad tienen un valor distinto de \"99\".","El atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria debe ser registrado solo si el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:Unidad tienen un valor distinto de \"99\"."),
	CE207(80207,"CCE207 - El atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria no debe registrarse cuando el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:Unidad tienen el valor \"99\".","El atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria no debe ser registrado si el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:Unidad tienen el valor \"99\"."),
	CE208(80208,"CCE208 - El atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria debe tener un valor vigente del catálogo catCFDI:c_FraccionArancelaria.","El atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria debe tener un valor vigente del catálogo catCFDI:c_FraccionArancelaria, es decir, la fecha del CFDI debe estar entre la fecha de inicio y fin de vigencia en el catálogo. "),
	CE209(80209,"CCE209 - El atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana debe tener el valor especificado en el catálogo catCFDI:c_FraccionArancelaria columna \"UMT\" cuando el atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria está registrado.","El atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana si existe, debe tener el valor especificado en el catálogo catCFDI:c_FraccionArancelaria columna \"UMT\" solo si el atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria está registrado y la clave registrada coincide con la columna c_FraccionArancelaria."),
	CE210(80210,"CCE210 - El atributo cfdi:Comprobante:Conceptos:Concepto:Unidad del concepto relacionado a la mercncía debe tener el valor especificado en el catálogo catCFDI:c_FraccionArancelaria columna \"UMT\" cuando el atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria está registrado.","Si el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana no existe, el atributo Unidad del concepto relacionado (donde NoIdentificacion es igual al de la Mercancia) debe tener el valor especificado en el catálogo catCFDI:c_FraccionArancelaria columna \"UMT\" solo si el atributo cce11:ComercioExterior:Mercancias:Mercancia:FraccionArancelaria está registrado y la clave registrada coincide con la columna c_FraccionArancelaria."),
	CE211(80211,"CCE211 - El atributo cfdi:Comprobante:descuento debe ser mayor o igual que la suma de los atributos cce11:ComercioExterior:Mercancias:Mercancia:ValorDolares de todas las mercancías que tengan la fracción arancelaria \"98010001\" convertida a la moneda del comprobante si la versión del CFDI es 3.2. ","El atributo cfdi:Comprobante:descuento debe ser mayor o igual que la suma de los atributos cce11:ComercioExterior:Mercancias:Mercancia:ValorDolares de todas las mercancías que tengan la fracción arancelaria \"98010001\" convertida a la moneda del comprobante si la versión del CFDI es 3.2. "),
	CE212(80212,"CCE212 - La suma de los valores de cfdi:Comprobante:Conceptos:Concepto:Descuento donde el NoIdentificacion es el mismo que el de la mercancía convertida a la moneda del comprobante debe ser mayor o igual que la suma de los valores de cce11:ComercioExterior:Mercancias:Mercancia:ValorDolares de todas las mercancías que tengan la fracción arancelaria \"98010001\" y el NoIdentificacion sea igual al NoIdentificacion del concepto si la versión del CFDI es 3.3. ","La suma de los valores del atributo cfdi:Comprobante:Conceptos:Concepto:Descuento donde el NoIdentificacion es el mismo que el de la mercancía convertida a la moneda del comprobante debe ser mayor o igual que la suma de los valores del atributo cce11:ComercioExterior:Mercancias:Mercancia:ValorDolares de todas las mercancías que tengan la fracción arancelaria \"98010001\" y el NoIdentificacion sea igual al NoIdentificacion del concepto si la versión del CFDI es 3.3. "),
	CE213(80213,"CCE213 - Los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana deben existir en los registros involucrados si se ha registrado alguno de ellos, si existe más de un concepto con el mismo NoIdentificacion o si existe más de una mercancía con el mismo NoIdentificacion.","Los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana deben existir en los registros involucrados si se registra alguno de estos atributos, si existe más de un registro concepto con el mismo NoIdentificacion o si existe más de un registro mercancía con el mismo NoIdentificacion."),
	CE214(80214,"CCE214 - Los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana deben registrarse en todos los elementos mercancía del comprobante, siempre que uno de ellos los tenga registrados.","Los atributos CantidadAduana, UnidadAduana y ValorUnitarioAduana deben ser registrados en todos los elementos mercancía del comprobante si al menos uno de ellos los tiene registrados. "),
	CE215(80215,"CCE215 - El atributo cce11:ComercioExterior:Mercancias:Mercancia:ValorUnitarioAduana debe ser mayor que \"0\" cuando  cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana es distinto de \"99\".","El atributo cce11:ComercioExterior:Mercancias:Mercancia:ValorUnitarioAduana debe ser mayor que \"0\" si el valor del atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana es distinto de \"99\"."),
	CE216(80216,"CCE216 - El atributo cce11:ComercioExterior:Mercancias:ValorDolares de cada mercancía registrada debe ser mayor o igual que el límite inferior y menor o igual que el límtie superior o uno, cuando la normatividad lo permita y exista el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana.","El atributo cce11:ComercioExterior:Mercancias:ValorDolares de cada mercancía registrada debe ser mayor o igual que el límite inferior y menor o igual que el límtie superior o uno, cuando la normatividad lo permita, siempre que exista el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana. "),
	CE217(80217,"CCE217 - El atributo cce11:ComercioExterior:Mercancias:ValorDolares de cada mercancía registrada debe ser igual al producto del valor del atributo cfdi:Comprobante:Conceptos:Concepto:Importe por el valor del atributo cfdi:Comprobante:TipoCambio y dividido entre el valor del atributo cce11:ComercioExterior:TipoDeCambioUSD donde el atributo cfdi:Comprobante:Conceptos:NoIdentificacion es igual al atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion, \"0\" cuando el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:Unidad tienen el valor \"99\", o \"1\", cuando la normatividad lo permita y no debe existir el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana. ","El atributo cce11:ComercioExterior:Mercancias:ValorDolares de cada mercancía registrada debe ser igual al producto del valor del atributo cfdi:Comprobante:Conceptos:Concepto:Importe por el valor del atributo cfdi:Comprobante:TipoCambio y dividido entre el valor del atributo cce11:ComercioExterior:TipoDeCambioUSD registrando la cantidad con centésimas (usar la regla del atributo NoIdentificacion para obtener los valores mínimo y máximo, el valor debe estar en este rango), donde el atributo cfdi:Comprobante:Conceptos:NoIdentificacion es igual al atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion y el NoIdentificacion no se repita en conceptos ni en mercancias, cero, cuando el atributo cce11:ComercioExterior:Mercancias:Mercancia:UnidadAduana o el atributo cfdi:Comprobante:Conceptos:Concepto:Unidad tienen el valor \"99\", o uno, cuando la normatividad lo permita, siempre que no exista el atributo cce11:ComercioExterior:Mercancias:Mercancia:CantidadAduana. "),
	CE218(80218,"CCE218 - Error no clasificado","Otro error en el documento"),
	
	/*CE101(80101,"CCE101 - El atributo cfdi:Comprobante:version no tiene un valor valido","El atributo cfdi:Comprobante:version debe tener el valor 3.2. ó 3.3."),
	CE102(80102,"CCE102 - El atributo cfdi:Comprobante:fecha no cumple con el formato requerido.","cfdi:Comprobante:fecha Debe cumplir con el patrón [0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0- 9]|3[01])T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]) y debe corresponder con la hora de la Zona Centro del Sistema de Horario en México."),
	CE103(80103,"CCE103 - El atributo cfdi:Comprobante:subtotal no coincide con la suma de los atributos importe de los nodos Concepto.","cfdi:Comprobante:subtotal Debe ser igual a la suma de los atributos importe por cada nodo Concepto ubicado en el nodo cfdi:Comprobante:Conceptos"),
	CE104(80104,"CCE104 - El atributo cfdi:Comprobante:Moneda se debe registrar","El atributo cfdi:Comprobante:Moneda es requerido."),
	CE105(80105,"CCE105 - El atributo cfdi:Comprobante:Moneda no contiene un valor del catálogo catCFDI:c_Moneda. ","cfdi:Comprobante:Moneda debe contener un valor del catálogo catCFDI:c_Moneda."),
	CE106(80106,"CCE106 - El atributo TipoCambio no tiene el valor \"1\" y la moneda indicada es MXN.","Si el atributo cfdi:Comprobante:Moneda es MXN, puede omitirse el atributo TipoCambio, pero si se incluye, debe tener el valor \"1\"."),
	CE107(80107,"CCE107 - El atributo cfdi:Comprobante:TipoCambio se debe registrar cuando el atributo cfdi:Comprobante:Moneda tiene un valor distinto de MXN y XXX.","El atributo cfdi:Comprobante:TipoCambio es requerido cuando el atributo cfdi:Comprobante:Moneda tenga un valor distinto de MXN y XXX."),

	CE108(80108,"CCE108 - El atributo cfdi:Comprobante:TipoCambio no se debe registrar cuando el atributo cfdi:Comprobante:Moneda tenga el valor XXX."),
	CE109(80109,"CCE109 - cfdi:Comprobante:TipoCambio Debe cumplir con el patrón [0-9]{1,14}(.([0-9]{1,6}))?"),
	CE110(80110,"CCE110 - cfdi:Comprobante:tipoDeComprobante El atributo cfdi:Comprobante:tipoDeComprobante debe cumplir con tener los valores \"ingreso\",  \"egreso\" o \"traslado\"."),
	CE111(80111,"CCE111 - Si el atributo cfdi:Comprobante:tipoDeComprobante tiene el valor \"traslado\", se debe registrar el atributo MotivoTraslado."),
	CE112(80112,"CCE112 - Si el atributo cfdi:Comprobante:tipoDeComprobante tiene el valor \"traslado\" y MotivoTraslado tiene la clave \"05\", se debe registrar el nodo Propietario."),
	CE113(80113,"CCE113 - Si el atributo cfdi:Comprobante:tipoDeComprobante es distinto de \"traslado\", el atributo MotivoTraslado no debe existir."),
	CE114(80114,"CCE114 - El nodo Propietario no debe existir cuando cfdi:Comprobante:tipoDeComprobante es distinto de \"traslado\" y MotivoTraslado tiene una clave distinta de \"05\"."),
	CE115(80115,"CCE115 - cfdi:Comprobante:total Debe ser igual a la suma del cfdi:Comprobante:subTotal, menos el cfdi:Comprobante:descuento, más los impuestos trasladados (cfdi:Comprobante:Impuestos:totalImpuestosTrasladados), menos los impuestos retenidos (cfdi:Comprobante:Impuestos:totalImpuestosRetenidos)."),
	CE116(80116,"CCE116 - cfdi:Comprobante:LugarExpedicion El atributo cfdi:Comprobante:LugarExpedicion no cumple con alguno de los valores permitidos."),
	CE117(80117,"CCE117 - cfdi:Comprobante:Emisor:nombre Es obligatorio registrar el nombre."),
	CE118(80118,"CCE118 - cfdi:Comprobante:Emisor:DomicilioFiscal:pais debe contener la clave \"MEX\"."),
	CE119(80119,"CCE119 - cfdi:Comprobante:Emisor:ExpedidoEn:pais debe contener la clave \"MEX\"."),
	CE120(80120,"CCE120 - cfdi:Comprobante:Emisor:DomicilioFiscal:estado debe contener una clave del catálogo catCFDI:c_Estado, donde la columna c_Pais tiene el valor \"MEX\"."),
	CE121(80121,"CCE121 - cfdi:Comprobante:Emisor:ExpedidoEn:estado debe contener una clave del catálogo catCFDI:c_Estado, donde la columna c_Pais tiene el valor \"MEX\"."),
	CE122(80122,"CCE122 - cfdi:Comprobante:Emisor:DomicilioFiscal:municipio El atributo municipio debe contener una clave del catálogo de catCFDI:c_Municipio, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado."),
	CE123(80123,"CCE123 - cfdi:Comprobante:Emisor:ExpedidoEn:municipio El atributo municipio debe contener una clave del catálogo de catCFDI:c_Municipio, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado."),
	CE124(80124,"CCE124 - cfdi:Comprobante:Emisor:DomicilioFiscal:localidad Si se registra el atributo de localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado."),
	CE125(80125,"CCE125 - cfdi:Comprobante:Emisor:ExpedidoEn:localidad Si se registra el atributo de localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado."),
	CE126(80126,"CCE126 - cfdi:Comprobante:Emisor:DomicilioFiscal:colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal"),
	CE127(80127,"CCE127 - cfdi:Comprobante:Emisor:ExpedidoEn:colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal"),
	CE128(80128,"CCE128 - cfdi:Comprobante:Emisor:DomicilioFiscal:codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad"),
	CE129(80129,"CCE129 - cfdi:Comprobante:Emisor:ExpedidoEn:codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad"),
	CE130(80130,"CCE130 - cfdi:Comprobante:Emisor:RegimenFiscal Debe tener solo un elemento hijo Regimen."),
	CE131(80131,"CCE131 - El atributo cfdi:Comprobante:Emisor:RegistroFiscal:Regimen debe tener una clave del catálogo catCFDI:c_RegimenFiscal donde la columna Persona corresponda con el tipo de persona del emisor, es decir, persona física si el RFC del emisor tiene 13 posiciones y persona moral en otro caso.")
	/*
	 * CE112(80112,"CCE11")
	
	
	
	
	
	
	CCE132(80132,"CCE132 - cfdi:Comprobante:Emisor:RegimenFiscal Debe tener una clave del catálogo catCFDI:c_RegimenFiscal"),
	CCE133(80133,"CCE133 - cfdi:Comprobante:Emisor:RegimenFiscal Debe tener una clave del catálogo catCFDI:c_RegimenFiscal donde la columna Persona corresponda con el tipo de persona del emisor, es decir, persona física si el RFC del emisor tiene 13 posiciones y persona moral en otro caso."),
	CCE134(80134,"CCE134 - cfdi:Comprobante:Receptor:rfc Si el atributo cfdi:tipoDeComprobante tiene el valor \"traslado\" y el atributo cce11:MotivoTraslado tiene el valor \"02\", entonces este atributo puede tener un RFC registrado en la lista de RFC inscritos no cancelados del SAT l_RFC o el valor \"XEXX010101000\", en otro caso, debe tener el valor \"XEXX010101000\""),
	CCE135(80135,"CCE135 - cfdi:Comprobante:Receptor:nombre Es obligatorio registrar el nombre"),
	CCE136(80136,"CCE136 - cfdi:Comprobante:Receptor:Domicilio Es obligatorio registrar el domicilio del Receptor"),

	CCE137(80137,"CCE137 - cfdi:Comprobante:Receptor:Domicilio:estado debe contener una clave del catálogo catCFDI:c_Estado, donde la columna c_Pais tiene el valor \"MEX\"."),
	CCE138(80138,"CCE138 - cfdi:Comprobante:Receptor:Domicilio:municipio El atributo municipio debe contener una clave del catálogo de catCFDI:c_Municipio, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado."),
	CCE139(80139,"CCE139 - cfdi:Comprobante:Receptor:Domicilio:localidad Si se registra el atributo de localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado."),
	CCE140(80140,"CCE140 - cfdi:Comprobante:Receptor:Domicilio:colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo codigoPostal"),
	CCE141(80141,"CCE141 - cfdi:Comprobante:Receptor:Domicilio:codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo municipio, y si existe el atributo de localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo localidad"),
	CCE142(80142,"CCE142 - cfdi:Comprobante:Receptor:Domicilio:pais no debe contener la clave \"MEX\"."), 
	CCE143(80143,"CCE143 - cfdi:Comprobante:Receptor:Domicilio:pais La clave en el atributo pais debe existir en el catálogo catCFDI:c_Pais."),
	CCE144(80144,"CCE144 - cfdi:Comprobante:Receptor:Domicilio:estado debe contener una clave del catálogo catCFDI:c_Estado, donde la columna clave de país sea igual a la clave de país registrada en el atributo pais."),
	CCE145(80145,"CCE145 - cfdi:Comprobante:Receptor:Domicilio:estado debe registrarse"),
	CCE146(80146,"CCE146 - cfdi:Comprobante:Receptor:Domicilio:codigoPostal debe de cumplir con el patrón de Código Postal de acuerdo al pais"),
	CCE147(80147,"CCE147 - cfdi:Comprobante:Receptor:Domicilio:codigoPostal debe registrarse"),
	CCE148(80148,"CCE148 - cce11:ComercioExterior solo debe de existir un nodo de ComercioExterior"),
	CCE149(80149,"CCE149 - cce11:ComercioExterior:TipoOperacion Si la clave registrada es \"A\", no deben existir los siguientes atributos: MotivoTraslado, ClaveDePedimento, CertificadoOrigen, NumCertificadoOrigen, NumExportadorConfiable, Incoterm, Subdivisión, TipoCambioUSD, TotalUSD y Mercancias."),
	CCE150(80150,"CCE150 - cce11:ComercioExterior:TipoOperacion Si la clave registrada es \"1\" ó \"2\", deben existir los siguientes atributos: ClaveDePedimento, CertificadoOrigen, Incoterm, Subdivision, TipoCambioUSD, TotalUSD y Mercancias."),
	CCE151(80151,"CCE151 - cce11:ComercioExterior:CertificadoOrigen Si el valor es cero no debe registrarse el atributo NumCertificadoOrigen."),
	CCE152(80152,"CCE152 - cce11:ComercioExterior:NumExportadorConfiable Si la clave de país del receptor o del destinatario no corresponde a un país del catálogo catCFDI:c_Pais donde la columna Agrupación tenga el valor Unión Europea, este atributo no debe existir."),
	CCE153(80153,"CCE153 - cce11:ComercioExterior:TipoCambioUSD Que el valor corresponda con el número de pesos mexicanos que equivalen a un dólar de Estados Unidos, de acuerdo al artículo 20 del Código Fiscal de la Federación."),
	CCE154(80154,"CCE154 - cce11:ComercioExterior:TotalUSD Se calcula con la suma de los valores del atributo ValorDolares de las mercancías. El valor se debe registrar con dos decimales."),
	CCE155(80155,"CCE155 - cce11:ComercioExterior:Emisor:Curp Si el atributo Rfc del nodo cfdi:Comprobante:Emisor es de longitud 12, entonces este campo no debe existir"),
	CCE156(80156,"CCE156 - cce11:ComercioExterior:Emisor:Curp Si el atributo Rfc del nodo cfdi:Comprobante:Emisor es de longitud 13, entonces este campo debe existir"),
	CCE157(80157,"CCE157 - cce11:ComercioExterior:Emisor:Domicilio Si el atributo cfdi:version es 3.2, no debe existir este nodo"),
	CCE158(80158,"CCE158 - cce11:ComercioExterior:Emisor:Domicilio Si el atributo cfdi:version es 3.3, debe existir este nodo"),
	
	CCE159(80159,"CCE159 - cce11:ComercioExterior:Emisor:Domicilio:Pais En el atributo Pais, debe contener la clave \"MEX\"."),
	CCE160(80160,"CCE160 - cce11:ComercioExterior:Emisor:Domicilio:Estado El atributo de Estado debe contener una clave del catálogo de catCFDI:c_Estado, donde la columna c_Pais tiene el valor \"MEX\"."),
	CCE161(80161,"CCE161 - cce11:ComercioExterior:Emisor:Domicilio:Municipio El atributo de Municipio debe contener una clave del catálogo de catCFDI:c_Municipio, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado."),
	CCE162(80162,"CCE162 - cce11:ComercioExterior:Emisor:Domicilio:Localidad Si se registra el atributo de Localidad debe contener una clave del catálogo de catCFDI:c_Localidad, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado."),
	CCE163(80163,"CCE163 - cce11:ComercioExterior:Emisor:Domicilio:Colonia El atributo colonia debe contener una clave del catálogo de catCFDI:c_Colonia, donde la columna c_CodigoPostal debe ser igual a la clave registrada en el atributo CodigoPostal. Si el atributo no tiene una clave numérica de cuatro posiciones, no se valida el contenido."),
	CCE164(80164,"CCE164 - cce11:ComercioExterior:Emisor:Domicilio:CodigoPostal El atributo de codigoPostal debe contener una clave del catálogo de catCFDI:c_CodigoPostal, donde la columna clave de c_Estado debe ser igual a la clave registrada en el atributo Estado, la columna clave de c_Municipio debe ser igual a la clave registrada en el atributo Municipio, y si existe el atributo de Localidad, la columna clave de c_Localidad debe ser igual a la clave registrada en el atributo Localidad."),
	
	CCE165(80165,"CCE165 - cce11:ComercioExterior:Propietario:NumRegIdTrib debe cumplir con el patrón que se publique en la columna \"Formato de registro de identidad tributaria\""),
	CCE166(80166,"CCE166 - cce11:ComercioExterior:Propietario:NumRegIdTrib no se encuentra en la lRFC"),
	CCE167(80167,"CCE167 - cce11:ComercioExterior:Receptor:NumRegIdTrib Si el comprobante es versión 3.3 el atributo cce11:ComercioExterior:Receptor:NumRegIdTrib no debe existir"),
	CCE168(80168,"CCE168 - cce11:ComercioExterior:Receptor:NumRegIdTrib Si el comprobante es versión 3.2 el atributo cce11:ComercioExterior:Receptor:NumRegIdTrib debe existir"),
	CCE169(80169,"CCE169 - cce11:ComercioExterior:Receptor:NumRegIdTrib debe cumplir con el patrón que se publique en la columna \"Formato de registro de identidad tributaria\""),
	CCE170(80170,"CCE170 - cce11:ComercioExterior:Receptor:NumRegIdTrib no se encuentra en la lRFC"),
	
	CCE171(80171,"CCE171 - cce11:ComercioExterior:Receptor:Domicilio Si el atributo cfdi:version es 3.2, no debe existir este nodo"),
	CCE172(80172,"CCE172 - cce11:ComercioExterior:Receptor:Domicilio Si el atributo cfdi:version es 3.3, debe existir este nodo"),
	
	CCE180(80180,"CCE180 - cce11:ComercioExterior:Destinatario Si el atributo cfdi:version es 3.2, no debe existir este nodo"),
	CCE181(80181,"CCE181 - cce11:ComercioExterior:Destinatario Si el atributo cfdi:version es 3.3, debe existir este nodo"),
	
	CCE190(80190,"CCE190 - cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion Cada concepto registrado en el elemento cfdi:Comprobante:Conceptos, debe tener registrado el atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion y el NoIdentificacion se puede repetir."),
	CCE191(80191,"CCE191 - cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion Al menos uno de los elementos registrados en cfdi:Comprobante:Conceptos, debe tener un registro relacionado en el nodo mercancías, donde el atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion."),
	CCE192(80192,"CCE192 - cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion Por cada Mercancía registrada en el elemento cce11:ComercioExterior:Mercancias, debe existir al menos un Concepto registrado en cfdi:Comprobante:Conceptos donde el atributo cce11:ComercioExterior:Mercancias:Mercancia:NoIdentificacion sea igual al atributo cfdi:Comprobante:Conceptos:Concepto:NoIdentificacion."),
	CCE193(80193,"CCE193 - cce11:ComercioExterior:Mercancias:Mercancia no se debe repetir elementos Mercancia donde el NoIdentificacion y la FraccionArancelaria sean iguales."),
	CCE194(80194,"CCE194 - cfdi:Comprobante:Conceptos:Concepto:Cantidad debe tener como valor mínimo incluyente \"0.001\" y debe cumplir con el patrón [0-9]{1,14}(.([0-9]{1,3}))?"),
	CCE195(80195,"CCE195 - cfdi:Comprobante:Conceptos:Concepto:Unidad El atributo cfdi:Comprobante:Conceptos:Concepto:Unidad debe tener un valor del catálogo catCFDI:c_UnidadAduana"),
	CCE196(80196,"CCE196 - cfdi:Comprobante:Conceptos:Concepto:ValorUnitario El atributo cfdi:Comprobante:Conceptos:Concepto:ValorUnitario debe tener como valor mínimo incluyente \"0.0001\", debe cumplir con el patrón [0-9]{1,16}(.([0-9]{1,4}))? y debe estar registrado con la cantidad de decimales que soporte la moneda en la que se expresan las cantidades del comprobante."),
	CCE197(80197,"CCE197 - cfdi:Comprobante:Conceptos:Concepto:importe El valor de este atributo debe ser mayor o igual que el límite inferior y menor o igual que el límite superior."),
	*/
	;
	
	
	/*
	 * SERVICIO_NODISPONIBLE(1,"Servicio no disponible"),
	PROCESANDO_RESPUESTA(2,"Procesando respuesta"),
	DESERIALIZANDO(3,"Deserializando objeto"),
	SERIALIZANDO(4,"Serializando objeto"),
	DECODIFICANDO(5,"Decodificando cadena en Base64"),
	CODIFICANDO(6,"Codificando cadena a Base64"),
	LEYENDO_ARCHIVO(7,"Error al leer el archivo"),
	GUARDANDOARCHIVO(8,"Guardando archivo"),
	
	EF_CANCELA_EXITOSAMENTE(201,"UUID Cancelado exitosamente"),
	EF_CANCELA_PREVIAMENTE_CANCELADO(202,"UUID Previamente cancelado"),
	EF_CANCELA_UUIDNOCORRESPONDE(203,"UUID No corresponde el RFC del emisor y de quien solicita la cancelación."),
	EF_CANCELA_NOEXISTE(205,"UUID No existe"),
	EF_CANCELA_USUARIOINVALIDO(300,"El usuario con el que se quiere conectar es inválido"),
	EF_CANCELA_XMLMALFORMADO(301,"XML mal formado"),
	
	
	EF_SELLO_INVALIDO(302,"El sello es inválido"),
	EF_CSD_NOCORRESPONDERFC(303,"El CSD del emisor no corresponde al RFC que viene como emisor en el comprobante."),
	EF_CSD_REVOCADO(304,"El CSD del emisor ha sido revocado o no se encuentra en la lista de contribuyentes. "),
	EF_FECHA_VIGENCIA_CSD(305,"La fecha de emisión no esta dentro de la vigencia del CSD del emisor."),
	EF_CERTIFICADO_ESFIEL(306,"El certificado corresponde a una FIEL. Debe utilizar un CSD."),
	EF_TIMBREPREVIO(307,"El CFDI contiene un timbre previo "),
	EF_CERTIFICADO_NO_FIRMADO(308,"El CFDI contiene un certificado no firmado por una entidad autorizada (SAT)"),
	EF_CERTIFICADO_INVALIDO(310,"El CFDI contiene un certificado inválido"),
	EF_FECHA_72HORAS(401,"El rango de la fecha de generación no puede ser mayor a 72 horas"),
	EF_EMISOR_REGIMEN(402,"El RFC del emisor no tiene régimen autorizado"),
	EF_FECHA2011(403,"La fecha de emisión no es posterior al 01 de enero 2011"),
	EF_AUTENTICACION(501,"Autenticación no válida."),
	EF_NOENCONTRADO(502,"Comprobante no encontrado."),
	EF_METADATOS(503,"Los metadatos recibidos no son válidos."),
	EF_ESTRUCTURA(504,"La estructura del comprobante recibido no es válida."),
	EF_METADATOS_EMISOR(505,"Los metadatos proporcionados no corresponden al emisor."),
	EF_PREVIAMENTE_TIMBRADO(506,"Comprobante timbrado anteriormente"),
	EF_PREVIAMENTE_CANCELADO(507,"Comprobante previamente cancelado"),
	EF_INFORMACION_INVALIDA(601,"La información para buscar el comprobante no es válida."),
	EF_CFDI_NOEXISTE(602,"Comprobante que se desea descargar no existe."),
	 */
	
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
	
	public static void main(String[] args){
		try{
			System.out.println("Error:");
			final Map<Integer,List<I_Api_Errores>> mapa = new HashMap<>();
			final List<I_Api_Errores> todos = new ArrayList<>();
			for(I_Api_Errores e:values()){
				if(!mapa.containsKey(e.getId()))
					mapa.put(e.getId(), new ArrayList<>());
				mapa.get(e.getId()).add(e);
				todos.add(e); 
			}
			List<Entry<Integer, List<I_Api_Errores>>> duplicados = mapa.entrySet().stream().filter(i->i.getValue().size()>1).collect(Collectors.toList());
			duplicados.stream().forEach(e->{
				System.out.print(e.getKey());
				System.out.println("\t"+Arrays.toString(e.getValue().toArray()));
			});
			
			//todos.sort((a,b)->a.name().compareTo(b.name()));
			todos.sort((a,b)->a.id.compareTo(b.id));
			todos.stream().forEach(e->{
				if(e.getMensaje()==null)
					System.out.println(e.name()+"("+e.getId()+",\""+e.getDescripcion()+"\"),");
				else
					System.out.println(e.name()+"("+e.getId()+",\""+e.getDescripcion()+"\",\""+e.getMensaje()+"\"),");
			});
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
}