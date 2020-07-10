package co.agro.chain.WebSocketRfidTag.dto;

import java.io.Serializable;

public class InboundMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3452767705727943478L;
	private String idUsuario;
	private String etiquetaRfid;
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEtiquetaRfid() {
		return etiquetaRfid;
	}
	public void setEtiquetaRfid(String etiquetaRfid) {
		this.etiquetaRfid = etiquetaRfid;
	}

}
